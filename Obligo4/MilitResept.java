public class MilitResept extends HvitResept{

//subklasse av hvit resept som forandrer pris metoden
  public MilitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);

}

    @Override
    public Double prisAaBetale(){
      return 0.0;
    }

    @Override
    public String farge(){
      return "Milit";
    }

}
