package assignment_4;

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    /**
     * Default constructor creating a 1x1 plot at coordinates (0,0).
     */
    
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
    
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }
    
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

 // Getters and setters for x, y, width, and depth...

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public boolean overlaps(Plot otherPlot) {
        return !(otherPlot.x + otherPlot.width <= x || 
                 otherPlot.y + otherPlot.depth <= y || 
                 otherPlot.x >= x + width || 
                 otherPlot.y >= y + depth);
    }

    public boolean encompasses(Plot otherPlot) {
        return (otherPlot.x >= x && 
                otherPlot.y >= y && 
                otherPlot.x + otherPlot.width <= x + width && 
                otherPlot.y + otherPlot.depth <= y + depth);
    }


    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
