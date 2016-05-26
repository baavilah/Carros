/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author jhojan
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo2 implements Runnable {
    
    private Socket socket ; 
    private Socket cliente1;
    DataOutputStream salida; 
    DataInputStream entrada2;
    DataOutputStream salida2;
    private Personaje2 personaje2;
    
    public Hilo2(Socket socket,Socket cliente1,Personaje2 personaje2) throws IOException{
      this.socket = socket;
      this.cliente1 = cliente1;
      this.entrada2 = new DataInputStream(socket.getInputStream());
      this.salida2 = new DataOutputStream(this.socket.getOutputStream());
      this.salida = new DataOutputStream(this.cliente1.getOutputStream());
      this.personaje2 = personaje2;
    }

    @Override
    public void run() {
        while(true){
            try {
                
                int recibi = this.entrada2.readInt();
                salida.writeInt(recibi);
                salida.flush();
                System.out.println("envie "  + recibi);
                System.out.println("recibi "  + recibi);
                switch (recibi) {
                case 1: 
                    this.personaje2.setX(this.personaje2.getX() - 10 );
                    break;
                case 2: this.personaje2.setX(this.personaje2.getX() +10); break;
                case 3: this.personaje2.setY(this.personaje2.getY() -10); break;
                case 4: this.personaje2.setY(10 + this.personaje2.getY()); break;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            
        }
    }
}
