

public class LegemiddelA extends Legemiddel{

  Integer narkotisk;

//super av legemiddel klasse men tar også inn virkestoff som kan returneres
  public LegemiddelA(String navn, Double pris, Double virkestoff, Integer styrke){

    super(navn, pris, virkestoff);
    this.narkotisk = styrke;


  }

  public Integer hentNarkotiskStyrke(){
    return narkotisk;
  }



}
