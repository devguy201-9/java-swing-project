/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CategoryDAO;
import DTO.CategoryDTO;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import mapper.CategoryMapper;

/**
 *
 * @author Thuan Vo
 */
public class CategoryBUS {
    private List<CategoryDTO> CategoryList;
    
    public CategoryBUS() {
        CategoryList = null;
    }

    public List<CategoryDTO> getCategoryList() {
        return CategoryList;
    }
    
    public CategoryDTO getByIdDuty(int id_duty){
        CategoryDAO category = new CategoryDAO();
        String sql = "SELECT * FROM `nhiemvu` WHERE id_duty = ?";
        List<CategoryDTO> temp = category.query(sql, new CategoryMapper(), id_duty);
        CategoryDTO result = temp.get(1);
        return result;
    }
    
    public void list(){
        CategoryDAO categoryDAO = new CategoryDAO();
        CategoryList = new ArrayList<>();
        CategoryList = categoryDAO.findAll();
    }
    
    public void show(){
        for(CategoryDTO category : CategoryList) {
            System.out.println(category.getName());
        }
    }
    
    public void add(CategoryDTO category){
        CategoryList.add(category);
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            categoryDAO.save(category);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int id_duty) {
        for(CategoryDTO categoryDTO : CategoryList){
            if(categoryDTO.getId_duty() == id_duty) {
                CategoryList.remove(categoryDTO);
                CategoryDAO categoryDAO = new CategoryDAO();
                try {
                    categoryDAO.delete(id_duty);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
    
    public void set(CategoryDTO categoryDTO){
        for(int i = 0 ; i < CategoryList.size() ; i++) {
            if(CategoryList.get(i).getId_duty() == categoryDTO.getId_duty()) {
                CategoryList.set(i, categoryDTO);
                CategoryDAO categoryDAO = new CategoryDAO();
                try {
                    categoryDAO.update(categoryDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }
}
