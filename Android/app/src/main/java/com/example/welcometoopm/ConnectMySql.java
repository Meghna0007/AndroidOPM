package com.example.welcometoopm;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.welcometoopm.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


    public class ConnectMySql  {
        String res = "";
        private static final String url = "jdbc:mysql://localhost:/opm";
        private static final String user = "root";
        private static final String pass = "";
        private static Connection connection;

        public static Connection getConnection()  {
            try {
                if (connection == null) {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                }
            } catch (Exception e) {
                System.out.println("Connection null");
                return connection;
            }

            return connection;

        }


        public static boolean addUser(User user) {
            try {
                Connection connection = getConnection();
                Statement st = connection.createStatement();
                String email = user.getEmail();
                String phoneNumber = user.getPhoneNumber();
                String password = user.getPassword();
                String sql = "INSERT INTO User " +
                        "VALUES ('"+ email + "', ' " + phoneNumber + " ', ' " + password + "')";
                st.executeUpdate(sql);
            } catch(Exception e) {
                System.out.println("Could not insert user " + e);
                return false;
            }

            return true;
        }

}
