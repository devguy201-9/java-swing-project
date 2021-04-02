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
public class ct_HoaDonDTO {
    private String id, id_HD, id_SP, amount, price,promotion_price,total_money;    

    public ct_HoaDonDTO(String id, String id_HD, String id_SP, String amount, String price, String promotion_price, String total_money) {
        this.id = id;
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.amount = amount;
        this.price = price;
        this.promotion_price = promotion_price;
        this.total_money = total_money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_HD() {
        return id_HD;
    }

    public void setId_HD(String id_HD) {
        this.id_HD = id_HD;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
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

    public String getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(String promotion_price) {
        this.promotion_price = promotion_price;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }
    
}
