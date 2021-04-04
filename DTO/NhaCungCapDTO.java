/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.DTO;

/**
 *
 * @author ACER
 */
public class NhaCungCapDTO {

    private int id_NCC;
    private String name_NCC, address, phone;

    public NhaCungCapDTO() {
        id_NCC = 0;
        name_NCC = address = phone = "";
    }

    public NhaCungCapDTO(String name_NCC, String address, String phone) {
        this.name_NCC = name_NCC;
        this.address = address;
        this.phone = phone;
    }

    public int getId_NCC() {
        return id_NCC;
    }

    public void setId_NCC(int id_NCC) {
        this.id_NCC = id_NCC;
    }

    public String getName_NCC() {
        return name_NCC;
    }

    public void setName_NCC(String name_NCC) {
        this.name_NCC = name_NCC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
