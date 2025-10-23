package com.gmail.danielfernandezneira1;

public class Cliente {
private String dni;
String nombre;
int telefono;
String email;
double descuentoAcumulado;
String direccion;
Contrato contrato;

    public Cliente(String dni, String nombre, int telefono, String email, String direccion, Contrato contrato) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion=direccion;
        this.contrato=contrato;
    }

    public void acumularDescuento(double preciocompra){
            this.descuentoAcumulado = descuentoAcumulado + preciocompra * contrato.acumulacion;
    }

    public double getDescuentoAcumulado() {
        return descuentoAcumulado;
    }

    public String getDni() {
        return dni;
    }

    public void setDescuentoAcumulado(double descuentoAcumulado) {
        this.descuentoAcumulado = descuentoAcumulado;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }


    public boolean equals(Cliente obj) {
        if (this.dni==obj.dni){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", descuentoAcumulado=" + descuentoAcumulado +
                ", direccion='" + direccion + '\'' +
                ", contrato=" + contrato +
                '}';
    }
}

