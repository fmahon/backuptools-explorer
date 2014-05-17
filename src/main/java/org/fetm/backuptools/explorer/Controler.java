package org.fetm.backuptools.explorer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Admin on 17.05.14.
 */
public class Controler {
    @FXML
    Button btAdd;
    @FXML
    TextField vaultName;

    @FXML
    public void onClick(){
        vaultName.setText("Hello");
    }

}
