/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente2;

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
    DataInputStream entrada;
    DataOutputStream salida;
    private Carro PersonajePrincipal;
    
    public Hilo2(Socket socket,Carro personajePrincipal) throws IOException{
      this.socket = socket;
      this.entrada = new DataInputStream(socket.getInputStream());
      this.salida = new DataOutputStream(this.socket.getOutputStream());
      this.PersonajePrincipal = personajePrincipal;
    }

    @Override
    public void run() {
        while(true){
            try {
                
                int recibi = this.entrada.readInt();
                System.out.println("recibi"  + recibi);
                switch (recibi) {
                case 1: 
                    this.PersonajePrincipal.setX(this.PersonajePrincipal.getX() - 10 );
                    break;
                case 2: this.PersonajePrincipal.setX(this.PersonajePrincipal.getX() +10); break;
                case 3: this.PersonajePrincipal.setY(this.PersonajePrincipal.getY() -10); break;
                case 4: this.PersonajePrincipal.setY(10 + this.PersonajePrincipal.getY()); break;
              }
                
            } catch (IOException ex) {
                Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
            }
               
             
            
        }
    }
    
}
