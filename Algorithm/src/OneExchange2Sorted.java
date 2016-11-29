/**
 * Created by cole on 2016-11-27.
 */
public class OneExchange2Sorted {
    public boolean oneExchange2Sorted(int[] a) {
        boolean result = true;
        int i = 0, j = i + 1;
        int count = 0;
        int length = a.length;

        while (j < length) {
            if (a[i] <= a[j]) {
                // 什么都不做
            } else {
                // 出现不等,进行交换
                if (j == length - 1) {
                    // 如果已经比较到最后一个,则直接进行交换
                    swap(a, i, j);
                    count++;
                } else {
                    // 未比较到最后一个,进行更多判断
                    while (j < length - 1) {
                        if (a[j] <= a[j + 1] && a[j + 1] <= a[i]) {
                            // 依次递增,且最大值不超过当前比较的较大值(即a[i]),就继续判断后续数字
                            // 例子: 5,3,4->3,4是递增的
                            j++;
                        } else if (a[j + 1] > a[i]) {
                            // 依次递增,且最大值超过当前比较的较大值(即a[i]),就和前一个数进行替换(及a[j])
                            // 例子: 5,3,6->6比5大
                            swap(a, i, j);
                            count++;
                            break;
                        } else if (a[j + 1] <= a[i + 1]) {
                            // 出现减小的情况,且减小的这个值小于当前比较的较小值(即a[i+1]),就和该数进行替换(及a[j+1])
                            // 例子: 5,3,4,3->最后一个3<=第一个3
                            swap(a, i, j + 1);
                            count++;
                            break;
                        } else {
                            // 出现减小的情况,且减小的这个值大于当前比较的较小值(即a[i+1])
                            // 例子: 5,3,5,4->因为前面的比较,保证了这种情况出现时,该数一定在3(比较的较小值)和5(比较的较大值)中间,即此处的4
                            // 上面这种情况必定无法完成交换
                            return false;
                        }
                    }
                    // 完成一轮操作,j++使其跳过已处理的数据
                    j++;
                }
            }
            // 更新i和j
            i = j;
            j = i + 1;
        }

        return count < 2 && result;
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

}
