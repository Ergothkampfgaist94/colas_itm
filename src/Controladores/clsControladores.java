/*
 * Create by Maira Perez - 27102023
 * mlp243@gmail.com
 */
package Controladores;

import Usuario.clsClientes;
import Usuario.clsEmpleados;
import Cola.Cola;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class clsControladores {

    clsClientes objCliente;
    clsEmpleados objEmpleados;
    Cola<clsClientes> colaCliente;
    Cola<clsClientes> colaClienteAux;
    Cola<clsEmpleados> colaEmpleados;
    Cola<clsEmpleados> colaEmpleadosAux;
    String Cadena;
    int ContCliente;
    boolean Banderita;

    public clsControladores() {
        objCliente = new clsClientes();
        objEmpleados = new clsEmpleados();
        colaCliente = new Cola();
        colaClienteAux = new Cola();
        colaEmpleados = new Cola();
        colaEmpleadosAux = new Cola();
        Cadena = "";
        ContCliente = 0;
        Banderita = false;
    }

    /* METODOS PARA LA GESTION DE CLIENTES */
    // METODO CREATE
    public String CrearCliente() {

        // IMPLEMENTAREMOS EL TRY -- CACTH QUE NOS VA PERMITIR DARLE UNA TRAZABILIDAD A LAS TRANSACCIONES DEL PROCESO
        // Este while permite INSERTAR DATOS A LA COLA GENERANDO LA DIRECCIÓN DE MEMORIA DEL NODO
        try {
            while (JOptionPane.showConfirmDialog(null,
                    "¿Desea crear un cliente nuevo?") == JOptionPane.YES_NO_OPTION) {
                colaCliente.Encolar(new clsClientes(
                        JOptionPane.showInputDialog("Ingrese el DNI del cliente: "),
                        JOptionPane.showInputDialog("Ingrese el nombre del cliente: "),
                        JOptionPane.showInputDialog("Ingrese los apellidos del cliente: "),
                        JOptionPane.showInputDialog("Ingrese correo electrónico del cliente: "),
                        JOptionPane.showInputDialog("Ingrese la dirección del cliente: "),
                        JOptionPane.showInputDialog("Ingrese el telefono del cliente: "),
                        JOptionPane.showInputDialog("Ingrese la de naciemiento del cliente (DD-MM-AAAA): ")
                ));
                ContCliente++;
            }
            // CUANDO FINALIZA DE AGREGAR MUESTRA EL MENSAJE DE EXITO, CON EL CONTADOR DE CLIENTES GLOBAL
            Cadena = "Clientes registrados con éxito, fueron un total de " + ContCliente;

            // RETORNAMOS EL ERROR
            return Cadena;

        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            Cadena = "Error al insertar clientes en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return Cadena;
        }

    }

    // METODO READ
    public String LeerCliente() {

        try {
            // INICIALIZAMOS A CADENA CON UNA VALOR NUEVO
            Cadena = "LISTADO DE CLIENTES REGISTRADOS EN EL SISTEMA\n\n";

            // VERIFICAMOS QUE LA COLA ESTE VACIA
            while (!colaCliente.EstaVacia()) {

                // CARGAMOS EL OBJETO DEL CLIENTE CON LOS DATOS DE LA COLA
                objCliente = colaCliente.getElementos();

                // LISTAMOS LOS DATOS EN LA CADENA
                Cadena += "DNI: " + objCliente.getDNI() + "\n"
                        + "Nombre: " + objCliente.getNombre() + "\n"
                        + "Apellidos: " + objCliente.getApellidos() + "\n"
                        + "Correo electrónico: " + objCliente.getCorreoE() + "\n"
                        + "Dirección: " + objCliente.getDireccion() + "\n"
                        + "Teléfono: " + objCliente.getTelefono() + "\n"
                        + "Fecha de Nacimiento: " + objCliente.getCorreoE() + "\n"
                        + "---------------------------------\n\n";

                // ENCOLAMOS EN LA COLA AUXILIAR EL DATO QUE ACAMOS DE RECORRER
                colaClienteAux.Encolar(colaCliente.getElementos());

                // ELIMINAMOS EL DATO SIGUIENTE DE LA COLA
                colaCliente.Desencolar();
            }

            // RETORNA LA COLA AUXILIAR A LA COLA PRINCIPAL DE CLIENTES
            returnColaClientes(colaClienteAux);

            // VALIDA QUE SI EXISTAN DATOS EN COLA PARA MOSTRAR EL TOTAL
            if (ContCliente != 0) {
                Cadena += "TOTAL DE CLIENTES REGISTRADOS " + ContCliente;
            }

            // RETORNAMOS LA CADENA LLENA DE DATOS
            return Cadena;
        } catch (HeadlessException e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            Cadena = "Error al leer clientes en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return Cadena;
        }

    }

    // METODO PARA ACTUALIZAR LA COLA DE CLIENTES POR EL DNI
    public String ActualizarCliente(String DNI) {
        try {
            Cadena = "";
            while (!colaCliente.EstaVacia()) {
                clsClientes objCliente;
                objCliente = colaCliente.getElementos();

                if (objCliente.getDNI().equalsIgnoreCase(DNI)) {
                    objCliente.setNombre("Nuevo nombre: \n");
                    objCliente.setApellidos("Nuevo apellido: \n");
                    objCliente.setCorreoE("Nuevo correo: \n");
                    objCliente.setDireccion("Nueva Dirección: \n");
                    objCliente.setFechaNac("Nuevo fecha de nacimiento: \n");
                    objCliente.setTelefono("Nuevo telefono: \n");

                    colaClienteAux.Encolar(colaCliente.getElementos());
                    colaCliente.Desencolar();

                } else {
                    colaClienteAux.Encolar(colaCliente.getElementos());
                    colaCliente.Desencolar();
                }

            }
        } catch (HeadlessException e) {
            Cadena = "Error al leer clientes en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return Cadena;

        }
        returnColaClientes(colaClienteAux);

        return Cadena;
    }
    // METODO PARA ELIMINAR UN CLIENTE POR EL DNI

    public String EliminarCliente(String DNI) {

        try {
            Cadena = "";
            Banderita = false;

            while (!colaCliente.EstaVacia()) {

                objCliente = colaCliente.getElementos();

                if (objCliente.getDNI().equalsIgnoreCase(DNI)) {
                    Banderita = true;
                    ContCliente--;
                    colaCliente.Desencolar();
                } else {
                    colaClienteAux.Encolar(colaCliente.getElementos());
                    colaCliente.Desencolar();
                }
            }

            if (Banderita) {
                Cadena = "El registro del libro fue encontrado y eliminado";
            } else {
                Cadena = "El ISBN del libro no fue encontrado";
            }

            returnColaClientes(colaClienteAux);
            return Cadena;

        } catch (Exception e) {
            // CAPTURAMOS EL ERROR DEL PROCESO Y LO ASIGNAMOS A CADENA
            Cadena = "Error al eliminar cliente en la COLA: " + e.getMessage();

            // RETORNAMOS EL ERROR
            return Cadena;
        }

    }

    // METODO PARA BUSCAR UN CLIENTE POR EL DNI
    public String BuscarCliente(String DNI) {

        Cadena = "";

        return Cadena;
    }

    // METODO PARA BUSCAR UN CLIENTE POR EL NOMBRE
    public String BuscarClienteNombre(String DNI) {

        Cadena = "";

        return Cadena;
    }

    // METODO QUE RETORNA LA COLA AUXILIAR A LA PRINCIPAL
    private void returnColaClientes(Cola<clsClientes> AuxCliente) {
        try {
            while (!AuxCliente.EstaVacia()) {
                colaCliente.Encolar(AuxCliente.getElementos());
                AuxCliente.Desencolar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al devolver la Cola de Clientes: " + e.getMessage());
        }
    }

    /* FIN METODOS CLIENTES */
}
