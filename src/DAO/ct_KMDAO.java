/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ct_KhuyenMaiDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.ct_KMMapper;

/**
 *
 * @author Asus
 */
public class ct_KMDAO extends AbstractDAO<ct_KhuyenMaiDTO> {

    public Integer save(ct_KhuyenMaiDTO ctkm) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO ct_khuyenmai(id_KM,id_SP,");
        sql.append("discount)");
        sql.append(" VALUES(?, ?, ?)");
        return insert(sql.toString(), ctkm.getId_KM(), ctkm.getId_SP(), ctkm.getDiscount());
    }

    public List<ct_KhuyenMaiDTO> findAll() {
        String sql = "SELECT * FROM ct_khuyenmai";
        return query(sql, new ct_KMMapper());
    }

    public void delete(int idCTKM) throws FileNotFoundException {
        String sql = "DELETE FROM ct_khuyenmai WHERE id = ? ";
        update(sql, idCTKM);
    }

    public void update(ct_KhuyenMaiDTO ctkm) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE ct_khuyenmai SET id_KM = ? , id_SP = ? ,");
        sql.append(" discount = ? WHERE id = ?");
        update(sql.toString(), ctkm.getId_KM(), ctkm.getId_SP(), ctkm.getDiscount(), ctkm.getId());
    }
}
