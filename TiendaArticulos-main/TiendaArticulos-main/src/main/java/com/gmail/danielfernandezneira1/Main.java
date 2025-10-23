package com.gmail.danielfernandezneira1;
import java.sql.SQLOutput;
import java.util.HashMap;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static sun.jvm.hotspot.runtime.BasicObjectLock.size;


public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();
        int opcion = pantalladeInicio();
        switch (opcion) {
            case 1:
                registarNuevoArticulo(miTienda);
            case 2:
                registrarNuevoCliente(miTienda);
            case 3:
                cambioContrato(miTienda);
            case 4:
                registrarVenta(miTienda);
            case 5:
                //gastosIngresosGanancias();
            case 6:
                //buscadorMain();
            case 7:
                //salir();
        }
    }


    public static Integer pantalladeInicio() {


        System.out.println("******************** TIENDA DE ANTGÜEDADES ********************");
        System.out.println("********************          MENÚ         ********************");
        System.out.println("1. Registrar nuevo artículo");
        System.out.println("2. Registrar nuevo cliente");
        System.out.println("3. Gestionar cambios de contrato");
        System.out.println("4. Registrar venta");
        System.out.println("5. Gastos, ingresos y ganancias");
        System.out.println("6. Buscador");
        System.out.println("7. Salir");
        System.out.print("Elige una opción del menú: ");
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        try {
            System.out.print("Introduce un número entero: ");
            numero = sc.nextInt();
            System.out.println("Has introducido: " + numero);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero.");
        }

        return numero;
    }

    public static void registarNuevoArticulo(Tienda tienda) {
        Scanner s = new Scanner(System.in);

        System.out.println("Descripcion:");
        String descripcion = s.nextLine();

        System.out.println("Año de origen :");
        Integer origen = s.nextInt();

        System.out.println("Precio de compra:");
        Integer precio = s.nextInt();

        s.nextLine();

        System.out.println("Fecha de compra (dd/mm/aa):");
        LocalDate fecha = conseguirFecha(tienda);


        System.out.println("Tipo de artículo (MENUDENCIA/OBRA_ARTE/VOLUMINOSO)");
        TipoArticulo tipoEnum = tipoArticulo();
        Articulo articulo1 = new Articulo(descripcion, origen, precio, fecha, tipoEnum);
        tienda.registrarArticulo(articulo1);
        if (articulo1 instanceof Articulo) {
            System.out.println("--------------------- Registrado correctamente ----------------");
            System.out.println("ARTÍCULO ID: " + articulo1.getID());
            System.out.println("Descripción: " + articulo1.getDescripcion());
            System.out.println("Origen: " + articulo1.getOrigen());
            System.out.println("Tipo: " + articulo1.getTipo());
            System.out.println("Estado: " + articulo1.getEstado());
            System.out.println("Precio de compra: " + articulo1.getFechaCompra());
            System.out.println("Fecha compra: " + articulo1.getFechaCompra());
            System.out.println("----------------------------------------------------------------");
        }
    }

    public static TipoArticulo tipoArticulo() {

        Scanner sc = new Scanner(System.in);
        String tipo = sc.nextLine();
        if (tipo.toLowerCase().equals("menudencia") || (tipo.toLowerCase().equals("obra_arte") || (tipo.toLowerCase().equals("voluminoso")))) {
            TipoArticulo tipoEnum = TipoArticulo.valueOf(tipo);
            return tipoEnum;
        } else if (tipo.equals("1")) {
            pantalladeInicio();
        } else {
            System.out.println("Tipo de artículo (MENUDENCIA/OBRA_ARTE/VOLUMINOSO)");
            System.out.println("presione 1 para salir -no se guardaran los datos de el articulo actual-");
            tipoArticulo();
        }
        return null;
    }


    public static Contrato conseguirContrato() {
        System.out.print("Tipo de contrato del cliente (ESTANDAR/PREFERENTE/SIN_CONTRATO): ");
        Scanner sd = new Scanner(System.in);
        System.out.println("presione 1 para salir -no se guardaran los datos de el articulo actual-");
        String contrat1 = sd.nextLine();
        if (contrat1.equals("1")) {
            pantalladeInicio();
        }
        try {
            Contrato contrato1 = Contrato.valueOf(contrat1);
            return contrato1;
        } catch (Exception e) {
            System.out.println("Error: El contrato ingresado no es valido. ");
            conseguirContrato();
        }
        return null;
    }

    public static LocalDate conseguirFecha(Tienda tienda) {
        Scanner s = new Scanner(System.in);
        System.out.println("Fecha de compra (yyyy-MM-dd):");
        System.out.println("presione 1 para salir  presione 2 para volver a registrar el articulo -no se guardaran los datos de el articulo actual-");
        String fecha2 = s.nextLine();
        if (fecha2.equals("2")) {
            registarNuevoArticulo(tienda);
        }
        if (fecha2.equals("1")) {
            pantalladeInicio();
        }
        try {
            LocalDate fecha = LocalDate.parse(fecha2);
            return fecha;
        } catch (Exception e) {
            System.out.println("Error: La fecha ingresada no es válida. Asegúrate de usar el formato yyyy-MM-dd.");
            conseguirFecha(tienda);
        }


        return null;
    }

    public static void registrarNuevoCliente(Tienda tienda) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre y apellidos: ");
        String nombre = sc.nextLine();

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Teléfono: ");
        int telefono = sc.nextInt();

        System.out.print("Correo electrónico: ");
        String correo = sc.nextLine();

        System.out.print("Dirección: ");
        String direccion = sc.nextLine();

        System.out.print("Tipo de contrato del cliente (ESTANDAR/PREFERENTE/SIN_CONTRATO): ");
        String contrat = sc.nextLine();
        Contrato contrato = conseguirContrato();
        Cliente cliente1 = new Cliente(dni, nombre, telefono, correo, direccion, contrato);
        tienda.registrarCliente(cliente1);
        System.out.println("--------------------- Registrado correctamente ----------------");

        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Dirección: " + direccion);
        System.out.println("Tipo de contrato: " + contrato);
        System.out.println("Descuento acumulado: 0.0");
        System.out.println("----------------------------------------------------------------");
    }


    public static void borrarDatosArticulo(Articulo articulo1) {
        articulo1.setDescripcion(null);
        articulo1.setFechaCompra(null);
        articulo1.setPrecioCompra(0);
        articulo1.setOrigen(0);
        articulo1.setFechaCompra(LocalDate.ofEpochDay(0));
        articulo1.tipo = null;
    }

    public static void cambioContrato(Tienda tienda) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------- Cambio de contrato ----------------");
        System.out.println("Dni del cliente:");
        String dni = sc.nextLine();
        System.out.println("Tipo del nuevo contrato (ESTANDAR/PREFERENTE/SIN_CONTRATO): ");
        tienda.buscarClientePorDni(dni).setContrato(conseguirContrato());
        if (tienda.buscarClientePorDni(dni) != null) {
            tienda.buscarClientePorDni(dni).toString();
        }

    }

    public static void registrarVenta(Tienda tienda) {
        Ventas venta1 = new Ventas(tienda.getListaClientes().get(size()-1));
        //aqui se asume que el ultimo cliente el el que registra esta venta
        //por lo tanto IMPORTANTE registrar el cliente antes de la venta
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------- REGISTRAR VENTA ----------------");
        System.out.println("rellene lso datos de la venta:");
        System.out.println("dni del cliente: ");
        String dni = sc.nextLine();
        if (tienda.buscarClientePorDni(dni) != null) {
            System.out.println("cuantos articulos incluue la venta?:");
            int cuantos = sc.nextInt();
            HashMap<String, Articulo> articulos = new HashMap<>();
            for (int i = 0; i < cuantos; i++) {
                Scanner s = new Scanner(System.in);

                System.out.println("Descripcion:");
                String descripcion = s.nextLine();

                System.out.println("Año de origen :");
                Integer origen = s.nextInt();

                System.out.println("Precio de compra:");
                Integer precio = s.nextInt();

                s.nextLine();

                System.out.println("Fecha de compra (dd/mm/aa):");
                LocalDate fecha = conseguirFecha(tienda);


                System.out.println("Tipo de artículo (MENUDENCIA/OBRA_ARTE/VOLUMINOSO)");
                TipoArticulo tipoEnum = tipoArticulo();
                if (!articulos.containsKey("articulo" + i)) {

                    articulos.put("articulo" + i, new Articulo(descripcion, origen, precio, fecha, tipoEnum));
                    venta1.incluirArticulo(articulos.get("articulo" + i));
                }
                tienda.registrarVenta(venta1);
            }
        }
    }



    public void GastosIngresosGanancias(Tienda tienda){
        double total=0;
        System.out.println("--------------------- DATOS ECONÓMICOS ----------------");
        for (i: getListaArticulos()) {


        }

        System.out.println("dinero gastado en la compra de articulos: "+total);
    }
}









