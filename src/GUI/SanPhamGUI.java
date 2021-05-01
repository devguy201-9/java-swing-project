/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.LoaiBUS;
import BUS.SanPhamBUS;
import DTO.LoaiDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class SanPhamGUI extends JPanel implements KeyListener {

    private SanPhamBUS spBUS = new SanPhamBUS();
    private LoaiBUS loaiBUS = new LoaiBUS();
//    private NsxBUS nsxBUS = new NsxBUS();
    private JTable tbl;
    private BufferedImage i = null;//Hình ảnh chọn từ file
    private JLabel img;
    private String imgName = "null";
    private JTextField txtId, txtTenSP, txtSl, txtGia, txtMT, txtNSX, txtLoai, txtSearch;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH;
    private boolean EditOrAdd = true;//Cờ cho button Cofirm True:ADD || False:Edit
    private JTextField sortTenSP;
    private JTextField txtMaxPrice;
    private JTextField sortMaSP;
    private JTextField txtMinPrice;
    private JTextField sortMaLoai;
    private JTextField sortMaNSX;
    private JComboBox cmbLoai;
    private JComboBox cmbNSX;
    private JComboBox cmbSortLoai;
    private JComboBox cmbSortNSX;

    //        
    public SanPhamGUI(int width) {
        DEFALUT_WIDTH = width;
        init();
    }

    public void init() {
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI", Font.PLAIN, 13);
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
        JLabel lbId = new JLabel("Mă Sản Phẩm");
        lbId.setBounds(new Rectangle(250, 0, 200, 30));
        lbId.setFont(font0);
        txtId = new JTextField("");
        txtId.setBounds(new Rectangle(350, 0, 220, 30));
        txtId.setFont(font0);

        JLabel lbName = new JLabel("Tên Sản Phẩm");
        lbName.setBounds(new Rectangle(250, 40, 200, 30));
        lbName.setFont(font0);
        txtTenSP = new JTextField("");
        txtTenSP.setBounds(new Rectangle(350, 40, 220, 30));
        txtTenSP.setFont(font0);

        JLabel lbSl = new JLabel("Số lượng");
        lbSl.setBounds(new Rectangle(250, 80, 200, 30));
        lbSl.setFont(font0);
        txtSl = new JTextField("");
        txtSl.setBounds(new Rectangle(350, 80, 220, 30));
        txtSl.setFont(font0);

        JLabel lbGia = new JLabel("Đơn giá (VNĐ)");
        lbGia.setBounds(new Rectangle(250, 120, 200, 30));
        lbGia.setFont(font0);
        txtGia = new JTextField("");
        txtGia.setBounds(new Rectangle(350, 120, 220, 30));
        txtGia.setFont(font0);

        JLabel lbmota = new JLabel("Mô tả");
        lbmota.setBounds(new Rectangle(250, 160, 200, 30));
        lbmota.setFont(font0);
//        String[] mota ={"Lon","Hộp","Chai","Gói","Cái","Tuýp"};
        txtMT = new JTextField("");
        txtMT.setBounds(new Rectangle(350, 160, 220, 30));
        txtMT.setFont(font0);

        JLabel lbLoai = new JLabel("Loại");
        lbLoai.setBounds(new Rectangle(430, 200, 40, 30));
        lbLoai.setFont(font0);
        cmbLoai = new JComboBox();
        cmbLoai.setFont(font0);
        cmbLoai.setBounds(new Rectangle(470, 200, 100, 30));
        listLoai(cmbLoai);

        img = new JLabel("Thêm hình");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(0, 0, 200, 230));

        // THÊM VÀO PHẦN HIỂN THỊ
        ItemView.add(img);
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbName);
        ItemView.add(txtTenSP);
        ItemView.add(lbSl);
        ItemView.add(txtSl);
        ItemView.add(lbGia);
        ItemView.add(txtGia);
        ItemView.add(lbmota);
        ItemView.add(txtMT);
        ItemView.add(lbLoai);
        ItemView.add(cmbLoai);

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

        JLabel btnXuatExcel = new JLabel(new ImageIcon("./src/image/btnXuatExcel.png"));
        btnXuatExcel.setBounds(new Rectangle(820, 0, 200, 50));
        btnXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel btnNhapExcel = new JLabel(new ImageIcon("./src/image/btnNhapExcel.png"));
        btnNhapExcel.setBounds(new Rectangle(820, 60, 200, 50));
        btnNhapExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);
        ItemView.add(btnXuatExcel);
        ItemView.add(btnNhapExcel);

        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditOrAdd = true;

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
                    spBUS.delete(txtId.getText());
                    cleanView();
                    tbl.clearSelection();
                    outModel(model, (ArrayList<SanPhamDTO>) spBUS.getSpBUS());
                }
            }
        });

        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (txtId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa !!!");
                    return;
                }

                EditOrAdd = false;

                txtId.setEditable(false);

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
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtId.getText().concat(".jpg"); //Tên hình

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
                if (EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        //Lấy dữ liệu từ TextField
                        int maSP = Integer.parseInt(txtId.getText());
                        String tenSP = txtTenSP.getText();
                        int sl = Integer.parseInt(txtSl.getText());
                        int gia = Integer.parseInt(txtGia.getText());
                        String mota = txtMT.getText();
                        LoaiDTO loai = (LoaiDTO) cmbLoai.getSelectedItem();
                        int maLoai = loai.getId_Loai();
                        String IMG = imgName;
                        if (spBUS.checkMasp(maSP)) {
                            JOptionPane.showMessageDialog(null, "Mã sản phẩm đă tồn tại !!!");
                            return;
                        }
                        //Upload sản phẩm lên DAO và BUS
                        SanPhamDTO sp = new SanPhamDTO(maLoai, sl, tenSP, mota, gia, IMG);
                        spBUS.add(sp);

                        outModel(model, (ArrayList<SanPhamDTO>) spBUS.getSpBUS());// Load lại table

                        saveIMG();// Lưu hình ảnh 

                        cleanView();
                    }
                } else // Edit Sản phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        //Lấy dữ liệu từ TextField
                        int maSP = Integer.parseInt(txtId.getText());
                        String tenSP = txtTenSP.getText();
                        int sl = Integer.parseInt(txtSl.getText());
                        int gia = Integer.parseInt(txtGia.getText());
                        String mota = txtMT.getText();
                        
                        LoaiDTO loai = (LoaiDTO) cmbLoai.getSelectedItem();
                        int maLoai = loai.getId_Loai();

                        String IMG = imgName;

                        //Upload sản phẩm lên DAO và BUS
                        SanPhamDTO sp = new SanPhamDTO(maLoai, sl, tenSP, mota, gia, IMG);
                        spBUS.set(sp);

                        outModel(model, (ArrayList<SanPhamDTO>) spBUS.getSpBUS());// Load lại table

                        saveIMG();// Lưu hình ảnh 

                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);

                    }
                }

            }
        });

        btnXuatExcel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                spBUS.exportProduct();    //LUU Y: LAM CHO NAY
                JOptionPane.showMessageDialog(null, "Xuat file excel thanh cong");
            }
        });

        btnNhapExcel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Excel", "xlsx");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
//                    try {
                        File file = fc.getSelectedFile(); //Lấy URL
//                        spBUS.importProduct(file);    //LUU Y: LAM CHO NAY
                        spBUS.list();
                        outModel(model, (ArrayList<SanPhamDTO>) spBUS.getSpBUS());
                        JOptionPane.showMessageDialog(null, "Nhap file excel thanh cong");
//                    } catch (IOException | ParseException ex) {
//                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            }
        });

        /**
         * *************************************************************
         */
        /**
         * *********************** PHẦN TABLE ************************************
         */
        /**
         * ************ TẠO MODEL VÀ HEADER ********************
         */
        Vector header = new Vector();
        header.add("Mă Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Số lượng");
        header.add("Đơn Giá");
        header.add("Mô tả");
        header.add("Loại");
//        header.add("Mă NSX");
        header.add("IMG");
        model = new DefaultTableModel(header, 0) {
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 5:
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
        tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(120);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(40);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(180);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(30);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(40);

        DefaultTableCellRenderer centerAlign = new DefaultTableCellRenderer();
        centerAlign.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(0).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(2).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(centerAlign);
        tbl.getColumnModel().getColumn(5).setCellRenderer(centerAlign);

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
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5, 100));
        add(scroll);
        add(ItemView);
        /**
         * **************************************************************************************
         */

        tbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int i = tbl.getSelectedRow();
                if (tbl.getRowSorter() != null) {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                imgName = tbl.getModel().getValueAt(i, 6).toString();
                Image newImage;
                try {
                    newImage = new ImageIcon("./src/image/SanPham/" + imgName).getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                } catch (NullPointerException E) {
                    newImage = new ImageIcon("./src/image/SanPham/NoImage.jpg").getImage().getScaledInstance(200, 230, Image.SCALE_DEFAULT);
                }
                txtId.setText(tbl.getModel().getValueAt(i, 0).toString());
                txtTenSP.setText(tbl.getModel().getValueAt(i, 1).toString());
                txtSl.setText(tbl.getModel().getValueAt(i, 2).toString());
                txtGia.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtMT.setText(tbl.getModel().getValueAt(i, 4).toString());
                cmbLoai.setSelectedItem(loaiBUS.searchMaLoai((int) tbl.getModel().getValueAt(i, 5)));

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
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtSearch.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text + ".*", 1));
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

        JLabel sortTitle = new JLabel("--------------------------------------------------------------------------- TÌM KIẾM THÔNG TIN ---------------------------------------------------------------------------", JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0, 0, this.DEFALUT_WIDTH - 400, 30));
        sort.add(sortTitle);

        /**
         * ****** SORT MAKH *************
         */
        JLabel lbSortMaSP = new JLabel("Mă SP :");
        lbSortMaSP.setFont(font0);
        lbSortMaSP.setBounds(0, 40, 50, 30);
        sort.add(lbSortMaSP);

        sortMaSP = new JTextField("");
        sortMaSP.setFont(font0);
        sortMaSP.setBounds(new Rectangle(50, 42, 100, 30));
        sortMaSP.addKeyListener(this);
        sort.add(sortMaSP);
        /**
         * **********************************
         */

        /**
         * ****** SORT MALOAI *************
         */
        JLabel lbSortMaLoai = new JLabel("Loại :");
        lbSortMaLoai.setFont(font0);
        lbSortMaLoai.setBounds(170, 40, 40, 30);
        sort.add(lbSortMaLoai);

        cmbSortLoai = new JComboBox();
        cmbSortLoai.setEditable(true);
        cmbSortLoai.setFont(font0);
        cmbSortLoai.setBounds(new Rectangle(210, 42, 110, 30));
        cmbSortLoai.addItem("Tất cả");
        cmbSortLoai.addKeyListener(this);
        listLoai(cmbSortLoai);
        sort.add(cmbSortLoai);

        /**
         * **********************************
         */
        
        /**
         * ********** SORT THEO GIÁ **************
         */
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(510, 40, 70, 30);
        sort.add(sortPrice);

        txtMinPrice = new JTextField("");
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(580, 42, 100, 30));
        txtMinPrice.addKeyListener(this);
        sort.add(txtMinPrice);

        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(690, 56, 10, 6);
        sort.add(sepPrice);

        txtMaxPrice = new JTextField("");
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(710, 42, 100, 30));
        txtMaxPrice.addKeyListener(this);
        sort.add(txtMaxPrice);
        /**
         * ***************************************
         */

        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840, 26, 63, 63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                search();
            }
        });
        sort.add(btnSearch);

        add(sort);
        /**
         * ****************************************************************
         */

    }

    //FUNCTION
    public void addCombo(JComboBox cmb, ArrayList list) {
        for (Object a : list) {
            cmb.addItem(a);
        }
    }

    public void listLoai(JComboBox cmb)
    {
        if(loaiBUS.getLoaiBUS()== null)loaiBUS.list();
        ArrayList<LoaiDTO> loai = (ArrayList<LoaiDTO>) loaiBUS.getLoaiBUS();
        addCombo(cmb, loai);
    }

    public void listSP() // Chép ArrayList lên table
    {
        if (spBUS.getSpBUS() == null) {
            spBUS.list();
        }
        ArrayList<SanPhamDTO> sp = (ArrayList<SanPhamDTO>) spBUS.getSpBUS();
        model.setRowCount(0);
        outModel(model, sp);
    }

    //FUNCTION FOR BTN
    public void cleanView() //Xóa trắng các TextField
    {
        txtId.setEditable(true);

        txtId.setText("");
        txtTenSP.setText("");
        txtSl.setText("");
        txtGia.setText("");
        txtMT.setText("");

        img.setIcon(null);
        img.setText("Image");

        imgName = "null";
    }

    public void outModel(DefaultTableModel model, ArrayList<SanPhamDTO> sp) // Xuất ra Table từ ArrayList
    {
        Vector data;
        model.setRowCount(0);
        for (SanPhamDTO s : sp) {
            data = new Vector();
            data.add(s.getId_SP());
            data.add(s.getName());
            data.add(s.getAmount());
            data.add(s.getPrice());
            data.add(s.getDescrption());
            data.add(s.getId_Loai());
//            data.add(s.getMaNsx());
            data.add(s.getImg());
            model.addRow(data);
        }
        tbl.setModel(model);
    }

    public void saveIMG() {
        try {
            if (i != null) {
                File save = new File("src/image/SanPham/" + imgName);//Tạo file
                ImageIO.write(i, "jpg", save); // Lưu hình i vào đường dẫn file save

                i = null; //Xóa hình trong bộ nhớ 
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search() {
        int masp = Integer.parseInt(sortMaSP.getText());
        int maloai = 0;
//        String mansx = "";
        if (cmbSortLoai.getSelectedIndex() != 0) {
            LoaiDTO loai = (LoaiDTO) cmbSortLoai.getSelectedItem();
            maloai = loai.getId_Loai();
            System.out.println(maloai);
        }

        int max = txtMaxPrice.getText().equals("") ? 999999 : Integer.parseInt(txtMaxPrice.getText());
        int min = txtMinPrice.getText().equals("") ? 0 : Integer.parseInt(txtMinPrice.getText());

        outModel(model, spBUS.searchSP(masp, maloai, max, min));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
