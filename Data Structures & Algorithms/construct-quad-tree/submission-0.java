/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    private Node dfs(int[][] g, int n, int r, int c){
        boolean allSame = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(g[r][c] != g[r + i][c + j]){
                    allSame = false;
                    break;
                }
            }
        }

        if(allSame) return new Node(g[r][c] == 1, true);

        int mid = n / 2;

        Node topLeft = dfs(g, mid, r, c);
        Node topRight = dfs(g, mid, r, c + mid);
        Node bottomLeft = dfs(g, mid, r + mid, c);
        Node bottomRight = dfs(g, mid, r + mid, c + mid);

        return new Node(
            false,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}