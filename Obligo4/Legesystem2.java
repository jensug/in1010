import java.util.Iterator;

public class Legesystem{


  public static void main(String[] args) {

/*
  Lenkeliste<Pasient> pasienter =  new Lenkeliste<Pasient>();


  Pasient jens = new Pasient("Jens", "130898");
  Pasient ole = new Pasient("Ole", "140898");
  Pasient tore = new Pasient("Tore", "150898");

  pasienter.leggTil(jens);
  pasienter.leggTil(ole);
  pasienter.leggTil(tore);

  Iterator<Pasient> pasienterIterator = pasienter.iterator();

  for (Pasient pasient : pasienter){
    System.out.println(pasient.hentNavn());
  }
*/


  Lenkeliste<String> liste = new Lenkeliste<String>();

  liste.leggTil("1");
  liste.leggTil("2");
  liste.leggTil("3");
  liste.leggTil("4");

  Iterator<String> listeIterator = liste.iterator();




  for (String tall : liste){
    System.out.println(tall);
  }


  }

}
