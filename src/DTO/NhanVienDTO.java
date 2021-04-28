/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class NhanVienDTO {

    private int id_NV, age;
    private String name, address, phone, img;
    private Gender gender;
    private Date start_day;

    public NhanVienDTO() {
        id_NV = 0;
        age = 0;
        name = address = phone = "";
        gender = null;
        start_day = null;
    }

    public NhanVienDTO(int age, String name, String address, String phone, Gender gender, Date start_day, String img) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.start_day = start_day;
        this.img = img;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender.equals(Gender.male))    this.gender = Gender.male;
        else this.gender = Gender.female;
    }

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
