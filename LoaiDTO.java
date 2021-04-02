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
public class LoaiDTO {
    private String id_Loai, name;

    public LoaiDTO(String id_Loai, String name) {
        this.id_Loai = id_Loai;
        this.name = name;
    }

    public String getId_Loai() {
        return id_Loai;
    }

    public void setId_Loai(String id_Loai) {
        this.id_Loai = id_Loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
