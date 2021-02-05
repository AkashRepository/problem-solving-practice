import java.util.*;

public class AvoidFloorInCity {


    public static void main(String[] args) {
        AvoidFloorInCity o =new AvoidFloorInCity();
        System.out.println(Arrays.toString(o.avoidFlood2(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(o.avoidFlood2(new int[]{1, 2, 3,4})));
        System.out.println(Arrays.toString(o.avoidFlood2(new int[]{1,0,2,3,0,1,2})));

        System.out.println(Arrays.toString(o.avoidFlood2(new int[]{1,0,2,0,3,0,2,0,0,0,1,2,3})));
    }

    public int[] avoidFlood2(int[] rains) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] ans = new int[rains.length];
        TreeSet<Integer> t = new TreeSet<>();
        for(int i=0;i<rains.length;i++){
            int a = rains[i];
            if(a==0){
                t.add(i);
                ans[i]=1;
                continue;
            }
            if(m.containsKey(a)){
                if(t.size()>0 && t.ceiling(m.get(a))!=null){
                    int temp = t.ceiling(m.get(a));
                    t.remove(temp);
                    ans[temp]=a;

                    m.put(a,i);
                    ans[i]=-1;
                } else {
                    return new int[]{};
                }
            } else {
                m.put(a, i);
                ans[i]=-1;
            }
        }
        return ans;

    }

    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] ans = new int[rains.length];
        int prev=-1;
        int[] z = new int[rains.length];

        for(int i=rains.length-1;i>=0;i--){
            z[i]=prev;
            if(rains[i]==0){
                prev=i;
            }
        }

        for(int i=0;i<rains.length;i++){
            int a = rains[i];
            if(a==0)
                continue;
            if(m.containsKey(a)){
                if(z[m.get(a)]!=-1 && z[m.get(a)] <  i && rains[z[m.get(a)]]==0){

                    ans[z[m.get(a)]]=a;
                    int j = m.get(a)-1;
                    while(j>=0){
                        if(z[j]==z[m.get(a)]){
                            z[j] = z[z[m.get(a)]];
                        }
                        j--;
                    }
                    rains[z[m.get(a)]]=Integer.MAX_VALUE;

                    m.remove(a);
                    ans[i]=-1;
                } else {
                    return new int[]{};
                }
            } else {
                m.put(a, i);
                ans[i]=-1;
            }
        }
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0 && ans[i]==0){
                ans[i]=1;
            }
        }
        return ans;

    }
}
