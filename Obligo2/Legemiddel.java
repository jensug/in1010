//abstrakt superklasse for legemiddel som tar inn navn, pris, og virkestoff som parameter
public abstract class Legemiddel{

  static int antLegemiddel;

  String navn;
  Integer ID;
  Double pris;
  Double virkestoff;

  public Legemiddel(String navn, Double pris, Double virkestoff){

    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;

//id som setter men øker for antall ider som finnes
    ID = antLegemiddel;
    antLegemiddel += 1;

  }

  public String hentNavn(){
    return navn;
}

  public Double hentPris(){
    return pris;
  }

  public Double hentVirkestoff(){
    return virkestoff;
  }

}
