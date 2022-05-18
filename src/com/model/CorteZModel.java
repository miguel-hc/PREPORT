
package com.model;

/**
 *
 * @author Copper
 */
public class CorteZModel {
    String fecha ;
    double totalActual ;
    double totalAnterio ;
    double abonoSae ;
    double impuestoabono;

    public CorteZModel(String fecha, double totalActual, double totalAnterio, double abonoSae, double impuestoabono) {
        this.fecha = fecha;
        this.totalActual = totalActual;
        this.totalAnterio = totalAnterio;
        this.abonoSae = abonoSae;
        this.impuestoabono = impuestoabono;
    }
    public CorteZModel() {
        
    }
    public CorteZModel(double abonoSae, double impuestoabono) {
        this.abonoSae = abonoSae;
        this.impuestoabono = impuestoabono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalActual() {
        return totalActual;
    }

    public void setTotalActual(double totalActual) {
        this.totalActual = totalActual;
    }

    public double getTotalAnterio() {
        return totalAnterio;
    }

    public void setTotalAnterio(double totalAnterio) {
        this.totalAnterio = totalAnterio;
    }

    public double getAbonoSae() {
        return abonoSae;
    }

    public void setAbonoSae(double abonoSae) {
        this.abonoSae = abonoSae;
    }

    public double getImpuestoabono() {
        return impuestoabono;
    }

    public void setImpuestoabono(double impuestoabono) {
        this.impuestoabono = impuestoabono;
    }
    
}
