package Binario;
import java.util.Scanner;
public class Main {
    
    public static void main(String [] args){
        int op=0,dato;
        Arbol arbol=new Arbol();
        Scanner c = new Scanner(System.in);
        do{
            System.out.println("Menu de Opciones:\n"
                    + "1)Agregar Nodo.\n"
                    + "2)Recorrido InOrden.\n"
                    + "3)Recorrido en PreOrden.\n"
                    + "4)Recorrido en PostOrden.\n"
                    + "5)Buscar en el Árbol.\n"
                    + "6)Dar Banamex a un Nodo.\n"
                    + "7)No. de Hojas en el Árbol.\n"
                    + "8)Ancestros de un Nodo.\n"
                    + "9)Altura del Árbol desde la Raiz\n"
                    + "10)Hermano de un Nodo.\n"
                    + "11)Descendientes de un Nodo.\n"
                    + "12)Salida.");
            op=c.nextInt();
            switch(op){
                case 1:
                    System.out.println("Ingresa Elemento");
                    dato=c.nextInt();
                    arbol.Agregar(dato);
                    break;
                    
                case 2:
                    if(!arbol.EstaVacio()){
                        System.out.println("Recorrido InOrden");
                        arbol.InOrden(arbol.Raiz);
                        System.out.println();
                    }else{
                        System.out.println("Árbol Vacio");
                    }
                    break;
                    
                case 3:
                    if(!arbol.EstaVacio()){
                        System.out.println("Recorrido en PreOrden");
                        arbol.PreOrden(arbol.Raiz);
                        System.out.println();
                    }else{
                        System.out.println("Arbol Vacio");
                    }
                    break;
                    
                case 4:
                    if(!arbol.EstaVacio()){
                        System.out.println("Recorrido en PostOrden");
                        arbol.PostOrden(arbol.Raiz);
                        System.out.println();
                    }else{
                        System.out.println("Arbol Vacio");
                    }
                    break;
                
                case 5:
                    int buscar=0;
                    Nodo x = null;
                    if(!arbol.EstaVacio()){
                        System.out.println("Ingrese el Número del nodo a buscar");
                        buscar=c.nextInt();
                        if(arbol.BuscarNodo(buscar)==null){
                            System.out.println("Nodo no Encontrado");
                        }else{
                            x=arbol.BuscarNodo(buscar);
                            System.out.println("Nodo "+x.Dato+" Encontrado");
                        }
                    }else{
                        System.out.println("Arbol Vacio");
                    }
                    break;

                
                case 6:
                    int banamex=0;
                    if(!arbol.EstaVacio()){
                        System.out.println("Ingrese nodo a eliminar");
                        banamex=c.nextInt();
                        if(arbol.Eliminar(banamex)==false){
                            System.out.println("Nodo "+banamex+" no Encontrado papu");
                        }else{
                            System.out.println("Nodo Borrado con exito");
                        }
                    }else{
                        System.out.println("Arbol Vacio");
                    }
                    break;
                
                case 7:
                    System.out.println("Hojas Totales:"+arbol.Hojas(arbol.Raiz));
                    break; 
                
                case 8:
                    int Valor=0;
                    System.out.println("Ingrese Valor");
                    Valor=c.nextInt();
                    System.out.println("Ancestros"+arbol.Ancestros(Valor,arbol.Raiz));
                    break;
                
                case 9:
                    if(arbol.EstaVacio()){
                        System.out.println("Por Definicion, La altura de un árbol vacio es cero.");
                    }else{
                        System.out.println("Altura del Árbol: "+arbol.Altura(arbol.Raiz));
                    }
                    break;
                
                case 10:
                    int hermano=0;
                    System.out.println("Ingrese Nodo Para buscar a su Hermano");
                    hermano=c.nextInt();
                    if(!arbol.Hermano(hermano,arbol.Raiz)){
                        System.out.println("El nodo No tiene Hermanos");
                    }else{
                        arbol.Hermano(hermano,arbol.Raiz);
                    }
                    break;
                
                case 11:
                    int hijos=0;
                    System.out.println("Ingrese el Nodo a Buscar descendencia");
                    hijos=c.nextInt();
                    arbol.Decendientes(arbol.BuscarNodo(hijos));
                    break;
                case 12:
                    System.out.println("Salida...");
                    break;
                    
                default: System.out.println("No esta esa opcion");    
            }
        }while(op!=12);
    }
}
