package Elements;
import Primitives.Coordinate;
import Primitives.Point3D;
import java.awt.Color;

//AmbientLighr source represents a fixed itensity and fixed color light source that affects all objects in the scene equally 
public class AmbientLight extends Light implements Comparable<AmbientLight>{
    private double Ka;//number representing the attenuation factors
    
    // ***************** Constructors ********************** //
    public AmbientLight()
    {
        super();
        Ka=0.1; 
    }
    public AmbientLight(Color color, double ka)
    {
        super(color); 
        Ka=ka; 
    } 
    public AmbientLight(int r, int g, int b)
    {
       Color color= new Color((int)r, (int)g, (int)b);
       _color=color; 
        Ka=0.1; 
    }
    //copy ctor
    public AmbientLight(AmbientLight light)
    {
        super(light._color); 
        Ka=light.Ka; 
    }

    // ***************** Getters/Setters ********************** //
    public double get_Ka(){ return Ka;}
    public void set_Ka(double ka){Ka=ka;}
    
    // ***************** Operations ******************** //  
    // the function returns the ambientLight intensity - using formula: i*Ka  
    @Override
    public Color getIntensity(Point3D point)
    {
       double r= Ka*_color.getRed();
       double g= Ka*_color.getGreen();
       double b= Ka*_color.getBlue();
       Color I= new Color((int)r, (int)g, (int)b);
        
       return I;
    }
    //the function compare between two ambient lights
    @Override
    public int compareTo(AmbientLight light) {
      if(light._color==_color && light.Ka==Ka)
          return 0;
      else 
          return -1; 
    }
}
