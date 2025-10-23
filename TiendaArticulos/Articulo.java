package com.gmail.danielfernandezneira1;

import java.time.LocalDate;

public class Articulo {

     String ID;
     private double precioCompra;
     private String descripcion;
    private int origen; //año de origen
    private LocalDate fechaCompra;
    TipoArticulo tipo;
     String estado= "en venta";
     int precioVenta;


    public Articulo(String descripcion, int origen, double precioCompra, LocalDate fechaCompra, TipoArticulo tipo) {
        this.descripcion = descripcion;
        this.origen = origen;
        this.precioCompra = precioCompra;
        this.fechaCompra = fechaCompra;
        this.tipo = tipo;
        if (tipo.equals("menudencia")) {
            this.ID = Identificaciones.nextVal(this);

        }

    }


        public int getOrigen () {
            return origen;
        }

        public String getID () {
            return ID;
        }

        public double getPrecioCompra () {
            return precioCompra;
        }

        public LocalDate getFechaCompra () {
            return fechaCompra;
        }

        public String getDescripcion () {
            return descripcion;
        }

        public TipoArticulo getTipo () {
            return tipo;
        }

        public String getEstado () {
            return estado;
        }

    public boolean equals(Articulo obj) {
        if(this.tipo.equals(obj.tipo)){
            if(this.descripcion.equals(obj.descripcion)){
                if (this.origen==obj.origen){
                    return true;
                }
                System.out.println("los articulos no son iguales, difieren en el año de origen");
                return false;
            }
            System.out.println("los articulos no son iguales, difieren en la descripcion");
            return false;
        }
        System.out.println("los articulos no son iguales, difieren en el tipo de articulo");
        return false;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}