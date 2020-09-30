import java.util.ArrayList;

public class Regneklynge{

  static int maksNoder;
  ArrayList<Rack> regneklynge = new ArrayList<Rack>();

  public Regneklynge(Integer maksN){
    maksNoder = maksN;
  }


  public void nyNode(Node nynode){

    if (regneklynge.size()< 1)
    {
      Rack nyrack = new Rack();
      nyrack.leggTilNode(nynode);
      regneklynge.add(nyrack);
    }
    else
    {
      boolean ikkeLagtTil = true;
      for (Rack racken : regneklynge) {
        if (racken.plass(maksNoder)){
          racken.leggTilNode(nynode);
          ikkeLagtTil = false;
        }
    }
    if (ikkeLagtTil){
      Rack nyrack = new Rack();
      nyrack.leggTilNode(nynode);
      regneklynge.add(nyrack);
      }
    }
 }

    public int antProsessorer(){
      int antallProssessorer = 0;
      for (Rack racken : regneklynge){
        antallProssessorer = antallProssessorer + racken.antProsessorerRack();
      }
      return antallProssessorer;
    }


    public int antRacks(){
      int antallRacks = 0;
      for (Rack racken : regneklynge){
        antallRacks +=1;
      }
      return antallRacks;
    }


    public int noderMedNokMinne(int paakrevdMinne){
        int sammenlagtAntNoder = 0;
        for (Rack racken : regneklynge){
          sammenlagtAntNoder += racken.noderMedNokMinnee(paakrevdMinne);
          
        }
        return sammenlagtAntNoder;

    }

  }
