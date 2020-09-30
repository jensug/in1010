import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

public class Legesystem{


  static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
  static Iterator<Pasient> pasienterIterator = pasienter.iterator();
  static SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
  static Iterator<Lege> legerIterator = leger.iterator();
  static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
  static Iterator<Legemiddel> legemidlerIterator = legemidler.iterator();
  static Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();
  static Iterator<Resept> resepterIterator = resepter.iterator();


  static int choice;


  public static void main(String[] args) {

    Lege ole = new Lege("Ole");
    leger.leggTil(ole);
    Legemiddel paracett = new LegemiddelA("Paracett", 2.2, 2.2, 2);
    legemidler.leggTil(paracett);
    Pasient lise = new Pasient("Lise", "130898");
    pasienter.leggTil(lise);

    while (choice != 7){
    meny();
    }




}

  static void meny(){
    System.out.print("\n -------------------------------------------------------\n");
    System.out.print("Legesystem Meny: (tast inn tall) \n \n");
    System.out.print("1 - Print ut fullstendig oversikt \n");
    System.out.print("2 - Legg til nytt element \n");
    System.out.print("3 - Bruk resept på pasient \n");
    System.out.print("4 - Skriv ut statestikk   ---> \n");
    System.out.print("5 - Les inn fra fil \n");
    System.out.print("6 - Eksporter til fil \n");
    System.out.print("7 - Avslutt\n");
    System.out.print("-------------------------------------------------------\n \n ");

      Scanner scanner = new Scanner(System.in);
      choice = scanner.nextInt();

      switch (choice) {
          case 1:
           print();
              // Perform "original number" case.
              break;
          case 2:
            leggTilObjekt();
              // Perform "encrypt number" case.
              break;
          case 3:
          brukResept();
              // Perform "decrypt number" case.
              break;
          case 4:
          statestikk();
              // Perform "quit" case.
              break;
          case 5:
          hentFraFil();
            System.out.println("du valgte 4");
                  // Perform "quit" case.
                break;

          case 6:
          eksporterTilFil();

            break;
          case 7:
          //quit
              break;
          default:
              // The user input an unexpected choice.


        }
  }



  static void print() {

        System.out.println("\n Pasienter: --------------------------------------------- \n");
        for (Pasient pasient: pasienter){

            System.out.println(pasient.navn + ": { Fødselsnummer: " + pasient.fodselsnummer + ", ID: " + pasient.ID + " }");
            System.out.println("  Pasientens resepter: ");

          Lenkeliste<Resept> pasientResepter = pasient.hentResepter();
          Iterator<Resept> pasientResepterIterator = pasientResepter.iterator();
          for (Resept resept : pasientResepter){
            System.out.println("   -" + resept.hentLegemiddel().hentNavn() + "{ Pris = " + resept.prisAaBetale() + "}");
          }
          System.out.println("\n");
        }


        System.out.println("\n Leger: --------------------------------------------- \n");
        for (Lege lege: leger){
          System.out.println(lege.hentLegeNavn());

          System.out.println("  Legens resepter: ");

          Lenkeliste<Resept> legeResepter = lege.hentResepter();
          Iterator<Resept> legeResepterIterator = legeResepter.iterator();
          for (Resept resept : legeResepter){
            System.out.println("   -" + resept.hentLegemiddel().hentNavn());

          }
          System.out.println("\n");
        }

        System.out.println("\n Legemidler: --------------------------------------------- \n");
        for (Legemiddel legemiddel: legemidler){
          System.out.println(legemiddel.hentNavn() + ": { Pris: " + legemiddel.hentPris() + ", ID: " + legemiddel.ID + ", Virkestoff: " + legemiddel.hentVirkestoff() + " }");
          System.out.println("\n");
        }

        System.out.println("\n Resepter: --------------------------------------------- \n");
        for (Resept resept: resepter){
          System.out.println("Resept ID " + resept.hentId() + " - " +  resept.hentLegemiddel().hentNavn());
          System.out.println("  Utskrevet av " + resept.hentLege().hentLegeNavn());
          System.out.println("  Til  pasient med id " + resept.hentPasientId());
          System.out.println("  Reit: " + resept.hentReit());
          System.out.println("\n");
        }

        }



  static void leggTilObjekt( ) {
    System.out.println("\n Velg objekt: \n");
    System.out.println("1 - Lege \n");
    System.out.println("2 - Pasient \n");
    System.out.println("3 - Resept \n");
    System.out.println("4 - Legemiddel \n");
    System.out.println("5 - Avslutt \n");

    Scanner scanner2 = new Scanner(System.in);
    int choice2 = scanner2.nextInt();


    switch (choice2) {
        case 1:
        leggTilLegeSystem();
            break;
        case 2:
        leggTilPasientSystem();
            break;
        case 3:
        leggTilReseptSystem();
            break;
        case 4:
        leggTilLegemiddelSystem();

            break;
        case 5:
                // Perform "quit" case.
              break;
        default:
            // The user input an unexpected choice.


}

  }

  static void brukResept(){

    Pasient midlertidigPasient = new Pasient("fakePasient", "10001");
    Legemiddel midlertidigLegemiddel = new LegemiddelB("FakeMiddel", 2.2, 2.2, 2);
    int midlertidigReit = 0;

    if (pasienter.stoerrelse() <= 0){
      System.out.println("Det finnes ingen pasienter");
    }
      else{
      System.out.println("Hvilken pasient vill du bruke resept for?");
        for (Pasient pasienten : pasienter){
          System.out.println("  " + pasienten.hentNavn());
        }

        Scanner brukReseptPasientSvanner = new Scanner(System.in);
        String brukReseptPasient = brukReseptPasientSvanner.next();

        boolean brukPasientIkkeFunnet = true;
        for (Pasient pasienten : pasienter){
          if (pasienten.hentNavn().equals(brukReseptPasient)){
            midlertidigPasient = pasienten;
            brukPasientIkkeFunnet = false;
          }
        }
        if (brukPasientIkkeFunnet){
          System.out.println("Fant ikke pasient.");
        }
          else{
            Lenkeliste<Resept> pasientensResept = midlertidigPasient.hentResepter();
            if (pasientensResept.stoerrelse() <= 0){
                System.out.println("Pasienten har ingen resepter.");
            }
              else{
                System.out.println("\nHvilket resept vill du bruke?");
              for (Resept pasientResept : pasientensResept){
                System.out.println("  " + pasientResept.hentLegemiddel().hentNavn() + " (Reit: " + pasientResept.hentReit() + ")");
              }
              Scanner brukReseptValgScanner = new Scanner(System.in);
              String brukReseptLegemiddelValgt = brukReseptValgScanner.next();

              boolean reitIkkeBrukt = true;
              for (Resept pasientResept : pasientensResept){
                if ((pasientResept.hentLegemiddel().hentNavn()).equals(brukReseptLegemiddelValgt))
                  reitIkkeBrukt = false;
                  pasientResept.brukReit();
                  midlertidigLegemiddel = pasientResept.hentLegemiddel();
                  midlertidigReit = pasientResept.hentReit();
              }
              if (reitIkkeBrukt){
                System.out.println("Fant ikke legemiddel.");
              }
              else{
                System.out.println("Brukte resept på " + midlertidigLegemiddel.hentNavn() + ". Antall reit igjen: " + midlertidigReit);
              }


              }


          }

  }
}

  static void statestikk(){
    System.out.println("\n Velg objekt: \n");
    System.out.println("1 - Totalt antall utskrevne resepter på vanedannende legemidler \n");
    System.out.println("2 - Antall vanedannende resepter utskrevne til militære. \n");
    System.out.println("3 - Statistikk om mulig misbruk av narkotika \n");
    System.out.println("4 - Avslutt \n");

    Scanner scannerStatestikk = new Scanner(System.in);
    int StatestikkValg = scannerStatestikk.nextInt();

    if (StatestikkValg == 4){

    }
    else if (StatestikkValg == 1){
      int antVanedannendeResept = 0;
      for (Resept reseptet : resepter){
        if (reseptet.hentLegemiddel().erVanedannende())
          antVanedannendeResept += 1;
        }
        System.out.println("\nTotalt antall utskrevne resepter på vanedannende legemidler er " + antVanedannendeResept);

    }
    else if (StatestikkValg == 2){
      int antVanedannendeMilitResept = 0;
      for (Resept reseptet : resepter){
        if (reseptet.hentLegemiddel().erVanedannende() || reseptet.farge().equals("Milit"))
          antVanedannendeMilitResept += 1;
        }
        System.out.println("\nTotalt antall utskrevne resepter på vanedannende legemidler er " + antVanedannendeMilitResept);
    }
    else if (StatestikkValg == 3){
      System.out.println("\nLeger med narkotiske resepter: \n");
      for (Lege legen : leger){
        if (legen.resepterMedNarkotiskStyrke > 0){
          System.out.println("  -" + legen.hentLegeNavn() + legen.resepterMedNarkotiskStyrke);
        }
      }
      System.out.println("\nPasienter med narkotiske resepter: \n");
      for (Pasient pasienten : pasienter){
        if (pasienten.resepterMedNarkotiskStyrke > 0){
          System.out.println("  -" + pasienten.hentNavn() + "" + pasienten.resepterMedNarkotiskStyrke);
        }
      }

    }
}

   static void hentFraFil(){

  }

  static void eksporterTilFil(){

  }





  //Legg til metoder

  static void leggTilLegeSystem(){

            int legeAvtalenummer = 0;
            System.out.println("\n Velg type lege: ");
            System.out.println("\n 1 - Vanlig lege");
            System.out.println("\n 2 - Fast lege");
            System.out.println("\n 3 - Avbryt \n");

            Scanner fastScanner = new Scanner(System.in);
            int fastLegeResultat = fastScanner.nextInt();

            boolean erFastLege = false;

            if (fastLegeResultat == 2){
              erFastLege = true;
              System.out.println("Skriv avtalenummer: ");
              Scanner avtaleScanner = new Scanner(System.in);
              Integer avtaleResultat = avtaleScanner.nextInt();

              legeAvtalenummer = avtaleResultat;
            } else if(fastLegeResultat == 1){

                    System.out.println("Skriv inn Legen sitt navn: ");

                    Scanner scanneren = new Scanner(System.in);
                    String Legensnavn = scanneren.next();

                    boolean legenFinnes = false;
                    for (Lege legen : leger){
                      if (legen.hentLegeNavn().equals(Legensnavn)){
                        System.out.println("Legen finnes allerde.");
                        legenFinnes = true;
                      }
                    }
                    if (legenFinnes == false){
                      if (erFastLege){
                        Fastlege heltNyFastLege = new Fastlege(Legensnavn, legeAvtalenummer);
                        leger.leggTil(heltNyFastLege);
                      }
                      else{
                      Lege heltNyLege = new Lege(Legensnavn);
                      leger.leggTil(heltNyLege);
                      }
                    }
              }
              else{
                System.out.println("Avbtytt");
              }
  }

  static void leggTilPasientSystem(){
    System.out.println("Skriv inn Pasienten sitt navn: ");
    Scanner scanneren1 = new Scanner(System.in);
    String Pasientnavn = scanneren1.next();
    boolean pasientenFinnes = false;
    for (Pasient pasienten : pasienter){
      if (pasienten.hentNavn().equals(Pasientnavn)){
        System.out.println("Pasienten finnes allerede.");
        pasientenFinnes = true;
      }
    }
    if (pasientenFinnes == false){
      System.out.println("Skriv inn pasientens fødselsnummer: ");
      Scanner scanneren2 = new Scanner(System.in);
      String Pasientnummer = scanneren2.next();

      Pasient heltNyPasient = new Pasient(Pasientnavn, Pasientnummer);
      pasienter.leggTil(heltNyPasient);
    }

}

  static void leggTilReseptSystem(){
    //MÅ VELGE HVA SLAGS RESEPT

            //lager fake objekter for å ungå might not have been initialized error
                  Lege reseptensLege = new Lege("FakeLege");
                  Legemiddel reseptensLegemiddel = new LegemiddelB("FakeMiddel", 2.2, 2.2, 2);
                  int reseptPasientID = 0;
                  Pasient reseptPasient = new Pasient("fakePasient", "00000");
                  int reseptReit = 0;


                  System.out.println("\n Velg type legemiddel: ");
                  System.out.println("\n 1 - Blå resept");
                  System.out.println("\n 2 - Hvit resept");
                  System.out.println("\n 3 - Millitær resept");
                  System.out.println("\n 4 - P resept");
                  System.out.println("\n 5 - Avbryt \n");


                  Scanner scannerReseptTyp = new Scanner(System.in);
                  int reseptTypValg = scannerReseptTyp.nextInt();

                  if (reseptTypValg == 5){

                  }
                  else if(reseptTypValg == 1 || reseptTypValg == 2 || reseptTypValg == 3 || reseptTypValg == 4 ){

                          //velger en lege:
                          if (leger.stoerrelse() <= 0){
                            System.out.println("Det finnes ingen leger.");
                          }
                          else{
                          System.out.println("Velg lege: ");
                          for (Lege legen : leger){
                            System.out.println("  " + legen.hentLegeNavn());
                          }

                          Scanner scanneren3 = new Scanner(System.in);
                          String Legensittnavn = scanneren3.next();
                          Lege heltNyLege = new Lege(Legensittnavn);

                          boolean legeFunnet = false;
                          for (Lege legen : leger){
                            if (legen.hentLegeNavn().equals(Legensittnavn)){
                              reseptensLege = legen;
                              legeFunnet = true;
                            }
                          }
                          if (legeFunnet == false){
                            System.out.println("Fant ikke lege.");
                          }
                            else{


                        //velger et legemiddel
                            if (legemidler.stoerrelse() <= 0){
                              System.out.println("Det finnes ingen legemiddler");
                            }
                              else{
                              System.out.println("Velg legemiddel: ");
                              for (Legemiddel legemiddelet : legemidler){
                                System.out.println("  " + legemiddelet.hentNavn());
                              }
                              Scanner scanneren4 = new Scanner(System.in);
                              String LegemiddelNavn = scanneren4.next();

                              boolean legemiddelFunnet = false;
                              for (Legemiddel legemiddelet : legemidler){
                                if (legemiddelet.hentNavn().equals(LegemiddelNavn)){
                                  reseptensLegemiddel = legemiddelet;
                                  legemiddelFunnet = true;
                                }
                              }
                              if (legemiddelFunnet == false){
                                System.out.println("Fant ikke legemiddel.");
                              }
                                else{


                        //velger pasienter
                                if (pasienter.stoerrelse() <= 0){
                                  System.out.println("Det finnes ingen pasienter");
                                }
                                  else{
                                  System.out.println("Skriv inn pasientens ID: ");

                                  Scanner scanneren5 = new Scanner(System.in);
                                  int pasientensID = scanneren5.nextInt();

                                  boolean pasientFunnet = false;
                                  for (Pasient pasienten : pasienter){
                                    if (pasienten.hentId().equals(pasientensID)){
                                      reseptPasientID = pasienten.hentId();
                                      reseptPasient = pasienten;
                                      pasientFunnet = true;
                                    }
                                  }
                                  if (pasientFunnet == false){
                                    System.out.println("Pasienten finnes ikke.");
                                  }
                                    else{

                                Resept heltNyResept = new BlaaResept(reseptensLegemiddel, reseptensLege, reseptPasientID, reseptReit);

                                if(reseptTypValg == 4){
                                  heltNyResept = new PResept(reseptensLegemiddel, reseptensLege, reseptPasientID);
                                }
                                else{
                          //skriv inn reit
                                    System.out.println("Skriv inn reit ");

                                    Scanner scanneren6 = new Scanner(System.in);
                                    int reseptensReit = scanneren6.nextInt();
                                    reseptReit = reseptensReit;
                                }

                                if(reseptTypValg == 1){
                                    heltNyResept = new HvitResept(reseptensLegemiddel, reseptensLege, reseptPasientID, reseptReit);
                                  }
                                else if (reseptTypValg == 2){
                                  heltNyResept = new BlaaResept(reseptensLegemiddel, reseptensLege, reseptPasientID, reseptReit);
                                }
                                else if (reseptTypValg == 3){
                                  heltNyResept = new MilitResept(reseptensLegemiddel, reseptensLege, reseptPasientID, reseptReit);
                                }

                                if (reseptensLegemiddel.erNarkotisk()){
                                  reseptensLege.resepterMedNarkotiskStyrke += 1;
                                  reseptPasient.resepterMedNarkotiskStyrke += 1;
                                }


                                    resepter.leggTil(heltNyResept);
                                    reseptensLege.leggTilResept(heltNyResept);
                                    reseptPasient.leggTilResept(heltNyResept);

                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        else {
                          System.out.println("Valget er ugyldig");
                        }
      }


      static void leggTilLegemiddelSystem(){
        System.out.println("\n Velg type legemiddel: \n");
        System.out.println("1 - LegemiddelA  \n");
        System.out.println("2 - LegemiddelB \n");
        System.out.println("3 - LegemiddelC \n");
        System.out.println("4 - Avbryt \n");

        Scanner scannermiddel = new Scanner(System.in);
        int LegemiddelValg = scannermiddel.nextInt();

        if (LegemiddelValg == 4){

        }
        else{

        System.out.print("Skriv navnet: \n");
        Scanner legemiddelNavnScanner = new Scanner(System.in);
        String scannetLegemiddelNavn = legemiddelNavnScanner.next();

        System.out.print("Skriv prisen: \n");
        Scanner legemiddelPrisScanner = new Scanner(System.in);
        double scannetLegemiddelPris = legemiddelPrisScanner.nextDouble();

        System.out.print("Skriv Virkestoff: \n");
        Scanner legemiddelStoffScanner = new Scanner(System.in);
        double scannetLegemiddelStoff = legemiddelStoffScanner.nextDouble();

        int scannetLegemiddelStyrke = 0;
        Legemiddel heltNyttLegemiddel = new LegemiddelA("FakeMiddel", 2.2, 2.2, 2);

          if (LegemiddelValg == 1){
          System.out.print("Skriv narkotisk styrke: \n");
          Scanner legemiddelStyrkeScanner = new Scanner(System.in);
          scannetLegemiddelStyrke = legemiddelStyrkeScanner.nextInt();
          heltNyttLegemiddel = new LegemiddelA(scannetLegemiddelNavn, scannetLegemiddelPris, scannetLegemiddelStoff, scannetLegemiddelStyrke);
          heltNyttLegemiddel.settNarkotisk();
          }
          else if (LegemiddelValg == 2){
          System.out.print("Skriv vanedannende styrke: \n");
          Scanner legemiddelStyrkeVScanner = new Scanner(System.in);
          scannetLegemiddelStyrke = legemiddelStyrkeVScanner.nextInt();
          heltNyttLegemiddel = new LegemiddelB(scannetLegemiddelNavn, scannetLegemiddelPris, scannetLegemiddelStoff, scannetLegemiddelStyrke);
          heltNyttLegemiddel.settVanedannede();
          }
          else if (LegemiddelValg == 3){
          heltNyttLegemiddel = new LegemiddelC(scannetLegemiddelNavn, scannetLegemiddelPris, scannetLegemiddelStoff);
          }

          legemidler.leggTil(heltNyttLegemiddel);

        }
      }

}
