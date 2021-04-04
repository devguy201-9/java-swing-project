/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.DTO;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class PhieuNhapHangDTO {

    private int id_PNH, id_NCC, id_NV;
    private Date date_add;
    private float total_money;

    public PhieuNhapHangDTO() {
        id_NCC = id_NV = id_PNH = 0;
        date_add = null;
        total_money = 0.f;
    }

    public PhieuNhapHangDTO(int id_NCC, int id_NV, Date date_add, float total_money) {
        this.id_NCC = id_NCC;
        this.id_NV = id_NV;
        this.date_add = date_add;
        this.total_money = total_money;
    }

    public int getId_PNH() {
        return id_PNH;
    }

    public void setId_PNH(int id_PNH) {
        this.id_PNH = id_PNH;
    }

    public int getId_NCC() {
        return id_NCC;
    }

    public void setId_NCC(int id_NCC) {
        this.id_NCC = id_NCC;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public Date getDate_add() {
        return date_add;
    }

    public void setDate_add(Date date_add) {
        this.date_add = date_add;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

}
