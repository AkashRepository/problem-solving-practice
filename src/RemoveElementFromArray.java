import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        RemoveElementFromArray o = new RemoveElementFromArray();

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> collect = Stream.of(4, 1, 3,  1, 2, 1, 3).collect(Collectors.toList());
        System.out.println(o.removeElement(collect, 1));
        System.out.println(collect);
    }

    private void swap(int i, int j, List<Integer> a){
        if(i >= a.size() || j>=a.size())
            return;
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    public int removeElement(List<Integer> a, int b) {

        int n = a.size();
        int c=0;
        for(int aa: a){
            if(aa!=b)
                c++;
        }

        int i = 0, j = 1, t = c;
        while(i<a.size() && j<a.size()){
            while(i< a.size() && a.get(i)!=b){
                i++;
            }
            j = i+1;
            if(i>=a.size() || j>=a.size())
                break;
            while(j<a.size() && a.get(j)==b){
                j++;
            }
            swap(i, j, a);
            i++;
        }



        t = n-c;
        while(t-->0){
            a.remove(c);
        }
        return c;


    }
}
