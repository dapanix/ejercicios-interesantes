package com.gmail.danielfernandezneira1;

public enum Arte {
    escultura(2), pintura(1), grabado(0.6), fotografia(0.5), otro(0.2);

    double costroextra;

    Arte(double costroextra) {
        this.costroextra = costroextra;
    }

    public double getCostroextra(Arte tipo) {
        return tipo.costroextra;
    }
}
