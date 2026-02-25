package Classes;

import GUI.ScreenSaver;
import java.awt.*;

public class Square extends Shape{
    //    Constructor:
    public Square(Color color1, Color color2, int width, int xPosition, int yPosition, int xSpeed, int ySpeed) {
        this.setShapeColor1(color1);
        this.setShapeColor2(color2);
        this.setShapeWidth(width);
        this.setShapeHeight(width);
        this.setxPosition(xPosition);
        this.setyPosition(yPosition);
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);

//        This is to update the rectangle. Extracted from Gemini AI
        this.setBounds(this.getxPosition(), this.getyPosition(), this.getShapeWidth(), this.getShapeHeight());
    }

    //    Methods:
    public void drawShape(Graphics g){
//        Uses the flag colorChanged to decided if color should be swapped or not
        if (!this.isColorChanged()) {
            g.setColor(this.getShapeColor1());
        } else {
            g.setColor(this.getShapeColor2());
        }

//        Uses Graphic to draw and fill the square
        g.fillRect(this.getxPosition(), this.getyPosition(), this.getShapeWidth(), this.getShapeWidth());
    }

    //    Moves the shape by adding its x and y speed to its x and y positions respectively
//    It also detects when the shape hits any side of the current window and changes its
//    direction accordingly.
    public void moveShape(ScreenSaver ss){
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());

        if (this.getxPosition() > ss.getWidth() - this.getShapeWidth() || this.getxPosition() < 0) {
            this.setxSpeed(-getxSpeed());
        }

        if (this.getyPosition() > ss.getHeight() - this.getShapeWidth() || this.getyPosition() < 0) {
            this.setySpeed(-getySpeed());
        }

//        This is to update the rectangle.  Extracted from Gemini AI
        this.setBounds(this.getxPosition(), this.getyPosition(), this.getShapeWidth(), this.getShapeHeight());
    }

    //    This is used by the collision detection logic. It changes
//    the speed of the shape and also the flag that controls the color.
    public void invertSpeed() {
        this.setColorChanged(!this.isColorChanged());
        this.setxSpeed(-getxSpeed());
        this.setySpeed(-getySpeed());
    }
}