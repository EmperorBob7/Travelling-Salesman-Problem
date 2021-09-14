
/** ***********************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac TSPTimer.java
 *  Execution:    java TSPTimer N
 *  Dependencies: Tour.java Point.java
 *
 *  Time the two heuristics by generating random instances of size N.
 *
 *  % java TSPTimer N
 *
 ************************************************************************ */
public class TSPTimer {

    public static void main(String[] args) {
        int SIZE = 600;
        int N = 1000;//Integer.parseInt(args[0]);
        System.out.printf("%-7s%-47s%-18s\n", "N", "Nearest insertion", "|Smallest insertion");
        for (; N <= 128000; N *= 2) {
            // generate data and run nearest insertion heuristic
            long timer1 = System.currentTimeMillis();
            Tour tour1 = new Tour();
            for (int i = 0; i < N; i++) {
                double x = Math.random() * SIZE;
                double y = Math.random() * SIZE;
                Point p = new Point(x, y);
                tour1.insertNearest(p);
            }
            double elapsed1 = (System.currentTimeMillis() - timer1) / 1000.0;
            System.out.printf("%-7d%-3s%15f", N, "dist:", tour1.distance());
            System.out.printf("%-6s%20s", "   time:", elapsed1 + " seconds  |");

            // generate data and run smallest insertion heuristic
            long timer2 = System.currentTimeMillis();
            Tour tour2 = new Tour();
            for (int i = 0; i < N; i++) {
                double x = Math.random() * SIZE;
                double y = Math.random() * SIZE;
                Point p = new Point(x, y);
                tour2.insertSmallest(p);
            }
            double elapsed2 = (System.currentTimeMillis() - timer2) / 1000.0;
            System.out.printf("%-3s%15f", "dist:", tour2.distance());
            System.out.printf("%-6s%20s\n", "   time:", elapsed2 + " seconds    ");
        }
    }
}
