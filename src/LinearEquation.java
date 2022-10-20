public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
}

    public double roundedToHundredth(double toRound){
        double roundedNumber = (double)Math.round(toRound * 100) / 100;
        return roundedNumber;
    }


    public double distance(){
        return (Math.sqrt((Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2.0))));
    }

    public double slope(){

        double slope = roundedToHundredth((double)(y2-y1) / (x2-x1));
        return slope;
    }

    public double yIntercept(){
        double slope = slope();
        double yintercept = ((double)y1 - (slope * x1));
        return yintercept;
    }

    public String equation(){
        double numerator = (y2 -y1);
        double denominator = (x2-x1);


        if (denominator < 0){
            denominator = denominator * -1;
            numerator = numerator * -1;
        }

        if (numerator / denominator == 1){
            String slopeInerceptForm = ("y = " + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInerceptForm = ("y = " + "x" + " - " + (yIntercept() * -1) + "\n");
            }
            if (yIntercept() == 0){
                slopeInerceptForm = ("y = x");
            }
            return slopeInerceptForm;
        }

        if (y2 == y1){
            String slopeInerceptForm = ("y = " + yIntercept());
        }

        if (numerator % denominator == 0){
            String slopeInerceptForm = ("y = " + numerator/denominator + "x" + " + " + yIntercept() + "\n");
            if (yIntercept() < 0){
                slopeInerceptForm = ("y = " + numerator/denominator + "x" + (yIntercept() * -1) + "\n");
            }
                if (yIntercept() == 0){
                    slopeInerceptForm = ("y = " + numerator/denominator + "x");
                }
            return slopeInerceptForm;
        }


        String slopeAsFraction = (int)numerator + "/" + (int)denominator;
        String slopeInerceptForm = ("y = " + slopeAsFraction + "x" + " + " + yIntercept() + "\n");
        if (yIntercept() < 0){
            slopeInerceptForm = ("y = " + slopeAsFraction + "x"  + yIntercept() + "\n");
        }
        return slopeInerceptForm;
    }

    public String coordinateForX(double xValue){
        double yValue = xValue * slope() + yIntercept();
        return roundedToHundredth(yValue) + "";
    }

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
