import Primitives.Coordinate;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest 
{
    //the function tests adding between two coordinates 
    @Test
    public void testAdd()
    {
       //adding between + and +
       Coordinate c1=new Coordinate(2.6); 
       Coordinate c2=new Coordinate(2); 
       Coordinate actual =c1.add(c2); 
       Coordinate expected=new Coordinate(4.6);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //adding between - and -
       c1=new Coordinate(-2.6); 
       c2=new Coordinate(-2); 
       actual =c1.add(c2); 
       expected=new Coordinate(-4.6);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //adding between + and -
       c1=new Coordinate(2.6); 
       c2=new Coordinate(-2); 
       actual =c1.add(c2); 
       expected=new Coordinate(0.6);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //adding between - and +
       c1=new Coordinate(-2.6); 
       c2=new Coordinate(2); 
       actual =c1.add(c2); 
       expected=new Coordinate(-0.6);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
    }
    
    //the function tests substracting between two coordinates 
    @Test
    public void testSubstract()
    {
       //substracting between + and +
       Coordinate c1=new Coordinate(7); 
       Coordinate c2=new Coordinate(3.5); 
       Coordinate actual =c1.substract(c2); 
       Coordinate expected=new Coordinate(3.5);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //substracting between - and -
       c1=new Coordinate(-7); 
       c2=new Coordinate(-3.5); 
       actual =c1.substract(c2); 
       expected=new Coordinate(-3.5);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //substracting between + and -
       c1=new Coordinate(7); 
       c2=new Coordinate(-3.5); 
       actual =c1.substract(c2); 
       expected=new Coordinate(10.5);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
       
       //substracting between - and +
       c1=new Coordinate(-7); 
       c2=new Coordinate(3.5); 
       actual =c1.substract(c2); 
       expected=new Coordinate(-10.5);
       assertEquals(actual.get_coordinate(),expected.get_coordinate(),1e-10);
    }
}
