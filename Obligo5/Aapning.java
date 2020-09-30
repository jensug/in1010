public class Aapning extends HvitRute{

  public Aapning(int rad, int kol){
    super(rad,kol);
    erAapning = true;
  }

@Override
  public void gaa(Rute forgje, String meldingen){

    String melding = meldingen + " (" + kolonne + ", " + rad + ")";

    labyrinten.utveier.leggTil(melding);
//System.out.println("Fant utvei på (" + rad + ", " + kolonne + ").");
  }
}
