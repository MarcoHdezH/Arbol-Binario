
package Binario;

public class Nodo {
    int Dato;
    String Nombre;
    Nodo HijoIzquierdo,HijoDerecho;
    
    public Nodo(int dato){
        this.Dato=dato;
        this.HijoDerecho=null;
        this.HijoIzquierdo=null;
    }
}
