package src;

public class ListaDobleEmpleado {

    //Clase sin variables
    
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

    public float Calcular_Promedio_Salario(){
        if (cabeza == null) return 0;
        float suma = 0;
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null){
            suma += actual.empleado.getSalario();
            contador ++;
            actual = actual.siguiente;
        }
        return (contador == 0) ? 0 : suma/contador;          // ( ? : ) Es un operador terniario que funciona como una estructura if/else
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

    public void Obtener_Mediana_Salario(){
        //Implementación
    }

    public void Imprimir_Lista(){
        Nodo actual = cabeza;
        while (actual != null){
            System.out.println(actual.empleado);
        
            actual = actual.siguiente;
        }
    }
}

