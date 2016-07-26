package com.datacrawler;

import android.os.Build;

/**
 * Created by soham on 21/7/16.
 */
public class GeneralProperties {
    public class PhoneProperties{
        String osVersion,apiLevel,apiLevelNumber,device,model,manufacturer,product;

        public PhoneProperties(String osVersion, String apiLevel, String apiLevelNumber, String device, String model, String manufacturer, String product) {
            this.osVersion = osVersion;
            this.apiLevel = apiLevel;
            this.apiLevelNumber = apiLevelNumber;
            this.device = device;
            this.model = model;
            this.manufacturer = manufacturer;
            this.product = product;
        }

        public String getOsVersion() {
            return osVersion;
        }

        public void setOsVersion(String osVersion) {
            this.osVersion = osVersion;
        }

        public String getApiLevel() {
            return apiLevel;
        }

        public void setApiLevel(String apiLevel) {
            this.apiLevel = apiLevel;
        }

        public String getApiLevelNumber() {
            return apiLevelNumber;
        }

        public void setApiLevelNumber(String apiLevelNumber) {
            this.apiLevelNumber = apiLevelNumber;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        @Override
        public String toString() {
            String s="Debug-infos:";
            s += "\n OS Version: " + osVersion + "(" + manufacturer + ")";
            s += "\n OS API Level: "+apiLevel + "("+apiLevelNumber+")";
            s += "\n Device: " +device;
            s += "\n Model (and Product): " + model + " ("+ product+ ")";
            return s;
        }
    }
    public PhoneProperties getGeneralProperties(){
        PhoneProperties phoneProperties = new PhoneProperties(System.getProperty("os.version"),android.os.Build.VERSION.RELEASE, ""+android.os.Build.VERSION.SDK_INT,android.os.Build.DEVICE,android.os.Build.MODEL, Build.MANUFACTURER,android.os.Build.PRODUCT);
        String s="Debug-infos:";
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        s += "\n OS API Level: "+android.os.Build.VERSION.RELEASE + "("+android.os.Build.VERSION.SDK_INT+")";
        s += "\n Device: " + android.os.Build.DEVICE;
        s += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
        return phoneProperties;
    }
}
