import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
//trenger kanskje ikke de to siste


public class Lenkeliste<T> implements Liste<T> {

  public Node<T> start =  null;


  public class Node<T> {

    Node<T> neste = null;
    T data;

    public Node(T x){
      this.data = x;
    }

    public T hentData(){
      return data;
    }

    public Node<T> hentNeste(){
      return neste;
    }

  }

  public class LenkelisteIterator implements Iterator<T>{

    public Node<T> current;

    public LenkelisteIterator(){
      current = start;
    }

    public boolean hasNext(){
      return (current != null);
    }


    public T next(){
      if (current == null){
        throw new NoSuchElementException();
      }
      T temp = current.hentData();
      current = current.hentNeste();
      return temp;
    }


    public void remove(){
    }


  }

  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }

@Override
  public void leggTil(T x){
    if (start == null){
      start = new Node<T>(x);
    }
    else{
        Node<T> peker = start;
      while (peker.neste != null){
        peker = peker.neste;
        }
    peker.neste = new Node<T>(x);

    }
  }

@Override
  public T fjern() throws UgyldigListeIndeks{
    if (start != null){

    T fjernet = start.data;
    if (start.neste == null){
      start = null;
    }
    else{
    Node<T> peker = start.neste;
    start = peker;
    }
    return fjernet;
  }
  else{
      throw new UgyldigListeIndeks(0);
  }
}

@Override
  public void sett(int pos, T x)  throws UgyldigListeIndeks{


    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{

      Node<T> pekersjekk = start;
      for (int i = 0; i < pos; i++){
        pekersjekk = pekersjekk.neste;
      }
      if (pekersjekk == null){
        throw new UgyldigListeIndeks(pos);
      }
      else{

  Node<T> peker = start;
  for (int i = 0; i < pos; i++){
    peker = peker.neste;
  }

  peker.data = x;

  }
}
}


@Override
  public void leggTil(int pos, T x) throws UgyldigListeIndeks{


    if (start == null && pos > 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{
    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{

      Node pekersjekk = start;
      for (int i = 0; i < (pos-1); i++){
        pekersjekk = pekersjekk.neste;
      }

      if (start != null && pekersjekk == null){
        throw new UgyldigListeIndeks(pos);
      }
      else{


    Node<T> nyNode = new Node<T>(x);

    if (pos == 0){
      if (start == null){
        start = nyNode;
      }
      else{
      nyNode.neste = start;
      start = nyNode;
    }
    }
    else{
    Node<T> peker = start;
    for (int i = 0; i < (pos-1); i++){
      peker = peker.neste;
    }
    nyNode.neste = peker.neste;
    peker.neste = nyNode;
  }
}
  }
}
}

@Override
  public T fjern(int pos) throws UgyldigListeIndeks{

    if (start != null){

    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{

    Node<T> peker = start;
    for (int i = 0; i < (pos); i++){
      peker = peker.neste;
    }
    if (peker == null){
      throw new UgyldigListeIndeks(pos);
    }
    else{

    Node<T> peker1 = start;

    if (pos == 0){
      if (start.neste == null){
        start = null;
      }
      else{
      start = start.neste;
      }
    }
    else{
    for (int i = 0; i < (pos-1); i++){
      peker1 = peker1.neste;
    }

    Node<T> peker2 = start;
    for (int i = 0; i < (pos+1); i++){
      peker2 = peker2.neste;
    }
    peker1.neste = peker2;
}

return peker.data;
  }
}
}
else{
    throw new UgyldigListeIndeks(pos);
}
}

@Override
  public int stoerrelse(){
    Node<T> p = start;
    int n = 0;

    while (p != null){
      n++;
      p = p.neste;
      }
      return n;
    }

    @Override
      public T hent(int pos) throws UgyldigListeIndeks {
        if (pos < 0){
          throw new UgyldigListeIndeks(pos);
        }
        else{
        Node<T> peker = start;
        for (int i = 0; i < pos; i++){
          peker = peker.neste;
        }
        if (peker == null){
          throw new UgyldigListeIndeks(pos);
        }
        else{
        return peker.data;
      }
      }
      }


  }
