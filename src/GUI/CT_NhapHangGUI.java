/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NguyenLieuBUS;
import BUS.PhieuNhapHangBUS;
import BUS.ct_PhieuNhapHangBUS;
import DTO.NguyenLieuDTO;
import DTO.PhieuNhapHangDTO;
import DTO.ct_PhieuNhapHangDTO;
import com.kingaspx.toast.util.Toast;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
class CT_NhapHangGUI extends JFrame implements ActionListener {

    private ct_PhieuNhapHangBUS ctBUS = new ct_PhieuNhapHangBUS();
    private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
    private NguyenLieuBUS nlBUS = new NguyenLieuBUS();
    private int maPhieuPhapHang;
    private int maNV, maNCC;
    private JTextField txtMaNL, txtSL, txtGiaBan, txtThanhTien;
    private DefaultTableModel model;
    private JTable tbl;
    private int DWIDTH = 840;
    private JTextField txtTenNL;
    private JButton btnCancel;
    private boolean flag = true;

    public CT_NhapHangGUI(String maPhieuPhapHang) {
        this.maPhieuPhapHang = Integer.parseInt(maPhieuPhapHang.trim());
        flag = false;
        ctBUS.listByCode(Integer.parseInt(maPhieuPhapHang.trim()));
        init();
    }

    CT_NhapHangGUI(int maNV, int maNCC) {
        this.maNV = maNV;
        this.maNCC = maNCC;
        PhieuNhapHangDTO pnh = new PhieuNhapHangDTO(maNCC, maNV, LocalDate.now(), 0.0f);
        pnhBUS.add(pnh);
        maPhieuPhapHang = pnhBUS.getPnhBUS().get(0).getId_PNH();
        init();
    }

    public void init() {
        nlBUS.list();
        setTitle("Chi tiết phiếu nhập");
        setSize(DWIDTH, 450);
        getContentPane().setBackground(new Color(25, 25, 34));
        setLayout(null);
        setLocationRelativeTo(null);

        Font ftitle = new Font("Segoe UI", Font.BOLD, 25);
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        //HEADER
        JLabel title = new JLabel("CHI TIẾT PHIẾU NHẬP HÀNG " + maPhieuPhapHang, JLabel.CENTER);
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

        JLabel lbMaNL = new JLabel("Mã nguyên liệu ");
        lbMaNL.setFont(font0);
        lbMaNL.setBounds(20, 20, 100, 30);
        txtMaNL = new JTextField();
        txtMaNL.setBounds(new Rectangle(120, 20, 210, 30));
        txtMaNL.setEditable(flag);
        txtMaNL.setInputVerifier(new MyInputVerifier());
        itemView.add(lbMaNL);
        itemView.add(txtMaNL);

        JLabel lbSL = new JLabel("Số lượng ");
        lbSL.setFont(font0);
        lbSL.setBounds(20, 60, 100, 30);
        txtSL = new JTextField();
        txtSL.setEditable(flag);
        txtSL.setBounds(new Rectangle(120, 60, 210, 30));
        txtSL.setInputVerifier(new MyInputVerifier());
        itemView.add(lbSL);
        itemView.add(txtSL);

        JLabel lbTenNL = new JLabel("Tên guyên liệu ");
        lbTenNL.setFont(font0);
        lbTenNL.setBounds(20, 100, 100, 30);
        txtTenNL = new JTextField();
        txtTenNL.setBounds(new Rectangle(120, 100, 210, 30));
        txtTenNL.setEditable(false);
        itemView.add(lbTenNL);
        itemView.add(txtTenNL);

        JLabel lbGiaBan = new JLabel("Giá bán ");
        lbGiaBan.setFont(font0);
        lbGiaBan.setBounds(20, 140, 100, 30);
        txtGiaBan = new JTextField();
        txtGiaBan.setBounds(new Rectangle(120, 140, 210, 30));
        txtGiaBan.setEditable(false);
        itemView.add(lbGiaBan);
        itemView.add(txtGiaBan);

        /**
         * ************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL
         * *******************
         */
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd_150px.png"));
        btnAdd.setBounds(new Rectangle(20, 180, 150, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.setVisible(flag);

        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete_150px.png"));
        btnDelete.setBounds(new Rectangle(180, 180, 150, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.setVisible(flag);

        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setBounds(new Rectangle(10, 240, 185, 40));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirm.setVisible(flag);

        btnCancel = new JButton("Hủy nhập hàng");
        btnCancel.setBackground(new Color(255, 102, 102));
        btnCancel.setBounds(new Rectangle(210, 240, 130, 40));
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.addActionListener(this);
        btnCancel.setVisible(flag);

        itemView.add(btnAdd);
        itemView.add(btnConfirm);
        itemView.add(btnDelete);
        itemView.add(btnCancel);

        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaNL.getText().equals("")) {
                    new Toast.ToastWarning("Vui lòng chọn mã nguyên liệu !!!", Toast.SHORT_DELAY);
                    return;
                }
                txtTenNL.requestFocus();
                int maNL = 0;
                int sl = 0;
                try {
                    maNL = Integer.parseInt(txtMaNL.getText());
                    sl = Integer.parseInt(txtSL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }

                int mess = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (mess == 0) { //yes
                    boolean flag = false;
                    int soLuong = Math.abs(sl);
                    boolean flag2 = false;

                    if (ctBUS.getCt_pnhBUS() != null) {
                        for (int i = 0; i < ctBUS.getCt_pnhBUS().size(); i++) {
                            if (ctBUS.getCt_pnhBUS().get(i).getId_NL() == maNL) {
                                flag = true;
                                if (ctBUS.getCt_pnhBUS().get(i).getAmount() >= soLuong) {
                                    flag2 = true;
                                    break;
                                }
                                break;
                            }
                        }
                    } else {
                        new Toast.ToastError("Chưa có nguyên liệu nào được nhập !!!, xóa thấy bại", Toast.SHORT_DELAY);
                        return;
                    }

                    if (!flag) {
                        new Toast.ToastError("Không tìm thấy mã nguyên liệu trong bảng nguyên liệu đã thêm, vui lòng nhập lại !!!i", Toast.SHORT_DELAY);
                        return;
                    }

                    if (!flag2) {
                        new Toast.ToastError("Số lượng nguyên liệu cần xóa vượt quá số lượng nguyên liệu mà bạn đã nhập , vui lòng nhập lại !!!", Toast.SHORT_DELAY);
                        return;
                    }

                    NguyenLieuDTO nl = null;
                    for (NguyenLieuDTO nguyenLieuDTO : nlBUS.getNlBUS()) {
                        if (nguyenLieuDTO.getId_NL() == maNL) {
                            nl = nguyenLieuDTO;
                        }
                    }
                    for (int i = 0; i < ctBUS.getCt_pnhBUS().size(); i++) {
                        if (ctBUS.getCt_pnhBUS().get(i).getId_NL() == maNL) {
                            if (ctBUS.getCt_pnhBUS().get(i).getAmount() == soLuong) {
                                ctBUS.deleteByCode(maPhieuPhapHang, maNL);
                                break;
                            }
                            ctBUS.getCt_pnhBUS().get(i).setAmount(ctBUS.getCt_pnhBUS().get(i).getAmount() - soLuong);
                            float tongGia = (float) (soLuong * 1.0 * nl.getPrice());
                            ctBUS.getCt_pnhBUS().get(i).setTotal_money(ctBUS.getCt_pnhBUS().get(i).getTotal_money() - tongGia);
                            ctBUS.set(ctBUS.getCt_pnhBUS().get(i));
                        }
                    }
                    nlBUS.subtractAmount(nl, soLuong);
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<ct_PhieuNhapHangDTO>) ctBUS.getCt_pnhBUS());

                }
            }
        });

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaNL.getText().equals("") || txtSL.getText().equals("")) {
                    new Toast.ToastWarning("Vui lòng nhập đầy đủ thông tin !!!", Toast.SHORT_DELAY);
                    return;
                }
                txtTenNL.requestFocus();
                int maNL = 0;
                try {
                    maNL = Integer.parseInt(txtMaNL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }
                boolean flag = false;
                NguyenLieuDTO nl = null;
                for (NguyenLieuDTO nguyenLieuDTO : nlBUS.getNlBUS()) {
                    if (maNL == nguyenLieuDTO.getId_NL()) {
                        flag = true;
                        nl = nguyenLieuDTO;
                        break;
                    }
                }
                if (!flag) {
                    new Toast.ToastError("Không tìm thấy mã nguyên liệu, vui lòng nhập lại !!!", Toast.SHORT_DELAY);
                    return;
                }
                int sl = 0;
                try {
                    sl = Integer.parseInt(txtSL.getText());
                } catch (NumberFormatException exc) {
                    return;
                }

                int soLuong = Math.abs(sl);
                float tongGia = (float) (soLuong * 1.0 * nl.getPrice());
                boolean updateOrAdd = false;

                if (ctBUS.getCt_pnhBUS() != null) {
                    for (int i = 0; i < ctBUS.getCt_pnhBUS().size(); i++) {
                        if (ctBUS.getCt_pnhBUS().get(i).getId_NL() == maNL) {
                            ctBUS.getCt_pnhBUS().get(i).setAmount(ctBUS.getCt_pnhBUS().get(i).getAmount() + soLuong);
                            ctBUS.getCt_pnhBUS().get(i).setTotal_money(ctBUS.getCt_pnhBUS().get(i).getTotal_money() + tongGia);
                            ctBUS.set(ctBUS.getCt_pnhBUS().get(i));
                            updateOrAdd = true;
                            break;
                        }
                    }
                }

                if (!updateOrAdd) {
                    ct_PhieuNhapHangDTO ctNhapHangDTO = new ct_PhieuNhapHangDTO(maPhieuPhapHang, maNL, soLuong, tongGia, nl.getPrice());
                    ctBUS.add(ctNhapHangDTO);
                }

                nlBUS.addAmount(nl, soLuong);
                cleanView();
                tbl.clearSelection();
                outModel(model, (ArrayList<ct_PhieuNhapHangDTO>) ctBUS.getCt_pnhBUS());
            }
        });

        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PhieuNhapHangDTO pnhdto = pnhBUS.getPnhBUS().get(0);
                float thanhTien = 0.f;
                for (ct_PhieuNhapHangDTO phieuNhapHangDTO : ctBUS.getCt_pnhBUS()) {
                    thanhTien += phieuNhapHangDTO.getTotal_money();
                }
                pnhdto.setTotal_money(thanhTien);
                pnhBUS.set(pnhdto);
                new Toast.ToastSuccessful("Thành công", "Nhập hàng thành công !!!", Toast.SHORT_DELAY);
                dispose();
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
        header.add("Mă NL");
        header.add("Số lượng");
        header.add("Giá");
        header.add("Thành tiền");
        model = new MyTable(header, 5);
        tbl = new JTable(model);
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
        if (ctBUS.getCt_pnhBUS() != null && !ctBUS.getCt_pnhBUS().isEmpty()) {
            outModel(model, (ArrayList<ct_PhieuNhapHangDTO>) ctBUS.getCt_pnhBUS());
        }
        add(itemView);
        /**
         * ***********************************
         */
        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    int i = tbl.getSelectedRow();
                    String maNL = tbl.getModel().getValueAt(i, 0).toString();
                    txtMaNL.setText(maNL);
                    String nameString = "";
                    for (NguyenLieuDTO nguyenLieuDTO : nlBUS.getNlBUS()) {
                        if (nguyenLieuDTO.getId_NL() == Integer.parseInt(maNL)) {
                            nameString = nguyenLieuDTO.getName();
                            break;
                        }
                    }
                    txtTenNL.setText(nameString);
                    txtSL.setText(tbl.getModel().getValueAt(i, 1).toString());
                    txtGiaBan.setText(tbl.getModel().getValueAt(i, 2).toString());
                } catch (Exception exc) {
                    return;
                }
            }
        });
        setVisible(true);
    }

    public void cleanView() {
        txtMaNL.setText("");
        txtTenNL.setText("");
        txtSL.setText("");
        txtGiaBan.setText("");
    }

    public void outModel(DefaultTableModel model, ArrayList<ct_PhieuNhapHangDTO> ctpnh) {     //xuat tu arraylist len table
        Vector data;
        model.setRowCount(0);
        for (ct_PhieuNhapHangDTO h : ctpnh) {
            data = new Vector();
            data.add(h.getId_NL());
            data.add(h.getAmount());
            data.add(h.getPrice());
            data.add(h.getTotal_money());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public PhieuNhapHangDTO getDTOContent() {
        return pnhBUS.getPnhBUS().get(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            int mess = JOptionPane.showConfirmDialog(null, "Xác nhận hủy nhập hàng", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (mess == 0) { //yes

                for (int i = 0; i < ctBUS.getCt_pnhBUS().size(); i++) {
                    for (NguyenLieuDTO nguyenLieuDTO : nlBUS.getNlBUS()) {
                        if (nguyenLieuDTO.getId_NL() == ctBUS.getCt_pnhBUS().get(i).getId_NL()) {
                            nlBUS.subtractAmount(nguyenLieuDTO, ctBUS.getCt_pnhBUS().get(i).getAmount());
                            break;
                        }
                    }
                }

                ctBUS.delete(maPhieuPhapHang);
                pnhBUS.delete(maPhieuPhapHang);
                new Toast.ToastSuccessful("Thành công", "Hủy phiếu nhập hàng thành công !!!", Toast.SHORT_DELAY);
                dispose();
            }
        }
    }
}
