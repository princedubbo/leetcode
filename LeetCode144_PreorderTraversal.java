import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述:给定一个二叉树，返回它的 前序 遍历。
 示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,2,3]
 */
public class LeetCode144_PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
        return list;
    }
}
