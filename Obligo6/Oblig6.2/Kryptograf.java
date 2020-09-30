public class Kryptograf extends Thread{


  Melding melding;

  KryptertMonitor kryptertMonitor;
  DeKryptertMonitor deKryptertMonitor;
  static int antallKryptograferHer = 0;
  static int antallKryptograferFerdig = 0;
  int kryptografID;
  static int antallMeldingerHer = 0;

  public Kryptograf(KryptertMonitor kryptert, DeKryptertMonitor deKryptert){
    this.kryptertMonitor = kryptert;
    this.deKryptertMonitor = deKryptert;


    kryptografID = antallKryptograferHer;
    antallKryptograferHer++;
  }

  @Override
  public void run() {
    System.out.println("Kryptograf starter å jobbe.");
  while (!kryptertMonitor.erFerdig()){
          Melding kryptertMelding = kryptertMonitor.leggAv();
          String dekryptertMld = Kryptografi.dekrypter(kryptertMelding.hentMelding());
          Melding deKryptertMelding = kryptertMelding;
          deKryptertMelding.settMelding(dekryptertMld);
          deKryptertMonitor.leggPaa(deKryptertMelding);
          antallMeldingerHer++;

    }
    while(kryptertMonitor.sjekkOmTom()){
      Melding kryptertMelding = kryptertMonitor.leggAv();
      String dekryptertMld = Kryptografi.dekrypter(kryptertMelding.hentMelding());
      Melding deKryptertMelding = kryptertMelding;
      deKryptertMelding.settMelding(dekryptertMld);
      deKryptertMonitor.leggPaa(deKryptertMelding);
      antallMeldingerHer++;

    }

  //  deKryptertMonitor.settFerdig();
  System.out.println("Kryptograf er ferdig");
  antallKryptograferFerdig++;
    if (antallKryptograferFerdig >= antallKryptograferHer){
        deKryptertMonitor.settFerdig();
  }

}
}
