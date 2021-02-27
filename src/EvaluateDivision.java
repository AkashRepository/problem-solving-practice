import java.util.*;



public class EvaluateDivision {



    public static void main(String[] args) {
        EvaluateDivision o = new EvaluateDivision();
//        [["a","b"],["b","c"],["bc","cd"]]
//[1.5,2.5,5.0]
//[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
        System.out.println(Arrays.toString(o.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")
                , Arrays.asList("bc", "cd")),
                new double[]{1.5,2.5,5.0}, Arrays.asList(Arrays.asList("a","c"),
                        Arrays.asList("c","b"), Arrays.asList("a", "a"), Arrays.asList("cd", "bc")))));
        System.out.println(Arrays.toString(o.calcEquation(
                Arrays.asList(Arrays.asList("x1","x2"), Arrays.asList("x2","x3"), Arrays.asList("x3","x4"), Arrays.asList("x4","x5")),
                new double[]{3.0,4.0,5.0,6.0},
                Arrays.asList(Arrays.asList("x1","x5"), Arrays.asList("x5","x2"), Arrays.asList("x2","x4"), Arrays.asList("x2","x2"), Arrays.asList("x2","x9"), Arrays.asList("x9","x9"))
        )));

    }


    static class Node {
        String a;
        String b;

        public Node(String a, String b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(Object nodeObj){
            if(nodeObj==null)
                return false;
            Node node = (Node)nodeObj;
            return node.a.equals(this.a) && node.b.equals(this.b);
        }

        public int hashCode(){
            return 31*this.a.hashCode()*this.b.hashCode();
        }
    }

    private void put(String a, String b, double val, Map<String, LinkedList<String>> m, Map<Node, Double> mv){
        Node node = new Node(a,b);
        mv.put(node, val);
        Node node1 = new Node(b,a);
        mv.put(node1, 1/val);
        if(!a.equals(b)){
            LinkedList<String> n = m.getOrDefault(a, new LinkedList<>());
            n.add(b);
            LinkedList<String> n1 = m.getOrDefault(b, new LinkedList<>());
            n1.add(a);
            m.put(a,n);
            m.put(b,n1);
        }
    }

    private Double dfs(String u,Map<String, LinkedList<String>> m, Map<Node, Double> mv, Node end,
                       HashSet<String> hs){
        if(mv.get(end)!=null)
            return mv.get(end);
        Node n = new Node(end.b, end.a);
        if(mv.get(n)!=null) {
            return 1 / mv.get(n);
        }

        if(m.get(u)==null)
            return null;
        for(String v : m.get(u)) {
            if(hs.contains(v))
                continue;
            hs.add(v);
            Node newEnd = new Node(v, end.b);
            Node nodev = new Node(u, v);
            Double val = dfs(v, m, mv, newEnd,hs);
            if(val!=null){
                Double d = val * mv.get(nodev);
                put(v, end.b, val, m, mv);
                return d;
            }
        }

        return null;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, LinkedList<String>> m = new HashMap<>();
        Map<Node, Double> mv = new HashMap<>();
        int i=0;
        for(List<String> e : equations){

            put(e.get(0), e.get(1), values[i], m, mv);
            put(e.get(0), e.get(0), 1.0, m, mv);
            put(e.get(1), e.get(1), 1.0, m, mv);
            i++;
        }
        i=0;
        double[] output = new double[queries.size()];
        Queue<String> q = new LinkedList<>();
        for(List<String> query : queries) {
            Node end = new Node(query.get(0), query.get(1));

            HashSet<String> hs = new HashSet<>();
            hs.add(query.get(0));
            Double val = dfs(query.get(0), m, mv, end,hs);
            if(val==null){
                output[i] = -1.0;
            } else{
                put(query.get(0), query.get(1), val, m, mv);
                output[i] = val;
            }
            i++;
        }
        return output;

    }
}
