package Geometries;
import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

// defines all the geometries whose contain raduis.
public abstract class RadialGeometry extends Geometry {
    protected double _raduis; 
    
    // ***************** Constructors ********************** //
    public RadialGeometry (double raduis)
    {
        super();
        _raduis=raduis; 
    }   
    public RadialGeometry (Color emmission, Material material,double raduis)
    {
        super(emmission, material);
        _raduis=raduis; 
    }   
    
    // ***************** Getters/Setters ********************** //
    public double get_raduis (){return _raduis; }
    public void set_raduis (Double raduis){ _raduis=raduis;}

    // ***************** Operations ******************** // 
    //the function find intersection points with the geometries, implemented by heritate classes 
    @Override
    public abstract ArrayList<Point3D> findIntersections(Ray r);
}
