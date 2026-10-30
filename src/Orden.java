/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.sql.*;

public class Orden {
    
    static String todos = "SELECT * FROM ordenes ORDER BY folio";
    static String folios = "SELECT folio FROM ordenes ORDER BY folio";
    
    int folio, silla, mesas_numero, alimentos_idalimentos;
    String fecha_hora, observaciones, estadoo, clientes_codigoc, empleados_codigoe_mesero, empleados_codigoe_cocinero;
    
    public Orden() {
        
    }

    public Orden(int folio, String fecha_hora, String observaciones, int silla, String estadoo, String clientes_codigoc, int mesas_numero, int alimentos_idalimentos, String empleados_codigoe_mesero, String empleados_codigoe_cocinero) {
        this.folio = folio;
        this.fecha_hora = fecha_hora;
        this.observaciones = observaciones; // Este campo es virtual en BD, pero se mantiene en la clase para lectura
        this.silla = silla;
        this.estadoo = estadoo;
        this.clientes_codigoc = clientes_codigoc;
        this.mesas_numero = mesas_numero;
        this.alimentos_idalimentos = alimentos_idalimentos;
        this.empleados_codigoe_mesero = empleados_codigoe_mesero;
        this.empleados_codigoe_cocinero = empleados_codigoe_cocinero;
    }
    
    public int insertar(Connection con) {
        int resultado = 0;
        try {
            // Se omite 'folio' (AUTO_INCREMENT) y 'observaciones' (GENERATED ALWAYS)
            String sql = "INSERT INTO ordenes (fecha_hora, silla, estadoo, clientes_codigoc, mesas_numero, alimentos_idalimentos, empleados_codigoe_mesero, empleados_codigoe_cocinero) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha_hora);
            ps.setInt(2, silla);
            ps.setString(3, estadoo);
            ps.setString(4, clientes_codigoc);
            ps.setInt(5, mesas_numero);
            ps.setInt(6, alimentos_idalimentos);
            ps.setString(7, empleados_codigoe_mesero);
            ps.setString(8, empleados_codigoe_cocinero);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con) {
        int resultado = 0; 
        try {
            String sql = "DELETE FROM ordenes WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, folio);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            // Tampoco actualizamos 'observaciones' por ser un campo autogenerado
            String sql = "UPDATE ordenes SET fecha_hora = ?, silla = ?, estadoo = ?, clientes_codigoc = ?, mesas_numero = ?, alimentos_idalimentos = ?, empleados_codigoe_mesero = ?, empleados_codigoe_cocinero = ? WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha_hora);
            ps.setInt(2, silla);
            ps.setString(3, estadoo);
            ps.setString(4, clientes_codigoc);
            ps.setInt(5, mesas_numero);
            ps.setInt(6, alimentos_idalimentos);
            ps.setString(7, empleados_codigoe_mesero);
            ps.setString(8, empleados_codigoe_cocinero);
            ps.setInt(9, folio);
            return ps.executeUpdate(); 
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }
}
