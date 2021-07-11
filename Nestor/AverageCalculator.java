public class AverageCalculator {
    public static void main(String[] args){
        double x = 0;
        System.out.printf("The %s numbers are: ", args.length);
        for (int i = 0; i <args.length; ++i) {
            System.out.printf("%.3f ", Double.parseDouble(args[i]));
            x += Double.parseDouble(args[i]);
        }
        System.out.printf("\n\nAnd their average is: %.3f\n", x / args.length);
    }
}