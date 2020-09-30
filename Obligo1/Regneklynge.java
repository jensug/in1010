import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//Jeg lager en regneklynge klasse som har en konstruktør som tar i mot et filnavn
public class Regneklynge{

  public int maksNoder;
  public String fil;


//klassen Regneklynge er en liste eller en samling av Rack objekter.
//Her har jeg brukt ArrayList istede for array fordi en arraylist kan samle Objekter av en gitt klasse
  ArrayList<Rack> regneklynge = new ArrayList<Rack>();

  public Regneklynge (String fil){

    this.fil = fil;

//jeg starter med å ta imot filen
    File f = new File(fil);


  //Proever aa hente inn filnavnet
    Scanner filleser = null;
    try {
      filleser = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("Fant ikke filen!");
    }

//hvis den finner filen,
      String linje = "";

//jeg har en linje index variabel for å holde rede på hvilken linje i filen jeg er på
      int linjeIndex = 0;

    //while løkken går gjennom linjene i filen
      while(filleser.hasNextLine()) {
//og for hver linje i filen så settes innholde i linjen til variabelen linje.
        linje = filleser.nextLine();

//den første linjen i filen (som har index 0) representerer maks antallnoder:
        if (linjeIndex == 0){
          maksNoder = Integer.parseInt(linje);
        }
//DE andre linjene har 3 forskjellige verdier jeg vill ha som skilles med mellomrom
        else {

          String[] delt = linje.split(" ");

//Her setter jeg verdiene fra filen til egne variabler så jeg kan bruke dem når jeg lager et nytt Node objekt
          int antallNoderLokal = Integer.parseInt(delt[0]);
          int MinnePerNodeLokal = Integer.parseInt(delt[1]);
          int antallProssessorerPerNodeLokal = Integer.parseInt(delt[2]);


//den følgene koden pleide å være i Hovedprogrammet før oppgave E
//Jeg bruker en for setning for å gjenta skapelsen av ny node et gitt antall ganger
          for (int i = 0; i < antallNoderLokal; i++){
            //Det nye node objektet tar i mot verdiene fra filen
            Node nynode = new Node(MinnePerNodeLokal, antallProssessorerPerNodeLokal);

//den følgende koden pleiede å være en egen metode kalt "nyNode" men kunne implementeres
//direkte inn i innlesningen fra filen fordi denne informasjonen blir lest av i regneklynge
//klassen, fra Hovedprogrammet som det tidligere gjorde.
        //hvis regneklynge ikke har noen racks, lager den en ny rack, og legger den nye noden der
            if (regneklynge.size()< 1)
            {
              Rack nyrack = new Rack(maksNoder);
              nyrack.leggTilNode(nynode);
              regneklynge.add(nyrack);
            }
    //hvis den har en eller flere racks, så går den gjennom regneklyngen og sjekker hvilken av listene som har plass og legger så til noden
            else
            {
              boolean ikkeLagtTil = true;
              for (Rack racken : regneklynge) {
                if (racken.plass(maksNoder)){
                  racken.leggTilNode(nynode);
                  ikkeLagtTil = false;
                }
            }
            //hvis det finnes racks, men ingen har plass, lager den også en ny rack og plaserer noden der
            if (ikkeLagtTil){
              Rack nyrack = new Rack(maksNoder);
              nyrack.leggTilNode(nynode);
              regneklynge.add(nyrack);
              }
            }


          }

        }
//denne setningen holder rede på linje indexen i filen:
        linjeIndex += 1;

      }


  }


//Dette var slike man lagde en ny node før oppgave E
/*
  public void nyNode(Node nynode){

    if (regneklynge.size()< 1)
    {
      Rack nyrack = new Rack(maksNoder);
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
      Rack nyrack = new Rack(maksNoder);
      nyrack.leggTilNode(nynode);
      regneklynge.add(nyrack);
      }
    }
 }
*/


//metoden antProsessorer går gjennom klyngen og samler antallProssessorer med rack metoden for å telle prosessorer
    public int antProsessorer(){
      int antallProssessorer = 0;
      for (Rack racken : regneklynge){
        antallProssessorer = antallProssessorer + racken.antProsessorerRack();
      }
      return antallProssessorer;
    }


//antall racks metoden går gjennom klyngen og teller hvor mange racks den har
    public int antRacks(){
      int antallRacks = 0;
      for (Rack racken : regneklynge){
        antallRacks +=1;
      }
      return antallRacks;
    }

//Noder med nok minne sjekkes på samme måte som ant prosessorer.
    public int noderMedNokMinne(int paakrevdMinne){
        int sammenlagtAntNoder = 0;
        for (Rack racken : regneklynge){
          sammenlagtAntNoder += racken.noderMedNokMinnee(paakrevdMinne);

        }
        return sammenlagtAntNoder;

    }

  }
