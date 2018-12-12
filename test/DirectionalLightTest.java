import Elements.*;
import Primitives.*;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class DirectionalLightTest {
    
    //the function checks the intensity of the directional light 
    @Test
    public void getIntensityTest()
    {
        //defined the directional light of the scene
        DirectionalLight directionalLight= new DirectionalLight(Color.white, new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1))));
       //defines 2 points in the space
        Point3D p1=new Point3D(new Coordinate(-10),new Coordinate(20),new Coordinate(-130));
        Point3D p2=new Point3D(new Coordinate(10),new Coordinate(30),new Coordinate(-300));
        //calculates the color created by the intensity of the directional light for each point 
        Color intensity1=directionalLight.getIntensity(p1); 
        Color intensity2=directionalLight.getIntensity(p2); 
        
        //checks that intensity is equal for all points in the space 
        assertTrue((intensity1.getRGB()==intensity2.getRGB()));     
    }
}
