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

public class SpotLightTest {
    
    //function checks the intensity of the spot light
    @Test
    public void getIntensityTest()
    {
         // defined the spot light 
        SpotLight spotLight=new SpotLight(new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1))),new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-1)),0.01,0.01,0.01,Color.white);
        //defines 2 points in the space
        Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-100));//closer point 
        Point3D p2=new Point3D(new Coordinate(-200),new Coordinate(-200),new Coordinate(-200));//farther point 
        //calculates the color created by the intensity of the spot light for each point 
        Color intensity1=spotLight.getIntensity(p1); 
        Color intensity2=spotLight.getIntensity(p2); 
        
        //checks that intensity of the closer point is bigger of farther point  
        assertTrue((intensity1.getRGB()>intensity2.getRGB())==true);     
    }
    
    //function checks how the spot light infuences a plane 
    @Test
	public void SpotLightTest_Plane1()
        {
            Scene scene=new Scene();

            Plane plane= new Plane(new Color(36,36,36), new Material(),new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-149)), new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(1))));
            SpotLight spotLight=new SpotLight(new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(1))),new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-130)),0.01,0.01,0.01,Color.magenta);

            scene.addGeometry(plane);
            scene.addLight(spotLight);
            
            ImageWriter imageWriter = new ImageWriter("Spot test1(plane)", 500, 500, 500, 500);
            Render render = new Render(scene,imageWriter);
		        
            render.renderImage();
            //render.printGrid(50);
            render.getImageWriter().writeToimage();	 
        }
        
         @Test
	public void spotLightTest_Plane2(){
		
		Scene scene = new Scene();
		
		Triangle triangle = new Triangle(new Point3D( new Coordinate(3500), new Coordinate( 3500), new Coordinate(-2000)),
				 						 new Point3D( new Coordinate( -3500), new Coordinate( -3500), new Coordinate( -1000)),
				 						 new Point3D(  new Coordinate( 3500), new Coordinate( -3500), new Coordinate( -2000)));
		Triangle triangle2 = new Triangle(new Point3D( new Coordinate(3500), new Coordinate( 3500), new Coordinate(-2000)),
				 						 new Point3D( new Coordinate( -3500), new Coordinate( 3500), new Coordinate( -1000)),
				 						 new Point3D(  new Coordinate( -3500), new Coordinate( -3500), new Coordinate( -1000)));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(-2), new Coordinate(-2), new Coordinate(-3))),
                        new Point3D(new Coordinate(200), new Coordinate( 200), new Coordinate( -100)), 
					    0, 0.000001, 0.0000005,new Color(255, 100, 100)));
	
		
		ImageWriter imageWriter = new ImageWriter("Spot test2(plane)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
                render.getImageWriter().writeToimage();
		
	}
        
        //function checks how the spot light infuences a sphere 
        @Test
	public void spotLightTest_Sphere1(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
                SpotLight spotLight =new SpotLight(new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(3))), 
				new Point3D(new Coordinate(200), new Coordinate(200),new Coordinate(-100)),0, 0.00001, 0.000005,Color.white);
		
                scene.addGeometry(sphere);
                scene.addLight(spotLight);
	
		ImageWriter imageWriter = new ImageWriter("Spot test1(sphere)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();		
	}
        
        //function checks how the spot light infuences a sphere       
         @Test
	public void spotLightTest_Sphere2(){
		
		Scene scene = new Scene();
		Sphere sphere = new Sphere(new Color(0, 0, 100), new Material(),800, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1000)));
                sphere.getMaterial().setnShininess(20);
		scene.addGeometry(sphere);
		scene.addLight(new SpotLight(new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(-3))),new Point3D(new Coordinate(-200), new Coordinate(-200), new Coordinate(-100)), 0, 0.00001, 0.000005, new Color(255,100,100)));
	
		ImageWriter imageWriter = new ImageWriter("Spot test2(Sphere)", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
}
        

}
