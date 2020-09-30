//superklassen resept som tar inn legemid objekt, lege objekt, pasientid og reit
 public abstract class Resept{

   static int antResept = 0;

   int reseptID;
   Legemiddel legemiddel;
   Lege utskrivendeLege;
   int pasientId;
   int reit;

   public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {

     this.legemiddel = legemiddel;
     this.utskrivendeLege = utskrivendeLege;
     this.pasientId = pasientId;
     this.reit = reit;

//respt id teller:
     reseptID = antResept;
     antResept += 1;


   }

   public int hentId(){
     return reseptID;
   }

   public Legemiddel hentLegemiddel(){
     return legemiddel;
   }

   public Lege hentLege(){
     return utskrivendeLege;
   }

   public int hentReit(){
     return reit;
   }

   public int hentPasientId(){
     return pasientId;
   }



   public boolean bruk(){
     if (reit > 0){
       return true;
     }
     else {
       return false;
     }
   }


//abstrakte metoder som ikke kan ha body fordi de er abstrakte
   abstract public String farge();

   abstract public Double prisAaBetale();

 }
