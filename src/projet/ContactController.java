/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DALI
 */
public class ContactController implements Initializable {

     @FXML
    private Button btnNext;

    @FXML
    private TextField email;

    @FXML
    private TextField fcb;

    @FXML
    private TextField linkedin;

    @FXML
    private TextField loc;

    @FXML
    private TextField tel;
     @FXML
    private TextField statut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(ActionEvent event) throws IOException {
        String Tel=tel.getText();
        String Email=email.getText();
        String Localisation=loc.getText();
        String Fcb=fcb.getText();
        String Linkedin=linkedin.getText();
        String Statut=statut.getText();
        cv CV=new cv();
        CV.setEmail(Email);
        CV.setFcb(Fcb);
        CV.setLinkedin(Linkedin);
        CV.setLocalisation(Localisation);
        CV.setTel(Tel);
        CV.setStatut(Statut);
        Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
             try {
    // Step 4
    Parent root = FXMLLoader.load(getClass().getResource("about_me.fxml"));
    // Step 5
    stage.setUserData(CV);
    // Step 6
    Scene scene = new Scene(root);
    stage.setScene(scene);
    // Step 7
    stage.show();
  } catch (IOException e) {
    System.err.println(String.format("Error: %s", e.getMessage()));
  }               
        
    }
    
}
