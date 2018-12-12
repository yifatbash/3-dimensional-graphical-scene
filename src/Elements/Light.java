package Elements;

import Primitives.Point3D;
import java.awt.Color;

//Light abstract class defines the light, all types of light in scene will inherit from it  
public abstract class Light {
    protected Color _color; 
    
    // ***************** Constructors ********************** //
    public Light ()
    {
        this._color = Color.white;
    }
    public Light (Color _color)
    {
        this._color = _color;
    }
    
    // ***************** Getters/Setters ********************** //
    public Color getColor() {return _color;}
    public void setColor(Color _color) {this._color = _color;}

    public abstract Color getIntensity(Point3D point);
}
