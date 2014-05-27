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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fetm.backuptools.explorer.domain.Vault;

/**
 * Created by florian on 27.05.14.
 */
public class VaultEditorController {
    private Stage dialogStage;
    private boolean okClicked;
    private Vault vault;

    @FXML TextField vaultName;
    @FXML TextField vaultPass;
    @FXML TextField vaultHost;
    @FXML TextField vaultUser;
    @FXML TextField vaultDirectory;

    @FXML
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
        vault.setName(vaultName.getText());
        vault.setDirectory(vaultDirectory.getText());
        vault.setPass(vaultPass.getText());
        vault.setHost(vaultHost.getText());
        vault.setUser(vaultUser.getText());
        return okClicked;
    }

    public void setOkClicked(boolean okClicked) {
        this.okClicked = okClicked;
    }


    public void setVault(Vault vault) {
        this.vault = vault;
        vaultName.setText(vault.getName());
        vaultDirectory.setText(vault.getDirectory());
        vaultPass.setText(vault.getPass());
        vaultHost.setText(vault.getHost());
        vaultUser.setText(vault.getUser());
    }
}
