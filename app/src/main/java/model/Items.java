package model;

public class Items {
    String itemName,itemPrice,itemDesc;
    String itemImage;

    public Items(){}


    public Items(String itemName, String itemPrice, String itemImage, String itemDesc) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.itemDesc = itemDesc;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
