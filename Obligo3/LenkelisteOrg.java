import java.util.Iterator;
import java.util.ArrayList;

public class Lenkeliste<T> implements Liste<T> {

  public Node start =  null;


  private class Node {

    Node neste = null;
    T data;

    public Node(T x){
      this.data = x;
    }

  }

@Override
  public void leggTil(T x){
    Node p = new Node(x);
    if (start == null){
      start = p;
    }
    else{
      start.neste = p;
    }
  }

@Override
  public T fjern(){
    T fjernet = start.data;
    if (start.neste == null){
      start = null;
    }
    else{
    start = start.neste;
    }
    return fjernet;
  }

@Override
  public void sett(int pos, T x) throws UgyldigListeIndeks {

    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{

  Node peker = start;
  for (int i = 0; i < pos; i++){
    peker = peker.neste;
  }
  if (peker == null){
    throw new UgyldigListeIndeks(pos);
  }
  else{
  peker.data = x;
  }
  }
}

@Override
  public void leggTil(int pos, T x) throws UgyldigListeIndeks {

    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{

    Node peker = start;
    for (int i = 0; i < pos; i++){
      peker = peker.neste;
    }
    if (peker == null){
      throw new UgyldigListeIndeks(pos);
    }
    else{
    Node p = new Node(peker.data);
    peker.data = x;
    p.neste = peker.neste;
    peker.neste = p;
}
  }
  }

@Override
  public T fjern(int pos) throws UgyldigListeIndeks {


    Node peker = start;
    for (int i = 0; i < pos; i++){
      peker = peker.neste;
    }

    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else{


    Node peker1 = start;

    for (int i = 0; i < (pos-1); i++){
      peker1 = peker1.neste;
    }
    if (peker == null){
      throw new UgyldigListeIndeks(pos);
    }
    else{
    Node peker2 = start;
    for (int i = 0; i < (pos+1); i++){
      peker2 = peker2.neste;
    }
    peker1.neste = peker2;
  }
}

return peker.data;
  }

@Override
  public int stoerrelse(){
    Node p = start;
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
    Node peker = start;
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
