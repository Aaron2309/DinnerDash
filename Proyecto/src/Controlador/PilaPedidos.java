/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Nodos.NodoPlatillos;

/**
 *
 * @author dbren
 */
public class PilaPedidos {
    private NodoPlatillos cima;
    
    
    public PilaPedidos(){
        cima = null;
    }
    
    public void push(String valor){
        NodoPlatillos nuevo = new NodoPlatillos();
        nuevo.platillo = valor;
        nuevo.siguiente = null;
        if(cima == null){
            cima = nuevo;
        }
        else{
            nuevo.siguiente = cima;
            cima = nuevo;
        }
    }
    
        public void pop(){
        if (cima != null) {
            cima = cima.siguiente;
            
        }
    }
        
        
        public void eliminarEspeficio(String a){
            if (cima != null){
            NodoPlatillos aux;
            aux = cima;
        }
        else{
            System.out.println("Lista vacia");
        }
        }
        
        
        public String extraer(){
                return cima.platillo;
            
        } 
    
        
        public void imprimir(){
        if (cima != null){
            NodoPlatillos aux;
            aux = cima;
            
            while(aux != null){
                
                System.out.print(aux.platillo + " ");
                
                aux = aux.siguiente;
            }
            
        }
        else{
            System.out.println("Lista vacia");
        }
    }
}
