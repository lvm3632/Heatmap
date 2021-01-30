import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.tc33.jheatchart.HeatChart;



public class View2 extends JPanel{

	

    private BufferedImage image;
   

@SuppressWarnings("deprecation")
public static BufferedImage mapaNuevo() {
		
		// Create some dummy data.
		int tmp_up= Integer.parseInt(Ventana.txtTmp_up.getText());
		int tmp_down=Integer.parseInt(Ventana.txtTmpdown.getText());
		int tmp_left=Integer.parseInt(Ventana.txtTemp_left.getText());
		int tmp_right=Integer.parseInt(Ventana.txtTmp_right.getText()); 
		int rows_columns=Integer.parseInt(Ventana.textFieldRowColumns.getText());
		int double_rows=rows_columns*rows_columns;
		                                
		                                
		                                
		MatrixBuilder.matrix = MatrixBuilder.generateEcuations(rows_columns, tmp_up, tmp_down, tmp_left, tmp_right);
		 MatrixBuilder.abReduced = MatrixBuilder.Gauss_Jordan(0.00001, MatrixBuilder.matrix, double_rows);
		double[][] data = MatrixBuilder.coordenadasXY(MatrixBuilder.abReduced, rows_columns);
		
		MatrixBuilder.valores(data);
		
		// Step 1: Create our heat map chart using our data.
		HeatChart map = new HeatChart(data);
	
		
	

		// Step 2: Customise the chart.
		map.setXAxisLabel("X Axis");
		map.setYAxisLabel("Y Axis");
		
		
		 double xOffset = 200.0;
		 double yOffset = 100.0;
		 double xInterval = 200.0;
		 double yInterval = 100.0;
		 
		 map.setXValues(xInterval, xOffset);
		 map.setYValues(yInterval, yOffset);
		 
		 //map.setYAxisValuesFrequency(100);
		 //map.setXAxisValuesFrequency(100);
		map.setCellHeight(80);
		map.setCellWidth(80);
		map.setAxisLabelColour(Color.BLUE);;
		map.setYValuesHorizontal(true);
		map.setAxisThickness(3);
		map.setChartMargin(40);
		
	
		// Step 3: Output the chart to a file.
		map.setHighValueColour(Color.RED);
		map.setLowValueColour(Color.BLUE);
		map.setColourScale(1);
		map.setTitle("Mapa de calor");
		return   (BufferedImage) map.getChartImage();
	}  

public static BufferedImage mapaDefault() {
	
	// Create some dummy data.
			int tmp_up=2000,
				tmp_down=400,
				tmp_left=100,
				tmp_right=400,
				rows_columns=4,
				double_rows=rows_columns*rows_columns;
			
			                                                                                                
			MatrixBuilder.matrix = MatrixBuilder.generateEcuations(rows_columns, tmp_up, tmp_down, tmp_left, tmp_right);
			 MatrixBuilder.abReduced = MatrixBuilder.Gauss_Jordan(0.00001, MatrixBuilder.matrix, double_rows);
			double[][] data = MatrixBuilder.coordenadasXY(MatrixBuilder.abReduced, rows_columns);
	    
			
			MatrixBuilder.valores(data);
			
			HeatChart map = new HeatChart(data);
			
		
			

	System.out.println("-----------------------------");
	
	
	// Step 1: Create our heat map chart using our data.
	

	// Step 2: Customise the chart.
	 double xOffset = 200.0;
	 double yOffset = 100.0;
	 double xInterval = 200.0;
	 double yInterval = 100.0;
	 
	 map.setXValues(xInterval, xOffset);
	 map.setYValues(yInterval, yOffset);
	 //map.setYAxisValuesFrequency(100);
	// map.setXAxisValuesFrequency(100);
	/*Integer [] data2 = {100,90,80};
	
	map.setYValues(data2);*/
	map.setChartMargin(40);
	map.setCellHeight(60);
	map.setCellWidth(100);
	map.setAxisThickness(3);
	// Step 3: Output the chart to a file.
	map.setXAxisLabel("X Axis");
	map.setYAxisLabel("Y Axis");
	map.setColourScale(0.8);
	map.setHighValueColour(Color.RED);
	map.setLowValueColour(Color.BLUE);

	map.setAxisLabelColour(Color.BLUE);;
	map.setYValuesHorizontal(true);
	map.setTitle("Mapa de calor");
	return   (BufferedImage) map.getChartImage();
}  
    
    public View2() {
               
          image = mapaDefault();
      
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}