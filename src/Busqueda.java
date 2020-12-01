import java.util.concurrent.Callable;

public class Busqueda implements Callable<Matriz> {

    private final Matriz matriz;
    private final int randomNumber;
    private final int[][] number;

    Busqueda(Matriz matriz, int[][] number, int randomNumber) {
        this.matriz = matriz;
        this.number = number;
        this.randomNumber = randomNumber;
    }

    @Override
    public Matriz call() throws InterruptedException {
        boolean search = matriz.findNumber(number, randomNumber);
        if (!search) {
            throw new RuntimeException("Search failed");
        }
        return matriz;
    }

}
