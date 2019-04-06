package sort;

/**
 * 快速排序
 * @author zlf
 */
public class quickSort {
    public static void quickSort(int[] a, int left, int right) {
        //以最左边数为基准
        int base = a[left];
        while (left < right) {
            //从序列右端开始，向左遍历，直到找到小于base的数
            while (left < right && a[right] >= base) {
                right--;
            }
            a[left] = a[right];
            //从序列左端开始，向右遍历，直到找到大于base的数
            while (left < right && a[left] <= base) {
                left++;
            }
            a[right] = a[left];

        }
        // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        a[left] = base;
        quickSort(a, left, left - 1);//对基准元素左边的元素进行递归排序
        quickSort(a, left + 1, a.length-1);  //对基准元素右边的进行递归排序

    }

    public static void main(String[] args) {
        int a[] = {18, 2, 6, 3, 77, 33, 89,56,7};
        int length = a.length-1;
        quickSort(a, 0, length);
        for (int i = 0,size = length; i < size; i++) {
            System.out.print(a[i]+",");
        }
    }

}


