package Classes;

import GUI.ScreenSaver;
import java.awt.*;

public class Triangle extends Shape{
    //    Attributes:
    private int numPoints;
    private int[] x;
    private int[] y;

    //    Constructor:
    public Triangle(Color color1, Color color2, int[] x, int[] y, int xSpeed, int ySpeed) {
        this.setShapeColor1(color1);
        this.setShapeColor2(color2);
        this.setCoordX(x);
        this.setxPosition(x[0]);
        this.setShapeWidth(x[1]);
        this.setCoordY(y);
        this.setyPosition(y[0]);
        this.setShapeHeight(y[2]);
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);
        numPoints = 3;

//        This is to update the rectangle. Extracted from Gemini AI
        this.setBounds(getCoordX()[2], getCoordY()[0], getCoordX()[1] - getCoordX()[2], getCoordY()[2] - getCoordY()[0]);
    }

    //    Getters & Setters:
    public int[] getCoordX() {
        return x;
    }

    public void setCoordX(int[] x) {
        this.x = x;
    }

    public int[] getCoordY() {
        return y;
    }

    public void setCoordY(int[] y) {
        this.y = y;
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
        g.fillPolygon(this.getCoordX(), this.getCoordY(), numPoints);
    }

    //    Moves the shape by adding its x and y speed to its x and y positions respectively
//    It also detects when the shape hits any side of the current window and changes its
//    direction accordingly.
    public void moveShape(ScreenSaver ss){
        int[] newX = {getCoordX()[0] + this.getxSpeed(), getCoordX()[1] + this.getxSpeed(), getCoordX()[2] + this.getxSpeed()};
        this.setCoordX(newX);
        int[] newY = {getCoordY()[0] + this.getySpeed(), getCoordY()[1] + this.getySpeed(), getCoordY()[2] + this.getySpeed()};
        this.setCoordY(newY);

        if (this.getCoordX()[1] > ss.getWidth() || this.getCoordX()[2] < 0) {
            this.setxSpeed(-getxSpeed());
        }

        if (this.getCoordY()[2] > ss.getHeight() || this.getCoordY()[0] < 0) {
            this.setySpeed(-getySpeed());
        }

//        This is to update the rectangle.  Extracted from Gemini AI
        this.setBounds(getCoordX()[2], getCoordY()[0], getCoordX()[1] - getCoordX()[2], getCoordY()[2] - getCoordY()[0]);
    }

    //    This is used by the collision detection logic. It changes
//    the speed of the shape and also the flag that controls the color.
    public void invertSpeed() {
        this.setColorChanged(!this.isColorChanged());
        this.setxSpeed(-getxSpeed());
        this.setySpeed(-getySpeed());
    }
}
