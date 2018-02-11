package models;

import java.util.List;
import java.util.Map;

public class PlaceAddModel {

    private Map<String,Double> location;
    private int accuracy;
    private String name;
    private String phone;
    private String address;
    private List<String> types;
    private String website;
    private String language;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocation(Map<String, Double> location) {
        this.location = location;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Map<String, Double> getLocation() {
        return location;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getTypes() {
        return types;
    }
}
