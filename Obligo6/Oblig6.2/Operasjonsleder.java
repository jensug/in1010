import java.util.ArrayList;
import java.io.PrintWriter;

public class Operasjonsleder extends Thread{

DeKryptertMonitor deKryptertMonitor;
ArrayList<Melding> deKrypterteMeldinger;
ArrayList<Melding> kanal1 = new ArrayList<Melding>();
ArrayList<Melding> kanal2 = new ArrayList<Melding>();
ArrayList<Melding> kanal3 = new ArrayList<Melding>();

Melding currentMelding;

public Operasjonsleder(DeKryptertMonitor deKryptertMonitor){
  this.deKryptertMonitor = deKryptertMonitor;

}

  @Override
  public void run() {


    deKryptertMonitor.tilFilStart();

    while(deKryptertMonitor.hentAntMld() > 0){
      currentMelding = deKryptertMonitor.leggAv();
      if (currentMelding.hentKanalID() == 0){
        int sekvensSett = 0;
        for (Melding meldinga : kanal1){
          if(currentMelding.hentSekvensnummer() > meldinga.hentSekvensnummer()){
            sekvensSett++;
          }
        }
        if(sekvensSett >= kanal1.size()){
          kanal1.add(currentMelding);
        } else{
          kanal1.add(sekvensSett, currentMelding);
        }
      }

      else if (currentMelding.hentKanalID() == 1){
        int sekvensSett = 0;
        for (Melding meldinga : kanal2){
          if(currentMelding.hentSekvensnummer() > meldinga.hentSekvensnummer()){
            sekvensSett++;
          }
        }
        if(sekvensSett >= kanal2.size()){
          kanal2.add(currentMelding);
        } else{
          kanal2.add(sekvensSett, currentMelding);
        }
      }

      else if (currentMelding.hentKanalID() == 2){
        int sekvensSett = 0;
        for (Melding meldinga : kanal3){
          if(currentMelding.hentSekvensnummer() > meldinga.hentSekvensnummer()){
            sekvensSett++;
          }
        }
        if(sekvensSett >= kanal3.size()){
          kanal3.add(currentMelding);
        } else{
          kanal3.add(sekvensSett, currentMelding);
        }
      }




    }

PrintWriter utPrinter;
try{
    utPrinter = new PrintWriter("kanal1.txt", "utf-8");
    for (Melding meldingen : kanal1){
      System.out.println("Operasjonsleder skriver melding til kanal1 fil.");
      utPrinter.println(meldingen.hentMelding());
        utPrinter.println("");
    }
    utPrinter.close();
  } catch (Exception e) {
        System.out.println("Exception: " + e);
      }

try{
    utPrinter = new PrintWriter("kanal2.txt", "utf-8");
    for (Melding meldingen : kanal2){
      System.out.println("Operasjonsleder skriver melding til kanal2 fil.");
      utPrinter.println(meldingen.hentMelding());
        utPrinter.println("");
    }
    utPrinter.close();
  } catch (Exception e) {
        System.out.println("Exception: " + e);
      }

  try{
      utPrinter = new PrintWriter("kanal3.txt", "utf-8");
      for (Melding meldingen : kanal3){
        System.out.println("Operasjonsleder skriver melding til kanal3 fil.");
        utPrinter.println(meldingen.hentMelding());
          utPrinter.println("");
      }
      utPrinter.close();
    } catch (Exception e) {
          System.out.println("Exception: " + e);
        }



  }



}
