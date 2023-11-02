package colas_base_251023;

import Controladores.clsControladores;
import javax.swing.JOptionPane;

public class COLAS_Base_251023 {

    public static void main(String[] args) {
        clsControladores met = new clsControladores();
        int opcion = 0;
        while (opcion != 7) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog("PROCESAMIENTO DE LIBROS\n"
                    + "1. Agregar libros\n"
                    + "2. Eliminar libro\n"
                    + "3. Modificar libro\n"
                    + "4. Buscar libro\n"
                    + "5. Mostrar inventario\n"
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

                default:
                    JOptionPane.showMessageDialog(null, "¡Opción incorrecta!\n\n"
                            + "Intentalo de nuevo");
            }

        }

    }

}
