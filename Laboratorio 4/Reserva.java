public class Reserva {
    //Atributos
    private String username;
    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private String numeroAsientos;
    private int cantidadMaletas;

    public Reserva(){

    }

    /**
     * 
    * @param username         El nombre de usuario de la persona que realiza la reserva de vuelo.
    * @param fechaVuelo       La fecha del vuelo.
    * @param tipoVuelo        El tipo de vuelo 
    * @param cantidadBoletos  La cantidad de boletos 
    * @param aerolinea        La aerolínea del vuelo.
    * @param numeroTarjeta    El número de tarjeta de crédito utilizado para el pago.
    * @param cuotas           El número de cuotas si el pago se realiza en cuotas.
    * @param claseVuelo       La clase del vuelo.
    * @param numeroAsientos   El número de asiento o rango de números de asiento.
    * @param cantidadMaletas  La cantidad de maletas o equipaje facturado.
     */
    public Reserva(String username, String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsientos, int cantidadMaletas) {
        this.username = username;
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsientos = numeroAsientos;
        this.cantidadMaletas = cantidadMaletas;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFechaVuelo() {
        return this.fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public boolean isTipoVuelo() {
        return this.tipoVuelo;
    }

    public boolean getTipoVuelo() {
        return this.tipoVuelo;
    }

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getAerolinea() {
        return this.aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return this.cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getClaseVuelo() {
        return this.claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public String getNumeroAsientos() {
        return this.numeroAsientos;
    }

    public void setNumeroAsientos(String numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public int getCantidadMaletas() {
        return this.cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    @Override
    public String toString() {
        return "Fecha de Vuelo: "+ getFechaVuelo() + ", Tipo de Vuelo: "+ getTipoVuelo()
        + ", Cantidad Boletos: " + getCantidadBoletos()+ ", Aerolínea: " + getAerolinea() + 
        "Numero de Tarjeta: " + getNumeroTarjeta() + ", Cuotas: " + getCuotas() + ", ClaseVuelo: "+ getClaseVuelo() +
        ", Número Asientos: "  + getNumeroAsientos() + ", Cantidad Maletas: " + getCantidadMaletas();
    }


}
