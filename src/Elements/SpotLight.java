package Elements;
import Primitives.Point3D;
import Primitives.Vector;
import java.awt.Color;

//SpotLight class which represents a spot light source, heritates from the PointLight class
public class SpotLight extends PointLight {
    private Vector _direction;//the direction of the light source 

    // ***************** Constructors ********************** //
    public SpotLight()
    {
        super();
        this._direction = new Vector();
    }
    public SpotLight(Vector direction, Point3D position, double Kc, double Kl, double Kq, Color color) 
    {
        super(position, Kc, Kl, Kq, color);
        this._direction = direction;
    }
    
    // ***************** Getters/Setters ********************** /
    public Vector getDirection() {return _direction;}
    public void setDirection(Vector _direction) {this._direction = _direction;}
    
     // ***************** Operations ******************** //
    //the function returns the color of the light - using the formula: i*(D*N)/(Kc+Kl*d+kq*d^2)
    @Override
    public Color getIntensity(Point3D point)
    {
        Vector D= new Vector(_direction).normalize();
        Vector L=getL(point).normalize(); //vector from the source light to the point
        
//        double r= _color.getRed()*Math.abs(D.dotProduct(L)/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2)));
//        double g= _color.getGreen()*Math.abs(D.dotProduct(L)/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2)));
//        double b= _color.getBlue()*Math.abs(D.dotProduct(L)/(_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2)));
        
        double divideFactor=_Kc+_Kl*point.distance(_position)+_Kq*Math.pow(point.distance(_position),2);
        double multFactor=Math.abs(D.dotProduct(L)); 
        if (divideFactor<=1)
            divideFactor=1; 
        if (multFactor>1)
            multFactor=1;
        
        double r= _color.getRed()*multFactor/divideFactor;
        double g= _color.getGreen()*multFactor/divideFactor;
        double b= _color.getBlue()*multFactor/divideFactor;
        
        //checks that the rgb values are not out of range
        if(r>255)
            r=255;
        if(g>255)
            g=255;
        if(b>255)
            b=255;
        
        Color I=new Color((int)r, (int)g, (int)b); 
        return I; 
    } 
}
