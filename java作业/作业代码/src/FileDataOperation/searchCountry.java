package FileDataOperation;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/*
*这是第五问国家名的搜索
* 我们传入keyword然后考虑存在搜索结果与不存在结果两种情况
*/


public class searchCountry {
    public static void search(List<String[]> rows, String keyword) {
        System.out.println("-------------------------关键字搜索--------------------------------------------------------");
        List<String[]> result = new ArrayList<>();
        //选取每一行的国家名进行关键字筛选，如果存在关键字就存入result
        for (String[] row : rows) {
            String name = row[1];
            if (name.contains(keyword)) {
                result.add(row);
            }
        }
        //判断result是否为空，以及不为空时的打印
        if (result.isEmpty()) {
            System.out.println("不存在包含关键字\"" + keyword + "\"的国家。");
        } else {
            System.out.println("包含关键字\"" + keyword + "\"的国家如下：");
            for (String[] row : result) {
                for(String s : row) {
                    System.out.print(s + "\t\t");
                }
                System.out.println();
            }
        }
    }
}