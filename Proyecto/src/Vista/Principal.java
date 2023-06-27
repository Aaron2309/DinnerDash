
package Vista;

import Controlador.Cliente;
import Controlador.ColaCaja;
import Controlador.ColaDespacho;
import Controlador.ColaEntrar;
import Controlador.PilaPedidos;
import Controlador.Platillo;
import Controlador.Restaurante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dbren
 */
public final class Principal extends JFrame{
    Menu menu = new Menu();
    ColaEntrar colaEntrar = new ColaEntrar();
    ColaCaja colaCaja = new ColaCaja();
    PilaPedidos pila = new PilaPedidos();
    ColaDespacho colaDespacho = new ColaDespacho();
    Restaurante rest = new Restaurante();
    Platillo platillo = new Platillo();
    
    
    private JPanel panel;
    private  JButton botones[][];
    
    public Principal(){
        setVisible(true);
	setResizable(true);
        setTitle("Dinner Dash");
	setBounds(0,0,800,800);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciar();
//        MatrizJuego();
//        dibujarRest(); 
//        esperaClientes();
//        entregarPlatillo();
//        sentar();
//        caja();
//        iniciarMenu();
//        agregarCola(); 
        
    }
    
    public void iniciar(){
        MatrizJuego();
        dibujarRest(); 
        esperaClientes();
        entregarPlatillo();
        sentar();
        caja();
        iniciarMenu();
        agregarCola(); 
    }
    
    public void MatrizJuego(){
        botones = new JButton[8][10];
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 10));
        add(panel);
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBounds(20, 10, 360, 360);
                botones[i][j].setBorderPainted(false);
                
                panel.add(botones[i][j]);
                
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    botones[i][j].setBackground(Color.LIGHT_GRAY);
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                }
                
            }
        }
    }
    
    public void dibujarRest(){
        final ImageIcon icon = new  ImageIcon("Mesa2.jpg");
        final ImageIcon icon1 = new  ImageIcon("Mesa3.jpg");
        final ImageIcon icon2 = new  ImageIcon("Mesa6.jpg");
        final ImageIcon icon3 = new  ImageIcon("barra.png");
        final ImageIcon icon4 = new  ImageIcon("cocina.png");
        final ImageIcon icon5 = new  ImageIcon("plato.png");
        final ImageIcon icon6 = new  ImageIcon("caja.png");
        final ImageIcon icon7 = new  ImageIcon("menu2.png");
        
        //Mesas de 2
        botones[2][1].setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[3][2].setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[2][3].setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[3][4].setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); 
        
        //Mesas de 4
        botones[5][2].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[6][3].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[5][4].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[6][2].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))); 
        botones[6][4].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
//        //Mesas de 6
        botones[1][7].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[1][9].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[2][8].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[3][7].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[3][9].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[4][7].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[4][9].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[5][8].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[6][7].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        botones[6][9].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        
        //Barra
        botones[0][2].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        botones[0][3].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        botones[0][4].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        botones[0][5].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        botones[0][6].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
        
        //Cocina
        botones[0][0].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        botones[0][1].setIcon(new ImageIcon(icon5.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        
        //Caja y menu 
        botones[0][9].setIcon(new ImageIcon(icon6.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        botones[0][8].setIcon(new ImageIcon(icon7.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
    }
    
    public void agregarCola (){
        
        while(true){
            try {
            int random = (int)Math.floor(Math.random()*6)+1;
            Cliente clie = new Cliente();
            clie.cantidadGrupo = random;
            clie.paciencia = 100;
            clie.vector = new String[random];
            colaEntrar.enqueue(clie);
            Thread.sleep(2000);
            
        } catch (InterruptedException ex) {
        }        
    }
    }
    
    public void ponerImagenesEntrada(){
        String a = Integer.toString(rest.matriz[5][0].cantidadGrupo);
        if (rest.matriz[5][0].cantidadGrupo == 1) {
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[5][0].cantidadGrupo == 2) {
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[5][0].cantidadGrupo == 3) {
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[5][0].cantidadGrupo == 4) {
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[5][0].cantidadGrupo == 5) {
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else{
            final ImageIcon icon1 = new  ImageIcon("persona" + a + ".jpg");
            botones[5][0].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }
    }
    
    public void PonerImagenesCaja(){
        rest.matriz[0][9] = colaCaja.extraer();
        String a = Integer.toString(rest.matriz[0][9].cantidadGrupo);
        if (rest.matriz[0][9].cantidadGrupo == 1) {
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[0][9].cantidadGrupo == 2) {
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[0][9].cantidadGrupo == 3) {
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[0][9].cantidadGrupo == 4) {
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else if (rest.matriz[0][9].cantidadGrupo == 5) {
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        }else{
            final ImageIcon icon4 = new  ImageIcon("persona" + a + ".jpg");
            botones[0][9].setIcon(new ImageIcon(icon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                                        }
    }
    
    public void esperaClientes(){
          int a = 0;
//        while(a!= 15){
            int random = (int)Math.floor(Math.random()*6)+1;
            Cliente clie = new Cliente();
            clie.cantidadGrupo = random;
            clie.vector = new String[random];
            clie.paciencia = 100;
            colaEntrar.enqueue(clie);
            a++;
//        }
            rest.matriz[5][0] = colaEntrar.extraer();
            ponerImagenesEntrada();
    }
    
    public void sentarMesa2(){
        String a = Integer.toString(rest.matriz[5][0].cantidadGrupo);
                int sentar;
                int sentar2;
                sentar = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para dos quiere sentar a as personas\n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4"));
                if (sentar == 1 && rest.matriz[2][1] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[2][1].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[2][1] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[2][1].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1; 
                        rest.matriz[2][1].vector[i] = platillo.comida[random-1];
                        pila.push(rest.matriz[2][1].vector[i]);
                        colaDespacho.enqueue(pila.extraer());
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[2][1].vector[i]);
                        rest.matriz[2][1].cuenta = rest.matriz[2][1].cuenta + platillo.precios[random-1];
                    }
                    pila.imprimir();
                    pila.extraer();
                }else if(sentar == 2 && rest.matriz[3][2] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[3][2].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[3][2] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                        for (int i = 0; i < rest.matriz[3][2].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[3][2].vector[i] = platillo.comida[random-1];
                            pila.push(rest.matriz[3][2].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[3][2].vector[i]);
                            rest.matriz[3][2].cuenta = rest.matriz[3][2].cuenta + platillo.precios[random-1];
//                            rest.matriz[3][2].cuenta =  rest.matriz[3][2].cuenta + menu
                        } 
                }else if (sentar == 3 && rest.matriz[2][3] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[2][3].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[2][3] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[2][3].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[2][3].vector[i] = platillo.comida[random-1];
                        pila.push(rest.matriz[2][3].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[2][3].vector[i]);
                        rest.matriz[2][3].cuenta = rest.matriz[2][3].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 4 && rest.matriz[3][4] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[3][4].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[3][4] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[3][4].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1; 
                        rest.matriz[3][4].vector[i] = platillo.comida[random-1];
                        pila.push(rest.matriz[3][4].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[2][1].vector[i]);
                        rest.matriz[3][4].cuenta = rest.matriz[3][4].cuenta + platillo.precios[random-1];
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Esa mesa ya esta ocupada");
                }
    }
    
    public void sentarMesa4(){
        String a = Integer.toString(rest.matriz[5][0].cantidadGrupo);
                int sentar;
                int sentar2;
                sentar = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para cuatro quiere sentar a as personas\n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4\n Para mesa #5"));
                if (sentar == 1 && rest.matriz[5][2] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[5][2].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[5][2] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[5][2].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[5][2].vector[i] = platillo.comida[random-1];  
                            pila.push(rest.matriz[5][2].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[5][2].vector[i]);
                            rest.matriz[5][2].cuenta = rest.matriz[5][2].cuenta + platillo.precios[random-1];
                        } 
                }else if(sentar == 2 && rest.matriz[6][3] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[6][3].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[6][3] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[6][3].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[6][3].vector[i] = platillo.comida[random-1]; 
                            pila.push(rest.matriz[6][3].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[6][3].vector[i]);
                            rest.matriz[6][3].cuenta = rest.matriz[6][3].cuenta + platillo.precios[random-1];
                        } 
                }else if (sentar == 3 && rest.matriz[5][4] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[5][4].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[5][4] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[5][4].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[5][4].vector[i] = platillo.comida[random-1]; 
                            pila.push(rest.matriz[5][4].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[5][4].vector[i]);
                            rest.matriz[5][4].cuenta = rest.matriz[5][4].cuenta + platillo.precios[random-1];
                        } 
                }else if (sentar == 4 && rest.matriz[6][2] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[6][2].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[6][2] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[6][2].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[6][2].vector[i] = platillo.comida[random-1]; 
                            pila.push(rest.matriz[6][2].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[6][2].vector[i]);
                            rest.matriz[6][2].cuenta = rest.matriz[6][2].cuenta + platillo.precios[random-1];
                        } 
                }else if (sentar == 5 && rest.matriz[6][4] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[6][4].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[6][4] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[6][4].vector.length; i++) {
                            int random =  (int)Math.floor(Math.random()*5)+1;
                            rest.matriz[6][4].vector[i] = platillo.comida[random-1]; 
                            pila.push(rest.matriz[6][4].vector[i]);
                            JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[6][4].vector[i]);
                            rest.matriz[6][4].cuenta = rest.matriz[6][4].cuenta + platillo.precios[random-1];
                        } 
                }else{
                    JOptionPane.showMessageDialog(null, "Esa mesa ya esta ocupada");;
                }
                
    }
    
    public void sentarMesa6(){
         String a = Integer.toString(rest.matriz[5][0].cantidadGrupo);
                int sentar;
                int sentar2;
                sentar = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para cuatro quiere sentar a as personas\n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4\n5 Para mesa #5\n6 Para mesa #6\n7 Para mesa #7\n8 Para mesa #8\n9 Para mesa #9\n10 Para mesa #10"));
                if (sentar == 1 && rest.matriz[1][7] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[1][7].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[1][7] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[1][7].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[1][7].vector[i] = platillo.comida[random-1];  
                        pila.push(rest.matriz[1][7].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[1][7].vector[i]);
                        rest.matriz[1][7].cuenta = rest.matriz[1][7].cuenta + platillo.precios[random-1];
                    } 
                    
                }else if(sentar == 2 && rest.matriz[1][9] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[1][9].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[1][9] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    //Tomar orden
                    for (int i = 0; i < rest.matriz[1][9].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[1][9].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[1][9].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[1][9].vector[i]);
                        rest.matriz[1][9].cuenta = rest.matriz[1][9].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 3 && rest.matriz[2][8] == null) {
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[2][8].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[2][8] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[2][8].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[2][8].vector[i] = platillo.comida[random-1];  
                        pila.push(rest.matriz[2][8].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[2][8].vector[i]);
                        rest.matriz[2][8].cuenta = rest.matriz[2][8].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 4 && rest.matriz[3][7] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[3][7].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[3][7] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[3][7].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[3][7].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[3][7].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[3][7].vector[i]);
                        rest.matriz[3][7].cuenta = rest.matriz[3][7].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 5 && rest.matriz[3][9] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[3][9].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[3][9] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[3][9].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[3][9].vector[i] = platillo.comida[random-1];
                        pila.push(rest.matriz[3][9].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[3][9].vector[i]);
                        rest.matriz[3][9].cuenta = rest.matriz[3][9].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 6 && rest.matriz[4][7] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[4][7].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[4][7] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[4][7].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[4][7].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[4][7].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[4][7].vector[i]);
                        rest.matriz[4][7].cuenta = rest.matriz[4][7].cuenta + platillo.precios[random-1];
                    } 
                }else if(sentar == 7 && rest.matriz[4][9] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[4][9].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[4][9] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[4][9].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[4][9].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[4][9].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[4][9].vector[i]);
                        rest.matriz[6][9].cuenta = rest.matriz[6][9].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 8 && rest.matriz[5][8] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[5][8].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[5][8] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[5][8].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[5][8].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[5][8].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[5][8].vector[i]);
                        rest.matriz[5][8].cuenta = rest.matriz[5][8].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 9 && rest.matriz[6][7] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[6][7].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[6][7] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[6][7].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[6][7].vector[i] = platillo.comida[random-1];
                        pila.push(rest.matriz[6][7].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[6][7].vector[i]);
                        rest.matriz[6][7].cuenta = rest.matriz[6][7].cuenta + platillo.precios[random-1];
                    } 
                }else if (sentar == 10 && rest.matriz[6][9] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona" + a + ".jpg");
                        botones[6][9].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[6][9] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[6][9].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[6][9].vector[i] = platillo.comida[random-1];
                        rest.matriz[6][9].vector[i] = platillo.comida[random-1];  
                        pila.push(rest.matriz[6][9].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[6][9].vector[i]);
                        rest.matriz[6][9].cuenta = rest.matriz[6][9].cuenta + platillo.precios[random-1];
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Esa mesa ya esta ocupada");
                }
    }
    
    public void sentarBarra(){
        int sentar;
                int sentar2;
                sentar = Integer.parseInt(JOptionPane.showInputDialog("En cual campo de la barra quiere sentar al cliente\n1 Para campo #1\n2 Para campo #2\n Para campo #3\n4 Para campo #4\n5 Para campo #5"));
                if (sentar == 1 && rest.matriz[0][2] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona1.jpg");
                        botones[0][2].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[0][2] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[0][2].vector.length; i++) {
                          int random =  (int)Math.floor(Math.random()*5)+1;
                          rest.matriz[0][2].vector[i] = platillo.comida[random-1]; 
                          pila.push(rest.matriz[0][2].vector[i]);
                          JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[0][2].vector[i]);
                          rest.matriz[0][2].cuenta = rest.matriz[0][2].cuenta + platillo.precios[random-1];
                    }
                }else if(sentar == 2 && rest.matriz[0][3] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona1.jpg");
                        botones[0][3].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[0][3] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[0][3].vector.length; i++) {
                        int random =  (int)Math.floor(Math.random()*5)+1;
                        rest.matriz[0][3].vector[i] = platillo.comida[random-1]; 
                        pila.push(rest.matriz[0][3].vector[i]);
                        JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[0][3].vector[i]);
                        rest.matriz[0][3].cuenta = rest.matriz[0][3].cuenta + platillo.precios[random-1];
                    }
                }else if (sentar == 3 && rest.matriz[0][4] == null) {
                                        //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona1.jpg");
                        botones[0][4].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[0][4] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[0][4].vector.length; i++) {
                          int random =  (int)Math.floor(Math.random()*5)+1;
                          rest.matriz[0][4].vector[i] = platillo.comida[random-1]; 
                          pila.push(rest.matriz[0][4].vector[i]);
                          JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[0][4].vector[i]);
                          rest.matriz[0][4].cuenta = rest.matriz[0][4].cuenta + platillo.precios[random-1];
                    }
                }else if (sentar == 4 && rest.matriz[0][5] == null) {
                                        //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona1.jpg");
                        botones[0][5].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[0][5] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    
                    for (int i = 0; i < rest.matriz[0][5].vector.length; i++) {
                          int random =  (int)Math.floor(Math.random()*5)+1;
                          rest.matriz[0][5].vector[i] = platillo.comida[random-1]; 
                          pila.push(rest.matriz[0][5].vector[i]);
                          JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[0][5].vector[i]);
                          rest.matriz[0][5].cuenta = rest.matriz[0][5].cuenta + platillo.precios[random-1];
                    }
                }else if (sentar == 5 && rest.matriz[0][6] == null) {
                    //Sentar Clientes
                    if (colaEntrar.extraer().paciencia <= 0) {
                        JOptionPane.showMessageDialog(null, "Oh no un cliente se ha marchado");
                        colaEntrar.dequeue();
                    }else{
                        final ImageIcon icon = new  ImageIcon("Persona1.jpg");
                        botones[0][6].setIcon(new ImageIcon(icon.getImage().getScaledInstance(75, 100, Image.SCALE_SMOOTH)));
                        rest.matriz[0][6] = rest.matriz[5][0];
                        colaEntrar.dequeue();
                        rest.matriz[5][0] = colaEntrar.extraer();
                        ponerImagenesEntrada();
                    }
                    
                    for (int i = 0; i < rest.matriz[0][6].vector.length; i++) {
                          int random =  (int)Math.floor(Math.random()*5)+1;
                          rest.matriz[0][6].vector[i] = platillo.comida[random-1]; 
                          pila.push(rest.matriz[0][6].vector[i]);
                          JOptionPane.showMessageDialog(null, "Platillo escogido: " + rest.matriz[0][6].vector[i]);
                          rest.matriz[0][6].cuenta = rest.matriz[0][6].cuenta + platillo.precios[random-1];
                    }
                }else{
                    System.out.println("Esa mesa ya esta ocupada");
                }
    }
    
    public void sentar(){
            ActionListener op = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Scanner sc = new Scanner(System.in);
                int sentar;
                int sentar2;
                sentar = Integer.parseInt(JOptionPane.showInputDialog("Donde quiere sentar a los clientes tenga en cuenta que vienen en grupo de: " + rest.matriz[5][0].cantidadGrupo + "\n1 Para mesa de dos personas\n2 Para mesa de cuatro Personas\n3 Para mesa de seis Personas\n4 Para la barra"));
                if (sentar == 1 && rest.matriz[5][0].cantidadGrupo <= 2) {
                    sentarMesa2();
                }else if (sentar == 2 && rest.matriz[5][0].cantidadGrupo <=4) {
                    sentarMesa4();
                }else if (sentar == 3) {
                    sentarMesa6();
                }else if (sentar == 4 && rest.matriz[5][0].cantidadGrupo == 1  ) {
                    sentarBarra();
                }else{
                    System.out.println("Esa mesa no es apropieda para la cantidad de personas");
                }
            }
        };
            
        botones[5][0].addActionListener(op);

    }
    
    public void entregarPlatillo(){
        ActionListener sc;
        sc = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                int entregar;
                int entregar2;
                entregar = Integer.parseInt(JOptionPane.showInputDialog("En el despacho hay " + pila.extraer() + "\n1 Para entregrar en mesa de dos personas\n2 Para entregrar en mesa de cuatro Personas\n3 Para entregrar en mesa de seis Personas"));
                if (entregar == 1 ) {
                    entregar2 = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para dos quiere tomar el pedido \n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4"));
                    if (entregar2 == 1 && rest.matriz[2][1] != null) {
                        for (int i = 0; i < rest.matriz[2][1].vector.length; i++) {
                            if (rest.matriz[2][1].vector[i] == pila.extraer()) {
                                rest.matriz[2][1].satisfecho++;
                                rest.matriz[2][1].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[2][1]);
                                break;
                            }
                            System.out.println(rest.matriz[2][1].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[2][1]);
                    }else if(entregar2 == 2 && rest.matriz[3][2] != null) {
                        for (int i = 0; i < rest.matriz[3][2].vector.length; i++) {
                            if (rest.matriz[3][2].vector[i] == pila.extraer()) {
                                rest.matriz[3][2].satisfecho++;
                                rest.matriz[3][2].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                        }
                        cuentaPorfis(rest.matriz[3][2]);
                        
                    }else if (entregar2 == 3 && rest.matriz[2][3] != null) {
                        for (int i = 0; i < rest.matriz[2][3].vector.length; i++) {
                            if (rest.matriz[2][3].vector[i] == pila.extraer()) {
                                rest.matriz[2][3].satisfecho++;
                                rest.matriz[2][3].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                        }
                        cuentaPorfis(rest.matriz[2][3]);
                    }else if (entregar2 == 4 && rest.matriz[3][4] != null) {
                        for (int i = 0; i < rest.matriz[3][4].vector.length; i++) {
                            if (rest.matriz[3][4].vector[i] == pila.extraer()) {
                                rest.matriz[3][4].satisfecho++;
                                rest.matriz[3][4].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[3][4].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[3][4]);
                    }else{
                        System.out.println("Esa mesa no tiene clientes aun");
                    }
                }else if (entregar == 2) {
                    entregar2 = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para dos quiere tomar el pedido \n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4\n5 Para mesa #5"));
                    
                    if (entregar2 == 1 && rest.matriz[5][2] != null) {
                        for (int i = 0; i < rest.matriz[5][2].vector.length; i++) {
                            if (rest.matriz[5][2].vector[i] == pila.extraer()) {
                                rest.matriz[5][2].satisfecho++;
                                rest.matriz[5][2].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[5][2].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[5][2]);
                    }else if(entregar2 == 2 && rest.matriz[6][3] != null) {
                        for (int i = 0; i < rest.matriz[6][3].vector.length; i++) {
                            if (rest.matriz[6][3].vector[i] == pila.extraer()) {
                                rest.matriz[6][3].satisfecho++;
                                rest.matriz[6][3].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[6][3].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[6][3]);
                    }else if (entregar2 == 3 && rest.matriz[5][4] != null) {
                        for (int i = 0; i < rest.matriz[5][4].vector.length; i++) {
                            if (rest.matriz[5][4].vector[i] == pila.extraer()) {
                                rest.matriz[5][4].satisfecho++;
                                rest.matriz[5][4].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[5][4].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[5][4]);
                    }else if (entregar2 == 4 && rest.matriz[6][2] != null) {
                        for (int i = 0; i < rest.matriz[6][2].vector.length; i++) {
                            if (rest.matriz[6][2].vector[i] == pila.extraer()) {
                                rest.matriz[6][2].satisfecho++;
                                rest.matriz[6][2].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[6][2].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[6][2]);
                        
                    }else if (entregar2 == 5 && rest.matriz[6][4] != null) {
                         for (int i = 0; i < rest.matriz[6][4].vector.length; i++) {
                            if (rest.matriz[6][4].vector[i] == pila.extraer()) {
                                rest.matriz[6][4].satisfecho++;
                                rest.matriz[6][4].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][2]);
                                break;
                            }
                            System.out.println(rest.matriz[6][4].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[6][4]);
                    }
                }else if (entregar == 3) {
                    entregar2 = Integer.parseInt(JOptionPane.showInputDialog("En cual mesa para dos quiere tomar el pedido \n1 Para mesa #1\n Para mesa #2\n Para mesa #3\n Para mesa #4\n6 Para mesa #5\n6 Para mesa #6\n7 Para mesa #7\n8 Para mesa #8\n9 Para mesa #9\n10 Para mesa #10"));
                    
                    if (entregar2 == 1 && rest.matriz[1][7] != null) {
                        for(int i = 0; i < rest.matriz[1][7].vector.length; i++) {
                            if (rest.matriz[1][7].vector[i] == pila.extraer()) {
                                rest.matriz[1][7].satisfecho++;
                                rest.matriz[1][7].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[1][7]);
                                break;
                            }
                            System.out.println(rest.matriz[1][7].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[1][7]);
                    }else if(entregar2 == 2 && rest.matriz[1][9] != null) {
                        for (int i = 0; i < rest.matriz[1][9].vector.length; i++) {
                            if (rest.matriz[1][9].vector[i] == pila.extraer()) {
                                rest.matriz[1][9].satisfecho++;
                                rest.matriz[1][9].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[1][9]);
                                break;
                            }
                            System.out.println(rest.matriz[1][9].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[1][9]);
                    }else if (entregar2 == 3 && rest.matriz[2][8] != null) {
                        for (int i = 0; i < rest.matriz[2][8].vector.length; i++) {
                            if (rest.matriz[2][8].vector[i] == pila.extraer()) {
                                rest.matriz[2][8].satisfecho++;
                                rest.matriz[2][8].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[2][8]);
                                break;
                            }
                            System.out.println(rest.matriz[2][8].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[2][8]);
                    }else if (entregar2 == 4 && rest.matriz[3][7] != null) {
                        for (int i = 0; i < rest.matriz[3][7].vector.length; i++) {
                            if (rest.matriz[3][7].vector[i] == pila.extraer()) {
                                rest.matriz[3][7].satisfecho++;
                                rest.matriz[3][7].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][7]);
                                break;
                            }
                            System.out.println(rest.matriz[3][7].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[3][7]);
                    }else if (entregar2 == 4 && rest.matriz[3][9] != null) {
                         for (int i = 0; i < rest.matriz[3][9].vector.length; i++) {
                            if (rest.matriz[3][9].vector[i] == pila.extraer()) {
                                rest.matriz[3][9].satisfecho++;
                                rest.matriz[3][9].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[3][9]);
                                break;
                            }
                            System.out.println(rest.matriz[3][9].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[3][9]);
                    }else if (entregar2 == 1 && rest.matriz[4][7] != null) {
                        for (int i = 0; i < rest.matriz[4][7].vector.length; i++) {
                            if (rest.matriz[4][7].vector[i] == pila.extraer()) {
                                rest.matriz[4][7].vector[i] = "Listo";
                                rest.matriz[4][7].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[4][7]);
                                break;
                            }
                            System.out.println(rest.matriz[4][7].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[3][9]);
                    }else if(entregar2 == 2 && rest.matriz[4][9] != null) {
                        for (int i = 0; i < rest.matriz[4][9].vector.length; i++) {
                            if (rest.matriz[4][9].vector[i] == pila.extraer()) {
                                rest.matriz[4][9].satisfecho++;
                                rest.matriz[4][9].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[4][9]);
                                break;
                            }
                            System.out.println(rest.matriz[4][9].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[4][9]);
                    }else if (entregar2 == 3 && rest.matriz[5][8] != null) {
                        for (int i = 0; i < rest.matriz[5][8].vector.length; i++) {
                            if (rest.matriz[5][8].vector[i] == pila.extraer()) {
                                rest.matriz[5][8].satisfecho++;
                                rest.matriz[5][8].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[5][8]);
                                break;
                            }
                            System.out.println(rest.matriz[5][8].vector[i]);
                        }
                        
                        cuentaPorfis(rest.matriz[5][8]);
                    }else if (entregar2 == 4 && rest.matriz[6][7] != null) {
                        for (int i = 0; i < rest.matriz[6][7].vector.length; i++) {
                            if (rest.matriz[6][7].vector[i] == pila.extraer()) {
                                rest.matriz[6][7].satisfecho++;
                                rest.matriz[6][7].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[6][7]);
                                break;
                            }
                            System.out.println(rest.matriz[6][7].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[6][7]);
                    }else if (entregar2 == 4 && rest.matriz[6][9] != null) {
                        for (int i = 0; i < rest.matriz[6][9].vector.length; i++) {
                            if (rest.matriz[6][9].vector[i] == pila.extraer()) {
                                rest.matriz[6][9].satisfecho++;
                                rest.matriz[6][9].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[6][9]);
                                break;
                            }
                            System.out.println(rest.matriz[6][9].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[6][9]);
                    }
                }else if (entregar == 4) {
                    entregar2 = Integer.parseInt(JOptionPane.showInputDialog("En cual campo de la barra quiere entregar la orden \n1 Para campo #1\n2 campo #2\n3 Para campo #3\n4 Para campo #4\n5 Para campo #5 "));
                    
                    if (entregar2 == 1 && rest.matriz[0][2] != null) {
                        for (int i = 0; i < rest.matriz[0][2].vector.length; i++) {
                            if (rest.matriz[0][2].vector[i] == pila.extraer()) {
                                rest.matriz[0][2].satisfecho++;
                                rest.matriz[0][2].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[0][2]);
                                break;
                            }
                            System.out.println(rest.matriz[0][2].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[0][2]);
                    }else if(entregar2 == 2 && rest.matriz[0][3] != null) {
                        for (int i = 0; i < rest.matriz[0][3].vector.length; i++) {
                            if (rest.matriz[0][3].vector[i] == pila.extraer()) {
                                rest.matriz[0][3].satisfecho++;
                                rest.matriz[0][3].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[0][3]);
                                break;
                            }
                            System.out.println(rest.matriz[0][3].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[0][3]);
                    }else if (entregar2 == 3 && rest.matriz[0][4] != null) {
                        for (int i = 0; i < rest.matriz[0][4].vector.length; i++) {
                            if (rest.matriz[0][4].vector[i] == pila.extraer()) {
                                rest.matriz[0][4].satisfecho++;
                                rest.matriz[0][4].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[0][4]);
                                break;
                            }
                            System.out.println(rest.matriz[0][4].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[0][4]);
                    }else if (entregar2 == 4 && rest.matriz[0][5] != null) {
                        for (int i = 0; i < rest.matriz[0][5].vector.length; i++) {
                            if (rest.matriz[0][5].vector[i] == pila.extraer()) {
                                rest.matriz[0][5].satisfecho++;
                                rest.matriz[0][5].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[0][5]);
                                break;
                            }
                            System.out.println(rest.matriz[0][5].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[0][5]);
                    }else if (entregar2 == 4 && rest.matriz[0][6] != null) {
                         for (int i = 0; i < rest.matriz[0][6].vector.length; i++) {
                            if (rest.matriz[0][6].vector[i] == pila.extraer()) {
                                rest.matriz[0][6].satisfecho++;
                                rest.matriz[0][6].vector[i] = "Listo";
                                pila.pop();
                                disminuirPaciencia(rest.matriz[0][6]);
                                break;
                            }
                            System.out.println(rest.matriz[0][6].vector[i]);
                        }
                        cuentaPorfis(rest.matriz[0][6]); 
                    }
                }
            }  
        };
        
        botones[0][1].addActionListener(sc);
    }
    
    public void entregaDespacho(){
//        final String menu[] = {"Pasta", "Hamburguesa", "Casado", "Pizza", "Chifrijo", "Tacos"};
        
        
    }
 
    public void caja(){
        MouseListener sc = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            final ImageIcon icon = new  ImageIcon("Mesa2.jpg");
            final ImageIcon icon1 = new  ImageIcon("Mesa3.jpg");
            final ImageIcon icon2 = new  ImageIcon("Mesa6.jpg");
            final ImageIcon icon3 = new  ImageIcon("barra.png");
                
                if (me.getButton() == MouseEvent.BUTTON3) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (rest.matriz[i][j] != null ){
                                    if (rest.matriz[i][j].satisfecho == rest.matriz[i][j].cantidadGrupo) {
                                        if ( i >0 && i < 4 && j > 2 && j < 5) {
                                            colaCaja.enqueue(rest.matriz[i][j]);
                                            botones[i][j].setIcon(new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                                            rest.matriz[i][j] = null;
                                            PonerImagenesCaja();
                                        }else if (i > 6 && i <= 7 && j > 3 && j < 5) {
                                            colaCaja.enqueue(rest.matriz[i][j]);
                                            botones[i][j].setIcon(new ImageIcon(icon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                                            rest.matriz[i][j] = null;
                                            PonerImagenesCaja();
                                        }else if (i == 0 && j > 3 && j < 7) {
                                            colaCaja.enqueue(rest.matriz[i][j]);
                                            botones[i][j].setIcon(new ImageIcon(icon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                                            rest.matriz[i][j] = null;
                                            PonerImagenesCaja();
                                        }else{
                                            colaCaja.enqueue(rest.matriz[i][j]);
                                            botones[i][j].setIcon(new ImageIcon(icon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                                            rest.matriz[i][j] = null;
                                            PonerImagenesCaja();
//                                            rest.matriz[i][j] != rest.matriz[5][0] && rest.matriz[i][j] != rest.matriz[0][9]
                                        }
//                                        PonerImagenesCaja();

                                    }

                            }
                        }
                    }
                }else if (me.getButton() == MouseEvent.BUTTON1) {
//                    rest.matriz[0][9] = colaCaja.extraer();
//                    String a = Integer.toString(rest.matriz[0][9].cantidadGrupo);
                    JOptionPane.showMessageDialog(null, "Dinero ganado: " + rest.matriz[0][9].cuenta);
                    colaCaja.dequeue();
                    rest.matriz[0][9] = colaCaja.extraer();
                    PonerImagenesCaja();
                    
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        };
        
        botones[0][9].addMouseListener(sc);
    }
     
    public void iniciarMenu(){
        MouseListener sc = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
            }
            

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        };
        
        botones[0][8].addMouseListener(sc);
    }
    
    public void disminuirPaciencia(Cliente a){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (rest.matriz[i][j] != null && rest.matriz[i][j] != rest.matriz[5][0] && rest.matriz[i][j] != a) {
                    rest.matriz[i][j].paciencia-=3;
                    System.out.println(rest.matriz[i][j].paciencia);
                }
            }
        }
    }
    
    public void cuentaPorfis(Cliente a){
        
        if (a.satisfecho == a.cantidadGrupo) {
            JOptionPane.showMessageDialog(null, "La cuenta porfis!!!!");
        }
    }
}
