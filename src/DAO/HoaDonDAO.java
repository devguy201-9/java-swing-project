/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.HoaDonMapper;

/**
 *
 * @author Asus
 */
public class HoaDonDAO extends AbstractDAO<HoaDonDTO> {

    public Integer save(HoaDonDTO hd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO hoadon(id_KH,");
        sql.append("id_NV,total_money,create_day)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), hd.getId_KH(), hd.getId_NV(), hd.getTotal_money(),
                hd.getCreate_day());
    }

    public List<HoaDonDTO> findAll() {
        String sql = "SELECT * FROM hoadon";
        return query(sql, new HoaDonMapper());
    }

    public void delete(int idHD) throws FileNotFoundException {
        String sql = "DELETE FROM hoadon WHERE id = ? ";
        update(sql, idHD);
    }

    public void update(HoaDonDTO hoaDon) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE hoadon SET id_KH  = ? , id_NV  = ?");
        sql.append(" , total_money  = ? create_day  = ?  WHERE id = ?");
        update(sql.toString(), hoaDon.getId_KH(), hoaDon.getId_NV(), hoaDon.getTotal_money(), hoaDon.getCreate_day(),
                hoaDon.getId());
    }

}
