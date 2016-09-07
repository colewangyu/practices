package Classical;

/**
 * Created by wy on 2016-09-07.
 */
public class hanoi {
    public static void main(String[] args) {
        hanoi(3, 1, 2, 3);
    }

    /**
     *
     * @param n 一共有多少个盘子需要移动
     * @param p1 第一个杆子的编号
     * @param p2 第二个杆子的编号
     * @param p3 第三个杆子的编号
     */
    public static void hanoi(int n, int p1, int p2, int p3) {
        if (n == 1) {
            System.out.println("盘子从" + p1 + "移动到" + p3);
        } else {
            hanoi(n - 1, p1, p3, p2);
            System.out.println("盘子从" + p1 + "移动到" + p3);
            hanoi(n - 1, p2, p1, p3);
        }
    }
}
