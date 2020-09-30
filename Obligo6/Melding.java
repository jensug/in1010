public class Melding{

  String melding;

  int sekvensnummer;
  int kanalID;
  //registrer

  static int antallMeldinger = 0;


  public Melding(String melding, int kanal, int sekvensnummer){
    this.sekvensnummer = sekvensnummer;
    antallMeldinger++;
    this.melding = melding;
    this.kanalID = kanal;

  }

  public String hentMelding(){
    return melding;
  }

  public int hentKanalID(){
    return kanalID;
  }

  public int hentSekvensnummer(){
    return sekvensnummer;
  }


  public void settMelding(String melding){
  this.melding = melding;
}

}
