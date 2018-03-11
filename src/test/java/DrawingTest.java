import static  org.junit.Assert.*;
import org.junit.Test;

public class DrawingTest {

    @Test
    public void drawingTest() throws Exception {

        String result = null;

        // C 20 4
        Board board = new Board(20, 4);
        result = board.toString();
        assertEquals(result,
                "----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n");

        //L 1 2 6 2
        board.line(1, 2, 6, 2);
        result = board.toString();
        assertEquals(result,
                "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------\n");


        //L 6 3 6 4
        board.line(6, 3, 6, 4);
        result = board.toString();
        assertEquals(result,
                "----------------------\n" +
                "|                    |\n" +
                "|xxxxxx              |\n" +
                "|     x              |\n" +
                "|     x              |\n" +
                "----------------------\n");

        //R 14 1 18 3
        board.rectangle(14, 1, 18, 3);
        result = board.toString();
        assertEquals(result,
                "----------------------\n" +
                "|             xxxxx  |\n" +
                "|xxxxxx       x   x  |\n" +
                "|     x       xxxxx  |\n" +
                "|     x              |\n" +
                "----------------------\n");

        //B 10 3 o
        board.fill(10, 3, 'o');
        result = board.toString();
        assertEquals(result,
                "----------------------\n" +
                "|oooooooooooooxxxxxoo|\n" +
                "|xxxxxxooooooox   xoo|\n" +
                "|     xoooooooxxxxxoo|\n" +
                "|     xoooooooooooooo|\n" +
                "----------------------\n");
    }

}
