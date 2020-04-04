package stl;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List; // import just the List interface

public class Solid {

    private String name;
    //is this how you instantiate and list?? see notes ** ARRAY LIST ***
    private List<Facet> f = new ArrayList<Facet>();
    private List<Vertex> v = new ArrayList<Vertex>();

    public Solid() {
        this.name = toString();
    }

    public Solid(String name) {

        this.name = name;
    }
// add Facet to facets list, returns true if successful, false if not
// how do you know it's successful or unsuccessful??

    public boolean addFacet(Vertex... vertices) {       // THIS IS WHERE YOUR PROBLEM IS I DON'T THINK YOU"RE ADDING THE VERTICES CORRECTLY
        //SEE THE HYBRID AND WHAT THE F%$# IT MEANS...
        // tester code:  System.out.print(3%3);
       /* for(int u  =0; u< vertices.length; u++) {
                //some tester code, vertices.length works prints how ever many vertices.
            System.out.print("*");
        }
        */
        System.out.print(vertices.length + ": VarArgs.length - ");
        // System.out.print(vertices.length); //this displays the number of vertices that are taken in.
        // the 444444... means that it iterates that much times. gets 4 gets 4 gets 4 gets 4 gets 4 gets 4... etc
        // for (int i =0; i < vertices.length; i++){
        //            v.add(vertices[i]);
        //            return true;
        //        }

//v.add(new Vertex(0,0,2));
//System.out.print(f.size());
/*
        for (int i = 0; i < vertices.length; i++) {
            v.add(vertices[i]);
        }*/
  /*      if(vertices.length % 3 == 1){
            System.out.print("x ");

            return true;
        }else if(vertices.length % 3 ==2){

            System.out.print("lol");

        }else if(vertices.length < 3){
            return false;
        }

*/
//  for(int i = 0; i < vertices.length; i++) {
//      System.out.print(vertices[i].toString());
//  }
// this piece of code tells me that all the vertices came through successfully because it's printing it's toString method and gives me a bunch of different
        // arrangement of vertices

//**************************<[ YOU'RE HERE RIGHT NOW ]>**********************************
        if(vertices.length < 3 ){
            return false;
        } else {
       for(int i =2; i <vertices.length; i++){
           addFacet(new Facet(vertices[0],vertices[i-1],vertices[i]));
       }
        return true;
        }
// **************************<[ YOU'RE HERE RIGHT NOW ]>*****************************






       /* if (vertices.length < 3) {
            return false;

for(int i =0 ; i < vertices.length; i++){
                addFacet(new Facet(vertices[0],vertices[i+1],vertices[i+2]));
            } use this.


            //this method receives a bunch a vertexes, whe  the createSolid method iterates it calls this function irregardless to make vertices with points.
            // it recieves the first one. goes through this. when i ran this method it kept saying 44444.... when i printed vertices.length.
            //  else if(vertices.length % 3==0){
            *//*is the if condition for for the f.size() or vertices.length?????? *//*
            //you're  here now
            // int i=0;
            //so for i = 2 --> i - 2 = 0, i-1 = 1 , i = 2..etc till i reaches the length of how ever many vertices exist.

            // the addFacet function below just returns that extra facet needed to completely use all vertexs
            // return true;
        } else if (vertices.length  % 3 == 1) {
            //  System.out.print( vertices.length % 3);
            //if the remainder of the length is 1 make a vertices with the last two.....
            //but in the Pseudo code, it makes a vertex with 0 then the previous one -- not the immediate previous 2
            // I'm really iffy about this -- >> addFacet(new Facet(vertices[0],vertices[vertices.length-2], vertices[vertices.length -1]));
            //how are you going to sort this out??
            int i = 0;
            //you're  here now
            //so for i = 2 --> i - 2 = 0, i-1 = 1 , i = 2..etc till i reaches the length of how ever many vertices exist.
            addFacet(new Facet(vertices[i], vertices[i + 1], vertices[i + 2]));
            // the addFacet function below just returns that extra facet needed to completely use all vertices
            addFacet(new Facet(vertices[0], vertices[vertices.length - 2], vertices[vertices.length - 1]));
            return true;
        } else if (vertices.length-1 % 3 == 2) {
            //System.out.print(f.size() % 3);
            for (int i =0 ; i < (vertices.length); i += 3)
            int i = 3;
            addFacet(new Facet(vertices[i - 3], vertices[i - 2], vertices[i - 1]));

            addFacet(new Facet(vertices[0], vertices[i - 2], vertices[i-1]));
            addFacet(new Facet(vertices[0], vertices[i], vertices[i + i]));

        return true;
    }else

    {
        //length of what ever is returned is less than 3 than kill the code

        for (int i =0 ; i < (vertices.length); i += 3) {
            int h=i;
            addFacet(new Facet(vertices[h], vertices[h + 1], vertices[h + 2]));
        }
        return true;
    }*/

    } // END OF THE METHOD ****************************************
    //this method has to sort through  all the
    //just something to the complete the class might have the change it




    //this is a dummy method that sorts through an array of vertices and makes an array of facetes with it a sorts through it by if/else
    //doesn't work don't know why but it's faulty.
    public void makeFacet() {



        System.out.print(v.size());
        if (v.size() % 3 == 1) {
            addFacet(new Facet(v.get(0), v.get(v.size() - 2), v.get(v.size()-1)));
            for (int i = 2; i < v.size(); i += 3) {//open for loop
                addFacet(new Facet(v.get(i - 2), v.get(i - 1), v.get(i)));
            }//close for loop
        } else if(v.size() % 3 == 2) {
            addFacet(new Facet(v.get(0), v.get(v.size() - 2), v.get(v.size()-1)));
            addFacet(new Facet(v.get(0), v.get(v.size() - 3), v.get(v.size() - 2)));
            for (int i = 2; i < v.size(); i += 3) {//open for loop
                addFacet(new Facet(v.get(i - 2), v.get(i - 1), v.get(i)));
                 }
        }else{
            for (int i = 2; i < v.size(); i += 3) {//open for loop
                addFacet(new Facet(v.get(i - 2), v.get(i - 1), v.get(i)));
                }
            }
        //System.out.print(f.size());
        }




    public boolean addFacet(Facet facet) {
/*
        int currentSize = f.size();
        int newSize =0;
        tester code.
        System.out.print(f.size());
        if (currentSize == newSize ) {
            f.add(facet);
            newSize++;
            return true;
        }else {
            return false;
        }
        */
        return f.add(facet);
    }

    public String toString() {
      String face ="solid ";
        for(int i =0; i <f.size(); i++) {

            face += f.get(i).toString();
        }

        return face;

     /* for(int i =0; i <f.size(); i++) {
            name += f.get(i).toString();
        }
        return "";*/
    }
    public String  print( String solid){
        //PrintWriter print
        StringBuilder string = new StringBuilder("solid " + solid);
        for(int i =0 ; i < f.size()-1;i++) {
            string.append(f.get(i).toString());
        }
        string.append("\nendsolid ").append(solid);
//        print.write(string.toString());
//        print.close();
        return solid;
         //  String test = f.get(2).toString();
    }

}