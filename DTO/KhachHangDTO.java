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
public class KhachHangDTO {
    private String last_name,first_name,phone;
    private int id_KH,id_HD;

    public KhachHangDTO() {
    	last_name=first_name=phone="";
    	id_KH=0;
    	id_HD=0;
    }

    public KhachHangDTO(int id_HD, String last_name, String first_name, String phone) {
        this.id_HD = id_HD;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
    }

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId_KH() {
		return id_KH;
	}

	public void setId_KH(int id_KH) {
		this.id_KH = id_KH;
	}

	public int getId_HD() {
		return id_HD;
	}

	public void setId_HD(int id_HD) {
		this.id_HD = id_HD;
	}

}
