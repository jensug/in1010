//bruker superklassen men tar også inn vandannedne styrke, som kan returneres

public class LegemiddelB extends Legemiddel{

  Integer vanedannende;


    public LegemiddelB(String navn, Double pris, Double virkestoff, Integer styrke){
      super(navn, pris, virkestoff);
      this.vanedannende = styrke;
    }

    public Integer hentVanedannendeStyrke(){
      return vanedannende;
    }
}
