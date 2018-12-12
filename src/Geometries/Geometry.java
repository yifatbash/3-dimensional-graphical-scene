package Geometries;

import Primitives.*;
import java.awt.Color;
import java.util.ArrayList;

//in order to be geometry the geometry should know to find ray intersections
public abstract class Geometry {
    protected Material _material;
    protected Color _emmission;
    
    // ***************** Constructors ********************** // 
    public Geometry() 
    {
	this._emmission = Color.black;
	this._material = new Material();
    }
    public Geometry(Color emmission, Material material) 
    {
        this._emmission = emmission;
	this._material = material;
    }
    //copy ctor
    public Geometry(Geometry g)
    {
        this._emmission = g._emmission;
	this._material = g._material;
    }
    
    // ***************** Getters/Setters ********************** //
    public Material getMaterial() {return _material;}
    public Color getEmmission() {return _emmission;}
    protected void setMaterial(Material _material) {this._material = _material;}
    protected void setEmmission(Color _emmission) {this._emmission = _emmission;}  
    
    //the function find intersections points between ray and geometry
    public abstract ArrayList<Point3D> findIntersections(Ray r); 
    public abstract Vector getNormal(Point3D point); 
}
