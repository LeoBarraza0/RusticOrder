/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbctest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leona
 */
public class RusticOrder {

    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/rusticorderbd";
        Connection conexion;
        Statement statement;
        ResultSet rst;
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rst = statement.executeQuery("SELECT * FROM usuario");
            //Lectura de datos
            while(rst.next()){
                System.out.println(rst.getString("Nombre"));
            }
            
            //Inserción de datos
            //statement.execute("INSERT INTO `usuario` (`IdUser`, `Nombre`, `Edad`, `FechaReg`, `Correo`, `Telefono`) VALUES ('0003', 'J', '17', current_timestamp(), 'j@gmail.com', '1234567890');");
            System.out.println("");
            rst = statement.executeQuery("SELECT * FROM usuario");
            while(rst.next()){
                System.out.println(rst.getString("Nombre"));
            }
            
            //Actualización de datos
            statement.execute("UPDATE `usuario` SET `Nombre` = 'Leonnn' WHERE `usuario`.`IdUser` = '0001';");
            System.out.println("");
            rst = statement.executeQuery("SELECT * FROM usuario");
            while(rst.next()){
                System.out.println(rst.getString("Nombre"));
            }
            
            //Eliminación de datos
            statement.execute("DELETE FROM usuario WHERE `usuario`.`IdUser` = '0001'");
            System.out.println("");
            rst = statement.executeQuery("SELECT * FROM usuario");
            while(rst.next()){
                System.out.println(rst.getString("Nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RusticOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
