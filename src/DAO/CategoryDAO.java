/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CategoryDTO;
import java.io.FileNotFoundException;
import java.util.List;
import mapper.CategoryMapper;

/**
 *
 * @author Thuan Vo
 */
public class CategoryDAO extends AbstractDAO<CategoryDTO> {

    public CategoryDTO getByIdDuty(int id_duty) {
        CategoryDAO category = new CategoryDAO();
        String  sql = "SELECT * FROM `danhmuc` WHERE id_duty = ?";
        List<CategoryDTO> temp = category.query(sql, new CategoryMapper(), id_duty);
        CategoryDTO result = temp.get(0);
        return result;
    }

    public Integer save(CategoryDTO category) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("INSERT INTO danhmuc(id_duty,name,image,image_hover");
        sql.append(" VALUES(?, ?, ?, ?)");
        return insert(sql.toString(), category.getId_duty(), category.getName(), category.getImage(), category.getImage_hover());
    }

    public List<CategoryDTO> findAll() {
        String sql = "select * from danhmuc";
        return query(sql, new CategoryMapper());
    }

    public void delete(int idCategory) throws FileNotFoundException {
        String sql = "DELETE FROM danhmuc WHERE id_duty = ? ";
        update(sql, idCategory);
    }

    public void update(CategoryDTO category) throws FileNotFoundException {
        StringBuilder sql = new StringBuilder("UPDATE danhmuc SET name = ? , image = ? , image_hover = ?");
        sql.append("WHERE id_duty = ?");
        update(sql.toString(), category.getName(), category.getImage(), category.getImage_hover(), category.getId_duty());
    }

}
