package FileDataOperation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 这个文件是关于对每一行的排序，我们选取每一行的第四个元素，人口密度进行对比然后得到排序
 * rows是我在fileReader里面把每一行都存储进来的List
 */

class Classifier {
    public static void classify(List<String[]> rows){
        rows.sort(new Comparator<>() {
            public int compare(String[] row1, String[] row2) {
                //选取两行的人口密度进行对比
                double val1 = Double.parseDouble(row1[3]);
                double val2 = Double.parseDouble(row2[3]);
                return Double.compare(val1, val2);
            }
        });

        //降序输出，如果不加这行就是升序输出
        Collections.reverse(rows);
    }
}
