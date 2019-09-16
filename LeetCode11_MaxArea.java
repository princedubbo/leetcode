/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
示例:
输入: [1,8,6,2,5,4,8,3,7]
输出: 49
 */
//Area = Max(min(height[i], height[j]) * (j-i)) {其中0 <= i < j < height.length}
/*
   基本的表达式: area = min(height[i], height[j]) * (j - i) 使用两个指针，
   值小的指针向内移动，这样就减小了搜索空间 因为面积取决于指针的距离与值小的值乘积，
   如果值大的值向内移动，距离一定减小，而求面积的另外一个乘数一定小于等于值小的值，
   因此面积一定减小，而我们要求最大的面积，因此值大的指针不动，而值小的指针向内移动遍历
   */
public class LeetCode11_MaxArea {
    public int maxArea(int[] height) {
        if(height==null || height.length<=1){
            return -1;
        }
        int i=0,j=height.length-1,res=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            res = Math.max(res,h*(j-i));
            if(height[i]<height[j])i++;
            else j--;
        }
        return res;
    }
}
