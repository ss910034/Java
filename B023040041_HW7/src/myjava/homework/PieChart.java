package myjava.homework;

import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart extends JFrame{  

	private static final long serialVersionUID = 1L;

	public PieChart(int a, int b, int c, int female, int male) {  
        super("B023040041_HW7");  
       
        setVisible(true);
        setLayout(new GridLayout(1,2));
        
        // This will create the dataset   
        DefaultPieDataset dataset = new DefaultPieDataset();
        DecimalFormat df = new DecimalFormat("#.##");
        dataset.setValue("Product A: " + df.format(a*1.0/(a+b+c) * 100) + "%",a);
        dataset.setValue("Product B: " + df.format(b*1.0/(a+b+c) * 100) + "%",b);
        dataset.setValue("Product C: " + df.format(c*1.0/(a+b+c) * 100) + "%",c);
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("female :" + df.format(female * 1.0 / (female + male) * 100), female);
        dataset1.setValue("female :" + df.format(male * 1.0 / (female + male) * 100 ), male);
        // based on the dataset we create the chart  
        JFreeChart chart = ChartFactory.createPieChart("product_type", dataset, true, true, false); 
        JFreeChart chart1 = ChartFactory.createPieChart("id_sex", dataset1, true, true, false); 
        
              
        // we put the chart into a panel  
        ChartPanel chartPanel = new ChartPanel(chart); 
        chartPanel.setSize(400,800);
        chartPanel.setVisible(true);
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setSize(400,800);
        chartPanel1.setVisible(true);
        add(chartPanel);
        add(chartPanel1);
        repaint();
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        // setup dynamic data input    
    }  
 
}
     
   