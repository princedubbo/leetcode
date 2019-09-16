/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
注意：整数顺序将表示为一个字符串。
示例 1:
输入: 1
输出: "1"
示例 2:
输入: 4
输出: "1211"
 */
/*
    题目思路：对于前一个数，找出相同元素的个数，把个数和该元素存到新的string里
*/

public class LeetCode38_CountAndSay {
    public String countAndSay(int n) {
        if(n<=0) return "";
        StringBuilder sb = new StringBuilder("1");
        while((--n)>0){
            StringBuilder cur = new StringBuilder("");
            for(int i=0;i<sb.length();i++){
                int count = 1;
                while(i+1<sb.length() && sb.charAt(i)==sb.charAt(i+1)){
                    count++;
                    i++;
                }
                cur.append(count+"").append(sb.charAt(i));
            }
            sb = cur;
        }
        return  sb.toString();
    }
}
