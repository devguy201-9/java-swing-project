/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DTO.HoaDonDTO;
import DTO.ct_HoaDonDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class printBill {

    private String file = "./report/test.pdf";
    private ArrayList<ct_HoaDonDTO> cthd = new ArrayList<ct_HoaDonDTO>();
    private HoaDonDTO hd;
    private BaseFont bf;

    public printBill(HoaDonDTO hd, ArrayList<ct_HoaDonDTO> cthd) {
        this.hd = hd;
        file = "./report/bill" + hd.getId() + ".pdf";
        this.cthd = cthd;
        print();
    }

    public void print() {
        String uderline = "*";
        try {
            bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Document bill = new Document(PageSize.A4, 15, 15, 10, 10);
            String line = "";
            for (int i = 0; i < bill.getPageSize().getWidth() / 5; i++) {
                line += uderline;
            }
            PdfWriter.getInstance(bill, new FileOutputStream(file));
            bill.open();
            Paragraph header = new Paragraph("Coffee", new Font(bf, 35));
            header.setAlignment(1);
            bill.add(header);
            Paragraph info = new Paragraph("Hóa dơn : " + hd.getId() + "          Ngày : " + hd.getCreate_day(), new Font(bf, 15));
            bill.add(info);
            Paragraph l = new Paragraph(line);
            l.setAlignment(1);
            bill.add(l);
            
            //table
            String[] cellHeader = {"Mã SP", "Tên SP", "SL", "Đơn Giá (VNĐ)"};

            PdfPTable t = new PdfPTable(cellHeader.length);
            t.setSpacingAfter(10);
            t.setSpacingBefore(10);
            int[] relativeWidths = {20, 80, 10, 40};
            t.setWidths(relativeWidths);

            for (String s : cellHeader) {
                t.addCell(createCell(s, new Font(bf, 13)));
            }

            for (ct_HoaDonDTO ct : cthd) {
                t.addCell(createCell(Integer.toString(ct.getId_SP())));
//                t.addCell(createCell(ct.getTenSP()));
                t.addCell(createCell(String.valueOf(ct.getPrice())));
                t.addCell(createCell(String.valueOf(ct.getAmount())));
                t.addCell(createCell(String.valueOf(ct.getTotal_money())));
            }
            bill.add(t);
            bill.add(l);

            Paragraph sum = new Paragraph("Tồng tiền : " + hd.getTotal_remaining_money() + "đ", new Font(bf, 20));
            sum.setAlignment(Element.ALIGN_RIGHT);
            bill.add(sum);

            bill.close();

//            JOptionPane.showMessageDialog(null, "In hoàn tất");
            System.out.println("Done");
        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public PdfPCell createCell(String s) {
        PdfPCell cell = new PdfPCell(new Phrase(s, new Font(bf, 13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }

    public PdfPCell createCell(String s, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(s, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
}
