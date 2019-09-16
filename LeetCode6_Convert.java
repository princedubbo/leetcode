/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G
 */

/* 算法思路：观察示例可知，往下走要走numRows步，往上走要走numRows-2步（除去头尾，因为和往下走重叠）
    1、模拟Z字遍历字符串
    2、往下走numRows步
    3、往上走numRows-2步
    4、重复1，2直到字符串遍历结束*/
public class LeetCode6_Convert {
    public String convert(String s, int numRows) {
        if(numRows<2) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sbs[i] = new StringBuilder();
        }
        int index = 0,len = s.length();
        while(index<len){
            for(int i=0;i<numRows && index<len;i++){ //往下走
                sbs[i].append(s.charAt(index++));
            }
            for(int i=numRows-2;i>0 && index<len;i--){ //往上走
                sbs[i].append(s.charAt(index++));
            }
        }
        for(int i=1;i<numRows;i++){
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
