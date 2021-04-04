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
public class ct_HoaDonDTO {

    private int id, id_HD, id_SP, amount;
    private float price, promotion_price, total_money;

    public ct_HoaDonDTO(int id_HD, int id_SP, int amount, float price, float promotion_price, float total_money) {
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.amount = amount;
        this.price = price;
        this.promotion_price = promotion_price;
        this.total_money = total_money;
    }

    public ct_HoaDonDTO() {
        id = 0;
        id_HD = 0;
        id_SP = 0;
        amount = 0;
        price = 0.f;
        promotion_price = 0.f;
        total_money = 0.f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_HD() {
        return id_HD;
    }

    public void setId_HD(int id_HD) {
        this.id_HD = id_HD;
    }

    public int getId_SP() {
        return id_SP;
    }

    public void setId_SP(int id_SP) {
        this.id_SP = id_SP;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(float promotion_price) {
        this.promotion_price = promotion_price;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

}
