package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public static class Position {
        private final int x;
        private final int y;

        public Position(int Px, int Py) {
            x = Px;
            y = Py;
        }
    }

    private static int hexRowWidth(int s, int y) {
        return (y < s) ? (s - 1 - y) : (y - s);
    }

    private static int hexRowOffset(int s, int y) {
        return (y < s) ? (y * 2 + s) : (s + (s - 1) * 2 - (y - s) * 2);
    }

    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        int width;
        int offset;
        for (int y = 0; y < 2 * s; y++) {
            width = hexRowWidth(s, y);
            offset = hexRowOffset(s, y);
            for (int x = width; x < width + offset; x++) {
                world[x + p.x][y + p.y] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
            }
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        int s = 3;
        Position[][] p = new Position[5][9];
        for (int y = 0; y < 9; y++) {
            if (y == 0 || y == 8) {
                int x = 2;
                p[x][y] = new Position((2 * s - 1) * x, y * s);
            } else if (y % 2 == 0) {
                for (int x = 0; x < 5; x = x + 2) {
                    p[x][y] = new Position((2 * s - 1) * x, y * s);
                }
            } else {
                for (int x = 1; x < 4; x = x + 2) {
                    p[x][y] = new Position((2 * s - 1) * x, y * s);
                }
            }
            //0,2;1,13;2,024;3,13;4,024;5,13;6,024;7,13;8,2
        }
        TETile t = Tileset.GRASS;
        addHexagon(world, p[0][2], s, t);
        addHexagon(world, p[0][4], s, t);
        addHexagon(world, p[1][7], s, t);
        t = Tileset.FLOWER;
        addHexagon(world, p[3][7], s, t);
        addHexagon(world, p[4][6], s, t);
        addHexagon(world, p[1][1], s, t);
        t = Tileset.TREE;
        addHexagon(world, p[2][8], s, t);
        addHexagon(world, p[3][3], s, t);
        addHexagon(world, p[4][4], s, t);
        t = Tileset.MOUNTAIN;
        addHexagon(world, p[0][6], s, t);
        addHexagon(world, p[1][3], s, t);
        addHexagon(world, p[1][5], s, t);
        addHexagon(world, p[2][0], s, t);
        addHexagon(world, p[2][2], s, t);
        addHexagon(world, p[2][4], s, t);
        addHexagon(world, p[2][6], s, t);
        addHexagon(world, p[3][1], s, t);
        t = Tileset.SAND;
        addHexagon(world, p[3][5], s, t);
        addHexagon(world, p[4][2], s, t);

        ter.renderFrame(world);
    }
}
