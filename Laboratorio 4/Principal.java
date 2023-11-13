import java.util.Scanner;
/**
 * @author Humberto Alexander de la Cruz Chanchavac
 * @version 1.0
 * @since 10/11/2023 al 12/11/2023
 * Descripción: Programa para automatizar la reservación de vuelos
 *              Las opciones y funcionalidades son las siguientes:
 *              1.	Registrarse
                2.	Cambiar contraseña de usuario
                3.	Cambiar tipo de Usuario (Premium, No premium)
                4.	Iniciar sesión con sus credenciales
                5.	Realizar reservación
                6.	Confirmar reservación
                7.	Imprimir itinerario
                8.	Leer Data
                9.	Guardar Data
 */

public class Principal{
    public static void main(String[] args) {
        Kayak kayak = new Kayak();
        kayak.leerUsuario();
        kayak.leerReservacion();

        boolean bandera = true;
        while (bandera){
            System.out.println("\n----INFORMACIÓN ELECTRÓNICOS----");
            System.out.println("1. Registrase");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir del programa");
    
            Scanner sc = new Scanner(System.in);
            String opcion = sc.nextLine();

            if(opcion.equals("1")){
                kayak.registrarMiUsuario();
            }
            else if(opcion.equals("2")){
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n---LOGIN---");
                System.out.println("Ingresar Username:");
                String username = sc.nextLine();
                System.out.println("Ingresar Password:");
                String password = sc.nextLine();
                kayak.login(username, password);
            }

            else if(opcion.equals("3")){
                bandera = false;
            }


            else System.out.println("Debe seleccionar una opción válida");

        }
    }
}