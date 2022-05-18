
package com.controller;

import com.conexion.Conexion;
import com.model.ReporteFiscalModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Copper
 */
public class ReporteFiscalController {
    
    java.sql.Statement s = null;
    java.sql.ResultSet rs = null;
    Conexion con = new Conexion();
    
    public ArrayList<ReporteFiscalModel> getVentas(String fecha) throws SQLException{
        ArrayList ventas = new ArrayList();
        ReporteFiscalModel rmodel;
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha, sum(vventas.totdoc) from vventas where vventas.vfecha = '"+fecha+"' and vventas.status = 'N' and vventas.tipodocsae = 'N' AND vventas.cajero = '003' group by vventas.vfecha;");
        while(rs.next()){
            rmodel = new ReporteFiscalModel();
            rmodel.setVentas(rs.getInt(2));
            ventas.add(rmodel);
        }
        return ventas;
    }
    
    public ArrayList<ReporteFiscalModel> getImpuesto(String fecha) throws SQLException{
        ArrayList impuestos = new ArrayList();
        ReporteFiscalModel rmodel;
        
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha, sum(vventas.totimp1) from vventas where vventas.vfecha = '"+fecha+"' and vventas.status = 'N' and vventas.tipodocsae = 'N'and vventas.cajero = '003' group by vventas.vfecha;");
        while(rs.next()){
            rmodel = new ReporteFiscalModel();
            rmodel.setImpuesto(rs.getDouble(2));
            impuestos.add(rmodel);
        }
        return impuestos;
    }
    
    public ArrayList<ReporteFiscalModel> getIva(String fecha) throws SQLException{
        ArrayList iva = new ArrayList();
        ReporteFiscalModel rmodel;
        
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha, sum(vventas.totimp4) from vventas where vventas.vfecha = '"+fecha+"' and vventas.status = 'N' and vventas.cajero = '003' and vventas.tipodocsae = 'N' group by vventas.vfecha;");
        while(rs.next()){
            rmodel = new ReporteFiscalModel();
            rmodel.setIva(rs.getInt(2));
            iva.add(rmodel);
        }
        return iva;
    }
}
