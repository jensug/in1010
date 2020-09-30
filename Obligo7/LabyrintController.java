import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class LabyrintController {
    LabyrintGUI gui;
    Stage stage;

    public LabyrintController(Stage stage, LabyrintGUI gui) {
      this.gui = gui;
      this.stage = stage;
      VelgFraFilEvent fraFilAction = new VelgFraFilEvent();
      gui.hentButton().setOnAction(fraFilAction);

    }



    class VelgFraFilEvent implements EventHandler<ActionEvent> {

      public void handle(ActionEvent event){
        FileChooser filVelger = new FileChooser();

        filVelger.setInitialDirectory(new File("."));
        File fil = filVelger.showOpenDialog(stage);
        if (fil == null) { return; }

        Labyrint l = null;
        try{
          l = l.lesFraFil(fil);
          gui.settLabyrint(l);
        } catch(FileNotFoundException e) {
          e.printStackTrace();
          return;
            }

      }
    }

}
