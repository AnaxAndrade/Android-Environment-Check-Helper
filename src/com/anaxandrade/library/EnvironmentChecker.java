package com.anaxandrade.library;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

public class EnvironmentChecker {
	
	Context context;
	
	public EnvironmentChecker(Context c){
		this.context = c;
	}
	
	/**
	 * This method should be used to check if the Device Supports
	 * or not Bluetooth (if it has bluetooth hardware availiable)
	 * 
	 * @author AnaxAndrade
	 * @return @true if the device Supports bluetooth or @false if it doesn't 
	 * 
	 */
	public boolean supportsBluetooth(){
		BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter != null) {
		   return true;
		}
		 return false;
	}
	
	/**
	 * Method to Check if Bluetooth is Enabled or Disabled in the Device
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if Bluetooth is currently Enabled in the Device
	 * or false is Bluetooth is Disabled
	 */
	public boolean isBluetoothEnabled(Context c){
		
		if (supportsBluetooth()){
			BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
			return mBluetoothAdapter.isEnabled();
		}
		
		return false;
	}
	
	/**
	 * Method to Check if Wifi is Enabled or Disabled in the Device
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if Wifi is currently Enabled in the Device
	 * or false is Wifi is Disabled
	 */
	public boolean isWifiEnabled(Context c){
		ConnectivityManager manager = (ConnectivityManager) 
							c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
		   
		return networkInfo.isConnected();
		    
		    
	}
	
	/**
	 * Use this to check if Mobile Network (2G, 3G or 4G) is Enabled and ready
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if one of the Mobile Networks is currently 
	 * Enabled in the Device or false is Mobile Networks are  Disabled
	 */
	public boolean isMobileNetworkEnabled(Context c){
		ConnectivityManager manager = (ConnectivityManager) 
				c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		
		return networkInfo.isConnected();
	   
	}
	
	/**
	 * To check if the device is Either connected to Wifi or
	 * Mobile Networks (2G, 3G or 4G)
	 * 
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if At Least Wifi or one of the 
	 * the mobile Networks are enabled, or false if
	 * none of them is enabled
	 */
	public boolean isNetworkConnected(Context c){
		return isMobileNetworkEnabled(c) || isWifiEnabled(c);
	}
	
	/**
	 * Use this Method to Check if the External Storage is available for
	 * writing Purposes
	 * 
	 * @note if it is writeable, it is also Readable
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if  Call this Method to Check if the External Storage 
	 * is currently ready for writing,
	 * or false is Bluetooth is Disabled
	 */
	public boolean isExternalStorageWriteable(Context c){

		String storState = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(storState)) {
	        return true;
	    }
	    return false;
	}
	
	/**
	 * Call this Method to Check if the External Storage is ready to read
	 * can be either read-only or read and write (in both cases it is actually 
	 * ready to read)
	 * 
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if The External Storage is ready to read
	 * or false if not available for reading
	 */
	public boolean isExternalStorageReadable(Context c){
		String storState = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(storState) ||
	    	Environment.MEDIA_MOUNTED_READ_ONLY.equals(storState)) {
	    	
	        return true;
	    }
	    return false;
	}
	
	/**
	 * Use this Method to Check if the External Storage is Empty or Not
	 * @author AnaxAndrade
	 * 
	 * @param c - the context of the app
	 * @return true if the external Storage is either empty or 
	 * uses a unknown filesystem, else it return false
	 */
	public boolean isExternalStorageEmpty(Context c){
		String storState = Environment.getExternalStorageState();
	    if (Environment.MEDIA_NOFS.equals(storState)) {

	    	return true;
	    }
	    return false;
	}
	
	
}
