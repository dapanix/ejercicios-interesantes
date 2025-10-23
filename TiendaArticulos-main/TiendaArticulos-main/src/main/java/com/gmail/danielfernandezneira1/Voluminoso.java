package com.gmail.danielfernandezneira1;

import java.time.LocalDate;

public class Voluminoso extends Articulo {
    int gasto = 0;
    String descripcion;
    int origen;
    double precioCompra;
    LocalDate fechaCompra;
    double peso;
    double ancho;
    double alto;
    double largo;
    double precioVenta;
    public Voluminoso(String descipcion, int origen, double precioCompra, LocalDate fechaCompra,
                      double peso, double ancho, double alto, double largo, double precioVenta) {
        super(descipcion, origen, precioCompra, fechaCompra, TipoArticulo.ObjetoVolumninoso);
        this.peso = peso;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.precioVenta=precioCompra+extras();
    }

    public Voluminoso(String descipcion, int origen, double precioCompra, LocalDate fechaCompra) {
        super(descipcion, origen, precioCompra, fechaCompra, TipoArticulo.ObjetoVolumninoso);
        this.peso = 0;
        this.ancho = 0;
        this.alto = 0;
        this.largo = 0;
        precioVenta=precioCompra+0.2*precioCompra;
    }

    public double gastosEnvio() {
        if (peso > 100 || ancho > 3 || alto > 3 || largo > 3) {
            gasto = 80;

        } else {
            gasto = 20;
        }
        return (gasto);
    }

    public double extras() {
        if (gasto == 0) {
            System.out.println("no ha calculado los gastos de envio, debe calcular los gastos de envio antes de calcular el extra");
            gastosEnvio();
        }
        return (getPrecioCompra()*0.2+gastosEnvio());

    }

    @Override
    public String toString() {
        return "Voluminoso{" +
                "gasto=" + gasto +
                ", descripcion='" + descripcion + '\'' +
                ", origen=" + origen +
                ", precioCompra=" + precioCompra +
                ", fechaCompra=" + fechaCompra +
                ", peso=" + peso +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", largo=" + largo +
                '}';
    }
}
