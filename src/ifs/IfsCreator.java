package ifs;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IfsCreator {
	/**
	 * @param g
	 * @return
	 */
	public int[][] GenerateIfs(AffineTransformation g){

		double[][] Arr1 = g.getAffine();
		int width =  g.getwidth();
		int height = g.getheight();
		double scale = g.getscale();
		int xOffset= g.getxOffset();
		int yOffset = g.getyOffset();
		double x= 0;
		double y= 0;

		//  int[][] affine = new int [width][height];
		/*
        for(int i = 0; i< (width*height);i++) {
            double numb = Math.random();
            if(numb >= 0 && numb < 0.33 ) {
                a =Arr1[0][0]; b =Arr1[0][1]; c =Arr1[0][2];
                d =Arr1[0][3]; e =Arr1[0][4]; f =Arr1[0][5];
            }else if(numb>0.33 && numb< 0.66){
                a=Arr1[1][0]; b =Arr1[1][1]; c =Arr1[1][2];
                d =Arr1[1][3];e =Arr1[1][4]; f =Arr1[1][5];
            }else if(numb>0.66 && numb< 1 ){
                a = Arr1[2][0];b = Arr1[2][1];c = Arr1[2][2];
                d = Arr1[2][3];e = Arr1[2][4];f = Arr1[2][5];
            }else {
            		if(!(g.getname().equals("Sierpinskilfs Gasket"))){
                        a = Arr1[3][0];b = Arr1[3][1];c = Arr1[3][2];
                        d = Arr1[3][3];e = Arr1[3][4];f = Arr1[3][5];
            	}
            }
		           if (numb<0.33) {
		            	row = 0;
		           } else if (numb<0.66) {
		            	row =1;
		            }else row=2;
		            a = Arr1[row][0];b = Arr1[row][1];c = Arr1[row][2];
		            d = Arr1[row][3];e = Arr1[row][4];f = Arr1[row][5];
		            double u = a*x+b*y+e;
		            double v = c*x+d*y+f;
		            x=u;
		            y=v;
		            int xDisp = (int) (x*scale+xOffset);
		           int yDisp = (int) (y*scale +yOffset);
		           affine[yDisp][xDisp];
		       }

		int affine[][] = new int [width][height];




		 TESTOR CODE
		//for(int i=0 ;i< Arr1.length; i++) { for (int j =0; j < Arr1[i].length; j++) {
			//System.out.println(Arr1[i][j]); } }





			*/
		int yDisp = 0;
		int xDisp = 0;
		int rownum = 0;
		int affine[][] = new int [width][height];
		for(int i=0; i < (width*height); i++){

			double bottom = 0;
			double total =0;

			double prob = Math.random();

			for(int j = 0; j < Arr1.length;  j++) {
				bottom += Arr1[j][6];

				if (prob > total && prob < bottom) {
					rownum = j;

					double u = Arr1[rownum][0]*x+Arr1[rownum][1]*y+Arr1[rownum][4];
					double v =  Arr1[rownum][2]*x+Arr1[rownum][3]*y+Arr1[rownum][5];
					x = u;
					y = v;


					xDisp = (int) ((x* scale) +xOffset);
					yDisp = (int) ((y* scale) +yOffset);

					affine[yDisp][xDisp]++;
				}
				total = bottom;
			}
		}

		//MORE TESTER CODE
		//System.out.print(xDisp);

		//System.out.print(i);





		return affine;
	}


	public AffineTransformation[] getTransforms() throws IOException {

		BarnsleyFernIfs fern = new BarnsleyFernIfs();
		maple leaf = new maple();
		triangle triangle = new triangle();
		FileIfs file = new FileIfs("C:\\temp\\GoldenDragon.ifs");

		return new AffineTransformation[] { fern, leaf, triangle, file };
	}


}
