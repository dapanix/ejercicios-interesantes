package com.gmail.danielfernandezneira1;

import java.time.LocalDate;

public class menudencia extends Articulo{
    String descripcion;
    int origen;
    double precioCompra;
    LocalDate fechaCompra;
    double precioVenta;
    public menudencia(String descripcion, int origen, double precioCompra, LocalDate fechaCompra,double precioVenta) {
        super(descripcion, origen, precioCompra, fechaCompra, TipoArticulo.menudencia);
        this.precioVenta=precioCompra+extras();
    }
    public double extras(){
        if (getOrigen()<1500){
            return 200;
        } else if (getOrigen() >=1500 && getOrigen()<1700) {
            return 150;
        }else if(getOrigen()>=1700 && getOrigen()<1900){
                return 50;
        }else {
            return 20;
        }

    }

    @Override
    public String toString() {
        return "menudencia{" +
                "descripcion='" + descripcion + '\'' +
                ", origen=" + origen +
                ", precioCompra=" + precioCompra +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
