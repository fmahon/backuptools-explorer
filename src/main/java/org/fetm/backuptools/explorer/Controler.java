package org.fetm.backuptools.explorer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

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
    public void onClickLoad(){


    }


    @FXML
    public void onClick(){

/*
        name            = backup for testing

        # directory for backup
        src             = /home/source

        # choice your destination
        vault.directory = /home/backup

        #if you use the sftp declare type and complete
        #the credential information.

        # Type of destination use sftp or dir
        vault.type         = sftp
        vault.ssh.host     = localhost
        vault.ssh.user     = username
        vault.ssh.password = password
*/


        String name = vaultName.getText();
        String host = vaultHost.getText();
        String pass = vaultPass.getText();
        String directory = vaultDirectory.getText();


        Properties properties = new Properties();

        String filePath = System.getProperty("user.home");
        String fileName = name + "_config.cfg";
        Path file_path = Paths.get(filePath + FileSystems.getDefault().getSeparator() + fileName);
        try {

            //if(file_path.toFile().exists()) {
            //    properties.load(new FileInputStream(file_path.toFile()));
            //}else{
                file_path.toFile().createNewFile();
            //}

            properties.setProperty("name", name);
           // properties.setProperty("src","soucre");
            properties.setProperty("vault.directory", directory);

            properties.store(new FileOutputStream(file_path.toFile()),"new configuration");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
