package Primitives;
import java.util.Objects;

//defines coordinate by double value 
public class Coordinate implements Comparable<Coordinate> {
    private double _coordinate; 
    
    // ***************** Constructors ********************** //
    public Coordinate()
    {
        _coordinate=0;
    }
    public Coordinate(double coordinate)
    {
        _coordinate=coordinate;
    }
    //copy ctor- the ctor initialized coordinate by another coordinate
    public Coordinate(Coordinate coordinate)
    {
        _coordinate=coordinate.get_coordinate();
    }
    
    // ***************** Getters/Setters ********************** //
    public double get_coordinate(){ return _coordinate;}
    public void set_coordinate(Double coordinate){_coordinate=coordinate;}

    
    @Override
    public int compareTo(Coordinate c) {
       if (c._coordinate == this._coordinate )
           return 0; 
       else 
           return -1;
    }
    
    // ***************** Operations ******************** // 
    //the function gets coordinate c and add to the corrent coordinate
    public Coordinate add(Coordinate c)
    {
        return new Coordinate(this._coordinate+(c._coordinate)); 
    }
    //the function gets coordinate c and sustract from the corrent coordinate
    public Coordinate substract(Coordinate c)
    {
        return new Coordinate(this._coordinate-c._coordinate); 
    }          
}
