import java.util.ArrayList;

 abstract class Rute {

  Labyrint labyrinten;

  int farge;

  int kolonne;
  int rad;


  boolean erAapning = false;

  Rute nord = null;
  Rute syd = null;
  Rute vest = null;
  Rute ost = null;


  public Rute(int rad, int kol){
    this.kolonne = kol;
    this.rad = rad;
  }

  public void settLabyrint(Labyrint labben){
    this.labyrinten = labben;
  }

  public boolean erAapning(){
    return erAapning;
  }


  abstract char tilTegn();




  public void gaa(Rute forrige, String meldingen){

      String melding = meldingen + "--> (" + kolonne + ", " + rad + ")";

                if(nord.equals(forrige) == false){
                    nord.gaa(this, melding);
                }
                if(syd.equals(forrige) == false){
                    syd.gaa(this, melding);
                }
                if(vest.equals(forrige) == false){
                    vest.gaa(this, melding);
                }
                if(ost.equals(forrige) == false){
                    ost.gaa(this, melding);
                }


      }

  public void finnUtvei(int kol, int rad){
    this.gaa(this, "");

  }





}
