package Primitives;

// defines ray by Point3D (the begining point of the vector) and vector.
public class Ray implements Comparable<Ray>{
    private Point3D _POO;
    private Vector _direction;
    
    // ***************** Constructors ********************** //
    public Ray(Point3D POO,Vector direction)
    {
        _POO=POO;
        _direction=direction;
    }
    ////copy ctor- the ctor initialized ray by another ray
    public Ray(Ray ray)
    {
        _POO=ray.get_POO();
        _direction=ray.get_direction();
    }
    
    @Override
    public int compareTo(Ray r) {
        if (this._POO.compareTo(r._POO)==0 && this._direction.compareTo(r._direction)==0)
            return 0; 
        else 
            return -1; 
    }
    
    // ***************** Getters/Setters ********************** //
    public Point3D get_POO(){return _POO;}
    public void set_POO(Point3D POO){_POO=POO;}
    public Vector get_direction(){return _direction;}
    public void set_direction(Vector direction){_direction=direction;}  
}
