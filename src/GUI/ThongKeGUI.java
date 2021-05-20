/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
import com.kingaspx.toast.util.Toast;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static oracle.jrockit.jfr.events.Bits.longValue;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
  

/**
 *
 * @author ACER
 */
public class ThongKeGUI extends JPanel{
    ThongKeBUS tkBUS = new ThongKeBUS();
    private int DEFAUTL_WIDTH;
    private JLabel lbDateStart,lbDateEnd;
    private JPanel panel;

    JDateChooser txtDateStart = new JDateChooser();
    JDateChooser txtDateEnd = new JDateChooser();
    
    public ThongKeGUI(int width) {
        this.DEFAUTL_WIDTH = width;
        init();
    }
    
    public void init(){   
    setSize(DEFAUTL_WIDTH, 700);
    setBackground(new Color(247, 241, 227));
    setLayout(null);
    
    Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
		
    panel = new JPanel();
    panel.setBounds(350, 65, 700, 450);
    panel.setBackground(new Color(247, 241, 227));
    
    lbDateStart = new JLabel("Ngày Bắt Đầu:");
    lbDateStart.setFont(font0);
    lbDateStart.setBounds(20, 100, 100, 30);
    txtDateStart.setBounds(new Rectangle(120, 100, 190, 30));
    txtDateStart.setDateFormatString("dd/MM/yyyy");
    add(lbDateStart);
    add(txtDateStart);
        
    
    lbDateEnd = new JLabel("Ngày Kết Thúc:");
    lbDateEnd.setFont(font0);
    lbDateEnd.setBounds(20, 150, 100, 30);
    txtDateEnd.setBounds(new Rectangle(120, 150, 190, 30));
    txtDateEnd.setDateFormatString("dd/MM/yyyy");
    add(lbDateEnd);
    add(txtDateEnd);
        
    JButton btnSubmit = new JButton("Thống kê");
    //set font chu
    Font font = new Font("Tahoma", Font.PLAIN, 18);
    btnSubmit.setFont(font);
    btnSubmit.setForeground(Color.WHITE);
    //set mau sac
    Color color = new Color(255, 218, 121);
    btnSubmit.setBackground(color);
    btnSubmit.setBorder(createLineBorder(new Color(134, 64, 0), 3, true));
    //set vi tri
    btnSubmit.setBounds(120, 230, 120, 35);
    add(btnSubmit);
    
    btnSubmit.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        hienthichart();
    }
});
    add(panel);
    
    }
    
    public void hienthichart(){
        final long startTime = System.currentTimeMillis();
            DefaultCategoryDataset dcd = new DefaultCategoryDataset();
            LocalDate startDate = Instant.ofEpochMilli(txtDateStart.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = Instant.ofEpochMilli(txtDateEnd.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            
            //validation
            if(endDate.isBefore(startDate)){
                new Toast.ToastWarning("Ngày nhập không hợp lệ !!!", Toast.SHORT_DELAY);
                return;
            }

            List<ThongKeDTO> tks = tkBUS.getChartByTime(startDate,endDate);
            for(ThongKeDTO tk : tks){
                dcd.setValue(tk.getDoanhThu(), "doanhthu", tk.getNameSP());
                System.out.println(tk.getNameSP());
            }
            JFreeChart jchart = ChartFactory.createBarChart("Doanh Thu Bán Hàng", "Tên Sản Phẩm", "Doanh thu", dcd, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel chartPanel = new ChartPanel(jchart);

            panel.removeAll();
            panel.add(chartPanel);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime));
//                add(chartPanel);
    }
}
    
