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
public class TaiKhoanDTO {
    private String id_TK,id_NV,user_name,pass;

    public TaiKhoanDTO(String id_TK, String id_NV, String user_name, String pass) {
        this.id_TK = id_TK;
        this.id_NV = id_NV;
        this.user_name = user_name;
        this.pass = pass;
    }

    public String getId_TK() {
        return id_TK;
    }

    public void setId_TK(String id_TK) {
        this.id_TK = id_TK;
    }

    public String getId_NV() {
        return id_NV;
    }

    public void setId_NV(String id_NV) {
        this.id_NV = id_NV;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
