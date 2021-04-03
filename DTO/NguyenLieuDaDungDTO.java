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
public class NguyenLieuDaDungDTO {
    private int id,id_NL,id_SP,amount_material,amount_product;

	public NguyenLieuDaDungDTO(int id_NL, int id_SP, int amount_material, int amount_product) {
		this.id_NL = id_NL;
		this.id_SP = id_SP;
		this.amount_material = amount_material;
		this.amount_product = amount_product;
	}

	public NguyenLieuDaDungDTO() {
		id=0;
		id_NL = 0;
		id_SP = 0;
		amount_material = 0;
		amount_product = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_NL() {
		return id_NL;
	}

	public void setId_NL(int id_NL) {
		this.id_NL = id_NL;
	}

	public int getId_SP() {
		return id_SP;
	}

	public void setId_SP(int id_SP) {
		this.id_SP = id_SP;
	}

	public int getAmount_material() {
		return amount_material;
	}

	public void setAmount_material(int amount_material) {
		this.amount_material = amount_material;
	}

	public int getAmount_product() {
		return amount_product;
	}

	public void setAmount_product(int amount_product) {
		this.amount_product = amount_product;
	}
    
}
