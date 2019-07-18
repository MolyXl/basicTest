import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MaZhuli
 * @description
 * @date 2019/7/3
 */
public class Test {

    public static void main(String[] args) {
        List<Map> list = new ArrayList<>();
        for(int i = 0;i<45;i++){
            Map map = new HashMap();
            map.put("key"+i,i);
            list.add(map);
        }
        List<List<Map>> returnList = new ArrayList<>(list.size() / 10);
        long begin = System.currentTimeMillis();
       /* for (int i = 0; i < list.size(); i += 10) {
            returnList.add(i + 10 < list.size() ? list.subList(i, i + 10) : list.subList(i, list.size()));
        }
        */
        for (int i = 0; i < list.size(); i++) {
            if ( i % 10 == 0 ) {
                int count = i/10;
                Stream<Map> stream = list.stream();
                Stream<Map> limit = stream.limit(20);
                List subList = (List) list.stream().limit((count + 1) * 10).skip(count * 10).collect(Collectors.toList());
                returnList.add(subList);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
    private static List<List> getSubList(List list,int len) {
       /* if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        List<List> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ( i % len == 0 ) {
                int count = i/len;
                List subList = (List) list.stream().limit((count + 1) * len).skip(count * len).collect(Collectors.toList());
                resultList.add(subList);
            }
        }
        return resultList;*/
       return null;
    }
}
