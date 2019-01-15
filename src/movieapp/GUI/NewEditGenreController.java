/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import movieapp.BE.Category;

/**
 * FXML Controller class
 *
 * @author kedde
 */
public class NewEditGenreController implements Initializable {
    movieapp.GUI.CategoryModel categoryModel;
    movieapp.GUI.MainWindowController mainWindowController;
    int type;
    private Category selectedGenre;
    @FXML
    private TextField genreName;
    @FXML
    private Button NewEditBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newEditGenre(ActionEvent event) throws SQLException {
        Stage stage = (Stage) NewEditBtn.getScene().getWindow();
        switch(type) {
            case 1:
                categoryModel.newGenre(genreName.getText());
                mainWindowController.reload();
                stage.close();
                break;
            case 2:
                selectedGenre.setGenre(genreName.getText());
                categoryModel.editGenre(selectedGenre);
                mainWindowController.reload();
                stage.close();
                break;
            default:
                System.out.println("Something went wrong");
                stage.close();
                break;
        }
    }
    
    public void setCategoryModel(CategoryModel categoryModel)
    {
        this.categoryModel = categoryModel;
    }
    
    public void setMainWindowController(MainWindowController mainWindowControler)
    {
        this.mainWindowController = mainWindowControler;
    }
    
    public void setEdit(Category selectedGenre) {
        type = 2;
        genreName.setText(selectedGenre.getGenre());
    }
    
    public void setNew() {
        type = 1;
    }
    
    public void setGenre(Category selectedCategory)
    {
        this.selectedGenre = selectedCategory;
    }
}
