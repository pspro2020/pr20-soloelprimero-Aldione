import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {

        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int[][] numbers = new int[5][5];
        int randomNumber = ThreadLocalRandom.current().nextInt(1,21);
        Matriz matriz = new Matriz(numbers, randomNumber);
        Busqueda busqueda = new Busqueda(matriz, numbers, randomNumber);
        List<Busqueda> busquedaArrayList = new ArrayList<>();
        busquedaArrayList.add(busqueda);
        
        crearMatriz(numbers);
        pintarMatriz(numbers, randomNumber);

        busquedaArrayList.add(new Busqueda(matriz, numbers, randomNumber));

        try {
            fixedThreadPool.invokeAny(busquedaArrayList);

        } catch (InterruptedException | ExecutionException ignored) {

        } finally {
            fixedThreadPool.shutdown();
        }

    }

    private static void pintarMatriz(int[][] numbers, int randomNumber) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("File %d:", i+1);
            for (int j = 0; j < numbers[0].length; j++) {
                System.out.printf(" %d", numbers[i][j]);
            }
            System.out.println();
        }
        System.out.printf("Number to search: %d\n", randomNumber);
    }

    private static void crearMatriz(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = ThreadLocalRandom.current().nextInt(1,11);
            }
        }
    }

}
