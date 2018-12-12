package Primitives;

// inherites from Point2D and another coordinate
public class Point3D implements Comparable<Point3D>{
    private Coordinate _x;
    private Coordinate _y;
    private Coordinate _z;
    
    // ***************** Constructors ********************** //
    //default ctor
    public Point3D()
    {
        _x=new Coordinate(); 
        _y=new Coordinate();
        _z=new Coordinate();
    }
    //the ctor initialized point3D by 3 coordinates
    public Point3D(Coordinate x, Coordinate y, Coordinate z)
    {
        _x=x;
        _y=y;
        _z=z;
    }
    //copy ctor- the ctor initialized point3D by another point
    public Point3D(Point3D p)
    {
        _x=p._x; 
        _y=p._y;
        _z=p._z;
    }
    
    // ***************** Getters/Setters ********************** //
    public Coordinate get_x(){ return _x;}
    public void set_x(Coordinate x){_x=x;}
    public Coordinate get_y(){ return _y;}
    public void set_y(Coordinate y){_y=y;}
    public Coordinate get_z(){ return _z;}
    public void set_z(Coordinate z){_z=z;}

    @Override
    public int compareTo(Point3D p) {
        if (this._x.compareTo(p._x)==0 && this._y.compareTo(p._y)==0 && this._z.compareTo(p._z)==0)
            return 0; 
        else 
            return -1; 
    }
    
    // ***************** Operations ******************** // 
    //the function gets a vector and add it to the point3D. It returns another point3D.
    public Point3D add(Vector v)
    {
        return new Point3D(this._x.add(v.get_head()._x), 
                           this._y.add(v.get_head()._y), 
                           this._z.add(v.get_head()._z));
    }
    //the function gets a vector and substract it from the point3D. It returns another point3D.
    public Point3D substract(Vector _v)
    {
	
	return new Point3D(this._x.substract(_v.get_head()._x),
			   this._y.substract(_v.get_head()._y),
			   this._z.substract(_v.get_head()._z));	
    }
    //the function gets a point3D and substract it from the point3D. It returns a vector.
    public Vector substract(Point3D p)
    {
        return new Vector (new Point3D(
                           this._x.substract(p._x), 
                           this._y.substract(p._y), 
                           this._z.substract(p._z)));
    }  
    //the function calculates the distance between 2 points 
    public double distance(Point3D point)
    {
        return Math.sqrt(Math.pow(_x.substract(point._x).get_coordinate(), 2)+Math.pow(_y.substract(point._y).get_coordinate(), 2)+Math.pow(_z.substract(point._z).get_coordinate(), 2));
    }
}
