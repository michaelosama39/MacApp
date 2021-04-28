package com.example.macapp.ui.premiumsToday;

public class PremiumsTodayModel {
    private String name ;
    private String copy;
    private String premium;

    public PremiumsTodayModel(String name, String copy, String premium) {
        this.name = name;
        this.copy = copy;
        this.premium = premium;
    }

    public PremiumsTodayModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }
}
