package ifs;


public class BarnsleyFernIfs implements AffineTransformation {

	private String name = "Barnsley Fern";
	private double scale =100;
	private int height =503;
	private int width = 1019;
	private int xOffset = 228;
	private int yOffset = 10;

	private double Arr1[][] = new double[][] {
		{0.00, 0.00, 0.00, 0.16, 0.00, 0.00, 0.01},
		{0.85, 0.04,-0.04, 0.85, 0.00, 1.60, 0.85},
		{0.20, -0.26,0.23, 0.22, 0.00, 1.60, 0.07},
		{-0.15, 0.28, 0.26, 0.24, 0.00, 0.44,0.07}
	};

	public double[][] getAffine(){
	return Arr1;
	}
	
	public String getname() {
	return name;
	}
	
	public int getheight() {
	return height;
	}
	public double getscale() {
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