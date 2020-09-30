import java.util.ArrayList;


public class TestLegemiddel{

  public static void main(String[] args) {


//test av legemiddel
    LegemiddelA middel1 = new LegemiddelA("middel1", 100.0, 5.0, 10);
    LegemiddelB middel2 = new LegemiddelB("middel2", 50.0, 6.0, 10);
    LegemiddelC middel3 = new LegemiddelC("middel3", 200.0, 10.0);


      Arraylist<Legemiddel> legemidler = new Arraylist<Legemiddel>();
      legemidler.add(middel1);
      legemidler.add(middel2);
      legemidler.add(middel3);

      for (Legemiddel middel: legemidler){
            //returnerer navnet til et middel
          System.out.println("Navn: " + middel.hentNavn());
                //returnerer prisen til et middel
          System.out.println("Pris: " + middel2.hentPris());
                //returnerer virkestoffet til et middel
          System.out.println("virkestoff: " + middel.hentVirkestoff());
          System.out.println("");
      }


            //returnerer narkotiskstyrke til første middel
      System.out.println("Middel1 narkotisk styrke: " + middel1.hentNarotiskStyrke());
            //returnerer vanedannende styrke til andre middel
      System.out.println("Middel2Vanedannende styke: " + middel2.hentVanedannendeStyrke());










  }


}
