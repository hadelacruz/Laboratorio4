public interface Reservacion {

    //Métodos de la Interfza Reservación
    /**
     * 
     * @param username Username de la persona registrada
     * @param password Contrasela del usuario
     * @param tipoUsuario Tipo usuario del usuario (Premium o Base)
     */
    public void registroUsuario(String username, String password, String tipoUsuario);

    /**
     * 
     * @param nuevaPassword Nueva contraseña de la cuenta
     */
    public void cambiarPassword(String nuevaPassword);

    //Cambiar de Base a Premiun
    public void cambiarTipoUsuario();

    /***
     * 
     * @param username Username de la persona registrada
     * @param password Contraseña del usuario
     * @return
     */
    public Usuario login(String username, String password);

    /**
     * 
    * @param username         El nombre de usuario de la persona que realiza la reserva de vuelo.
    * @param fechaVuelo       La fecha del vuelo.
    * @param tipoVuelo        El tipo de vuelo 
    * @param cantidadBoletos  La cantidad de boletos 
    * @param aerolinea        La aerolínea del vuelo.
     */
    public void reservacion(String fechaVuelo, boolean TipoVuelo, int cantidadBoletos, String aerolinea, String username);

    /**
     * 
    * @param numeroTarjeta    El número de tarjeta de crédito utilizado para el pago.
    * @param cuotas           El número de cuotas si el pago se realiza en cuotas.
    * @param claseVuelo       La clase del vuelo.
    * @param numeroAsientos   El número de asiento o rango de números de asiento.
    * @param cantidadMaletas  La cantidad de maletas o equipaje facturado.
     */
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsientos, int cantidadMaletas);

    //Imprimir datos reservación
    public String itinerario();

    //Métodos para guardar y leer data de usuarios y reservas
    public void guardarUsuario();
    public void guardarReserva();
    public void leerUsuario();
    public void leerReservacion();
}
