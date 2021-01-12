package DataCleansing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    @FXML private TableView<MachineCleansingDetail> tableView;
    @FXML private TableColumn<MachineCleansingDetail, String> columnSerial;
    @FXML private TableColumn<MachineCleansingDetail, String> columnModel;
    @FXML private TableColumn<MachineCleansingDetail, String> columnEmployee;
    @FXML private TableColumn<MachineCleansingDetail, String> columnHDDSerial;
    @FXML private TableColumn<MachineCleansingDetail, String> columnComment;
    @FXML private TableColumn<MachineCleansingDetail, String> columnStatus;
    @FXML private TableColumn<MachineCleansingDetail, String> columnLastUpdated;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize columns
        columnSerial.setCellValueFactory(new PropertyValueFactory<>("serialNum"));
        columnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        columnEmployee.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        columnComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        columnHDDSerial.setCellValueFactory(new PropertyValueFactory<>("serialHDD"));
        columnLastUpdated.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("cleansed"));

        //maak object machineList aan
        MachineList machineList = new MachineList();

        //zet de MachineLijst om in observablelist (voor javafx tableview)
        ObservableList<MachineCleansingDetail> machinesobservableList = FXCollections.observableList(machineList.getMachineList());

        //zet observablelist in de tableview
        tableView.setItems(machinesobservableList);
    }

    public void backToDashboard(ActionEvent actionEvent) throws IOException {
        Parent report = FXMLLoader.load( getClass().getResource( "FXML/FXMLDashboard.fxml" ) );
        Scene reportScene = new Scene( report );
        //get Stage -> set scene Cleansing -> laten zien
        Stage window = (Stage) ( (Node)actionEvent.getSource() ).getScene().getWindow();
        window. setScene( reportScene );
        window.show();
    }


}
