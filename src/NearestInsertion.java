
/** ***********************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac NearestInsertion.java
 *  Execution:    java NearestInsertion file.txt
 *  Dependencies: Tour.java Point.java In.java StdDraw.java
 *
 *  Run nearest neighbor insertion heuristic for traveling
 *  salesperson problemand plot results.
 *
 *  % java NearestInsertion tsp1000.txt
 *
 ************************************************************************ */
public class NearestInsertion {

    public static void main(String[] args) {
        // open input file
        //In inFile = new In(args[0]);
        In inFile = new In("tsp10.txt");

        // get dimensions
        int w = inFile.readInt();
        int h = inFile.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        TourInterface tour = new Tour();
        while (!inFile.isEmpty()) {
            double x = inFile.readDouble();
            double y = inFile.readDouble();
            Point p = new Point(x, y);
            tour.insertNearest(p);

            // uncomment the 4 lines below to animate
//             StdDraw.clear();
//             tour.draw(p);
//             StdDraw.text(100, 0, "" + tour.distance());
//             StdDraw.show(250);
        }

        // draw to standard draw
        StdDraw.clear();
        tour.draw(null);
        StdDraw.text(100, 0, "" + tour.distance());
        StdDraw.show(0);

        // print tour to standard output
        if (tour.size() < 20) {
            StdOut.println(tour);
        }
        System.out.printf("Tour distance =  %.4f\n", tour.distance());
        System.out.printf("Number of points = %d\n", tour.size());
    }

}
