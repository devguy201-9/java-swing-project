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
public class KhachHangDTO {

    private String last_name, first_name, phone;
    private int id_KH;

    public KhachHangDTO() {
        last_name = first_name = phone = "";
        id_KH = 0;
    }

    public KhachHangDTO(String last_name, String first_name, String phone) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }
}
