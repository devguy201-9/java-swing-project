/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class NguyenLieuDTO {

    private int id_NL, amount;
    private String name;
    private float price;

    public NguyenLieuDTO(int amount, String name, float price) {
        this.amount = amount;
        this.name = name;
        this.price = price;
    }

    public NguyenLieuDTO() {
        id_NL = 0;
        amount = 0;
        name = "";
        price = 0.f;
    }

    public int getId_NL() {
        return id_NL;
    }

    public void setId_NL(int id_NL) {
        this.id_NL = id_NL;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void addAmount(int amount) {
        this.amount += amount;
    }
    
    public void subtractAmount(int amount) {
        this.amount -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
