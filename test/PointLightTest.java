import Elements.*;
import Primitives.*;
import Geometries.*;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;
import Elements.*;
import org.junit.Test;
import Renderer.*;
import Scene.Scene;

public class PointLightTest {
    
    //function checks the intensity of the point light
    @Test
    public void getIntensityTest()
    {
        // defined the point light 
        PointLight pointLight=new PointLight(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-150)),0.01,0.01,0.01,Color.white);
        //defines 2 points in the space
        Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-130));//closer point 
        Point3D p2=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-100));//farther point 
        //calculates the color created by the intensity of the point light for each point 
        Color intensity1=pointLight.getIntensity(p1); 
        Color intensity2=pointLight.getIntensity(p2); 
        
        //checks that intensity of the closer point is bigger of farther point  
        assertTrue((intensity1.getRGB()>intensity2.getRGB())==true);     
    }
    
    //function checks how the point light infuences a plane 
     @Test
	public void PointLightTest_Plane1()
        {
            Scene scene=new Scene();

            Plane plane= new Plane(new Color(36,36,36), new Material(),new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-149)), new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(1))));
            PointLight pointLight=new PointLight(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-100)),0.001,0.001,0.001,Color.magenta);

            scene.addGeometry(plane);
            scene.addLight(pointLight);
            
            ImageWriter imageWriter = new ImageWriter("point test1(plane)", 500, 500, 500, 500);
            Render render = new Render(scene,imageWriter);
		        
            render.renderImage();
            //render.printGrid(50);
            render.getImageWriter().writeToimage();	 
        }
        
        	@Test
	public void pointLightTest_Plane2(){
		
		Scene scene = new Scene();
                Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1000)));
	
		
		
                Triangle triangle = new Triangle(new Point3D( new Coordinate(3500), new Coordinate( 3500), new Coordinate(-2000)),
				 						 new Point3D( new Coordinate( -3500), new Coordinate( -3500), new Coordinate( -1000)),
				 						 new Point3D(  new Coordinate( 3500), new Coordinate( -3500), new Coordinate( -2000)));
		Triangle triangle2 = new Triangle(new Point3D( new Coordinate(3500), new Coordinate( 3500), new Coordinate(-2000)),
				 						 new Point3D( new Coordinate( -3500), new Coordinate( 3500), new Coordinate( -1000)),
				 						 new Point3D(  new Coordinate( -3500), new Coordinate( -3500), new Coordinate( -1000)));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight( new Point3D(new Coordinate(200),new Coordinate( 200), new Coordinate(-100)), 
					   0, 0.000001, 0.0000005,new Color(255, 100, 100)));
	
		
		ImageWriter imageWriter = new ImageWriter("Point test2(plane)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		  render.getImageWriter().writeToimage();
		
	}
        
        //function checks how the point light infuences a sphere
        @Test
	public void pointLightTest_Sphere1()
        {
            Scene scene=new Scene();

            Sphere sphere= new Sphere(Color.BLUE, new Material(),100, new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-149)));
            PointLight pointLight=new PointLight(new Point3D(new Coordinate(-20), new Coordinate(-20),new Coordinate(-60)),0.001,0.001,0.007,Color.white);

            scene.addGeometry(sphere);
            scene.addLight(pointLight);
            
            ImageWriter imageWriter = new ImageWriter("pointLight test1(Sphere)", 500, 500, 500, 500);
            Render render = new Render(scene,imageWriter);
		        
            render.renderImage();
            //render.printGrid(50);
            render.getImageWriter().writeToimage();
        }     
        
        @Test
	public void pointLightTest_Sphere2(){
		try{
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1000)));
		
		scene.addGeometry(sphere);
                PointLight pointLight= new PointLight( new Point3D(new Coordinate(-200), new Coordinate(-200),new Coordinate(-100)),0, 0.00001, 0.000005,new Color(255,100,100));
		scene.addLight(pointLight);
	
		ImageWriter imageWriter = new ImageWriter("Point test2 (sphere)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		} 	
        }
}
