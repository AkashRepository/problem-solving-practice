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
        int[] ls = new int[n*n+1];
        int row = 1;
        int t = 1;
        for(int i=n-1;i>=0;i--){
            if(row%2==1){
                for(int j=0;j<n;j++,t++){
                    if(board[i][j]!=-1){
                        ls[t] = board[i][j];
                    }
                }
            } else {
                for(int j=n-1;j>=0;j--,t++){
                    if(board[i][j]!=-1){
                        ls[t] = board[i][j];
                    }
                }
            }
            row++;
        }


        Node first = new Node(1);

        visited[first.val] = true;
        q.add(first);
        // System.out.println(Arrays.toString(ls));
        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.val==n*n){
                return node.sum;
            }
            for(int i=node.val+1;i<=node.val+6 && i<=n*n;i++){

                Node nn = new Node(i);
                nn.sum = node.sum + 1;
                nn.val = ls[nn.val]!=0?ls[nn.val]:i;

                if(visited[nn.val])
                    continue;

                q.add(nn);
                visited[nn.val]=true;
            }
        }
        return -1;
    }
}
