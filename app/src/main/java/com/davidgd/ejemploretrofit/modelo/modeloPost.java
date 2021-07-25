package com.davidgd.ejemploretrofit.modelo;

public class modeloPost {

    //Nombres de los keys de nuestro archivo Json
    private int id;
    private String concepto;
    private String codigo;
    private int precio;
    private int control;
    private String fecha;
    private String estado;
    private String linea;

    public int getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getControl() {
        return control;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public String getLinea() {
        return linea;
    }
}
