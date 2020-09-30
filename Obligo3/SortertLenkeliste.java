public class SortertLenkeliste<T extends Comparable<T> > extends Lenkeliste<T>{


@Override
  public void leggTil(T x){
    Node start = super.start;

//hvis listen er tom legger den til en node som første objekt i listen.
    if (start == null){
      super.leggTil(x);
    }
//hvis listen ikke er tom lager jeg en peker og en variabel som holder rede på posisjon
    else{
      Node peker = start;
      int pos = 0;
//Så lenge pekeren peker på en node i listen, hvor det neste objektet ikke er tomt,
//  og verdien i objektet er mindre enn det nye tallet x som legges til,
//  så fortsetter den å telle videre i listen.
          while (peker.neste != null && peker.data.compareTo(x) < 0){
          peker = peker.neste;
          pos += 1;
          }
//når den til slutt kommer til enden av listen (hvor neste objekt er 0),
//  ELLER hvis objektet pekeren peker på ikke lengere er lavere enn det
//  vi prøver å legge til, så går den videre

// hvis loopen har sluttet fordi den har kommet til slutten av listen
//   (hvor det ikke er en neste node), så sjekker den om verdien til noden
//  den peker på er større eller mindre enn den vi skal legge til.
//  hvis den er mindre så vill posisjonen settes til å være bak det siste objektet
//  og så legges objektet til på denne posisjonen med super klassen.
              if (peker.neste == null){
                  pos += 1;
                  super.leggTil(pos, x);
              }
//hvis loopen har stoppet fordi verdien til noden pekeren peker på
//   er større enn den vi vill legge til, så bruker vi super.leggtil på posisjonen
//   dette objektet har som vill sette bojektet foran det som pekes på.
              else{
                  super.leggTil(pos, x);
              }
        }
  }

@Override
  public T fjern(){
//fjern metoden vill fjerne det siste elementet i motsetning til super metoden som
//  fjerner det første. Så lengden på listen forteller posisjonen på det siste
//  elementet og fjerne det med super klassen som fjerner med posisjon som parameeter.
    int sistePos = super.stoerrelse()-1;
    return super.fjern(sistePos);

  }


@Override
public void sett(int pos, T x) throws UnsupportedOperationException{
  throw new UnsupportedOperationException("Ugyldig argument. SortertLenkeliste skal sorteres.");
}

@Override
public void leggTil(int pos, T x) throws UnsupportedOperationException{
  throw new UnsupportedOperationException("Ugyldig argument. SortertLenkeliste skal sorteres.");
}

}
