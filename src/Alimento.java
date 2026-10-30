/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.sql.*;

public class Alimento {
    
    static String todos = "SELECT * FROM alimentos ORDER BY nombrea";
    static String ids = "SELECT idalimentos FROM alimentos ORDER BY idalimentos";
    
    int idalimentos;
    float precio;
    String nombrea, descripcion, categoria, estadoa;
    byte[] foto;
    
    public Alimento() {
        
    }

    public Alimento(int idalimentos, String nombrea, String descripcion, float precio, byte[] foto, String categoria, String estadoa) {
        this.idalimentos = idalimentos;
        this.nombrea = nombrea;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.categoria = categoria;
        this.estadoa = estadoa;
    }
    
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            // Se omiten idalimentos porque es AUTO_INCREMENT
            String sql = "INSERT INTO alimentos (nombrea, descripcion, precio, foto, categoria, estadoa) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrea);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBytes(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estadoa);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con) {
        int resultado = 0; 
        try {
            String sql = "DELETE FROM alimentos WHERE idalimentos = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalimentos);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE alimentos SET nombrea = ?, descripcion = ?, precio = ?, foto = ?, categoria = ?, estadoa = ? WHERE idalimentos = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrea);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setBytes(4, foto);
            ps.setString(5, categoria);
            ps.setString(6, estadoa);
            ps.setInt(7, idalimentos);
            return ps.executeUpdate(); 
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
