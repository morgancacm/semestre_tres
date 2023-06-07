/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.unicesar.ejemploappjavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Jairo F
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnAutobus, btnTractor, btnConsulta;
    
    @FXML
    private StackPane panel;
    
    @FXML
    private void clickAutobus(ActionEvent e) throws IOException{
        
       StackPane autobus = new StackPane(App.loadFXML("autobu"));
       this.panel.getChildren().clear();
       this.panel.getChildren().add(autobus);
    
    }
    
    @FXML
    private void clickTractor(ActionEvent e){
        
        this.panel.getChildren().clear();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Titulo");
        alert.setContentText("Mensaje de click en boton tractor");
        alert.showAndWait();
    
    }
    
    @FXML
    private void clickConsulta(ActionEvent e){
        

    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
