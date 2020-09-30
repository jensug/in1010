//Jeg har hat feber i hele dag og klarte derfor ikke å fullføre oppgaven.
//Selvom jeg har hatt en del til til å gjøre den har jeg utsatt masse.
//Så det er ikke vits å se på koden tror jeg, men hvis jeg kan få en liten utsettelse hadde det hjulpet veldig.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class LabyrintLoser extends Application {

    @Override
    public void start(Stage primaryStage) {

        LabyrintGUI gui = new LabyrintGUI(primaryStage);
        LabyrintController controller = new LabyrintController(primaryStage, gui);

        Scene scene = new Scene(gui.getRot());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Labyrint løser");
        primaryStage.show();
    }
}
