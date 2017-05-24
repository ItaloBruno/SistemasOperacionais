package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "AnimationTimer Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 1200, 720 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image earth = new Image("http://rpgromaduke.weebly.com/uploads/1/2/0/5/12057661/699305788.png");
        Image sun   = new Image( "http://3.bp.blogspot.com/-si0mjuVwqa4/VXz26Z4UzCI/AAAAAAAAJaA/dtXQNO7wWV4/s1600/beer_PNG2362.png" );
        Image space = new Image( "http://static.messynessychic.com/wp-content/uploads/2013/06/tavern.jpg" );



        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 ;

                // Clear the canvas
                gc.clearRect(0, 0, 512,512);

                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 196, 196 );
            }
        }.start();

        theStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
