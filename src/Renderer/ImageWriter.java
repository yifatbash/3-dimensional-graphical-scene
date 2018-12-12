package Renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//the class allows to draw and produce garphic images 
public class ImageWriter {

	private int _imageWidth; //the image width 
	private int _imageHeight; //the image height 
	
        private int _Ny; //number of pixels per column
	private int _Nx; //number of pixels per line
        
	final String PROJECT_PATH = System.getProperty("user.dir"); //the path where the file with the image will be saved 
	
	private BufferedImage _image; //the image (the object is BufferedImage, which is a class already defined in java)
	
	private String _imageName; //the name of the image 
	
	// ***************** Constructors ********************** // 
        
	//ctor which receives all parameters apart from the image and initializes the imageWriter 
	public ImageWriter(String imageName, int width, int height, int Ny, int Nx){
		
		_Nx = Nx;
		_Ny = Ny;
		
		_imageWidth = width;
		_imageHeight = height;
		
		_imageName = imageName;
		
		_image = new BufferedImage(
				_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
        
	//copy ctor: initializes the current imageWriter by another imageWriter 
	public ImageWriter (ImageWriter imageWriter){
		_Nx = imageWriter._Nx;
		_Ny = imageWriter._Ny;
		
		_imageWidth = imageWriter.getWidth();
		_imageHeight = imageWriter.getHeight();
		
		_imageName = imageWriter._imageName;
		
		_image = new BufferedImage(
				_imageWidth, _imageHeight, BufferedImage.TYPE_INT_RGB);;
	}
	
	// ***************** Getters/Setters ********************** //
	
	public int getWidth()  { return _imageWidth;  }
	public int getHeight() { return _imageHeight; }

	public int getNy() { return _Ny; }
	public int getNx() { return _Nx; }

	public void setNy(int _Ny) { this._Ny = _Ny; }
	public void setNx(int _Nx) { this._Nx = _Nx; }
		
	// ***************** Operations ******************** // 
	
        //the function generates the image file (jpg) that was built by the function writePixel
	public void writeToimage(){
		
		File ouFile = new File(PROJECT_PATH + "/" + _imageName + ".jpg");

		try {
			ImageIO.write(_image, "jpg", ouFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
        //there are 3 versions of the function writePixel which paints a particular pixel in a given color 
        //vesion 1: gets pixel and 3 values: r, g, b- to create the RGB value 
	public void writePixel(int xIndex, int yIndex, int r, int g, int b){
		
		int rgb = new Color(r, g, b).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);
		
	}
	
        //version 2: gets pixel and array of 3 values: r, g, b- to create the RGB value
	public void writePixel(int xIndex, int yIndex, int[] rgbArray){
		
		int rgb = new Color(rgbArray[0], rgbArray[1], rgbArray[2]).getRGB();
		_image.setRGB(xIndex, yIndex, rgb);
		
	}
	
        //version 3: gets pixel and a color= value representing the RGB color after mixing 
	public void writePixel(int xIndex, int yIndex, Color color){
		
		_image.setRGB(xIndex, yIndex, color.getRGB());
		
	}
        
        public void printGrid(ImageWriter image, int interval)
        {
            for (int i=0; i<image.getHeight(); i++)
            {
                for(int j=0; j<image.getWidth(); j++)
                {
                    if (i%interval==0 || j%interval==0)
                      image.writePixel(i, j, 255, 255, 255); //paint the pixel with white
                    else 
                        image.writePixel(i, j, 0, 0, 0); //paint the pixel with black 
                }
            }
        }	
}