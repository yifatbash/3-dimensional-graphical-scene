import Elements.Camera;
import Geometries.Sphere;
import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Math;
import java.util.ArrayList;

public class SphereTest {
    
    //the function tests that the function which find intersections points between ray and sphere is ok 
    @Test
    public void testIntersectionPoints()
    {
        //create camera
        Camera camera=new Camera(); 
        
        //******test1: 2 intersection points- sphere is in front of the view plane**********
        
        //create sphere 
        Point3D O=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)); // O=(0,0,-3) the sphere center
        double raduis=1; // r=(0^2+0^2+(-3-(-2))^2)^0.5=1
        Sphere sphere=new Sphere(raduis,O); 
        
        //create the array list of the intersection points 
        ArrayList<Point3D> actual= new ArrayList(); 
        
        //construct ray through the center of view plane (0,0)
        Ray ray1=new Ray(camera.get_P0(), camera.get_vTo());
        ray1= camera.ConstructRayThroughPixel(3, 3, 0, 0, 1, 9, 9);
        //add the intersection points to array list of the intersection points
        actual=sphere.findIntersections(ray1);
        //we expected to have no intersection points 
        assertTrue(actual==null); 
        
        //construct ray through the center of view plane (2,2)
        Ray ray3=new Ray(camera.get_P0(), camera.get_vTo());
        ray3= camera.ConstructRayThroughPixel(3, 3, 2, 2, 1, 9, 9); 
        //add the intersection points to array list of the intersection points
        actual=sphere.findIntersections(ray3);
        //we expect to have no intersection points 
        assertTrue(actual==null); 
        
        //construct ray through the center of view plane (1,1)
        Ray ray2=new Ray(camera.get_P0(), camera.get_vTo());
        ray2= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9); 
        //add the intersection points to array list of the intersection points
        actual=sphere.findIntersections(ray2);
        //a temporary array list- stores the expected intersection points with ray2
        ArrayList<Point3D> expected= new ArrayList(); 
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-2)));
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-4)));
        
        //compare between the actual and the expected array list of the intersection points 
        for (int i=0;i<actual.size()&& i<expected.size(); i++)
        {
            assertTrue(actual.get(i).compareTo(expected.get(i))==0); 
        }
        
        //******test2: 3 intersection points- sphere surrounds view plane**********
        //create sphere 
        O=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)); // O=(0,0,-1) the sphere center
        raduis=5; 
        sphere=new Sphere(raduis,O); 
//        for(int i=0; i<3; i++)
//        {
//            for(int j=0; j<3; j++)
//            {
//                //construct ray through each pixel in the view plane
//                ray= camera.ConstructRayThroughPixel(3, 3, i, j, 1, 9, 9); 
//                //add the intersection points to array list of the intersection points
//                actual.addAll(sphere.findIntersections(ray));
//            }
//        }

        //clear the data from the previous test
        actual.clear();
        expected.clear(); 
        
        //constract 3 rays through the diagonal of the view plane 
        //construct ray through the center of view plane (0,0)
        ray1=new Ray(camera.get_P0(), camera.get_vTo());
        ray1= camera.ConstructRayThroughPixel(3, 3, 0, 0, 1, 9, 9); 
        //add the intersection points to array list of the intersection points
        actual.addAll(sphere.findIntersections(ray1));
        //help variable to calculate the expected intersection point 
        double t2=Math.sqrt(1/19.0)+Math.sqrt(457/19.0);//t2=(tm^2+th^2) 
        //add to a temporary array list- stores the expected intersection points
        expected.add(new Point3D(new Coordinate(t2*-3/Math.sqrt(19)),new Coordinate(t2*3/Math.sqrt(19)),new Coordinate(t2*-1/Math.sqrt(19))));

        //construct ray through the center of view plane (1,1)
        ray2=new Ray(camera.get_P0(), camera.get_vTo());
        ray2= camera.ConstructRayThroughPixel(3, 3, 1, 1, 1, 9, 9);
        //add the intersection points to array list of the intersection points
        actual.addAll(sphere.findIntersections(ray2));
        //add to a temporary array list- stores the expected intersection points
        expected.add(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-6)));
        
        //construct ray through the center of view plane (2,2)
        ray3=new Ray(camera.get_P0(), camera.get_vTo());
        ray3= camera.ConstructRayThroughPixel(3, 3, 2, 2, 1, 9, 9);
        //add the intersection points to array list of the intersection points
        actual.addAll(sphere.findIntersections(ray3));
        //help variable to calculate the expected intersection point 
        t2=Math.sqrt(1/19.0)+Math.sqrt(457/19.0);//t2=(tm^2+th^2) 
        //add to a temporary array list- stores the expected intersection points
        expected.add(new Point3D(new Coordinate(t2*3/Math.sqrt(19)),new Coordinate(t2*-3/Math.sqrt(19)),new Coordinate(t2*-1/Math.sqrt(19))));
        
    }
    //the function tests the getNormal function 
    @Test
    public void getNormalTest()
    {
        //create sphere 
        Point3D O=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)); // O=(0,0,-3) the sphere center
        double raduis=9; // r=(0^2+0^2+(-3-(-2))^2)^0.5=1
        Sphere sphere=new Sphere(raduis,O); 
        
        //test1: p=(3,0,-3)
        Point3D p=new Point3D(new Coordinate(3),new Coordinate(0),new Coordinate(-3)); 
        Vector actual = new Vector(); 
        actual= sphere.getNormal(p); 
        Vector expected=new Vector(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0))); 
        assertTrue(actual.compareTo(expected)==0); 
        
        //test2: p=(0,3,-3)
        p=new Point3D(new Coordinate(0),new Coordinate(3),new Coordinate(-3)); 
        actual= sphere.getNormal(p); 
        expected=new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0))); 
        assertTrue(actual.compareTo(expected)==0); 
                   
        //test3: p=(0,0,0)
        p=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)); 
        actual= sphere.getNormal(p); 
        expected=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1))); 
        assertTrue(actual.compareTo(expected)==0); 
          
        //test4: p=(-3,0,-3)
        p=new Point3D(new Coordinate(-3),new Coordinate(0),new Coordinate(-3)); 
        actual= sphere.getNormal(p); 
        expected=new Vector(new Point3D(new Coordinate(-1),new Coordinate(0),new Coordinate(0))); 
        assertTrue(actual.compareTo(expected)==0); 
                
        //test5: p=(0,-3,-3)
        p=new Point3D(new Coordinate(0),new Coordinate(-3),new Coordinate(-3)); 
        actual= sphere.getNormal(p); 
        expected=new Vector(new Point3D(new Coordinate(0),new Coordinate(-1),new Coordinate(0))); 
        assertTrue(actual.compareTo(expected)==0); 
    }
}
