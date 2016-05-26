/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente1;

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

public class Hilo implements Runnable{
    private Socket socket ; 
    DataInputStream entrada;
    DataOutputStream salida;
    private Personaje2 Personaje2;
    
    public Hilo(Socket socket,Personaje2 personaje2) throws IOException{
      this.socket = socket;
      this.entrada = new DataInputStream(socket.getInputStream());
      this.salida = new DataOutputStream(this.socket.getOutputStream());
      this.Personaje2 = personaje2;
    }

    @Override
    public void run() {
        while(true){
            try {
                
                int recibi = this.entrada.readInt();
                System.out.println("recibi"  + recibi);
                switch (recibi) {
                case 1: 
                    this.Personaje2.setX(this.Personaje2.getX() - 10 );
                    break;
                case 2: this.Personaje2.setX(this.Personaje2.getX() +10); break;
                case 3: this.Personaje2.setY(this.Personaje2.getY() -10); break;
                case 4: this.Personaje2.setY(10 + this.Personaje2.getY()); break;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            
        }
    }
    
}
