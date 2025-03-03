package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDobleEmpleado lista = new ListaDobleEmpleado();

        int opcion;
        do {
            System.out.println("\n=== MENÚ DE EMPLEADOS ===");
            System.out.println("1. Insertar Empleado");
            System.out.println("2. Buscar Empleado por ID");
            System.out.println("3. Eliminar Empleado por ID");
            System.out.println("4. Mostrar Lista de Empleados");
            System.out.println("5. Ordenar por Nombre (Ascendente)");
            System.out.println("6. Ordenar por Nombre (Descendente)");
            System.out.println("7. Ordenar por Salario (Ascendente)");
            System.out.println("8. Ordenar por Salario (Descendente)");
            System.out.println("9. Calcular Promedio de Salario");
            System.out.println("10. Encontrar Empleado con Salario Máximo");
            System.out.println("11. Encontrar Empleado con Salario Mínimo");
            System.out.println("12. Salir");
            System.out.print("Ingrese una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese ID del empleado: ");
                    int id = scanner.nextInt();
                    System.out.print("Ingrese salario del empleado: ");
                    float salario = scanner.nextFloat();
                    lista.Insertar_Empleado(new Empleado(nombre, id, salario));
                    System.out.println("Empleado agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Empleado encontrado = lista.Buscar_Empleado(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Empleado encontrado: " + encontrado.getNombre() + " | ID: " + encontrado.getId() + " | Salario: " + encontrado.getSalario());
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    boolean eliminado = lista.Elimiar_Empleado(idEliminar);
                    if (eliminado) {
                        System.out.println("Empleado eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un empleado con ese ID.");
                    }
                    break;

                case 4:
                    System.out.println("\nLista de empleados:");
                    lista.Imprimir_Lista();
                    break;

                case 5:
                    lista.Ordenar_Por_Nombre(true);
                    System.out.println("Lista ordenada por nombre en orden ascendente.");
                    break;

                case 6:
                    lista.Ordenar_Por_Nombre(false);
                    System.out.println("Lista ordenada por nombre en orden descendente.");
                    break;

                case 7:
                    lista.Ordenar_Por_Salario(true);
                    System.out.println("Lista ordenada por salario en orden ascendente.");
                    break;

                case 8:
                    lista.Ordenar_Por_Salario(false);
                    System.out.println("Lista ordenada por salario en orden descendente.");
                    break;

                case 9:
                    float promedio = lista.Calcular_Promedio_Salario();
                    System.out.println("El salario promedio es: " + promedio);
                    break;

                case 10:
                    Empleado maxSalario = lista.Encontrar_Salario_Maximo();
                    if (maxSalario != null) {
                        System.out.println("Empleado con el salario más alto: " + maxSalario.getNombre() + " | Salario: " + maxSalario.getSalario());
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 11:
                    Empleado minSalario = lista.Encontrar_Salario_Minimo();
                    if (minSalario != null) {
                        System.out.println("Empleado con el salario más bajo: " + minSalario.getNombre() + " | Salario: " + minSalario.getSalario());
                    } else {
                        System.out.println("La lista está vacía.");
                    }
                    break;

                case 12:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 12);

        scanner.close();
    }
}
