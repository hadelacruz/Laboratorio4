public class Usuario {
    //Atributos
    private String username;
    private String password;
    private String tipoUsuario;

    public Usuario(){

    }

    /**
     * 
     * @param username Username de la persona registrada
     * @param password Contrasela del usuario
     * @param tipoUsuario Tipo usuario del usuario (Premium o Base)
     */
    public Usuario(String username, String password, String tipoUsuario) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", tipoUsuario='" + getTipoUsuario() + "'" +
            "}";
    }

}
