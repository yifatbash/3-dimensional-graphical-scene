import Elements.*;
import Geometries.*;
import Primitives.*;
import Renderer.*;
import Scene.Scene;
import java.awt.Color;
import org.junit.Test;


public class OccludedTest {   
    
        @Test
	public void spotLightTestOccluded1()
        {
            Scene scene = new Scene();
	    scene.setScreenDistance(200);

            Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),500, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
            scene.addGeometry(sphere);
		
            Triangle triangle = new Triangle(new Color(0,0,100),new Material(1,1,4),
                                new Point3D( new Coordinate(-125),new Coordinate(-225),new Coordinate(-260)),
	 			new Point3D(new Coordinate(-225), new Coordinate(-125),new Coordinate(-260)),
	 			new Point3D(new Coordinate(-225),new Coordinate(-225),new Coordinate(-270)));
		scene.addGeometry(triangle);
		
		
		scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(-3))),
				new Point3D(new Coordinate(-200), new Coordinate(-200),new Coordinate(-150)),0.1, 0.00001, 0.000005,new Color(255,100,100)));
				
		ImageWriter imageWriter = new ImageWriter("Spot test1(OCCLUDED)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
        }
        
        @Test
        public void spotLightTestOccluded2()
        {
            Scene scene = new Scene();
	    scene.setScreenDistance(200);

            Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),500, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
            scene.addGeometry(sphere);
		
            Triangle triangle = new Triangle(new Color(0,0,100),new Material(1,1,4),
                                new Point3D( new Coordinate(-100),new Coordinate(-200),new Coordinate(-300)),
	 			new Point3D(new Coordinate(-200), new Coordinate(-100),new Coordinate(-300)),
	 			new Point3D(new Coordinate(-200),new Coordinate(-200),new Coordinate(-310)));
		scene.addGeometry(triangle);
		
		
		scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(-3))),
				new Point3D(new Coordinate(-200), new Coordinate(-200),new Coordinate(-150)),0.1, 0.00001, 0.000005,new Color(255,100,100)));
				
		ImageWriter imageWriter = new ImageWriter("Spot test2(OCCLUDED)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
        }
        
        @Test
        public void spotLightTestOccluded3()
        {
            Scene scene = new Scene();
	    scene.setScreenDistance(200);

            Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),500, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
            scene.addGeometry(sphere);
		
            Triangle triangle = new Triangle(new Color(0,0,100),new Material(1,1,4),
                                new Point3D( new Coordinate(-75),new Coordinate(-150),new Coordinate(-280)),
	 			new Point3D(new Coordinate(-150), new Coordinate(-75),new Coordinate(-280)),
	 			new Point3D(new Coordinate(-150),new Coordinate(-150),new Coordinate(-290)));
		scene.addGeometry(triangle);
		
		
		scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(-3))),
				new Point3D(new Coordinate(-200), new Coordinate(-200),new Coordinate(-150)),0.1, 0.00001, 0.000005,new Color(255,100,100)));
				
		ImageWriter imageWriter = new ImageWriter("Spot test3(OCCLUDED)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
        }
        
        @Test
        public void spotLightTestOccluded4()
        {
            Scene scene = new Scene();
	    scene.setScreenDistance(200);

            Sphere sphere = new Sphere (new Color(0, 0, 100),new Material(1,1,20),500, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
            scene.addGeometry(sphere);
		
            Triangle triangle = new Triangle(new Color(0,0,100),new Material(1,1,4),
                                new Point3D( new Coordinate(-125),new Coordinate(-225),new Coordinate(-220)),
	 			new Point3D(new Coordinate(-225), new Coordinate(-125),new Coordinate(-220)),
	 			new Point3D(new Coordinate(-225),new Coordinate(-225),new Coordinate(-230)));
		scene.addGeometry(triangle);
		
		
		scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(2),new Coordinate(2),new Coordinate(-3))),
				new Point3D(new Coordinate(-200), new Coordinate(-200),new Coordinate(-150)),0.1, 0.00001, 0.000005,new Color(255,100,100)));
				
		ImageWriter imageWriter = new ImageWriter("Spot test4(OCCLUDED)", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
        }  
        
        @Test
        public void shadowTest(){
		
		Scene scene = new Scene();
		scene.setAmbientLight(new AmbientLight(Color.white, 0.1));
		Sphere sphere = new Sphere (new Color(0, 0, 150),new Material(1,1,20),500, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
		
		scene.addGeometry(sphere);
		
                Triangle triangle1 = new Triangle(
                                new Point3D( new Coordinate(3500),new Coordinate(3500),new Coordinate(-2000)),
	 			new Point3D(new Coordinate(-3500), new Coordinate(-3500),new Coordinate(-1000)),
	 			new Point3D(new Coordinate(3500),new Coordinate(-3500),new Coordinate(-2000)));
                Triangle triangle2 = new Triangle(
                                new Point3D( new Coordinate(3500),new Coordinate(3500),new Coordinate(-2000)),
	 			new Point3D(new Coordinate(-3500), new Coordinate(3500),new Coordinate(-1000)),
	 			new Point3D(new Coordinate(-3500),new Coordinate(-3500),new Coordinate(-1000)));
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		
                scene.addLight(new SpotLight( new Vector(new Point3D(new Coordinate(-2),new Coordinate(-2),new Coordinate(-3))),
				new Point3D(new Coordinate(200), new Coordinate(200),new Coordinate(-100)),0, 0.00001, 0.000005,new Color(255, 100, 100)));
		
		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		imageWriter.writeToimage();
		
	}
}
