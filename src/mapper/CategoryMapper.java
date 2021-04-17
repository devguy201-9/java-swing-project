/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import DTO.CategoryDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thuan Vo
 */
public class CategoryMapper implements RowMapper<CategoryDTO>{
    @Override
    public CategoryDTO mapRow(ResultSet rs) {
        try {
            CategoryDTO category = new CategoryDTO();
            category.setId_duty(rs.getInt("id_duty"));
            category.setName(rs.getString("name"));
            category.setImage(rs.getString("image"));
            category.setImage_hover(rs.getString("image_hover"));
            return category;
        } catch (SQLException e) {
            return null;
        }
    }
}
