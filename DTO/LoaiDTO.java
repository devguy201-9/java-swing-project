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
public class LoaiDTO {
	private int id_Loai;
    private String name;

    public LoaiDTO(String name) {
        this.name = name;
    }

    public LoaiDTO() {
    	id_Loai=0;
    	name="";
    }
    
    public int getId_Loai() {
		return id_Loai;
	}

	public void setId_Loai(int id_Loai) {
		this.id_Loai = id_Loai;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
