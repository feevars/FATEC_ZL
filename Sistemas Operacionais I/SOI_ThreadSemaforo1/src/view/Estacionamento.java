package view;

import controller.ThreadCarro;
import java.util.concurrent.Semaphore;

public class Estacionamento {
    public static void main(String [] args) {
        int permissao = 3;
        
        Semaphore semaforo = new Semaphore(permissao);
         
         for (int idCarro=0; idCarro<10; idCarro++) {
             Thread carro = new ThreadCarro(idCarro, semaforo);
         }
    }
    

}