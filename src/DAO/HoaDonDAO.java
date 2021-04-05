/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.io.FileNotFoundException;

/**
 *
 * @author Asus
 */
public class HoaDonDAO extends AbstractDAO<HoaDonDTO> {

    public Integer save(HoaDonDTO hd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO hoadon(id_KH,id_KM,");
        sql.append("id_NV,total_money,total_promo,total_remaining_money,create_day)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), hd.getId_KH(), hd.getId_KM(),hd.getId_NV(),hd.getTotal_money(), hd.getTotal_promo(), 
                    hd.getTotal_remaining_money(), hd.getCreate_day());
    }
}
