public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {


@Override
  public void leggTil(T x){


Node peker = start;
T data = x;
int j = 1;

if (peker == null) {super.leggTil(data);}
else if (data.compareTo(hent(0)) < 0) {super.leggTil(0, data);}
else if (data.compareTo(hent(stoerrelse() -1)) > 0) {
    super.leggTil(data);
}
else {
    while (data.compareTo(hent(j)) > 0) {peker = peker.neste; j++;}
    if (peker.neste == null) {
        j++;
        super.leggTil(j, data);
    }
    else {super.leggTil(j, data);}
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
