package src;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDobleEmpleado lista = new ListaDobleEmpleado();

        int opcion = 0; // Variable para almacenar la opción del usuario
        
        do { // Ciclo do-while para que el menú se ejecute al menos una vez
            
            // Menú de opciones en JOptionPane
            String menu = "=== MENÚ DE EMPLEADOS ===\n"
                    + "1. Insertar Empleado\n"
                    + "2. Buscar Empleado por ID\n"
                    + "3. Eliminar Empleado por ID\n"
                    + "4. Mostrar Lista de Empleados\n"
                    + "5. Ordenar por Nombre (Ascendente)\n"
                    + "6. Ordenar por Nombre (Descendente)\n"
                    + "7. Ordenar por Salario (Ascendente)\n"
                    + "8. Ordenar por Salario (Descendente)\n"
                    + "9. Calcular Promedio de Salario\n"
                    + "10. Encontrar Empleado con Salario Máximo\n"
                    + "11. Encontrar Empleado con Salario Mínimo\n"
                    + "12. Salir";

            String opcion2 = JOptionPane.showInputDialog(menu); // Captura la opción del usuario como String
            
            try {
                opcion = Integer.parseInt(opcion2); // Convierte la opción a entero
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número.", null, JOptionPane.ERROR_MESSAGE);
                continue; // Si la conversión falla, reinicia el ciclo
            }

            switch (opcion) {
                case 1: // Insertar Empleado
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado: ");
                    
                    String id2 = JOptionPane.showInputDialog("Ingrese ID del empleado: ");
                    int id = Integer.parseInt(id2); // Conversión de ID a entero
                    
                    String salario2 = JOptionPane.showInputDialog("Ingrese el salario del empleado: ");
                    float salario = Float.parseFloat(salario2); // Conversión de salario a float
                    
                    // Verifica si el ID ya existe antes de insertar
                    if (lista.Buscar_Empleado(id) != null) {
                        JOptionPane.showMessageDialog(null, "Error: Ya existe un empleado con el mismo ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    } else {
                        lista.Insertar_Empleado(new Empleado(nombre, id, salario));
                    }

                    JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.", null, JOptionPane.INFORMATION_MESSAGE);
                    lista.Mostrar_Estadisticas(); // Muestra las estadísticas actualizadas
                    break;

                case 2: // Buscar Empleado por ID
                    String idBuscar2 = JOptionPane.showInputDialog("Ingrese ID del empleado a buscar: ");
                    int idBuscar = Integer.parseInt(idBuscar2);
                    
                    Empleado encontrado = lista.Buscar_Empleado(idBuscar);
                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, "Empleado encontrado: " + encontrado.getNombre() + " | ID: " + encontrado.getId() + " | Salario: " + encontrado.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un empleado con ese ID.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 3: // Eliminar Empleado por ID
                    String idEliminar2 = JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar: ");
                    int idEliminar = Integer.parseInt(idEliminar2);
                    
                    boolean eliminado = lista.Elimiar_Empleado(idEliminar);
                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.", null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un empleado con ese ID.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    lista.Mostrar_Estadisticas();
                    break;

                case 4: // Mostrar Lista de Empleados
                    lista.Imprimir_Lista();
                    break;

                case 5: // Ordenar por Nombre Ascendente
                    lista.Ordenar_Por_Nombre(true);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por nombre en orden ascendente.", null, JOptionPane.INFORMATION_MESSAGE);
                    lista.Mostrar_Estadisticas();
                    break;

                case 6: // Ordenar por Nombre Descendente
                    lista.Ordenar_Por_Nombre(false);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por nombre en orden descendente.", null, JOptionPane.INFORMATION_MESSAGE);
                    lista.Mostrar_Estadisticas();
                    break;

                case 7: // Ordenar por Salario Ascendente
                    lista.Ordenar_Por_Salario(true);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por salario en orden ascendente.", null, JOptionPane.INFORMATION_MESSAGE);
                    lista.Mostrar_Estadisticas();
                    break;

                case 8: // Ordenar por Salario Descendente
                    lista.Ordenar_Por_Salario(false);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por salario en orden descendente.", null, JOptionPane.INFORMATION_MESSAGE);
                    lista.Mostrar_Estadisticas();
                    break;

                case 9: // Calcular Promedio de Salario
                    float promedio = lista.Calcular_Promedio_Salario();
                    JOptionPane.showMessageDialog(null, "El salario promedio es: " + promedio, null, JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 10: // Encontrar Salario Máximo
                    Empleado maxSalario = lista.Encontrar_Salario_Maximo();
                    if (maxSalario != null) {
                        JOptionPane.showMessageDialog(null, "Empleado con el salario más alto: " + maxSalario.getNombre() + " | Salario: " + maxSalario.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista está vacía.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 11: // Encontrar Salario Mínimo
                    Empleado minSalario = lista.Encontrar_Salario_Minimo();
                    if (minSalario != null) {
                        JOptionPane.showMessageDialog(null, "Empleado con el salario más bajo: " + minSalario.getNombre() + " | Salario: " + minSalario.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista está vacía.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 12: // Salir del programa
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...", null, JOptionPane.INFORMATION_MESSAGE);
                    break;

                default: // Manejo de opción inválida
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", null, JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 12); // Repetir hasta que el usuario elija salir

        scanner.close(); // Cierra el scanner
    }
}
