package src;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class ListaDobleEmpleado {

    private int contadorEmpleados;
    private float totalSalarios;

    private Nodo cabeza;
    private Nodo cola;

    public ListaDobleEmpleado() {
        this.cabeza = null;
        this.cola = null;
    }

    //Metodos

    public void Insertar_Empleado(Empleado empleado){

        Nodo nuevoNodo = new Nodo(empleado);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } 
        else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }

         // Actualizar el contador de empleados y el total de salarios
        contadorEmpleados++; // Incrementar el contador de empleados
        totalSalarios += empleado.getSalario(); // Acumular el salario del nuevo empleado
    }

    public Empleado Buscar_Empleado(int id){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.empleado.getId() == id){
                return actual.empleado;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean Elimiar_Empleado(int id){                     //Retorno booleano para saber si se eliminó un empleado
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.empleado.getId() == id){
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;   //Se redirecciona el puntero del nodo anterior hacia el actual para que sea del nodo anterior hacia el siguiente.
                } else {
                    cabeza = actual.siguiente;                      //Se elimina el primer nodo en caso de que ese sea el que buscabamos.
                }
                if (actual.siguiente != null) {                     
                    actual.siguiente.anterior = actual.anterior;    //Se redirecciona el puntero del nodo siguiente hacia el actual para que sea del nodo siguiente hacia el anterior.
                } else {
                    cola = actual.anterior;                        //Se elimina el último nodo en caso de que ese sea el que buscabamos.
                }

                // Actualizar el total de salarios y el contador de empleados
                contadorEmpleados--;
                totalSalarios -= actual.empleado.getSalario();
                return true;                                        
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void Ordenar_Por_Nombre(boolean ascendente){                  //Ordenamiento de burbuja
        if (cabeza == null) return;
        boolean intercambio;
        do {                                         //do while para asegurarse de que entre al menos una vez en el ciclo while.
            intercambio = false;                    //Variable booleana que determina si hubo intercambio
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                if ((ascendente && actual.empleado.getNombre().compareTo(actual.siguiente.empleado.getNombre()) > 0) ||    //Si es ascendente siempre entra a esta validación
                    (!ascendente && actual.empleado.getNombre().compareTo(actual.siguiente.empleado.getNombre()) < 0)) {   //Si es descendente siempre entra a esta.
                    Empleado temp = actual.empleado;                //Variable temporal (auxiliar)
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;              //Se intercambian para recorrer la lista.
                    intercambio = true;                            //Si hay intercambio se marcará otra iteración
                }
                actual = actual.siguiente;
            }
        } while (intercambio);                    //Se sale del cicclo cuando ya no hay más nodos para ordenar.
    }

    public void Ordenar_Por_Salario(boolean ascendente){                //Ordenamiento de burbuja
        if (cabeza == null) return;
        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                if ((ascendente && actual.empleado.getSalario() > actual.siguiente.empleado.getSalario()) ||    //Si es ascendente siempre entra a esta validación
                    (!ascendente && actual.empleado.getSalario() < actual.siguiente.empleado.getSalario())) {   //Si es descendente siempre entra a esta.
                    Empleado temp = actual.empleado;                //Variable temporal (auxiliar)
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;
                    intercambio = true;
                }
                actual = actual.siguiente;
            }
        } while (intercambio);
    
    }

    // Método para calcular el salario promedio
    public float Calcular_Promedio_Salario() {
        return (contadorEmpleados == 0) ? 0 : totalSalarios / contadorEmpleados;       //Operador terniario que funciona con estructura if/else.
    }

    public Empleado Encontrar_Salario_Maximo(){
        if (cabeza == null) return null;
        Nodo actual = cabeza;
        Empleado maximo = cabeza.empleado;
        while (actual != null){
            if (actual.empleado.getSalario() > maximo.getSalario()){
                maximo = actual.empleado;
            }
            actual = actual.siguiente;
        }
        return maximo;
    }

    public Empleado Encontrar_Salario_Minimo(){
        if (cabeza == null) return null;
        Nodo actual = cabeza;
        Empleado minimo = cabeza.empleado;
        while (actual != null){
            if (actual.empleado.getSalario() < minimo.getSalario()){
                minimo = actual.empleado;
            }
            actual = actual.siguiente;
        }
        return minimo;
    }

    public float Calcular_Mediana_Salario() {
        if (cabeza == null) {
            return 0;  // Si la lista está vacía, no hay mediana
        }

        // Crear una lista para almacenar los salarios
        ArrayList<Float> salarios = new ArrayList<>();

        Nodo actual = cabeza;
        while (actual != null) {
            salarios.add(actual.empleado.getSalario());
            actual = actual.siguiente;
        }

        // Ordenar los salarios de menor a mayor
        Collections.sort(salarios);

        int n = salarios.size();
        
        // Si el número de empleados es impar, la mediana es el valor del medio
        if (n % 2 == 1) {
            return salarios.get(n / 2);
        } 
        else {
            // Si es par, la mediana es el promedio de los dos valores del medio
            float salarioMedio1 = salarios.get((n / 2) - 1);
            float salarioMedio2 = salarios.get(n / 2);
            return (salarioMedio1 + salarioMedio2) / 2.0f;
        }
    }
    

    public void Imprimir_Lista() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay empleados en la lista.", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //Lógica de impresión de lista

        Nodo actual = cabeza;
        StringBuilder empleados = new StringBuilder();             //StringBuilder porque los objetos de este tipo son mutables (su tamaño puede cambiar) y así lo actualizo.
        
        while (actual != null) {
            empleados.append(actual.empleado.toString()).append("\n");
            actual = actual.siguiente;
        }

        // Mostrar la lista completa de empleados
        JOptionPane.showMessageDialog(null, empleados.toString(), "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Mostrar_Estadisticas() {
        String stats = String.format(
            "Número total de empleados: %d\n" +           //Marcadores de posición
            "Salario promedio: %.2f\n" +
            "Salario máximo: %.2f\n" +
            "Salario mínimo: %.2f\n",
            contadorEmpleados,                             //Valores
            Calcular_Promedio_Salario(), 
            (Encontrar_Salario_Maximo() != null ? Encontrar_Salario_Maximo().getSalario() : 0), 
            (Encontrar_Salario_Minimo() != null ? Encontrar_Salario_Minimo().getSalario() : 0)
        );
        JOptionPane.showMessageDialog(null, stats, "Estadísticas de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    
}

