package src;
public class Square extends Shape {

    private static int shapeType = 2;

    Square(int type) {
        super(shapeType);
    }

    public void drawSquare(Square s) {

    }

    @Override
    public int getShapeType() {
        // TODO Auto-generated method stub
        return shapeType;
    }
    
    
}
