// Write a JavaFX application that displays the side view of a spaceship that follows the movement of the mouse.
// When the mouse button is pressed down, have a laser beam shoot out of the front of the ship (one continuous beam,
// not a moving projectile) until the mouse mutton is released. Define the spaceship using a separate class.
// When the space bar is pressed the color of the laser beam changes.
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class MouseClickEvent11_29 extends Application {
    private ImageView imageView;
    private Line laser;
    private Group root;
    private double rocketX = 0;
    private double rocketY = 0;
    private double rocketXAdj;
    private double rocketYAdj;

    public void start(Stage stage) {
        imageView = new ImageView("rocket1.png");
        imageView.setScaleX(0.5); imageView.setScaleY(0.5);
        imageView.setRotate(90);//how to rotate and scale image?
        imageView.setX(rocketX);
        imageView.setY(rocketY);

        rocketXAdj = imageView.getX();
        rocketYAdj = imageView.getY();

        root = new Group(imageView);
        laser = new Line(0,0,0,0);
        root.getChildren().add(laser);
        Scene scene = new Scene(root, 800,500, Color.BLACK);

        scene.setOnKeyPressed(this::processKeyPress);
        scene.setOnMousePressed(this::processMousePress);
        scene.setOnMouseReleased(this::processMouseRelease);
        scene.setOnMouseMoved(this::processMouseMove);

        stage.setScene(scene);
        stage.setTitle("Rocket Ship");
        stage.show();
    }

    public void processMouseMove(MouseEvent event){
        //mouse following
        rocketX = event.getX();
        rocketY = event.getY();
        imageView.setX(rocketXAdj);
        imageView.setY(rocketYAdj);
    }

    public void processMousePress(MouseEvent event){
        laser.setStartX(imageView.getX());
        laser.setStartY(imageView.getY());
        laser.setEndX(800);
        laser.setEndY(imageView.getY());

        laser.setStroke(Color.RED);
        laser.setStrokeWidth(10);
        root.getChildren().add(laser);
    }

    public void processMouseRelease(MouseEvent event){
        //stop shooting
        laser.setStroke(null);
    }

    public void processKeyPress(KeyEvent event){
        //shoot lasers

        switch (event.getCode()) {
            case SPACE:
               // imageView.setY(imageView.getY() - JUMP);
                break;
            case DOWN:
                //imageView.setY(imageView.getY() + JUMP);
                break;
            case RIGHT:
                //imageView.setX(imageView.getX() + JUMP);
                break;
            case LEFT:
                //imageView.setX(imageView.getX() - JUMP);
                break;
            default:
                break;
        }
    }

}
