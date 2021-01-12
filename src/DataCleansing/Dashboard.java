package DataCleansing;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage window = primaryStage;
        Parent root = FXMLLoader.load((getClass().getResource( "FXML/FXMLDashboard.fxml" )));

        Scene scene = new Scene(root,1000,800);
        window.setTitle( "DataCleansing" );
        window.setScene(scene);
        window.show();
    }

   public void openDataCleansing(ActionEvent actionEvent) throws IOException {
        Parent report = FXMLLoader.load( getClass().getResource( "FXML/FXMLCleansing.fxml" ) );
        Scene reportScene = new Scene( report );

        //get Stage -> set scene Cleansing -> laten zien
        Stage window = (Stage) ( (Node)actionEvent.getSource() ).getScene().getWindow();
        window. setScene( reportScene );
        window.show();
    }

    public void openReport(ActionEvent actionEvent) throws IOException {
        Parent report = FXMLLoader.load( getClass().getResource( "FXML/FXMLReport.fxml" ) );
        Scene reportScene = new Scene( report );

        //get Stage -> set scene Cleansing -> laten zien
        Stage window = (Stage) ( (Node)actionEvent.getSource() ).getScene().getWindow();
        window. setScene( reportScene );
        window.show();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
