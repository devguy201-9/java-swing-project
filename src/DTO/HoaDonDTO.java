/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author ACER
 */
public class HoaDonDTO {

    private int id, id_KH, id_KM, id_NV;
    private float total_money, total_promo, total_remaining_money;
    private Timestamp create_day;

    public HoaDonDTO(int id_KH, int id_KM, int id_NV, float total_money, float total_promo, float total_remaining_money,
            Timestamp create_day) {
        this.id_KH = id_KH;
        this.id_KM = id_KM;
        this.id_NV = id_NV;
        this.total_money = total_money;
        this.total_promo = total_promo;
        this.total_remaining_money = total_remaining_money;
        this.create_day = create_day;
    }

    public HoaDonDTO() {
        id = 0;
        id_KH = 0;
        id_KM = 0;
        id_NV = 0;
        total_money = 0.f;
        total_promo = 0.f;
        total_remaining_money = 0.f;
        create_day = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }

    public int getId_KM() {
        return id_KM;
    }

    public void setId_KM(int id_KM) {
        this.id_KM = id_KM;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public float getTotal_promo() {
        return total_promo;
    }

    public void setTotal_promo(float total_promo) {
        this.total_promo = total_promo;
    }

    public float getTotal_remaining_money() {
        return total_remaining_money;
    }

    public void setTotal_remaining_money(float total_remaining_money) {
        this.total_remaining_money = total_remaining_money;
    }

    public Timestamp getCreate_day() {
        return create_day;
    }

    public void setCreate_day(Timestamp create_day) {
        this.create_day = create_day;
    }

}
