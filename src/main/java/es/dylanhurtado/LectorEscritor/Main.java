package es.dylanhurtado.LectorEscritor;

public class Main {

    private final static int TIMES = 7;
    private final static int READERS = 2;
    private final static int WRITERS = 2;

    public static void main(String[] args) {

        //Resource
        Resource resource = new Resource();

        //Writers
        for (int i = 0; i < READERS; i++) {
            Reader reader = new Reader(i,TIMES,resource);
            reader.start();
        }

        //Writers
        for (int i = 0; i < WRITERS; i++) {
            Writer writer = new Writer(i,TIMES,resource);
            writer.start();
        }

    }
}
