package Elements;
import Primitives.Point3D;
import Primitives.Vector;
import java.awt.Color;

//DirectionalLight class represents a directional light source, heritate from the Light class
public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;//direction of the light source 

    // ***************** Constructors ********************** //
    public DirectionalLight() 
    {
        super(); 
        this._direction = new Vector();
    }
    public DirectionalLight(Color color, Vector direction) 
    {
        super(color);
        this._direction = direction;
    }

    // ***************** Getters/Setters ********************** //
    public Vector getDirection() {return _direction;}
    public void setDirection(Vector direction) {this._direction = direction;}
    
    // ***************** Operations ******************** //
    //the function returns the directional light intensity
    @Override
    public Color getIntensity(Point3D point) 
    {
       return _color; 
    }
    //the function returns a vector connect between the center of the light source and a given point of the geometry 
    @Override
    public Vector getL(Point3D point) {
        return _direction;
    }    
}
