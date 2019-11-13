package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
    private int idCarro;
    public static int posChegada;
    public static int posSaida;
    private Semaphore semaforo;

    public ThreadCarro(int idCarro, Semaphore semaforo) {
        this.idCarro = idCarro;
        this.semaforo = semaforo;
        this.start();
    }

    @Override
    public void run() {
        carroAndando();
        // finally serve para rodar algo independente do try ou do catch terem funcionado
        // (faz o release para ambos, seja qual funcionar)

        try {
            semaforo.acquire();
            carroParado();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
            carroSaindo();
        }
    }

    public void carroAndando() {
        int distanciaFinal = (int) ((Math.random() * 1001) + 1000);
        int variacaoDistancia = 100;
        int tempo = 100;
        int distanciaPercorrida = 0;

        while (distanciaPercorrida < distanciaFinal) {
            distanciaPercorrida += variacaoDistancia;
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("o carro " + idCarro + " já andou " + distanciaPercorrida + "m.");
        }

        posChegada++;
        System.out.println("o carro " + idCarro + " foi o " + posChegada + "º a chegar");
    }

    private void carroParado() {
        System.out.println("O carro " + idCarro + " parou.");
        int tempoParado = (int) ((Math.random() + 501) + 500);

        try {
            Thread.sleep(tempoParado);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void carroSaindo() {
        posSaida++;
        System.out.println("o carro " + idCarro + " saiu.");
    }
}
