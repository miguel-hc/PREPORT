package com.model;

/**
 *
 * @author Copper
 */
public class Ventas {

    String Venta;
    String Fecha;

    public Ventas() {
        this.Venta = "";
        this.Fecha = "";
    }

    public Ventas(String Venta, String Fecha) {
        this.Venta = Venta;
        this.Fecha = Fecha;
    }
    
    

    public String getVenta() {
        return Venta;
    }

    public void setVenta(String Venta) {
        this.Venta = Venta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
    
}
