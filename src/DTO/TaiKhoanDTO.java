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

    private int id_TK, id_NV,id_permission;
    private String user_name, pass;

    public TaiKhoanDTO() {
        id_NV = 0;
        id_TK = 0;
        id_permission=0;
        user_name = "";
        pass = "";
    }

    public TaiKhoanDTO(int id_NV, int id_permission, String user_name, String pass) {
        this.id_NV = id_NV;
        this.user_name = user_name;
        this.pass = pass;
        this.id_permission = id_permission; 
    }

    public int getId_TK() {
        return id_TK;
    }

    public void setId_TK(int id_TK) {
        this.id_TK = id_TK;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
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

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

}
