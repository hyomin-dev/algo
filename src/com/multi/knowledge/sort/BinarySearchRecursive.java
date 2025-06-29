package com.multi.knowledge.sort;


public class BinarySearchRecursive {
    public static void main(String[] args) {

        int n = 10;
        int[] array = {0, 1, 2, 3, 4, 5,6,7,8, 9};
        int target = 6;
        int result = binarySearch(array, target, 0, n-1); // target index
        if(result>=0)
            System.out.println(target+"의 위치는 "+result+"에 있습니다.");
        else
            System.out.println(target+"은 배열에 존재하지 않습니다.");
    }

    static int binarySearch(int[] array, int target, int start, int end){

        if(start>end) // start와 end가 같을 때 start == end == x인 경우 x와 x-1 또는 x+1과 x이므로 start>end인 경우임
            return -1;

        int mid = (start+end)/2;

        if(array[mid]==target)
            return mid;
        else if(array[mid]>target) // target이 array[mid] 왼쪽
            return binarySearch(array, target, start,mid-1 );
        else // target이 array[mid] 오른쪽
            return binarySearch(array, target, mid+1,end);

    }
}
