/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"
 */
/*
manacher
    Case1:pR边界小于i
    Case2:pR边界大于i
            Case2.1 i对应点i' 在范围内
            Case2.2 i对应点i'压边界
            Case2.3 i对应点i' 在范围外
 */
public class LeetCode5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=0)
            return s;
        char[] charArr = manacherString(s);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int posCore = 0;
        for(int i=0;i<charArr.length;i++){
            pArr[i] = pR>i?Math.min(pArr[2*index-i],pR-i):1;
            while(i+pArr[i]<charArr.length && i-pArr[i]>-1){
                if(charArr[i+pArr[i]]==charArr[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>pR){
                pR = i+pArr[i];
                index = i;
            }
            if(pArr[i]>max){
                max = pArr[i];
                posCore = i;
            }
        }
        int start = (posCore-max)>>1;
        return s.substring(start+1,start+max);
    }

    //解决奇偶回文
    private char[] manacherString(String s){
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length()*2+1];
        int index = 0;
        for(int i=0;i<res.length;i++){
            res[i] = (i&1)==0?'#':charArr[index++];
        }
        return res;
    }
}
