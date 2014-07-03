package org.fetm.backuptools.explorer.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import org.fetm.backuptools.common.BackupAgentFactory;
import org.fetm.backuptools.common.VaultConfiguration;
import org.fetm.backuptools.common.model.Backup;
import org.fetm.backuptools.explorer.domain.App;

import java.io.IOException;
import java.util.List;

/******************************************************************************
 * Copyright (c) 2014. Richard Breguet <richard.breguet@gmail.com>            *
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

public class MainLayoutController{
    private App app;

    @FXML
    public ListView listview;

    @FXML
    public ListView backuplist;

    @FXML
    public TreeView backuptree;

    @FXML
    public void onClickAddVault() throws IOException {
        app.addNewVault();
    }

    @FXML
    public void onClickEditVault() throws IOException {
        app.editVault(listview.getSelectionModel().getSelectedIndex());
        app.reloadConfigurationFiles();
    }

    public void init(){
        listview.setItems(app.getVaultConfigurations());

        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VaultConfiguration>() {
            @Override
            public void changed(ObservableValue<? extends VaultConfiguration> observableValue, VaultConfiguration vaultConfiguration, VaultConfiguration newConfiguration) {
               if (newConfiguration != null) {
                   app.setCurrentVault(newConfiguration);
               }
            }
        });


        backuplist.setItems(app.getBackups());
        backuplist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Backup>() {
            @Override
            public void changed(ObservableValue<? extends Backup> observableValue, Backup backup, Backup newBackup) {
                app.setCurrentBackup(newBackup);
                backuptree.setRoot(app.buildTreeViewCurrentBackup());
            }
        });

    }

    public void setApp(App app){
        this.app = app;
        init();
    }

}
