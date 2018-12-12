import Elements.Camera;
import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CameraTest {
    
        //the function tests the rays construction (constract 3 rays, each one to another pixel in the diagonal of the view plane)
    	@Test
	public void testConstructRayThroughPixel() {
		Camera _Camera=new Camera(); //create the camera
                //construct ray through (3,3)
		Ray actual1=_Camera.ConstructRayThroughPixel(3,3,3,3,1,9,9);     
                Vector direction1= new Vector(new Point3D(new Coordinate(6),new Coordinate(-6),new Coordinate(-1)));
                direction1 =direction1.normalize(); 
                Ray expected1= new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),direction1);
                assertTrue(actual1.compareTo(expected1)==0);  
                //construct ray through (0,0)
                Ray actual2=_Camera.ConstructRayThroughPixel(3,3,0,0,1,9,9);     
                Vector direction2= new Vector(new Point3D(new Coordinate(-3),new Coordinate(3),new Coordinate(-1)));
                direction2 =direction2.normalize(); 
                Ray expected2= new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),direction2);
                assertTrue(actual2.compareTo(expected2)==0);  
                //construct ray through (-3,-3)
                Ray actual3=_Camera.ConstructRayThroughPixel(3,3,-3,-3,1,9,9);     
                Vector direction3= new Vector(new Point3D(new Coordinate(-12),new Coordinate(12),new Coordinate(-1)));
                direction3 =direction3.normalize(); 
                Ray expected3= new Ray(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)),direction3);
                assertTrue(actual3.compareTo(expected3)==0);  
        }
}
