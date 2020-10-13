package Search;

public class Interpolation {
    public static void main(String[] args) {
        int n = 9;
        int pos;
        int key = 23;
        int[] num = {0, 1, 5, 9, 13, 17, 23, 32, 45};

        pos = inter_search(num, key, n);
        if (pos == -1) {
            System.out.println("Cannot find!");
        } else {
            System.out.println(pos);
        }
    }

    public static int inter_search(int num[], int key, int n) {
        int pos;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            pos = left + ((right - left) * (key - num[left])) / (num[right] - num[left]);
            if (num[pos] < key) {
                left = pos + 1;
            } else if (num[pos] > key) {
                right = pos - 1;
            } else if (num[pos] == key){
                return pos;
            }else return -1;
        }
        return -1;
    }
}

