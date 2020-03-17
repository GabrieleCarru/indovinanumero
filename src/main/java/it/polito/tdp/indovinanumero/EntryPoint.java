package it.polito.tdp.indovinanumero;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.indovinanumero.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {
	

    @Override
    public void start(Stage stage) throws Exception {
    	
    	// qui è il luogo giusto dove creare il nuovo modello!
    	Model model = new Model();
    	FXMLController controller;
    	
    	// andiamo a recuperare un riferimento (un puntatore?) al controller che ci serve altrimenti non potremmo settarlo
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	
    	// ora possiamo ottenere il riferimento direttamente dal Loader
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
    	// settiamo il controller sul modello interessato
        controller = loader.getController();
    	controller.setModel(model);
    	

        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
