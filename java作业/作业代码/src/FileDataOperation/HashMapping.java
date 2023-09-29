package FileDataOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
/*
*考虑使用hash表
*/

class CountryContinentMapping{
    //建立（国家-大洲）的映射
    private static final Map<String, String> mapping = new HashMap<>();

    //建立每个大洲的累计表
    //在此处发现，如果使用int类型存储累计大洲的人口，会导致越界出现负值，采用double类型
    private static final Map<String, Double> countMap = new HashMap<>();

    static {
        mapping.put("中国", "亚洲");
        mapping.put("孟加拉国", "亚洲");
        mapping.put("印度", "亚洲");
        mapping.put("印度尼西亚", "亚洲");
        mapping.put("菲律宾", "亚洲");
        mapping.put("伊朗", "亚洲");
        mapping.put("日本", "亚洲");
        mapping.put("越南", "亚洲");
        mapping.put("巴基斯坦", "亚洲");
        mapping.put("泰国", "亚洲");
        mapping.put("土耳其", "亚洲");

        mapping.put("英国", "欧洲");
        mapping.put("德国", "欧洲");
        mapping.put("意大利", "欧洲");
        mapping.put("法国", "欧洲");
        mapping.put("俄罗斯", "欧洲");

        mapping.put("墨西哥", "北美洲");
        mapping.put("美国", "北美洲");

        mapping.put("巴西", "南美洲");

        mapping.put("尼日利亚", "非洲");
        mapping.put("埃塞俄比亚", "非洲");
        mapping.put("刚果民主共和国", "非洲");
        mapping.put("坦桑尼亚", "非洲");
        mapping.put("南非", "非洲");
        mapping.put("埃及", "非洲");
    }

    //利用Hash表，传入国家名，传出大陆名
    public static String getContinent(String country) {
        return mapping.getOrDefault(country, "其他");
    }


    //对每个大陆的人口进行累计操作
    public static void counter(String continent, int population){
        countMap.put(continent, countMap.getOrDefault(continent,0.0)+population);
    }

    //国家按照人口密度排序之后的rows打印
    public static  void printCountryOrder(List<String[]> rows){
        System.out.println("-----------------------------------人口密度排序----------------------------------------");
        for (String[] row : rows) {
            //每一行的元素打印
            for (String s : row) {
                System.out.print(s + "\t\t");
            }
            String country = row[1];
            int population = Integer.parseInt(row[2]);
            //调用getContinent函数得到大洲名
            String continent = CountryContinentMapping.getContinent(country);
            System.out.print("\t\t" + continent);
            CountryContinentMapping.counter(continent, population);

            System.out.println();
        }
    }


    //每个大洲的人口总数打印
    public static void printContinentCount() {
        System.out.println("-----------------------------------大洲的人口总数-------------------------------------");
        DecimalFormat df = new DecimalFormat("#");//为了不采用科学计数法
        System.out.println("大洲人口统计：");
        for (Map.Entry<String, Double> entry : countMap.entrySet()) {
            String continent = entry.getKey();
            Double population = entry.getValue();
            System.out.println(continent + ": " + df.format(population));
        }
    }
}

