
package Controlador;

import Controlador.Nodos.NodoEntrar;

public class ColaCaja {
    private NodoEntrar first;
    private NodoEntrar last;
    
   public ColaCaja() {
         first = last = null;
    }
    
    
    public void enqueue(Cliente a) {
        NodoEntrar nuevo = new NodoEntrar();
        nuevo.personas = a;
        
        nuevo.siguiente = null;
        if (first == null)
            first = last = nuevo;
        else {
            last.siguiente = nuevo;
            last = nuevo;
        }
    }
    
    public Cliente extraer(){
        if (first != null) {
            Cliente informacion = first.personas;
            if (first == last) {
                first = null;
                last = null;
            }else{
                first = first.siguiente;
            }
            return informacion;
        }else{
            Cliente informacion = first.personas;
            return informacion;
        }
    }
    
    //Borrar Inicio Cola
    public void dequeue () {
        if (first != null)
            first = first.siguiente;
    }
    
    public void imprimir(){
        if (first != null){
            NodoEntrar aux;
            aux = first;
            
            while(aux != null){
                
                System.out.print((aux.personas) + " ");
                
                aux = aux.siguiente;
            }
            
        }
        else{
            System.out.println("Lista vacia");
        }
    }
}
