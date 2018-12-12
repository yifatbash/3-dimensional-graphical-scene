package Elements;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray; 
import java.util.ArrayList;

// defines camera by Point3D (0,0,0) and 3 vectors: vUp(0,1,0), vTo(0,0,-1), vRight(1,0,0)
public class Camera {
    private Point3D _P0; //(0,0,0)
    private Vector _vUp; //(0,1,0)
    private Vector _vTo; //(0,0,-1)
    private Vector _vRight; //(1,0,0)
    
    // ***************** Constructors ********************** //
    //default ctor
     public Camera ()
    {
        _P0= new Point3D(); //(0,0,0)
        _vUp=new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0))); //(0,1,0)
        _vTo=new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1))); //(0,0,-1)
        _vRight=new Vector(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0))); //(1,0,0)
    } 
    //ctor gets Point3D and 3 vectors and initilaizes the camera 
    public Camera (Point3D P0, Vector vUp, Vector vTo, Vector vRight)
    {
        _P0=P0; 
        _vUp=vUp; 
        _vTo=vTo; 
        _vRight=vRight; 
    }
    
    // ***************** Getters/Setters ********************** //
    public Point3D get_P0(){return _P0; }
    public Vector get_vUp(){return _vUp; }
    public Vector get_vTo(){return _vTo; }
    public Vector get_vRight(){return _vRight; }

    public void set_P0(Point3D P0){_P0=P0; }
    public void set_vUp(Vector vUp){_vUp=vUp;}
    public void set_vTo(Vector vTo){_vTo=vTo;}
    public void set_vRight(Vector vRight){_vRight=vRight;}
    
    /*the function gets a specific pixel in the view plane and construct ray through the pixel, using all the parameters it gets:
    Nx: number of pixel in the view plane width
    Ny: number of pixel in the view plane height
    x:  the position of the point which we want to arrive in the view plane width
    y:  the position of the point which we want to arrive in the view plane height 
    screenDistance: the distance between the camera (0,0,0) and the view plane 
    screenWidth: the length of the view plane width
    screenHeight: the length of the view plane height 
    */
    public ArrayList<Ray> Construct9RaysThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Pc is the image center point 
        Point3D Pc= new Point3D();
        // Pc= P0+dVto: we go from the center of projection P0 in direction of vTo d steps 
        Pc=_P0.add(_vTo.scaling(screenDistance));
        // Vright is vertical to both vTo and vUp
        Vector Vright=new Vector(); 
        Vright=_vTo.crossProduct(_vUp);
        // calculating of the ratio of each pixel in the image 
        double Rx=screenWidth/Nx; // catlculate the width ratio
        double Ry=screenHeight/Ny; // calculate the height ratio
        
        //calculate the direction of the ray according to the formule which we learned in the coursec 
        Point3D P=new Point3D(); 
        Vector direction= new Vector();
        
        //construct the first ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + (double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry + (double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        Vector vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        Ray ray=new Ray(_P0,vectorRay);
		
        //Jagged edges -> super sampling
	//creating more rays
	ArrayList<Ray> list=new ArrayList<Ray>();
	list.add(ray);
                
        //construct the second ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx]*vRight-[(y-Ny/2)*Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the third ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry + Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the fourth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+Rx ).substract(_vUp.scaling((y-(double)Ny/2)*Ry +Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the fifth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx]*vRight-[(y-Ny/2)*Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the sixth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/4]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/4).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the seventh ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the fourth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx*3/4]*vRight-[(y-Ny/2)*Ry+Ry/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx*3/4 ).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the fourth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/2+Ry*3/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry*3/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
    
	return list;
    }
    
    /*the function gets a specific pixel in the view plane and construct ray through the pixel, using all the parameters it gets:
    Nx: number of pixel in the view plane width
    Ny: number of pixel in the view plane height
    x:  the position of the point which we want to arrive in the view plane width
    y:  the position of the point which we want to arrive in the view plane height 
    screenDistance: the distance between the camera (0,0,0) and the view plane 
    screenWidth: the length of the view plane width
    screenHeight: the length of the view plane height 
    */
    public ArrayList<Ray> Construct5bRaysThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Pc is the image center point 
        Point3D Pc= new Point3D();
        // Pc= P0+dVto: we go from the center of projection P0 in direction of vTo d steps 
        Pc=_P0.add(_vTo.scaling(screenDistance));
        // Vright is vertical to both vTo and vUp
        Vector Vright=new Vector(); 
        Vright=_vTo.crossProduct(_vUp);
        // calculating of the ratio of each pixel in the image 
        double Rx=screenWidth/Nx; // catlculate the width ratio
        double Ry=screenHeight/Ny; // calculate the height ratio
        
        //calculate the direction of the ray according to the formule which we learned in the coursec 
        Point3D P=new Point3D(); 
        Vector direction= new Vector();
        
        //construct the first ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + (double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry + (double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        Vector vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        Ray ray=new Ray(_P0,vectorRay);
		
        //Jagged edges -> super sampling
	//creating more rays
	ArrayList<Ray> list=new ArrayList<Ray>();
	list.add(ray);
                
        
        //construct the second ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/4]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/4).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the third ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the fourth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx*3/4]*vRight-[(y-Ny/2)*Ry+Ry/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx*3/4).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
        
        //construct the fifth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry*3/4]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+(double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry +(double)Ry*3/4));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
    
	return list;
    }
    
    /*the function gets a specific pixel in the view plane and construct ray through the pixel, using all the parameters it gets:
    Nx: number of pixel in the view plane width
    Ny: number of pixel in the view plane height
    x:  the position of the point which we want to arrive in the view plane width
    y:  the position of the point which we want to arrive in the view plane height 
    screenDistance: the distance between the camera (0,0,0) and the view plane 
    screenWidth: the length of the view plane width
    screenHeight: the length of the view plane height 
    */
    public ArrayList<Ray> Construct5RaysThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Pc is the image center point 
        Point3D Pc= new Point3D();
        // Pc= P0+dVto: we go from the center of projection P0 in direction of vTo d steps 
        Pc=_P0.add(_vTo.scaling(screenDistance));
        // Vright is vertical to both vTo and vUp
        Vector Vright=new Vector(); 
        Vright=_vTo.crossProduct(_vUp);
        // calculating of the ratio of each pixel in the image 
        double Rx=screenWidth/Nx; // catlculate the width ratio
        double Ry=screenHeight/Ny; // calculate the height ratio
        
        //calculate the direction of the ray according to the formule which we learned in the coursec 
        Point3D P=new Point3D(); 
        Vector direction= new Vector();
        
        //construct the first ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + (double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry + (double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        Vector vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        Ray ray=new Ray(_P0,vectorRay);
		
        //Jagged edges -> super sampling
	//creating more rays
	ArrayList<Ray> list=new ArrayList<Ray>();
	list.add(ray);
                
        //construct the second ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the third ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry + Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the fourth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx+Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry +Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the fifth ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx]*vRight-[(y-Ny/2)*Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
    
	return list;
    }
    
    /*the function gets a specific pixel in the view plane and construct ray through the pixel, using all the parameters it gets:
    Nx: number of pixel in the view plane width
    Ny: number of pixel in the view plane height
    x:  the position of the point which we want to arrive in the view plane width
    y:  the position of the point which we want to arrive in the view plane height 
    screenDistance: the distance between the camera (0,0,0) and the view plane 
    screenWidth: the length of the view plane width
    screenHeight: the length of the view plane height 
    */
    public ArrayList<Ray> Construct3RaysThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Pc is the image center point 
        Point3D Pc= new Point3D();
        // Pc= P0+dVto: we go from the center of projection P0 in direction of vTo d steps 
        Pc=_P0.add(_vTo.scaling(screenDistance));
        // Vright is vertical to both vTo and vUp
        Vector Vright=new Vector(); 
        Vright=_vTo.crossProduct(_vUp);
        // calculating of the ratio of each pixel in the image 
        double Rx=screenWidth/Nx; // catlculate the width ratio
        double Ry=screenHeight/Ny; // calculate the height ratio
        
        //calculate the direction of the ray according to the formule which we learned in the coursec 
        Point3D P=new Point3D(); 
        Vector direction= new Vector();
        
        //construct the first ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx/2]*vRight-[(y-Ny/2)*Ry+Ry/2]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + (double)Rx/2).substract(_vUp.scaling((y-(double)Ny/2)*Ry + (double)Ry/2));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        Vector vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        Ray ray=new Ray(_P0,vectorRay);
		
        //Jagged edges -> super sampling
	//creating more rays
	ArrayList<Ray> list=new ArrayList<Ray>();
	list.add(ray);
                
        //construct the second ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx+Rx]*vRight-[(y-Ny/2)*Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx + Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                
        //construct the third ray through the given pixel, and add it to the rays list
        //direction= [(x-Nx/2)*Rx]*vRight-[(y-Ny/2)*Ry+Ry]*VUp
        direction=_vRight.scaling((x-(double)Nx/2)*Rx).substract(_vUp.scaling((y-(double)Ny/2)*Ry + Ry));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        ray=new Ray(_P0,vectorRay);        
        list.add(ray);
                   
	return list;
    }
    
    /*the function gets a specific pixel in the view plane and construct ray through the pixel, using all the parameters it gets:
    Nx: number of pixel in the view plane width
    Ny: number of pixel in the view plane height
    x:  the position of the point which we want to arrive in the view plane width
    y:  the position of the point which we want to arrive in the view plane height 
    screenDistance: the distance between the camera (0,0,0) and the view plane 
    screenWidth: the length of the view plane width
    screenHeight: the length of the view plane height 
    */
    public Ray ConstructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDistance, double screenWidth, double screenHeight)
    {
        // Pc is the image center point 
        Point3D Pc= new Point3D();
        // Pc= P0+dVto: we go from the center of projection P0 in direction of vTo d steps 
        Pc=_P0.add(_vTo.scaling(screenDistance));
        // Vright is vertical to both vTo and vUp
        Vector Vright=new Vector(); 
        Vright=_vTo.crossProduct(_vUp);
        // calculating of the ratio of each pixel in the image 
        double Rx=screenWidth/Nx; // catlculate the width ratio
        double Ry=screenHeight/Ny; // calculate the height ratio
        
        //calculate the direction of the ray according to the formule which we learned in the coursec 
        Point3D P=new Point3D(); 
        // calculate how many steps we have to do in direction of vRight in order to arrive to the given pixel 
        double rScale= (x-(double)Nx/2)*Rx + (double)Rx/2;
        // calculate how many steps we have to do in direction of vUp in order to arrive to the given pixel
        double uScale= (y-(double)Ny/2)*Ry + (double)Ry/2;
        // direction= rScale*vRight-uScale*VUp: direction we should go from Pc (the image center point) in order to arrive to the given pixel  
        Vector direction= new Vector(); 
        direction=_vRight.scaling(rScale).substract(_vUp.scaling(uScale));
        // P= Pc+direction: P is the position of the given pixel 
        P=Pc.add(direction);
        // construct ray to through P
        Vector vectorRay = P.substract(_P0);    
        vectorRay = vectorRay.normalize();// normalize the ray 
        Ray r=new Ray(_P0,vectorRay);
        
      
        return r; 
    }
  }