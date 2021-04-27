/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Thuan Vo
 */
public class ct_quyenDTO {
    int id_permission;
    int id_duty;

    public ct_quyenDTO(int id_role, int id_duty) {
        this.id_permission = id_role;
        this.id_duty = id_duty;
    }

    public ct_quyenDTO() {
        this.id_permission = 0;
        this.id_duty = 0;
    }

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    public int getid_duty() {
        return id_duty;
    }

    public void setid_duty(int id_duty) {
        this.id_duty = id_duty;
    }
}
