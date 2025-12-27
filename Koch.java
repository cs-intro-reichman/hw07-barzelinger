/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0){
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		// caclulate the length of the line;
		double Xvector = (x2 - x1);
		double Yvector = (y2 - y1);

		// devide the line to three parts and get the outer two parts.
		double Ax = x1 + (Xvector / 3);
		double Ay = y1 + (Yvector / 3);
		double Bx = x1 + 2 * (Xvector / 3);
		double By = y1 + 2 * (Yvector / 3);
		
		// create the angle of the curve.
		double rx = 0.5 * (Xvector / 3) + Math.sqrt(3) / 2 * (Yvector / 3);
		double ry = -(Math.sqrt(3) / 2) * (Xvector / 3) + 0.5 * (Yvector / 3);

		// get the peak.
		double peakx = Ax + rx;
		double peaky = Ay + ry;
		
		// create the lines.
		// x1y1 -> A
		curve(n -1 , x1, y1, Ax, Ay);
		// A -> peak
		curve(n - 1, Ax, Ay, peakx, peaky);
		// peak -> B
		curve(n - 1 , peakx, peaky, Bx, By);
		// B -> x2y2
		curve(n - 1, Bx, By, x2, y2);

	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		
		// Draws a Koch snowflake of depth n
		double ax = 0.1, ay = 0.25;
    	double bx = 0.9, by = 0.25;
		double cx = 0.5;
		double cy = 0.25 + (0.8 * 0.866); // 0.8 * √3/2

		curve(n, ax, ay, bx, by); 
		curve(n, bx, by, cx, cy); 
		curve(n, cx, cy, ax, ay); 


	}
}
