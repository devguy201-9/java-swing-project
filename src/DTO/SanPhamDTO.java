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

    private int id_SP, id_Loai, amount;
    private String name, descrption, img;
    private float price;

    public SanPhamDTO() {
        id_SP = id_Loai = amount = 0;
        name = "";
        descrption = "";
        price = 0.f;
    }

    public SanPhamDTO(int id_Loai, int amount, String name, String descrption, float price, String img) {
        this.id_Loai = id_Loai;
        this.amount = amount;
        this.name = name;
        this.descrption = descrption;
        this.price = price;
        this.img = img;
    }

    public int getId_SP() {
        return id_SP;
    }

    public void setId_SP(int id_SP) {
        this.id_SP = id_SP;
    }

    public int getId_Loai() {
        return id_Loai;
    }

    public void setId_Loai(int id_Loai) {
        this.id_Loai = id_Loai;
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

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
