import java.util.Iterator;
import java.util.ArrayList;

public class Pasient{

  static int antallPasienter = 0;

  int resepterMedNarkotiskStyrke = 0;

  String navn;
  String fodselsnummer;
  int ID;
  Stabel<Resept> resepter = new Stabel<Resept>();
  Iterator resepterIterator = resepter.iterator();


  public String hentNavn(){
    return navn;
  }

  public Pasient( String navn, String fodselsnummer){
    this.navn = navn;
    this. fodselsnummer = fodselsnummer;
    this.ID = antallPasienter;
    antallPasienter += 1;
  }

  public void leggTilResept(Resept r){
    resepter.leggPaa(r);
  }

  public Integer hentId(){
    return ID;
  }

  public Lenkeliste<Resept> hentResepter(){

    return resepter;
  }





}
