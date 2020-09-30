public class HvitResept extends Resept{

//subklasse av resept som bruker super av resept men som overider farge og pris
  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);

  }

    public String farge(){
      return "Hvit";
    }


       public Double prisAaBetale(){
         return legemiddel.hentPris();
       }


}
