package multipage.form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import multipage.Main;
import multipage.Subject;

public class Controller {
    public TextField txtCode;
    public TextField txtName;
    public TextField txtHour;

    @FXML
    ListView<Subject> lv;
    public Text errors;

    public ObservableList<Subject> subjectList = FXCollections.observableArrayList();

    public void submitS(){
       try {
           Integer hour = Integer.parseInt(txtHour.getText());
           errors.setVisible(false);
           if (txtHour.getText().isEmpty() || txtCode.getText().isEmpty() || txtName.getText().isEmpty() || hour < 0){
               throw new Exception("Vui long nhap day du thong tin");
           }
           updateSubject();
           lv.setItems(subjectList);
           lv.refresh();

           } catch (Exception e){
           errors.setText(e.getMessage());
           errors.setVisible(true);
       }

    }

    public void updateSubject(){
        Integer hour = Integer.parseInt(txtHour.getText());
        for(Subject m : subjectList){
            if (m.getCode().equals(txtCode.getText())){

                return;
            }
        }
        subjectList.add(new Subject(txtCode.getText(), txtName.getText(), hour));
    }


    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene  = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Danh sach mon hoc");
        Main.rootStage.setScene(listScene);


    }
}
