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
public class ThongKeDTO {
    private String nameSP;
    private int soluongDaBan;

    public ThongKeDTO() {
    }
    
    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public int getSoluongDaBan() {
        return soluongDaBan;
    }

    public void setSoluongDaBan(int soluongDaBan) {
        this.soluongDaBan = soluongDaBan;
    }
}
