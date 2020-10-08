public class BinarySearch {
    public static void main(String[] args) {
        int n = 9;
        int pos;
        int key = 23;
        int[] num = {0, 1, 5, 9, 13, 17, 23, 32, 45};
        pos = binary_search(num, key, 0, n - 1);
        if (pos == -1) {
            System.out.println("Cannot find!");
        }
        else {
            System.out.println(pos);
        }
    }

    public static int binary_search(int num[], int key, int left, int right) {
        while (left <= right) {
            int med = (left + right) / 2;
            if (num[med] == key) {
                return med;
            } else if (num[med] < key) {
                left = med + 1;
            } else if (num[med] > key) {
                right = med - 1;
            }
        }
        return -1;
    }
}
//key=23 일 경우 6출력
//key=100 일 경우 Cannot find!출력