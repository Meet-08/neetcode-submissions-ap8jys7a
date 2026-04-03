/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 1;
        int r = n - 2;
        int peakIdx = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int midEl = mountainArr.get(mid);
            int left = mountainArr.get(mid - 1);
            int right = mountainArr.get(mid + 1);
            
            if(left < midEl && midEl > right){
                peakIdx = mid;
                break;
            }

            if(left < midEl &&midEl < right){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        System.out.println(peakIdx);

        int leftRes = binarySearch(0, peakIdx - 1, target, true, mountainArr);

        if(leftRes == -1) return binarySearch(peakIdx, n - 1, target, false, mountainArr);

        return leftRes;
    }

    private int binarySearch(int l, int r, int target, boolean ascending, MountainArray mountainArr) {
        while (l <= r) {
            int m = (l + r) / 2;
            int val = mountainArr.get(m);
            if (val == target) {
                return m;
            }
            if (ascending == (val < target)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}