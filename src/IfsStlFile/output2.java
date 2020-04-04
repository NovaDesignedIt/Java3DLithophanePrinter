package IfsStlFile;
import ifs.AffineTransformation;
import ifs.IfsCreator;
import stl.Solid;
import stl.StlImage;

import java.io.*;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Viewer for IFS (Iterated Function System) image mapping.
 * 20W CST8132
 * @author Howard
 */
public class output2 extends JPanel {

	private static final long serialVersionUID = 8462584230403421155L;
	private final boolean COLOUR;
	private final int SCALE_TYPE;
	private final int[][] ifs;

	private output2(int[][] matrix, boolean useColour, int scaleMapping) 
	{
		ifs=matrix;
		COLOUR = useColour;
		SCALE_TYPE = scaleMapping;
		int w = ifs.length;
		int h = ifs[0].length;
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.white);
	}

	private void drawIfs(Graphics2D g) {
		//	int h = getHeight();
			//	int w = getWidth();
		int w = ifs.length;
		int h = ifs[0].length;
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);

		float max=0;
		for (int y = 0; y < h; y++) 
			for (int x = 0; x < w; x++) 
			{
				if(ifs[x][y]>max) max=ifs[x][y];
			}

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				float i=ifs[x][y];
				float scale;
				scale=i/max;

				if(SCALE_TYPE < 0)
					scale=(float)Math.sqrt(scale);
				else if(SCALE_TYPE > 0)
					scale=scale*scale;
				//scale = (max / i) % 1;

				int c;
				if(COLOUR)
					c = Color.HSBtoRGB(scale, 1, i>0?1:0);
				else
					c = Color.HSBtoRGB(0, 0, i>0?scale:1);
				image.setRGB(x, y, c);
			}
		}
		g.drawImage(image, 0, 0, null);
	}

	/**
	 * Overrides paint in the JComponent
	 */
	@Override
	protected void paintComponent(Graphics gg) {
		super.paintComponent(gg);
		Graphics2D g = (Graphics2D) gg;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawIfs(g);
	}

	/**
	 * View the IFS map on a JPanel. The mapping will be displayed in grey scale with a linear scale
	 * @param matrix The IFS map to be plotted
	 */
	public static void view(int[][] matrix)
	{
		view(matrix,false,0);
	}

	/**
	 * View the IFS map on a JPanel
	 * @param matrix The IFS map to be plotted
	 * @param useColour Should the map be in colour? if not, grey scale is used
	 * @param scaleMapping Mapping from pixel value to display value. 0 - linear scale, <0 square root scale, >0 squared scale 
	 */
	public static void view(int[][] matrix, boolean useColour, int scaleMapping)
	{
		String colourString = useColour?"Colour ":"grey ";
		String scaleString = scaleMapping>0?"Squared scale":scaleMapping==0?"Linear scale":"Square root scale";
		SwingUtilities.invokeLater(() -> {
			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("IFS "+colourString+scaleString);
			f.setResizable(false);
			f.add(new output2(matrix,useColour,scaleMapping), BorderLayout.CENTER);
			f.pack();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		});
	}

	public static void main(String[] arg) throws IOException {

		IfsCreator ifs = new IfsCreator();
		Scanner input = new Scanner(System.in);
		//changed to transform
		AffineTransformation[] transforms = ifs.getTransforms();
		
		System.out.println("Available images");
		for (int i = 0;i < transforms.length ; i++ ) {
			System.out.println(i+1+"."+transforms[i].getname());
		}
		//fix this shit below
	int selection = 0;

	 while (!(selection > 0 && selection < transforms.length+1)) {
		 System.out.print("please make a selection>>");
	 selection = input.nextInt();	
	 }	
		
	//THIS DE-INCREMENTS THE SELECTIONS
		//output2.view(ifs.GenerateIfs(t[(selection-1)]),false,0);
		System.out.print("Complete");

		//**** this

		StlImage stl = new StlImage(0.8,4.0);



		//this is supposed to output a file finish this later. looking for
		String name = "C:\\temp\\"+(transforms[(selection-1)].getname())+".stl";
		Solid solid = new Solid(transforms[(selection-1)].getname());
		solid = stl.createSolid(ifs.GenerateIfs(transforms[(selection-1)]));
		//solid.print(new PrintWriter(name),transforms[(selection-1)].getname());
		//System.out.print(transforms[3].getname());

				//Solid mySolid = stl.createSolid(ifs.GenerateIfs(t[(selection-1)]));
				//writer.print(String.valueOf(stl.createSolid(ifs.GenerateIfs(t[(selection-1)]))));

				//tester code:
			//System.out.print(stl.createSolid(ifs.GenerateIfs(t[(selection-1)])));

	}
}