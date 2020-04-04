package stl;


import java.text.DecimalFormat;

public class Vertex {

    //variable deceleration of the class vertex private.
    private double x;
    private double y;
    private double z;
    private String vertex="";

    static DecimalFormat df = new DecimalFormat("##.##");

    //these are my constructors for the class vertex. vertex belongs to three seperate instances of the class
    // as define in the static main the of the program.
    // DecimalFormat df = new DecimalFormat("0.##");

  public  Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String toString(){
        /*
        Methods• Vertex – initial constructor with the three coordinate values•toString -
        a string just the display the information about this vertex
         create a String of this Vertex specified in the StL ASCII Format•calcNormal –
         you already have an object declaration for this you just need to call the method to print it
        in the given stl ASCII format specified in the lab document.

        df.format(x)+" "+df.format(y)+" "+df.format(z));

        */
        return df.format(x)+" "+df.format(y)+" "+df.format(z);
    }
    /*
    Java program to find equation
of a plane passing through
given 3 points.
import java .io.*;

    class GFG
    {
        // Function to find equation of plane.
        static void equation_plane(float x1, float y1,
                                   float z1, float x2,
                                   float y2, float z2,
                                   float x3, float y3,
                                   float z3)

        /// these are my coordinates difference is that my coordinates are encapsulated into classes
        {
           ** you're here **

            System.out.println("equation of plane is " + a +
                    " x + " + b + " y + " + c +
                    " z + " + d + " = 0.");
        }
        // Driver code
        public static void main(String[] args)
        {
            float x1 =-1;
            float y1 = 2;
            float z1 = 1;
            float x2 = 0;
            float y2 =-3;
            float z2 = 2;
            float x3 = 1;
            float y3 = 1;
            float z3 =-4;
            equation_plane(x1, y1, z1, x2,
                    y2, z2, x3, y3, z3);
        }
    }

// This code is contributed
// by Amber_Saxena.

            float a1 = x2 - x1;
            float b1 = y2 - y1;
            float c1 = z2 - z1;
            float a2 = x3 - x1;
            float b2 = y3 - y1;
            float c2 = z3 - z1;

            float a = b1 * c2 - b2 * c1;
            float b = a2 * c1 - a1 * c2;
            float c = a1 * b2 - b1 * a2;
            double d = (- a * x1 - b * y1 - c * z1);
*/
    public static Vertex calcNormal(Vertex v1, Vertex v2, Vertex v3){
        /* https://www.youtube.com/watch?v=LwPRhL4PUj8  <--- convert this explanation into the code.
        static method to calculate unit normal Vertex given three vertices (see hybrid #3)
        points of of the first vertex
        */
        double a1 = v2.x - v1.x;
        double b1 = v2.y - v1.y;
        double c1 = v2.z - v1.z;
        double a2 = v3.x - v1.x;
        double b2 = v3.y - v1.y;
        double c2 = v3.z - v1.z;
        //coordinates of the normal vector will equal these values.
        double a = ((b1 * c2) - (b2 * c1));
        double b = ((a2 * c1) - (a1 * c2));
        double c = ((a1 * b2) - (b1 * a2));
        //this  is the get the magnitude of the vector a,b,c so that i'm
        //i'm able to get
        double magnitude =  Math.sqrt( (a*a) + (b*b) + (c*c) );
        //the thing is do you return 4 points??  because the unit normal vector is the vector perpendicular to the plane
        // does this mean that float d = 1 to make it a UNIT normal vector
        return new Vertex(a/magnitude ,b/magnitude ,c/magnitude);
    }




}