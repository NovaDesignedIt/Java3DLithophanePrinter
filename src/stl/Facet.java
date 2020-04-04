package stl;
public class Facet{


//i'm going to have to declair the object as above and then pass the v1,v2,v3 variables the instances of the object type.

    /*
    normal– A Vertex representing the normal of Facet(Create using Vertex.calcNormal() method)
     v1 – First Vertex of Facet•
     v2 – SecondVertex of Facet•
     v3 – ThirdVertex of Face
     */
    private Vertex v1;
    private Vertex v2;
    private Vertex v3;
    private Vertex v4;



    /*

    here i have a method that takes in the v1,v2,v3 as input parameters and returns the type facet as a face of the shape because
    i gave it 3 dimensions on a 3d plane it's going the encode the dimensions for a shape.
    still not sure what to do with the unit normal yet ASK NEXT LAB****

         */

    public Facet(Vertex v1, Vertex v2, Vertex v3){

        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4.calcNormal(v1,v2,v3);

    }


    public String toString(){

        String normal ="";
        normal += "\nfacet normal "+ v4.toString() +"\n" + " outer loop \n  vertex "+
                v1.toString() +"\n  vertex "+ v2.toString() +"\n  vertex " + v3.toString()+ "\n ";
        normal += " endloop\n" +
                "endfacet";

        return normal;
    }




}