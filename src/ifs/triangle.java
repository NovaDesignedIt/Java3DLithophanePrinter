
package ifs;

public class triangle implements AffineTransformation {

	private double Arr1[][] = new double[][] {
		{0.50, 0.00, 0.00,0.50, 0.00, 0.00, 0.33},
		{0.50, 0.00, 0.00, 0.50, 0.00, 0.50, 0.33},
		{0.50, 0.00, 0.00, 0.50, 0.43, 0.25, 0.34}
		
	};
	
	private String name = "Sierpinskilfs Gasket";
	private int width = 519;
	private double scale = -500;
	private int height = 449;
	private int xOffset = 439;
	private int yOffset = 509;
	
	 
	public String getname() {
	return name;
	}
	
	public double[][] getAffine(){
		
	return Arr1;
	}
	
	public int getheight() {
	return height;
	}
	
	public  double getscale() {
	return scale;
	}
	
	public int getwidth() {
	return width;
	}
	
	public int getxOffset() {
	return xOffset;
	}
	
	public int getyOffset() {
	return yOffset;
	
	} 
			
}
