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
public class ct_PhieuNhapHangDTO {

    private int id_PNH, id_NL, amount;
    private float price;
    private String name;

    public ct_PhieuNhapHangDTO(int id_PNH, int id_NL, int amount, String name, float price) {
        this.id_PNH = id_PNH;
        this.id_NL = id_NL;
        this.amount = amount;
        this.name = name;
        this.price = price;
    }

    public ct_PhieuNhapHangDTO() {
        id_PNH = 0;
        id_NL = 0;
        amount = 0;
        name = "";
        price = 0.f;
    }

    public int getId_PNH() {
        return id_PNH;
    }

    public void setId_PNH(int id_PNH) {
        this.id_PNH = id_PNH;
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
