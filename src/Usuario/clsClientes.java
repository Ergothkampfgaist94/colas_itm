/*
 * Create by Maira Perez - 27102023
 * mlp243@gmail.com
 */
package Usuario;

public class clsClientes extends clsUsuarios {

    private String FechaNac;

    public clsClientes() {
        this.FechaNac = "";
    }

    public clsClientes(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public clsClientes(String DNI, String Nombre, String Apellidos,
            String CorreoE, String Direccion, String Telefono,
            String FechaNac) {
        super(DNI, Nombre, Apellidos, CorreoE, Direccion, Telefono);
        this.FechaNac = FechaNac;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    @Override
    public String toString() {
        return super.toString() + "Fecha Nacimiento =" + FechaNac + '}';
    }

}
