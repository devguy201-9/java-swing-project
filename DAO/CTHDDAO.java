/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanqlsieuthi.DAO;

import doanqlsieuthi.DTO.ct_HoaDonDTO;
import java.io.FileNotFoundException;

/**
 *
 * @author Asus
 */
public class CTHDDAO extends AbstractDAO<ct_HoaDonDTO> {

    public Integer save(ct_HoaDonDTO cthd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_hoadon(id_HD,id_SP,");
        sql.append("amount,price,promotion_price,total_money)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), cthd.getId_HD(), cthd.getId_SP(), cthd.getAmount(), cthd.getPrice(),
                cthd.getPromotion_price(), cthd.getTotal_money());
    }

}
