public class SortRute extends Rute{


  int farge = 1;


  public SortRute(int rad, int kol){
    super(rad,kol);
  }

@Override
  public void gaa(Rute forgje, String meldingen){
    //ikke gå videre
  }

  @Override
    public char tilTegn(){
      return '#';
    }
}
