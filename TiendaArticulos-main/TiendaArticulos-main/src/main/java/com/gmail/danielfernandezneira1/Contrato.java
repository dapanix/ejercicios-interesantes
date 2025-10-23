package com.gmail.danielfernandezneira1;

public enum Contrato {
    Estandar(0.25),
    Preferente(0.05),
    Sin_contrato(0);
    public double acumulacion;

    Contrato(double acumulacion) {
        this.acumulacion=acumulacion;
    }
}
