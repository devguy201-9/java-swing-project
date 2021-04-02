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
public class NguyenLieuDaDungDTO {
    private String id,id_NL,id_SP,amount_material,amount_product;

    public NguyenLieuDaDungDTO(String id, String id_NL, String id_SP, String amount_material, String amount_product) {
        this.id = id;
        this.id_NL = id_NL;
        this.id_SP = id_SP;
        this.amount_material = amount_material;
        this.amount_product = amount_product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_NL() {
        return id_NL;
    }

    public void setId_NL(String id_NL) {
        this.id_NL = id_NL;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }

    public String getAmount_material() {
        return amount_material;
    }

    public void setAmount_material(String amount_material) {
        this.amount_material = amount_material;
    }

    public String getAmount_product() {
        return amount_product;
    }

    public void setAmount_product(String amount_product) {
        this.amount_product = amount_product;
    }
    
}
