package es.dylanhurtado.LectorEscritor;

import java.util.Random;

public class Reader extends Thread {
    private int id;
    private int times;
    private Resource resource;
    private Random random;

    public Reader(int id, int times, Resource resource) {
        this.id = id;
        this.times = times;
        this.resource = resource;
        this.random = new Random();
    }

    public void run() {

        for (int i = 0; i < times; i++) {
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.read(id);


        }
    }
}
