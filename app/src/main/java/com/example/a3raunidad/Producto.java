package com.example.a3raunidad;

public class Producto {
    private String serie,descripcion,tipo;
    private int valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Producto(String serie, String descripcion, String tipo, int valor) {
        this.serie = serie;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
    }
}
