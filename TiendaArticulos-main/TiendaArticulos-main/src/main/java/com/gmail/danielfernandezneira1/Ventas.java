package com.gmail.danielfernandezneira1;
import java.util.ArrayList;

public class Ventas {
    Cliente cliente;
    Articulo articulo;
     ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
    double total=0;


    public Ventas(Cliente cliente) {
        this.cliente = cliente;
    }
    public boolean incluirArticulo(Articulo articulo){
        if (articulo.estado.equals("en venta")){
            if (!contieneArticulo(articulo)){
                listaArticulos.add(articulo);
                return true;
            }
        }return false;
    }public boolean contieneArticulo(Articulo articulo){
        if (!listaArticulos.contains(articulo)){
            return true;
        }
        return false;
    }
    public void realizarVenta(){
        
        if (listaArticulos.size()>0){
        for (Articulo i : listaArticulos){
            i.estado="Vendido";
            total=i.precioVenta+total;
        }
        cliente.acumularDescuento(total);
    }

    }
    public double descuentoCliente(double precio){
        if (cliente.getDescuentoAcumulado()>precio){
            cliente.setDescuentoAcumulado(cliente.getDescuentoAcumulado()-precio);
            return precio;
        }else{
            double desc=cliente.getDescuentoAcumulado();
            cliente.setDescuentoAcumulado(0);
            return desc;
        }
    }
    public double getTotal() {
        return total;
    }
    @Override
    public String toString() {
        return "Ventas [cliente=" + cliente + ", articulo=" + articulo + ", listaArticulos=" + listaArticulos
                + ", total=" + total + "]";
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }
}
