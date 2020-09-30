public class PResept extends HvitResept{

//subklasse av hvit resept som setter reit som 3 og forandrer pris metoden
  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {

    super(legemiddel, utskrivendeLege, pasientId, 3);
}

@Override
    public Double prisAaBetale(){
      Double pris = legemiddel.hentPris();
      pris -= 116;
      if (pris < 0){
        pris = 0.0;
      }
      return pris;
    }

}
