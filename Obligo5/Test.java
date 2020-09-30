import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test{

public static void main(String[] args) {


  File fil = new File("3.in");
  Labyrint l = null;
  l = l.lesFraFil(fil);

  l.skrivUt();
  for (String melding : l.finnUtveiFra(3,5)){
    System.out.println(melding + "\n");

  }

}

}
