package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

// defines cylinder by Point3D, vector and raduis inherited by radicalGeometry.
public class Cylinder extends RadialGeometry {
    private Point3D _axisPoint; 
    private Vector _axisDirection;
    
    // ***************** Constructors ********************** //
    public Cylinder (double raduis, Point3D axisPoint, Vector axisDirection)
    {
        super(raduis);
        _axisPoint=axisPoint;
        _axisDirection=axisDirection;       
    }
    public Cylinder (Color emmission, Material material, double raduis, Point3D axisPoint, Vector axisDirection)
    {
        super(emmission,material,raduis);
        _axisPoint=axisPoint;
        _axisDirection=axisDirection;       
    }
    
    // ***************** Getters/Setters ********************** //
    public Point3D get_axisPoint(){return _axisPoint;}
    public void set_axisPoint(Point3D axisPoint){ _axisPoint=axisPoint;}
    public Vector get_axisDirection(){return _axisDirection;}
    public void set_axisDirection(Vector axisDirection){_axisDirection=axisDirection;}
    
    // ***************** Operations ******************** // 
    @Override
    public ArrayList<Point3D> findIntersections(Ray r)
    {
        throw new UnsupportedOperationException("Not supported on this course."); 
    }
    @Override
    public Vector getNormal(Point3D point) {
        throw new UnsupportedOperationException("Not supported on this course."); 
    } 
}
