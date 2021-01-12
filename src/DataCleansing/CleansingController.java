package DataCleansing;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CleansingController extends Cleansing implements Initializable {
    @FXML private TextField inputSerialNum;
    @FXML private TextField inputModel;
    @FXML private ComboBox<String> cboEmployee;
    @FXML private TextArea inputComment;
    @FXML private Text txtMachineSerial;
    @FXML private Text txtEmployee;
    @FXML private Pane cleaningCheckBoxes;
    @FXML private TextField inputHDDSerial;
    @FXML private CheckBox chNoHdd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cboEmployee.setItems(FXCollections.observableList(getEmployees()));
    }

    public void btnReset(ActionEvent actionEvent) {
        reload();
    }

    public void btnStartCleansing(ActionEvent actionEvent) {
        Alert alert = new Alert( Alert.AlertType.WARNING);
        if (inputSerialNum.getText().equals("")){
            alert.setHeaderText( "No serial number is entered" );
            alert.show();
        }
        else if(inputModel.getText().equals("")){
            alert.setHeaderText( "No model name is entered" );
            alert.show();
        }
        else if(cboEmployee.getValue() == null){
            alert.setHeaderText( "Choose an employee" );
            alert.show();
        }
        else{
            //enable checkboxes en HDD textfield
            cleaningCheckBoxes.setDisable( false );
            inputHDDSerial.setEditable( true );
            txtMachineSerial.setText(inputSerialNum.getText());
            txtEmployee.setText(cboEmployee.getValue());
        }
    }

    public void chNoHdd(ActionEvent actionEvent) {
        if (chNoHdd.isSelected()){
            inputHDDSerial.setText("NO HDD");
            inputHDDSerial.setDisable(true);
        }
        else{
            inputHDDSerial.setText("");
            inputHDDSerial.setDisable(false);
        }
    }

    public void save(ActionEvent actionEvent) {
        if (stepsFinalcontrol()){
            String serialNum = inputSerialNum.getText();
            String model = inputModel.getText().toUpperCase();
            String employeeName = cboEmployee.getValue();
            String comment = inputComment.getText();
            String serialHDD = inputHDDSerial.getText().toUpperCase();

            //sla gegevens op
            cleansed(serialNum,model, employeeName, comment,serialHDD, true);

            reload();
        }
    }

    public boolean stepsFinalcontrol() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Can not be saved!");

        //loop door alle checkboxes, als allemaal niet is gechekeched return false
        for (int i = 0; i < cleaningCheckBoxes.getChildren().size(); i++) {
            CheckBox cb = (CheckBox) cleaningCheckBoxes.getChildren().get(i);
            if (!cb.isSelected()) {
                alert.setContentText("The erasing steps are not compleet.");
                alert.show();
                return false;
            }
        }
        //controleer de HDD serialnummer is ingevoerd
        if ((inputHDDSerial.getText()) =="" && !chNoHdd.isSelected()) {
            alert.setContentText( "The HDD Serial Number is empty." );
            alert.show();
            return false;
        }
        return true;
    }

    public void backToDashboard(ActionEvent actionEvent) {
        Parent report = null;
        try {
            report = FXMLLoader.load( getClass().getResource( "FXML/FXMLDashboard.fxml" ) );
            Scene reportScene = new Scene( report );

            //get Stage -> set scene Cleansing -> laten zien
            Stage window = (Stage) ( (Node)actionEvent.getSource() ).getScene().getWindow();
            window. setScene( reportScene );
            window.show();
        } catch (IOException e) {
            System.out.println("Error cant load Dashboard");
        }
    }

    public void reload() {
        //haal de stage op waar 'cboSerialnum' zich bevindt (mag ook andere element zijn op de scene)
        Stage window = (Stage) inputSerialNum.getScene().getWindow();
        window.close();

        Parent report = null;
        try {
            report = FXMLLoader.load( getClass().getResource( "FXML/FXMLCleansing.fxml" ) );
        } catch (IOException e) {
            System.out.println("Error");
        }
        Scene reportScene = new Scene( report );
        window. setScene( reportScene );
        window.show();
    }
}