/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Nodos.NodoEntrar;
import Controlador.Nodos.NodoPlatillos;

/**
 *
 * @author dbren
 */
public class ColaDespacho {
    private NodoPlatillos first;
    private NodoPlatillos last;
    
   public ColaDespacho() {
         first = last = null;
    }
    
    
    public void enqueue(String a) {
        NodoPlatillos nuevo = new NodoPlatillos();
        nuevo.platillo = a;
        
        nuevo.siguiente = null;
        if (first == null)
            first = last = nuevo;
        else {
            last.siguiente = nuevo;
            last = nuevo;
        }
    }
    
    public String extraer(){
        if (first != null) {
            String informacion = first.platillo;
            if (first == last) {
                first = null;
                last = null;
            }else{
                first = first.siguiente;
            }
            return informacion;
        }else{
            String informacion = first.platillo;
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
            NodoPlatillos aux;
            aux = first;
            
            while(aux != null){
                
                System.out.print((aux.platillo) + " ");
                
                aux = aux.siguiente;
            }
            
        }
        else{
            System.out.println("Lista vacia");
        }
    }
}
