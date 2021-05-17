/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.ThongKeBUS;
import DTO.ThongKeDTO;
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
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    JFormattedTextField txtDateStart = new JFormattedTextField(df);
    JFormattedTextField txtDateEnd = new JFormattedTextField(df);
    
    public ThongKeGUI(int width) {
        this.DEFAUTL_WIDTH = width;
        init();
    }
    
    public void init(){   
    setSize(DEFAUTL_WIDTH, 700);
    setLayout(null);
    
    Font font0 = new Font("Segoe UI", Font.PLAIN, 14);
		
    panel = new JPanel();
    panel.setBounds(246, 21, 800, 1000);
    
    lbDateStart = new JLabel("Ngày Bắt Đầu:");
    lbDateStart.setFont(font0);
    lbDateStart.setBounds(20, 100, 100, 30);
    txtDateStart.setBounds(new Rectangle(120, 100, 190, 30));
    add(lbDateStart);
    add(txtDateStart);
    
    txtDateStart .addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
      {
        JOptionPane.showMessageDialog(null, "Please Enter Valid");
        e.consume();
      }
    }
  });
    
    lbDateEnd = new JLabel("Ngày Kết Thúc:");
    lbDateEnd.setFont(font0);
    lbDateEnd.setBounds(20, 150, 100, 30);
    txtDateEnd.setBounds(new Rectangle(120, 150, 190, 30));
    add(lbDateEnd);
    add(txtDateEnd);
    
    txtDateEnd .addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
      {
        JOptionPane.showMessageDialog(null, "Please Enter Valid");
        e.consume();
      }
    }
  });
    
    

    JButton btnSubmit = new JButton("Thống kê");
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
                List<ThongKeDTO> tks = tkBUS.getChartByTime(LocalDate.parse(txtDateStart.getText(), formatter),LocalDate.parse(txtDateEnd.getText(), formatter) );

        final long endTime = System.currentTimeMillis();
                for(ThongKeDTO tk : tks){
                    dcd.setValue(tk.getDoanhThu(), "doanhthu", tk.getNameSP());
                    System.out.println(tk.getNameSP());
                }
                JFreeChart jchart = ChartFactory.createBarChart("Doanh Thu Record", "Tên Sản Phẩm", "Doanh thu", dcd, PlotOrientation.VERTICAL, true, true, false);
                ChartPanel chartPanel = new ChartPanel(jchart);

                panel.removeAll();
                panel.add(chartPanel);
                System.out.println("Total execution time: " + (endTime - startTime));
//                add(chartPanel);
    }
}
    
