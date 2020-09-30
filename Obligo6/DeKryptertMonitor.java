import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class DeKryptertMonitor {


  Lock laas = new ReentrantLock();


  Melding currentMelding;

  boolean sisteMeldingSendt = false;

  ArrayList<Melding> meldinger = new ArrayList<Melding>();


Condition ferdig = laas.newCondition();

public DeKryptertMonitor(){

}

public int hentAntMld(){
  return meldinger.size();
}


public boolean erFerdig(){
  return sisteMeldingSendt;
}



  public void leggPaa(Melding melding){
    laas.lock();
      System.out.println("Kryptograf legger til melding.");
      meldinger.add(melding);


        laas.unlock();

  }

  public void settFerdig(){
    laas.lock();
    sisteMeldingSendt = true;
    System.out.println("Alle kryptografene er ferdig.");
    ferdig.signalAll();
    laas.unlock();

  }

public void tilFilStart(){


System.out.println("Operasjonsleder starter å jobbe.");
laas.lock();
  try {

    System.out.println("Operasjonsleder venter på meldinger.");
    ferdig.await();
  } catch(InterruptedException e) {

  } finally {
    laas.unlock();
  }

}

  public Melding leggAv(){

    laas.lock();

      currentMelding = meldinger.remove(0);
      System.out.println("Operasjonsleder henter melding.");
        laas.unlock();

    return currentMelding;

  }

}
