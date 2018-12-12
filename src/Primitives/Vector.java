package Primitives;
import java.lang.Math;

// defines vector by Point3D. By default the point is (0,0,0)
public class Vector implements Comparable<Vector>{
    private Point3D _head;
    
    // ***************** Constructors ********************** //
    // default ctor 
    public Vector()
    {
         _head=new Point3D(); 
    }
    //ctor gets point3D and initialized the vector from (0,0,0) to the point3D
    public Vector(Point3D p)
    {
        _head=p;
    }
    //copy ctor- initialized the vector with another vector
    public Vector (Vector v)
    {
        _head=new Point3D(v._head); 
    }
   
    // ***************** Getters/Setters ********************** //
    public Point3D get_head(){return _head;}
    public void set_head(Point3D head){_head=head;}

    @Override
    public int compareTo(Vector v) {
        if (this._head.compareTo(v._head)==0)
            return 0; 
        else 
            return -1; 
    }
    
    // ***************** Operations ******************** // 
    //the function gets vector and add to the corrent vector
    public Vector add(Vector v)
    {
        return new Vector (this._head.add(v));
    }
    //the function gets vector and substract from the corrent vector
    public Vector substract(Vector v)
    {
        return new Vector (this._head.substract(v));
    }
    //the function gets vector and returns a vector which is vertical of both corrent vector and given vector.
    public Vector crossProduct(Vector v)
    {
    Vector v1=new Vector(new Point3D
                        (new Coordinate (this._head.get_y().get_coordinate()*v._head.get_z().get_coordinate()-
                                this._head.get_z().get_coordinate()*v._head.get_y().get_coordinate()),
                        new Coordinate (this._head.get_z().get_coordinate()*v._head.get_x().get_coordinate()-
                                this._head.get_x().get_coordinate()*v._head.get_z().get_coordinate()), 
                        new Coordinate(this._head.get_x().get_coordinate()*v._head.get_y().get_coordinate()-
                                this._head.get_y().get_coordinate()*v._head.get_x().get_coordinate())));
    if(v1.length() != 0)
        v1.normalize();  
    
    return v1;
    }
    //the function returns the length of corrent vector 
    public double length()
    {
        return (Math.sqrt(Math.pow(this._head.get_x().get_coordinate(), 2)
                          +Math.pow(this._head.get_y().get_coordinate(), 2) 
                          +Math.pow(this._head.get_z().get_coordinate(), 2))); 
    }
    // the function returns the normalized vector 
    public Vector normalize() 
    { 
        // the boundary case: if legth is 0 can't divide by zero
        if(this.length() == 0)
            return this;
            //throw new ArithmeticException("Didn't throw divide by zero exception!"); 

        return new Vector(
                new Point3D(new Coordinate(this._head.get_x().get_coordinate()/this.length()),
                            new Coordinate(this._head.get_y().get_coordinate()/this.length()),
                            new Coordinate(this._head.get_z().get_coordinate()/this.length())));                    
    }
    //the function gets vector and returns double var which represents the operation of dotProduct 
    public double dotProduct(Vector v)
    {
        return this._head.get_x().get_coordinate()*v._head.get_x().get_coordinate()
                +this._head.get_y().get_coordinate()*v._head.get_y().get_coordinate()
                +this._head.get_z().get_coordinate()*v._head.get_z().get_coordinate();
    }
    //the function gets double scalar and returns a vector multiplied with the scalar 
    public Vector scaling(double a)
        {
            return new Vector (new Point3D(
                new Coordinate(this._head.get_x().get_coordinate()*a),
                new Coordinate(this._head.get_y().get_coordinate()*a),
                new Coordinate(this._head.get_z().get_coordinate()*a)));
        }   
}
