
public class Lenkeliste<T> implements Liste<T> {

  public Node start =  null;


  public class Node {

    Node neste = null;
    T data;

    public Node(T x){
      this.data = x;
    }

  }

@Override
  public void leggTil(T x){

      //viss lista er tom
      if (start == null){
        start = new Node(x);
        return;
      }
      Node tmp = start;

      //viss elementet er mindre enn listehodet
      if(start.data.compareTo(x) > 0){
        start = new Node(x);
        start.neste = tmp;
        return;
      }

      while(tmp.neste != null){
          if(tmp.neste.data.compareTo(x) >= 0){
            Node nySinNeste = tmp.neste;
            Node nyNode = new Node(x);
            tmp.neste = nyNode;
            nyNode.neste = nySinNeste;
            return;
          }
          tmp = tmp.neste;
        }//er ved enden av lista
        tmp.neste = new Node(x);
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
    Node peker = start.neste;
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

      Node pekersjekk = start;
      for (int i = 0; i < pos; i++){
        pekersjekk = pekersjekk.neste;
      }
      if (pekersjekk == null){
        throw new UgyldigListeIndeks(pos);
      }
      else{

  Node peker = start;
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


    Node nyNode = new Node(x);

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
    Node peker = start;
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

    Node peker = start;
    for (int i = 0; i < (pos); i++){
      peker = peker.neste;
    }
    if (peker == null){
      throw new UgyldigListeIndeks(pos);
    }
    else{

    Node peker1 = start;

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

    Node peker2 = start;
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
