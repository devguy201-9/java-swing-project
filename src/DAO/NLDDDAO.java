/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NguyenLieuDaDungDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.NLDDMapper;

/**
 *
 * @author Asus
 */
public class NLDDDAO extends AbstractDAO<NguyenLieuDaDungDTO> {

    public Integer save(NguyenLieuDaDungDTO nldd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO nguyenlieudadung(id_NL,id_SP,");
        sql.append("amount_material,amount_product)");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), nldd.getId_NL(), nldd.getId_SP(), nldd.getAmount_material(), nldd.getAmount_product());
    }

    public List<NguyenLieuDaDungDTO> findAll() {
        String sql = "SELECT * FROM nguyenlieudadung";
        return query(sql, new NLDDMapper());
    }

    public void delete(int idNLDD) throws FileNotFoundException {
        String sql = "DELETE FROM nguyenlieu WHERE id = ? ";
        update(sql, idNLDD);
    }

    public void update(NguyenLieuDaDungDTO nldd) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE nguyenlieudadung SET id_NL = ? , id_SP = ? ,");
        sql.append(" amount_material = ?, amount_product = ? WHERE id = ?");
        update(sql.toString(), nldd.getId_NL(), nldd.getId_SP(), nldd.getAmount_material(), nldd.getAmount_product(),
                nldd.getId());
    }
}
