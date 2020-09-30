public class Hovedprogram {


public static void main(String[] args) {

  int antallTelegrafister = 3;
  int antallKryptografer = 20;

  Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);


  KryptertMonitor krypterteMeldingerMonitor = new KryptertMonitor();
  DeKryptertMonitor deKrypterteMeldingerMonitor = new DeKryptertMonitor();

  for (int i = 0; i < antallTelegrafister; i++){
    Telegrafist telegrafist = new Telegrafist(krypterteMeldingerMonitor, ops);
    telegrafist.start();
  }


  for (int i = 0; i < antallKryptografer; i++){
    Kryptograf kryptograf = new Kryptograf(krypterteMeldingerMonitor, deKrypterteMeldingerMonitor);
    kryptograf.start();
  }


  Operasjonsleder operasjonsleder = new Operasjonsleder(deKrypterteMeldingerMonitor);
  operasjonsleder.start();




}



}
