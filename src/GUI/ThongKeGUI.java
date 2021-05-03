/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.SanPhamBUS;
import BUS.ThongKeBUS;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ThongKeGUI extends JPanel implements ActionListener,ItemListener,ChangeListener{
    private SanPhamBUS spBUS = new SanPhamBUS();
    private NhanVienBUS nvBUS = new NhanVienBUS();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private int DEFALUT_WIDTH;
    private JLabel lbFromDate,lbToDate;
    private JPanel Toggle,controlRadio;
    private JButton onOffButton;
    private boolean OnOff = true; // TRUE is ALL || FALSE is TOP
    private JLabel lbId,lbTime;
    private ButtonGroup id,Time;
    private JRadioButton ckMaSP,ckMaNV,ckMaKH,ckDate,ckTrimester,ckPeriod;
    
    //time
    private JPanel form,paneTime;
    private JLabel lbMa;
    private JTextField txtMa;
    private JButton btnStatistic,btnSuggest;    
    private JComboBox<String> cmbFromDate,cmbFromMonth,cmbFromYear;
    private JComboBox<String> cmbToDate,cmbToMonth,cmbToYear;
    //quý
    private JPanel paneTrimester;
    private JLabel lbTrimester,lbYearTrimester;
    private JComboBox<String> cmbTrimester,cmbYearTrimester;
    //kỳ
    private JPanel panePeriod;
    private JLabel lbPeriod,lbYearPeriod;
    private JComboBox<String> cmbPeriod,cmbYearPeriod;
    
    //PHẦN HIỆN THÔNG TIN(bên phải)
    private JTextArea viewStatistic;
    private JScrollPane scrollViewALL,scrollViewTable;
    private JTable tbl;
    private DefaultTableModel model;
    
    
    public ThongKeGUI(int width) {
        spBUS.list();
        nvBUS.list();
        khBUS.list();
        this.DEFALUT_WIDTH= width;
        init();
    }
    
    public void init(){
        setLayout(null);
        setBackground(null);
        setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH - 220, 730));
        
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI", Font.BOLD, 13);
/************** PHẦN KIỄM KÊ *****************************************/

        JPanel control = new JPanel(null);
        control.setBackground(null);
        control.setBounds(new Rectangle(0,0,(DEFALUT_WIDTH - 220)/2,730));
        
        // ************Chuyển đổi ALL và TOP*********
        Toggle = new JPanel(null);
        Toggle.setBackground(Color.GRAY);
        Toggle.setBounds(new Rectangle(0,10,120,30));
                //nut ALL
        onOffButton = new JButton("ALL");
        onOffButton.setBounds(new Rectangle(0,0,60,30));
        Toggle.add(onOffButton);
        onOffButton.addActionListener(this);   
        
        add(Toggle);
        
        //*************Bảng thông tin***************
        
        controlRadio = new JPanel(new GridLayout(2, 4));
        controlRadio.setBounds(new Rectangle(0,50,(DEFALUT_WIDTH - 220)/2 - 10,150));
//        controlRadio.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // CHỌN MÃ CẦN THỐNG KÊ
        
        lbId = new JLabel("Chọn mã");
        lbId.setFont(font1);                   
                
        id = new ButtonGroup();
        
        ckMaSP = new JRadioButton("Sản Phẩm");
        ckMaSP.setFont(font0);
        ckMaSP.setSelected(true);
        ckMaSP.addItemListener(this);
        id.add(ckMaSP);        
        ckMaNV = new JRadioButton("Nhân viên");
        ckMaNV.setFont(font0);
        ckMaNV.addItemListener(this);
        id.add(ckMaNV);
        ckMaKH = new JRadioButton("Khách hàng");
        ckMaKH.setFont(font0);
        ckMaKH.addItemListener(this);
        id.add(ckMaKH);
        
//-----------------

        lbTime = new JLabel("Chọn thời gian");
        lbTime.setFont(font1);
        
        Time = new ButtonGroup();
        
        ckDate = new JRadioButton("DD/MM/YYYY");
        ckDate.setFont(font0);
        ckDate.setSelected(true);
        ckDate.addItemListener(this);
        Time.add(ckDate);
        ckTrimester = new JRadioButton("Quý");
        ckTrimester.setFont(font0);
        ckTrimester.addItemListener(this);
        Time.add(ckTrimester);
        ckPeriod = new JRadioButton("Kỳ(4 tháng)");
        ckPeriod.setFont(font0);
        ckPeriod.addItemListener(this);
        Time.add(ckPeriod);
        
            //*******hien thi********
        controlRadio.add(lbId);
        controlRadio.add(ckMaSP);
        controlRadio.add(ckMaNV);
        controlRadio.add(ckMaKH);
        controlRadio.add(lbTime);
        controlRadio.add(ckDate);
        controlRadio.add(ckTrimester);
        controlRadio.add(ckPeriod);
        
        control.add(controlRadio);
        
//*********************** Panel điền thông tin ***********************//            
        
        form = new JPanel(null);
        form.setBackground(null);
        form.setBounds(new Rectangle(0,230,(DEFALUT_WIDTH - 220)/2 - 10,300));
        
        /******************NHẬP MÃ********************/        
        
        lbMa.setBounds(new Rectangle(0,0,100,30));
        lbMa.setFont(font0);
        txtMa.setBounds(new Rectangle(110,0,230,30));
        txtMa.setFont(font0);
        txtMa.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    btnStatistic.doClick();
                }
            }
        });
        btnSuggest = new JButton("...");
        btnSuggest.setBounds(new Rectangle(340,0,30,30));
        btnSuggest.addActionListener(this);
        
        form.add(lbMa);
        form.add(txtMa);
        form.add(btnSuggest);
        
        /**************** CHỌN TIME ********************************/
        paneTime = new JPanel(null);
        paneTime.setBackground(null);
        paneTime.setBounds(new Rectangle(0,40,(DEFALUT_WIDTH - 220)/2 - 10,80));
        
        // FROM
        lbFromDate = new JLabel("Từ ngày");
        lbFromDate.setFont(font0);
        lbFromDate.setBounds(new Rectangle(0,0,100,30));
        
        cmbFromDate = new JComboBox<>();
        cmbFromDate.setBounds(new Rectangle(110,0,80,30));
        cmbFromDate.setFont(font0);
        listDate(cmbFromDate,true);
        JLabel sepTime0 = new JLabel("/");
        sepTime0.setFont(font0);
        sepTime0.setBounds(new Rectangle(195,0,10,30));
        
        cmbFromMonth.addActionListener(this);
        cmbFromMonth.setBounds(new Rectangle(205,0,80,30));
        cmbFromMonth.setFont(font0);
        listMonth(cmbFromMonth);
        JLabel sepTime1 = new JLabel("/");
        sepTime1.setFont(font0);
        sepTime1.setBounds(new Rectangle(290,0,10,30));
        
        cmbFromYear.addActionListener(this);
        cmbFromYear.setBounds(new Rectangle(300,0,80,30));
        cmbFromYear.setFont(font0);
        listYear(cmbFromYear);
        
        System.out.print(cmbFromYear.getSelectedIndex());
        
        paneTime.add(lbFromDate);
        paneTime.add(cmbFromDate);
        paneTime.add(sepTime0);
        paneTime.add(cmbFromMonth);
        paneTime.add(sepTime1);
        paneTime.add(cmbFromYear);
        
        // TO
        lbToDate = new JLabel("Đến ngày");
        lbToDate.setFont(font0);
        lbToDate.setBounds(new Rectangle(0,40,100,30));
        
        cmbToDate.setBounds(new Rectangle(110,40,80,30));
        cmbToDate.setFont(font0);
        listDate(cmbToDate,false);
        JLabel sepTime2 = new JLabel("/");
        sepTime2.setFont(font0);
        sepTime2.setBounds(new Rectangle(195,40,10,30));
        
        cmbToMonth.addActionListener(this);
        cmbToMonth.setBounds(new Rectangle(205,40,80,30));
        cmbToMonth.setFont(font0);
        listMonth(cmbToMonth);
        JLabel sepTime3 = new JLabel("/");
        sepTime3.setFont(font0);
        sepTime3.setBounds(new Rectangle(290,40,10,30));
        
        cmbToYear.addActionListener(this);
        cmbToYear.setBounds(new Rectangle(300,40,80,30));
        cmbToYear.setFont(font0);
        listYear(cmbToYear);
        
        
        paneTime.add(lbFromDate);
        paneTime.add(cmbFromDate);
        paneTime.add(sepTime0);
        paneTime.add(cmbFromMonth);
        paneTime.add(sepTime1);
        paneTime.add(cmbFromYear);
        
        paneTime.add(lbToDate);
        paneTime.add(cmbToDate);
        paneTime.add(sepTime2);
        paneTime.add(cmbToMonth);
        paneTime.add(sepTime3);
        paneTime.add(cmbToYear);
        
        form.add(paneTime);
        
/*************** CHỌN THEO QUÝ *****************************/

        paneTrimester = new JPanel(null);
        paneTrimester.setBackground(null);
        paneTrimester.setBounds(new Rectangle(0,40,(DEFALUT_WIDTH - 220)/2 - 10,80));
        
        lbTrimester = new JLabel("Quý");
        lbTrimester.setFont(font0);
        lbTrimester.setBounds(new Rectangle(0,0,100,30));
        
        cmbTrimester.setBounds(new Rectangle(110,0,160,30));
        cmbTrimester.setFont(font0);
        for(int i = 1 ; i <=12  ; i+=3)
        {
            cmbTrimester.addItem("Quý "+(i+2)/3+" ( tháng "+i+" - "+(i+2)+" )");
        }
        
        lbYearTrimester = new JLabel("Năm",JLabel.CENTER);
        lbYearTrimester.setFont(font0);
        lbYearTrimester.setBounds(new Rectangle(270,0,40,30));
        
        cmbYearTrimester.setBounds(new Rectangle(310,0,80,30));
        cmbYearTrimester.setFont(font0);
        listYear(cmbYearTrimester);
        cmbYearTrimester.removeItemAt(0);
        
        paneTrimester.add(lbTrimester);
        paneTrimester.add(cmbTrimester);
        paneTrimester.add(lbYearTrimester);
        paneTrimester.add(cmbYearTrimester);
        
        paneTrimester.setVisible(false);
        
        form.add(paneTrimester);
        /***********************************************************/
        
        /*************** CHỌN THEO KỲ *****************************/
        
        panePeriod = new JPanel(null);
        panePeriod.setBackground(null);
        panePeriod.setBounds(new Rectangle(0,40,(DEFALUT_WIDTH - 220)/2 - 10,80));
        
        lbPeriod = new JLabel("Kỳ");
        lbPeriod.setFont(font0);
        lbPeriod.setBounds(new Rectangle(0,0,100,30));
        
        cmbPeriod.setBounds(new Rectangle(110,0,160,30));
        cmbPeriod.setFont(font0);
        for(int i = 1 ; i <=12  ; i+=4)
        {
            cmbPeriod.addItem("Kỳ "+(i+3)/4+" ( tháng "+i+" - "+(i+3)+" )");
        }
        
        lbYearPeriod = new JLabel("Năm",JLabel.CENTER);
        lbYearPeriod.setFont(font0);
        lbYearPeriod.setBounds(new Rectangle(270,0,40,30));
        
        cmbYearPeriod.setBounds(new Rectangle(310,0,80,30));
        cmbYearPeriod.setFont(font0);
        listYear(cmbYearPeriod);
        cmbYearPeriod.removeItemAt(0);
        
        panePeriod.add(lbPeriod);
        panePeriod.add(cmbPeriod);
        panePeriod.add(lbYearPeriod);
        panePeriod.add(cmbYearPeriod);
        
        panePeriod.setVisible(false);
        form.add(panePeriod);
        /***********************************************************/
        
        
        btnStatistic = new JButton("Thống kê");
        btnStatistic.setFont(new Font("Segoe UI",Font.PLAIN,15) {
        });
        btnStatistic.setBounds(new Rectangle(50,140,(DEFALUT_WIDTH - 220)/2 - 100,40));
        btnStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStaticticAction(e);
            }
        });
        
        form.add(btnStatistic);
        
        control.add(form);
        
        add(control);
/*********************************************************************/        

/*************** PHẦN HIỆN THÔNG TIN *********************************/
        
        viewStatistic = new JTextArea();
        viewStatistic.setEditable(false);
        
        scrollViewALL = new JScrollPane(viewStatistic);
        scrollViewALL.setBounds(new Rectangle(570,20,(DEFALUT_WIDTH - 220)/2 - 100 ,500));
        
        add(scrollViewALL);


        /*************** NHẤP TOGGLE ALL **************/
        Vector header = new Vector();
        header.add("STT");
        header.add("Mã SP");
        header.add("Tên SP");
        header.add("SL Bán");

        model = new DefaultTableModel(header,5);
        tbl = new JTable(model);

        
        // CUSTOM TABLE
        tbl.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);
        
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(new Color(232,57,99));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        scrollViewTable = new JScrollPane(tbl);
        scrollViewTable.setBounds(new Rectangle(570,20,(DEFALUT_WIDTH - 220)/2 - 100 ,500));
        scrollViewTable.setVisible(false);
        
        add(scrollViewTable);
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    public void outStatistic(ArrayList<String> sp)
    {
        model.setRowCount(0);
        for(int i = 0 ; i < sp.size() ; i++)
        {
            System.out.print(sp.get(i));
            String[] s = sp.get(i).split("_");
//            System.out.println(s[1]);
            /**********/
            String maSP = s[0].trim();
            String tenSP = s[1].trim();
            String sl = s[2].trim();
            System.out.println(maSP);
            Vector data = new Vector();
            data.add(i+1);
            data.add(maSP);
            data.add(tenSP);
            data.add(sl);
            model.addRow(data);
        }
        tbl.setModel(model);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(15);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(140);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //Switch On Off
        if(obj.equals(onOffButton))
        {
            Color color = new Color(61, 252, 47);
            int change = 60;
            String text = "TOP";
            if(!OnOff)
            {
                change = 0;
                text = "ALL";
                color = Color.GRAY;
            }
            onOffButton.setText(text);
            onOffButton.setBounds(new Rectangle(change,0,60,30));
            Toggle.setBackground(color);
            Toggle.add(onOffButton);
            
            
            lbMa.setVisible(!OnOff);
            txtMa.setVisible(!OnOff);
            btnSuggest.setVisible(!OnOff);
            
            scrollViewALL.setVisible(!OnOff);
            scrollViewTable.setVisible(OnOff);
            
            OnOff = !OnOff;
            repaint();
            revalidate();
        }
        
        
        if(obj.equals(cmbFromMonth) || obj.equals(cmbFromYear))
        {
            cmbFromDate.removeAllItems();
            listDate(cmbFromDate,true);
        }
        if(obj.equals(cmbToMonth) || obj.equals(cmbToYear))
        {
            cmbToDate.removeAllItems();
            listDate(cmbToDate,false);
        }
        if(obj.equals(btnSuggest))
        {
            if(ckMaSP.isSelected())
            {
                SuggestSanPham sp = new SuggestSanPham(txtMa.getText());
                String s = sp.getTextFieldContent();
                txtMa.setText(s.split("%")[0]);
            }
            else if(ckMaNV.isSelected())
            {
                SuggestNhanVien sp = new SuggestNhanVien();
                String s = sp.getTextFieldContent();
                txtMa.setText(s);
            }
            else if(ckMaKH.isSelected())
            {
                SuggestKhachHang sp = new SuggestKhachHang();
                String s = sp.getTextFieldContent();
                txtMa.setText(s);
            }
        }
    }
    
    public void btnStaticticAction (ActionEvent e)
    {
        ThongKeBUS tk = new ThongKeBUS();
        String ma = txtMa.getText();
        Object obj = null;
        if(ckMaSP.isSelected())
        {
            if(OnOff)
            {
                obj = new SanPhamDTO();
                obj = spBUS.getSP(ma);
                if(obj == null)
                {
                    JOptionPane.showMessageDialog(null, "Không tồn tại sản phầm !!");
                    return;
                }
            }
        }
        else if(ckMaNV.isSelected())
        {
            if(OnOff)
            {
                obj = new NhanVienDTO();
                obj = nvBUS.getEmployeeById(ma);
                if(obj == null)
                {
                    JOptionPane.showMessageDialog(null, "Không tồn tại nhân viên !!");
                    return;
                }
            }
        }
        else if(ckMaKH.isSelected())
        {
            if(OnOff)
            {
                obj = new KhachHangDTO();
                obj = khBUS.getCustomerById(ma);
                if(obj == null)
                {
                    JOptionPane.showMessageDialog(null, "Không tồn tại khách hàng !!");
                    return;
                }
            }
        }
        
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        
        // THÔNG KÊ THEO NGÀY
        if(ckDate.isSelected())
        {
            int fYear = cmbFromYear.getSelectedIndex()>0 ? Integer.parseInt(cmbFromYear.getSelectedItem().toString()) : 2000;
            int fMonth = cmbFromMonth.getSelectedIndex()>0 ? cmbFromMonth.getSelectedIndex()-1 : 0;
            int fDate =  cmbFromDate.getSelectedIndex()>0 ? Integer.parseInt(cmbFromDate.getSelectedItem().toString()) : 1;
            from.set(fYear, fMonth, fDate, 0, 0, 0);

            int tYear = cmbToYear.getSelectedIndex()>0 ? Integer.parseInt(cmbToYear.getSelectedItem().toString()) : Calendar.getInstance().get(Calendar.YEAR);
            int tMonth = cmbToMonth.getSelectedIndex()>0 ? cmbToMonth.getSelectedIndex()-1 : 11;
            int maxDate = cmbToDate.getItemCount();
            System.out.println(maxDate);
            int tDate =  cmbToDate.getSelectedIndex()>0 ? Integer.parseInt(cmbToDate.getSelectedItem().toString()) : maxDate-1;
            to.set(tYear, tMonth, tDate,23,0,0);
        }
        // THỐNG KÊ THEO QUÝ
        else if(ckTrimester.isSelected())
        {
            int year = Integer.parseInt(cmbYearTrimester.getSelectedItem().toString());
            int fMonth = (cmbTrimester.getSelectedIndex()+1)*3-2;
            int tMonth = fMonth + 2;
            
            from.set(year,fMonth-1,1,0,0,0);
            to.set(year, tMonth-1, 1,23,0,0);
            int dateOfMonth = to.getActualMaximum(Calendar.DAY_OF_MONTH);
            to.set(Calendar.DATE, dateOfMonth);
        }
        else if(ckPeriod.isSelected()) 
        {
            int year = Integer.parseInt(cmbYearPeriod.getSelectedItem().toString());
            int fMonth = (cmbPeriod.getSelectedIndex()+1)*4-3;
            int tMonth = fMonth + 3;
            
            from.set(year,fMonth-1,1,0,0,0);
            to.set(year, tMonth-1, 1,23,0,0);
            int dateOfMonth = to.getActualMaximum(Calendar.DAY_OF_MONTH);
            to.set(Calendar.DATE, dateOfMonth);
        }
                
        
        System.out.print(from.getTime());
        System.err.println(to.getTime());
        
        if(to.before(from))
        {
            JOptionPane.showMessageDialog(null,"Lỗi");
            return;
        }
        
        if(OnOff)
        {
            String result = "";
            if(ckMaSP.isSelected())
            {
                result = tk.StatisticSP(ma, from, to);
            }
            else if(ckMaNV.isSelected())
            {
                result = tk.StatisticNV(ma, from, to);
            }
            else if(ckMaKH.isSelected())
            {
                result = tk.StatisticKH(ma, from, to);
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");

//            viewStatistic.setText( outStatistic( obj,sdf.format( from.getTime() ), sdf.format( to.getTime() ) ,result) );

        }
        else
        {
            if(ckMaSP.isSelected())
            {
                Vector header = new Vector();
                header.add("STT");
                header.add("Mã SP");
                header.add("SL Bán");
                model = new DefaultTableModel(header,5);
                header.add("Tên SP");
                
                outStatistic(tk.StatisticTopSP(from, to));
            }
            else if(ckMaNV.isSelected())
            {
                Vector header = new Vector();
                header.add("STT");
                header.add("Mã NV");
                header.add("Họ và Tên");
                header.add("Tổng tiền(VNĐ)");
                model = new DefaultTableModel(header,5);
                
                outStatistic(tk.StatisticTopNV(from, to));
            }
            else if(ckMaKH.isSelected())
            {
                Vector header = new Vector();
                header.add("STT");
                header.add("Mã KH");
                header.add("Họ và Tên");
                header.add("Tổng tiền(VNĐ)");
                model = new DefaultTableModel(header,5);
                
                outStatistic(tk.StatisticTopKH(from, to));
            }
        }
    }

    public void listDate(JComboBox cmb,boolean flag) // TRUE is FROM - FALSE is TO
    {
        cmb.addItem("Không");
        int thisMonth = 12 , thisDate = 31 ,thisYear = Calendar.getInstance().get(Calendar.YEAR);
        if( cmbFromYear.getSelectedIndex() > 0 || cmbToYear.getSelectedIndex() > 0)
        {
            thisYear = flag ? Integer.parseInt(cmbFromYear.getSelectedItem().toString()) : Integer.parseInt(cmbToYear.getSelectedItem().toString());
//            System.out.println(thisYear);
        }
        if( cmbFromMonth.getSelectedIndex() > 0 || cmbToMonth.getSelectedIndex() > 0)
        {
            thisMonth = flag?cmbFromMonth.getSelectedIndex():cmbToMonth.getSelectedIndex();
//            System.out.println(thisMonth);
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(thisYear, thisMonth - 1, 1);
//        System.out.println(calendar.getTime());
        thisDate = calendar.getActualMaximum(Calendar.DATE);
//        System.out.println(thisDate);
        
        for(int i = 1 ; i <= thisDate ; i++)
        {
            cmb.addItem(i);
        }
    }
    public void listMonth(JComboBox cmb)
    {
        cmb.addItem("Không");
        for(int i = 1 ; i <= 12 ; i++ )
        {
            cmb.addItem(i);
        }
    }
    public void listYear(JComboBox cmb)
    {
        cmb.addItem("Không");
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = thisYear ; i >= thisYear - 20 ; i-- )
        {
            cmb.addItem(i);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
