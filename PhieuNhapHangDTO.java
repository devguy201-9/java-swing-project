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
public class PhieuNhapHangDTO {
    private String id_PNH,id_NCC,id_NV,date_add,total_money;

    public PhieuNhapHangDTO(String id_PNH, String id_NCC, String id_NV, String date_add, String total_money) {
        this.id_PNH = id_PNH;
        this.id_NCC = id_NCC;
        this.id_NV = id_NV;
        this.date_add = date_add;
        this.total_money = total_money;
    }

    public String getId_PNH() {
        return id_PNH;
    }

    public void setId_PNH(String id_PNH) {
        this.id_PNH = id_PNH;
    }

    public String getId_NCC() {
        return id_NCC;
    }

    public void setId_NCC(String id_NCC) {
        this.id_NCC = id_NCC;
    }

    public String getId_NV() {
        return id_NV;
    }

    public void setId_NV(String id_NV) {
        this.id_NV = id_NV;
    }

    public String getDate_add() {
        return date_add;
    }

    public void setDate_add(String date_add) {
        this.date_add = date_add;
    }

    public String getTotal_money() {
        return total_money;
    }

    public void setTotal_money(String total_money) {
        this.total_money = total_money;
    }
    
}
