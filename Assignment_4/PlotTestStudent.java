package assignment_4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {
    Plot plot;

    @BeforeEach
    void setUp() {
        plot = new Plot(1, 1, 5, 5);
    }

    @Test
    void testCopyConstructor() {
        Plot copiedPlot = new Plot(plot);
        assertEquals(plot.toString(), copiedPlot.toString());
    }

    @Test
    void testOverlaps() {
        Plot overlapPlot = new Plot(3, 3, 5, 5);
        assertTrue(plot.overlaps(overlapPlot));
    }

    @Test
    void testDoesNotOverlap() {
        Plot noOverlapPlot = new Plot(10, 10, 5, 5);
        assertFalse(plot.overlaps(noOverlapPlot));
    }

    @Test
    void testEncompasses() {
        Plot smallPlot = new Plot(2, 2, 1, 1);
        assertTrue(plot.encompasses(smallPlot));
    }

    @Test
    void testDoesNotEncompass() {
        Plot bigPlot = new Plot(0, 0, 10, 10);
        assertFalse(plot.encompasses(bigPlot));
    }

    @Test
    void testSettersAndGetters() {
        plot.setX(10);
        plot.setY(10);
        plot.setWidth(15);
        plot.setDepth(20);
        assertEquals(10, plot.getX());
        assertEquals(10, plot.getY());
        assertEquals(15, plot.getWidth());
        assertEquals(20, plot.getDepth());
    }

    @Test
    void testToString() {
        String expected = "1,1,5,5";
        assertEquals(expected, plot.toString());
    }

  
}
