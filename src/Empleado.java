package src;

public class Empleado{
    String nombre;
    int id;
    float salario;

    public Empleado(String nombre, int id, float salario){
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    //Metodos 'getters' para acceder a los valores de los atributos.

    public String getNombre(){
        return nombre;
    }

    public int getId(){
        return id;
    }

    public float getSalario(){
        return salario;
    }

    @Override
    public String toString() {                      //Método para imprimir los valores de cada atríbuto de un empleado y no su dirección en memoria
    return "Nombre: " + nombre + " | ID: " + id + " | Salario: " + salario;
    }
}