/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbren
 */
public class Hilo implements Runnable{
    
    ColaEntrar colaEntrar = new ColaEntrar();
    Cliente clie = new Cliente();
    

    @Override
    public void run() {
        while(true){
            int random = (int)Math.floor(Math.random()*6)+1;
            Cliente clie = new Cliente();
            clie.cantidadGrupo = random;
            clie.paciencia = 50;
            colaEntrar.enqueue(clie);
            colaEntrar.imprimir();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
