
package com.model;

/**
 *
 * @author Copper
 */
public class ReporteFiscalModel {
    
    String fecha;
    double ventas, impuesto, iva, totalimpuesto;

    public ReporteFiscalModel(String fecha, double ventas, double impuesto, double iva, double totalimpuesto) {
        this.fecha = fecha;
        this.ventas = ventas;
        this.impuesto = impuesto;
        this.iva = iva;
        this.totalimpuesto = totalimpuesto;
    }
    
    public ReporteFiscalModel() {}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalimpuesto() {
        return totalimpuesto;
    }

    public void setTotalimpuesto(double totalimpuesto) {
        this.totalimpuesto = totalimpuesto;
    }
    
    
    
}
