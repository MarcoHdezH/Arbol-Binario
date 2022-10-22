
package Binario;


public class Arbol {
    Nodo Raiz;
    
    public Arbol(){
        Raiz=null;
    }
    
    //Método Para Insertar Nodos al Árbol
    public void Agregar(int dato){
        Nodo Nuevo=new Nodo(dato);
        if(Raiz==null){
            Raiz=Nuevo;
        }else{
            Nodo aux=Raiz;
            Nodo padre;
            while(true){
                padre=aux;
                if(dato<aux.Dato){
                    aux=aux.HijoIzquierdo;
                    if(aux==null){
                        padre.HijoIzquierdo=Nuevo;
                        return;
                    }
                }else{
                    aux=aux.HijoDerecho;
                    if(aux==null){
                        padre.HijoDerecho=Nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    
    //Método Árbol Vacio
    public boolean EstaVacio(){
        return Raiz==null;
    }
    
    //Método para recorrer InOrden 
    public void InOrden(Nodo R){
        if(R!=null){
            InOrden(R.HijoIzquierdo);
            System.out.print("["+R.Dato+"]->");
            InOrden(R.HijoDerecho);
        }
    }
    
    //Método No.Hojas
    public int Hojas(Nodo R){
        if(R!=null){
            if(R.HijoDerecho==null && R.HijoIzquierdo==null){
                return 1;
            }else{
                return Hojas(R.HijoIzquierdo)+Hojas(R.HijoDerecho);
            }
        }
        return 0;
    }
    
    //Método para saber si es Padre
    public boolean EsPadre(Nodo R){
        return !EsHoja(R);
    }
    
    //Método para saber si es Hoja
    public boolean EsHoja(Nodo R){
        return R.HijoIzquierdo==null && R.HijoDerecho==null;
    }
    
    //Método para recorrer en PreOrden
    public void PreOrden(Nodo R){
        if(R!=null){
            System.out.print("["+R.Dato+"]->");
            PreOrden(R.HijoIzquierdo);
            PreOrden(R.HijoDerecho);
        }
    }
    
    //Método para recorrer en PostOrden
    public void PostOrden(Nodo R){
        if(R!=null){
            PostOrden(R.HijoIzquierdo);
            PostOrden(R.HijoDerecho);
            System.out.print("["+R.Dato+"]->");
        }
    }
    
    //Buscar Nodos en el arbol 
    public Nodo BuscarNodo(int D){
        Nodo aux=Raiz;
        while(aux.Dato!=D){
            if(D<aux.Dato){
                aux=aux.HijoIzquierdo;
            }else{
                aux=aux.HijoDerecho;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }
    
    //Método Eliminar Nodo
    public boolean Eliminar(int D){
        Nodo aux=Raiz;
        Nodo padre=Raiz;
        boolean HijoIzq=true;
        while(aux.Dato!=D){
            padre=aux;
            if(D<aux.Dato){
                HijoIzq=true;
                aux=aux.HijoIzquierdo;
            }else{
                HijoIzq=false;
                aux=aux.HijoDerecho;
            }
            if(aux==null){
                return false;
            }
        }//Fin While
        if(aux.HijoIzquierdo==null && aux.HijoDerecho==null){
            if(aux==Raiz){
                Raiz=null;
            }else if(HijoIzq){
                padre.HijoIzquierdo=null;
            }else{
                padre.HijoDerecho=null;
            }
        }else if(aux.HijoDerecho==null){
            if(aux==Raiz){
                Raiz=aux.HijoIzquierdo;
            }else if(HijoIzq){
                padre.HijoIzquierdo=aux.HijoIzquierdo;
            }else{
                padre.HijoDerecho=aux.HijoIzquierdo;
            }
        }else if(aux.HijoIzquierdo==null){
            if(aux==Raiz){
                Raiz=aux.HijoDerecho;
            }else if(HijoIzq){
                padre.HijoDerecho=aux.HijoDerecho;
            }else{
                padre.HijoDerecho=aux.HijoIzquierdo;
            }
        }else{
            Nodo Reemplazo=ObtenerReemplazo(aux);
            if(aux==Raiz){
                Raiz=Reemplazo;
            }else if(HijoIzq){
                padre.HijoIzquierdo=Reemplazo;
            }else{
                padre.HijoDerecho=Reemplazo;
            }
            Reemplazo.HijoIzquierdo=aux.HijoIzquierdo;
        }
        return true;
    }
    
    //Método Reemplazo (Complemento de Eliminar)
    public Nodo ObtenerReemplazo(Nodo R){
        Nodo Rpadre=R;
        Nodo Reemplazo=R;
        Nodo aux=R.HijoDerecho;
        while(aux!=null){
            Rpadre=Reemplazo;
            Reemplazo=aux;
            aux=aux.HijoIzquierdo;
        }
        if(Reemplazo!=R.HijoDerecho){
            Rpadre.HijoIzquierdo=Reemplazo.HijoDerecho;
            Reemplazo.HijoDerecho=R.HijoDerecho;
        }
        return Reemplazo;
    }
    
    //Método Para Obtener La altura de un Nodo
    public int Altura(Nodo R){
        int Altura=0;
        if(EsPadre(R)){
            if(R.HijoIzquierdo!=null){
                Altura=Math.max(Altura, Altura(R.HijoIzquierdo));
            }
            if(R.HijoDerecho!=null){
                Altura=Math.max(Altura, Altura(R.HijoDerecho));
            }
            Altura++;
        }
        
        return Altura;
    }
    
    //Método Para Obtener Los Descendientes de un Nodo
    public void Decendientes(Nodo R){
        if(R.HijoDerecho!=null && R.HijoIzquierdo!=null){
            System.out.println("Descendiente Izquierdo:"+R.HijoIzquierdo.Dato+" Descendiente Derecho:"+R.HijoDerecho.Dato);
        }else{
            if(R.HijoIzquierdo!=null && R.HijoDerecho==null){
                System.out.println("Unico Descendiente Izquierdo:"+R.HijoIzquierdo.Dato);
            }else{
                if(R.HijoIzquierdo==null && R.HijoDerecho!=null){
                    System.out.println("Unico Descendiente Derecho:"+R.HijoDerecho.Dato);
                }else{
                    if(EsHoja(R)){
                        System.out.println("Nodo Hoja (Sin Descendientes)");
                    }
                }
            }
        }
        
    }
    
    //Método Para saber el numero de ancestros de un Nodo
    public int Ancestros(int Dato, Nodo R){
        if(R==null || (EsHoja(R))){
            return 0;
        }else{
            if(Dato>R.Dato){
                return 1+Ancestros(Dato,R.HijoDerecho);
            }else{
                if(Dato<R.Dato){
                    return 1+Ancestros(Dato,R.HijoIzquierdo);
                }else{
                    return 0;
                }
            }
        }
    }
    
    //Metodo para Los Hermanos de un Nodo
    public boolean Hermano(int valor, Nodo papa){
        if(papa==null ||(EsHoja(papa))){
            return false;
        }else{
            if(papa.HijoIzquierdo!=null && papa.HijoDerecho!=null &&papa.HijoDerecho.Dato==valor){
                System.out.println("El hermano de "+papa.HijoDerecho.Dato+" es "+papa.HijoIzquierdo.Dato);
                return true;
            }
            if(papa.HijoDerecho!=null && papa.HijoIzquierdo!=null && papa.HijoIzquierdo.Dato==valor){
                System.out.println("El hermano de "+papa.HijoIzquierdo.Dato+" es "+papa.HijoDerecho.Dato);
                return true;
            }else{
                return Hermano(valor,papa.HijoDerecho) || Hermano(valor,papa.HijoIzquierdo);
            }
        }
    }
    
}
