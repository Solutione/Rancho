package org.solutione.rancho.api;


import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {

    Connection conexionMySQL = null;

    public ConnectSQL(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.mariadb.jdbc.Driver").newInstance ();
                    conexionMySQL = DriverManager.getConnection("jdbc:mariadb://35.227.82.116/rancho",
                            "root","tassadar");
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
