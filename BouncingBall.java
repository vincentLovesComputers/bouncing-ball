
/*
 * This program graphically simulates a bouncing ball
 */
import acm.program.*;
import acm.graphics.*;

import java.awt.*;

public class BouncingBall extends GraphicsProgram{

    /** Size(diameter) of the ball*/

    private static final int DIAM_BALL = 30;

    /** Amount Y velocity is increased each cycle as a result of gravity*/

    private static final double GRAVITY = 3;

    /** Animation delay or pause time between ball moves*/
    private static final int DELAY = 50;

    /** Initial X and Y location of the ball */

    private static final int X_START = DIAM_BALL/2;
    private static final int Y_START = 100;

    /** X velocity*/

    private static final double X_VEL = 5;


    /** Amount Y velocity is reduced by 90% when it bounces*/

    private static final double BOUNCE_REDUCE = 0.9;


    /** Starting X and Y Velocities*/
    private double x_Vel = X_VEL;
    private double y_Vel = 0.0;

    /*private instance variable*/
    private GOval ball;


    /*private instance variable*/

    public void run(){
        setup();

        //simulation ends when ball goes off right hand
        //end fo screen

        while(ball.getX() < getWidth()){
            moveBall();
            checkForCollision();
            pause(DELAY);
        }


    }

    /*creates and place ball*/
    private void setup(){
        setBackground(Color.blue);
        ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
        ball.setFilled(true);
        add(ball);
    }

    /**update and move ball*/
    private void moveBall(){
        //increase yVelocity due to gravity on each cycle
        y_Vel += GRAVITY;
        ball.move(x_Vel, y_Vel);

    }

    /** Determine collision with floor, update velocities
     * and locate as appropriate
     */
    private void checkForCollision(){
        //determine if ball has dropped below the floor
        if(ball.getY() > getHeight() - DIAM_BALL){

            //change ball's yVelocity to now bounce upwards
            y_Vel = -y_Vel*BOUNCE_REDUCE;

            //assume bounce will move ball an amount above the
            //floor equal to the amount it would have dropped
            //below the floor
            double diff = ball.getY() - (getHeight() - DIAM_BALL);
            ball.move(0, -2*diff);
        }
    }
}
