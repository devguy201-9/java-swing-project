/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ct_HDBUS;
import DTO.ct_HoaDonDTO;
import com.kingaspx.toast.util.Toast;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class CT_HoaDonGUI extends JFrame {

    private ct_HDBUS ctBUS = new ct_HDBUS();
    private String mahd;
    private JTextField txtMaSP, txtSL, txtDonGia;
    private DefaultTableModel model;
    private JTable tbl;
    private int DWIDTH = 840;
    private JTextField txtTenSP;

    public CT_HoaDonGUI(String mahd) {
        this.mahd = mahd;
        init();
    }

    public void init() {
        setTitle("Chi tiết hóa đơn");
        setSize(DWIDTH, 450);
        getContentPane().setBackground(new Color(25, 25, 34));
        setLayout(null);
        setLocationRelativeTo(null);

        Font ftitle = new Font("Segoe UI", Font.BOLD, 25);
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        //HEADER
        JLabel title = new JLabel("CHI TIẾT HÓA ĐƠN  " + mahd, JLabel.CENTER);
        title.setFont(ftitle);
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, DWIDTH, 60);
        add(title);
        /**
         * *************** PHẦN HIỂN THỊ THÔNG TIN **************************
         */
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(0, 60, this.getSize().width, this.getSize().height - 150));
        itemView.setBackground(new Color(223, 230, 233));

        JLabel lbMaSP = new JLabel("Mã sản phẩm ");
        lbMaSP.setFont(font0);
        lbMaSP.setBounds(20, 20, 100, 30);
        txtMaSP = new JTextField();
        txtMaSP.setBounds(new Rectangle(120, 20, 210, 30));
        itemView.add(lbMaSP);
        itemView.add(txtMaSP);
        txtMaSP.setEditable(false);

        JLabel lbTenSP = new JLabel("Tên sản phẩm ");
        lbTenSP.setFont(font0);
        lbTenSP.setBounds(20, 60, 100, 30);
        txtTenSP = new JTextField();
        txtTenSP.setBounds(new Rectangle(120, 60, 210, 30));
        itemView.add(lbTenSP);
        itemView.add(txtTenSP);
        txtTenSP.setEditable(false);

        JLabel lbSL = new JLabel("Số lượng ");
        lbSL.setFont(font0);
        lbSL.setBounds(20, 100, 100, 30);
        txtSL = new JTextField();
        txtSL.setBounds(new Rectangle(120, 100, 210, 30));
        itemView.add(lbSL);
        itemView.add(txtSL);
        txtSL.setEditable(false);

        JLabel lbDonGia = new JLabel("Đơn giá ");
        lbDonGia.setFont(font0);
        lbDonGia.setBounds(20, 140, 100, 30);
        txtDonGia = new JTextField();
        txtDonGia.setBounds(new Rectangle(120, 140, 210, 30));
        itemView.add(lbDonGia);
        itemView.add(txtDonGia);
        txtDonGia.setEditable(false);
        /**
         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
         * *******************
         */

        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete_150px.png"));
        btnDelete.setBounds(new Rectangle(80, 180, 150, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        itemView.add(btnDelete);

        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtMaSP.getText().equals("")) {
                    new Toast.ToastWarning("Vui lòng chọn chi tiết hóa đơn cần xóa !!!", Toast.SHORT_DELAY);
                    return;
                }
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    ctBUS.deleteMaSP(txtMaSP.getText());
                    new Toast.ToastSuccessful("Thành công","Xóa chi tiết hóa đơn thành công !!!",Toast.SHORT_DELAY);
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<ct_HoaDonDTO>) ctBUS.getCt_hdBUS());
                }
            }
        });
        /**
         * ************** TẠO TABLE
         * ***********************************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************************
         */
        Vector header = new Vector();
        header.add("Mă SP");
        header.add("Tên SP");
        header.add("Số lượng");
        header.add("Đơn giá");
        model = new MyTable(header, 4);
        tbl = new JTable(model);
        list(); //Đọc từ database lên table 
        /**
         * ****** CUSTOM TABLE ***************
         */
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);

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
        scroll.setBounds(new Rectangle(350, 20, this.getSize().width - 400, this.getSize().height - 180));
        scroll.setBackground(null);

        itemView.add(scroll);

        add(itemView);

        tbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ctBUS.getCt_hdBUS().isEmpty()) {
                    int i = tbl.getSelectedRow();
                    if (i == -1) {
                        return;
                    }
                    txtMaSP.setText(tbl.getModel().getValueAt(i, 0).toString());
                    txtTenSP.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtSL.setText(tbl.getModel().getValueAt(i, 2).toString());
                    txtDonGia.setText(tbl.getModel().getValueAt(i, 3).toString());
                }
            }
        });
        setVisible(true);

    }

    public void cleanView() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtSL.setText("");
        txtDonGia.setText("");
    }

    public void outModel(DefaultTableModel model, ArrayList<ct_HoaDonDTO> hd) {     //xuat tu arraylist len table
        Vector data;
        model.setRowCount(0);
        for (ct_HoaDonDTO h : hd) {
            data = new Vector();
            data.add(h.getId_SP());
            data.add(h.getName());
            data.add(h.getAmount());
            data.add(h.getPrice());
            data.add(h.getId_HD());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void list() // Chép ArrayList lên table
    {
        if (ctBUS.getCt_hdBUS() == null) {
            ctBUS.listMaHD(mahd);
        }
        ArrayList<ct_HoaDonDTO> cthd = (ArrayList<ct_HoaDonDTO>) ctBUS.getCt_hdBUS();
        model.setRowCount(0);
        outModel(model, cthd);
    }

}
