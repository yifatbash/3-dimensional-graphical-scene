import Elements.Camera;
import Geometries.Plane;
import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Math;
import java.util.ArrayList;

public class PlaneTest {
    
    //the function tests that the function which find intersections points between ray and plane is ok 
    @Test
    public void testIntersectionPoints()
    {
        //create camera
        Camera camera=new Camera(); 
        
        //******test1: 3 intersection points- plane is parallel to the view plane**********
        //create plane
        Point3D Q=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3));// Q=(0,0,-3) create point on the plane
        Vector normal=new Vector (new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1)));// N=(0,0,1): the normal of the plane 
        Plane plane=new Plane(Q, normal);
        
        //create the array list of the intersection points 
        ArrayList<Point3D> actual= new ArrayList(); 
        
        //constract 3 rays through the diagonal of the view plane 
        //construct ray through the center of view plane (0,0) 
        Ray ray1=new Ray(camera.get_P0(), camera.get_vTo());
        ray1= camera.ConstructRayThroughPixel(3, 3, 0, 0, 1, 9, 9);
        //add intersection points to the arrayList of the intersection points 
        actual=plane.findIntersections(ray1); 
        //construct ray through the center of view plane (1,1)
        Ray ray2=new Ray(camera.get_P0(), camera.get_vTo());
        ray2= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9); 
        //add intersection points to the arrayList of the intersection points 
        actual.addAll(plane.findIntersections(ray2)); 
        //construct ray through the center of view plane (2,2)
        Ray ray3=new Ray(camera.get_P0(), camera.get_vTo());
        ray3= camera.ConstructRayThroughPixel(3, 3, 2, 2, 1, 9, 9); 
        //add intersection points to the arrayList of the intersection points 
        actual.addAll(plane.findIntersections(ray3)); 
        
        //create a temporary array list- stores the expected intersction points
        ArrayList<Point3D> expected= new ArrayList();
        //add to a temporary array list- stores the expected intersction points
        expected.add(new Point3D(new Coordinate(-8.999999999999998),new Coordinate(8.999999999999998),new Coordinate(-3)));
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)));
        expected.add(new Point3D(new Coordinate(8.999999999999998),new Coordinate(-8.999999999999998),new Coordinate(-3)));
        
        //compare between the actual and the expected array list of the intersection points 
        for (int i=0;i<actual.size()&& i<expected.size(); i++)
        {
            assertTrue(actual.get(i).compareTo(expected.get(i))==0); 
        }
        
        //clear the data from the previous test
        actual.clear();
        expected.clear();
        
        //******test2: 3 intersection points- plane is not parallel to the view plane (the angle between the plane normal and vTo is 60)**********
        //create plane
        Q=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3));// Q=(0,0,-3) create point on the plane
        normal=new Vector (new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(1)));// N=(0,1,1): the angle between the plane normal and vTo=(0,0,1) is 60
        plane=new Plane(Q, normal);
        
        //construct ray through the center of view plane (0,0)   
        ray1= camera.ConstructRayThroughPixel(3, 3, 0, 0, 1, 9, 9);
        //add intersection points to the arrayList of the intersection points 
        actual=plane.findIntersections(ray1); 
        //construct ray through the center of view plane (1,1)
        ray2= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9); 
        //add intersection points to the arrayList of the intersection points 
        actual.addAll(plane.findIntersections(ray2)); 
        //construct ray through the center of view plane (2,2)
        ray3= camera.ConstructRayThroughPixel(3, 3, 2, 2, 1, 9, 9); 
        //add intersection points to the arrayList of the intersection points 
        actual.addAll(plane.findIntersections(ray3)); 
        
        //add to a temporary array list- stores the expected intersction points
        expected.add(new Point3D(new Coordinate(4.5),new Coordinate(-4.5),new Coordinate(1.5)));
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)));
        expected.add(new Point3D(new Coordinate(2.2499999999999996),new Coordinate(-2.2499999999999996),new Coordinate(-0.75)));
        
        //compare between the actual and the expected array list of the intersection points 
        for (int i=0;i<actual.size()&& i<expected.size(); i++)
        {
            assertTrue(actual.get(i).compareTo(expected.get(i))==0); 
        } 
    }       
}
