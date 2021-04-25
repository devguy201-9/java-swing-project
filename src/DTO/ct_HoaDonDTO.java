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

    private int id_HD, id_SP, amount;
    private String name;
    private float price;

    public ct_HoaDonDTO(int id_HD, int id_SP, String name, int amount, float price) {
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.name = name;
        this.amount = amount;
        this.price = price;        
//        this.total_money = total_money;
    }

    public ct_HoaDonDTO() {       
        id_HD = 0;
        id_SP = 0;
        amount = 0;
        price = 0.f;        
//        total_money = 0.f;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
