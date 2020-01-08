import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {

        HashMap<Integer, Integer> values = new HashMap<>();

        try {
            File file = new File("data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                values.put(Integer.parseInt(line), i++);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int[] numberList = new int[] { 231552, 234756, 596873, 648219, 726312, 981237, 988331, 1277361, 1283379 };

        String solutions = "";
        for (int a = 0; a < numberList.length; a++) {
            for (int v : values.keySet()) {
                if (values.keySet().contains(numberList[a] - v)) {
                    solutions += "1";
                    break;
                }
            }
            if (solutions.length() - 1 != a)
                solutions += "0";
        }
        System.out.println(solutions);
    }

}