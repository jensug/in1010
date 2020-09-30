import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class LabyrintGUI {

    private Stage stage;
    private BorderPane rot;

    Button velgFraFil;
    Labyrint labyrint = null;
    GridPane labyrintPane;

    public LabyrintGUI (Stage stage){
      this.stage = stage;
      this.rot = new BorderPane();


      velgFraFil = new Button("Last inn fil:");

      VBox meny = new VBox(velgFraFil);
      rot.setRight(meny);


    }



    public void settLabyrint(Labyrint labyrint){
      labyrintPane = new GridPane();
      rot.setCenter(labyrintPane);

      this.labyrint = labyrint;
      GUIRute[][] ruter = new GUIRute[labyrint.rader][labyrint.kolonner];
      Rute[][] labyrintRuter = labyrint.ruter;
      for (int rad = 0; rad < labyrint.rader; rad++){
        for (int kol = 0; kol < labyrint.kolonner; kol++){
          char tegn = labyrintRuter[rad][kol].tilTegn();
          ruter[rad][kol] = new GUIRute(tegn, labyrint, rad, kol, ruter, this);
          labyrintPane.add(ruter[rad][kol], kol, rad);
        }
      }
    }


    public BorderPane getRot(){
      return rot;
    }

    public Button hentButton(){
      return velgFraFil;
    }



    public GridPane lagLabyrintGrid(Labyrint labyrint){
      return null;
    }
}

class GUIRute extends Rectangle{
  boolean erHvit = false;
  boolean erUtvei = false;
  GUIRute[][] ruter;
  int rad;
  int kol;
  Labyrint labyrint;

  public GUIRute(char tegn, Labyrint labyrint, int rad, int kol, GUIRute[][] ruter, LabyrintGUI gui){
    this.ruter = ruter;
    this.rad = rad;
    this.kol = kol;
    this.labyrint = labyrint;

    if (tegn == '.'){
      erHvit = true;
      setFill(Color.WHITE);
    } else if (tegn == '#'){
      setFill(Color.BLACK);
    }
    setWidth(30);
    setHeight(30);
    setStroke(Color.WHITE);
    setStrokeWidth(1);

      if(erHvit){

        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
              Liste<String> utveier = labyrint.finnUtveiFra(kol, rad);
              Text antLosninger = new Text("Antall løsninger: " + utveier.stoerrelse());
              gui.getRot().setBottom(antLosninger);
              if(utveier.stoerrelse() == 0){
                reset();
                return;
              }
              String utvei = utveier.hent(0);
              boolean[][] losning = losningStringTilTabell(utvei, labyrint.kolonner, labyrint.rader);

              reset();
//finner utvei
                for (int rad = 0; rad < labyrint.rader; rad++){
                  for (int kol = 0; kol < labyrint.kolonner; kol++){
                    if(losning[rad][kol]){
                      ruter[rad][kol].setFill(Color.BLUE);
                    }
                  }
                }

            }
        });
      }
    }

    /**
     * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
     * av losningstien.
     * @param losningString String-representasjon av utveien
     * @param bredde        bredde til labyrinten
     * @param hoyde         hoyde til labyrinten
     * @return              2D-representasjon av rutene der true indikerer at
     *                      ruten er en del av utveien.
     */
    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            losning[y][x] = true;
        }
        return losning;
    }


    public void reset(){
      for (int rad = 0; rad < labyrint.rader; rad++){
        for (int kol = 0; kol < labyrint.kolonner; kol++){
          if(ruter[rad][kol].erHvit){
            ruter[rad][kol].setFill(Color.WHITE);
          }
        }
      }
    }

}
