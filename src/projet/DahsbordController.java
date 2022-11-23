/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projet;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DALI
 */
public class DahsbordController implements Initializable {

    @FXML
    private Button btnCreation;
    @FXML
    private ImageView img_img;

    @FXML
    private Button upload;

    @FXML
    void change(ActionEvent event)throws IOException {
        FileChooser chooser=new FileChooser();
        FileChooser.ExtensionFilter exxFilterJPG=new FileChooser.ExtensionFilter("JPG files (*.jpg)","*.JPG");
        FileChooser.ExtensionFilter exxFilterPNG=new FileChooser.ExtensionFilter("PNG files (*.png)","*.PNG");
        chooser.getExtensionFilters().addAll(exxFilterJPG,exxFilterPNG);
        File file=chooser.showOpenDialog(null);
        BufferedImage bufferedimg=ImageIO.read(file);
        WritableImage image=SwingFXUtils.toFXImage(bufferedimg,null); 
        img_img.setImage(image);
    }
    @FXML
    void creation(ActionEvent event) throws IOException  {
        JOptionPane.showMessageDialog(null,"Next");
        btnCreation.getScene().getWindow().hide();
                      
                  btnCreation.getScene().getWindow().hide();
                      
                  Parent  a = FXMLLoader.load(getClass().getResource("Contact.fxml"));
                  Scene scene=new Scene(a);
                  Stage stage=new Stage();
                  stage.setScene(scene);
                  stage.setTitle("contact");
                  stage.show();

    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
