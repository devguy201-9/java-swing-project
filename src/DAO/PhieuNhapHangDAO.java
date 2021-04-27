/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PhieuNhapHangDTO;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.List;
import mapper.PNHMapper;

/**
 *
 * @author Asus
 */
public class PhieuNhapHangDAO extends AbstractDAO<PhieuNhapHangDTO> {

    public Integer save(PhieuNhapHangDTO pnh) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO phieunhaphang(id_NCC,id_NV,");
        sql.append("date_add,total_money)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), pnh.getId_NCC(), pnh.getId_NV(), new SimpleDateFormat("yyyy/MM/dd").format(pnh.getDate_add()), pnh.getTotal_money());
    }

    public List<PhieuNhapHangDTO> findAll() {
        String sql = "SELECT * FROM phieunhaphang";
        return query(sql, new PNHMapper());
    }

    public void delete(int idPNH) throws FileNotFoundException {
        String sql = "DELETE FROM phieunhaphang WHERE id_PNH = ? ";
        update(sql, idPNH);
    }

    public void update(PhieuNhapHangDTO pnh) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE phieunhaphang SET id_NCC = ? , id_NV = ? ,");
        sql.append(" date_add = ?, total_money = ? WHERE id_PNH = ?");
        update(sql.toString(), pnh.getId_NCC(), pnh.getId_NV(), new SimpleDateFormat("yyyy/MM/dd").format(pnh.getDate_add()), pnh.getTotal_money(), pnh.getId_PNH());
    }
}
