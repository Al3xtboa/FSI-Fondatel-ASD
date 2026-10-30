/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.sql.*;

public class Empleado {
    
    static String todos = "SELECT * FROM empleados ORDER BY nombree";
    static String codigos = "SELECT codigoe FROM empleados ORDER BY codigoe";
    
    String codigoe, nombree, puesto, turno, estadoe;
    
    public Empleado() {
        
    }

    public Empleado(String codigoe, String nombree, String puesto, String turno, String estadoe) {
        this.codigoe = codigoe;
        this.nombree = nombree;
        this.puesto = puesto;
        this.turno = turno;
        this.estadoe = estadoe;
    }
    
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO empleados VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoe);
            ps.setString(2, nombree);
            ps.setString(3, puesto);
            ps.setString(4, turno);
            ps.setString(5, estadoe);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con) {
        int resultado = 0; 
        try {
            String sql = "DELETE FROM empleados WHERE codigoe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoe);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE empleados SET nombree = ?, puesto = ?, turno = ?, estadoe = ? WHERE codigoe = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombree);
            ps.setString(2, puesto);
            ps.setString(3, turno);
            ps.setString(4, estadoe);
            ps.setString(5, codigoe);
            return ps.executeUpdate(); 
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
