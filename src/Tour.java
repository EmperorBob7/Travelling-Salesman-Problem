
public class Tour implements TourInterface {
	private ListNode root;

	public Tour() {
		
	}

	public Tour(Point a, Point b, Point c, Point d) {
		ListNode d1 = new ListNode(d);
		ListNode a1 = new ListNode(a, new ListNode(b, new ListNode(c, d1)));
		d1.next = a1;
		root = a1;
	}

	@Override
	public void draw(Point p) {
		if(root == null)
			return;
		ListNode t = root;
		boolean b = true;
		while(t != null && t.next != null && (!root.equals(t) || b)) {
			b = false;
			ListNode next = t.next;
			if(p != null && (t.equals(p) || next.equals(p))) {
				StdDraw.setPenColor(StdDraw.RED);
				t.current.drawTo(next.current);
			} else {
				StdDraw.setPenColor(StdDraw.BLACK);
				t.current.drawTo(next.current);
			}
			t = next;
		}
	}

	@Override
	public int size() {
		ListNode t = root;
		boolean b = true;
		int c = 0;
		while(t != null && !root.equals(t) || b) {
			b = false;
			c++;
			t = t.next;
		}
		return c;
	}

	@Override
	public double distance() {
		double d = 0;
		ListNode t = root;
		boolean b = true;
		while(t != null && t.next != null && (!root.equals(t) || b)) {
			b = false;
			ListNode next = t.next;
			d += t.current.distanceTo(next.current);
			t = next;
		}
		return d;
	}

	@Override
	public void insertInOrder(Point p) {
		ListNode t = root;
		if(t == null) {
			root = new ListNode(p);
			return;
		}
		while(t.next != null && t.next != root) {
			t = t.next;
		}
		t.next = new ListNode(p, root);
	}

	@Override
	public void insertNearest(Point p) {
		ListNode t = root;
		if(t == null) {
			root = new ListNode(p);
			root.next = root;
			return;
		}
		double min = Double.MAX_VALUE;
		ListNode m = t;
		while(t != null && !root.equals(t) || min == Double.MAX_VALUE) {
			double d = t.current.distanceTo(p);
			if((d != 0 || !root.equals(t)) && d < min) {
				min = d;
				m = t;
			}
			t = t.next;
		}
		m.next = new ListNode(p, m.next);
	}

	@Override
	public void insertSmallest(Point p) {
		ListNode t = root;
		if(t == null) {
			root = new ListNode(p);
			root.next = root;
			return;
		}
		ListNode m = t;
		double min = Double.MAX_VALUE;
		while(t != null && !root.equals(t) || min == Double.MAX_VALUE) {
			double d = t.current.distanceTo(p) + p.distanceTo(t.next.current) - t.current.distanceTo(t.next.current);
			if((d != 0 || !root.equals(t)) && d < min) {
				min = d;
				m = t;
			}
			t = t.next;
		}
		m.next = new ListNode(p, m.next);
	}

	public String toString() {
		ListNode t = root;
		String s = "";
		while (t != null && !root.equals(t) || s.equals("")) {
			s += t + "\n";
			t = t.next;
		}
		return s;
	}
	public static void main(String[] args) {
		Point a = new Point(100.0, 100.0);
	    Point b = new Point(500.0, 100.0);
	    Point c = new Point(500.0, 500.0);
	    Point d = new Point(100.0, 500.0);

	    // Set up a Tour with those four points
	    // The constructor should link a->b->c->d->a
	    Tour squareTour = new Tour(a, b, c, d);
	    System.out.println(squareTour.size());

	    // check the toString() and Output the Tour
	    StdOut.println(squareTour);

	    // check the distance -> 1600.0
	    StdOut.println(squareTour.distance());

	    // call draw -> should be square
	    squareTour.draw(a);
	}
}

class ListNode {
	public Point current;
	public ListNode next;

	public ListNode(Point p) {
		current = p;
	}

	public ListNode(Point p, ListNode next) {
		current = p;
		this.next = next;
	}

	public String toString() {
		return current.toString();
	}
	
	public boolean equals(ListNode n) {
		if(n == null)
			return true;
		return current.equals(n.current);
	}
	
	public boolean equals(Point p) {
		return current.distanceTo(p) == 0;
	}
}