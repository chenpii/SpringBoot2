package com.atguigu.boot.leetbook;

import java.util.*;

public class ArrayAndString {
    public static void main(String[] args) {
        Solution sl = new Solution();
        // int[] array = {1, 3, 5, 6};
        // System.out.println(sl.searchInsert(array, 2));
        // System.out.println(Arrays.toString(array));
        //
        // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // sl.rotate(matrix);
        // for (int[] data : matrix) {
        //     System.out.println(Arrays.toString(data));
        // }
        //
        // System.out.println("===============");
        // int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[] array2 = sl.findDiagonalOrder(mat);
        // System.out.println(Arrays.toString(array2));
        //
        // System.out.println("===============");
        // String[] strs = {"flower", "flow", "flight"};
        // System.out.println(sl.longestCommonPrefix(strs));
        //
        // System.out.println("===============");
        // String str = "babad";
        // System.out.println(sl.longestPalindrome(str));
        //
        // System.out.println("===============");
        // char[] chars = {'h', 'e', 'l', 'l', 'o'};
        // sl.reverseString(chars);
        // System.out.println(chars);
        //
        // System.out.println("===============");
        // int[] array3 = {1, 1, 0, 1, 1, 1};
        // System.out.println(sl.findMaxConsecutiveOnes(array3));
        //
        // System.out.println("===============");
        // int[] array4 = {2, 3, 1, 2, 4, 3};
        // int target = 7;
        // System.out.println(sl.minSubArrayLen(target, array4));
        //
        // System.out.println("===============");
        // System.out.println(sl.generate(5));
        //
        // System.out.println("===============");
        // System.out.println(sl.getRow(3));
        //
        // System.out.println("===============");
        // System.out.println(sl.reverseWords("God Ding"));
        //
        // System.out.println("===============");
        // System.out.println(Arrays.toString(sl.twoSum(new int[]{3, 2, 4}, 7)));
        //
        // System.out.println("===============");
        // System.out.println(sl.lengthOfLongestSubstring("abcbad"));

        // System.out.println(sl.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(sl.climbStairs(6));
    }
}

/*
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
class Solution {
    public Solution() {
    }

    /**
     * 数组中重复的元素最多保留2个
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (slow < 2 || nums[i] != nums[slow - 2]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 原地删除重复的元素
     *
     * @param nums nums = [1,1,2]
     * @return 2, nums = [1,2,_]
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[slow] != nums[i]) {
                nums[++slow] = nums[i];
            }
        }
        return slow + 1;
    }

    /**
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/array-and-string/yf47s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int leftIndex = i - 1; leftIndex > -1; leftIndex--) {
                left += nums[leftIndex];
            }
            for (int rightIndex = i + 1; rightIndex < nums.length; rightIndex++) {
                right += nums[rightIndex];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        //1、暴力遍历
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] >= target) {
        //         return i - 1;
        //     }
        // }
        // return nums.length;

        //2、二分法
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                //左边找
                right = mid - 1;
            } else left = mid + 1;

        }
        if (nums[left] > target) {
            return left - 1;
        } else if (nums[right] < target) {
            return right + 1;
        } else {
            return -1;
        }

    }

    /**
     * 合并区间
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int slow = 0;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < slow; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];

                int min = intervals[i][0];
                int max = intervals[i][1];

                if (min < start) {
                    if (max < start) { //不重叠
                        slow++;
                        intervals[slow] = intervals[i];
                    } else if (max >= start && max <= end) {
                        intervals[slow][0] = min;
                    } else {
                        intervals[slow][0] = min;
                        intervals[slow][1] = max;
                    }
                } else if (min >= start && min <= end) {
                    if (max <= end) { //包含在里面
                        continue;
                    } else {
                        intervals[slow][1] = max;
                    }
                } else { //不重叠
                    slow++;
                    intervals[slow] = intervals[i];
                }

            }
        }

        int[][] newArray = new int[slow + 1][];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = intervals[i];
        }
        return newArray;
    }

    /**
     * 矩阵逆时针旋转90°
     * 1.先对角翻转
     * 2.再左右翻转
     * 若是顺时针旋转90°
     * 1.先左右翻转
     * 2.再对角翻转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //对角翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                // if (i == j) {
                //     continue;
                // }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //左右翻转
        int mid = (matrix.length) / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }

    }

    /**
     * 若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int[] rowRecord = new int[M];
        int[] colRecord = new int[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rowRecord[i] == 1 || colRecord[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     * <p>
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;//行数
        int n = mat[0].length;//列数
        int[] array = new int[m * n];
        int arrayIndex = 0;

        for (int indexCount = 0; indexCount < m + n - 1; indexCount++) { //索引和为常数
            if (indexCount % 2 == 0) {//索引和为偶数，方向朝上，行数递减，列数递增
                //起始行数
                int startRow = Math.min(indexCount, m - 1);
                //终止列
                int endCol = Math.min(indexCount, n - 1);
                for (int i = startRow; indexCount - i <= endCol; i--) {
                    array[arrayIndex] = mat[i][indexCount - i];
                    arrayIndex++;
                }

            } else {//索引和为奇数，方向朝下，列数递减,行数递增
                //起始列数
                int startCol = Math.min(indexCount, n - 1);
                //终止行
                int endRow = Math.min(indexCount, m - 1);
                for (int j = startCol; indexCount - j <= endRow; j--) {
                    array[arrayIndex] = mat[indexCount - j][j];
                    arrayIndex++;
                }
            }
        }
        return array;
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String s : strs) {
            // 当前前缀以当前字符串开头，则更新前缀为当前字符串
            if (prefix.startsWith(s)) {
                prefix = s;
                continue;
            }
            for (int i = 0; i < prefix.length(); i++) {
                if (s.charAt(i) != prefix.charAt(i)) {
                    prefix = prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    /**
     * 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * 超时了
     *
     * @param s s = "babad"
     * @return "bab"
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = 0, end = 0;
        int len = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left > 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 > len) {
                        len = right - left + 1;
                        start = left;
                        end = right;
                    }
                    left--;
                    right++;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    //双指针

    /**
     * 翻转字符串
     * <p>
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     *
     * @param s 输入：s = ["h","e","l","l","o"]
     *          输出：["o","l","l","e","h"]
     */
    public void reverseString(char[] s) {
        int front = 0, back = s.length - 1;
        while (front < back) {
            char tmp = s[front];
            s[front] = s[back];
            s[back] = tmp;
            front++;
            back--;
        }
    }

    /**
     * 给定长度为2n的整数数组 nums ，
     * 你的任务是将这些数分成 n 对,
     * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从 1 到 n 的 min(ai, bi) 总和最大。
     * 返回该 最大总和 。
     *
     * @param nums nums = [1,4,3,2]
     * @return 4
     * <p>
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     * 所以最大总和为 4
     * <p>
     * [6,2,6,5,1,2]
     * [1,2,2,5,6,6]
     * 9
     */
    public int arrayPairSum(int[] nums) {
        //先排序，然后获取偶数索引位置之和
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            sum += Math.min(nums[i], nums[j]);
            i += 2;
            j += 2;
        }
        return sum;
    }

    /**
     * 两数之和 I - 数组无序
     * 要求时间复杂度小于O(n2)
     * 利用哈希表降低时间复杂度
     *
     * @param nums   nums = [3,2,4]
     * @param target 7
     * @return [0, 2]
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (left < right) {
            //利用哈希表保存 当前元素与目标值的差值及其索引，如果后续找到有元素跟差值一样，说明这两个元素就是要找的。
            if (map.containsKey(nums[left])) {
                return new int[]{map.get(nums[left]), left};
            }
            map.put(target - nums[left], left);
            if (map.containsKey(nums[right])) {
                return new int[]{map.get(nums[right]), right};
            }
            map.put(target - nums[right], right);
            left++;
            right--;
        }
        return new int[]{0, 0};
    }

    /**
     * 找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s s = "abcabcbb"
     * @return 3 abc
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(c, i);
        }
        return res;

    }


    /**
     * 两数之和 II - 输入有序数组
     *
     * @param numbers [2,7,11,15]
     * @param target  9
     * @return [1, 2]
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] array = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == target - numbers[i]) {
                    array[0] = i + 1;
                    array[1] = j + 1;
                } else if (numbers[j] < target - numbers[i]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return array;
    }
    //双指针-快慢指针

    /**
     * 原地移除元素
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * @param nums nums = [3,2,2,3],
     * @param val  val = 3
     * @return 2, nums = [2,2]
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * 最大连续1的个数
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     *
     * @param nums nums = [1,1,0,1,1,1]
     * @return 3
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;//慢指针
        int max = 0;//最大连续1的个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                slow++;
            } else { //0的时候保存当前slow的值，然后重置到0
                max = Math.max(max, slow);
                slow = 0;
            }
        }
        max = Math.max(max, slow);
        return max;
    }


    //尺取法，根据快慢指针滑动，达到要求进行缩减

    /**
     * 长度最小的子数组
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * @param target target = 7
     * @param nums   nums = [2,3,1,2,4,3]
     * @return 2
     * 子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, sum = 0;
        int minLen = nums.length;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            if (sum >= target) { //达到要求，开始缩减
                while (true) {
                    if (sum - nums[slow] >= target) { //如果缩减后也能达到目标，则缩减
                        sum -= nums[slow];
                        slow++;
                    } else {
                        break;
                    }
                }
                //缩减完成，更新最小长度
                minLen = Math.min(fast - slow + 1, minLen);
            }
        }
        if (sum < target) { //所有加起来都没达到目标
            return 0;
        }
        return minLen;
    }

    /**
     * 杨辉三角
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * @param numRows numRows = 5
     * @return [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> list = new ArrayList<Integer>();
            if (row == 0) {
                list.add(1);
            } else {//左上+右上
                for (int j = 0; j < row + 1; j++) {
                    if (j == 0) { //第一个为1
                        list.add(1);
                    } else if (j == row) {//最后一个为1
                        list.add(1);
                    } else {
                        // 左上
                        int leftup = result.get(row - 1).get(j - 1);
                        //右上
                        int rightup = result.get(row - 1).get(j);
                        list.add(leftup + rightup);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 杨辉三角 2
     * 输出给定行的杨辉三角，要求空间复杂度为O(rowIndex)
     *
     * @param rowIndex rowIndex = 3
     * @return [1, 3, 3, 1]
     */
    public List<Integer> getRow(int rowIndex) {
        // 思路：
        // 1.申请一个长度为k的数组，每个元素初始化为1
        // 2.如果给定的行数rowIndex小于等于2，则直接返回，否则需要进行迭代计算
        // 3.每次迭代依赖“上一行”的数据，迭代之后的数据覆盖“上一行”的数据
        // 4.每次迭代计算时，从后往前进行计算，可以避免“上一行”数据发生 变化
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
        }
        if (rowIndex < 2) {
            return result;
        }
        for (int i = 2; i <= rowIndex; i++) { //从2开始迭代到rowIndex
            for (int j = i - 1; j > 0; j--) { //每次迭代从后往前，从i-1遍历到1
                result.set(j, result.get(j) + result.get(j - 1));//等于本身+前一位
            }
        }
        return result;
    }

    //反转字符串中的单词 III

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * @param s s = "God Ding"
     * @return "doG gniD"
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0;
        for (; fast < chars.length; fast++) {
            //每个单词反转
            if (chars[fast] == ' ' || fast == chars.length - 1) {
                int forward = slow;
                int backward = fast - 1;
                if (fast == chars.length - 1) {
                    backward = fast;
                }
                while (forward < backward) {
                    char temp = chars[forward];
                    chars[forward] = chars[backward];
                    chars[backward] = temp;
                    forward++;
                    backward--;
                }
                slow = fast + 1;
            }
        }
        return new String(chars);
    }

    //寻找旋转排序数组中的最小值

    /**
     * @param nums nums = [3,4,5,1,2]
     * @return 1 原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     */
    public int findMin(int[] nums) {
        //找到无序点，无序点即为最小
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    /**
     * 移动0
     * 思路：快慢指针
     * 慢指针指向新数组的最后一位
     * 快指针遇到不为0的值
     *
     * @param nums nums = [0,1,0,3,12]
     *             执行后  [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * @param x x = -123
     * @return -321
     */
    public int reverse(int x) {
        int n = 0;
        while (x != 0) {//有正有反
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    /**
     * 判断是否是回文数字
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] chars = (x + "").toCharArray();
        boolean flag = true;
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            if (chars[left] != chars[right]) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
    }

    /**
     * 罗马数字转数字
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        //如果当前字符的值小于右边字符的值，则减去当前，反之加上当前值
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                num -= map.get(s.charAt(i));
            } else {
                num += map.get(s.charAt(i));
            }
        }
        //加上最后一个字符的值
        num += map.get(s.charAt(s.length() - 1));
        return num;
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     * <p>
     * 思路：只有子序列和大于0才对后面有益
     *
     * @param nums nums = [-2,1,-3,4,-1,2,1,-5,4]
     * @return 输出：6 连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public int maxSubArray(int[] nums) {

        int sum = 0;
        int result = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * @param s s = "   fly me   to   the moon  "
     * @return 4 最后一个单词是“moon”，长度为4。
     */
    public int lengthOfLastWord(String s) {
        // 方法一
        //字符串从后往前遍历，遇到不是空格的开始计数，开始计数后遇到空格结束计数。
        // int count = 0;
        // for (int i = s.length() - 1; i > -1; i--) {
        //     if (s.charAt(i) == ' ') { //遇到空格
        //         if (count == 0) {//还没开始计数
        //             continue;
        //         } else {//已开始计数
        //             break;
        //         }
        //     }
        //     count++;
        // }
        // return count;

        //方法二，从后往前找，先找到第一个不是空格的，再找第一个是空格的
        int count = 0;
        int i = s.length() - 1;
        int flag = 0;
        while (s.charAt(i) == ' ') {
            i--;
        }
        while (s.charAt(i) != ' ') {
            count++;
            i--;
            if (i < 0) break;
        }
        return count;
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * @param digits digits = [4,3,2,1]
     * @return [4, 3, 2, 2] 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        //两种情况，元素0-8，直接+1，返回，如果元素9，需要前一位再加一
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    public int climbStairs(int n) {
    /*
    第n阶梯只能从n-1或者n-2爬上来，所以方法有n-1+n-2种
     */
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);

    }


    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int slow = 0;

    }
}

