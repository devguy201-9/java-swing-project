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
public class PermissionDTO {
    int id_permission;
    String name;

    public PermissionDTO(int id_quyen, String name) {
        this.id_permission = id_quyen;
        this.name = name;
    }

    public PermissionDTO() {
        this.id_permission = 0;
        this.name = "";
    }

    public int getId_Permission() {
        return id_permission;
    }

    public void setId_Permission(int id_permission) {
        this.id_permission = id_permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionDTO(String name) {
        this.name = name;
    }
}
