package ubc.cs304.team64.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ubc.cs304.team64.model.Facility;
import ubc.cs304.team64.model.Member;
import ubc.cs304.team64.util.FXMLLoaderWrapper;


import java.net.URL;
import java.util.ResourceBundle;

import static ubc.cs304.team64.ui.Main.updateStage;

public class DeleteController implements Initializable {

    @FXML
    private Label description;

    @FXML Button back, yesDelete, noDelete;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setUp(Facility facility,Member member) {
        back.setOnAction(e -> MyAccountController.setStage(facility, member));
        noDelete.setOnAction(e -> MyAccountController.setStage(facility, member));
        yesDelete.setOnAction(e -> delete(member));
        String personalOutput = new StringBuilder()
                .append("Are you sure you wuld like to delete you account?  This will ,\n")
                .append("deregister you from all classes and delete your personal data., \n")
                .append(" Your will lose access to all facilities immediately.")
                .toString();
        description.setText(personalOutput);

    }

    public void delete(Member member) {
        Main.connectionHandler.deleteMember(member);
        updateStage(new FXMLLoaderWrapper<>("Login.fxml").getScene(), "Login");
    }




    static void setStage(Member member, Facility facility){
        FXMLLoaderWrapper<DeleteController> loader = new FXMLLoaderWrapper<>("deleteAccount.fxml");
        loader.getController().setUp(facility, member);
        updateStage(loader.getScene(), "GreaterVan Fitness");
    }



}