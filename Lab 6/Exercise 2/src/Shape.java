package src;
abstract public class Shape {


    private int shapeType;


    Shape(int type) {
        this.shapeType = type;
    }

    
    abstract public int getShapeType();

    
    
}
