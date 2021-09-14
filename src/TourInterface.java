
/**
 * Interface for traveling salesman tours
 */
public interface TourInterface {

    /* PUBLIC METHODS */
    /**
     * returns the points in the tour, in order
     *
     * @return
     */
    String toString();

    /**
     * Draws the tour
     *
     * @param p draws any edge whose start or end point is p in a different
     * color
     */
    void draw(Point p);

    /**
     * Returns the number of points in the tour
     *
     * @return the number of points in the tour
     */
    int size();

    /**
     * Returns the total length of the tour
     *
     * @return the total length of the tour
     */
    double distance();

    /**
     * Insert p at the end of the tour; does nothing if p is null
     *
     * @param p the point to add to the tour
     */
    void insertInOrder(Point p);

    /**
     * Insert p after the point to which it is closest; does nothing if p is
     * null
     *
     * @param p the point to add to the tour
     */
    void insertNearest(Point p);

    /**
     * Insert p where it will cause the shortest detour; does nothing if p is
     * null
     *
     * @param p the point to add to the tour
     */
    void insertSmallest(Point p);
}
