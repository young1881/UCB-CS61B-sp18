package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static final TERenderer ter = new TERenderer();
    private static final TETile[][] world = new TETile[WIDTH][HEIGHT];

    public HexWorld(){
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    private static void addRow(int s, int i, int py, TETile newt){

        for (int j = py; j < py + 2 * s; j++){
            if (py + s - j <= s / 2 + i){
                world[i][j] = newt;
            }
        }
    }

    // add a hexagon of side length s to a given position in the world
    public static void addRandom(int s, int px, int py, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least size 2.");
        }

        TETile newt = TETile.colorVariant(t, 32, 32, 32, RANDOM);
        for(int i = px; i < px + s ; i++){
            addRow(s, i - px, py, newt);
        }
        for(int i = px + 2 * s - 1; i >= px + s; i--){
            addRow(s, px + 2 * s - 1 - i, py, newt);
        }

    }

    public static void main(String[] args) {
        HexWorld myWorld = new HexWorld();
        myWorld.addRandom(3, 10, 10, Tileset.FLOWER);

        // draws the world to the screen
        ter.renderFrame(world);

    }
}
