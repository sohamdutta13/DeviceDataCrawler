# DeviceDataCrawler
Provides easy access to device informations. These include installed app data, device details, 
location details, app data usage details etc

Add the below lines to the app gradle.

repositories {
    jcenter()
    maven {
        url 'https://dl.bintray.com/sohamdutta13/maven'
    }
}

dependencies {
    compile 'com.datacrawler:datacrawler:1.0.0'
}

Below are the codes used to access the data from the devices.


AppsUtils phoneAppUtils = new AppsUtils();
phoneAppUtils.getPackages(this);

PhoneContactsUtils phoneContactsUtils = new PhoneContactsUtils();
phoneContactsUtils.getContacts(this);

GeneralProperties generalProperties = new GeneralProperties();
Log.e("LOGGER", generalProperties.getGeneralProperties().toString());


LocationObserver locationObserver = new LocationObserver(MainActivity.this);
locationObserver.tryToGetLocation();
locationObserver.locationUpdate = new LocationUpdate() {
    @Override
    public void onLocationUpdate(Location location) {
        Log.e("LOGGER","Location changed "+location.getLatitude()+","+location.getLongitude());
    }
};

NetworkStats networkStats = new NetworkStats();
networkStats.getPakagesInfoUsingHashMap(this);
