package ifs;

public abstract interface AffineTransformation  {

	public String getname();
	
	public int getheight();
	public double getscale();
	
	public int getwidth();
	public int getxOffset();
	
	public int getyOffset();
	public double[][] getAffine();


}
