package com.abubaker.p01_epharma;

public class CartModel {
    String CartMedName,CartPrice,CartQty;

    public CartModel(String cartMedName, String cartPrice, String cartQty) {
        CartMedName = cartMedName;
        CartPrice = cartPrice;
        CartQty = cartQty;
    }

    public CartModel(){}

    public String getCartMedName() {
        return CartMedName;
    }

    public String getCartPrice() {
        return CartPrice;
    }

    public String getCartQty() {
        return CartQty;
    }

    public void setCartMedName(String cartMedName) {
        CartMedName = cartMedName;
    }

    public void setCartPrice(String cartPrice) {
        CartPrice = cartPrice;
    }

    public void setCartQty(String cartQty) {
        CartQty = cartQty;
    }
}
