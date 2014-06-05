/******************************************************************************
 * Copyright (c) 2013,2014. Florian Mahon <florian@faivre-et-mahon.ch>        *
 *                                                                            *
 * This file is part of backuptools.                                          *
 *                                                                            *
 * This program is free software: you can redistribute it and/or modify       *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation, either version 3 of the License, or          *
 * any later version.                                                         *
 *                                                                            *
 * This program is distributed in the hope that it will be useful, but        *
 * WITHOUT ANY WARRANTY; without even the implied warranty of                 *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU           *
 * General Public License for more details. You should have received a        *
 * copy of the GNU General Public License along with this program.            *
 * If not, see <http://www.gnu.org/licenses/>.                                *
 ******************************************************************************/

package org.fetm.backuptools.explorer.domain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.fetm.backuptools.explorer.GUI.VaultEditorController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by florian on 27.05.14.
 */
public class App {

    private Stage primaryStage;
    private ObservableList<Vault> vaults = FXCollections.observableArrayList();
//    public static final String FOLDERNAME = "";

    public App(){

    }

    public ObservableList<Vault> getVaults() {
        return vaults;
    }


    public boolean showVaultEditor( Vault vault) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("VaultEditor.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Vault");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        VaultEditorController controller = loader.getController();

        controller.setDialogStage(dialogStage);
        controller.setVault(vault);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addNewVault() {
        Vault vault = new Vault();
        try {
            if(showVaultEditor(vault)){
                getVaults().add(vault);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void editVault(Integer index) {

        try {
            if(showVaultEditor(getVaults().get(index))){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

 /*   public void readVaultsFromFiles() {

        Properties properties = new Properties();

        String filePath = System.getProperty("user.home");

        String fileName = name + "_config.cfg";

        Path file_path = Paths.get(filePath + FileSystems.getDefault().getSeparator() + fileName);
        try {

            if (file_path.toFile().exists()) {
                properties.load(new FileInputStream(file_path.toFile()));
            } else {
                file_path.toFile().createNewFile();
            }

            properties.setProperty("name", name);
            properties.setProperty("src", "soucre");
            properties.setProperty("vault.directory", directory);

            properties.store(new FileOutputStream(file_path.toFile()), "new configuration");

        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public void writeVaultsToFiles() {


    }*/

}
