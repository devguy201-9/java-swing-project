/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class SanPhamBUS {

    private List<SanPhamDTO> spBUS;

    public SanPhamBUS() {
        spBUS = null;
    }

    public List<SanPhamDTO> getSpBUS() {
        return spBUS;
    }

    public void list() {
        SanPhamDAO spDAO = new SanPhamDAO();
        spBUS = new ArrayList<>();
        spBUS = spDAO.findAll();
    }

    public void add(SanPhamDTO spDTO) {
        SanPhamDAO spDAO = new SanPhamDAO();
        try {
            spDTO.setId_SP(spDAO.save(spDTO));
            spBUS.add(spDTO);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public SanPhamDTO findOneByName(String name) {
        SanPhamDAO spDAO = new SanPhamDAO();
        SanPhamDTO sp = spDAO.getOneByName(name);

        return sp;
    }

    public List<SanPhamDTO> findAllByMaLoai(int id) {
        SanPhamDAO spDAO = new SanPhamDAO();
        List<SanPhamDTO> sps = spDAO.findAllByMaLoai(id);
        return sps;
    }

    public SanPhamDTO getOneById(int id) {
        SanPhamDAO spDAO = new SanPhamDAO();
        SanPhamDTO sp = spDAO.getOneById(id);
        return sp;
    }

    public void delete(String id) {
        int idSP = Integer.parseInt(id);
        for (SanPhamDTO spDTO : spBUS) {
            if (spDTO.getId_SP() == idSP) {
                spBUS.remove(spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.delete(idSP);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public void set(SanPhamDTO spDTO) {
        for (int i = 0; i < spBUS.size(); i++) {
            if (spBUS.get(i).getId_SP() == spDTO.getId_SP()) {
                spBUS.set(i, spDTO);
                SanPhamDAO spDAO = new SanPhamDAO();
                try {
                    spDAO.update(spDTO);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
    }

    public SanPhamDTO getSP(String masp) {
        for (SanPhamDTO sp : spBUS) {
            if (sp.getId_SP() == Integer.parseInt(masp)) {
                return sp;
            }
        }
        return null;
    }

    public boolean checkMasp(int masp) {
        for (SanPhamDTO sp : spBUS) {
            if (sp.getId_SP() == masp) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<SanPhamDTO> searchSP(int masp, int maloai, int max, int min) {
        ArrayList<SanPhamDTO> search = new ArrayList<>();

        for (SanPhamDTO sp : spBUS) {
            SanPhamDTO spTemp = null;
            if (masp == 0 && maloai == 0) {
                spTemp = sp;
            } else if (masp == 0) {
                if (sp.getId_Loai() == maloai) {
                    spTemp = sp;
                }
            } else if (maloai == 0) {
                if (sp.getId_SP() == masp) {
                    spTemp = sp;
                }
            }

            if (spTemp != null && spTemp.getPrice() >= min && spTemp.getPrice() <= max) {
                search.add(spTemp);
            }

        }
        return search;
    }

    public void exportProduct() {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Product");
        //set font , size and color
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        font.setColor(IndexedColors.BLUE.getIndex());

        // Create a CellStyle with the font
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(font);

        // Create a Row
        Row headerRow = sheet.createRow(0);
        String[] columns = {
            "Name",
            "Descrption",
            "Price",
            "Img"
        };

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum = 1;
        list();
        List<SanPhamDTO> employeeDTOs = getSpBUS();
        for (SanPhamDTO nv : employeeDTOs) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(nv.getName());
            row.createCell(1).setCellValue(nv.getDescrption());
            row.createCell(2).setCellValue(nv.getPrice());
            row.createCell(3).setCellValue(nv.getImg());
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        try {
            OutputStream os = new FileOutputStream(new File("./report/Product.xlsx"));
            workbook.write(os);
//     Closing stream;
            workbook.close();
            os.close();

        } catch (IOException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void importProduct(File file) throws FileNotFoundException, IOException, ParseException {
        FileInputStream in = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(in);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Row row;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);

            String name = valueOf(row.getCell(0)).trim();

            String tempIdType = valueOf(row.getCell(1)).trim();
            int idType = parseInt(tempIdType);

            String descrption = valueOf(row.getCell(2)).trim();

            String tempAmount = valueOf(row.getCell(3)).trim();
            int amount = parseInt(tempAmount);

            String tempPrice = valueOf(row.getCell(4)).trim();
            int price = parseInt(tempPrice);

            String img = valueOf(row.getCell(5)).trim();

            //set value 
            SanPhamDTO sp = new SanPhamDTO();
            sp.setId_Loai(idType);
            sp.setName(name);
            sp.setDescrption(descrption);
            sp.setPrice(price);
            sp.setImg(img);

            SanPhamDTO temp = findOneByName(sp.getName());
            if (temp != null) {
                sp.setId_SP(temp.getId_SP());
                set(sp);
            } else {
                spBUS.add(sp);
                add(sp);
            }

        }
    }

}
