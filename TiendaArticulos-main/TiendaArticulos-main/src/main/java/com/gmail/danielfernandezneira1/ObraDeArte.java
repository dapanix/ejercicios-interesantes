package com.gmail.danielfernandezneira1;

import java.time.LocalDate;

public class ObraDeArte extends Articulo {
    Arte tipo = null;
    String autor;
    double precioVenta;


    public ObraDeArte(Arte tipo, String autor, String descripcion, int origen, double precioCompra, LocalDate fechaCompra, double precioVenta) {
        super(descripcion, origen, precioCompra, fechaCompra, TipoArticulo.ObraDeArte);
            if (tipo.equals("escultura") || tipo.equals("pintura") || tipo.equals("fotografia") || tipo.equals("otro") || tipo.equals("grabado")) {
                this.tipo = tipo;
            } else {
                System.out.println("por favor ingrese el tipo de obra de arte todo en minusculas y sin tildes");

            }
            this.precioVenta = precioCompra + precioCompra * Arte.otro.getCostroextra(tipo);
        }



        @Override
        public String toString () {
            return "ObraDeArte{" +
                    "tipo=" + tipo +
                    ", autor='" + autor + '\'' +
                    ", descripcion='" + getDescripcion() + '\'' +
                    ", origen=" + getOrigen() +
                    ", precioCompra=" + getPrecioCompra() +
                    ", fechaCompra=" + getFechaCompra() +
                    '}';
        }


}
