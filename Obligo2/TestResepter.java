public class TestResepter{


//test av resept objekter
  public static void main(String[] args) {



        LegemiddelA middel1 = new LegemiddelA("middel1", 200.0, 5.0, 10);
        LegemiddelB middel2 = new LegemiddelB("middel2", 200.0, 6.0, 10);
        LegemiddelC middel3 = new LegemiddelC("middel3", 200.0, 10.0);


            Lege lege1 = new Lege("Ole");

        MilitResept resept1 = new MilitResept(middel1, lege1, 1, 2);
        PResept resept2 = new PResept(middel2, lege1, 2);
        BlaaResept resept3 = new BlaaResept(middel3,lege1, 3, 3);


        System.out.println("ReseptID: " + resept1.hentId());

/* henter bare objekter, ikke navn, så ingen poeng å printe dem ut
        System.out.println(resept1.hentLegemiddel());
        System.out.println(resept1.hentLege());
*/
        System.out.println("Antall bruk igjen: " + resept1.hentReit());
        System.out.println("Pasientens ID: " + resept1.hentPasientId());
        System.out.println("Pris paa legemiddel for pasient: " + resept1.prisAaBetale() +  " kr");
        System.out.println("Farge paa resept: " + resept1.farge());

          System.out.println("");

        System.out.println("ReseptID: " + resept2.hentId());
        System.out.println("Antall bruk igjen: " + resept2.hentReit());
        System.out.println("Pris paa legemiddel for pasient: " + resept2.prisAaBetale() +  " kr");

          System.out.println("");


        System.out.println("ReseptID: " + resept3.hentId());
        System.out.println("Pris paa legemiddel for pasient: " + resept3.prisAaBetale() +  " kr");
        System.out.println("Farge paa resept: " + resept3.farge());




  }
}
