package src;


public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        Square s = new Square();
        ((Circle) c.drawShape(c)).drawCircle(c);
        ((Square) s.drawShape(s)).drawSquare(s);
 
        
    }
}
