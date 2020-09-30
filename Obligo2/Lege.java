//klassen lege som tar inn parameter for navn og har en funksjon som returnerer navnet
public class Lege{

  String legeNavn;

  public Lege(String navn){
    this.legeNavn = navn;
  }


  public String hentLegeNavn(){
    return legeNavn;
  }
}
