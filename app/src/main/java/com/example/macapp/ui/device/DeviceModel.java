package com.example.macapp.ui.device;

public class DeviceModel {
    private String name ;
    private String helperName;
    private String helperNumber;
    private String typeOfDevice;
    private String copy;
    private String dateOfBuy;
    private String mobilePrice;
    private String firstBatch;
    private String premium;
    private String monthOfLength;
    private String payOfDay;

    public DeviceModel(String name, String helperName,
                       String helperNumber, String typeOfDevice,
                       String copy, String dateOfBuy, String mobilePrice,
                       String firstBatch, String premium,
                       String monthOfLength, String payOfDay) {
        this.name = name;
        this.helperName = helperName;
        this.helperNumber = helperNumber;
        this.typeOfDevice = typeOfDevice;
        this.copy = copy;
        this.dateOfBuy = dateOfBuy;
        this.mobilePrice = mobilePrice;
        this.firstBatch = firstBatch;
        this.premium = premium;
        this.monthOfLength = monthOfLength;
        this.payOfDay = payOfDay;
    }

    public DeviceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelperName() {
        return helperName;
    }

    public void setHelperName(String helperName) {
        this.helperName = helperName;
    }

    public String getHelperNumber() {
        return helperNumber;
    }

    public void setHelperNumber(String helperNumber) {
        this.helperNumber = helperNumber;
    }

    public String getTypeOfDevice() {
        return typeOfDevice;
    }

    public void setTypeOfDevice(String typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(String dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public String getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(String mobilePrice) {
        this.mobilePrice = mobilePrice;
    }

    public String getFirstBatch() {
        return firstBatch;
    }

    public void setFirstBatch(String firstBatch) {
        this.firstBatch = firstBatch;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getMonthOfLength() {
        return monthOfLength;
    }

    public void setMonthOfLength(String monthOfLength) {
        this.monthOfLength = monthOfLength;
    }

    public String getPayOfDay() {
        return payOfDay;
    }

    public void setPayOfDay(String payOfDay) {
        this.payOfDay = payOfDay;
    }
}
