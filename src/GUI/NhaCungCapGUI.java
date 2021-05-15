/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NCCBUS;
import DTO.NhaCungCapDTO;
import com.kingaspx.toast.util.Toast;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class NhaCungCapGUI extends JPanel {

    private NCCBUS nccBUS = new NCCBUS();
    private JTable tbl;
    private JLabel lbMaNCC, lbTenNCC, lbDienThoai, lbSoFax, lbDiaChi, iconSearch;
    private JTextField txtMaNCC, txtTenNCC, txtDiaChi, txtDienThoai, txtSearch;
    JComboBox cmbChoice;
    private DefaultTableModel model;
    private int DEFAULT_WIDTH;
    private boolean EditOrAdd = true;  //gan co cho EditAdd
    private JButton btnAdd, btnEdit, btnConfirm, btnBack, btnFile;

    private boolean tableSelectionActive = true;

    public NhaCungCapGUI(int width) {
        DEFAULT_WIDTH = width;
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, DEFAULT_WIDTH - 220, 1000));

        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);

        /**
         * **************************** PHẦN HIỂN THỊ THÔNG TIN
         * *****************************************
         */
        JPanel itemView = new JPanel(null);
        itemView.setBounds(new Rectangle(30, 40, DEFAULT_WIDTH - 950, 600));
        itemView.setBackground(new Color(247, 241, 227));

        /**
         * ****** Tao Cac Label & TextField ***********************
         */
        lbMaNCC = new JLabel("Mã NCC");
        lbMaNCC.setFont(font1);
        lbMaNCC.setBounds(new Rectangle(0, 0, 200, 30));
        txtMaNCC = new JTextField("");
        txtMaNCC.setFont(font0);
        txtMaNCC.setBorder(null);
        txtMaNCC.setBounds(new Rectangle(110, 0, 220, 30));
        txtMaNCC.setEditable(false);

        lbTenNCC = new JLabel("Tên NCC");
        lbTenNCC.setFont(font1);
        lbTenNCC.setBounds(new Rectangle(0, 40, 200, 30));
        txtTenNCC = new JTextField("");
        txtTenNCC.setFont(font0);
        txtTenNCC.setBorder(null);
        txtTenNCC.setBounds(new Rectangle(110, 40, 220, 30));

        lbDiaChi = new JLabel("Địa chỉ");
        lbDiaChi.setFont(font1);
        lbDiaChi.setBounds(new Rectangle(0, 80, 200, 30));
        txtDiaChi = new JTextField("");
        txtDiaChi.setFont(font0);
        txtDiaChi.setBorder(null);
        txtDiaChi.setBounds(new Rectangle(110, 80, 220, 30));

        lbDienThoai = new JLabel("Số điện thoại");
        lbDienThoai.setFont(font1);
        lbDienThoai.setBounds(new Rectangle(0, 120, 200, 30));
        txtDienThoai = new JTextField("");
        txtDienThoai.setFont(font0);
        txtDienThoai.setBorder(null);
        txtDienThoai.setBounds(new Rectangle(110, 120, 220, 30));

        //  THÊM VÀO PHẦN HIỆN THỊ
        itemView.add(lbMaNCC);
        itemView.add(txtMaNCC);
        itemView.add(lbTenNCC);
        itemView.add(txtTenNCC);
        itemView.add(lbDiaChi);
        itemView.add(txtDiaChi);
        itemView.add(lbDienThoai);
        itemView.add(txtDienThoai);

        add(itemView);

        /**
         * ************** TẠO CÁC BTN THÊM ,XÓA, SỬA *******************
         */
        Font font2 = new Font("Tahoma", Font.PLAIN, 25);
        //        btnEdit,btnDelete,btnConfirm,btnBack,btnFile
        btnAdd = new JButton("THÊM");
        btnEdit = new JButton("SỬA");
        btnConfirm = new JButton("XÁC NHẬN");
        btnBack = new JButton("QUAY LẠI");
        btnFile = new JButton("CHỌN ẢNH");

        //font chữ
        btnAdd.setFont(font2);
        btnAdd.setForeground(Color.WHITE);
        btnEdit.setFont(font2);
        btnEdit.setForeground(Color.WHITE);
        btnConfirm.setFont(font2);
        btnConfirm.setForeground(Color.WHITE);
        btnBack.setFont(font2);
        btnBack.setForeground(Color.WHITE);
        btnFile.setFont(font2);
        btnFile.setForeground(Color.WHITE);

        //màu nền
//        Color colorAdd = new Color(85, 239, 196);
//        btnAdd.setBackground(colorAdd);
//        Color colorEdit = new Color(196, 69, 105);
//        btnEdit.setBackground(colorEdit);
//        Color colorDelete = new Color(56, 103, 214);
//        btnDelete.setBackground(colorDelete);
//        Color colorConfirm = new Color(250, 130, 49);
//        btnConfirm.setBackground(colorConfirm);
//        Color colorBack = new Color(181, 52, 113);
//        btnBack.setBackground(colorBack);
//        Color colorFile = new Color(60, 64, 198);
//        btnFile.setBackground(colorFile);
        //màu nền
        Color color = new Color(255, 218, 121);
        btnAdd.setBackground(color);
        btnEdit.setBackground(color);
        btnConfirm.setBackground(color);
        btnBack.setBackground(color);
        btnFile.setBackground(color);

        //viền
        btnAdd.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnEdit.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnConfirm.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnBack.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));
        btnFile.setBorder(createLineBorder(new Color(134, 64, 0), 5, true));

        //icon
        JLabel lbAdd = new JLabel(new ImageIcon("./src/image/add-icon.png"));
        lbAdd.setBounds(new Rectangle(0, 0, 50, 50));
        btnAdd.add(lbAdd);

        JLabel lbEdit = new JLabel(new ImageIcon("./src/image/icons8-gear-32.png"));
        lbEdit.setBounds(new Rectangle(0, 0, 50, 50));
        btnEdit.add(lbEdit);

        JLabel lbDelete = new JLabel(new ImageIcon("./src/image/icons8-delete-32.png"));
        lbDelete.setBounds(new Rectangle(0, 0, 50, 50));

        //vị trí
        btnAdd.setBounds(new Rectangle(110, 250, 200, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEdit.setBounds(new Rectangle(110, 320, 200, 50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(110, 250, 200, 50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(110, 320, 200, 50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //THÊM VÀO PHẦN HIỂN THỊ
        itemView.add(btnAdd);
        itemView.add(btnEdit);
        itemView.add(btnConfirm);
        itemView.add(btnBack);

        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditOrAdd = true;

                cleanView();
                setEdit(true);
                btnAdd.setVisible(!EditOrAdd);
                btnEdit.setVisible(!EditOrAdd);

                btnConfirm.setVisible(EditOrAdd);
                btnBack.setVisible(EditOrAdd);
                tbl.setEnabled(!EditOrAdd);
                tableSelectionActive = false;
            }
        });

        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtMaNCC.getText().equals("")) {
                    new Toast.ToastWarning("Vui lòng chọn nhà cung cấp cần sửa !!!", Toast.SHORT_DELAY);
                    return;
                }
                tableSelectionActive = false;
                setEdit(true);
                txtMaNCC.setEditable(false);
                btnAdd.setVisible(!EditOrAdd);
                btnEdit.setVisible(!EditOrAdd);

                btnConfirm.setVisible(EditOrAdd);
                btnBack.setVisible(EditOrAdd);

                tbl.setEnabled(!EditOrAdd);
                EditOrAdd = false;
            }
        });

        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanView();
                EditOrAdd = true;
                btnAdd.setVisible(EditOrAdd);
                btnEdit.setVisible(EditOrAdd);
                setEdit(false);
                btnConfirm.setVisible(!EditOrAdd);
                btnBack.setVisible(!EditOrAdd);

                tbl.setEnabled(EditOrAdd);
                tableSelectionActive = true;
            }
        });

        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mess;
                if (EditOrAdd) {  //thêm NCC

                    String sDT = txtDienThoai.getText();
                    //validate SDT
                    Pattern pattern = Pattern.compile("^\\d{10,11}$");
                    Matcher m = pattern.matcher(sDT);   //so sánh
                    if (!m.matches()) {
                        new Toast.ToastError("Số điện thoại không hợp lệ!! Vui lòng nhập 10 hoặc 11 số !!!", Toast.SHORT_DELAY);
                        return;
                    }
                    //kiem tra ton tai
                    for (int j = 0; j < nccBUS.getNccBUS().size(); j++) {
                        if (nccBUS.getNccBUS().get(j).getPhone().equals(sDT)) {
                            new Toast.ToastError("Số điện thoại đã tồn tại, vui lòng nhập số khác !!!", Toast.SHORT_DELAY);
                            return;
                        }
                    }

                    mess = JOptionPane.showConfirmDialog(null, "Xác nhận thêm nhà cung cấp", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
                    if (mess == 0) {     //YES
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String sdt = txtDienThoai.getText();
                        
                        if(!tenNCC.equals("") && !diaChi.equals("") && !sdt.equals("")){
                        //Upload nhà cung cấp lên DAO và BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
                        nccBUS.add(ncc);
                        new Toast.ToastSuccessful("Thành công", "Thêm nhà cung cấp thành công !!!", Toast.SHORT_DELAY);
                        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
                        }
                        else{
                            new Toast.ToastError("Vui lòng nhập đầy đủ thông tin !!!", Toast.SHORT_DELAY);
                        }
                        cleanView();
                    }
                } else {   //sửa NCC
                    mess = JOptionPane.showConfirmDialog(null, "Xác nhận sửa nhà cung cấp", "Thông báo sửa", JOptionPane.YES_NO_OPTION);
                    if (mess == 0) {  //YES

                        String sDT = txtDienThoai.getText();
                        for (int j = 0; j < nccBUS.getNccBUS().size(); j++) {
                            if (nccBUS.getNccBUS().get(j).getPhone().equals(sDT) && nccBUS.getNccBUS().get(j).getId_NCC() != Integer.parseInt(txtMaNCC.getText())) {
                                new Toast.ToastError("Số điện thoại đã tồn tại, vui lòng nhập số khác !!!", Toast.SHORT_DELAY);
                                return;
                            }
                        }
                        //validate SDT
                        Pattern pattern = Pattern.compile("^\\d{10,11}$");
                        Matcher m = pattern.matcher(sDT);   //so sánh
                        if (!m.matches()) {
                            new Toast.ToastError("Số điện thoại không hợp lệ!! Vui lòng nhập 10 hoặc 11 số !!!", Toast.SHORT_DELAY);
                            return;
                        }

                        //Lấy data từ textField lên
                        int maNCC = Integer.parseInt(txtMaNCC.getText());
                        String tenNCC = txtTenNCC.getText();
                        String diaChi = txtDiaChi.getText();
                        String sdt = txtDienThoai.getText();
                        
                        if(!tenNCC.equals("") && !diaChi.equals("") && !sdt.equals("")){
                        //Upload nhà cung cấp lên DAO và BUS
                        NhaCungCapDTO ncc = new NhaCungCapDTO(tenNCC, diaChi, sdt);
                        ncc.setId_NCC(maNCC);
                        nccBUS.set(ncc);
                        new Toast.ToastSuccessful("Thành công", "Sửa thông tin nhà cung cấpthành công !!!", Toast.SHORT_DELAY);
                        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
                        }
                        else{
                            new Toast.ToastError("Vui lòng nhập đầy đủ thông tin !!!", Toast.SHORT_DELAY);
                        }
                    }
                }
            }
        }
        );

        /**
         * ******************TABLE***************************************************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************
         */
        Vector header = new Vector();

        header.add("Mã NCC");
        header.add("Tên NCC");
        header.add("Địa chỉ");
        header.add("SDT");
        model = new MyTable(header, 4);
        tbl = new JTable(model);
        //sap xep
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);

        tbl.setRowSorter(rowSorter);

        listNCC();

        /**
         * ************ TẠO TABLE ********************
         */
        //Chỉnh độ rộng cột
        tbl.getColumnModel()
                .getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel()
                .getColumn(1).setPreferredWidth(50);
        tbl.getColumnModel()
                .getColumn(2).setPreferredWidth(70);
        tbl.getColumnModel()
                .getColumn(3).setPreferredWidth(30);

        //Chỉnh table
        tbl.setFocusable(
                false);
        tbl.getTableHeader()
                .setFont(font1);
        tbl.setRowHeight(
                30);
        tbl.setShowVerticalLines(
                false);
        tbl.getTableHeader()
                .setBackground(new Color(134, 64, 0));
        tbl.getTableHeader()
                .setForeground(Color.WHITE);
        tbl.setSelectionBackground(
                new Color(52, 152, 219));
        tbl.setFillsViewportHeight(
                true);
        tbl.getTableHeader()
                .setOpaque(false);
        tbl.setIntercellSpacing(
                new Dimension(0, 0));

        //Add table vào scrollPane
        JScrollPane scroll = new JScrollPane(tbl);

        scroll.setBounds(
                new Rectangle(400, 40, DEFAULT_WIDTH - 700, 500));
        scroll.setBackground(
                null);
        add(scroll);

        //event click vào Table
        tbl.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                if (tableSelectionActive) {
                    int click = tbl.getSelectedRow(); //Chon vao dong trong bang hiển thị lên txt
                    if (click == -1) {
                        return;
                    }
                    txtMaNCC.setText(tbl.getModel().getValueAt(click, 0).toString());
                    txtTenNCC.setText(tbl.getModel().getValueAt(click, 1).toString());
                    txtDiaChi.setText(tbl.getModel().getValueAt(click, 2).toString());
                    txtDienThoai.setText(tbl.getModel().getValueAt(click, 3).toString());
                }
            }
        }
        );

        /**
         * ********************* SORT TABLE ****************************
         */
        //PHẦN CHỌN SEARCH
        cmbChoice = new JComboBox();

        cmbChoice.setFont(font0);

        cmbChoice.addItem(
                "Mã NCC");
        cmbChoice.addItem(
                "Tên NCC");
        cmbChoice.addItem(
                "Địa chỉ");
        cmbChoice.addItem(
                "SDT");
        cmbChoice.setBounds(
                new Rectangle(0, 180, 100, 30));
        cmbChoice.setEditable(
                false);

        // Custem Icon search
        iconSearch = new JLabel(new ImageIcon("./src/image/search_25px.png"));

        iconSearch.setCursor(
                new Cursor(Cursor.HAND_CURSOR));
        iconSearch.setBounds(
                290, 170, 50, 50);

        //Phần TextField
        txtSearch = new JTextField();

        txtSearch.setFont(font0);
//        txtSearch.setBorder(null);

        txtSearch.setBackground(Color.WHITE);

        txtSearch.setOpaque(
                false);
        txtSearch.setBounds(
                new Rectangle(110, 180, 220, 30));

        //Add tất cả vào ItemView
        itemView.add(cmbChoice);

        itemView.add(iconSearch);

        itemView.add(txtSearch);

        //bắt sự kiện FOCUS search box
        txtSearch.addFocusListener(
                new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e
            ) {
                iconSearch.setIcon(new ImageIcon("./src/image/search_25px_focus.png"));
            }

            public void focusLost(FocusEvent e) {
                iconSearch.setIcon(new ImageIcon("./src/image/search_25px.png"));
                iconSearch.setBorder(createLineBorder(Color.BLACK));
            }
        });

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();
                int choice = cmbChoice.getSelectedIndex();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        setEdit(false);
    }

//FUNCTION
    public void cleanView() {
        txtMaNCC.setEditable(false);
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
    }

    public void outModel(DefaultTableModel model, ArrayList<NhaCungCapDTO> ncc) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (NhaCungCapDTO n : ncc) {
            data = new Vector();
            data.add(n.getId_NCC());
            data.add(n.getName_NCC());
            data.add(n.getAddress());
            data.add(n.getPhone());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    //lấy data từ BUS lên Table
    public void listNCC() {
        if (nccBUS.getNccBUS() == null) {
            nccBUS.list();
        }

        outModel(model, (ArrayList<NhaCungCapDTO>) nccBUS.getNccBUS());
    }

    private void setEdit(boolean flag) {
        txtTenNCC.setEditable(flag);
        txtDiaChi.setEditable(flag);
        txtDienThoai.setEditable(flag);
    }
}
