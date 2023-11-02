/*
 * Create by Maira Perez - 27102023
 * mlp243@gmail.com
*/
package Usuario;

public class clsUsuarios {
    
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String CorreoE;
    private String Direccion;
    private String Telefono;

    public clsUsuarios(){
        this.DNI = "";
        this.Nombre = "";
        this.Apellidos = "";
        this.CorreoE = "";
        this.Direccion = "";
        this.Telefono = "";
    }
    
    public clsUsuarios(String DNI, String Nombre, String Apellidos, String CorreoE, String Direccion, String Telefono) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.CorreoE = CorreoE;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getCorreoE() {
        return CorreoE;
    }

    public void setCorreoE(String CorreoE) {
        this.CorreoE = CorreoE;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Usuario: {" + "DNI=" + DNI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", CorreoE=" + CorreoE + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
    }
      
    
}
