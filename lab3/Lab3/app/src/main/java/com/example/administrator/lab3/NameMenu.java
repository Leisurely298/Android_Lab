package com.example.administrator.lab3;


public class NameMenu {
    private String name;
    private String price;
    private String first_letter;
    public NameMenu(String name, String price, String first_letter){
        this.name = name;
        this.price = price;
        this.first_letter = first_letter;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getFirst_Letter(){
        return first_letter;
    }
}
