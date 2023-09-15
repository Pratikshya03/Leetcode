/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int p=m+n;
        int nums3[]= new int[p];
        for(int i=0;i<m;i++)
        {
            nums3[i]=nums1[i];
        }
        for(int j=0;j<n;j++){
            nums3[m+j]=nums2[j];
        }
        for (int j = 1; j < p; j++) {
        int key = nums3[j];
        int i = j-1;
        while ((i >= 0 ) && (nums3[i] > key)) {
            nums3[i+1] = nums3[i];
            i--;
        }
        nums3[i+1] = key;
    }
        if(p%2==0)
        {
           int mid;
           mid=p/2;
           return (double) (nums3[mid]+nums3[mid-1])/2;
        }
        else
        {
            int mid;
            mid=p/2;
            return (double) nums3[mid];
        }
    }
}
    
    
