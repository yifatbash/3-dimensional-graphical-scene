package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

// defines triangle by three Point3D (vertices of the triangle).
public class Triangle extends Geometry implements FlatGeometry{
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;
    
    // ***************** Constructors ********************** //
      public Triangle (Point3D p1,Point3D p2,Point3D p3)
    {
        super();
        _p1=p1; 
        _p2=p2; 
        _p3=p3;
    }
    public Triangle (Color emmission, Material material,Point3D p1,Point3D p2,Point3D p3)
    {
        super(emmission,material);
        _p1=p1; 
        _p2=p2; 
        _p3=p3;
    }
    
    // ***************** Getters/Setters ********************** //
    public Point3D Get_p1(){return _p1;}
    public void set_p1(Point3D p1){_p1=p1;}
    public Point3D Get_p2(){return _p2;}
    public void set_p2(Point3D p2){_p2=p2;}
    public Point3D Get_p3(){return _p3;}
    public void set_p3(Point3D p3){_p3=p3;}        

    // ***************** Operations ******************** // 
    //the function find intersections points between ray and triangle 
    @Override
    public ArrayList<Point3D> findIntersections(Ray ray) {
       ArrayList<Point3D> intersections=new ArrayList<>(); 
       
       //calculate the plane in which the triangle is state
       Vector vOnTriangle1= new Vector (_p1.substract(_p2));// calculate the first vector on the triangle plane
       Vector vOnTriangle2= new Vector (_p1.substract(_p3));// calculate the second vector on the triangle plane
       Vector triangleNormal= new Vector(vOnTriangle1.crossProduct(vOnTriangle2));// calculate the normal of the triangle plane (V1xV2)
       Plane trianglePlane=new Plane(_p1,triangleNormal); //create the triangle plane
       //calculte the intersection point with the triangle plane
       intersections.addAll(trianglePlane.findIntersections(ray));
       
       // create a pyramid which it's base is the triangle 
       Vector v1=new Vector(_p1.substract(ray.get_POO()));
       Vector v2=new Vector(_p2.substract(ray.get_POO()));
       Vector v3=new Vector(_p3.substract(ray.get_POO()));
       
       //create a normal for each face of the pyramid
       Vector N1=new Vector(v1.crossProduct(v2)).normalize();
       Vector N2=new Vector(v2.crossProduct(v3)).normalize();
       Vector N3=new Vector(v3.crossProduct(v1)).normalize();
       
       // P=ray intersection point with the triangle 
       Point3D P=new Point3D(intersections.get(0)); 
       // if all the normals are IN the pyramid: sign(P-P0)*N1==sign(P-P0)*N2==sign(P-P0)*N3 so the intersection P is in the triangle 
       if (P.substract(ray.get_POO()).dotProduct(N1)>0 && P.substract(ray.get_POO()).dotProduct(N2)>0 && P.substract(ray.get_POO()).dotProduct(N3)>0)
       {
           return intersections; 
       }
       if(P.substract(ray.get_POO()).dotProduct(N1)<0 && P.substract(ray.get_POO()).dotProduct(N2)<0 && P.substract(ray.get_POO()).dotProduct(N3)<0)
       {
           return intersections; 
       }
       // P is on the plane but not in the triangle so no intersection point with the triangle 
       else 
           return null; 
    }

    //the function gets point on the geometry and returns the normal of the point
    @Override
    public Vector getNormal(Point3D point) {
        Vector v1=new Vector(); 
        v1=_p2.substract(_p1); 
        Vector v2=new Vector(); 
        v2=_p3.substract(_p1); 
        Vector normal=v1.crossProduct(v2).normalize(); 
        return normal;
    }
}
