import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class FloodTest {

    @Test
    public void testSimple() {
        WaterColor[][] colors = {
                { WaterColor.BLUE, WaterColor.RED},
                { WaterColor.CYAN, WaterColor.YELLOW}
        };

        Board b = new Board(2, colors);
        b.tiles[0][0].setColor(WaterColor.RED);
        b.flood(0, WaterColor.RED);

        boolean [] [] flooded_solution = {
                { true,  true},
                { false, false}
        };

        for (int y = 0; y < b.size; y++) {
            for (int x = 0; x < b.size; x++) {
                assertEquals(b.flooded.contains(new Coord(x,y)), flooded_solution[y][x]);
            }
        }
    }

    @Test
    public void testTransitive() {
        WaterColor[][] colors = {
                { WaterColor.BLUE, WaterColor.RED,    WaterColor.RED},
                { WaterColor.CYAN, WaterColor.YELLOW, WaterColor.RED},
                { WaterColor.RED,  WaterColor.YELLOW, WaterColor.RED}
        };

        Board b = new Board(3, colors);
        b.tiles[0][0].setColor(WaterColor.RED);
        b.flood(0, WaterColor.RED);

        boolean [][] flooded_solution = {
                { true,  true,  true},
                { false, false, true},
                { false, false, true}
        };

        for (int y = 0; y < b.size; y++) {
            for (int x = 0; x < b.size; x++) {
                assertEquals(b.flooded.contains(new Coord(x,y)), flooded_solution[y][x]);
            }
        }
    }

    @Test
    public void testGame() {

        // Initialize the game
        WaterColor[][] colors_step0 = {
                { WaterColor.BLUE, WaterColor.RED,    WaterColor.CYAN,   WaterColor.YELLOW },
                { WaterColor.CYAN, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.PINK   },
                { WaterColor.CYAN, WaterColor.RED,    WaterColor.PINK,   WaterColor.PINK   },
                { WaterColor.BLUE, WaterColor.BLUE,   WaterColor.RED,    WaterColor.YELLOW }
        };

        Board b = new Board(4, colors_step0);

        // Flood the board with the 1st color and check the result.
        b.flood(0, WaterColor.RED);

        WaterColor[][] colors_step1 = {
                { WaterColor.RED,  WaterColor.RED,    WaterColor.CYAN,   WaterColor.YELLOW },
                { WaterColor.CYAN, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.PINK   },
                { WaterColor.CYAN, WaterColor.RED,    WaterColor.PINK,   WaterColor.PINK   },
                { WaterColor.BLUE, WaterColor.BLUE,   WaterColor.RED,    WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step1));

        // Fload the board with the 2nd color and check the results.
        b.flood(0, WaterColor.CYAN);

        WaterColor[][] colors_step2 = {
                { WaterColor.CYAN,  WaterColor.CYAN,   WaterColor.CYAN,   WaterColor.YELLOW },
                { WaterColor.CYAN,  WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.PINK   },
                { WaterColor.CYAN,  WaterColor.RED,    WaterColor.PINK,   WaterColor.PINK   },
                { WaterColor.BLUE,  WaterColor.BLUE,   WaterColor.RED,    WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step2));

        // Fload the board with the 3rd color and check the results.
        b.flood(0, WaterColor.YELLOW);

        WaterColor[][] colors_step3 = {
                { WaterColor.YELLOW,  WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW },
                { WaterColor.YELLOW,  WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.PINK   },
                { WaterColor.YELLOW,  WaterColor.RED,    WaterColor.PINK,   WaterColor.PINK   },
                { WaterColor.BLUE,    WaterColor.BLUE,   WaterColor.RED,    WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step3));

        // Fload the board with the 4th color and check the results.
        b.flood(0, WaterColor.PINK);

        WaterColor[][] colors_step4 = {
                { WaterColor.PINK, WaterColor.PINK, WaterColor.PINK, WaterColor.PINK   },
                { WaterColor.PINK, WaterColor.PINK, WaterColor.PINK, WaterColor.PINK   },
                { WaterColor.PINK, WaterColor.RED,  WaterColor.PINK, WaterColor.PINK   },
                { WaterColor.BLUE, WaterColor.BLUE, WaterColor.RED,  WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step4));

        // Fload the board with the 5th color and check the results.
        b.flood(0, WaterColor.BLUE);

        WaterColor[][] colors_step5 = {
                { WaterColor.BLUE, WaterColor.BLUE, WaterColor.BLUE, WaterColor.BLUE   },
                { WaterColor.BLUE, WaterColor.BLUE, WaterColor.BLUE, WaterColor.BLUE   },
                { WaterColor.BLUE, WaterColor.RED,  WaterColor.BLUE, WaterColor.BLUE   },
                { WaterColor.BLUE, WaterColor.BLUE, WaterColor.RED,  WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step5));

        // Fload the board with the 6th color and check the results.
        b.flood(0, WaterColor.RED);

        WaterColor[][] colors_step6 = {
                { WaterColor.RED, WaterColor.RED, WaterColor.RED, WaterColor.RED    },
                { WaterColor.RED, WaterColor.RED, WaterColor.RED, WaterColor.RED    },
                { WaterColor.RED, WaterColor.RED, WaterColor.RED, WaterColor.RED    },
                { WaterColor.RED, WaterColor.RED, WaterColor.RED, WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step6));

        // Fload the board with the 7th (and final) color and check the results.
        b.flood(0, WaterColor.YELLOW);

        WaterColor[][] colors_step7 = {
                { WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW },
                { WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW },
                { WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW },
                { WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW, WaterColor.YELLOW }
        };

        assertTrue(check_colors(b, colors_step7));

        // One final check.
        int num_tiles = b.getSize() * b.getSize();
        assertEquals(num_tiles, b.flooded.size());
    }

    private boolean check_colors(Board b, WaterColor[][] ref) {
        for (int x = 0; x < b.getSize(); ++x) {
            for (int y = 0; y < b.getSize(); ++y) {
                if (b.get(new Coord(x, y)).getColor() != ref[y][x]) {
                    return false;
                }
            }
        }

        return true;
    }
}
