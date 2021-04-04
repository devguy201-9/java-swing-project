/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.DTO;

/**
 *
 * @author ACER
 */
public class ct_PhieuNhapHangDTO {

    private int id_PNH, id_NL, amount;
    private float total_money, price;

    public ct_PhieuNhapHangDTO(int id_PNH, int id_NL, int amount, float total_money, float price) {
        this.id_PNH = id_PNH;
        this.id_NL = id_NL;
        this.amount = amount;
        this.total_money = total_money;
        this.price = price;
    }

    public ct_PhieuNhapHangDTO() {
        id_PNH = 0;
        id_NL = 0;
        amount = 0;
        total_money = 0.f;
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

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
