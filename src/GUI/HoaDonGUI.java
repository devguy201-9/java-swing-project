/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.ct_HDBUS;
//import BUS.printBill;
import DTO.ct_HoaDonDTO;
import DTO.HoaDonDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class HoaDonGUI extends JPanel {

    private HoaDonBUS hdBUS = new HoaDonBUS();
    private ct_HDBUS ctBUS = new ct_HDBUS();
    private int DEFAULT_WIDTH;

    private JLabel lbMaHD, lbMaKH, lbMaNV, lbNgayHD, lbTongTien;
    private JTextField txtMaHD, txtMaKH, txtMaNV, txtNgayHD, txtTongTien;
    private JDateChooser dateChoice;

    private JButton btnDelete, btnView, btnBill, btnBack;

    private JTable tbl;
    private DefaultTableModel model;

    private Choice monthChoice, yearChoice;
    private JTextField txtMinPrice, txtMaxPrice, txtMaHDSearch;

    public HoaDonGUI(int width) {
        this.DEFAULT_WIDTH = width;
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFAULT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        /**
         * ********************* PHẦN VIEW THÔNG TIN
         * ****************************
         */
        JPanel itemView = new JPanel(null);
        itemView.setBackground(null);
        itemView.setBounds(new Rectangle(30, 40, this.DEFAULT_WIDTH - 200, 120));

        lbMaHD = new JLabel("Mã HD");
        lbMaHD.setFont(font1);
        lbMaHD.setBounds(0, 0, 55, 30);
        txtMaHD = new JTextField();
        txtMaHD.setFont(font0);
        txtMaHD.setBounds(new Rectangle(55, 0, 80, 30));
        txtMaHD.setEditable(false);
        itemView.add(lbMaHD);
        itemView.add(txtMaHD);

        lbMaKH = new JLabel("Mã KH");
        lbMaKH.setFont(font0);
        lbMaKH.setBounds(155, 0, 60, 30);
        txtMaKH = new JTextField();
        txtMaKH.setFont(font0);
        txtMaKH.setBounds(new Rectangle(215, 0, 80, 30));
        txtMaKH.setEditable(false);
        itemView.add(lbMaKH);
        itemView.add(txtMaKH);

        lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(315, 0, 60, 30);
        txtMaNV = new JTextField();
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(375, 0, 80, 30));
        txtMaNV.setEditable(false);
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);

        lbNgayHD = new JLabel("Ngày HD");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0, 40, 60, 30);
        txtNgayHD = new JTextField();
        txtNgayHD.setFont(font0);
        txtNgayHD.setBounds(new Rectangle(80, 40, 375, 30));
        txtNgayHD.setEditable(false);
        itemView.add(lbNgayHD);
        itemView.add(txtNgayHD);

        dateChoice = new JDateChooser();
        dateChoice.setBounds(new Rectangle(80, 40, 375, 30));
        dateChoice.setVisible(false);
        itemView.add(dateChoice);

        lbTongTien = new JLabel("Tổng Tiền");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(0, 80, 60, 30);
        txtTongTien = new JTextField();
        txtTongTien.setFont(font0);
        txtTongTien.setBounds(new Rectangle(80, 80, 375, 30));
        txtTongTien.setEditable(false);
        itemView.add(lbTongTien);
        itemView.add(txtTongTien);

        JSeparator sepHD = new JSeparator(0);
        sepHD.setBounds(new Rectangle(0, 180, this.DEFAULT_WIDTH - 350, 3));
        add(sepHD);

        add(itemView);

        /**
         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
         * *******************
         */
        Font font2 = new Font("Tahoma", Font.PLAIN, 25);
        //        btnEdit,btnDelete,btnConfirm,btnBack,btnView
        
        btnDelete = new JButton("XÓA");        
        btnBack = new JButton("QUAY LẠI");
        btnView = new JButton("CHI TIẾT HD");
        btnBill = new JButton("IN BILL");
        

        //font chữ
        btnBill.setFont(font2);
        btnBill.setForeground(Color.WHITE);        
        btnDelete.setFont(font2);
        btnDelete.setForeground(Color.WHITE);        
        btnBack.setFont(font2);
        btnBack.setForeground(Color.WHITE);
        btnView.setFont(font2);
        btnView.setForeground(Color.WHITE);

        
        
        //màu nền
        Color color = new Color(255, 218, 121);
        btnBill.setBackground(color);
        btnDelete.setBackground(color);
        btnBack.setBackground(color);
        btnView.setBackground(color);
        
        
        //viền
        btnBill.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnDelete.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnView.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        
        
        
//        btnDelete = new JLabel(new ImageIcon(("./src/image/btnDelete.png")));
        btnDelete.setBounds(new Rectangle(500, 60, 200, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnView = new JLabel(new ImageIcon(("./src/image/btnView.png")));
        btnView.setBounds(new Rectangle(730, 0, 200, 50));
        btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnBill = new JLabel(new ImageIcon(("./src/image/btnBill.png")));
        btnBill.setBounds(new Rectangle(730, 60, 200, 50));
        btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));

//        btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(500, 60, 200, 50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        itemView.add(btnDelete);
        itemView.add(btnView);
        itemView.add(btnBill);

        itemView.add(btnBack);

        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtMaHD.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xóa !!!", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    hdBUS.delete(txtMaHD.getText());
//                    ctBUS.delete(txtMaHD.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<HoaDonDTO>) hdBUS.getHdBUS());
                }
            }
        });

        // Xem Chi Tiết HD              
        btnView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaHD.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xem !!!", "Thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                CT_HoaDonGUI chitiet = new CT_HoaDonGUI(txtMaHD.getText());
            }
        });

        // In Bill
        btnBill.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int maHD = Integer.parseInt(txtMaHD.getText());
                int maKH = Integer.parseInt(txtMaKH.getText());
                int maNv = Integer.parseInt(txtMaNV.getText());
                Timestamp ngayLap = Timestamp.valueOf(txtNgayHD.getText());
                float tongTien = Float.parseFloat(txtTongTien.getText());
                HoaDonDTO hd = new HoaDonDTO(maHD, maKH, maNv, tongTien, ngayLap);
                ArrayList<ct_HoaDonDTO> cthd = (ArrayList<ct_HoaDonDTO>) ctBUS.getCt_hdBUS();
//                printBill bill = new printBill(hd, cthd);
//                bill.print();
            }
        });

        //Button Back
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                isEdit(false);
                Date time = Timestamp.valueOf(txtNgayHD.getText());
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(time.getTime());

                if (dateChoice.getCalendar() != null) {
                    int dd = dateChoice.getCalendar().get(Calendar.DATE);
                    int mm = dateChoice.getCalendar().get(Calendar.MONTH);
                    int yyy = dateChoice.getCalendar().get(Calendar.YEAR);
                    calendar.set(yyy, mm, dd);
                    Timestamp newTime = new Timestamp(calendar.getTime().getTime());
                    System.out.println(newTime);
                    txtNgayHD.setText(newTime.toString());
                }
            }
        });

        /**
         * **************** TẠO MODEL VÀ HEADER
         * ********************************************
         */
        Vector header = new Vector();
        header.add("Mă Hóa Đơn");
        header.add("Mă Khách hàng");
        header.add("Mã Nhân Viên");
        header.add("Ngày Lập HD");
        header.add("Tổng Tiền");
        model = new MyTable(header, 5);
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list(); //Đọc từ database lên table 
        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(40);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(4).setCellRenderer(centerAlign);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 270, this.DEFAULT_WIDTH - 400, 400));
        scroll.setBackground(null);

        add(scroll);

        //Nhấp vào dòng nào là đẩy data lên textfield
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tbl.getSelectedRow();
                if (i == -1) {
                    return;
                }
                if (tbl.getRowSorter() != null) {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                txtMaHD.setText(tbl.getModel().getValueAt(i, 0).toString());
                try {
                    txtMaKH.setText(tbl.getModel().getValueAt(i, 1).toString());
                } catch (NullPointerException ex) {
                    txtMaKH.setText("");
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 2).toString());
                txtNgayHD.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtTongTien.setText(tbl.getModel().getValueAt(i, 4).toString());
            }
        });
        /**
         * ********************* SORT TABLE ****************************
         */
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30, 170, this.DEFAULT_WIDTH - 400, 140);

        /**
         * ****** SORT THỜI GIAN *************
         */
        JLabel sortTime = new JLabel("Thời gian :");
        sortTime.setFont(font0);
        sortTime.setBounds(0, 40, 80, 30);
        sort.add(sortTime);
        // Choice Tháng
        int month = Calendar.getInstance().get(Calendar.MONTH);// Lấy tháng hiện tại
        monthChoice = new Choice();
        monthChoice.setFont(font0);
        monthChoice.add("Không");
        for (int i = 1; i <= 12; i++) {
            monthChoice.add("Tháng " + i);
        }
        monthChoice.select(0);
        monthChoice.setBounds(new Rectangle(80, 42, 90, 40));
        sort.add(monthChoice);
        // Choice Năm
        int year = Calendar.getInstance().get(Calendar.YEAR);//Lấy năm hiện tại
        yearChoice = new Choice();
        yearChoice.setFont(font0);
        yearChoice.add("Không");
        for (int i = year; i >= 1999; i--) {
            yearChoice.add(String.valueOf(i));
        }
        yearChoice.select(0);
        yearChoice.setBounds(new Rectangle(170, 42, 80, 40));
        sort.add(yearChoice);

        /**
         * ********** SORT THEO GIÁ **************
         */
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(300, 40, 80, 30);
        sort.add(sortPrice);

        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(380, 42, 100, 26));
        txtMinPrice.setInputVerifier(new MyInputVerifier());
        sort.add(txtMinPrice);

        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(490, 56, 10, 6);
        sort.add(sepPrice);

        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(510, 42, 100, 26));
        txtMaxPrice.setInputVerifier(new MyInputVerifier());
        sort.add(txtMaxPrice);
        /**
         * ********** SORT MÃ SP **************
         */
        JLabel sortHD = new JLabel("Mã hd:");
        sortHD.setFont(font0);
        sortHD.setBounds(650, 40, 60, 30);
        sort.add(sortHD);

        txtMaHDSearch = new JTextField();
        txtMaHDSearch.setFont(font0);
        txtMaHDSearch.setBounds(new Rectangle(700, 42, 100, 26));
        txtMaHDSearch.setInputVerifier(new MyInputVerifier());
        sort.add(txtMaHDSearch);
//        /******************************************/
        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840, 20, 63, 63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                txtTongTien.requestFocus();
                search();
            }
        });
        sort.add(btnSearch);

        add(sort);
    }

    public void search() {
        int maHD = txtMaHDSearch.getText().equals("") ? 0 : Integer.parseInt(txtMaHDSearch.getText());
        int mm = monthChoice.getSelectedIndex() - 1;
        int yyyy;
        try {
            yyyy = Integer.parseInt(yearChoice.getSelectedItem());
        } catch (NumberFormatException ex) {
            yyyy = 0;
        }
        double max = txtMaxPrice.getText().equals("") ? 99999999 : Double.parseDouble(txtMaxPrice.getText());
        double min = txtMinPrice.getText().equals("") ? 0 : Double.parseDouble(txtMinPrice.getText());

        outModel(model, hdBUS.search(mm, yyyy, max, min, maHD));
    }

    public void cleanView() {
        txtMaHD.setText("");
        txtMaKH.setText("");
        txtMaNV.setText("");
        txtNgayHD.setText("");
        txtTongTien.setText("");
    }

    public void outModel(DefaultTableModel model, ArrayList<HoaDonDTO> hd) {     //xuat tu arraylist len table
        Vector data;
        model.setRowCount(0);
        for (HoaDonDTO h : hd) {
            data = new Vector();
            data.add(h.getId());
            data.add(h.getId_KH());
            data.add(h.getId_NV());
            data.add(h.getCreate_day());
            data.add(h.getTotal_money());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void list() // Chép ArrayList lên table
    {
        if (hdBUS.getHdBUS() == null) {
            hdBUS.list();
        }
        ArrayList<HoaDonDTO> hd = (ArrayList<HoaDonDTO>) hdBUS.getHdBUS();
        model.setRowCount(0);
        outModel(model, hd);
    }

}
