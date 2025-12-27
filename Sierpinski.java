/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		
		// set the canvas.
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);

		// set the tips of the triangle.
		double x1 = 0.0, y1 = 0.0;
    	double x2 = 1.0, y2 = 0.0;
    	double x3 = 0.5, y3 = 0.866;

		// draw the triangles.
    	sierpinski(n, x1, x2, x3, y1, y2, y3);
}

	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {

		// base case - draw one triangle.
		if (n == 0){
			StdDraw.line(x1, y1, x2, y2);
        	StdDraw.line(x2, y2, x3, y3);
        	StdDraw.line(x3, y3, x1, y1);
        	return;
		}

		// calculate the mid point.
		double mx12 = (x1 + x2) / 2.0;
        double my12 = (y1 + y2) / 2.0;

        double mx23 = (x2 + x3) / 2.0;
        double my23 = (y2 + y3) / 2.0;

        double mx13 = (x1 + x3) / 2.0;
        double my13 = (y1 + y3) / 2.0;

		// left triangle.
		sierpinski(n - 1,
                   x1, mx12, mx13,
                   y1, my12, my13);

        // right triangle.
        sierpinski(n - 1,
                   mx12, x2, mx23,
                   my12, y2, my23);

        // top triangle.
        sierpinski(n - 1,
                   mx13, mx23, x3,
                   my13, my23, y3);
		
	}
}
