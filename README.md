#The "Environment Checker" Library
This Android Library as created to help encapsulating comon tasks of getting some devices Configurations!

##Basic Idea
As we know, for a proper app Development, usualy we should check for somedevice configurations to ensure a proper behavior, but in some cases the code to check for that check are long, I think it is boring to copy and pasting or typing all that code in Every Single app I need, so I decided to create a Library that encapsulates all the common (or not at all) tasks to save a bit of work.
  That was the basic ideia behind this Library, so I created it and decided to share it here in Github so if someone likes the ideia, think it is useful or wants to use it to feel free. If someone wants to contribute to Iwould totaly appreciate it!


##Objectives
* Ensure proper encapsulation of the tasks by putting them altogether in a class and each of them going inside a method;
* Provide a very simple api through which some basic (but some thimes boring) taks can be done quickly
* Help to accelerate the app development process [ well, not too much ;) ]


##Simple Example (of the motivations)
For instance, if I wanted to check if the Device has wifi and Mobile Broadband Networks (2G,3G) Enabled, I would do:

```

ConnectivityManager manager = (ConnectivityManager) 
							c.getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI); 
		   
boolean wifiOn =  networkInfo.isConnected();

networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

boolean mobileNetworkOn = networkInfo.isConnected();

```
Now I only have to:

```
EnvironmentChecker checker = new EnvironmentChecker(context);
boolean wifiOn = checker.isWifiEnabled(context);
boolean mobileNetworkOn = checker

```
