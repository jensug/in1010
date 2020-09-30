import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Labyrint{

  int rader;
  int kolonner;
  Rute[][] ruter;

Lenkeliste<String> utveier = new Lenkeliste<String>();


private Labyrint (Rute[][] ruter, int rader, int kolonner){
  this.ruter = ruter;
  this.rader = rader;
  this.kolonner = kolonner;
}

static Labyrint lesFraFil(File fila) throws FileNotFoundException{


  Scanner filleser = new Scanner(fila);


  int antallRader = 0;
  int antallKolonner = 0;
  Rute[][] ruterObjekt;

    String linje = "";

//leser inn første linje
    linje = filleser.nextLine();
    String[] delt = linje.split(" ");

    antallRader = Integer.parseInt(delt[0]);
    antallKolonner = Integer.parseInt(delt[1]);
    ruterObjekt = new Rute[antallRader][antallKolonner];


//leser innn resten av linjene
    int radIndex = 0;
    int kolonneIndex = 0;

      while(radIndex < antallRader) {
        linje = filleser.nextLine();
        //delt = linje.split("");
        kolonneIndex = 0;

        while(kolonneIndex < antallKolonner){
          ////LES CHAR
        //  System.out.print(linje.charAt(kolonneIndex));

          if(linje.charAt(kolonneIndex) == '#'){
            //System.out.print('#');
            ruterObjekt[radIndex][kolonneIndex] = new SortRute(radIndex, kolonneIndex);
          }
          else if(linje.charAt(kolonneIndex) == '.'){
            //System.out.print('.');
            if(radIndex == 0 || radIndex == (antallRader-1) || kolonneIndex == 0 || kolonneIndex == (antallKolonner-1)){
              ruterObjekt[radIndex][kolonneIndex] = new Aapning(radIndex, kolonneIndex);
            }else{
            ruterObjekt[radIndex][kolonneIndex] = new HvitRute(radIndex, kolonneIndex);
            }
          }
          kolonneIndex++;
        }
        //System.out.println();
        radIndex++;
        }


    //Skal sette vest øst sør og nord
    radIndex = 0;
    kolonneIndex = 0;

      while(radIndex < antallRader) {
        kolonneIndex = 0;

        while(kolonneIndex < antallKolonner){

    //nord
          if (radIndex == 0){
            ruterObjekt[radIndex][kolonneIndex].nord = null;
          }else{
            ruterObjekt[radIndex][kolonneIndex].nord = ruterObjekt[(radIndex-1)][kolonneIndex];
          }
    //vest
          if (kolonneIndex == 0){
            ruterObjekt[radIndex][kolonneIndex].vest = null;
          }else{
            ruterObjekt[radIndex][kolonneIndex].vest = ruterObjekt[radIndex][(kolonneIndex-1)];
          }

    //øst
          if (radIndex == (antallRader-1)){
            ruterObjekt[radIndex][kolonneIndex].ost = null;
          }else{
            ruterObjekt[radIndex][kolonneIndex].ost = ruterObjekt[(radIndex+1)][kolonneIndex];
          }
    //sør
          if (kolonneIndex == (antallKolonner-1)){
            ruterObjekt[radIndex][kolonneIndex].syd = null;
          }else{
            ruterObjekt[radIndex][kolonneIndex].syd = ruterObjekt[radIndex][(kolonneIndex+1)];
          }

          kolonneIndex++;
        }
        radIndex++;
        }


Labyrint nyLabyrint = new Labyrint(ruterObjekt, antallRader, antallKolonner);

//setter labyrinten i rutene
      radIndex = 0;
      kolonneIndex = 0;

        while(radIndex < antallRader) {
          kolonneIndex = 0;
          while(kolonneIndex < antallKolonner){
            nyLabyrint.ruter[radIndex][kolonneIndex].settLabyrint(nyLabyrint);
            kolonneIndex++;
          }
          radIndex++;
          }

  return nyLabyrint;
}


public void skrivUt(){


System.out.println();

  int tellerRad = 0;
  while (tellerRad < rader){
    int tellerKolonne = 0;
    while (tellerKolonne < kolonner){
      System.out.print(ruter[tellerRad][tellerKolonne].tilTegn());
      tellerKolonne++;
    }
    System.out.println();
    tellerRad++;
  }

  System.out.println();
}




public Liste<String> finnUtveiFra(int kol, int rad){
ruter[rad][kol].finnUtvei(kol, rad);


Liste<String> utveiene = utveier;
utveier = new Lenkeliste<String>();

return utveiene;
}

}
