import java.util.ArrayList;

//jeg lager klassen Node med en konstruktør som tar imot minnestorrelse og prosessorantall

  public class Node{


    Integer minnestorrelse;
    Integer prosessorantall;

    public Node(Integer m, Integer p){
        minnestorrelse = m;
        prosessorantall = p;
    }


//Node-klassen har en metode som gir tilgang til prosessorantall
    public int antProsessorerNode(){
      return prosessorantall;
    }

//og en metode som forteller om noden har et mere minne enn oppgitt minne i parametere, eller om det ikke har.
    public boolean nokMinne(Integer paakrevdMinne){
      if (minnestorrelse >= paakrevdMinne){
        return true;
      }
      else{
        return false;
      }

    }

  }
