public class Stabel<T> extends Lenkeliste<T>{



  public void leggPaa(T x){
    int pos = super.stoerrelse();
    super.leggTil(pos, x);
  }

  public T taAv(){
      int pos = super.stoerrelse()-1;
    T tattAv = super.hent((pos));
    super.fjern((pos));
    return tattAv;
  }
}
