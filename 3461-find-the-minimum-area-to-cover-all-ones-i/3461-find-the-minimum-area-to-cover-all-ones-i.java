class Solution {
    public int minimumArea(int[][] grid) {
        
        int left , right, top, bottom;
        left = top = Integer.MAX_VALUE;
        right = bottom = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    top = Math.min(i, top);
                    bottom = Math.max(i, bottom);
                    left = Math.min(j, left);
                    right = Math.max(j, right);
                }
            }
        }

        return (bottom - top + 1)*(right - left + 1);
    }
}