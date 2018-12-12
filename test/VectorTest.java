import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class VectorTest 
{
    //the function tests the normalization of the vector 
    @Test
    public void testNormalize()
    {
        //normalize vector with positive coordinates
        Vector v = new Vector(new Point3D (new Coordinate(3.5), new Coordinate(5), new Coordinate(10)));
        v=v.normalize();
        assertEquals(1, v.length(),1e-10);       
        v = new Vector(new Point3D (new Coordinate(0), new Coordinate(0), new Coordinate(0)));
        try 
        {   v= v.normalize();
            fail("Didn't throw divide by zero exception!");
        } 
        catch (ArithmeticException e)
        {
             assertTrue(true);
        }
        
        //normalize vector with negative coordinates
        v = new Vector(new Point3D (new Coordinate(-3.5), new Coordinate(-5), new Coordinate(-10)));
        v=v.normalize();
        assertEquals(1, v.length(),1e-10);       
        v = new Vector(new Point3D (new Coordinate(0), new Coordinate(0), new Coordinate(0)));
        try 
        {   v= v.normalize();
            fail("Didn't throw divide by zero exception!");
        } 
        catch (ArithmeticException e)
        {
             assertTrue(true);
        }
        
        //normalize vector with both positive and negative coordinates
        v = new Vector(new Point3D (new Coordinate(-3.5), new Coordinate(5), new Coordinate(-10)));
        v=v.normalize();
        assertEquals(1, v.length(),1e-10);       
        v = new Vector(new Point3D (new Coordinate(0), new Coordinate(0), new Coordinate(0)));
        try 
        {   v= v.normalize();
            fail("Didn't throw divide by zero exception!");
        } 
        catch (ArithmeticException e)
        {
             assertTrue(true);
        }
    }
    
    //the function tests the adding between two vectors 
    @Test 
    public void testAdd()
    {
        //adding between + and +
        Vector v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(4.3)));
        Vector v2=new Vector(new Point3D(new Coordinate(-1.5), new Coordinate(2.25),new Coordinate(3.0)));
        Vector actual=v1.add(v2);
        Vector expected=new Vector(new Point3D(new Coordinate(0.5), new Coordinate(2.75),new Coordinate(7.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //adding between - and -
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-4.3)));
        v2=new Vector(new Point3D(new Coordinate(-1.5), new Coordinate(-2.25),new Coordinate(-3.0)));
        actual=v1.add(v2);
        expected=new Vector(new Point3D(new Coordinate(-3.5), new Coordinate(-2.75),new Coordinate(-7.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //adding between + and -
        v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(4.3)));
        v2=new Vector(new Point3D(new Coordinate(-1.5), new Coordinate(-2.25),new Coordinate(-3.0)));
        actual=v1.add(v2);
        expected=new Vector(new Point3D(new Coordinate(0.5), new Coordinate(-1.75),new Coordinate(1.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //adding between - and +
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-4.3)));
        v2=new Vector(new Point3D(new Coordinate(1.5), new Coordinate(2.25),new Coordinate(3.0)));
        actual=v1.add(v2);
        expected=new Vector(new Point3D(new Coordinate(-0.5), new Coordinate(1.75),new Coordinate(-1.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
    }
    
     //the function tests the substracting between two vectors 
    @Test 
    public void testSubstract()
    {
        //substracting between + and +
        Vector v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(4.3)));
        Vector v2=new Vector(new Point3D(new Coordinate(1.5), new Coordinate(2.25),new Coordinate(3)));
        Vector actual=v1.substract(v2);
        Vector expected=new Vector(new Point3D(new Coordinate(0.5), new Coordinate(-1.75),new Coordinate(1.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //substracting between - and -
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-4.3)));
        v2=new Vector(new Point3D(new Coordinate(-1.5), new Coordinate(-2.25),new Coordinate(-3)));
        actual=v1.substract(v2);
        expected=new Vector(new Point3D(new Coordinate(-0.5), new Coordinate(1.75),new Coordinate(-1.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //substracting between + and -
        v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(0.5),new Coordinate(4.3)));
        v2=new Vector(new Point3D(new Coordinate(-1.5), new Coordinate(-2.25),new Coordinate(-3)));
        actual=v1.substract(v2);
        expected=new Vector(new Point3D(new Coordinate(3.5), new Coordinate(2.75),new Coordinate(7.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //substracting between - and +
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-0.5),new Coordinate(-4.3)));
        v2=new Vector(new Point3D(new Coordinate(1.5), new Coordinate(2.25),new Coordinate(3)));
        actual=v1.substract(v2);
        expected=new Vector(new Point3D(new Coordinate(-3.5), new Coordinate(-2.75),new Coordinate(-7.3)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
    }
    
     //the function tests the operation of crossProduct between two vectors 
    @Test 
    public void crossProduct()
    {
        //crossProduct 2 vectors from the first quadrant (+,+)
        Vector v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(4),new Coordinate(0)));
        Vector v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(5),new Coordinate(0)));
        Vector actual=v1.crossProduct(v2);
        Vector expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(6)));
        assertTrue(actual.compareTo(expected)==0);
        
        //crossProduct 2 vectors from the third quadrant (-,-)
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-4),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(-1), new Coordinate(-5),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(6)));
        assertTrue(actual.compareTo(expected)==0);
        
        //crossProduct 2 vectors from the first quadrant (+,+) and the third quadrant (-,-)
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-4),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(5),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-6)));
        assertTrue(actual.compareTo(expected)==0);
        
        //crossProduct 2 vectors from the fourth quadrant (+,-) and the second quadrant (-,+)
        v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(-4),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(-1), new Coordinate(5),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(6)));
        assertTrue(actual.compareTo(expected)==0);
        
        //crossProduct 2 vectors from the second quadrant (-,+) and the first quadrant (+,+)
        v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(4),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(5),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(-14)));
        assertTrue(actual.compareTo(expected)==0);
        
        //boundary case: crossProduct vector on x axis with vector on y axis
        v1=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(0), new Coordinate(1),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(1)));
        assertTrue(actual.compareTo(expected)==0);
        
        //boundary case: crossProduct vector on x axis with itself
        v1=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
        v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
        actual=v1.crossProduct(v2);
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(0)));
        assertTrue(actual.compareTo(expected)==0);
    }
    
    // the function tests if we get correct length of the vector 
    @Test 
    public void testLength()
    {
        //calcultate the length of vector with positive coordinates
        Vector v=new Vector(new Point3D(new Coordinate(4), new Coordinate(2),new Coordinate(4)));
        double actual= v.length(); 
        double expected=6;
        assertEquals(actual, expected,1e-10);
        
        //calcultate the length of vector with negative coordinates
        v=new Vector(new Point3D(new Coordinate(-4), new Coordinate(-2),new Coordinate(-4)));
        actual= v.length(); 
        expected=6;
        assertEquals(actual, expected,1e-10);
        
        //calcultate the length of vector with both positive and negative coordinates
        v=new Vector(new Point3D(new Coordinate(-4), new Coordinate(2),new Coordinate(-4)));
        actual= v.length(); 
        expected=6;
        assertEquals(actual, expected,1e-10);
    }
    
    //the function tests the operation of scalling between scalar and vector 
    @Test
    public void testScalling()
    {
        //tests scalling with a positive number
        Vector actual=new Vector(new Point3D(new Coordinate(4), new Coordinate(2),new Coordinate(-3)));
        actual=actual.scaling(2); 
        Vector expected=new Vector(new Point3D(new Coordinate(8), new Coordinate(4),new Coordinate(-6)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
        
        //tests scalling with a negtive number
        Vector actual2=new Vector(new Point3D(new Coordinate(4), new Coordinate(2),new Coordinate(-3)));
        actual2=actual2.scaling(-2); 
        Vector expected2=new Vector(new Point3D(new Coordinate(-8), new Coordinate(-4),new Coordinate(6)));
        assertEquals(actual2.get_head().get_x().get_coordinate(), expected2.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual2.get_head().get_y().get_coordinate(), expected2.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual2.get_head().get_z().get_coordinate(), expected2.get_head().get_z().get_coordinate(), 1e-10);
        
        //tests scalling with zero (boundary value)
        actual=actual.scaling(0); 
        expected=new Vector(new Point3D(new Coordinate(0), new Coordinate(0),new Coordinate(0)));
        assertEquals(actual.get_head().get_x().get_coordinate(), expected.get_head().get_x().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_y().get_coordinate(), expected.get_head().get_y().get_coordinate(), 1e-10);
        assertEquals(actual.get_head().get_z().get_coordinate(), expected.get_head().get_z().get_coordinate(), 1e-10);
    }
    
    //the function tests the operation of dotProduct between two vectors
    @Test 
    public void testDotProduct()
    {
       //dotProduct between + and +
       Vector v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(4),new Coordinate(2)));
       Vector v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(5),new Coordinate(3)));
       double actual=v1.dotProduct(v2); 
       double expected=28; 
       assertEquals(actual, expected, 1e-10);
       
       //dotProduct between - and -
       v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-4),new Coordinate(-2)));
       v2=new Vector(new Point3D(new Coordinate(-1), new Coordinate(-5),new Coordinate(-3)));
       actual=v1.dotProduct(v2); 
       expected=28; 
       assertEquals(actual, expected, 1e-10);   
       
       //dotProduct between + and -
       v1=new Vector(new Point3D(new Coordinate(2), new Coordinate(4),new Coordinate(2)));
       v2=new Vector(new Point3D(new Coordinate(-1), new Coordinate(-5),new Coordinate(-3)));
       actual=v1.dotProduct(v2); 
       expected=-28; 
       assertEquals(actual, expected, 1e-10);
       
       //dotProduct between - and +
       v1=new Vector(new Point3D(new Coordinate(-2), new Coordinate(-4),new Coordinate(-2)));
       v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(5),new Coordinate(3)));
       actual=v1.dotProduct(v2); 
       expected=-28; 
       assertEquals(actual, expected, 1e-10);  
       
       //boundray case: dotProduct between vector and itself
       v1=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
       v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
       actual=v1.dotProduct(v2); 
       expected=1; 
       assertEquals(actual, expected, 1e-10); 
       
       //boundray case: dotProduct between vector on y axis and x axis 
       v1=new Vector(new Point3D(new Coordinate(0), new Coordinate(1),new Coordinate(0)));
       v2=new Vector(new Point3D(new Coordinate(1), new Coordinate(0),new Coordinate(0)));
       actual=v1.dotProduct(v2); 
       expected=0; 
       assertEquals(actual, expected, 1e-10); 
    }
}


