import java.util.HashMap;
import java.util.Map;

class Floor {

    public static void main(String[] s) {
        //Please make input here
        int input[][] = {
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        };
        int count = getPartitionsCount(input);
        System.out.print(count);
    }

    public static int getPartitionsCount(int[][] floorMatrix) {
        Map<Integer, String> memorize = new HashMap();
        int count = 0;
        boolean currentRowHasNotCount = true;

        //cuz of 4 * 4 matrix
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 4; col++) {

                //if == 1
                if (floorMatrix[row][col] == 1) {

                    if (currentRowHasNotCount) {
                        //if nothing before current position
                        //check above column has been marked
                        if (!memorize.containsKey(col)) {
                            //if nothing above column , count++
                            count += 1;
                        }

                        //current has been count
                        currentRowHasNotCount = false;
                    }
                    //even current row has been count check the whole row to mark, which will use in next row
                    memorize.put(col, "");

                }

            }

            currentRowHasNotCount = true;
        }

        return count;
    }


}
