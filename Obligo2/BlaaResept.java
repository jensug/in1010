public class BlaaResept extends Resept{

//konstruktør for blå resept, bruker bare super men forandrer pris og farge.
  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);


}


    public Double prisAaBetale(){
      Double pris = legemiddel.hentPris();
      Double rabatt = pris * 75 / 100;
      pris -= rabatt;
      return pris;
}

      @Override
      public String farge(){
        return "Blaa";
      }


}
