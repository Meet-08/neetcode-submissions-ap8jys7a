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

        int leftRes = binarySearch(0, peakIdx - 1, target, mountainArr);

        if(leftRes == -1) return binarySearch(peakIdx, n - 1, target, mountainArr);

        return leftRes;
    }

    private int binarySearch(int start, int end, int target,  MountainArray mountainArr){
        while(start <= end){
            int m = (start + end) / 2;
            int mid = mountainArr.get(m);

            if(mid == target) return m;

            if(mid < target){
                start = m + 1;
            }else{
                end = m - 1;
            }
        }

        return -1;
    }
}