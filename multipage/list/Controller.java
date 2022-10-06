package multipage.list;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import multipage.Main;
import multipage.Subject;

public class Controller {




    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/form.fxml"));
        Scene listScene  = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Them mon hoc");
        Main.rootStage.setScene(listScene);


    }
}
