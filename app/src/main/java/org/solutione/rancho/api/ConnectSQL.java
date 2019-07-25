package org.solutione.rancho.api;


import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL {

    private Connection conexionMySQL = null;
    public static int CLOSE = 0;
    public static int NOCLOSE = 1;

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

    public Connection getConnection(){
        return conexionMySQL;
    }

    public void setData(final String query){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement stmt = conexionMySQL.createStatement();
                    stmt.executeQuery(query);
                    conexionMySQL.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setData(final String query, final int status){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement stmt = conexionMySQL.createStatement();
                    stmt.executeQuery(query);
                    if(status==ConnectSQL.CLOSE)
                        conexionMySQL.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
