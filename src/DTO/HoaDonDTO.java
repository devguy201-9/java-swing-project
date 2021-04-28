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

    private int id, id_KH, id_NV;   
    private float total_money;      
    private Timestamp create_day;

    public HoaDonDTO(int id, int id_KH, int id_NV, float total_money, 
            Timestamp create_day) {    
        this.id = id;
        this.id_KH = id_KH;
        this.id_NV = id_NV;
        this.total_money = total_money;
        this.create_day = create_day;
    }

    public HoaDonDTO() {
        id = 0;
        id_KH = 0;
        id_NV = 0;
        total_money = 0.f;
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

    public Timestamp getCreate_day() {
        return create_day;
    }

    public void setCreate_day(Timestamp create_day) {
        this.create_day = create_day;
    }

}
