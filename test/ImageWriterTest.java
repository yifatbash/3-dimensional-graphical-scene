import static org.junit.Assert.assertTrue;
import org.junit.Test;
import Renderer.ImageWriter;
import java.awt.Color;


public class ImageWriterTest {
    
    //the function check the function "writeToImage"
    @Test
    public void writeImageTest()
    {
        //test1: create grid
        ImageWriter image=new ImageWriter("grid", 500, 500, 500, 500);
        image.printGrid(image, 50); 
        image.writeToimage(); 
        assertTrue(true);
        
        //test2: create image of arrow  
        image=new ImageWriter("arrow", 500, 500, 500, 500);
        image.printGrid(image, 50);
        for(int i=151; i<300; i++)
        {
            for(int j=101; j<500; j++)
            {
                image.writePixel(j, i, 102, 255, 178);
            }
        }
        
        for(int i=201; i<=250; i++)
        {
            for(int j=0; j<=50; j++)
            {
                image.writePixel(j, i,  102, 255, 178);
            }
        }
        for(int i=151; i<=300; i++)
        {
            for(int j=51; j<=100; j++)
            {
                image.writePixel(j, i,  102, 255, 178);
            }
        }
        for(int i=101; i<=350; i++)
        {
            for(int j=101; j<=150; j++)
            {
                image.writePixel(j, i, 102, 255, 178);
            }
        }
        for(int i=51; i<=400; i++)
        {
            for(int j=151; j<=200; j++)
            {
                image.writePixel(j, i, 102, 255, 178);
            }
        }
        image.writeToimage();
        assertTrue(true);
        
        //test3: create image of smile 
        image=new ImageWriter("smile", 500, 500, 500, 500);
        for(int i=101; i<400; i++)
        {
            for(int j=151; j<400; j++)
            {
                image.writePixel(j, i,Color.yellow);
            }
        }
        for(int i=151; i<200; i++)
        {
            for(int j=201; j<250; j++)
            {
                image.writePixel(j, i,Color.black);
            }
        }
        for(int i=151; i<200; i++)
        {
            for(int j=301; j<350; j++)
            {
                image.writePixel(j, i,Color.black);
            }
        }
        for(int i=251; i<350; i++)
        {
            for(int j=201; j<250; j++)
            {
                image.writePixel(j, i,Color.black);
            }
        }
        for(int i=251; i<350; i++)
        {
            for(int j=301; j<350; j++)
            {
                image.writePixel(j, i,Color.black);
            }
        }
        for(int i=301; i<350; i++)
        {
            for(int j=201; j<350; j++)
            {
                image.writePixel(j, i,Color.black);
            }
        }
        image.writeToimage();
        assertTrue(true);

        
        
    }
        
        
        
    
}



