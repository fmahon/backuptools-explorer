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

package org.fetm.backuptools.explorer.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fetm.backuptools.common.VaultConfiguration;

/**
 * Created by florian on 27.05.14.
 */
public class VaultEditorController {
    private Stage dialogStage;
    private boolean okClicked;
    private VaultConfiguration vaultConfiguration;

    @FXML TextField vaultName;
    @FXML TextField vaultPass;
    @FXML TextField vaultHost;
    @FXML TextField vaultUser;
    @FXML TextField vaultDirectory;
    @FXML TextField vaultLocation;
    @FXML ComboBox vault_type;

    public void onClickOk(){
        setOkClicked(true);
        dialogStage.close();
    }

    @FXML
    public void onClickCancel(){
        setOkClicked(false);
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        vaultConfiguration.setName(vaultName.getText());
        vaultConfiguration.setLocation(vaultLocation.getText());
        vaultConfiguration.setDirectory(vaultDirectory.getText());
        vaultConfiguration.setPass(vaultPass.getText());
        vaultConfiguration.setHost(vaultHost.getText());
        vaultConfiguration.setUser(vaultUser.getText());
        vaultConfiguration.setVaultType((String)vault_type.getValue());
        return okClicked;
    }

    public void setOkClicked(boolean okClicked) {
        this.okClicked = okClicked;
    }


    public void setVaultConfiguration(VaultConfiguration vaultConfiguration) {
        this.vaultConfiguration = vaultConfiguration;
        vaultName.setText(vaultConfiguration.getName());
        vaultLocation.setText(vaultConfiguration.getLocation());
        vaultDirectory.setText(vaultConfiguration.getDirectory());
        vaultPass.setText(vaultConfiguration.getPass());
        vaultHost.setText(vaultConfiguration.getHost());
        vaultUser.setText(vaultConfiguration.getUser());
        vault_type.getItems().add(VaultConfiguration.TYPE_DIR);
        vault_type.getItems().add(VaultConfiguration.TYPE_SFTP);
        vault_type.setValue(vaultConfiguration.getVaultType());
    }
}
