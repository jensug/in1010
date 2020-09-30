import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class KryptertMonitor {

Lock laas = new ReentrantLock();
Condition harMelding = laas.newCondition();


Melding currentMelding;

boolean sisteMeldingSendt = false;

ArrayList<Melding> meldinger = new ArrayList<Melding>();


public KryptertMonitor(){

}

public boolean sjekkOmTom(){
  laas.lock();
  boolean ikkeFerdig = true;
  if (meldinger.size() == 0){
    ikkeFerdig = false;
  }
  laas.unlock();

  return ikkeFerdig;
}


public boolean erFerdig(){
  laas.lock();
  boolean sjekk = sisteMeldingSendt;
  laas.unlock();
  return sjekk;
}

public void settFerdig(){
  sisteMeldingSendt = true;
  System.out.println("Alle telegrafister er ferdig.");
}

public Melding leggAv(){

  laas.lock();
  try {
    System.out.println("Kryptografen er klar til å hente melding.");
    while(meldinger.size() == 0){
      System.out.println("Kryptografen venter på melding.");
      harMelding.await();
    }
    currentMelding = meldinger.remove(0);
    System.out.println("Kryptografen henter melding.");
  } catch(InterruptedException e) {

  } finally {
      laas.unlock();
  }
  return currentMelding;

}

  public void leggPaa(Melding melding){
    laas.lock();
      System.out.println("Telegrafist legger til melding");
      meldinger.add(melding);
      harMelding.signalAll();

    laas.unlock();

  }


}
