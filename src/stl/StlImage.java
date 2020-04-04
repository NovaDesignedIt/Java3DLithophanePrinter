package stl;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.stream.IntStream;


public class StlImage {
    private double minThick, thickScale, maxValue;
    private double scale = 0.1;
    public StlImage(double min, double max){
    this.minThick = min;
    this.thickScale = max;
    }
    public Solid createSolid(int[][] matrix) {
        // a. find the maximum value in the integer array. store it in maXValue
        double currentMax;
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                currentMax =  matrix[i][j];

                if (currentMax > maxValue) {
                    maxValue = matrix[i][j];
                }
                //System.out.print(value);
            }
        }
        //finding the max value in the array and setting it to max value.
      /*  int currentMax = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                currentMax = anInt;
                if (currentMax > maxValue) {
                    maxValue = anInt;
                }
            }
        }*/

          //b. top for every value in the integer array (not including the last value in the length and width)
        //do the following:
         //   System.out.print(maxValue); //this is working
       /* ArrayList<Vertex> vertex = new ArrayList<Vertex>();
        Solid solid = new Solid();
        for (int x = 0; x < matrix.length-1; x++) {
            for (int y = 0; y < matrix[x].length - 1; y++) {
                vertex.add(createIfsVertex(x, y, matrix[x][y]));
                vertex.add(createIfsVertex(x + 1, y, matrix[x][y + 1]));
                vertex.add(createIfsVertex(x + 1, y + 1, matrix[x + 1][y + 1]));
                vertex.add(createIfsVertex(x, y + 1, matrix[x + 1][y]));
                //tester code
                //System.out.print(x +" "+y);
            }
            //the problem is the that the VARARG  takes in 4 vertices that executes the code and it only returns
        }*/
            //Arraylist<Vertex> vertex = new Arraylist<Vertex>;
            Solid solid = new Solid();
            for (int x = 0; x < matrix.length-1; x++) {
                for (int y = 0; y < matrix[x].length - 1; y++) {
                    solid.addFacet(
                            createIfsVertex(x, y, matrix[x][y] ),
                            createIfsVertex(x + 1, y, matrix[x][y+1]),
                            createIfsVertex(x + 1, y + 1, matrix[x+1][y+1]),
                            createIfsVertex(x, y + 1, matrix[x+1][y])
                    );
                    //tester code
                   //System.out.print(x +" "+y);
                }
                //the problem is the that the VARARG  takes in 4 vertices that executes the code and it only returns
            }

                            //side 1
                    solid.addFacet(
                            new Vertex(0,0,0),
                            new Vertex(matrix.length*scale, 0,0),
                            new Vertex(matrix.length*scale,0, minThick),
                            new Vertex(0,0,minThick)
                    );
                            //side 2
                    solid.addFacet(
                            new Vertex(0, matrix[0].length*scale,0),
                            new Vertex(0,0,0),
                            new Vertex(0,0,minThick),
                            new Vertex(0, matrix[0].length*scale,minThick)
                    );
                            //side 3
                    solid.addFacet(
                            new Vertex(matrix.length*scale,0,0),
                            new Vertex(matrix.length*scale, matrix[0].length*scale,0),
                            new Vertex(matrix.length*scale, matrix[0].length*scale,minThick),
                            new Vertex(matrix.length*scale,0,minThick)
                    );
                            //side 4
                    solid.addFacet(
                            new Vertex(matrix.length*scale , matrix[0].length*scale ,0),
                            new Vertex(0, matrix[0].length*scale,0),
                            new Vertex(0, matrix[0].length*scale,minThick),
                            new Vertex(matrix.length*scale, matrix[0].length*scale,minThick)
                    );
                            //bottom
                    solid.addFacet(
                            new Vertex(0,0,0),
                            new Vertex(0, matrix[0].length*scale,0),
                            new Vertex(matrix.length*scale, matrix[0].length*scale,0),
                            new Vertex(matrix.length*scale,0,0)
                    );

                            //newside?
        //my picture was printing wrong, there was a half triangle so double the side made it full..
                    solid.addFacet(
                            new Vertex(0,0,0),
                            new Vertex(0, matrix[0].length*scale,0),
                            new Vertex(matrix.length*scale, matrix[0].length*scale,0),
                            new Vertex(matrix.length*scale,0,0)
                    );


        return solid;
    }

    private Vertex createIfsVertex(double x, double y, double z){
        //tester code works returns a non-Zero max value.
       //System.out.print(x*scale+" "+maxValue+" "+y*scale);
        return new Vertex(x*scale, y*scale, (minThick + thickScale * Math.sqrt(z/maxValue)));
    }

}
