package src;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class ListaDobleEmpleado {

    // Contador de empleados y total de salarios
    private int contadorEmpleados;
    private float totalSalarios;

    // Nodos que representan el inicio y el final de la lista doblemente enlazada
    private Nodo cabeza;
    private Nodo cola;

    // Constructor de la clase, inicializa la lista vacía
    public ListaDobleEmpleado() {
        this.cabeza = null; // No hay empleados al inicio
        this.cola = null;   // No hay empleados al inicio
    }

    // Métodos

    // Método para insertar un nuevo empleado en la lista
    public void Insertar_Empleado(Empleado empleado) {
        Nodo nuevoNodo = new Nodo(empleado); // Crear un nuevo nodo con el empleado

        // Si la lista está vacía, el nuevo nodo es tanto la cabeza como la cola
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // Si la lista no está vacía, se añade el nuevo nodo al final
            cola.siguiente = nuevoNodo; // El siguiente de la cola actual es el nuevo nodo
            nuevoNodo.anterior = cola;   // El anterior del nuevo nodo es la cola actual
            cola = nuevoNodo;            // Actualizar la cola al nuevo nodo
        }

        // Actualizar el contador de empleados y el total de salarios
        contadorEmpleados++; // Incrementar el contador de empleados
        totalSalarios += empleado.getSalario(); // Acumular el salario del nuevo empleado
    }

    // Método para buscar un empleado por su ID
    public Empleado Buscar_Empleado(int id) {
        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        while (actual != null) { // Recorrer la lista
            if (actual.empleado.getId() == id) { // Si se encuentra el empleado
                return actual.empleado; // Retornar el empleado encontrado
            }
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }
        return null; // Si no se encuentra, retornar null
    }

    // Método para eliminar un empleado por su ID
    public boolean Elimiar_Empleado(int id) {
        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        while (actual != null) { // Recorrer la lista
            if (actual.empleado.getId() == id) { // Si se encuentra el empleado
                // Redireccionar punteros para eliminar el nodo
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente; // Conectar el anterior con el siguiente
                } else {
                    cabeza = actual.siguiente; // Si es el primer nodo, actualizar la cabeza
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior; // Conectar el siguiente con el anterior
                } else {
                    cola = actual.anterior; // Si es el último nodo, actualizar la cola
                }

                // Actualizar el total de salarios y el contador de empleados
                contadorEmpleados--; // Decrementar el contador de empleados
                totalSalarios -= actual.empleado.getSalario(); // Restar el salario del empleado eliminado
                return true; // Retornar true indicando que se eliminó
            }
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }
        return false; // Retornar false si no se encontró el empleado
    }

    // Método para ordenar la lista de empleados por nombre
    public void Ordenar_Por_Nombre(boolean ascendente) {
        if (cabeza == null) return; // Si la lista está vacía, no hacer nada
        boolean intercambio;
        do {
            intercambio = false; // Inicializar la variable de intercambio
            Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
            while (actual.siguiente != null) { // Recorrer la lista
                // Comparar nombres y decidir si se deben intercambiar
                if ((ascendente && actual.empleado.getNombre().compareTo(actual.siguiente.empleado.getNombre()) > 0) ||
                    (!ascendente && actual.empleado.getNombre().compareTo(actual.siguiente.empleado.getNombre()) < 0)) {
                    // Intercambiar empleados
                    Empleado temp = actual.empleado; // Variable temporal para el intercambio
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;
                    intercambio = true; // Marcar que hubo un intercambio
                }
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }
        } while (intercambio); // Repetir mientras haya intercambios
    }

    // Método para ordenar la lista de empleados por salario
    public void Ordenar_Por_Salario(boolean ascendente) {
        if (cabeza == null) return; // Si la lista está vacía, no hacer nada
        boolean intercambio;
        do {
            intercambio = false; // Inicializar la variable de intercambio
            Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
            while (actual.siguiente != null) { // Recorrer la lista
                // Comparar salarios y decidir si se deben intercambiar
                if ((ascendente && actual.empleado.getSalario() > actual.siguiente.empleado.getSalario()) ||
                    (!ascendente && actual.empleado.getSalario() < actual.siguiente.empleado.getSalario())) {
                    // Intercambiar empleados
                    Empleado temp = actual.empleado; // Variable temporal para el intercambio
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;
                    intercambio = true; // Marcar que hubo un intercambio
                }
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }
        } while (intercambio); // Repetir mientras haya intercambios
    }

    // Método para calcular el salario promedio
    public float Calcular_Promedio_Salario() {
        // Retornar 0 si no hay empleados, de lo contrario calcular el promedio
        return (contadorEmpleados == 0) ? 0 : totalSalarios / contadorEmpleados;
    }

    // Método para encontrar el empleado con el salario máximo
    public Empleado Encontrar_Salario_Maximo() {
        if (cabeza == null) return null; // Si la lista está vacía, retornar null
        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        Empleado maximo = cabeza.empleado; // Inicializar el máximo con el primer empleado
        while (actual != null) { // Recorrer la lista
            if (actual.empleado.getSalario() > maximo.getSalario()) { // Si se encuentra un salario mayor
                maximo = actual.empleado; // Actualizar el máximo
            }
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }
        return maximo; // Retornar el empleado con el salario máximo
    }

    // Método para encontrar el empleado con el salario mínimo
    public Empleado Encontrar_Salario_Minimo() {
        if (cabeza == null) return null; // Si la lista está vacía, retornar null
        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        Empleado minimo = cabeza.empleado; // Inicializar el mínimo con el primer empleado
        while (actual != null) { // Recorrer la lista
            if (actual.empleado.getSalario() < minimo.getSalario()) { // Si se encuentra un salario menor
                minimo = actual.empleado; // Actualizar el mínimo
            }
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }
        return minimo; // Retornar el empleado con el salario mínimo
    }

    // Método para calcular la mediana de los salarios
    public float Calcular_Mediana_Salario() {
        if (cabeza == null) {
            return 0; // Si la lista está vacía, no hay mediana
        }

        // Crear una lista para almacenar los salarios
        ArrayList<Float> salarios = new ArrayList<>();

        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        while (actual != null) { // Recorrer la lista
            salarios.add(actual.empleado.getSalario()); // Agregar el salario a la lista
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }

        // Ordenar los salarios de menor a mayor
        Collections.sort(salarios);

        int n = salarios.size(); // Obtener el número de salarios
        
        // Si el número de empleados es impar, la mediana es el valor del medio
        if (n % 2 == 1) {
            return salarios.get(n / 2); // Retornar el salario del medio
        } else {
            // Si es par, la mediana es el promedio de los dos valores del medio
            float salarioMedio1 = salarios.get((n / 2) - 1);
            float salarioMedio2 = salarios.get(n / 2);
            return (salarioMedio1 + salarioMedio2) / 2.0f; // Retornar la mediana
        }
    }

    // Método para imprimir la lista de empleados
    public void Imprimir_Lista() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay empleados en la lista.", null, JOptionPane.INFORMATION_MESSAGE);
            return; // Si la lista está vacía, mostrar mensaje y salir
        }

        // Lógica de impresión de lista
        Nodo actual = cabeza; // Comenzar desde la cabeza de la lista
        StringBuilder empleados = new StringBuilder(); // Usar StringBuilder para construir la cadena de empleados
        
        while (actual != null) { // Recorrer la lista
            empleados.append(actual.empleado.toString()).append("\n"); // Agregar cada empleado a la cadena
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }

        // Mostrar la lista completa de empleados
        JOptionPane.showMessageDialog(null, empleados.toString(), "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para mostrar estadísticas de empleados
    public void Mostrar_Estadisticas() {
        String stats = String.format(
            "Número total de empleados: %d\n" + // Marcadores de posición
            "Salario promedio: %.2f\n" +
            "Salario máximo: %.2f\n" +
            "Salario mínimo: %.2f\n",
            contadorEmpleados, // Valores
            Calcular_Promedio_Salario(), 
            (Encontrar_Salario_Maximo() != null ? Encontrar_Salario_Maximo().getSalario() : 0), 
            (Encontrar_Salario_Minimo() != null ? Encontrar_Salario_Minimo().getSalario() : 0)
        );
        // Mostrar las estadísticas en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, stats, "Estadísticas de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }
}
