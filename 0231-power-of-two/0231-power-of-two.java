class Solution {
    public boolean isPowerOfTwo(int n) {
        int ans =1;
        for (int i =0; i<=30; i++){
            if(ans==n){
                return true;
            }
            if(ans * 2 < (Integer.MAX_VALUE)){
            ans = ans*2;
            }
        }
        return false;
    }
}


// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         return n > 0 && (n & (n - 1)) == 0;
//     }
// }