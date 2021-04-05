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
public class KhuyenMaiDTO {

    private int id_KM;
    private String name, type;
    private Date start_time, end_time;

    public KhuyenMaiDTO(String name, String type, Date start_time, Date end_time) {
        this.name = name;
        this.type = type;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public KhuyenMaiDTO() {
        id_KM = 0;
        name = "";
        type = "";
        start_time = null;
        end_time = null;
    }

    public int getId_KM() {
        return id_KM;
    }

    public void setId_KM(int id_KM) {
        this.id_KM = id_KM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

}
