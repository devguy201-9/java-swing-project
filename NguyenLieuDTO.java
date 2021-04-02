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
    private String id_NL,name,amount,price;

    public NguyenLieuDTO(String id_NL, String name, String amount, String price) {
        this.id_NL = id_NL;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getId_NL() {
        return id_NL;
    }

    public void setId_NL(String id_NL) {
        this.id_NL = id_NL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
