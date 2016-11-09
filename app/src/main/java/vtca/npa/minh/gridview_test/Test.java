package vtca.npa.minh.gridview_test;

import java.util.ArrayList;

/**
 * Created by MINH on 14 Aug 2016.
 */
public class Test {
    public static ArrayList<Cell> getTestCell() {
        ArrayList<Cell> cells = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Cell c = new Cell("http://lorempixel.com/500/500?rand=" + i);
            cells.add(c);
        }

        return cells;
    }

}
