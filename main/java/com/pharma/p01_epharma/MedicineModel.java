package com.abubaker.p01_epharma;

public class MedicineModel {

    String brandName;
    String genName;
    String price;
    String quantity;
    String availability;
    String img;

    public MedicineModel() {
    }

    public MedicineModel(String brandName, String genName, String price, String quantity, String availability,String img) {
        this.brandName = brandName;
        this.genName = genName;
        this.price = price;
        this.quantity = quantity;
        this.availability = availability;
        this.img=img;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
