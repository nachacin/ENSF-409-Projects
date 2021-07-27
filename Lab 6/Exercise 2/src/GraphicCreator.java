package src;

public class GraphicCreator {

    public void drawShape(Shape s) {
        if(s.getShapeType() == 1) {
            drawSquare((Square) s);
        }
        else if(s.getShapeType() == 2) 
            drawCircle((Circle) s);
    }

    public void drawCircle(Circle c) {
        System.out.println(c);
    }

    public void drawSquare(Square s) {
        System.out.println(s);
    }
    
}
