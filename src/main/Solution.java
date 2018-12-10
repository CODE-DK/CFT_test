import java.util.List;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args){
        if (args.length != 4){
            System.out.println("Entering parameters error");
            System.exit(0);
        }

        Solution solution = new Solution();
        solution.doSomething(args[0], args[1], args[2], args[3]);
    }

    private void doSomething(String inputPath, String outputPath, String dataKey, String sortKey) {

        FocusReader reader = new FocusReader(inputPath);
        FocusWriter writer = new FocusWriter(outputPath);

        if (dataKey != null){
            if (dataKey.equals("-i")){
                List<Integer> list = reader.read(Integer :: parseInt);
                if (list != null){
                    FocusSorter.sort(list, sortKey);
                    writer.write(list);
                }else System.out.println("list must be not null");
            }else if (dataKey.equals("-s")){
                List<String> list = reader.read(Function.identity());
                if (list != null){
                    FocusSorter.sort(list, sortKey);
                    writer.write(list);
                }else System.out.println("list must be not null");
            }else{
                System.out.println("Data type is not supported");
                System.exit(0);
            }
        }else {
            System.out.println("Data key is null");
            System.exit(0);
        }
    }
}
