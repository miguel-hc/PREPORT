/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.conexion.Conexion;
import com.model.CorteZModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Copper
 */
public class CorteZAspelCaja {
    
    String fecha = "";
    double totalActual = 0;
    double totalAnterio = 0;
    java.sql.Statement s = null;
    java.sql.ResultSet rs = null;
    Conexion con = new Conexion();
    
    public ArrayList<CorteZModel> getCorteZAspelCaja(String fecha, String FolioCorte) throws SQLException{
    
        ArrayList DatoCorte = new ArrayList();
        CorteZModel model;
        
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select cortexz02.fecha, cortexz02.totalact, cortexz02.totalant from cortexz02 where cortexz02.folioxz = '"+FolioCorte+"' and cortexz02.cajero = '003' and cortexz02.fecha = '"+fecha+"' ;");
        while(rs.next()){
            model = new CorteZModel(rs.getString("fecha"),rs.getDouble("totalact"),rs.getDouble("totalant"),0,0);
            System.out.println(rs.getString("totalact"));
            DatoCorte.add(model);
        }
        return DatoCorte;
    }
    
    
    public ArrayList<CorteZModel> getAbonoSae(String Fecha) throws SQLException{
        ArrayList anbonoSae = new ArrayList();
        CorteZModel model;
        s = con.getConnection().createStatement();
        rs = s.executeQuery("select vventas.vfecha ,sum(vventas.totdoc) as total, sum(vventas.totimp4) as totalimpuesto from vventas where vventas.vfecha = '"+Fecha+"' and vventas.status = 'N' and vventas.tipodocsae = 'P' and vventas.cajero = '003' group by vventas.vfecha;");
        while(rs.next()){
            model = new CorteZModel(rs.getDouble("total"), rs.getDouble("totalimpuesto"));
            //System.out.println("abono sae "+model.getAbonoSae());
            anbonoSae.add(model);
        }
        return anbonoSae;
    }
    
}
