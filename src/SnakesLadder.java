import java.util.LinkedList;
import java.util.Queue;

public class SnakesLadder {

    public static void main(String[] args) {
        SnakesLadder o = new SnakesLadder();
        System.out.println(o.snakesAndLadders(new int[][]{{1,1,-1},{1,1,1},{-1,1,1}}));
    }

    static class Node{
        int val;
        int sum;
        public Node(int val){
            this.val=val;
        }
    }

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<Node> q = new LinkedList<>();
        Node first = new Node(1);
        q.add(first);

        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.val] = true;
            for(int i=node.val+1;i<=node.val+6 && i<=n*n;i++){

                if(!visited[i]){
                    Node nn = new Node(i);
                    nn.sum = node.sum + 1;
                    int idx = (i-1)/n;
                    int x = n-1-idx ;
                    int y = 0;
                    if(idx%2==0){
                        y = (i-1)%n;
                    } else {
                        y = n - (i-1)%n - 1;
                    }
                    if(board[x][y]!=-1){
                        nn.val = board[x][y];
                    }
                    if(nn.val==n*n){
                        return nn.sum;
                    }
                    if(!visited[nn.val])
                        q.add(nn);
                }
            }
        }
        return -1;
    }
}
