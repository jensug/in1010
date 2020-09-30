import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class Monitor{

  Lock laas = new ReentrantLock();


  Melding currentMelding;

  boolean sisteMeldingSendt = false;

  ArrayList<Melding> meldinger = new ArrayList<Melding>();


  public int hentAntMld(){
    return meldinger.size();
  }


  public boolean erFerdig(){
    return sisteMeldingSendt;
  }

  public void settFerdig(){
    sisteMeldingSendt = true;
  }

}
