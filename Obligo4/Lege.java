import java.util.Iterator;
import java.util.ArrayList;

//klassen lege som tar inn parameter for navn og har en funksjon som returnerer navnet
public class Lege implements Comparable<Lege>{

  String legeNavn;

  int resepterMedNarkotiskStyrke = 0;

  Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();
  Iterator resepterIterator = resepter.iterator();

  public Lenkeliste<Resept> hentResepter(){
    return resepter;
  }

  public void leggTilResept(Resept r){
    resepter.leggTil(r);
  }


  public Lege(String navn){
    this.legeNavn = navn;
  }


  public String hentLegeNavn(){
    return legeNavn;
  }

@Override
    public int compareTo(Lege lege){
      String navn = this.legeNavn;
      return navn.compareTo(lege.hentLegeNavn());
    }
}
