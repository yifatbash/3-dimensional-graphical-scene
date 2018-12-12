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

public class MiniProjectTest {

    //@Test
    public void MiniProjectTest_Before() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(255, 255, 255), new Material(1, 1, 20), 800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject (before)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_After3() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(255, 255, 255), new Material(1, 1, 20), 800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject (after3)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_After5() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(255, 255, 255), new Material(1, 1, 20), 800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject (after5)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }
    
    //@Test
    public void MiniProjectTest_After5b() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(255, 255, 255), new Material(1, 1, 20), 800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject (after5b)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_After9() {
        Scene scene = new Scene();
        Sphere sphere = new Sphere(new Color(255, 255, 255), new Material(1, 1, 20), 800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject (after9)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_Triangle_Before() {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(Color.white, new Material(), new Point3D(new Coordinate(-180), new Coordinate(200), new Coordinate(-149)),
                new Point3D(new Coordinate(200), new Coordinate(-200), new Coordinate(-149)),
                new Point3D(new Coordinate(-200), new Coordinate(-220), new Coordinate(-149)));

        scene.addGeometry(triangle);
        //Sphere sphere = new Sphere (new Color(255,255,255),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        //scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject_ triangle (before)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_Triangle_After3() {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(Color.white, new Material(), new Point3D(new Coordinate(-180), new Coordinate(200), new Coordinate(-149)),
                new Point3D(new Coordinate(200), new Coordinate(-200), new Coordinate(-149)),
                new Point3D(new Coordinate(-200), new Coordinate(-220), new Coordinate(-149)));

        scene.addGeometry(triangle);
        //Sphere sphere = new Sphere (new Color(255,255,255),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        //scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject_ triangle (after3)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    // @Test
    public void MiniProjectTest_Triangle_After5() {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(Color.white, new Material(), new Point3D(new Coordinate(-180), new Coordinate(200), new Coordinate(-149)),
                new Point3D(new Coordinate(200), new Coordinate(-200), new Coordinate(-149)),
                new Point3D(new Coordinate(-200), new Coordinate(-220), new Coordinate(-149)));

        scene.addGeometry(triangle);
        //Sphere sphere = new Sphere (new Color(255,255,255),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        //scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject_ triangle (after5)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    //@Test
    public void MiniProjectTest_Triangle_After5b() {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(Color.white, new Material(), new Point3D(new Coordinate(-180), new Coordinate(200), new Coordinate(-149)),
                new Point3D(new Coordinate(200), new Coordinate(-200), new Coordinate(-149)),
                new Point3D(new Coordinate(-200), new Coordinate(-220), new Coordinate(-149)));

        scene.addGeometry(triangle);
        //Sphere sphere = new Sphere (new Color(255,255,255),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        //scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject_ triangle (after5b)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }

    // @Test
    public void MiniProjectTest_Triangle_After9() {
        Scene scene = new Scene();
        Triangle triangle = new Triangle(Color.white, new Material(), new Point3D(new Coordinate(-180), new Coordinate(200), new Coordinate(-149)),
                new Point3D(new Coordinate(200), new Coordinate(-200), new Coordinate(-149)),
                new Point3D(new Coordinate(-200), new Coordinate(-220), new Coordinate(-149)));

        scene.addGeometry(triangle);
        //Sphere sphere = new Sphere (new Color(255,255,255),new Material(1,1,20),800, new Point3D(new Coordinate(0.0), new Coordinate(0.0), new Coordinate(-1000)));
        //scene.addGeometry(sphere);

        ImageWriter imageWriter = new ImageWriter("MiniProject_ triangle (after9)", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImageMiniProject();
        imageWriter.writeToimage();
    }
}
