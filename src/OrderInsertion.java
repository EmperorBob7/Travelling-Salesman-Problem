
/** ***********************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac OrderInsertion.java
 *  Execution:    java OrderInsertion file.txt
 *  Dependencies: Tour.java Point.java In.java StdDraw.java
 *
 *  Run order of input insertion heuristic for traveling
 *  salesperson problem and plot results.
 *
 *  % java OrderInsertion tsp10.txt
 *
 ************************************************************************ */
public class OrderInsertion {

    public static void main(String[] args) {
        // open input file
        //In inFile = new In(args[0]);
        In inFile = new In("tsp1000.txt");

        // get dimensions
        int w = inFile.readInt();
        int h = inFile.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        Tour tour = new Tour();
        while (!inFile.isEmpty()) {
            double x = inFile.readDouble();
            double y = inFile.readDouble();
            Point p = new Point(x, y);
            System.out.println(p);
            tour.insertInOrder(p);

            //comment out the 4 lines below to disable animation
//            StdDraw.clear();
//            tour.draw(p);
//            StdDraw.text(100, 0, "" + tour.distance());
//            StdDraw.show(1000);
        }

        // draw to standard draw
        StdDraw.clear();
        tour.draw(null);
        StdDraw.text(100, 0, "" + tour.distance());
        StdDraw.show(0);

        // print tour to standard output
        //StdOut.println(tour);
        System.out.printf("Tour distance =  %.4f\n", tour.distance());
        System.out.printf("Number of points = %d\n", tour.size());
    }

}
