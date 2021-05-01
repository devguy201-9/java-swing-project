/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.Gender;
import DTO.NhanVienDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class NhanVienGUI extends JPanel {

    private NhanVienBUS nvBUS = new NhanVienBUS();
    private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtMaNV, txtHoNV, txtSDT, txtNamSinh, txtPhai, txtNgay, txtDiaChi, txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JTextField sortMaNV;
    private JTextField sortHoNV;
    private JTextField sortSDT;
    private Choice sortPhai;
    private JComboBox cmbPhai;

    public NhanVienGUI(int width) {
        DEFALUT_WIDTH = width;
        try {
            init();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() throws ClassNotFoundException, SQLException {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
        /**
         * **************************** PHẦN HIỂN THỊ THÔNG TIN *****************************************
         */

        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(30, 20, this.DEFALUT_WIDTH - 220, 250));
        ItemView.setBackground(Color.WHITE);

        /**
         * ****** Tao Cac Label & TextField ***********************
         */
        JLabel lbMaNV = new JLabel("Mă nhân viên");
        lbMaNV.setBounds(new Rectangle(250, 0, 200, 30));
        lbMaNV.setFont(font0);
        txtMaNV = new JTextField("");
        txtMaNV.setBounds(new Rectangle(350, 0, 220, 30));

        JLabel lbHoNV = new JLabel("Họ và tên");
        lbHoNV.setBounds(new Rectangle(250, 40, 200, 30));
        lbHoNV.setFont(font0);
        txtHoNV = new JTextField("");
        txtHoNV.setBounds(new Rectangle(350, 40, 220, 30));

        JLabel lbSDT = new JLabel("Số điện thoại");
        lbSDT.setBounds(new Rectangle(250, 80, 200, 30));
        lbSDT.setFont(font0);
        txtSDT = new JTextField("");
        txtSDT.setBounds(new Rectangle(350, 80, 220, 30));

        JLabel lbNgay = new JLabel("Ngày bắt đầu");
        lbNgay.setBounds(new Rectangle(250, 120, 200, 30));
        lbNgay.setFont(font0);
        txtNgay = new JTextField("");
        txtNgay.setBounds(new Rectangle(350, 120, 220, 30));

        JLabel lbDiaChi = new JLabel("Địa chỉ");
        lbDiaChi.setBounds(new Rectangle(250, 160, 200, 30));
        lbDiaChi.setFont(font0);
        txtDiaChi = new JTextField("");
        txtDiaChi.setBounds(new Rectangle(350, 160, 220, 30));

        JLabel lbNamSinh = new JLabel("Tuổi");
        lbNamSinh.setBounds(new Rectangle(440, 200, 80, 30));
        lbNamSinh.setFont(font0);
        txtNamSinh = new JTextField("");
        txtNamSinh.setBounds(new Rectangle(490, 200, 80, 30));

        JLabel lbPhai = new JLabel("Phái");
        lbPhai.setBounds(new Rectangle(250, 200, 30, 30));
        lbPhai.setFont(font0);
        String[] phai = {"Nam", "Nữ"};   //LUU Y: dua vao Array cua gender?
        cmbPhai = new JComboBox(phai);
        cmbPhai.setBounds(new Rectangle(290, 200, 80, 30));

        img = new JLabel("Thêm hình");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0, 0, 200, 230));

        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbMaNV);
        ItemView.add(txtMaNV);
        ItemView.add(lbHoNV);
        ItemView.add(txtHoNV);
        ItemView.add(lbSDT);
        ItemView.add(txtSDT);
        ItemView.add(lbNamSinh);
        ItemView.add(txtNamSinh);
        ItemView.add(lbPhai);
        ItemView.add(cmbPhai);
//        ItemView.add(txtPhai);
        ItemView.add(lbNgay);
        ItemView.add(txtNgay);
        ItemView.add(lbDiaChi);
        ItemView.add(txtDiaChi);
        /**
         * *********************************************************
         */

        /**
         * ************** TẠO CÁC BTN THÊM ,XÓA, SỬA *******************
         */
        JLabel btnAdd = new JLabel(new ImageIcon("./src/image/btnAdd.png"));
        btnAdd.setBounds(new Rectangle(620, 0, 200, 50));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel btnEdit = new JLabel(new ImageIcon("./src/image/btnEdit.png"));
        btnEdit.setBounds(new Rectangle(620, 70, 200, 50));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel btnDelete = new JLabel(new ImageIcon("./src/image/btnDelete.png"));
        btnDelete.setBounds(new Rectangle(620, 140, 200, 50));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);

        JLabel btnConfirm = new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(620, 0, 200, 50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(620, 70, 200, 50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel btnFile = new JLabel(new ImageIcon("./src/image/btnFile.png"));
        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(620, 140, 200, 50));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);

        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditOrAdd = true;
                txtMaNV.requestFocus();
                cleanView();

                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);

                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);

                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });

        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    TaiKhoanBUS usBUS = new TaiKhoanBUS();
                    usBUS.delete(txtMaNV.getText());
                    nvBUS.delete(txtMaNV.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<NhanVienDTO>) nvBUS.getNvBUS());
                }
            }
        });

        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                if (txtMaNV.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa !!!");
                    return;
                }

                EditOrAdd = false;

                txtMaNV.setEditable(false);

                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);

                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);

//                tbl.clearSelection();
                tbl.setEnabled(false);
            }
        });

        // MouseClick btnFile
        btnFile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtMaNV.getText().concat(".jpg"); //Tên hình

                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));

                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cleanView();

                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);

                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                btnFile.setVisible(false);

                tbl.setEnabled(true);
            }
        });

        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i;

                if (EditOrAdd) //Thêm Nhân Viên
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        try {
                            //Lấy dữ liệu từ TextField
                            int maNV = Integer.parseInt(txtMaNV.getText());
                            String hoTen = txtHoNV.getText();
                            String sdt = txtSDT.getText();
                            int namSinh = Integer.parseInt(txtNamSinh.getText());
                            String phai = cmbPhai.getSelectedItem().toString();
                            Date ngayBD = new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText());
                            String diaChi = txtDiaChi.getText();
                            String IMG = imgName;

                            if (nvBUS.check(maNV)) {
                                JOptionPane.showMessageDialog(null, "Mã nhân viên đă tồn tại !!!");
                                return;
                            }
                            //Upload nhân viên lên DAO và BUS
                            NhanVienDTO nv = new NhanVienDTO(maNV, IMG, diaChi, phai, Gender.male, ngayBD, IMG);
                            nvBUS.add(nv);
//                        TaiKhoanBUS usBUS = new TaiKhoanBUS();
//                        TaiKhoanDTO user = new TaiKhoanDTO(maNV, removeAccent(sdt.concat(maNV)).toLowerCase(), "123456", "Nhân Viên", "1");
//                        usBUS.add(user, 1);
                            outModel(model, (ArrayList<NhanVienDTO>) nvBUS.getNvBUS());// Load lại table

                            saveIMG();// Lưu hình ảnh 

                            cleanView();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Loi");
                        } catch (ParseException ex) {
                            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        try {
                            //Lấy dữ liệu từ TextField
                            int maNV = Integer.parseInt(txtMaNV.getText());
                            String hoTen = txtHoNV.getText();
                            String sdt = txtSDT.getText();
                            int namSinh = Integer.parseInt(txtNamSinh.getText());
                            String phai = cmbPhai.getSelectedItem().toString();
                            Date ngayBD = new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText());
                            String diaChi = txtDiaChi.getText();
                            String IMG = imgName;

                            //Upload nhân viên lên DAO và BUS
                            NhanVienDTO NV = new NhanVienDTO(maNV, IMG, diaChi, phai, Gender.male, ngayBD, IMG);
                            nvBUS.set(NV);

                            outModel(model, (ArrayList<NhanVienDTO>) nvBUS.getNvBUS());// Load lại table

                            saveIMG();// Lưu hình ảnh

                            JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                        } catch (ParseException ex) {
                            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }

            }
        });

        /**
         * *************************************************************
         */
        /**
         * *******************************************************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************
         */
        Vector header = new Vector();
        header.add("Mă NV");
        header.add("Họ và tên");
        header.add("SĐT");
        header.add("Tuổi");
        header.add("Phái");
        header.add("Ngày bắt đầu");
        header.add("Địa chỉ");
        header.add("IMG");
        model = new DefaultTableModel(header, 5) {
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }

        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        listSP(); //Đọc từ database lên table 

        /**
         * ******************************************************
         */
        /**
         * ************** TẠO TABLE ***********************************************************
         */
        // Chỉnh width các cột 
        tbl.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(70);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(130);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(4).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(5).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(7).setCellRenderer(centerAlign);

        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0, 0));
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232, 57, 99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52, 152, 219));

        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 360, this.DEFALUT_WIDTH - 400, 300));
        scroll.setBackground(null);

        add(scroll);
        add(ItemView);
        /**
         * **************************************************************************************
         */

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tbl.getSelectedRow();
                imgName = tbl.getModel().getValueAt(i, 7).toString();
                Image newImage;
                try {
                    newImage = new ImageIcon("./src/image/NhanVien/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                } catch (NullPointerException E) {
                    newImage = new ImageIcon("./src/image/NhanVien/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtHoNV.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtSDT.setText(tbl.getModel().getValueAt(i, 2).toString());
                txtNamSinh.setText(tbl.getModel().getValueAt(i, 3).toString());
                cmbPhai.setSelectedItem(tbl.getModel().getValueAt(i, 4).toString());
                txtNgay.setText(tbl.getModel().getValueAt(i, 5).toString());
                txtDiaChi.setText(tbl.getModel().getValueAt(i, 6).toString());
                img.setText("");
                img.setIcon(new ImageIcon(newImage));

            }
        });
        /**
         * ******************* THANH SEARCH **********************************************
         */

//         Tạo Search Box
        JPanel searchBox = new JPanel(null);
        searchBox.setBackground(null);
        searchBox.setBounds(new Rectangle(620, 200, 250, 30));
        searchBox.setBorder(createLineBorder(Color.BLACK)); //Chỉnh viền 

        //Phần TextField 
        txtSearch = new JTextField();
        txtSearch.setBounds(new Rectangle(5, 0, 200, 30));
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
        txtSearch.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // Custem Icon search
        JLabel searchIcon = new JLabel(new ImageIcon("./src/image/search_25px.png"));
        searchIcon.setBounds(new Rectangle(200, -9, 50, 50));
        searchIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add tất cả vào search box
        searchBox.add(searchIcon);
        searchBox.add(txtSearch);

        //bắt sự kiện Focus vào search box
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px_focus.png")); //Đổi màu icon
                searchBox.setBorder(createLineBorder(new Color(52, 152, 219))); // Đổi màu viền 
            }

            public void focusLost(FocusEvent e) //Trờ về như cũ
            {
                searchIcon.setIcon(new ImageIcon("./src/image/search_25px.png"));
                searchBox.setBorder(createLineBorder(Color.BLACK));
            }
        });
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1, 2));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1, 2));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        ItemView.add(searchBox);
        /**
         * ******************************************************************************
         */
        /**
         * ********************* PHẦN SEARCH TABLE ****************************
         */
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30, 265, this.DEFALUT_WIDTH - 400, 100);

        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------ TÌM KIẾM THÔNG TIN ------------------------------------------------------------------------------", JLabel.CENTER); // Mỗi bên 78 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0, 0, this.DEFALUT_WIDTH - 400, 30));
        sort.add(sortTitle);

        /**
         * ****** SORT MAKH *************
         */
        JLabel lbSortMaNV = new JLabel("Mă NV :");
        lbSortMaNV.setFont(font0);
        lbSortMaNV.setBounds(0, 40, 50, 30);
        sort.add(lbSortMaNV);

        sortMaNV = new JTextField();
        sortMaNV.setFont(font0);
        sortMaNV.setBounds(new Rectangle(50, 42, 70, 30));
        sort.add(sortMaNV);
        /**
         * **********************************
         */

        /**
         * ****** SORT HONV *************
         */
        JLabel lbSortHoNV = new JLabel("Họ tên :");
        lbSortHoNV.setFont(font0);
        lbSortHoNV.setBounds(140, 40, 50, 30);
        sort.add(lbSortHoNV);

        sortHoNV = new JTextField();
        sortHoNV.setFont(font0);
        sortHoNV.setBounds(new Rectangle(200, 42, 100, 30));
        sort.add(sortHoNV);
        /**
         * **********************************
         */

        /**
         * ****** SORT SDT NV *************
         */
        JLabel lbSortSDT = new JLabel("SDT :");
        lbSortSDT.setFont(font0);
        lbSortSDT.setBounds(320, 40, 50, 30);
        sort.add(lbSortSDT);

        sortSDT = new JTextField();
        sortSDT.setFont(font0);
        sortSDT.setBounds(new Rectangle(350, 42, 100, 30));
        sort.add(sortSDT);
        /**
         * **********************************
         */
        /**
         * ********** SORT PHÁI *************
         */
        JLabel lbSortPhai = new JLabel("Phái :");
        lbSortPhai.setFont(font0);
        lbSortPhai.setBounds(470, 40, 35, 30);
        sort.add(lbSortPhai);

        sortPhai = new Choice();
        sortPhai.addItem("Tất cả");
              
        
        sortPhai.addItem("Nam");
        sortPhai.addItem("Nữ");
        sortPhai.setFont(font0);
        sortPhai.setBounds(new Rectangle(505, 43, 100, 30));
        sort.add(sortPhai);
        /**
         * **********************************
         */
        /**
         * ***************************************
         */

        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840, 26, 63, 63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(sortPhai.getSelectedItem());
                System.out.println(sortPhai.getSelectedIndex());
                int manv = Integer.parseInt(sortMaNV.getText());
                String hoten = sortHoNV.getText();
                String sdt = sortSDT.getText();
                String phai = sortPhai.getSelectedIndex() != 0 ? sortPhai.getSelectedItem() : "";

                outModel(model, nvBUS.search(manv, hoten, sdt, phai));
            }
        });
        sort.add(btnSearch);

        add(sort);
        /**
         * ****************************************************************
         */
    }

    //FUNCTION
    public void cleanView() //Xóa trắng các TextField
    {
        txtMaNV.setEditable(true);

        txtMaNV.setText("");
        txtHoNV.setText("");
        txtSDT.setText("");
        txtNamSinh.setText("");
        txtNgay.setText("");
        txtDiaChi.setText("");

        img.setIcon(null);
        img.setText("Image");

        imgName = "null";
    }

    public void outModel(DefaultTableModel model, ArrayList<NhanVienDTO> nv) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (NhanVienDTO n : nv) {
            data = new Vector();
            data.add(n.getId_NV());
            data.add(n.getName());
            data.add(n.getPhone());
            data.add(n.getAge());
            data.add(n.getGender());
            data.add(n.getStart_day());
            data.add(n.getAddress());
            data.add(n.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/NhanVien/" + imgName);// Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listSP() // Chép ArrayList lên table
    {
        if (nvBUS.getNvBUS() == null) {
            nvBUS.list();
        }
        ArrayList<NhanVienDTO> nv = (ArrayList<NhanVienDTO>) nvBUS.getNvBUS();
//        model.setRowCount(0);
        outModel(model, nv);
    }

}
