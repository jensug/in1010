
//fastlege som implementerer komuneavtale
public class Fastlege extends Lege implements Kommuneavtale{

  Integer avtalenummer;

//tar bare super av fastlege men tar også inn avtalenummer som parameter
  public Fastlege( String navn, Integer avtalenummer){
    super(navn);
    this.avtalenummer = avtalenummer;

  }

//overider avtalenummer
  public int hentAvtalenummer(){
    return avtalenummer;
  }

}
