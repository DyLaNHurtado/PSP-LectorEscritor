package es.dylanhurtado.LectorEscritor;

public class Resource {

    private int writeRequests;
    private int writers;
    private int readers;
    private int data;

    public Resource() {
        writeRequests = 0;
        writers = 0;
        readers = 0;
        data = 0;
    }


    public synchronized void write(int id) {
        writeRequests++;
        while (readers > 0 || writers > 0) {
            try {
                System.out.println("Escritor " + id + " -> esta esperando ");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeRequests--;
        writers++;
        System.out.println("Escritor " + id + " -> comienza a escribir ");

        int DELAY = 5000;
        try {
            Thread.sleep((int) (Math.random() * DELAY));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        data++;
        System.out.println("Escritor " + id + " -> escribe " + data);
        System.out.println("Escritor " + id + " -> termina de escribir ");
        writers--;
        //Despierta todos los escritores
        notifyAll();
    }

    public synchronized void read(int id) {

        while (writeRequests > 0 || writers > 0) {

            try {
                System.out.println("Lector "+ id +" esta esperando");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
        int DELAY=5000;
        try {
            Thread.sleep((int)(Math.random()*DELAY));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lector " + id + " -> ha leido " + data);
        System.out.println("Lector " + id + " -> termina de leer");
        readers--;
        notifyAll();

    }
}
