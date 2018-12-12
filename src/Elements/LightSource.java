package Elements;
import Primitives.*;
import java.awt.Color;

//LightSource interface which marks the source lights
public interface LightSource {
    
    public Color getIntensity(Point3D point);
    public Vector getL(Point3D point); 
    
}
