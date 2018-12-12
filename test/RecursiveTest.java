import Elements.AmbientLight;
import java.awt.Color;
import org.junit.Test;
import Elements.SpotLight;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;

public class RecursiveTest {
	
	@Test
	public void refractedTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
                scene.setAmbientLight(new AmbientLight(Color.white,0.1));
		Sphere sphere1 = new Sphere(new Color(0, 0, 100), new Material(1,1,20,0,1),500, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1000)));
                Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Material(1,1,20,0,0),250, new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(-1000)));
                scene.addGeometry(sphere1);
                scene.addGeometry(sphere2);
		
                scene.addLight(new SpotLight(new Vector(new Point3D(new Coordinate(2), new Coordinate(2), new Coordinate(-3))),
                                            new Point3D(new Coordinate(-200), new Coordinate(-200), new Coordinate(-150)),
                                            0.1, 0.00001, 0.000005, new Color(255,100,100)));
	
		ImageWriter imageWriter = new ImageWriter("Refracted Test1", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	      
        @Test
	public void reflectedTest1(){
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
                 Sphere sphere1 = new Sphere(new Color(0, 0, 100), new Material(1,1,20,0,1),300, new Point3D(new Coordinate(-550), new Coordinate(-500), new Coordinate(-1000)));
                Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Material(1,1,20,0,0),150, new Point3D(new Coordinate(-550), new Coordinate(-500), new Coordinate(-1000)));

		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);
		
                Triangle triangle1 = new Triangle(new Color(20, 20, 20), new Material(1,1,20,1,0), 
                                                    new Point3D( new Coordinate(1500), new Coordinate(-1500), new Coordinate(-1500)),
                                                    new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500)),
                                                    new Point3D(  new Coordinate( 200), new Coordinate( 200), new Coordinate( -375)));
                Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Material(1,1,20,1,0),
                                                    new Point3D( new Coordinate(1500), new Coordinate(-1500), new Coordinate(-1500)),
                                                    new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500)),
                                                    new Point3D(  new Coordinate( -1500), new Coordinate( -1500), new Coordinate( -1500)));
                
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
                
                scene.addLight(new SpotLight(new Vector(new Point3D(new Coordinate(-2), new Coordinate(-2), new Coordinate(-3))),
                        new Point3D(new Coordinate(200), new Coordinate(200), new Coordinate(-150)),
                        0, 0.00001, 0.000005, new Color(255,100,100)));

		ImageWriter imageWriter = new ImageWriter("Reflected Test 1", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	
	@Test
	public void reflectedTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(300);
		
                Sphere sphere1 = new Sphere(new Color(0, 0, 100), new Material(1,1,20,0,1),300, new Point3D(new Coordinate(-500), new Coordinate(-500), new Coordinate(-1000)));
                Sphere sphere2 = new Sphere(new Color(100, 20, 20), new Material(1,1,20,0,0),150, new Point3D(new Coordinate(-500), new Coordinate(-500), new Coordinate(-1000)));

		scene.addGeometry(sphere1);
		scene.addGeometry(sphere2);

                Triangle triangle1 = new Triangle(new Color(0, 0, 0), new Material(1,1,20,1,0), 
                                                    new Point3D( new Coordinate(1500), new Coordinate(-1500), new Coordinate(-1500)),
                                                    new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500)),
                                                    new Point3D(  new Coordinate(500), new Coordinate(800), new Coordinate( -375)));
                Vector V1=new Vector(new Point3D( new Coordinate(1500), new Coordinate(-1500), new Coordinate(-1500)).substract(new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500))));
                Vector V2=new Vector((new Point3D( new Coordinate( 700), new Coordinate( 500), new Coordinate( -375))).substract(new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500))));
                
                Triangle triangle2 = new Triangle(new Color(0, 0, 0), new Material(1,1,20,1,0),
                                                    new Point3D( new Coordinate(1500), new Coordinate(-1500), new Coordinate(-1500)),
                                                    new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500)),
                                                    new Point3D(  new Coordinate( -1500), new Coordinate( -1500), new Coordinate( -1500)));
                
                 V1=new Vector(new Point3D( new Coordinate(-1500), new Coordinate(-1500), new Coordinate(-1500)).substract(new Point3D( new Coordinate( 1500), new Coordinate( -1500), new Coordinate( -1500))));
                V2=new Vector((new Point3D( new Coordinate( -1500), new Coordinate( -1500), new Coordinate(-1500))).substract(new Point3D( new Coordinate( -1500), new Coordinate( 1500), new Coordinate( -1500))));

                
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);

                scene.addLight(new SpotLight(new Vector(new Point3D(new Coordinate(5), new Coordinate(0), new Coordinate(-4))),
                                            new Point3D(new Coordinate(-1000), new Coordinate(-500), new Coordinate(-600)),
                                            0, 0.00001, 0.000005, new Color(255,100,100)));
	
		ImageWriter imageWriter = new ImageWriter("Reflected Test2", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
	}
        

}
