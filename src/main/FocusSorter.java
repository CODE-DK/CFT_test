import java.util.List;

public class FocusSorter {
     static <T extends Comparable> List<T> sort(List<T> list, String sortKey){
        int j = 0;
        T temp;

        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);

            if (sortKey.equals("-a")){
                for (j = i - 1; j >= 0 && list.get(j).compareTo(temp) > 0; j--) {
                    list.set(j + 1, list.get(j));
                }
            }else if (sortKey.equals("-d")){
                for (j = i - 1; j >= 0 && list.get(j).compareTo(temp) < 0; j--) {
                    list.set(j + 1, list.get(j));
                }
            }else {
                System.out.println("Sort key is not supported");
                System.exit(0);
            }
            list.set(j + 1, temp);
        }
        return list;
    }
}
