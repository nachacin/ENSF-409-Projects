package src;
public class Shape implements GraphicCreator{

    private int shapeType;

    Shape(int type) {
        this.shapeType = type;
    }

    @Override
    public Shape drawShape(Shape s) {

        return s;
        
    }
    
    
}
