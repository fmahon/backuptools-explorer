package org.fetm.backuptools.explorer.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.fetm.backuptools.explorer.domain.App;

import java.io.IOException;

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

public class MainLayoutController {
    private App app;

    @FXML
    public ListView listview;

    @FXML
    public void onClickAddVault() throws IOException {
        app.addNewVault();
    }

    @FXML
    public void onClickEditVault() throws IOException {
        app.editVault(listview.getSelectionModel().getSelectedIndex());
    }

    public void init(){
        listview.setItems(app.getVaultConfigurations());
    }

    public void setApp(App app){
        this.app = app;
        init();
    }


}
