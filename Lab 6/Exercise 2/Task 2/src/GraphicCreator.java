public class GraphicCreator {
    //Some fields
    public GraphicCreator() {
        //Initialization of some fields
    }
    public void creator() {
        System.out.println("Hello do you want to draw a circle or a square?");
        /**
         * then proceeds to create instances of the appropriate graphics by 
         * calling their respective drawShape methods.
         */
    }
    public static void main(String[] args) {
        var aGraphicCreator = new GraphicCreator();
        aGraphicCreator.creator();
    }
}
