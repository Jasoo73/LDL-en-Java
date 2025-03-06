package src;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDobleEmpleado lista = new ListaDobleEmpleado();

        int opcion = 0;                 
        
        do {                              //Do while para que entre al menos una vez al ciclo.
            

            /*JOptionPane.showMessageDialog(
                null,
                 "1. Insertar Empleado\n2. Buscar Empleado por ID\n3. Eliminar Empleado por ID\n4. Mostrar Lista de Empleados\n5. Ordenar por Nombre (Ascendente)\n6. Ordenar por Nombre (Descendente)\n7. Ordenar por Salario (Ascendente)\n8. Ordenar por Salario (Descendente)\n9. Calcular Promedio de Salario\n10. Encontrar Empleado con Salario Máximo\n11. Encontrar Empleado con Salario Mínimo\n12. Salir",
                "\n=== MENÚ DE EMPLEADOS ===",
                JOptionPane.PLAIN_MESSAGE);
            */

            //JOptionPane.showMessageDialog(null, "Información", "title", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Información", "title", JOptionPane.QUESTION_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Información", "title", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Información", "title", JOptionPane.ERROR_MESSAGE);

            //int decision = JOptionPane.showConfirmDialog(null, "Bro, do you even code?", null, JOptionPane.YES_NO_CANCEL_OPTION);

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

            String opcion2 = JOptionPane.showInputDialog(menu);
            
            //Opcion 2 es una variable auxiliar para hacer la conversión de tipos de String a entero 

            try {
                    // Intentamos convertir la opción ingresada a un entero
                    opcion = Integer.parseInt(opcion2);
                } catch (NumberFormatException e) {
                    // Si no es un número válido, mostramos un mensaje de error y continuamos el ciclo
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número.", null, JOptionPane.ERROR_MESSAGE);
                    continue; 
                }
            
            //System.err.println(name);

            //JOptionPane.showOptionDialog(null, "you are awesome", "secret message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);


            //opcion = scanner.nextInt();
            //scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) { 
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado: ");

                    String id2 = JOptionPane.showInputDialog("Ingrese ID del empleado: ");
                    int id = Integer.parseInt(id2);

                    String salario2 = JOptionPane.showInputDialog("Ingrese el salario del empleado: ");
                    float salario = Integer.parseInt(salario2);

                    // Llamar al método de insertar y verificar si el ID ya existe
                    if (lista.Buscar_Empleado(id) != null) {
                        // Si el ID ya existe, mostrar un mensaje de error y no agregar al empleado
                        JOptionPane.showMessageDialog(null, "Error: Ya existe un empleado con el mismo ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    } 
                    else {
                        // Si el ID no existe, insertar el empleado
                        lista.Insertar_Empleado(new Empleado(nombre, id, salario));
                    }

                    JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.", null, JOptionPane.INFORMATION_MESSAGE);

                    lista.Mostrar_Estadisticas();

                    break;

                case 2:
                    String idBuscar2 = JOptionPane.showInputDialog("Ingrese ID del empleado a buscar: ");
                    int idBuscar = Integer.parseInt(idBuscar2);
                    
                    Empleado encontrado = lista.Buscar_Empleado(idBuscar);
                    if (encontrado != null) {
                        JOptionPane.showMessageDialog(null, "Empleado encontrado: " + encontrado.getNombre() + " | ID: " + encontrado.getId() + " | Salario: " + encontrado.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 3:
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

                case 4:
                    lista.Imprimir_Lista();
                    break;

                case 5:
                    lista.Ordenar_Por_Nombre(true);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por nombre en orden ascendente.", null, JOptionPane.INFORMATION_MESSAGE);

                    lista.Mostrar_Estadisticas();

                    break;

                case 6:
                    lista.Ordenar_Por_Nombre(false);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por nombre en orden descendente.", null, JOptionPane.INFORMATION_MESSAGE);

                    lista.Mostrar_Estadisticas();

                    break;

                case 7:
                    lista.Ordenar_Por_Salario(true);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por salario en orden ascendente.", null, JOptionPane.INFORMATION_MESSAGE);

                    lista.Mostrar_Estadisticas();

                    break;

                case 8:
                    lista.Ordenar_Por_Salario(false);
                    JOptionPane.showMessageDialog(null, "Lista ordenada por salario en orden descendente.", null, JOptionPane.INFORMATION_MESSAGE);

                    lista.Mostrar_Estadisticas();

                    break;

                case 9:
                    float promedio = lista.Calcular_Promedio_Salario();
                    JOptionPane.showMessageDialog(null, "El salario promedio es: " + promedio, null, JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 10:
                    Empleado maxSalario = lista.Encontrar_Salario_Maximo();
                    if (maxSalario != null) {
                        JOptionPane.showMessageDialog(null, "Empleado con el salario más alto: " + maxSalario.getNombre() + " | Salario: " + maxSalario.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista está vacía.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 11:
                    Empleado minSalario = lista.Encontrar_Salario_Minimo();
                    if (minSalario != null) {
                        JOptionPane.showMessageDialog(null, "Empleado con el salario más bajo: " + minSalario.getNombre() + " | Salario: " + minSalario.getSalario(), null, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista está vacía.", null, JOptionPane.WARNING_MESSAGE);
                    }
                    break;

                case 12:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...", null, JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.", null, JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 12); 

        scanner.close();
    }
}
