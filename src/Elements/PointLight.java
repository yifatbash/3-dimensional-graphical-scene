package Elements;
import Primitives.Point3D;
import Primitives.Vector;
import java.awt.Color;

//PointLight class which represents a spot light source, heritates from the Light class
public class PointLight extends Light implements LightSource{
    protected Point3D _position;//the position of the light
    //numbers representing the attenuation factors with distance d (thinness of light)
    protected double _Kc; 
    protected double _Kl; 
    protected double _Kq; 

    // ***************** Constructors ********************** //
    public PointLight() {
        super(); 
        this._position = new Point3D();
        this._Kc = 0.001;
        this._Kl = 0.001;
        this._Kq = 0.001;
    }
    public PointLight(Point3D position, double Kc, double Kl, double Kq, Color color) {
        super(color);
        this._position = position;
        this._Kc = Kc;
        this._Kl = Kl;
        this._Kq = Kq;
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getPosition() {return _position;}
    public double getKc() {return _Kc;}
    public double getKl() {return _Kl;}
    public double getKq() {return _Kq;}

    public void setPosition(Point3D position) {this._position = position;}
    public void setKc(double Kc) {this._Kc = Kc;}
    public void setKl(double Kl) {this._Kl = Kl;}
    public void setKq(double Kq) {this._Kq = Kq;}
    
    // ***************** Operations ******************** //
    //the function returns the color of the light - using the formula: i/(Kc+Kl*d+kq*d^2)
    @Override
    public Color getIntensity(Point3D point) {
        
        double divideFactor=_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2);
        if(divideFactor<1)
            divideFactor=1;
        
       double r= _color.getRed()/divideFactor;
       double g= _color.getGreen()/divideFactor;
       double b= _color.getBlue()/divideFactor;
        
//       double r= _color.getRed()/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2));
//       double g= _color.getGreen()/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2));
//       double b= _color.getBlue()/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2));
       
       
       
       //checks that the rgb values are not out of range 
        if(r>255)
            r=255;
        if(g>255)
            g=255;
        if(b>255)
            b=255;
        
       Color I= new Color((int)r, (int)g, (int)b);
       return I; 
    }
    //the function returns a vector connect between the center of the light source and a given point of the geometry 
    @Override
    public Vector getL(Point3D point) {
        Vector l=new Vector(); 
        l=point.substract(_position);
        return l; 
    }
}
