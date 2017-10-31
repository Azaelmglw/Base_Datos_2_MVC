package models;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Azaelmglw
 */

public class ModelDirecciones {
    private Connection sql_connection;
    private Statement sql_statement;
    private PreparedStatement sql_prepared_statement;
    private ResultSet sql_result_set;
    private String sql;
    
    private String id_direccion;
    private String calle_direccion;
    private String colonia_direccion;
    private int numero_direccion;
    private String ciudad_direccion;
    private String estado_direccion;
    
    private void Connect(){
        try {
            Class.forName("org.postgresql.Driver");
            sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PersonasDB", "postgres", "");
            sql_statement = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e);
        } catch (ClassNotFoundException f) {
            JOptionPane.showMessageDialog(null, "Error: " + f);
        }
    }
    
    public void Consultar_Direcciones(){
        try{
            Connect();
            sql = "SELECT * FROM Direcciones ORDER BY DirecciónID ASC;";
            sql_result_set = sql_statement.executeQuery(sql);
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al consultar direcciones: " + e);
        }     
    }
    
    public void Asignar_Valores(){
        try{
            id_direccion = sql_result_set.getString("DirecciónID");
            calle_direccion = sql_result_set.getString("Calle");
            colonia_direccion = sql_result_set.getString("Colonia");
            numero_direccion = sql_result_set.getInt("Número");
            ciudad_direccion = sql_result_set.getString("Ciudad");
            estado_direccion = sql_result_set.getString("Estado");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al asignar valores de consulta de direcciones: " + e);
        }
    }
    
    public void Mover_Primero(){
        try{
            if (sql_result_set.isFirst() == false) {
                sql_result_set.first();
                Asignar_Valores();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar el primer registro: " + e);
        }
    }
    
    public void Mover_Anterior(){
        try {
            if (sql_result_set.isFirst() == false) {
                sql_result_set.previous();
                Asignar_Valores();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar el anterior registro: " + e);
        }
    }
    
    public void Mover_Siguiente(){
        try{
            if(sql_result_set.isLast() == false){
                sql_result_set.next();
                Asignar_Valores();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar el siguiente regsitro: " + e);
        }
    }
    
    public void Mover_Ultimo(){
        try{
            if(sql_result_set.isLast() == false){
                sql_result_set.last();
                Asignar_Valores();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar el último registro: " + e);
        }
    }
    
    public void Insertar_Usuario(){
        try{
            Connect();
            sql = "INSERT INTO Direcciones(Calle, Colonia, Número, Ciudad, Estado) VALUES(?, ?, ?, ?, ?);";
            sql_prepared_statement = sql_connection.prepareStatement(sql);
            sql_prepared_statement.setString(1, calle_direccion);
            sql_prepared_statement.setString(2, colonia_direccion);
            sql_prepared_statement.setInt(3, numero_direccion);
            sql_prepared_statement.setString(4, ciudad_direccion);
            sql_prepared_statement.setString(5, estado_direccion);
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al insertar nuevo usuario: "  + e);
        }
    }
    
    public void Modificar_Usuario(){
        try{
            Connect();
            sql = "UPDATE Direcciones SET Calle = (?), Colonia = (?), Número = (?), Ciudad = (?), Estado = (?) WHERE DirecciónID = (?);";
            sql_prepared_statement = sql_connection.prepareStatement(sql);
            sql_prepared_statement.setString(1, calle_direccion);
            sql_prepared_statement.setString(2, colonia_direccion);
            sql_prepared_statement.setInt(3, numero_direccion);
            sql_prepared_statement.setString(4, ciudad_direccion);
            sql_prepared_statement.setString(5, estado_direccion);
            sql_prepared_statement.setInt(6, Integer.parseInt(id_direccion));
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + e);
        }
    }
    
    public void Eliminar_Usuario(){
        try{
            Connect();
            sql = "DELETE FROM Direcciones WHERE DirecciónID = (?)";
            sql_prepared_statement = sql_connection.prepareStatement(sql);
            sql_prepared_statement.setInt(1, Integer.parseInt(id_direccion));
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e);
        }
    }
    
    public String getID_Direccion(){
        return id_direccion;
    }
    
    public String getCalle_Direccion(){
        return calle_direccion;
    }
    
    public String getColonia_Direccion(){
        return colonia_direccion;
    }
    
    public int getNumero_Direccion(){
        return numero_direccion;
    }
    
    public String getCiudad_Direccion(){
        return ciudad_direccion;
    }
    
    public String getEstado_Direccion(){
        return estado_direccion;
    }
    
    public void setId_Direccion(String id_direccion){
        this.id_direccion = id_direccion;
    }
    
    public void setCalle_Direccion(String calle_direccion){
        this.calle_direccion = calle_direccion;
    }
    
    public void setColonia_Direccion(String colonia_direccion){
        this.colonia_direccion = colonia_direccion;
    }
    
    public void setNumero_Direccion(int numero_direccion){
        this.numero_direccion = numero_direccion;
    }
    
    public void setCiudad_Direccion(String ciudad_direccion){
        this.ciudad_direccion = ciudad_direccion;
    }
    
    public void setEstado_Direccion(String estado_direccion){
        this.estado_direccion = estado_direccion;
    }
}

