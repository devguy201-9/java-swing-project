/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ct_PhieuNhapHangDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.ct_PNHMapper;

/**
 *
 * @author Asus
 */
public class ct_PNHDAO extends AbstractDAO<ct_PhieuNhapHangDTO> {

    public Integer save(ct_PhieuNhapHangDTO ctpnh) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_phieunhaphang(id_PNH,id_NL,amount,");
        sql.append("price,total_money)");
        sql.append(" VALUES(?, ?, ?, ?, ?)");
        return insert(sql.toString(), ctpnh.getId_PNH(), ctpnh.getId_NL(), ctpnh.getAmount(), ctpnh.getPrice(), ctpnh.getTotal_money());
    }

    public List<ct_PhieuNhapHangDTO> findAll() {
        String sql = "SELECT * FROM ct_phieunhaphang";
        return query(sql, new ct_PNHMapper());
    }
    
    public List<ct_PhieuNhapHangDTO> findByCode(int maPNH) {
        String sql = "SELECT * FROM ct_phieunhaphang WHERE id_PNH = ?";
        return query(sql, new ct_PNHMapper(),maPNH);
    }

    public void delete(int idPNH) throws FileNotFoundException {
        String sql = "DELETE FROM ct_phieunhaphang WHERE id_PNH = ? ";
        update(sql, idPNH);
    }
    
    public void deleteByCodeBillAndProduct(int idPNH,int idNL) throws FileNotFoundException {
        String sql = "DELETE FROM ct_phieunhaphang WHERE id_PNH = ? AND id_NL = ?";
        update(sql, idPNH,idNL);
    }

    public void update(ct_PhieuNhapHangDTO ctpnh) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE ct_phieunhaphang SET id_NL = ? , amount = ? ,");
        sql.append(" price = ?, total_money = ? WHERE id_PNH = ?");
        update(sql.toString(), ctpnh.getId_NL(), ctpnh.getAmount(), ctpnh.getPrice(), ctpnh.getTotal_money(), ctpnh.getId_PNH());
    }
}
