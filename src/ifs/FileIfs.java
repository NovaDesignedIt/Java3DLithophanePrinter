package ifs;

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.awt.geom.AffineTransform;

public class FileIfs implements AffineTransformation {

    private double[][] affine;
    private double scale;
    private int height;
    private int width;
    private int xOffset;
    private int yOffset;
    private String name;
    private String path;
    // File text ;
//    FileReader file = new FileReader(path);
//    BufferedReader br = new BufferedReader(file);
    public FileIfs(String path) throws IOException {
       //PATH PARAMETER TAKES IN THE PATH AND GIVES IT TO THE SCANNER;
        this.path = path;

        // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

        //constructor not even getting through...
        // second method to read the file still trying to seperate the white space from the text file and read the data efficiently
        //the method below is inneficient  this method is used using the buffered reader.
        FileReader file = new FileReader(path);
        //this is declairing the file reader and taking in the path of the file in the system as an argument
        //the 'file' Type fileReader is going to pass as an arguement in the next declaration of object class.
        BufferedReader br = new BufferedReader(file);
        //the Buffered reader is going to read the file inside the txt. file
        String lines;
        String Affine = "";
        int ArraySize=0;

        //THIS I HERE IS TO INCREMENT THE ROW OF THE DOUBLE ARRAY AFFINE TO GET THE TRANSFORMS
        int i =0;

        while ((lines = br.readLine()) != null) { //beginning of the while loop
            //the while loop knows everything therefore you have to do it in the if statement.
            //in the While loop it knows the the the size of the array[] and the size of each indexed array by saying array.length
            //and array array[].length

            lines = lines.trim();
            lines = lines.replaceAll("\\s+", " "); //remove the trailing whitespace. //the \\s+ takes the leading white spaces
            //replaces all with just a single  " " white space.
            //the line of code below splits the white space with " " token and puts it into an array.
            String[] token = lines.split(" "); //SUCCESS!! This works!
            // System.out.print(lines);

            ArrayList<Double> prob = new ArrayList<Double>();
            int tokenlength = 0;


            if (token[0].equals("affine")) {
               this.affine = new double[Integer.parseInt(token[1])][];
                //this pass the number as an array!!
            } else if (token[0].equals("height")) {
                //to get the height
                this.height = Integer.parseInt(token[1]);
            } else if (token[0].equals("scale")) {
                // to get the scale
                this.scale = Double.parseDouble(token[1]);
            } else if (token[0].equals("width")) {
                // to get the width
                this.width = Integer.parseInt(token[1]);
            } else if (token[0].equals("xOffset")) {
                //to get the xOffset
                this.xOffset = Integer.parseInt(token[1]);
            } else if (token[0].equals("yOffset")) {
                // to get yOffset
                this.yOffset = Integer.parseInt(token[1]);
            } else if (token[0].equals("name")) {
               this.name = token[1] + " " + token[2];

            } else {

            /*for(int i = 0; i <token.length; i++){
                }
            }*/
                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ TESTER CODE }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //
                    //--
                double[] ray = Arrays.stream(token).mapToDouble(Double::parseDouble).toArray();
                affine[i] = ray;
                i++;


                    //--
                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ TESTER CODE }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

             /*
                for (int i = 0; i < token.length; i++) {
                    Affine += token[i] + " ";
                }
                Affine += "\n";
                */

                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //
           /* double[][] dummy;
            for (int j =0; j < ArraySize; j++ ) {
                for (int i = 0; i < token.length; i++) {  //beginning of the floor loop
                    prob.add(Double.parseDouble(token[i]));
                    prob.toArray();
                } // end of the for loop
                dummy = new double[j][];
                     }*/

            } //end of the if/else statement totally
        }// end of the while loop

        //WAIT BEFORE USING THIS v

        // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //
     /*   Affine = Affine.replaceAll("\\s+", " "); //remove the trailing whitespace. //the \\s+ takes the leading white spaces
        //replaces all with just a single  " " white space.
        //the line of code below splits the white space with " " token and puts it into an array.
        String[] token = Affine.split(" "); //SUCCESS!! This works!
        this.affine = new double[][]{
                {Double.parseDouble(token[0]),
                        Double.parseDouble(token[1]),
                        Double.parseDouble(token[2]),
                        Double.parseDouble(token[3]),
                        Double.parseDouble(token[4]),
                        Double.parseDouble(token[5]),
                        Double.parseDouble(token[6])
                },
                {
                        Double.parseDouble(token[7]),
                        Double.parseDouble(token[8]),
                        Double.parseDouble(token[9]),
                        Double.parseDouble(token[10]),
                        Double.parseDouble(token[11]),
                        Double.parseDouble(token[12]),
                        Double.parseDouble(token[13])
                }

        }; // END OF THE NEW DOUBLE DECELERATION*/
        // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

    }// ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //


    //THIS METHOD A NOTHER DUMMY METHOD MADE TO CALL THE FUNCTION.. JUST A SECOND WAY OF  DOING WAS I WAS  DOING BELOW
    //TILL I READ THE DOCUMENTATION  AND REALISED I HAVE TO SCAN THE FILE IN THE CONSTRUCTOR AND ASSIGNE THE VARIABLES
  public void getdata2() throws IOException {

        // second method to read the file still trying to seperate the white space from the text file and read the data efficiently
        //the method below is inneficient  this method is used using the buffered reader.
        FileReader file = new FileReader(path);
        //this is declairing the file reader and taking in the path of the file in the system as an argument
        //the 'file' Type fileReader is going to pass as an arguement in the next declaration of object class.
        BufferedReader br = new BufferedReader(file);
        //the Buffered reader is going to read the file inside the txt. file
        String lines;
        String Affine="";
        int ArraySize;
        while ((lines = br.readLine()) != null) { //beginning of the while loop
            //the while loop knows everything therefore you have to do it in the if statement.
            //in the While loop it knows the the the size of the array[] and the size of each indexed array by saying array.length
            //and array array[].length

            lines = lines.trim();
            lines = lines.replaceAll("\\s+", " "); //remove the trailing whitespace. //the \\s+ takes the leading white spaces
            //replaces all with just a single  " " white space.
            //the line of code below splits the white space with " " token and puts it into an array.
            String[] token = lines.split(" "); //SUCCESS!! This works!
            // System.out.print(lines);

            ArrayList<Double> prob = new ArrayList<Double>();
            int tokenlength = 0;


            if (token[0].equals("affine")) {
                ArraySize = Integer.parseInt(token[1]);
                affine = new double[ArraySize][];
                //this pass the number as an array!!
            } else if (token[0].equals("height")) {
                //to get the height
               height = Integer.parseInt(token[1]);
            } else if (token[0].equals("scale")) {
                // to get the scale
               scale = Double.parseDouble(token[1]);
            } else if (token[0].equals("width")) {
                // to get the width
                width = Integer.parseInt(token[1]);
            } else if (token[0].equals("xOffset")) {
                //to get the xOffset
            xOffset = Integer.parseInt(token[1]);
            } else if (token[0].equals("yOffset")) {
                // to get yOffset
               yOffset = Integer.parseInt(token[1]);
            } else if (token[0].equals("name")) {
                  name = token[1] + " " + token[2];

            } else {








                /*for(int i = 0; i <token.length; i++){
                    }
                }*/

                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

                for (int i=0; i < token.length; i++) {
                Affine += token[i]+" ";
                }
                Affine += "\n";

                // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //

               /* double[][] dummy;
                for (int j =0; j < ArraySize; j++ ) {
                    for (int i = 0; i < token.length; i++) {  //beginning of the floor loop
                        prob.add(Double.parseDouble(token[i]));
                        prob.toArray();
                    } // end of the for loop
                    dummy = new double[j][];
                         }*/
            } //end of the if/else statement totally
        }// end of the while loop
      //Close my scanner to prevent resources leak

      // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //
      br.close();

            //WAIT BEFORE USING THIS v
        Affine = Affine.replaceAll("\\s+", " "); //remove the trailing whitespace. //the \\s+ takes the leading white spaces
        //replaces all with just a single  " " white space.
        //the line of code below splits the white space with " " token and puts it into an array.
        String[] token = Affine.split(" "); //SUCCESS!! This works!!!!!!!!

      //how can you code this efficiently?????
      // {{{{{ THIS ISN HARDED CODED METHOD..? HOW THE F*CK CAN YOU PUT HIS IN an ARRAY IF AN ARRAY IS ISN't DYNAMIC?????
        affine = new double[][] {
                {       Double.parseDouble(token[0]),
                        Double.parseDouble(token[1]),
                        Double.parseDouble(token[2]),
                        Double.parseDouble(token[3]),
                        Double.parseDouble(token[4]),
                        Double.parseDouble(token[5]),
                        Double.parseDouble(token[6])
                },
                {
                        Double.parseDouble(token[7]),
                        Double.parseDouble(token[8]),
                        Double.parseDouble(token[9]),
                        Double.parseDouble(token[10]),
                        Double.parseDouble(token[11]),
                        Double.parseDouble(token[12]),
                        Double.parseDouble(token[13])
                }

        };// END OF ASSIGNMENT OF THE DOUBLE ARRAY

      // ~*~*~*~*~*~*~*~*~*~*~*~*~*~{ Functioning code }*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~* //


        // _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_
      /*  Scanner scan = new Scanner(Affine);
        while(scan.hasNextLine()){
            for (int i=0; i<){
            }
        }
        //String[] token = lines.split(" ");
               /* for (int i =0; i < affine.length-1 ; i++ ){
                    for (int j =0; j < affine[i].length-1 ;j++){
                        };
                    }*/
    }//END OF THE METHOD () TYPE VOID

 //this was a dummy method intended, to do the scanning, I tried calling this function in the constructor.
   public void getdata() throws FileNotFoundException {
       Scanner scan = new Scanner(new File(path));
       // Declairing my Scanner object that's going to take in a new file path
       // the New file(name) takes the path of the file i want to scan
       // is nested in the scanner class for efficient coding
       String data;
       //string data is what I'm going to be giving from the file
       //so input is the txt file we're going to read.
       while (scan.hasNextLine()) {
           //while the scan is going through the lines the text file
           //while the scanner is scanning all the lines...
        data = scan.nextLine();

        //pass the the data to the variable data.
        String[] token = data.split(" ");
            if(token[0].equals(scan.hasNextDouble())){
                    System.out.print(token[0]);
            }
        //beginning of the if statement.
        if(token[0].equals("affine\t2")){
            // I'm
// --*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
            // -*-*-*-*-*-*-*-*-*-*-*-*-* you're here -*-*-*-*-*-*-*-*-*-*-*-*-* //

            // -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* //
// --*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        /*System.out.print(token[0]);
        for(int i =0; i < 8; i++) {
            System.out.print(token[i]);
        }*/
        }else if(token[0].equals("height")){
            //to get the height
            height = Integer.parseInt(token[1]);
        }else if(token[0].equals("scale")){
            // to get the scale
            scale = Double.parseDouble(token[1]);
        }else if(token[0].equals("width")) {
            // to get the width
           width = Integer.parseInt(token[1]);
        }else if(token[0].equals("xOffset")) {
            //to get the xOffset
           xOffset = Integer.parseInt(token[1]);
        }else if(token[0].equals("yOffset")) {
            // to get yOffset
            yOffset = Integer.parseInt(token[1]);
        }else if(token[0].equals("name")) {
              name = token[1]+" "+token[2];

        }

       }


   }
   /* {// try open
        try {
            scan = new Scanner(text);
            int linenumber =1;
            while(scan.hasNext()){
                String line = scan.nextLine();
                System.out.println(linenumber +" "+line);
                linenumber++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }//try closes*/

    //BufferedReader textReader = new BufferedReader (fr);
    //String

   /*
   public void test() {
     try {
       scan = new Scanner(new File(name));
         String data;
          while(scan.hasNextLine()){
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    */


    public String getname(){

        //  WAS WAS DONE IN HERE WAS TO:
        // 1. SCAN THE FILE
        // 2. IF NAME EXISTS IN HERE
        // 3. TAKE IT AND RETURN IT
        // 4. I REPEATED THIS METHOD FOR MOST OF THE GETTERS AND SETTERS
        //   RESULT: IT DIDN'T WORK BECAUSE THE FILE PATH WASN'T EXISTING IN THE INSTANCE OF THIS METHOD BEING CALLED.

/*//        FileReader file = new FileReader(path);
//        BufferedReader br = new BufferedReader(file);
        String lines;
        while ((lines = br.readLine()) != null) {

            lines = lines.trim();
            lines = lines.replaceAll("\\s+", " "); //remove the trailing whitespace. //the \\s+ takes the leading white spaces
            //replaces all with just a single  " " white space.
            //the line of code below splits the white space with " " token and puts it into an array.
            String[] token = lines.split(" ");


            if (token[0].equals("name")) {
               name = token[1] + " " + token[2];
            }

        }*/
        return name;
    }
    public double[][] getAffine(){

        return affine;
    }
    public double getscale() {

        return scale;

    }
    public int getheight(){

        return height;
    }
    public int getwidth() {

        return width;
    }
    public int getxOffset(){

    return xOffset;
    }
    public int getyOffset(){


        return yOffset;

    }

}
