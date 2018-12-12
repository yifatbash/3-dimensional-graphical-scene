package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

// defines plane by Point3D and Normal
public class Plane extends Geometry implements FlatGeometry{
    private Point3D _Q;
    private Vector _N;
    
    // ***************** Constructors ********************** //
    public Plane (Point3D Q,Vector N)
    {
        super();
        _Q=Q;
        _N=N;
    } 
    public Plane (Color emmission, Material material,Point3D Q,Vector N)
    {
        super(emmission, material);
        _Q=Q;
        _N=N;
    } 
    
    // ***************** Getters/Setters ********************** //
    public Point3D get_Q(){return _Q;}
    public void set_Q(Point3D Q){_Q=Q;}
    public Vector get_N(){return _N;}
    public void set_N(Vector N){_N=N;}
    
    // ***************** Operations ******************** // 
    //the function find intersections points between ray and plane 
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray)
    {
        ArrayList<Point3D> intersections=new ArrayList<>(); 
       // t=-N*(PO-Q0)/N*V: we calculate the distance we should go from P0 in direction of the ray in order to arrive to P=point in the plane 
       double t= -_N.dotProduct(ray.get_POO().substract(_Q))/_N.dotProduct(ray.get_direction());
       Point3D P=new Point3D(); 
       // P=P0+t*V: P is the ray intersection point in the plane 
       P=ray.get_POO().add(ray.get_direction().scaling(t)); 
       intersections.add(P);   
       // return the insersection point with the plane 
       return intersections; 
    }
    
    //the function gets point on the geometry and returns the normal of the point
    @Override
    public Vector getNormal(Point3D point) {
        return _N; 
    }
}



