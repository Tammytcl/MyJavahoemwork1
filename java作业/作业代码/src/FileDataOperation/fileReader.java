package FileDataOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class dataLoader {
    public static List<String[]> loader() throws FileNotFoundException {
        //文件地址
        File file = new File("D:/Desktop/java作业/作业代码/data/population.csv");
        Scanner sc = new Scanner(file);
        String columns = sc.nextLine();
        //考虑先把每一行都用一个string类型的数组rows进行存储，然后再考虑比较
        List<String[]> rows = new ArrayList<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[]fields = line.split(",");
            rows.add(fields);
        }
        return rows;
    }
}
