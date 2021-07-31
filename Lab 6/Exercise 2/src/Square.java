package src;
public class Square extends Shape {

    Square() {
        super();
        //TODO Auto-generated constructor stub
    }

    public Square drawShape(Shape s) {

        return (Square) s;
    }

    public void drawSquare(Square square) {
        System.out.println(square);
    }

    
}
