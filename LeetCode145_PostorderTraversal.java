import java.util.*;

/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
 */
/*
题目思路：前序遍历是 根 左 右
        可以实现   根 右 左
        压栈出栈   左 右 根
 */
public class LeetCode145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.add(root);
            while(!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if(root.left!=null){
                    s1.push(root.left);
                }
                if(root.right!=null){
                    s1.push(root.right);
                }
            }
            while(!s2.isEmpty()){
                list.add(s2.pop().val);
            }
        }
        return list;
    }
}
