package ifs;

public class maple implements AffineTransformation {
	
		
		
		private double Arr1[][] = new double[][] {
			{0.51, 0.00, 0.01, 0.14, 1.31, 0.08, 0.10},
			{0.50, -0.45,0.52, 0.43, 0.75, -1.49, 0.35},
			{0.47, 0.47,-0.49, 0.45, 0.74, 1.62, 0.35},
			{0.51, 0.00, 0.00, 0.49, -1.62, -0.02, 0.20}	
		};
		
		private String name = "Maple leaf";
		private double scale =100;
		private int height =702;
		private int width = 885;
		private int xOffset = 340;
		private int yOffset = 445;


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
