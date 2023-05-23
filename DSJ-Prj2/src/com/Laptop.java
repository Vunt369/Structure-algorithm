package com;
public class Laptop {
    private String code;
    private String name;
    private int price;
    private int guaranty;

    public Laptop() {
    }

    public Laptop(String code, String name, int price, int guaranty) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.guaranty = guaranty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(int guaranty) {
        this.guaranty = guaranty;
    }
    @Override
    public String toString(){
        return code + " | " + name + " | " + price + " | " + guaranty;
    }
    public boolean equals(Laptop mod){
        return mod.getCode().equals(this.getCode()) && mod.getName().equals(this.name) && mod.getPrice() == this.price && mod.getGuaranty() == this.guaranty;
    }
}
