package FileDataOperation;
import  java.io.FileNotFoundException;
import java.util.List;
/*
*本文件是所有操作的集合
*/


class FileDataOperation{
    public void Operation(String keyword,int numElements){

        try{
            //调用预处理的dataLoader来读取每一行的数据
            List<String[]> rows = dataLoader.loader();

            //调用排序函数接口Comparator.java
            Classifier.classify(rows);

            //问题二按照人口密度排序
            CountryContinentMapping.printCountryOrder(rows);

            //问题三对大洲人口数进行统计
            CountryContinentMapping.printContinentCount();

            //问题四进行关键字的搜索
            searchCountry.search(rows,keyword);

            //问题五利用洗牌将所有行打乱选取前十行，对这前十行在再进行排序输出
            RandomUtil.randomPut(rows, numElements);


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}




