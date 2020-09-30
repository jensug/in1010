public class HvitRute extends Rute{


  int farge = 0;


  public HvitRute(int rad, int kol){
    super(rad,kol);
  }

  @Override
    public char tilTegn(){
      return '.';
    }



    @Override
    public void gaa(Rute forrige, String meldingen){

      String melding = meldingen + " (" + kolonne + ", " + rad + ") -->";

      //System.out.println("Fant en HvitRute (" + rad + ", " + kolonne + ").");

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


}
