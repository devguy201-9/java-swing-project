/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ct_HoaDonDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.ct_HDMapper;

/**
 *
 * @author Asus
 */
public class ct_HDDAO extends AbstractDAO<ct_HoaDonDTO> {

    public Integer save(ct_HoaDonDTO cthd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_hoadon(id_HD,id_SP,");
        sql.append("name,amount,price)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), cthd.getId_HD(), cthd.getId_SP(), cthd.getAmount(), cthd.getPrice());
    }

    public List<ct_HoaDonDTO> findAll() {
        String sql = "SELECT * FROM ct_hoadon";
        return query(sql, new ct_HDMapper());
    }
    
    public List<ct_HoaDonDTO> findByCode(int maHD) {
        String sql = "SELECT * FROM ct_hoadon WHERE id_HD = ? ";
        return query(sql, new ct_HDMapper(),maHD);
    }

    public void delete(int idCTHD) throws FileNotFoundException {
        String sql = "DELETE FROM ct_hoadon WHERE id = ? ";
        update(sql, idCTHD);
    }
    
    public void deleteByCodeProduct(int MaSP) throws FileNotFoundException {
        String sql = "DELETE FROM ct_hoadon WHERE id_SP = ? ";
        update(sql, MaSP);
    }

    public void update(ct_HoaDonDTO cthd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE ct_hoadon SET id_HD = ? , id_SP = ? ,");
        sql.append(" amount = ?, price = ?, promotion_price = ?, total_money = ? WHERE id = ?");
        update(sql.toString(), cthd.getId_HD(), cthd.getId_SP(),cthd.getName(), cthd.getAmount(), 
                cthd.getPrice());
    }
}
