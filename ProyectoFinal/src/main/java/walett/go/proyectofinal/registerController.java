/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package walett.go.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * * @author Jorman Noriega, Julio Rios, Andres Contreras, Sergio Arango
 */
public class registerController implements Initializable {

    private Hyperlink linkSesion;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtUsuario, txtEmail;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private StackPane stackpaneRegistar;

    @FXML
    public void clickSesion(ActionEvent a){
//        StackPane login = new StackPane(App.loadFXML("login"));
//        this.stackpaneRegistar.getChildren().clear();
//        this.stackpaneRegistar.getChildren().add(login);
    }

    @FXML
    public void clickRegistrar(ActionEvent a) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
