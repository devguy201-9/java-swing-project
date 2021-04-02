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
public class ct_PhieuNhapHangDTO {

    private String id, id_KM, id_SP, discount;

    public ct_PhieuNhapHangDTO(String id, String id_KM, String id_SP, String discount) {
        this.id = id;
        this.id_KM = id_KM;
        this.id_SP = id_SP;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_KM() {
        return id_KM;
    }

    public void setId_KM(String id_KM) {
        this.id_KM = id_KM;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
}
