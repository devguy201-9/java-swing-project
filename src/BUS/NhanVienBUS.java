/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DTO.Gender;
import DTO.NhanVienDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.String.valueOf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class NhanVienBUS {

    private List<NhanVienDTO> nvBUS;

    public NhanVienBUS() {
        nvBUS = null;
    }

    public List<NhanVienDTO> getNvBUS() {
        return nvBUS;
    }

    public void list() {
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvBUS = new ArrayList<>();
        nvBUS = nvDAO.findAll();
    }

    public NhanVienDTO getEmployeeByPhone(String phone) {
        NhanVienDAO nvDAO = new NhanVienDAO();
        NhanVienDTO nv = nvDAO.getOneByPhone(phone);
        return nv;
    }
    
    public NhanVienDTO getEmployeeByGender(Gender phai){
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvBUS.add(nvDAO.getOneByGender(phai));
        return nvBUS.get(nvBUS.size());        
    }

    public void add(NhanVienDTO nvDTO) {
        nvBUS.add(nvDTO);
        NhanVienDAO nvDAO = new NhanVienDAO();
        try {
            nvDAO.save(nvDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String id) {
        int idNV = Integer.parseInt(id);
        for (NhanVienDTO nvDTO : nvBUS) {
            if (nvDTO.getId_NV() == idNV) {
                nvBUS.remove(nvDTO);
                NhanVienDAO nvDAO = new NhanVienDAO();
                try {
                    nvDAO.delete(idNV);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(NhanVienDTO nvDTO) {
        for (int i = 0; i < nvBUS.size(); i++) {
            if (nvBUS.get(i).getId_NV() == nvDTO.getId_NV()) {
                nvBUS.set(i, nvDTO);
                NhanVienDAO nvDAO = new NhanVienDAO();
                try {
                    nvDAO.update(nvDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public boolean check(int manv) {
        for (NhanVienDTO nv : nvBUS) {
            if (nv.getId_NV() == manv) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<NhanVienDTO> search(int manv, String name, String phone, String phai) {
        ArrayList<NhanVienDTO> search = new ArrayList<>();
        name = name.toLowerCase();
        Gender gender = Gender.female;
        if (!phai.equals("")) {
            if (phai.equals("Nam")) {
                gender = Gender.male;
            } else if (phai.equals("Nữ")) {
                gender = Gender.female;
            }
        }
        for (NhanVienDTO nv : nvBUS) {
            if ((nv.getId_NV() == manv) && nv.getName().toLowerCase().contains(name) && nv.getPhone().contains(phone) && ( nv.getGender().toString().equals(gender.toString()) || phai.equals(""))) {
                search.add(nv);
            } else if ((manv == 0) && nv.getName().toLowerCase().contains(name) && nv.getPhone().contains(phone) && ( nv.getGender().toString().equals(gender.toString()) || phai.equals(""))) {
                search.add(nv);
            }
        }
        return search;
    }


//    public void export(String excelFilePath){
//    
//    
//    XSSFWorkbook workbook = new XSSFWorkbook();
//    XSSFSheet sheet = workbook.createSheet("Employee");
//
//    XSSFFont font = workbook.createFont();
//    font.setFontHeightInPoints((short) 12);
//    font.setBold(true);
//    
//    font.setColor(IndexedColors.BLUE.getIndex());
//
//    // Create a CellStyle with the font
//    XSSFCellStyle headerCellStyle = workbook.createCellStyle();
//    headerCellStyle.setFont(font);
//
//    // Create a Row
//    Row headerRow = sheet.createRow(0);
//    String[] columns = {
//            "Name",
//            "Age",
//            "Gender",
//            "Address",
//            "Phone",
//            "Start_Day"
//    };
//
//    // Create cells
//    for (int i = 0; i < columns.length; i++) {
//        Cell cell = headerRow.createCell(i);
//        cell.setCellValue(columns[i]);
//        cell.setCellStyle(headerCellStyle);
//    }
//
//    // Create Other rows and cells with employees data
//    int rowNum = 1;
//    list();
//    List<NhanVienDTO> employeeDTOs = getNvBUS();
//    for (NhanVienDTO nv : employeeDTOs) {
//        Row row = sheet.createRow(rowNum++);
//
//        row.createCell(0)
//                .setCellValue(nv.getName());
//
//        row.createCell(1)
//                .setCellValue(nv.getAge());
//        row.createCell(2)
//                .setCellValue(nv.getGender().toString());
//        row.createCell(3)
//                .setCellValue(nv.getAddress());
//        row.createCell(4)
//                .setCellValue(nv.getPhone());
//        row.createCell(5)
//                .setCellValue(nv.getStart_day().toString());
//        
//    }
//
//    for (int i = 0; i < columns.length; i++) {
//        sheet.autoSizeColumn(i);
//    }
//try{
//    OutputStream os = new FileOutputStream(excelFilePath);
//    workbook.write(os);
//
//    // Closing stream
//    workbook.close();
//    
//        } catch ( IOException ex) {
//            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void importEmployee(File file) throws FileNotFoundException, IOException, ParseException{
//        FileInputStream in = new FileInputStream(file);
//            XSSFWorkbook workbook = new XSSFWorkbook(in);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Row row;
//            
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            for(int i = 1; i <= sheet.getLastRowNum(); i++){
//                row = sheet.getRow(i);
//                
//                String name = valueOf(row.getCell(0)).trim();
//                String tempAge = valueOf(row.getCell(1)).trim();
//                int age = Integer.valueOf(tempAge);
//                String gender = valueOf(row.getCell(2)).trim();
//                String address = valueOf(row.getCell(3)).trim();
//                String phone = valueOf(row.getCell(4)).trim();
//                String startDateString = valueOf(row.getCell(5)).trim();
//                Date startDate = new Date(formatter.parse(startDateString).getTime());
//                
//                NhanVienDTO nv = new NhanVienDTO();
//                nv.setName(name);
//                nv.setAge(age);
//                nv.setGender(gender);
//                nv.setAddress(address);
//                nv.setPhone(phone);
//                nv.setStart_day(startDate);
//                
//                NhanVienDTO temp = getEmployeeByPhone(nv.getPhone());
//                if(temp != null){
//                    nv.setId_NV(temp.getId_NV());
//                    set(nv);
//                }else {
//                    nvBUS.add(nv);
//                    add(nv);
//                }
//                
//            }
//    }
}
