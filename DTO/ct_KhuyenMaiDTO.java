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
public class ct_KhuyenMaiDTO {

    private int id, id_KM, id_SP;
    private float discount;

    public ct_KhuyenMaiDTO(int id_KM, int id_SP, float discount) {
        this.id_KM = id_KM;
        this.id_SP = id_SP;
        this.discount = discount;
    }

    public ct_KhuyenMaiDTO() {
        id_KM = 0;
        id = 0;
        id_SP = 0;
        discount = 0.f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_KM() {
        return id_KM;
    }

    public void setId_KM(int id_KM) {
        this.id_KM = id_KM;
    }

    public int getId_SP() {
        return id_SP;
    }

    public void setId_SP(int id_SP) {
        this.id_SP = id_SP;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}
