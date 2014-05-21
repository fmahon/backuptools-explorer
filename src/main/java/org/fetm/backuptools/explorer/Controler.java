package org.fetm.backuptools.explorer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

public class Controler {
    @FXML
    Button btAdd;
    @FXML
    TextField vaultName;
    @FXML
    TextField vaultPass;
    @FXML
    TextField vaultHost;
    @FXML
    TextField vaultUser;
    @FXML
    TextField vaultDirectory;


    @FXML
    public void onClick(){
        String name = vaultName.getText();
        String host = vaultHost.getText();
        String pass = vaultPass.getText();
        String directory = vaultDirectory.getText();
        vaultName.setText("Hello");
    }

}
