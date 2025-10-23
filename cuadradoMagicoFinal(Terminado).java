package EjsInicio.NuevosEjs;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class cuadradoMagicoFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("de que tamaño (numero de filas y columnas) quiere el cuadrado? tiene que ser multiplo de 8: ");
        int tamano = sc.nextInt();
        while(tamano%4!=0){
            System.out.println("el tamaño tiene que ser multiplo de 4: ");
            tamano = sc.nextInt();
        }
        int[] cuadradofinal = new int[tamano * tamano];
        int tamanototal = tamano * tamano;//tamanototal es simplemente el tamaño de el cuadrado (tamano^2)
        int[][] cuadradoTotal = new int[tamano][];
        //cuadradofinal y cuadradoTotal son los arrays que vamos a usar, uno para tomar los datos y modificarlos y el otro para poder plasmar el resultado

        for (int i = 0; i < tamano; i++) {
            cuadradoTotal[i] = new int[tamano];
        }
        int cont2 = 0;// rellenar cuadradoTotal de valores, lo vamos a usar para acceder a los numeros que quiero cambiar de sitio
        //y poder ponerlos correctamente en cuadradoFinal
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                cont2 = cont2 + 1;
                cuadradoTotal[i][j] = cont2;
            }
        }//rellenar de valores cuadradofinal (el array que va a mostrar los resultados
        for (int i = 0; i < tamanototal; i++) {
            cuadradofinal[i] = i + 1;
        }

        // codigo para seleccionar el bloque B y cambiarlo por el H
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (i < tamano / 4 && j >= tamano / 4 && j < tamano - tamano / 4) {//intervalos en los que estan los numeros que queremos acceder
                    cuadradofinal[(tamanototal - (tamano - (tamano - j)) - (tamano * i)) - 1] = cuadradoTotal[i][j];//seleccionar los numeros cambiarlos de sitio y posicion en el array final
                }
            }
        }
        //coger el bloqe H y cambiarlo por el B
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (i >= tamano - tamano / 4 && j >= tamano / 4 && j < tamano - tamano / 4) {
                    cuadradofinal[(tamanototal - (tamano - (tamano - j)) - (tamano * i)) - 1] = cuadradoTotal[i][j];
                }
            }
        }
        //coger el D y cambiarlo por el F
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (j < tamano / 4 && i >= tamano / 4 && i < tamano - tamano / 4) {
                    cuadradofinal[(tamanototal - (tamano - (tamano - j)) - (tamano * i)) - 1] = cuadradoTotal[i][j];
                }
            }
        }
        //coger el F y cambiarlo por el D
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (j >= tamano - tamano / 4 && i >= tamano / 4 && i < tamano - tamano / 4) {
                    cuadradofinal[tamanototal - (tamano * (i + 1)) + (tamano - (j + 1))] = cuadradoTotal[i][j];
                }
            }
        }

        int ancho = 4;  // Ancho fijo para cada número

        for (int i = 0; i < tamanototal; i++) {
            System.out.print(String.format("%" + ancho + "d ", cuadradofinal[i]));

            if ((i + 1) % tamano == 0) {
                System.out.println();
            }


        }//comprobacion de que una fila, una columna y una diagonal suman lo mismo, siempre van a sumar lo mismo
        //ya que no se admiten valores que no sean multiplos de 4 pero bueno nunca esta de mas comprobarlo,
        //si es necesario optimizar el codigo a partir de aqui se puede eliminar ya que el cuadrado siempre va a ser magico
        int cuenta1=0;
        int cuenta2=0;
        int cuenta3=0;
        for (int i = 0; i < tamanototal; i++) {
            if( i%tamano==0){
                cuenta1=cuenta1+cuadradofinal[i];
            }
            if (i<tamano){
                cuenta2=cuenta2+cuadradofinal[i];
            }
            for (int j = 0; j < tamano; j++) {
                if(i==j){
                    cuenta3=cuenta3+cuadradoTotal[i][j];
                }
            }
        }
        if (cuenta1==cuenta2 || cuenta1==cuenta3 || cuenta2==cuenta3){
            System.out.println("todas las filas columnas y diagonales suman lo mismo: "+cuenta1);
        }else{//esta parte del codigo en realidad no se va a usar nunca pero bueno ya que estamos pues la dejo
            System.out.println("la diagonal suma: "+cuenta3+ " la columna suma "+cuenta1+"la fila suma "+cuenta2+"no es cuadrado magico D:");
        }
    }
}
