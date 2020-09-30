public class Telegrafist extends Thread{

Operasjonssentral operasjonssentral;
KryptertMonitor kryptertMonitor;
static int antallTelegrafisterHer = 0;
static int antallTelegrafisterFerdig = 0;
int telegrafistID;
Kanal[] kanaler;
Kanal kanal;
static int antallMeldingerHer = 0;



  public Telegrafist(KryptertMonitor kryptertMonitor, Operasjonssentral sentral) {
    this.kryptertMonitor = kryptertMonitor;
    this.operasjonssentral = sentral;


      }


      @Override
      public void run() {

        telegrafistID = antallTelegrafisterHer;
        antallTelegrafisterHer++;

        kanaler = operasjonssentral.hentKanalArray();
        kanal = kanaler[telegrafistID];

        System.out.println("Telegrafist starter å jobbe");

        String kanalen = kanal.lytt();
        int meldingSekvens = 0;
        while(kanalen != null){
          Melding nyMelding = new Melding(kanalen, telegrafistID, meldingSekvens);
          kryptertMonitor.leggPaa(nyMelding);
          antallMeldingerHer++;
          kanalen = kanal.lytt();
          meldingSekvens++;
        }


      System.out.println("Telegrafist er ferdig");
      antallTelegrafisterFerdig++;
        if (antallTelegrafisterFerdig >= antallTelegrafisterHer){
            kryptertMonitor.settFerdig();
        }
      }
}
