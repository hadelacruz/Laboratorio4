import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayak implements Reservacion {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Reserva> listaReservas;

    String usernameGlobal = "";

    public Kayak(){
        listaUsuarios = new ArrayList<Usuario>();
        listaReservas = new ArrayList<Reserva>();
    }

    //Guardar Data de Usuarios
    @Override
    public void guardarUsuario(){
        try {
            File fichero = new File("usuarios.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            //Crear encabezados
            if(fichero.length() == 0){
                bw.write("Username,Password,TipoUsuario");
                bw.newLine();
            }

            for (Usuario usuario : listaUsuarios) {
                String filaUsuario = usuario.getUsername()+","+usuario.getPassword()+","+usuario.getTipoUsuario();
                bw.write(filaUsuario);
                bw.newLine(); 
            }
            bw.close();


        } catch (Exception e) {
            System.out.println("ERROR EN EL MOMENTO DE CARGAR LA DATA");
        }
    }

    @Override
    public void leerUsuario(){
        try {
            String linea;
            //Leer archivo csv
            BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"));
            br.readLine();

            while((linea = br.readLine()) != null){
                String datos[] = linea.split(",");
                Usuario usuario = new Usuario("", "", "");
                usuario.setUsername(datos[0]);
                usuario.setPassword(datos[1]);
                usuario.setTipoUsuario(datos[2]);
                listaUsuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("ADVERTENCIA, NO HAY DATA EN EL ARCHIVO CSV");
        }
    }

    //Método para guardar la data actualizada de Reserva
    @Override
    public void guardarReserva(){
        try {
            File fichero = new File("reservas.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            //Crear encabezados
            if(fichero.length() == 0){
                bw.write("Username,FechaVuelo,TipoVuelo,CantidadBoletos,Aerolinea,NumeroTarjeta,Cuotas,ClaseVuelo,NumeroAsientos,CantidadMaletas");
                bw.newLine();
            }

            for (Reserva reserva : listaReservas) {
                String filaReserva = reserva.getUsername()+","+reserva.getFechaVuelo()+","+reserva.getTipoVuelo()+","+ reserva.getCantidadBoletos()
                                    +","+reserva.getAerolinea()+","+ reserva.getNumeroTarjeta()+","+ reserva.getCuotas()+","+ reserva.getClaseVuelo()
                                    +","+ reserva.getNumeroAsientos()+","+ reserva.getCantidadMaletas();
                bw.write(filaReserva);
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            System.out.println("ERROR EN EL MOMENTO DE CARGAR LA DATA");
        }
    }

    //Método para leer la data de reservación
    @Override
    public void leerReservacion(){
        try {
            String linea;
            //Leer archivo csv
            BufferedReader br = new BufferedReader(new FileReader("reservas.csv"));
            br.readLine();

            while((linea = br.readLine()) != null){
                String datos[] = linea.split(",");
                Reserva reserva =  new Reserva("", "", false, 0, "", "", 0, "", "", 0);
                reserva.setUsername(datos[0]);
                reserva.setFechaVuelo(datos[1]);
                reserva.setTipoVuelo(Boolean.parseBoolean(datos[2]));
                reserva.setCantidadBoletos(Integer.parseInt(datos[3]));
                reserva.setAerolinea(datos[4]);
                reserva.setNumeroTarjeta(datos[5]);
                reserva.setCuotas(Integer.parseInt(datos[6]));
                reserva.setClaseVuelo(datos[7]);
                reserva.setNumeroAsientos(datos[8]);
                reserva.setCantidadMaletas(Integer.parseInt(datos[9]));
            }

        } catch (Exception e) {
            System.out.println("ADVERTENCIA, NO HAY DATA EN EL ARCHIVO CSV");
        }
    }

    //Método propio del controlador, encargado de llmar a registroUsuario
    public void registrarMiUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---INGRESAR DATOS USUARIO---");
        System.out.println("Username");
        String username = sc.nextLine();
        System.out.println("Password");
        String password = sc.nextLine();
        System.out.println("Tipo Usuario:");
        System.out.println("  1. Premium");
        System.out.println("  2. Base");
        String indice = sc.nextLine();
        String tipoUsuario = "";
        if(indice.equals("1")) tipoUsuario = "Premium";
        else if(indice.equals("2")) tipoUsuario = "Base";

        registroUsuario(username, password, tipoUsuario);
        System.out.println("\nUsuario registrado correctamente");
    }

    //Método que registra un usuario
    
    @Override
    public void registroUsuario(String username, String password, String tipoUsuario){
        //Agregar usuario a la lista
        Usuario usuario = new Usuario(username, password, tipoUsuario);
        listaUsuarios.add(usuario);
        guardarUsuario();
    }

    @Override
    public Usuario login(String username, String password){
        String tipoUsuario = "";
        boolean bandera = false;
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getUsername().equals(username) & usuario.getPassword().equals(password)){
                System.out.println("Logeado exitosamente");
                usernameGlobal = usuario.getUsername();
                tipoUsuario = usuario.getTipoUsuario();
                //Sub menú
                subMenu(tipoUsuario, username);
                bandera = true;
            }
        }
        if(bandera == false) System.out.println("Credenciales Incorrectas");
        return null;
    }

    @Override
    public void reservacion(String fechaVuelo, boolean TipoVuelo, int cantidadBoletos, String aerolinea, String username){
        //Imprimir Itinerario
        System.out.println("Fecha de Vuelo: "+ fechaVuelo + ", Tipo de Vuelo: "+ TipoVuelo
                                + ", Cantidad Boletos: " + cantidadBoletos+ ", Aerolínea: " + aerolinea);
    }

    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsientos, int cantidadMaletas){
        //imprimir itenerario
        System.out.println("Numero de Tarjeta: " + numeroTarjeta + ", Cuotas: " + cuotas + ", ClaseVuelo: "+ claseVuelo +
                            ", Número Asientos: "  + numeroAsientos + ", Cantidad Maletas: " + cantidadMaletas);
    }

    @Override
    public String itinerario(){
        int reserva = listaReservas.size() -1;
        return "\n¡Reservación realizada correctamente! \n" + 
            listaReservas.get(reserva).toString()
         ;
    }


    //SubMenú
    /**
     * 
     * @param tipoUsuario Captura si es usuario Base o Premium
     * @param username Captura el username del usuario logeado
     */
    public void subMenu(String tipoUsuario, String username){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---SUB MENÚ---");
        if(tipoUsuario.equals("Premium")){
            boolean continuar = true;
            while (continuar) {
                System.out.println("1. Realizar reservación");
                System.out.println("2. Cambiar Contraseña");
                System.out.println("3. Salir");
                String opcionA = sc.nextLine();
                if(opcionA.equals("1")){
                    //Realizar reservación
                    realizarReservacionPremium(username);
                }else if(opcionA.equals("2")){
                    System.out.println("\nIngresar nueva contraseña: ");
                    String nuevaPassword = sc.nextLine();
                    cambiarPassword(nuevaPassword);
                }
                else if(opcionA.equals("3")){
                    continuar = false;
                }else System.out.println("Opción inválida");

            }

        }else if(tipoUsuario.equals("Base")){
            boolean continuar = true;
            while (continuar) {
                System.out.println("1. Realizar reservación");
                System.out.println("2. Cambiar Contraseña");
                System.out.println("3. Cambiar a usuario Premium");
                System.out.println("4. Salir");
                String opcionB = sc.nextLine();
                if(opcionB.equals("1")){
                    realizarReservacionBase(username);
                }else if(opcionB.equals("2")){
                    System.out.println("\nIngresar nueva contraseña: ");
                    String nuevaPassword = sc.nextLine();
                    cambiarPassword(nuevaPassword);
                }else if(opcionB.equals("3")){
                    cambiarTipoUsuario();
                }
                else if(opcionB.equals("4")){
                    continuar  =false;
                }else System.out.println("Opción inválida");
                
            }


        }else System.out.println("Tipo de usuario incorrecto");
    }


    //Método del controlador para realizar la reservación del vuelo
    /**
     * 
     * @param username Captura el username del usuario
     */
    public void realizarReservacionPremium(String username){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n---MODO RESERVAS---");
            System.out.println("Fecha Vuelo:");
            String fechaVuelo = sc.nextLine();
            System.out.println("Tipo Vuelo:");
            System.out.println("  1. Ida y Vuelta");
            System.out.println("  2. Solo Ida");
            String opcionVuelo = sc.nextLine();
            boolean tipoVuelo = false;
            if(opcionVuelo.equals("1")) tipoVuelo = true;
            else if(opcionVuelo.equals("2")) tipoVuelo = false;
            System.out.println("Cantidad Boletos");
            int cantidadBoletos = sc.nextInt();
            sc.nextLine();
            System.out.println("Aerolínea:");
            String aerolinea = sc.nextLine();
            reservacion(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username);
            
            //Paso de Confirmación
            System.out.println("\n---MODO CONFIRMACIÓN---");
            System.out.println("Número de Tarjeta:");
            String numeroTarjeta = sc.nextLine();
            System.out.println("Número de asiento:");
            String numeroAsiento = sc.nextLine();
            System.out.println("Cantidad de maletas:");
            int cantidadMaletas = sc.nextInt();
            sc.nextLine();
            confirmacion(numeroTarjeta, 0, "NA", numeroAsiento, cantidadMaletas);


            //AgregarReservación
            Reserva reserva = new Reserva(username, fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, numeroTarjeta, 0, "NA", numeroAsiento, cantidadMaletas);
            listaReservas.add(reserva);
            guardarReserva();
            System.out.println(itinerario());

        } catch (Exception e) {
            System.out.println("Ingresar valores válidos");
        }
    }

    //Método del controlador para realizar la reservación del vuelo
    /**
     * 
     * @param username Captura el username del usuario
     */
    public void realizarReservacionBase(String username){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n---MODO RESERVAS---");
            System.out.println("Fecha Vuelo:");
            String fechaVuelo = sc.nextLine();
            System.out.println("Tipo Vuelo:");
            System.out.println("  1. Ida y Vuelta");
            System.out.println("  2. Solo Ida");
            String opcionVuelo = sc.nextLine();
            boolean tipoVuelo = false;
            if(opcionVuelo.equals("1")) tipoVuelo = true;
            else if(opcionVuelo.equals("2")) tipoVuelo = false;
            System.out.println("Cantidad Boletos");
            int cantidadBoletos = sc.nextInt();
            sc.nextLine();
            System.out.println("Aerolínea:");
            String aerolinea = sc.nextLine();
            reservacion(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username);
            
            //Paso de Confirmación
            System.out.println("\n---MODO CONFIRMACIÓN---");
            System.out.println("Número de Tarjeta:");
            String numeroTarjeta = sc.nextLine();
            boolean bandera = true;
            int cuotas = 0;
            while(bandera){
                System.out.println("Cantidad de cuotas:");
                cuotas =sc.nextInt();
                sc.nextLine();
                if(cuotas>24 || cuotas<0) System.out.println("Solo tienes hasta 24 cuotas, ingresa otra cantidad");
                else bandera = false;
            }
            System.out.println("Definir clase par vuelo:");
            System.out.println("  1. Coach");
            System.out.println("  2. Primera Clase");
            String opcionClaseVuelo = sc.nextLine();
            String claseVuelo = "";
            if(opcionClaseVuelo.equals("1")) claseVuelo = "Coach";
            else if(opcionClaseVuelo.equals("2")) claseVuelo = "Primero Clase";
            confirmacion(numeroTarjeta, cuotas, claseVuelo, "", 0);
            System.out.println("Aplicar cupón de 10% de decuento");
            System.out.println("  1. Si");
            System.out.println("  2. No");
            String cupon = sc.nextLine();
            if(cupon.equals("1")) System.out.println("Cupón Aplicado Existosamente");
            else if(cupon.equals("2")) System.out.println("Cupón No Aplicado");

            //AgregarReservación
            Reserva reserva = new Reserva(username, fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, numeroTarjeta, cuotas, claseVuelo, "NA", 0);
            listaReservas.add(reserva);
            guardarReserva();
            System.out.println(itinerario());

        } catch (Exception e) {
            System.out.println("Ingresar valores válidos");
        }
    }

    //Método para cambiar la contraseña de cualquier usuario
    @Override
    public void cambiarPassword(String nuevaPassword){
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getUsername().equals(usernameGlobal)) {
                usuario.setPassword(nuevaPassword);
            }
        }
        System.out.println("\n¡Contraseña actualizada exitosamente!");
        guardarUsuario();
    }

    //Método para cambiar el tipo de Usuario de un usuario Base
    @Override
    public void cambiarTipoUsuario(){
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getUsername().equals(usernameGlobal)) {
                usuario.setTipoUsuario("Premium");
            }
        }
        System.out.println("\n¡Usuario cambiado a Premiun!");
        guardarUsuario();
    }

}
