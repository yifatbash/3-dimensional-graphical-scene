import Elements.*;
import org.junit.Test;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;
import java.awt.Color;

public class RenderTest {

    //the function checks the "renderImage" function
	@Test
	public void basicRendering(){
		
		Scene scene = new Scene();
		
		scene.addGeometry(new Sphere(50, new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-150))));
		
		Triangle triangle = new Triangle(new Point3D(new Coordinate(100), new Coordinate(0),new Coordinate(-149)),
                                                new Point3D(new Coordinate(0), new Coordinate(100),new Coordinate(-149)),
                                                new Point3D(new Coordinate(100), new Coordinate(100),new Coordinate(-149)));
				 						
		
		Triangle triangle2 = new Triangle(new Point3D(new Coordinate(100), new Coordinate(0),new Coordinate(-149)),
                                                new Point3D(new Coordinate(0), new Coordinate(-100),new Coordinate(-149)),
                                                new Point3D(new Coordinate(100), new Coordinate(-100),new Coordinate(-149)));

                
		Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0),new Coordinate(-149)),
                                                new Point3D(new Coordinate(0), new Coordinate(100),new Coordinate(-149)),
                                                new Point3D(new Coordinate(-100), new Coordinate(100),new Coordinate(-149)));

		
		Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100), new Coordinate(0),new Coordinate(-149)),
                                                new Point3D(new Coordinate(0), new Coordinate(-100),new Coordinate(-149)),
                                                new Point3D(new Coordinate(-100), new Coordinate(-100),new Coordinate(-149)));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
                
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
              
             
		Render render = new Render(scene,imageWriter);
		
                
		render.renderImage();
                render.printGrid(50);
		render.getImageWriter().writeToimage();	
        }     
}