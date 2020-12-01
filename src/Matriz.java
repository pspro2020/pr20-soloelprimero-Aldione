import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Matriz {

    final int randomNumber;
    final int[][] number;

    public Matriz(int[][] number, int randomNumber) {
        this.number = number;
        this.randomNumber = randomNumber;
    }

    public boolean findNumber(int[][] number, int randomNumber) throws InterruptedException {
        double searchDuration = ThreadLocalRandom.current().nextDouble(0.5,2);
        boolean found = false;
        final int limitNumber = 10;

        if (randomNumber > limitNumber) {
            System.out.println("Wrong number.");
        } else {
            for (int i = 0; i < number.length; i++) {
                for (int j = 0; j < number[i].length; j++) {
                    if (number[i][j] == randomNumber) {
                        search(searchDuration);
                        System.out.printf("Number found on file %d, column %d\n", i+1, j+1);
                        found = true;
                    }
                }
            }
        }
        if (found) {
            System.out.printf("Number found in %.2f seconds\n", searchDuration);
        } else {
            System.out.printf("Number not found in %.2f seconds\n", searchDuration);
        }

        return found;
    }

    private void search(double searchDuration) throws InterruptedException {
        try {
            TimeUnit.SECONDS.sleep((long) searchDuration);
        } catch (InterruptedException e) {
            throw new InterruptedException();
        }
    }

}
