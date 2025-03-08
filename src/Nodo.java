package src;

// Clase que representa un nodo en una lista doblemente ligada
public class Nodo {
    Empleado empleado;  // Objeto que almacena los datos del empleado
    Nodo siguiente;     // Referencia al siguiente nodo en la lista
    Nodo anterior;      // Referencia al nodo anterior en la lista

    // Constructor que inicializa un nodo con un empleado
    public Nodo(Empleado empleado) {
        this.empleado = empleado;   // Asigna el objeto empleado al nodo
        this.siguiente = null;      // Inicialmente, el nodo no tiene siguiente
        this.anterior = null;       // Inicialmente, el nodo no tiene anterior
    }
}
