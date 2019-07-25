package org.solutione.rancho;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQL {

    private String ip = "35.227.82.116";
    private String puerto = "3306";
    private String baseDatos = "rancho";
    private String user = "root";
    private String password = "tassadar";

    public ConnectSQL(){
        Connection conexionMySQL = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance ();
            //conexionMySQL = DriverManager.getConnection("jdbc:mariadb://" + ip + ":" + puerto + "/" + baseDatos+"?user="+user+"&password="+password);
            conexionMySQL = DriverManager.getConnection("jdbc:mariadb://35.227.82.116:3306/rancho?user=root&password=tassadar");

            Statement stmt = conexionMySQL.createStatement();
            ResultSet rs = stmt.executeQuery("CREATE TABLE prueba;");
            rs.first();
            conexionMySQL.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
