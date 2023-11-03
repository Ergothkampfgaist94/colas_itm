package colas_base_251023;

import Controladores.clsControladores;
import javax.swing.JOptionPane;

public class COLAS_Base_251023 {

    public static void main(String[] args) {
        clsControladores met = new clsControladores();
        int opcion = 0;
        while (opcion != 7) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("PROCESAMIENTO DE LIBROS\n"
                    + "1. Agregar cliente\n"
                    + "2. Modificar cliente\n"
                    + "3. Mostrar cliente\n"
                    + "4. Eliminar cliente\n"
                    + "5. Buscar cliente\n"
                    + "6. Cantidad de libros\n"
                    + "7. Salir del sistema\n"));

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null,
                            met.CrearCliente());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, met.ActualizarCliente(
                            JOptionPane.showInputDialog("¿DN1?")
                    ));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, met.LeerCliente());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, met.EliminarCliente(
                            JOptionPane.showInputDialog("¿DN1?")));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, met.BuscarCliente(
                            JOptionPane.showInputDialog("¿DN1?")));
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "¡Opción incorrecta!\n\n"
                            + "Intentalo de nuevo");
            }

        }

    }

}
