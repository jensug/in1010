import java.util.ArrayList;

public class Hovedprogram {


public static void main(String[] args) {

//lager lege og fastlege objekter:
  Lege sjefsLege = new Lege("Kari Traad");
  Fastlege kommuneLege = new Fastlege("Ole Johansen", 420);

//lager legemiddel objekter
  LegemiddelB morfin = new LegemiddelB("Morfin", 300.0, 8.8, 10);
  LegemiddelA weed = new LegemiddelA("Weed",420.0 , 4.20, 420);
  LegemiddelC ppiller = new LegemiddelC("P-Piller", 199.90, 2.0);

//lager respter basert på legemiddel og legene
  BlaaResept rehab = new BlaaResept(morfin, sjefsLege, 419, 4);
  MilitResept weedForTraumer = new MilitResept(weed, sjefsLege, 420, 1);
  PResept pillerMotPrevansjon = new PResept(ppiller, kommuneLege, 421);


//så til slutt printer jeg alle de ulike funksjonene:

      System.out.println("____________________________________________________");
      System.out.println("Resept mot rus avhengighet rehab:");
      System.out.println("ReseptId: " + rehab.hentId());
      System.out.println("Utskrivende Lege: " + rehab.hentLege().hentLegeNavn() + "      Type: " + rehab.farge());
      System.out.println("Utskrevet til pasient med id: " + rehab.hentPasientId());
      System.out.println("");
      System.out.println("Legemiddel: " + rehab.hentLegemiddel().hentNavn() +  "      Legemiddel id: "+ rehab.hentLegemiddel().ID);
      System.out.println("Virkestoff: " + rehab.hentLegemiddel().hentVirkestoff() + "     Vanedannende styrke: " + ((LegemiddelB)rehab.hentLegemiddel()).hentVanedannendeStyrke());
      System.out.println("");
      System.out.println("Antall bruk: " + rehab.hentReit() + "     Flere bruk igjen?: " + rehab.bruk());
      System.out.println("Pris : " + rehab.prisAaBetale());
      System.out.println("____________________________________________________");

      System.out.println("");
      System.out.println("");

      System.out.println("____________________________________________________");
      System.out.println("Resept mot traumatiske millitaer opplevelser");
      System.out.println("ReseptId: " + weedForTraumer.hentId());
      System.out.println("Utskrivende Lege: " + weedForTraumer.hentLege().hentLegeNavn() + "      Type: " + weedForTraumer.farge());
      System.out.println("Utskrevet til pasient med id: " + weedForTraumer.hentPasientId());
      System.out.println("");
      System.out.println("Legemiddel: " + weedForTraumer.hentLegemiddel().hentNavn() +  "      Legemiddel id: "+ weedForTraumer.hentLegemiddel().ID);
      System.out.println("Virkestoff: " + weedForTraumer.hentLegemiddel().hentVirkestoff() + "     Narkotisk styrke: " + ((LegemiddelA)weedForTraumer.hentLegemiddel()).hentNarkotiskStyrke());
      System.out.println("");
      System.out.println("Antall bruk: " + weedForTraumer.hentReit() + "     Flere bruk igjen?: " + weedForTraumer.bruk());
      System.out.println("Pris : " + weedForTraumer.prisAaBetale());
      System.out.println("____________________________________________________");

      System.out.println("");
      System.out.println("");

      System.out.println("____________________________________________________");
      System.out.println("Resept mot tidlig prevansjon");
      System.out.println("ReseptId: " + pillerMotPrevansjon.hentId());
      System.out.println("Utskrivende Lege: " + pillerMotPrevansjon.hentLege().hentLegeNavn() + "      Type: " + pillerMotPrevansjon.farge());
      System.out.println("Komunal avtalenummer: " + ((Fastlege)pillerMotPrevansjon.hentLege()).hentAvtalenummer());
      System.out.println("Utskrevet til pasient med id: " + pillerMotPrevansjon.hentPasientId());
      System.out.println("");
      System.out.println("Legemiddel: " + pillerMotPrevansjon.hentLegemiddel().hentNavn() +  "      Legemiddel id: "+ pillerMotPrevansjon.hentLegemiddel().ID);
      System.out.println("Virkestoff: " + pillerMotPrevansjon.hentLegemiddel().hentVirkestoff());
      System.out.println("");
      System.out.println("Antall bruk: " + pillerMotPrevansjon.hentReit() + "     Flere bruk igjen?: " + pillerMotPrevansjon.bruk());
      System.out.println("Pris : " + pillerMotPrevansjon.prisAaBetale());
      System.out.println("____________________________________________________");






}


}
