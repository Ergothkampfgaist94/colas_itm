/*
 * Create by Maira Perez - 27102023
 * mlp243@gmail.com
 */
package Usuario;

public class clsEmpleados extends clsUsuarios {

    private int CantHTM;
    private float ValorHora;
    private int Rol;

    public clsEmpleados() {
        this.CantHTM = 0;
        this.ValorHora = 0;
        this.Rol = 0;
    }

    public clsEmpleados(int CantHTM, float ValorHora, int Rol) {
        this.CantHTM = CantHTM;
        this.ValorHora = ValorHora;
        this.Rol = Rol;
    }

    public clsEmpleados(int CantHTM,
            float ValorHora,
            int Rol,
            String DNI,
            String Nombre,
            String Apellidos,
            String CorreoE,
            String Direccion,
            String Telefono) {
        super(DNI, Nombre, Apellidos, CorreoE, Direccion, Telefono);
        this.CantHTM = CantHTM;
        this.ValorHora = ValorHora;
        this.Rol = Rol;
    }

    public int getCantHTM() {
        return CantHTM;
    }

    public void setCantHTM(int CantHTM) {
        this.CantHTM = CantHTM;
    }

    public float getValorHora() {
        return ValorHora;
    }

    public void setValorHora(float ValorHora) {
        this.ValorHora = ValorHora;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    @Override
    public String toString() {
        return super.toString()
                + "CantHTM=" + CantHTM
                + ", ValorHora=" + ValorHora
                + ", Rol=" + Rol + '}';
    }

}
