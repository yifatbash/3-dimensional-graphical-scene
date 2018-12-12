import Primitives.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Point3DTest 
{
    //the function tests adding between two point3D
    @Test 
    public void testAdd()
    {
        //adding between + and +
        Point3D p= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        Vector v=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2)));
        Point3D actual = p.add(v); 
        Point3D expected= new Point3D(new Coordinate(7.2), new Coordinate(4.2), new Coordinate(4.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);  
        
        //adding between - and -
        p= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        v=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2)));
        actual = p.add(v); 
        expected= new Point3D(new Coordinate(-7.2), new Coordinate(-4.2), new Coordinate(-4.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10); 
        
        //adding between + and -
        p= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        v=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2)));
        actual = p.add(v); 
        expected= new Point3D(new Coordinate(3.2), new Coordinate(3.2), new Coordinate(0.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);  
        
        //adding between + and -
        p= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        v=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2)));
        actual = p.add(v); 
        expected= new Point3D(new Coordinate(-3.2), new Coordinate(-3.2), new Coordinate(-0.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10); 
    }
    //the function tests substracting between vector and point3D
     @Test 
    public void testSubstractVector()
    {
         //substracting between + and +
        Point3D p= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        Vector v=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2)));
        Point3D actual = p.substract(v); 
        Point3D expected= new Point3D(new Coordinate(3.2), new Coordinate(3.2), new Coordinate(0.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);  
        
        //substracting between - and -
        p= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        v=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2)));
        actual = p.substract(v); 
        expected= new Point3D(new Coordinate(-3.2), new Coordinate(-3.2), new Coordinate(-0.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);   
        
        //substracting between + and -
        p= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        v=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2)));
        actual = p.substract(v); 
        expected= new Point3D(new Coordinate(7.2), new Coordinate(4.2), new Coordinate(4.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);   
        
        //substracting between - and +
        p= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        v=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2)));
        actual = p.substract(v); 
        expected= new Point3D(new Coordinate(-7.2), new Coordinate(-4.2), new Coordinate(-4.6));
        assertEquals(actual.get_x().get_coordinate(),expected.get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_y().get_coordinate(),expected.get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_z().get_coordinate(),expected.get_z().get_coordinate(),1e-10);  
    }
    
    //the function tests substracting between two point3D
    @Test 
    public void testSubstractPoint()
    {
        //substracting between + and +
        Point3D p1= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        Point3D p2=new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2));
        Vector actual = p1.substract(p2); 
        Vector expected= new Vector(new Point3D(new Coordinate(3.2), new Coordinate(3.2), new Coordinate(0.6)));
        assertEquals(actual.get_head().get_x().get_coordinate(),expected.get_head().get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_head().get_y().get_coordinate(),expected.get_head().get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_head().get_z().get_coordinate(),expected.get_head().get_z().get_coordinate(),1e-10);
        
        //substracting between - and -
        p1= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        p2=new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2));
        actual = p1.substract(p2); 
        expected= new Vector(new Point3D(new Coordinate(-3.2), new Coordinate(-3.2), new Coordinate(-0.6)));
        assertEquals(actual.get_head().get_x().get_coordinate(),expected.get_head().get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_head().get_y().get_coordinate(),expected.get_head().get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_head().get_z().get_coordinate(),expected.get_head().get_z().get_coordinate(),1e-10);  
        
        //substracting between + and -
        p1= new Point3D(new Coordinate(5.2), new Coordinate(3.7), new Coordinate(2.6));
        p2=new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-2));
        actual = p1.substract(p2); 
        expected= new Vector(new Point3D(new Coordinate(7.2), new Coordinate(4.2), new Coordinate(4.6)));
        assertEquals(actual.get_head().get_x().get_coordinate(),expected.get_head().get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_head().get_y().get_coordinate(),expected.get_head().get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_head().get_z().get_coordinate(),expected.get_head().get_z().get_coordinate(),1e-10);
        
        //substracting between - and +
        p1= new Point3D(new Coordinate(-5.2), new Coordinate(-3.7), new Coordinate(-2.6));
        p2=new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(2));
        actual = p1.substract(p2); 
        expected= new Vector(new Point3D(new Coordinate(-7.2), new Coordinate(-4.2), new Coordinate(-4.6)));
        assertEquals(actual.get_head().get_x().get_coordinate(),expected.get_head().get_x().get_coordinate(),1e-10);    
        assertEquals(actual.get_head().get_y().get_coordinate(),expected.get_head().get_y().get_coordinate(),1e-10);  
        assertEquals(actual.get_head().get_z().get_coordinate(),expected.get_head().get_z().get_coordinate(),1e-10); 
    }   
    
    //the function tests calculating distance between two point3D
    @Test 
    public void testDistance()
    {
        Point3D p1= new Point3D(new Coordinate(6), new Coordinate(3), new Coordinate(3));
        Point3D p2=new Point3D(new Coordinate(2), new Coordinate(0),new Coordinate(3));
        double actual=p1.distance(p2);
        double expected=5; 
        assertEquals(actual, expected, 1e-10);
        
        p1= new Point3D(new Coordinate(-6), new Coordinate(-3), new Coordinate(-3));
        p2=new Point3D(new Coordinate(-2), new Coordinate(0),new Coordinate(-3));
        actual=p1.distance(p2);
        expected=5; 
        assertEquals(actual, expected, 1e-10);
    }
}
