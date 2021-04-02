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
public class HoaDonDTO {
   private String id,id_KH,id_KM,id_NV,total_money,total_promo,total_remaining_money,create_day;

    public HoaDonDTO(String id, String id_KH, String id_KM, String id_NV, String total_money, String total_promo, String total_remaining_money, String create_day) {
        this.id = id;
        this.id_KH = id_KH;
        this.id_KM = id_KM;
        this.id_NV = id_NV;
        this.total_money = total_money;
        this.total_promo = total_promo;
        this.total_remaining_money = total_remaining_money;
        this.create_day = create_day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_KH() {
        return id_KH;
    }

    public void setId_KH(String id_KH) {
        this.id_KH = id_KH;
    }

    public String getId_KM() {
        return id_KM;
    }

    public void setId_KM(String id_KM) {
        this.id_KM = id_KM;
    }

    public String getId_NV() {
        return id_NV;
    }

    public void setId_NV(String id_NV) {
        this.id_NV = id_NV;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }

    public String getTotal_promo() {
        return total_promo;
    }

    public void setTotal_promo(String total_promo) {
        this.total_promo = total_promo;
    }

    public String getTotal_remaining_money() {
        return total_remaining_money;
    }

    public void setTotal_remaining_money(String total_remaining_money) {
        this.total_remaining_money = total_remaining_money;
    }

    public String getCreate_day() {
        return create_day;
    }

    public void setCreate_day(String create_day) {
        this.create_day = create_day;
    }
   
}
