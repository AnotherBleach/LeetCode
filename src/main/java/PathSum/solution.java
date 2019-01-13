package PathSum;

public class solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {


        return calc(root,0,sum);
    }
    private boolean calc(TreeNode root,int current,int sum)
    {
       if(root!=null)
       {
           if(root.left == root.right&&root.left == null)
           {

               if(current+root.val == sum)return true;

           }
           else{

               if(calc(root.left,current+root.val,sum)==false)
                   return calc(root.right,current+root.val,sum);
               return true;

           }


       }
       return false;
    }
}
