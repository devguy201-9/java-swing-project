/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import BUS.PhieuNhapHangBUS;
import BUS.ct_PhieuNhapHangBUS;
import DTO.HoaDonDTO;
import DTO.PhieuNhapHangDTO;
import DTO.ct_PhieuNhapHangDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class NhapHangGUI extends JPanel implements ActionListener, KeyListener{
    private PhieuNhapHangBUS pnhBUS = new PhieuNhapHangBUS();
    private ct_PhieuNhapHangBUS ctBUS = new ct_PhieuNhapHangBUS();
    private int DEFAULT_WIDTH;
    
    private JLabel lbMaPNH,lbMaNCC,lbMaNV,lbNgayHD,lbTongTien;
    private JTextField txtMaPNH,txtMaNCC,txtMaNV,txtNgayHD,txtTongTien;
    private JButton btnMaNCC,btnMaNV;
    private JDateChooser dateChoice;
    
    private JLabel btnEdit,btnBill,btnConfirm,btnBack;
    private JButton btnView,btnAdd;
    
    private JTable tbl;
    private DefaultTableModel model;
    
    private Choice monthChoice,yearChoice;
    private JTextField txtMinPrice,txtMaxPrice,txtMaSP;
    
    
    public NhapHangGUI(int width){
        this.DEFAULT_WIDTH = width;
        init();
    }
    
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFAULT_WIDTH - 220, 1000));
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);
        
/*********************** PHẦN VIEW THÔNG TIN *****************************/

        JPanel itemView = new JPanel(null);
        itemView.setBackground(null);
        itemView.setBounds(new Rectangle(30,40,this.DEFAULT_WIDTH - 200,120));
        
        lbMaPNH = new JLabel("Mã PN");
        lbMaPNH.setFont(font1);
        lbMaPNH.setBounds(0,0,55,30);
        txtMaPNH = new JTextField();
        txtMaPNH.setFont(font0);
        txtMaPNH.setBounds(new Rectangle(55,0,80,30));
        itemView.add(lbMaPNH);
        itemView.add(txtMaPNH);
                       
        lbMaNCC = new JLabel("Mã NCC");
        lbMaNCC.setFont(font0);
        lbMaNCC.setBounds(155,0,30,30);
        txtMaNCC = new JTextField();
        txtMaNCC.setFont(font0);
        txtMaNCC.setBounds(new Rectangle(215,0,50,30));
        btnMaNCC = new JButton("...");
        btnMaNCC.setBackground(new Color(131, 149, 167));
        btnMaNCC.setBounds(new Rectangle(265, 0, 30, 30));
        btnMaNCC.addActionListener(this);
        itemView.add(btnMaNCC);
        itemView.add(lbMaNCC);
        itemView.add(txtMaNCC);

        lbMaNV = new JLabel("Mã NV");
        lbMaNV.setFont(font0);
        lbMaNV.setBounds(315,0,60,30);
        txtMaNV = new JTextField();
        txtMaNV.setFont(font0);
        txtMaNV.setBounds(new Rectangle(375,0,50,30));
        btnMaNV = new JButton("...");
        btnMaNV.setBackground(new Color(131, 149, 167));
        btnMaNV.setBounds(new Rectangle(425, 0, 30, 30));
        btnMaNV.addActionListener(this);
        itemView.add(btnMaNV);
        itemView.add(lbMaNV);
        itemView.add(txtMaNV);

        lbNgayHD = new JLabel("Ngày Nhập");
        lbNgayHD.setFont(font0);
        lbNgayHD.setBounds(0,40,70,30);
        txtNgayHD = new JTextField();
        txtNgayHD.setFont(font0);        
        txtNgayHD.setBounds(new Rectangle(80,40,375,30));
        itemView.add(lbNgayHD);
        itemView.add(txtNgayHD);
        
        dateChoice = new JDateChooser();
        dateChoice.setBounds(new Rectangle(80,40,375,30));
        dateChoice.setVisible(false);
        itemView.add(dateChoice);

        lbTongTien = new JLabel("Tổng Tiền");
        lbTongTien.setFont(font0);
        lbTongTien.setBounds(0,80,60,30);
        txtTongTien = new JTextField();
        txtTongTien.setFont(font0);
        txtTongTien.setBounds(new Rectangle(80,80,375,30));
        itemView.add(lbTongTien);
        itemView.add(txtTongTien);
        
        
        JSeparator sepHD = new JSeparator(0);
        sepHD.setBounds(new Rectangle(0, 180, this.DEFAULT_WIDTH - 350, 3));
        add(sepHD);
        
        add(itemView);

/**************** TẠO CÁC BTN XÓA, SỬA, VIEW, IN BILL ********************/
        Font font2 = new Font("Sogoe UI", Font.PLAIN, 18);
        
        btnAdd = new JButton("THÊM");
        btnAdd.setFont(font2);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(new Color(85, 239, 196));

        btnAdd.setBounds(new Rectangle(730,60,200,40));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
               
        
        btnView = new JButton("CHI TIẾT PN");
        btnView.setFont(font2);
        btnView.setForeground(Color.WHITE);
        btnView.setBackground(new Color(250, 130, 49));
        
        
        btnView.setBounds(new Rectangle(730,0,200,40));
        btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
//        btnBill = new JLabel(new ImageIcon(("./src/image/btnBill.png")));
//        btnBill.setBounds(new Rectangle(730,60,200,50));
//        btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnConfirm= new JLabel(new ImageIcon("./src/image/btnConfirm.png"));
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(500,0,200,50));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnBack = new JLabel(new ImageIcon("./src/image/btnBack.png"));
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(500,60,200,50));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
//        itemView.add(btnEdit);
        itemView.add(btnAdd);
        itemView.add(btnView);
//        itemView.add(btnBill);
        
        itemView.add(btnConfirm);
        itemView.add(btnBack);
        
        // MouseClick btnAdd
        btnAdd.addMouseListener(new MouseAdapter() {
            public void mouseCliced(MouseEvent e){
                
                
            }
        });
        
        // Xem Chi Tiết HD              
        btnView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                CT_NhapHangGUI chitiet = new CT_NhapHangGUI(txtMaPNH.getText());
            }
        });
        
        // In Bill
//        btnBill.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e){
//                int maHD = Integer.parseInt(txtMaPNH.getText());
//                int maKH = Integer.parseInt(txtMaNCC.getText());
//                int maNv = Integer.parseInt(txtMaNV.getText());
//                Timestamp ngayLap = Timestamp.valueOf(txtNgayHD.getText());
//                float tongTien = Float.parseFloat(txtTongTien.getText());
//                HoaDonDTO hd = new HoaDonDTO(maHD, maKH, maNv, tongTien, ngayLap);                
//                ArrayList<ct_PhieuNhapHangDTO> cthd = (ArrayList<ct_PhieuNhapHangDTO>) ctBUS.getCt_pnhBUS();
////                printBill bill = new printBill(hd, cthd);
////                bill.print();
//            }
//        });
        
        //Button Confirm
       
        
        
        //Button Back
        btnBack.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
//                isEdit(false);
                
                Date time = Timestamp.valueOf(txtNgayHD.getText());
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(time.getTime());

                if(dateChoice.getCalendar() != null)
                {
                    int dd = dateChoice.getCalendar().get(Calendar.DATE);
                    int mm = dateChoice.getCalendar().get(Calendar.MONTH);
                    int yyy = dateChoice.getCalendar().get(Calendar.YEAR);
                    calendar.set(yyy,mm, dd);
                    Timestamp newTime = new Timestamp(calendar.getTime().getTime());
                    System.out.println(newTime);
                    txtNgayHD.setText(newTime.toString());
                }
            }
        });
        
 /****************** TẠO MODEL VÀ HEADER *********************************************/
        Vector header = new Vector();
        header.add("Mă Phiếu Nhập");
        header.add("Mă Nhà cung cấp");
        header.add("Mã Nhân Viên");
        header.add("Ngày Nhập");
        header.add("Tổng Tiền");
        model = new DefaultTableModel(header,5)
        {
            public Class getColumnClass(int column)
            {
                switch(column){
                    case 4:
                        return Integer.class;
                    default:
                        return String.class;
                }
            }              
        };
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        list(); //Đọc từ database lên table 
        
/*********************************************************/
        
/**************** TẠO TABLE ************************************************************/

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
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(134, 64, 0));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        // Add table vào ScrollPane
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(30, 270, this.DEFAULT_WIDTH - 400 , 400));
        scroll.setBackground(null);
        
        add(scroll);
        
        
        //Nhấp vào dòng nào là đẩy data lên textfield
        tbl.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e)
             {
                int i = tbl.getSelectedRow();
                if(tbl.getRowSorter() != null)
                {
                    i = tbl.getRowSorter().convertRowIndexToModel(i);
                }
                txtMaPNH.setText(tbl.getModel().getValueAt(i, 0).toString());
                try
                {
                    txtMaNCC.setText(tbl.getModel().getValueAt(i, 1).toString());
                }
                catch(NullPointerException ex)
                {
                    txtMaNCC.setText("");
                }
                txtMaNV.setText(tbl.getModel().getValueAt(i, 2).toString()); 
                txtNgayHD.setText(tbl.getModel().getValueAt(i, 3).toString());
                txtTongTien.setText( tbl.getModel().getValueAt(i, 4).toString());
             }
        });
        
/*****************************************************************************************/       
/*********************** SORT TABLE *****************************/
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(30,170,this.DEFAULT_WIDTH - 400,140);
        
//        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------------ BỘ LỌC ------------------------------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 84 dấu ( - )
//        sortTitle.setFont(font1);
//        sortTitle.setBounds(new Rectangle(0,0,this.DEFAULT_WIDTH - 400,30));
//        sort.add(sortTitle);
        
        /******** SORT THỜI GIAN **************/
        JLabel sortTime = new JLabel("Thời gian :");
        sortTime.setFont(font0);
        sortTime.setBounds(0,40,80,30);
        sort.add(sortTime);
        // Choice Tháng
        int month = Calendar.getInstance().get(Calendar.MONTH);// Lấy tháng hiện tại
        monthChoice = new Choice();
        monthChoice.setFont(font0);
        monthChoice.add("Không");
        for(int i = 1 ; i <= 12 ; i++ )
        {
            monthChoice.add("Tháng "+i);
        }
        monthChoice.select(0);
        monthChoice.setBounds(new Rectangle(80,42,90,40));
        sort.add(monthChoice);
        // Choice Năm
        int year = Calendar.getInstance().get(Calendar.YEAR);//Lấy năm hiện tại
        yearChoice = new Choice();
        yearChoice.setFont(font0);
        yearChoice.add("Không");
        for(int i = year ; i >= 1999 ; i--)
        {
            yearChoice.add(String.valueOf(i));
        }
        yearChoice.select(0);
        yearChoice.setBounds(new Rectangle(170,42,80,40));
        sort.add(yearChoice);
        /*************************************/
        
        /************ SORT THEO GIÁ ***************/
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(300,40,80,30);
        sort.add(sortPrice);
        
        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(380,42,100,26));
        sort.add(txtMinPrice);
        
        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(490, 56, 10, 6);
        sort.add(sepPrice);
        
        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(510,42,100,26));
        sort.add(txtMaxPrice);
          
        /******************************************/
        /************ SORT MÃ SP ***************/
        JLabel sortSP = new JLabel("Mã SP :");
        sortSP.setFont(font0);
        sortSP.setBounds(650,40,60,30);
        sort.add(sortSP);

        txtMaSP = new JTextField();
        txtMaSP.setFont(font0);
        txtMaSP.setBounds(new Rectangle(700,42,100,26));  
        sort.add(txtMaSP);
//        /******************************************/
        JLabel btnSearch = new JLabel(new ImageIcon("./src/image/btnSearch_45px.png"));
        btnSearch.setBounds(new Rectangle(840,20,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
               search();
           }
        });
        sort.add(btnSearch);
        
        add(sort);

/****************************************************************/        
        
        
        
     
        
        
    }
    
    public void search()
    {
        
        
        int mm = monthChoice.getSelectedIndex()-1;
        int yyy ;
        try{
            yyy = Integer.parseInt(yearChoice.getSelectedItem());
        }catch(NumberFormatException ex)
        {
            yyy = 0;
        }
        double max = txtMaxPrice.getText().equals("") ? 99999999 : Double.parseDouble(txtMaxPrice.getText());
        double min = txtMinPrice.getText().equals("") ? 0      : Double.parseDouble(txtMinPrice.getText());

//        outModel(model,pnhBUS.search(mm, yyy, max, min,ctBUS.getHDBySP(Integer.parseInt(txtMaSP.getText()))));
    }
    
    public void cleanView()  {
      txtMaPNH.setText("");
      txtMaNCC.setText("");
      txtMaNV.setText("");
      txtNgayHD.setText("");
      txtTongTien.setText("");
    }
    
    public void outModel(DefaultTableModel model, ArrayList<PhieuNhapHangDTO> hd){     //xuat tu arraylist len table
        Vector data;
        model.setRowCount(0);
        for(PhieuNhapHangDTO h : hd){
            data = new Vector();
            data.add(h.getId_PNH());
            data.add(h.getId_NCC());
            data.add(h.getId_NV());
            data.add(h.getDate_add());
            data.add(h.getTotal_money());
            model.addRow(data);
        }
        tbl.setModel(model);
    }
    
    public void list() // Chép ArrayList lên table
    {
        if(pnhBUS.getPnhBUS()== null)pnhBUS.list();
        ArrayList<PhieuNhapHangDTO> hd = (ArrayList<PhieuNhapHangDTO>) pnhBUS.getPnhBUS();
        model.setRowCount(0);
        outModel(model,hd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMaNV) // Suggest Nhan Vien
        {
            SuggestNhanVien rm = new SuggestNhanVien();
            String s = rm.getTextFieldContent();
            txtMaNV.setText(s);
        }
        if (e.getSource() == btnMaNCC) // Suggest Nha cung cap
        {
            SuggestNhaCungCap rm = new SuggestNhaCungCap();
            String s = rm.getTextFieldContent();
            txtMaNCC.setText(s);
        }
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
