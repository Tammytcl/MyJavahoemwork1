package FileDataOperation;
import java.util.*;
/*
*这个函数是用来随机打乱之后选取乱序的前十行
* 利用shuffle进行洗牌，然后把乱序的前十行存入randomRows
* 由于输出的时候需要对这十行进行排序，这里就调用之前写的排序函数
 */


class RandomUtil {
    public static void randomPut(List<String[]> rows, int numElements) {
        System.out.println("---------------------------随机行排序------------------------------------------------------");

        Random random = new Random();
        List<String[]> randomRows = new ArrayList<>();
        // 随机打乱
        Collections.shuffle(rows, random);

        // 输出随机抽取的行
        for (int i = 0; i < numElements; i++)  {
            String[] row = rows.get(i);
            randomRows.add(row);
        }
        //由于排序要求和第二问相同，我们直接调用第二问定义的函数
        Classifier.classify(randomRows);
        for (String[] row : randomRows) {
            for (String s : row) {
                System.out.print(s + "\t\t");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------");
    }
}

 
