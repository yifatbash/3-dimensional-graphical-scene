import Elements.Camera;
import Geometries.Triangle;
import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Math;
import java.util.ArrayList;

public class TriangleTest {
     //the function tests that the function which find intersections points between ray and triangle is ok 
    @Test
    public void testIntersectionPoints()
    {
        //create camera
        Camera camera=new Camera(); 
        
        //******test1: 1 intersection point**********
        //create triangle 
        Point3D P1=new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(-2));// P1=(0,1,-2) 
        Point3D P2=new Point3D(new Coordinate(1),new Coordinate(-1),new Coordinate(-2));// P2=(-1,1,-2) 
        Point3D P3=new Point3D(new Coordinate(-1),new Coordinate(-1),new Coordinate(-2));// P3=(-1,-1,-2) 
        Triangle triangle = new Triangle (P1, P2, P3);
        
        //create the array list of the intersection points 
        ArrayList<Point3D> actual= new ArrayList(); 
        
        //construct ray through the center of view plane (0,0)
        Ray ray1=new Ray(camera.get_P0(), camera.get_vTo());
        ray1= camera.ConstructRayThroughPixel(3, 3, 0,0, 1, 9, 9);
        //add the intersection points to array list of the intersection points
        actual=triangle.findIntersections(ray1);
        //we expected to have no intersection points 
        assertTrue(actual==null); 
        
        //construct ray through the center of view plane (2,2)
        Ray ray2=new Ray(camera.get_P0(), camera.get_vTo());
        ray2= camera.ConstructRayThroughPixel(3, 3, 2, 2, 1, 9, 9); 
        //add the intersection points to array list of the intersection points
        actual=triangle.findIntersections(ray1);
        //we expected to have no intersection points 
        assertTrue(actual==null); 
        
        //construct ray through the center of view plane (1,1)
        Ray ray3=new Ray(camera.get_P0(), camera.get_vTo());
        ray3= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9); 
        actual=triangle.findIntersections(ray3); 
        //a temporary array list- stores the expected intersction points
        ArrayList<Point3D> expected= new ArrayList(); 
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-2)));
        
        //compare between the actual and the expected array list of the intersection points 
        for (int i=0;i<actual.size()&& i<expected.size(); i++)
        {
            assertTrue(actual.get(i).compareTo(expected.get(i))==0); 
        }
        
        //clear the data from the previous test
        actual.clear();
        expected.clear(); 
        
        //******test2: 2 intersection point**********
        
        //create triangle 
        P1=new Point3D(new Coordinate(0),new Coordinate(10),new Coordinate(-2));// P1=(0,10,-2) 
        P2=new Point3D(new Coordinate(1),new Coordinate(-1),new Coordinate(-2));// P2=(-1,1,-2) 
        P3=new Point3D(new Coordinate(-1),new Coordinate(-1),new Coordinate(-2));// P3=(-1,-1,-2) 
        triangle = new Triangle (P1, P2, P3);
        
        //construct ray through the center of view plane (1,2)
        ray1= camera.ConstructRayThroughPixel(3, 3,1,2, 1, 9, 9);
        //we expect to have no intersection points 
        actual=triangle.findIntersections(ray1); 
        assertTrue(actual==null);
        
        //construct ray through the center of view plane (1,0)
        ray2= camera.ConstructRayThroughPixel(3, 3,1,0, 1, 9, 9); 
        //add intersection points to the arrayList of the intersection points 
        actual=triangle.findIntersections(ray2); 
        
        //construct ray through the center of view plane (1,1)
        ray3= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9);
        //add intersection points to the arrayList of the intersection points 
        actual.addAll(triangle.findIntersections(ray3)); 

        //add to a temporary array list- stores the expected intersction points
        expected.add(new Point3D(new Coordinate(0),new Coordinate(5.999999999999999),new Coordinate(-2)));
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-2)));
        //compare between the actual and the expected array list of the intersection points 
        for (int i=0;i<actual.size()&& i<expected.size(); i++)
        {
            assertTrue(actual.get(i).compareTo(expected.get(i))==0); 
        }
    }
    //the function tests the getNormal function 
     @Test
    public void getNormalTest()
    {
        Point3D P1=new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(-2));// P1=(0,1,-2) 
        Point3D P2=new Point3D(new Coordinate(1),new Coordinate(-1),new Coordinate(-2));// P2=(-1,1,-2) 
        Point3D P3=new Point3D(new Coordinate(-1),new Coordinate(-1),new Coordinate(-2));// P3=(-1,-1,-2) 
        Triangle triangle = new Triangle (P1, P2, P3);
        
        Vector expected=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-4))); 
        expected=expected.normalize(); 
        Vector actual=new Vector(); 
        actual=triangle.getNormal(P3); 
        
        assertTrue(expected.compareTo(actual)==0);
        
    }
    
       
    
}

