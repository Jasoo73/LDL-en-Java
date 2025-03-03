package src;

public class Nodo {
    Empleado empleado;  // El objeto que contiene los datos
    Nodo siguiente;     
    Nodo anterior;      


    public Nodo(Empleado empleado) {
        this.empleado = empleado;   
        this.siguiente = null;
        this.anterior = null;
    }
}


