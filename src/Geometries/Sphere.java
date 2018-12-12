package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

// defines sphere by Point3D (the center point) and raduis inherited by radicalGeometry.
public class Sphere extends RadialGeometry  {
    private Point3D _center; 
    
    // ***************** Constructors ********************** // 
    public Sphere (double raduis, Point3D center) 
    {
        super(raduis);
        _center=center;      
    }
    public Sphere (Color emmission, Material material ,double raduis, Point3D center) 
    {
        super(emmission,material,raduis);
        _center=center;      
    }
    
    // ***************** Getters/Setters ********************** //
    public Point3D get_center(){ return _center; }
    public void set_center(Point3D center){_center=center;}    

    // ***************** Operations ******************** // 
    //the function find intersections points between ray and sphere
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) 
    {   
        ArrayList<Point3D> intersections=new ArrayList<>();
        
        Vector L= new Vector(); 
        L=this._center.substract(ray.get_POO()); //L=O-POO: L is a vector from POO(beginning of the ray) to the sphere center point 
        double tm=L.dotProduct(ray.get_direction()); //tm=L*V: tm is the projection of vector L on the ray 
        double d= Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2)); // d=(|L|^2-tm^2)^0.5: d is the distance between the center point and the ray 
        if (d>_raduis)
        {
            return null; // if d>r no ray intersections 
        }
        
        double th= Math.sqrt(Math.pow(_raduis,2)-Math.pow(d,2)); //th=(r^2-d^2)^0.5: th is half of the distance between the 2 ray intersections   
        double t1=tm-th; // help us to find the first ray intersection with the sphere 
        double t2=tm+th; // help us to find the second ray intersection with the sphere 
        
        Point3D P1=new Point3D(); 
        Point3D P2=new Point3D(); 
        // if both t1 and t2 are positives- has 2 ray intersection
        // if just one of them is positive- has 1 ray intersection 
        if (t1>0)
        {
            P1=ray.get_POO().add(ray.get_direction().scaling(t1)); // P1=PO+t1*V: calculate the first ray intersection
            intersections.add(P1);
        }
        if (t2>0)
        {
           P2=ray.get_POO().add(ray.get_direction().scaling(t2)); // P2=PO+t2*V: calculate the second ray intersection 
           intersections.add(P2);
        }    
        
        return intersections; // return the ray intersections with the sphere 
    }
    //the function gets point on the geometry and returns the normal of the point 
    @Override
    public Vector getNormal(Point3D point) {
        Vector normal= new Vector(); 
        normal=point.substract(_center); 
        return normal.normalize(); 
    }
}
