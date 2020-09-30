import java.util.ArrayList;


//Jeg lager klassen Rack med en konstruktør som tar i mot maksNoder per rack
public class Rack {

//Et Rack objekt består av en liste eller en samling av noder.
//Her bruker jeg Arraylist fordi den kan samle objekter i motsetning til vanlige arrays.
  ArrayList<Node> rack = new ArrayList<Node>();


  public int maksNoder;

  public Rack(Integer maksNoder) {
    this.maksNoder = maksNoder;

  }

//klassen rack har en metode plass som sjeker om størrelsen på racken er mindre enn den
// publice variabelen maksnoder (som ligger i regneklynge.java) og returnerer true eller false
    public boolean plass( int maksNoder){
            if (rack.size() < maksNoder){
              return true;
            }
            else {
              return false;
            }
          }


//Rack objekter har også en metode leggTilNode som gjør det mulig å legge til et Node Objekt hvor Node objektet er opgitt i parameteret
      public void leggTilNode(Node node){
        rack.add(node);
        }

//En metode som går gjennom rack listen og teller hvor mange prosessorer som er i racken til sammen
      public int antProsessorerRack(){
        int antallProssessorer = 0;
        for (Node noden : rack){
          antallProssessorer = antallProssessorer + noden.antProsessorerNode();
        }
        return antallProssessorer;
      }

//og til slutt en metode som sjekker hvor mange noder denne racken inneholder som har en angitt (i parameteret) mengde minne
    public int noderMedNokMinnee(Integer paakrevdMinne){
      int sammenlagtAntNoderPaakrevd = 0;
        for (Node noden : rack){

          if (noden.nokMinne(paakrevdMinne)){
            sammenlagtAntNoderPaakrevd += 1;
          }
    }
    return sammenlagtAntNoderPaakrevd;
  }

}
