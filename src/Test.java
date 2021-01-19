public class Test {
    public int finalInstances(int instances, int[] averageUtil) {
        for(int i=0;i< averageUtil.length;i++){
            int a = averageUtil[i];
            if(a>1&&a<25 && instances>1){
                instances = (int)Math.ceil((instances*1.0)/2);
                i+=10;
            } else if(a>60){
                int newinstances = instances*2;
                if(newinstances <= 2*100_000_000){
                    i+=10;
                    instances = newinstances;
                }
            }
        }
        return instances;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.finalInstances(200000000, new int[]{100}));
    }

}
