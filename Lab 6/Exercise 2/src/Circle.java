package src;

public class Circle extends Shape {

    Circle() {
        super();
        //TODO Auto-generated constructor stub
    }

    public Circle drawShape(Shape s) {

        return (Circle) s;
    }

    public void drawCircle(Circle c) {
        System.out.println(c);
    }


}
