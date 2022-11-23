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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;




public class About_meController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextArea about;

    @FXML
    void affiche(ActionEvent event) {
         Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
  // Step 2
         cv CV = (cv) stage.getUserData();
         CV.setDescription(about.getText());
         System.out.print(CV);
         stage.close();
      try {
    // Step 4
    Parent root = FXMLLoader.load(getClass().getResource("Experience_prof.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
