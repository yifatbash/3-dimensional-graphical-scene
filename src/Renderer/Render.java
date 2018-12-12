package Renderer;

import Elements.*;
import Geometries.FlatGeometry;
import Geometries.Geometry;
import Primitives.*;
import Scene.Scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

//Render class 
public class Render implements Comparable<Render>{
    
    private Scene _scene;  
    private ImageWriter _imageWriter;

    // ***************** Constructors ********************** // 
    //ctor: gets parameters and initialize the current render 
    public Render(Scene scene, ImageWriter imageWriter)
    {
        this._scene = scene;
        this._imageWriter = imageWriter;
    }
    //copy ctor: gets a render and initialize the current render with another render 
    public Render(Render render) 
    {
        this._scene = render._scene;
        this._imageWriter = render._imageWriter;
    }
    
    // ***************** Getters/Setters ********************** //
    
    public Scene getScene() {return _scene;}
    public ImageWriter getImageWriter() {return _imageWriter;}
    
    public void setScene(Scene _scene) {this._scene = _scene;}
    public void setImageWriter(ImageWriter _imageWriter) {this._imageWriter = _imageWriter;}
    
    // ***************** Operations ******************** // 

    //the function compare between 2 renders 
    @Override
    public int compareTo(Render render)
    {
        if (render==null)
            return -1; 
        if (this._scene==render._scene && this._imageWriter==render._imageWriter)
            return 0; 
        return -1; 
    }
    	@Override
	public String toString() {
		return "Render [_scene=" + _scene + ", _imageWriter=" + _imageWriter + "]";
	}
    
    //the function enable to add grid in the image background
    public void printGrid(int interval)
    {
        for (int i=0; i<_imageWriter.getHeight(); i++)
        {
            for(int j=0; j<_imageWriter.getWidth(); j++)
            {
                if (i%interval==0 || j%interval==0|| j==449 ||i==499)
                    _imageWriter.writePixel(i, j, 255, 255, 255);//paint the pixel with write
                //else 
                    //_imageWriter.writePixel(i, j, 0, 0, 0);//paint the pixel with black
            }
        }
    }
    
    //the function create the image of the scene 
    public void renderImageMiniProject()
    {       
        //go over all the pixels in the view plane
        for (int i=0; i<_imageWriter.getHeight(); i++) 
        {
            for(int j=0; j<_imageWriter.getWidth(); j++)
            {
                //foreach pixel do the following:
                //defined arrayList which will store all the colors we get form each ray 
                ArrayList<Color> colors=new ArrayList<Color>();
                //construct 5 rays through the pixel and checks intersection points with any geometry
                ArrayList<Ray> rays= _scene.getCamera().Construct3RaysThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.getScreenDistance(), _imageWriter.getWidth(),_imageWriter.getHeight());
		//foreach ray: 		
                for(Ray ray:rays)
		{
                    //create arrayList of all intersection points between the ray and all the scene geometries 
                    Map<Geometry,ArrayList<Point3D>> intersectionPoints= getSceneRayIntersections(ray);
                    //if there is no intersection points add the color of the scene background to the color array
                    if(intersectionPoints.isEmpty())
			colors.add(_scene.getBackground());
                    //if there is intersection points so add the color of the closest point to the color array
		    else
                    {
                        Map<Geometry,Point3D> closestPoint= getClosestPoint(intersectionPoints);
			for(Entry<Geometry,Point3D> entry: closestPoint.entrySet())
			colors.add(calcColor(entry.getKey(),entry.getValue(),ray));
                    }
		}
            //paint each pixel with the averge color 
            _imageWriter.writePixel(j, i, calcAverageColor(colors));      
            }
        }
    }
    //the function gets the arrayList of colors and calculate the average of them
    Color calcAverageColor(ArrayList<Color> colors)
    {
        int r=0; 
        int g=0; 
        int b=0; 
        //defines the iterator would go over all the colors 
        Iterator<Color> colorIterator=colors.iterator(); 
        //go over all the colors and sum them 
        while(colorIterator.hasNext())
        {
            Color myColor=colorIterator.next(); //takes the next color in the arrayList
            r+=(int)myColor.getRed(); 
            g+=(int)myColor.getGreen(); 
            b+=(int)myColor.getBlue(); 
        }
        //divide the sum by the number of colors to get teh average 
        r=r/colors.size(); 
        g=g/colors.size(); 
        b=b/colors.size(); 
        
        //return the average color 
        return new Color(r,g,b);            
    }   
            
    //the function create the image of the scene 
    public void renderImage()
    {       
        //go over all the pixels in the view plane
        for (int i=0; i<_imageWriter.getHeight(); i++) 
        {
            for(int j=0; j<_imageWriter.getWidth(); j++)
            {
                //foreach pixel do the following:
                //construct ray through the pixel and checks intersection points with any geometry
                Ray ray=_scene.getCamera().ConstructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), j, i, _scene.getScreenDistance(), _imageWriter.getWidth(),_imageWriter.getHeight());
                //create arrayList of all intersection points between the ray and all the scene geometries 
                Map<Geometry, ArrayList<Point3D>> intersectionPoints=getSceneRayIntersections(ray);
                //if there is no intersection points so paint the pixel with scene background color
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(j, i, _scene.getBackground());
                //if there is intersection points so paint the pixel with the closest point color 
                else 
                {
                    Map<Geometry, Point3D> closestPoint=getClosestPoint(intersectionPoints);
                    for(Entry<Geometry,Point3D> entry: closestPoint.entrySet())
                        _imageWriter.writePixel(j, i, calcColor(entry.getKey(),entry.getValue(),ray));
                }
            }
        }		
    }
    
    //the function gets ray and go over all geometries to find intersection points between ray and geometries 
    private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray)
    {
        //create iterator to go over all geometries
        Iterator<Geometry> geometries=_scene.getGeometriesIterator();
        //create map which will save all intersection points between ray and geometries 
        Map<Geometry, ArrayList<Point3D>> intersectionPoints=new HashMap<Geometry,ArrayList<Point3D>>(); 
        
        //while we don't arrive to the end of the list so continue to checks the next geometry
        while(geometries.hasNext())
        {
            //move to the next geometry
           Geometry geometry=geometries.next();
           //create a list of intersection points betweeen the geometry and the ray 
           ArrayList<Point3D> geometryIntersectionPoints=geometry.findIntersections(ray);
           
           if (geometryIntersectionPoints!=null && geometryIntersectionPoints.size()>0 )
               //add the intersection points of the particular geometry into map connects between each geomtry and its intersection points 
                intersectionPoints.put(geometry,geometryIntersectionPoints); 
        }  
        
        return intersectionPoints;// return the map of all intersection points with the given ray 
    }
    
    //the function gets map of intersection points between ray and each geometry and returns the closest point to the center of projection (camera)
    private Map<Geometry,Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints)
    {
        double distance= Double.MAX_VALUE; //initialize distance with high value
        Point3D P0=_scene.getCamera().get_P0(); //P0: center of projection
        Map<Geometry,Point3D> minDistancePoint=new HashMap<Geometry, Point3D>(); 
        
        //go over all the gerometries 
        for(Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
        {
            //for each geometry, go over all the intersectiosn points 
            for(Point3D point: entry.getValue())
            {
                //compare between 2 points: if the distance between the point and P0 is shorter than the current distance 
                if(P0.distance(point)<distance)
                {
                    minDistancePoint.clear();// if P0 is close than the last minDistancePoint- remove the last point from the map  
                    minDistancePoint.put(entry.getKey(), new Point3D(point));// initialize min distance point with P0
                    distance=P0.distance(point); // initialize the distance with the new minimal distance 
                }
            } 
        }
        
        return minDistancePoint; //returns the closest point 
    }
    
    //the function gets 2 colors and returns the color which correspond to the addition of them 
    private Color addColor(Color c1, Color c2)
    {
        int r= c1.getRed()+ c2.getRed(); 
        int g= c1.getGreen()+ c2.getGreen(); 
        int b= c1.getBlue() + c2.getBlue(); 
        
        //checks that the rgb values are not out of rang
        if(r>255)
           r=255;
        if(g>255)
           g=255;
        if(b>255)
           b=255;   
        
        return new Color (r,g,b);
    }
   
    //Shell function which calls the original calcColor function, with level=0
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay)
    {
        return calcColor(geometry, point, inRay, 0);
    }
    
    //the function gets a point and returns a color of the point.
    //the function gets 4 parameters:
    //geometry: the geometry which point is on it 
    //point: the point which the function calcColor calculates the color for it 
    //inRay: the ray which reach the point 
    //level: the current recursion level 
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level)
    {
        if (level==3)//RECUSRSION_LEVEL==3
            return new Color(0,0,0); 
        
        //defines all the scene's source lights
        Color ambientLight=_scene.getAmbientLight().getIntensity(point); 
        Color emissionLight=geometry.getEmmission(); 
        Color diffuseLight= new Color(0,0,0);
        Color specularLight= new Color(0,0,0); 
        
        //defines the iterator would go over all the lights in the scene 
        Iterator<LightSource> lights=_scene.getLightsIterator(); 
        //go over all the lights 
        while(lights.hasNext())
        {
            
            LightSource light=lights.next(); //takes the next light in the arrayList 
            if (!occluded(light, point,geometry))
            {
            //sum all the diffuse light created from the source lights
            diffuseLight= addColor(diffuseLight,CalcDiffuseComp(geometry.getMaterial().getKd(),
                                                geometry.getNormal(point), 
                                                light.getL(point), 
                                                light.getIntensity(point)));
            //sum all the specular light created from the source lights
            specularLight= addColor(specularLight, CalcSpecularComp(geometry.getMaterial().getKs(),
                                                new Vector(_scene.getCamera().get_P0().substract(point)), 
                                                geometry.getNormal(point), 
                                                light.getL(point), 
                                                geometry.getMaterial().getnShininess(), 
                                                light.getIntensity(point)));  
            }
        }
        
        //Recursive call for reflected ray
        Ray reflectedRay= constractReflectedRay(geometry.getNormal(point), point, inRay);
        Entry<Geometry,Point3D> reflectedEntry= findClosestIntersection(reflectedRay,geometry);
        Color reflectedColor=new Color(0,0,0); 
        if(reflectedEntry!=null) //if there is a intersection point with reflectedRay
            reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay,level+1);
        double _Kr=geometry.getMaterial().getKr();  
        int r=(int)_Kr*reflectedColor.getRed(); 
        int g=(int)_Kr*reflectedColor.getGreen(); 
        int b=(int)_Kr*reflectedColor.getBlue(); 
        
        Color reflectedLight=new Color(r,g,b); 
        
        //Recursive call for a refracted ray 
        Ray refractedRay=constractRefractedRay(geometry.getNormal(point), point, inRay); 
        Entry<Geometry,Point3D> refractedEntry=findClosestIntersection(refractedRay,geometry); 
        Color refractedColor=new Color(0,0,0); 
        if(refractedEntry!=null) //if there is a intersection point with refractedRay
            refractedColor = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay ,level+1);
        double _Kt=geometry.getMaterial().getKt(); 
        r=(int)_Kt*refractedColor.getRed(); 
        g=(int)_Kt*refractedColor.getGreen(); 
        b=(int)_Kt*refractedColor.getBlue(); 
        
        Color refracedLight=new Color(r,g,b);
        
        //phonf formula: ambientLight+emmissionLight+diffuseLight+specularLight+reflectedLight+refractedLight 
        Color I= new Color(0,0,0); 
        I=addColor(I,ambientLight); 
        I=addColor(I,emissionLight);
        I=addColor(I,diffuseLight);
        I=addColor(I,specularLight);
        I=addColor(I, reflectedLight); 
        I=addColor(I, refracedLight); 
        
        return I; 
    } 
    
    //the function calculates the diffuse light:
    //material: the material of geometry 
    //N: the normal in the geometry's point
    //L: the direction of the vector form the source light to the point
    //I: the intensity (color) of the light  
    private Color CalcDiffuseComp(double Kd, Vector N, Vector L, Color I)
    {
        N=N.normalize(); 
        L=L.normalize();       
        //diffuseLight= Kd*(N*L)*I
        //absolutes values in order to calculate the scale factor without meaning of direction 
        double r= Kd*Math.abs((N.dotProduct(L))*I.getRed());
        double g= Kd*Math.abs((N.dotProduct(L))*I.getGreen());
        double b= Kd*Math.abs((N.dotProduct(L))*I.getBlue());
        
        //checks that the rgb values are not out of rang
        if(r>255)
            r=255;
        if(g>255)
            g=255;
        if(b>255)
            b=255;
        
        return new Color ((int)r,(int)g,(int)b);
    }
    //the function calculates the specular light:
    //material: the material of geometry 
    //V: the direction of the vector from the geometry's point to the viewer
    //L: the direction of the vector form the source light to the point
    //R: the dircetion of the light reflected from geometry
    //shininess: the degree of the geometry's brillance 
    //I: the intensity (color) of the light  
    private Color CalcSpecularComp(double Ks, Vector V, Vector N, Vector L, double shininess, Color I)
    {
        V=V.normalize(); 
        N=N.normalize();
        L=L.normalize();
        
        //R=L-2(L*N)*N
        Vector R= L.substract((N.scaling(L.dotProduct(N))).scaling(2));
        
        double r,g,b; 
        if (V.dotProduct(R)>0) //if the specularLight vector is in the same direction of the camera so calculate the specular light 
        {
            //specularLight=Ks*(V*R)^n*I
            r= Ks*Math.pow(V.dotProduct(R),shininess)*I.getRed();
            g= Ks*Math.pow(V.dotProduct(R),shininess)*I.getGreen();
            b= Ks*Math.pow(V.dotProduct(R),shininess)*I.getBlue();
        }
        else //there is no specular light in this point 
        {
           r=0; 
           g=0; 
           b=0; 
        }
        
        //checks that the rgb values are not out of rang
        if(r>255)
            r=255;
        if(g>255)
            g=255;
        if(b>255)
            b=255;
        
        return new Color ((int)r,(int)g,(int)b);
    }
    
    //the function checks if a given point of geometry is occluded by another geometry 
    private boolean occluded(LightSource light, Point3D point, Geometry geometry) 
    {
        Vector lightDirection=light.getL(point).normalize(); //the direction of the vector from the source light to the point 
        lightDirection= lightDirection.scaling(-1); //reverse the direction of this vector- from the point to the source light 
        
        Point3D geometryPoint=new Point3D(point); //defines a point with the given point values 
        
        //in order to solve the floating point problem 
        Vector epsVector=new Vector(geometry.getNormal(point)); //defind the normal of the geometry in the given point 
        epsVector= epsVector.scaling(2); //in order to distance the normal a little from the geometry 
        geometryPoint= geometryPoint.add(epsVector); //add this vector to the point: distance the point from the geometry 
        
        Ray lightRay=new Ray(geometryPoint, lightDirection); //create ray from the point to the source light 
        
        Map<Geometry, ArrayList<Point3D>> intersectionPoints= getSceneRayIntersections(lightRay); //checks if there is geometry between the source light and the geometry 
        
        //Flat geometry cannot self intersect 
        if (geometry instanceof FlatGeometry)
        {
            intersectionPoints.remove(geometry);
        }
        
        //go over the intersectionPoints list and checks if the geometry is opaque(when Kt=0) 
        for(Entry<Geometry,ArrayList<Point3D>> entry: intersectionPoints.entrySet())
        {
            if (entry.getKey().getMaterial().getKt()==0 && entry.getKey().getMaterial().getKr()==0 )//if geometry is opaque the point of given geometry is occluded
                return true; 
        }
        //if geometry is not opaque the point of given geometry is not occluded 
        return false; 
        
        //return !intersectionPoints.isEmpty(); // if there is no intersection points so there is no geometry between the source light and geometry
                                              // so the point is not occluded
    }
    
    //the function construct reflected ray 
    private Ray constractReflectedRay(Vector normal, Point3D point, Ray inRay)
    {
        Vector N= normal.normalize();
        Vector D = inRay.get_direction().normalize();
        
        //formula: R=D-2(D*N)*N
        Vector R= D.substract((N.scaling(D.dotProduct(N))).scaling(2));
        
        normal=normal.scaling(-2);	
        point=point.add(normal);
        
        Ray reflectedRay = new Ray(point, R);
        return reflectedRay;         
    }
    
    //the function construct refracted ray in direction of inRay 
    private Ray constractRefractedRay(Vector normal, Point3D point, Ray inRay)
    {
        Vector direction = inRay.get_direction();
        
        normal=normal.scaling(-2);	
        point=point.add(normal);
        
        Ray refractedRay = new Ray(point, direction);
        return refractedRay;	
    }
    
    //the function gets reflectedRay and find the closest intersesction point with the ray 
    private Entry<Geometry,Point3D> findClosestIntersection(Ray inRay, Geometry geometry)
    {
        Map<Geometry, ArrayList<Point3D>> intersectionPoints= getSceneRayIntersections(inRay);//find all intersections with all geometries 
        
        if (geometry instanceof FlatGeometry)
        {
            intersectionPoints.remove(geometry);
        }
        
        Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);// find the closest point 

        Entry<Geometry,Point3D> entry = null;	
	for(Entry<Geometry,Point3D> e: closestPoint.entrySet())
	    entry= e;
		
        return entry; //return the closest point and it's geometry
    }

    public void writeToimage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
