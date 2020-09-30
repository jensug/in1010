
//Klassen Hovedprogram inneholder main konstruktøren
public class Hovedprogram {
    public static void main(String[] args) {

//Her lager jeg regneklyngen abel som tar i mot en tekstfil
      Regneklynge abel = new Regneklynge("regneklynge.txt");



//Så printes verdiene ut ved hjelp av metodene noderMedNokMinne, antProsessorer og antRacks.
      System.out.println("Noder med minst 32 GB:" + abel.noderMedNokMinne(32));
      System.out.println("Noder med minst 64 GB:" + abel.noderMedNokMinne(64));
      System.out.println("Noder med minst 128 GB:" + abel.noderMedNokMinne(128));
      System.out.println("");
      System.out.println("Antall prosessorer:" + abel.antProsessorer());
      System.out.println("Antall racks:" + abel.antRacks());



    }

}
