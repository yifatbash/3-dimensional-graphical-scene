package Scene;
import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Elements.LightSource;
import Geometries.Geometry;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

//defined the properties of the scene 
public class Scene implements Comparable<Scene>{
    private String _sceneName; 
    private Color _background; 
    private AmbientLight _ambientLight; 
    private ArrayList<Geometry> _geometries; 
    private Camera _camera; 
    private double _screenDistance;   
    private ArrayList<LightSource> _lights; 
    
    // ***************** Constructors ********************** //
    //default ctor
    public Scene() 
    {
        this._sceneName = "";
        this._background = Color.BLACK;
        this._ambientLight = new AmbientLight(); 
        this._geometries=new ArrayList<Geometry>();
        this._camera = new Camera();
        this._screenDistance = 149;
        this._lights= new ArrayList<LightSource>(); 
    }
    //ctor 
    public Scene(String sceneName, Color background, AmbientLight ambientLight, ArrayList<Geometry> geometries, Camera camera, double screenDistance, ArrayList<LightSource> lights)
    {
        this._sceneName = sceneName;
        this._background = background;
        this._ambientLight = ambientLight;
        this._geometries= geometries;
        this._camera = camera;
        this._screenDistance = screenDistance;
        this._lights= lights; 
    }
    //copy ctor
    public Scene(Scene scene)
    {
        this._sceneName = scene._sceneName;
        this._background = scene._background;
        this._ambientLight = scene._ambientLight;
        this._geometries= scene._geometries;
        this._camera = scene._camera;
        this._screenDistance = scene._screenDistance;
        this._lights=  scene._lights; 
    }
 
    // ***************** Getters/Setters ********************** //
    public String getSceneName() { return _sceneName;}
    public void setSceneName(String _sceneName) {this._sceneName = _sceneName;} 
    public Color getBackground() {return _background;}
    public void setBackground(Color _background) {this._background = _background;}
    public AmbientLight getAmbientLight() {return _ambientLight;}
    public void setAmbientLight(AmbientLight _ambientLight) {this._ambientLight = _ambientLight;}
    public ArrayList<Geometry> getGeometries() { return _geometries;} 
    public void setGeometries(ArrayList<Geometry> _geometries) {this._geometries = _geometries;}
    public Camera getCamera() {return _camera;}
    public void setCamera(Camera _camera) {this._camera = _camera;} 
    public double getScreenDistance() {return _screenDistance;}
    public void setScreenDistance(double _screenDistance) { this._screenDistance = _screenDistance;}
    public ArrayList<LightSource> getLights() { return _lights;} 
    public void setLights(ArrayList<LightSource> lights) {this._lights = lights;}
    
    // ***************** Operations ******************** // 
        @Override
    public int compareTo(Scene scene) {
        if(scene._sceneName==_sceneName && scene._ambientLight==_ambientLight && scene._background==_background && scene._camera==_camera && scene._geometries==_geometries && scene._lights==_lights && scene._screenDistance==_screenDistance)
            return 0; 
        else 
            return -1; 
    }
    
    //the function gets the geometry and adds it to the geometries list 
    public void addGeometry(Geometry geometry)
    {
        _geometries.add(geometry);  
    }
    
    //the function returns iterator which go over of the arrayList stored the geometries 
    public Iterator<Geometry> getGeometriesIterator()
    {
        return _geometries.iterator(); 
    }
    
    //the function gets the geometry and adds it to the geometries list 
    public void addLight(LightSource light)
    {
        _lights.add(light);  
    }
    
    //the function returns iterator which go over of the arrayList stored the source lights
    public Iterator<LightSource> getLightsIterator()
    {
        return _lights.iterator();
    }
}
