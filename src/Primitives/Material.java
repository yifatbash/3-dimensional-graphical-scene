package Primitives;

public class Material {
    //numbers representing the attenuation factors
    private double _Kd; 
    private double _Ks; 
    private int _nShininess;//An integer representing the degree of brightness of the material
    private double _Kr; //value between 0 to 1. perfect mirror has a Kr of 1, matt surface has a Kr of 0
    private double _Kt;  //value between 0 to 1. Kt=1 when object is translucent, Kt=0 when object is opaque.

    // ***************** Constructors ********************** //
    public Material() {
        this._Kd = 1;
        this._Ks = 1;
        this._nShininess = 1;
        this._Kr=0;
        this._Kt=0;
    }
    public Material(double _Kd, double _Ks, int _nShininess) {
        this._Kd = _Kd;
        this._Ks = _Ks;
        this._nShininess = _nShininess;
        this._Kr=0;
        this._Kt=0;
    }
    public Material(double _Kd, double _Ks, int _nShininess, double _Kr, double _Kt) {
        this._Kd = _Kd;
        this._Ks = _Ks;
        this._nShininess = _nShininess;
        this._Kr=_Kr;
        this._Kt=_Kt;
    }

    // ***************** Getters/Setters ********************** //
    public double getKd() {return _Kd;}
    public double getKs() {return _Ks;}
    public int getnShininess() {return _nShininess;}
    public double getKr() {return _Kr;}
    public double getKt() {return _Kt;}

    public void setKd(double _Kd) {this._Kd = _Kd;}
    public void setKs(double _Ks) {this._Ks = _Ks;}
    public void setnShininess(int _nShininess) {this._nShininess = _nShininess;}
    public void setKr(double _Kr) { this._Kr = _Kr;}
    public void setKt(double _Kt) {this._Kt = _Kt;}
}
