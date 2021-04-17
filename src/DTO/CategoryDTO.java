/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Thuan Vo
 */
public class CategoryDTO {
    int id_duty;
    String name, image , image_hover;

    public CategoryDTO() {
        this.id_duty = 0;
        this.name = "";
        this.image = "";
        this.image_hover = "";
    }

    public CategoryDTO(int id_duty, String name, String image, String image_hover) {
        this.id_duty = id_duty;
        this.name = name;
        this.image = image;
        this.image_hover = image_hover;
    }

    

    public int getId_duty() {
        return id_duty;
    }

    public void setId_duty(int id_duty) {
        this.id_duty = id_duty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_hover() {
        return image_hover;
    }

    public void setImage_hover(String image_hover) {
        this.image_hover = image_hover;
    }

    @Override
    public String toString() {
        return  name + ":" + image + ":" + image_hover ;
    }
    
}
