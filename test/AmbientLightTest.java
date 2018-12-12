import Elements.*;
import Primitives.*;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class AmbientLightTest {
        
    //the function checks the intensity of the ambient light 
    @Test
    public void getIntensityTest()
    {
        AmbientLight ambientLight= new AmbientLight(Color.white,0.1);// defined the ambient light of the scene
        //defines 2 points in the space 
        Point3D p1=new Point3D(new Coordinate(-10),new Coordinate(20),new Coordinate(-130));
        Point3D p2=new Point3D(new Coordinate(10),new Coordinate(30),new Coordinate(-300));
        //calculates the color created by the intensity of the ambient light for each point  
        Color intensity1=ambientLight.getIntensity(p1); 
        Color intensity2=ambientLight.getIntensity(p2); 
        
        //checks that intensity is equal for all points in the space 
        assertTrue((intensity1.getRGB()==intensity2.getRGB()));     
    }
}
