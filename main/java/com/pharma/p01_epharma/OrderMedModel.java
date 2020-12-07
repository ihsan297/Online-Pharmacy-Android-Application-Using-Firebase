package com.abubaker.p01_epharma;

public class OrderMedModel {

    String brandName;
    String genName;
    String price;
    String quantity;
    String availability;

    public OrderMedModel(String brandName, String genName, String price, String quantity, String availability) {
        this.brandName = brandName;
        this.genName = genName;
        this.price = price;
        this.quantity = quantity;
        this.availability = availability;
    }
    public OrderMedModel(){}

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenName() {
        return genName;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
