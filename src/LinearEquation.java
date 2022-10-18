public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)

 */

public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
}

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
       the nearest hundredth */
    public double distance(){
        return (Math.sqrt((Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2.0))));
    }



    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        double slope = ((y2-y1) / (x2-x1));
        double yintercept = (y1 / (slope * x1));
        return yintercept;
    }



    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        double slope = ((y2-y1) / (x2-x1));
        return slope;
    }



    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation(){
        int numerator = (y2 -y1);
        int denominator = (x2-x1);


        if (denominator < 0){
            denominator = denominator * -1;
            numerator = numerator * -1;
        }

        if (numerator / denominator == 1){
            String slopeInerceptForm = ("y = " + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInerceptForm = ("y = " + "x" + " - " + (yIntercept() * -1) + "\n");
            }
            return slopeInerceptForm;
        }

        if (numerator % denominator == 0){
            String slopeInerceptForm = ("y = " + numerator/denominator + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInerceptForm = ("y = " + numerator/denominator + "x" + " - " + (yIntercept() * -1) + "\n");
            }
            return slopeInerceptForm;
        }



        String slopeAsFraction = numerator + "/" + denominator;
        String slopeInerceptForm = ("y = " + slope() + "x" + " + " + yIntercept() + "\n");
        return slopeInerceptForm;
    }





    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        double yValue = xValue * slope() + yIntercept();
        return roundedToHundredth(yValue) + "";
    }





    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound){
        double roundedNumber = (double)Math.round(toRound * 100) / 100;
        return roundedNumber;
    }



    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo(){
        String point1 = ("Point 1: " + "(" + x1 +"," + y1 + ")\n");
        String point2 = ("Point 2: " + "(" + x2 +"," + y2 + ")\n");
        double slope = slope();
        double yintercept = yIntercept();
        String slopeInerceptForm = equation();
        double distance = distance();
        return point1 + point2 + "The slope is: " + slope + "\n" + "The yintercept is: " + yintercept + "\n" + slopeInerceptForm + "The distance between the two points is: " + roundedToHundredth(distance);
    }




}
