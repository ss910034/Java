package myjava.homework;

import org.jfree.ui.ApplicationFrame;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.CategoryLabelPositions;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer;  
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.ui.RefineryUtilities;

import com.opencsv.CSVReader;

public class B023040041_HW7_2 extends ApplicationFrame{  

	private static final long serialVersionUID = 1L;
	private static Scanner input;
    public B023040041_HW7_2(String title,int a,int b,int c) {  
        super("JAVA_HW7_長條分布圖");          
        CategoryDataset dataset = createDataset(a,b,c);  
        JFreeChart chart = createChart(title,dataset);  
        ChartPanel chartPanel = new ChartPanel(chart);  
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 800));  
        setContentPane(chartPanel);  
    }  
      
   private CategoryDataset createDataset(int a,int b,int c) {  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        dataset.addValue(a, "product_A", "product_A");     
        dataset.addValue(b, "product_B", "product_B");     
        dataset.addValue(c, "product_C", "product_C");        
        return dataset;  
    }  

    private JFreeChart createChart(String title,CategoryDataset dataset) {          
        JFreeChart chart = ChartFactory.createBarChart3D(  
            title+"的購買統計",      // chart title  
            "產品類別",               // domain axis label  
            "個數",                  // range axis label  
            dataset,                  // data  
            PlotOrientation.VERTICAL, // orientation  
            true,                     // include legend  
            true,                     // tooltips  
            false                     // urls  
        );  
        Font font = new Font("微軟正黑體", Font.BOLD,16);
        chart.getTitle().setFont(font);
        Font font2 = new Font("微軟正黑體", Font.PLAIN,16);
        CategoryPlot plot = chart.getCategoryPlot();
         plot.getRangeAxis().setLabelFont(font2);
         plot.getDomainAxis().setLabelFont(font2);
        // 設定 Label(Category1, Category2) 轉動角度 360度/8=45度  
        CategoryAxis axis = plot.getDomainAxis(); 
        axis.setCategoryLabelPositions(  
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)  
        );  
          
        CategoryItemRenderer renderer = plot.getRenderer();  
        renderer.setBaseItemLabelsVisible(true);  
        BarRenderer r = (BarRenderer) renderer;  
        r.setMaximumBarWidth(0.06); // 設定 Single Bar width 佔 所有 Space 的百分比  
        return chart;  
    }  

    public static void main(String[] args) {  
    	while(true){
	    	input = new Scanner(System.in);
	    	System.out.print("Please input the ID : ");
	    	String in = input.next();
	    	HashMap<String, Integer> store1 = new HashMap<String , Integer> (8000);
	        File file = new File("query_result.csv");
	        int count = 1,a = 0,b = 0,c = 0;
	    	try{
	    		CSVReader reader = new CSVReader(new FileReader(file));
	    		String[] nextLine;
	    		try {
					while((nextLine = reader.readNext()) != null){
						if(in.equals(nextLine[0])){
							store1.put(nextLine[1], count++);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		for (String key : store1.keySet()){
	    			if(key.equals("Product_A"))
	    				a = store1.get(key);
	    			else if(key.equals("Product_B"))
	    				b = store1.get(key);
	    			else if(key.equals("Product_C"))
	    				c = store1.get(key);
	    		}
	    	} 
	        catch(FileNotFoundException e){
	        	e.printStackTrace();
	        }
	        B023040041_HW7_2 demo = new B023040041_HW7_2(in,a,b,c);  
	        demo.pack();  
	        RefineryUtilities.centerFrameOnScreen(demo);  
	        demo.setVisible(true);  
    	}
    }  
}  