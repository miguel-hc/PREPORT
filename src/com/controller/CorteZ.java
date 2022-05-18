package com.controller;
import com.conexion.Conexion;
import com.model.Ventas;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Cooper
 */
public class CorteZ {
    
    java.sql.Statement s = null;
    java.sql.ResultSet rs = null;
    Conexion con = new Conexion();
    
    
    public ArrayList<Ventas> getVventas(String Vfecha) throws SQLException{
    ArrayList listaVentas = new ArrayList();
        
        Ventas ventas = null;
        
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha ,sum(vventas.montopago1) as total from vventas where vventas.vfecha = '"+Vfecha+"' and vventas.status = 'N' and vventas.tipodocsae = 'P' and vventas.cajero = '003' group by vventas.vfecha;");
        
        while(rs.next()){
            ventas = new Ventas();
            ventas.setFecha(rs.getString("vfecha"));
            ventas.setVenta(rs.getString("total"));
           
            listaVentas.add(ventas);
        }
        
        return listaVentas;
        
    }
    
    public void getCorteZ(int NcorteZ){
    
        try {
            s = con.getConnection().createStatement();
            rs = s.executeQuery("select cortexz02.folioxz, cortexz02.totalant, cortexz02.totalact from cortexz02 where cortexz02.folioxz = '"+NcorteZ+"' and CORTEXZ02.cajero = '003';");
            while (rs.next()) {
                System.out.println (rs.getString("folioxz"));
                System.out.println (rs.getString("totalant"));
                System.out.println (rs.getString("totalact"));
            }
        }
        catch (java.sql.SQLException e) {
            e.printStackTrace();
            System.out.println ("Unable to increase everyone's salary.");
        }
        
    }
    
    public void getPagosSae(String Vfecha) throws SQLException{
        
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha ,sum(vventas.montopago1) as total from vventas where vventas.vfecha = '"+Vfecha+"' and vventas.status = 'N' and vventas.tipodocsae = 'P' group by vventas.vfecha;");
        
        while(rs.next()){    
            System.out.println(rs.getString("vfecha"));
            System.out.println(rs.getString("total"));
        }
        
    }
}
