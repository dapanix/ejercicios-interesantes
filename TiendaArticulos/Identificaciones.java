package com.gmail.danielfernandezneira1;

import java.util.Arrays;

public class Identificaciones {
    static String letra="n";
    private static int contador=0;
    private static int[] listaIDs= new int [1];

    public static String nextVal(Articulo articulo){
        if (articulo.tipo.equals("menudencia")){
            letra="M";}
        else if(articulo.tipo.equals("ObraDeArte")){
            letra="O";
        }else if (articulo.tipo.equals("ObjetoVolumninoso")){
            letra="V";
        }

         contador++;
         listaIDs= Arrays.copyOf(listaIDs, listaIDs.length+1);
         listaIDs[listaIDs.length-1]=contador;
         String codigo=letra+contador;
         return codigo;

    }
}

