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
public class SanPhamDTO {
    private String id_SP,id_Loai,name,descrption,amount,price;

    public SanPhamDTO(String id_SP, String id_Loai, String name, String descrption, String amount, String price) {
        this.id_SP = id_SP;
        this.id_Loai = id_Loai;
        this.name = name;
        this.descrption = descrption;
        this.amount = amount;
        this.price = price;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }

    public String getId_Loai() {
        return id_Loai;
    }

    public void setId_Loai(String id_Loai) {
        this.id_Loai = id_Loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
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
