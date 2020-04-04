package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import stl.Facet;
import stl.Solid;
import stl.Vertex;

class SolidTest {


    @Test
    void test1() {

        //Input was zero parameters.
        Solid solid = new Solid();
        //AddFacet is return false for each of These methods.
        assertEquals(false, solid.addFacet());
        //with 0 Vertex
        System.out.print(solid.print("TestInvalid : 0 vertex \n"));
        assertEquals(false, solid.addFacet(new Vertex(0, 0, 0)));
        //with 1 vertex
        System.out.print(solid.print("TestInvalid : 1 vertex \n"));
        assertEquals(false, solid.addFacet(new Vertex(0, 0, 0), new Vertex(0, 0, 0)));
        //with 2 vertex
        System.out.print(solid.print("TestInvalid : 2 vertex \n"));
        //this test passes!
    }
    //this will test with 3 Vertex
    @Test
    void test3() {
        Solid solid = new Solid();
        Solid solid2 = new Solid();
        //solid2.addFacet()
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2)));
        assertEquals(true, solid.addFacet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2)));
//	System.out.print(solid.print("Test3 : 3 vertex \n"));
        assertTrue((solid.toString()).equals(solid2.toString()));
        System.out.print("Test3 : 3 vertex \n" + solid.toString());
        System.out.print("Test9 II: 9 vertex \n" + solid2.toString());
    }
    @Test
    void test4() {
        Solid solid = new Solid();
        Solid solid2 = new Solid();
        //solid2.addFacet()
        //Create my solids that I will test using different code streams 
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(2, 2, 2), new Vertex(3, 3, 3)));
        assertTrue(solid.addFacet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2), new Vertex(3, 3, 3)));
        System.out.print("Test4 : 4 vertex \n" + solid.toString());
        System.out.print("Test4 II: 4 vertex \n" + solid.toString());
        assertTrue((solid.toString()).equals(solid2.toString()));
        System.out.print("Test9 II: 9 vertex \n" + solid2.toString());
    }
    @Test
    void test9() {
        Solid solid = new Solid();
        Solid solid2 = new Solid();
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(2, 2, 2), new Vertex(3, 3, 3)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(3, 3, 3), new Vertex(4, 4, 4)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(4, 4, 4), new Vertex(5, 5, 5)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(5, 5, 5), new Vertex(6, 6, 6)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(6, 6, 6), new Vertex(7, 7, 7)));
        solid2.addFacet(new Facet(new Vertex(0, 0, 0), new Vertex(7, 7, 7), new Vertex(8, 8, 8)));

        assertEquals(true, solid.addFacet(new Vertex(0, 0, 0), new Vertex(1, 1, 1), new Vertex(2, 2, 2), new Vertex(3, 3, 3)
                , new Vertex(4, 4, 4), new Vertex(5, 5, 5), new Vertex(6, 6, 6), new Vertex(7, 7, 7), new Vertex(8, 8, 8)));
        assertTrue((solid.toString()).equals(solid2.toString()));

        System.out.print("Test9 : 9 vertex \n" + solid.toString());
        System.out.print("Test9 II: 9 vertex \n" + solid2.toString());
    }


}
