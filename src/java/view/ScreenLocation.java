package view;

import java.awt.*;

public class ScreenLocation {
    private int width;
    private int height;
    private int locationX;
    private int locationY;

    public void setWindowLocation(int percentHeight,int percentWidth){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width/100*percentWidth;
        locationX = (screenSize.width-width)/2;
        height = screenSize.height/100*percentHeight;
        locationY = (screenSize.height-height)/2;

    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

}
