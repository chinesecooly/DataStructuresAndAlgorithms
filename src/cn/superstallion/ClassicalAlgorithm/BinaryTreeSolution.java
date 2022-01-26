package cn.superstallion.ClassicalAlgorithm;

import javax.lang.model.util.ElementFilter;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 二叉树
 */
public class BinaryTreeSolution {
    //94. 二叉树的中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        return inorderList;
    }
    public static void inorderTraversal(TreeNode root, List<Integer> inorderList) {
        if (root != null) {
            inorderTraversal(root.left, inorderList);
            inorderList.add(root.val);
            inorderTraversal(root.right, inorderList);
        }
    }

    //95. 不同的二叉搜索树 II
    //todo
    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    //96. 不同的二叉搜索树
    public int numTrees(int n) {
        return -1;
    }

    //98. 验证二叉搜索树
    static public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root != null) {
            if (root.val <= lower || root.val >= upper) {
                return false;
            } else {
                return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
            }
        } else {
            return true;
        }
    }

    //99. 恢复二叉搜索树
    static public void recoverTree(TreeNode root) {
        find(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    static public TreeNode find(TreeNode root, long lower, long upper) {
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null && root.right != null) {
            left = find(root.left, lower, root.val);
            right = find(root.right, root.val, upper);
        } else if (root.left != null) {
            left = find(root.left, lower, root.val);
        } else if (root.right != null) {
            right = find(root.right, root.val, upper);
        }
        if (root.val > upper || root.val < lower) {
            if (left != null && right != null) {
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                return null;
            } else if (left != null) {
                if (left.val > lower && left.val < upper) {
                    int temp = root.val;
                    root.val = left.val;
                    left.val = temp;
                    return null;
                } else {
                    return left;
                }
            } else if (right != null) {
                if (right.val > lower && right.val < upper) {
                    int temp = root.val;
                    root.val = right.val;
                    right.val = temp;
                    return null;
                } else {
                    return right;
                }
            } else {
                return root;
            }
        } else {
            return null;
        }
    }

    //100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    //101. 对称二叉树
    static public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        } else if (root.left.val != root.right.val) {
            return false;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }
    static public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

    //102. 二叉树的层序遍历
    static public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = null;
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if (root == null) {
            return lists;
        } else {
            queueA.offer(root);
        }
        for (; !queueA.isEmpty() || !queueB.isEmpty(); ) {
            for (; !queueA.isEmpty(); ) {
                TreeNode node = queueA.poll();
                if (list == null) {
                    list = new ArrayList<>();
                    lists.add(list);
                }
                list.add(node.val);

                if (node.left != null) {
                    queueB.add(node.left);
                }
                if (node.right != null) {
                    queueB.add(node.right);
                }
                if (queueA.isEmpty()) {
                    list = null;
                }
            }
            for (; !queueB.isEmpty(); ) {
                TreeNode node = queueB.poll();
                if (list == null) {
                    list = new ArrayList<>();
                    lists.add(list);
                }
                list.add(node.val);

                if (node.left != null) {
                    queueA.offer(node.left);
                }
                if (node.right != null) {
                    queueA.offer(node.right);
                }
                if (queueB.isEmpty()) {
                    list = null;
                }
            }
        }
        return lists;
    }

    //103. 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = null;
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if (root == null) {
            return lists;
        } else {
            queueA.offer(root);
        }
        for (; !queueA.isEmpty() || !queueB.isEmpty(); ) {
            for (; !queueA.isEmpty(); ) {
                TreeNode node = queueA.poll();
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(node.val);

                if (node.left != null) {
                    queueB.add(node.left);
                }
                if (node.right != null) {
                    queueB.add(node.right);
                }
                if (queueA.isEmpty()) {
                    lists.add(list);
                    list = null;
                }
            }
            for (; !queueB.isEmpty(); ) {
                TreeNode node = queueB.poll();
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(node.val);

                if (node.left != null) {
                    queueA.offer(node.left);
                }
                if (node.right != null) {
                    queueA.offer(node.right);
                }
                if (queueB.isEmpty()) {
                    Collections.reverse(list);
                    lists.add(list);
                    list = null;
                }
            }
        }
        return lists;
    }

    //104. 二叉树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //todo 改进
    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        return inPostBuildTree(preorder,inorder,null,false);
    }
    //105. 从前序与中序遍历序列构造二叉树
    static public TreeNode preInBuildTree(int[] preorder, int[] inorder,TreeNode root,boolean flag){
        int []preorderLeft=null;
        int []preorderRight=null;
        int []inorderLeft=null;
        int [] inorderRight=null;
        if (preorder.length!=1&&inorder.length!=1) {
            int index = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    index = i;
                    break;
                }
            }
            preorderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
            preorderRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
            inorderLeft = Arrays.copyOfRange(inorder, 0, index);
            inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        }
        if (root==null){
            root=new TreeNode(preorder[0]);
            if (preorderLeft!=null&&preorderLeft.length!=0){
                preInBuildTree(preorderLeft,inorderLeft,root,true);
            }
            if (preorderRight!=null&&preorderRight.length!=0){
                preInBuildTree(preorderRight,inorderRight,root,false);
            }
        }else if (flag){
            root.left=new TreeNode(preorder[0]);
            if (preorderLeft!=null&&preorderLeft.length!=0){
                preInBuildTree(preorderLeft,inorderLeft,root.left,true);
            }
            if (preorderRight!=null&&preorderRight.length!=0){
                preInBuildTree(preorderRight,inorderRight,root.left,false);
            }
        }else {
            root.right=new TreeNode(preorder[0]);
            if (preorderLeft!=null&&preorderLeft.length!=0){
                preInBuildTree(preorderLeft,inorderLeft,root.right,true);
            }
            if (preorderRight!=null&&preorderRight.length!=0){
                preInBuildTree(preorderRight,inorderRight,root.right,false);
            }
        }
        return root;
    }

    //106. 从中序与后序遍历序列构造二叉树
    static public TreeNode inPostBuildTree(int[] inorder, int[] postorder,TreeNode root,boolean flag){
        int []postorderLeft=null;
        int []postorderRight=null;
        int []inorderLeft=null;
        int [] inorderRight=null;
        if (postorder.length!=1&&inorder.length!=1) {
            int index = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == postorder[postorder.length-1]) {
                    index = i;
                    break;
                }
            }
            postorderLeft = Arrays.copyOfRange(postorder, 0, index );
            postorderRight = Arrays.copyOfRange(postorder, index , postorder.length-1);
            inorderLeft = Arrays.copyOfRange(inorder, 0, index);
            inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        }
        if (root==null){
            root=new TreeNode(postorder[postorder.length-1]);
            if (postorderLeft!=null&&postorderLeft.length!=0){
                inPostBuildTree(inorderLeft,postorderLeft,root,true);
            }
            if (postorderRight!=null&&postorderRight.length!=0){
                inPostBuildTree(inorderRight,postorderRight,root,false);
            }
        }else if (flag){
            root.left=new TreeNode(postorder[postorder.length-1]);
            if (postorderLeft!=null&&postorderLeft.length!=0){
                inPostBuildTree(inorderLeft,postorderLeft,root.left,true);
            }
            if (postorderRight!=null&&postorderRight.length!=0){
                inPostBuildTree(inorderRight,postorderRight,root.left,false);
            }
        }else {
            root.right=new TreeNode(postorder[postorder.length-1]);
            if (postorderLeft!=null&&postorderLeft.length!=0){
                inPostBuildTree(inorderLeft,postorderLeft,root.right,true);
            }
            if (postorderRight!=null&&postorderRight.length!=0){
                inPostBuildTree(inorderRight,postorderRight,root.right,false);
            }
        }
        return root;
    }

    //107. 二叉树的层序遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        Collections.reverse(lists);
        return lists;
    }

    //108. 将有序数组转换为二叉搜索树
    static public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    static public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    //109. 有序链表转换二叉搜索树
    static public TreeNode sortedListToBST(ListNode head) {
        int length=0;
        for (ListNode node=head;node!=null;node=node.next){
            length++;
        }
        return sortedListToBST(head,0,length-1);
    }

    //110. 平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else {
                return false;
            }
        }
    }

    //链表转数组
    static public int[] sortedListToSortedArray(ListNode head,int length){
        length++;
        int[] ints;
        if (head==null){
            return new int[0];
        }else if (head.next==null){
            ints = new int[length];
        }else {
            ints = sortedListToSortedArray(head.next, length);
        }
        ints[length-1]=head.val;
        return ints;
    }
    static private TreeNode sortedListToBST(ListNode head,int left,int right) {
        if (left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(getValue(mid,head));
        root.left = sortedListToBST(head, left, mid - 1);
        root.right = sortedListToBST(head, mid + 1, right);
        return root;
    }
    static private int getValue(int pos,ListNode head){
        ListNode target=head;
        for (int i = 0; i < pos; i++) {
            target=target.next;
        }
        return target.val;
    }

    //111. 二叉树的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    //112. 路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return targetSum == root.val;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }

    //113. 路径总和 II
    static public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> paths = new ArrayList<>();
        pathSum(root,targetSum,0,paths,new ArrayList<Integer>());
        return paths;
    }
    static public void pathSum(TreeNode root, int targetSum, int nowSum, List<List<Integer>> paths, List<Integer> path) {
        if (root!=null){
            ArrayList<Integer> temp = new ArrayList<>(path);
            temp.add(root.val);
            if (root.left!=null&&root.right!=null){
                pathSum(root.left, targetSum, nowSum+root.val,paths,temp);
                pathSum(root.right, targetSum, nowSum+root.val,paths,temp);
            }else if (root.left!=null){
                pathSum(root.left, targetSum, nowSum+root.val,paths,temp);
            }else if (root.right!=null){
                pathSum(root.right, targetSum, nowSum+root.val,paths,temp);
            }else {
                if (root.val+nowSum==targetSum){
                    paths.add(temp);
                }
            }
        }
    }

    //114. 二叉树展开为链表
    static TreeNode linkedRoot;
    static public void flatten(TreeNode root) {
        if (root!=null){
            TreeNode left=root.left;
            TreeNode right=root.right;
            if (linkedRoot==null){
                linkedRoot=root;
                linkedRoot.left=null;
            }else {
                linkedRoot.right=root;
                linkedRoot.left=null;
                linkedRoot=linkedRoot.right;
            }
            flatten(left);
            flatten(right);
        }
    }

    //116. 填充每个节点的下一个右侧节点指针
    public Node connect(Node root) {
        Queue<Node> queueA = new LinkedList<>();
        Queue<Node> queueB = new LinkedList<>();
        if (root == null) {
            return null;
        } else {
            queueA.offer(root);
        }
        for (; !queueA.isEmpty() || !queueB.isEmpty(); ) {
            for (; !queueA.isEmpty(); ) {
                Node node = queueA.poll();
                if (node.left != null) {
                    queueB.add(node.left);
                }
                if (node.right != null) {
                    queueB.add(node.right);
                }
                if (queueA.peek()!=null){
                    node.next=queueA.peek();
                }
            }
            for (; !queueB.isEmpty(); ) {
                Node node = queueB.poll();

                if (node.left != null) {
                    queueA.offer(node.left);
                }
                if (node.right != null) {
                    queueA.offer(node.right);
                }
                if (queueB.peek()!=null){
                    node.next=queueB.peek();
                }
            }
        }
        return root;
    }

    //124. 二叉树中的最大路径和
    static Integer maxPathSum;
    static Integer maxLeftPathSum;
    static Integer maxRightPathSum;
    static public int maxPathSum(TreeNode root) {
        if (root!=null){
            pathSum(root,0,0);
            if (maxLeftPathSum!=null&&maxRightPathSum==null){
                maxPathSum=maxPathSum==null?maxLeftPathSum:maxPathSum>maxLeftPathSum?maxPathSum:maxLeftPathSum;
            }else if (maxLeftPathSum==null&&maxRightPathSum!=null){
                maxPathSum=maxPathSum==null?maxRightPathSum:maxPathSum>maxRightPathSum?maxPathSum:maxRightPathSum;
            }else {
                OptionalInt max = IntStream.of(maxRightPathSum, maxLeftPathSum, maxRightPathSum + maxLeftPathSum - root.val).max();
                maxPathSum=maxPathSum==null?max.getAsInt():maxPathSum>max.getAsInt()?maxPathSum:max.getAsInt();
            }
            maxLeftPathSum=null;
            maxRightPathSum=null;
            maxPathSum(root.left);
            maxPathSum(root.right);
        }
        return maxPathSum;
    }
    static public void pathSum(TreeNode root,int pathSum,int flag){
        if (flag==1){
            maxLeftPathSum=maxLeftPathSum==null?pathSum+root.val:maxLeftPathSum>pathSum+root.val?maxLeftPathSum:pathSum+root.val;
        }else {
            maxRightPathSum=maxRightPathSum==null?pathSum+root.val:maxRightPathSum>pathSum+root.val?maxRightPathSum:pathSum+root.val;
        }
        if (root.left==null&&root.right==null){
        } else if (root.left!=null&&root.right!=null){
            if (flag==0){
                pathSum(root.left,pathSum+root.val,1);
                pathSum(root.right,pathSum+root.val,2);
            }else {
                pathSum(root.left,pathSum+root.val,flag);
                pathSum(root.right,pathSum+root.val,flag);
            }
        }else if (root.left!=null){
            if (flag==0){
                pathSum(root.left,pathSum+root.val,1);
            }else {
                pathSum(root.left,pathSum+root.val,flag);
            }
        }else{
            if (flag==0){
                pathSum(root.right,pathSum+root.val,2);
            }else {
                pathSum(root.right,pathSum+root.val,flag);
            }
        }
    }

    //129. 求根节点到叶节点数字之和
    static List<String> numbers=new ArrayList<>();
    static public int sumNumbers(TreeNode root) {
        sumNumbers(root,new StringBuilder());
        int sum= numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return sum;
    }
    static public void sumNumbers(TreeNode root,StringBuilder number) {
        if (root!=null){
            number.append(root.val);
            if (root.left!=null&&root.right!=null){
                sumNumbers(root.left,new StringBuilder(number));
                sumNumbers(root.right,new StringBuilder(number));
            }else if (root.left!=null){
                sumNumbers(root.left,new StringBuilder(number));
            }else {
                sumNumbers(root.right,new StringBuilder(number));
            }
        }else {
            numbers.add(number.toString());
        }
    }

    //144. 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorderList = new ArrayList<>();
        preorderTraversal(root, preorderList);
        return preorderList;
    }
    public void preorderTraversal(TreeNode root, List<Integer> preorderList) {
        if (root != null) {
            preorderList.add(root.val);
            preorderTraversal(root.left, preorderList);
            preorderTraversal(root.right, preorderList);
        }
    }

    //145. 二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorderList = new ArrayList<>();
        postorderTraversal(root, postorderList);
        return postorderList;
    }
    public void postorderTraversal(TreeNode root, List<Integer> postorderList) {
        if (root != null) {
            postorderTraversal(root.left, postorderList);
            postorderTraversal(root.right, postorderList);
            postorderList.add(root.val);
        }
    }

    //199. 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if (root == null) {
            return list;
        } else {
            queueA.offer(root);
        }
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            while (!queueA.isEmpty()) {
                TreeNode node = queueA.poll();
                if (queueA.isEmpty()) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queueB.add(node.left);
                }
                if (node.right != null) {
                    queueB.add(node.right);
                }
            }
            while (!queueB.isEmpty()) {
                TreeNode node = queueB.poll();
                if (queueB.isEmpty()) {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queueA.offer(node.left);
                }
                if (node.right != null) {
                    queueA.offer(node.right);
                }
            }
        }
        return list;
    }

    //222. 完全二叉树的节点个数
    static public int countNodes(TreeNode root) {
        int depth=0;
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            queueA.offer(root);
        }
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            while (!queueA.isEmpty()) {
                TreeNode node = queueA.poll();
                if (node.left != null) {
                    queueB.add(node.left);
                }
                if (node.right != null) {
                    queueB.add(node.right);
                }
                if (queueA.isEmpty()){
                    depth++;
                }
                if (queueB.isEmpty()){
                    return ((int) (Math.pow(2, depth + 1) - (Math.pow(2, depth) - queueA.size())));
                }
            }
            while (!queueB.isEmpty()) {
                TreeNode node = queueB.poll();
                if (node.left != null) {
                    queueA.offer(node.left);
                }
                if (node.right != null) {
                    queueA.offer(node.right);
                }
                if (queueB.isEmpty()){
                    depth++;
                }
                if (queueA.isEmpty()){
                    return ((int) (Math.pow(2, depth + 1) - (Math.pow(2, depth) - queueB.size())));
                }
            }
        }
        return -1;
    }

    //226. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        } else {
            TreeNode temp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(temp);
        }
        return root;
    }

    //230. 二叉搜索树中第K小的元素
    static public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root,inorderList);
        System.out.println(inorderList);
        return inorderList.get(k-1);
    }

    //235. 二叉搜索树的最近公共祖先
    public TreeNode SearchLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root.val <= p.val && root.val >= q.val || (root.val >= p.val && root.val <= q.val)) {
            return root;
        } else if (root.val > p.val) {
            return SearchLowestCommonAncestor(root.left, p, q);
        } else {
            return SearchLowestCommonAncestor(root.right, p, q);
        }
    }

    //236. 二叉树的最近公共祖先
    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<String, Integer> pLevelAndSide = findLevelAndSide(root, p, -1, 1);
        Map<String, Integer> qLevelAndSide = findLevelAndSide(root, q, -1, 1);
        if (pLevelAndSide.get("side")!=qLevelAndSide.get("side")){
            return root;
        }else {
            if (pLevelAndSide.get("level")==qLevelAndSide.get("level")){
                return findAncestor(root,p);
            }else {
                if (pLevelAndSide.get("level")>qLevelAndSide.get("level")){
                    TreeNode ancestor = findAncestor(q, p);
                    if (ancestor==null){
                        return findAncestor(root,q);
                    }else {
                        return q;
                    }
                }else {
                    TreeNode ancestor = findAncestor(p, q);
                    if (ancestor==null){
                        return findAncestor(root,p);
                    }else {
                        return p;
                    }
                }
            }
        }
    }
    static public Map<String,Integer> findLevelAndSide(TreeNode root,TreeNode target,int side,int level){
        if (root.val== target.val){
            HashMap<String, Integer> map = new HashMap<>();
            map.put("level",level);
            map.put("side",side);
            return map;
        }else {
            if (side==-1){
                if (root.left!=null&&root.right!=null){
                    Map<String, Integer> leftLevelAndSide = findLevelAndSide(root.left, target, 0, level + 1);
                    Map<String, Integer> rightLevelAndSide = findLevelAndSide(root.right, target, 1, level + 1);
                    return leftLevelAndSide==null?rightLevelAndSide:leftLevelAndSide;
                }else if (root.left!=null){
                    return findLevelAndSide(root.left,target,0,level+1);
                }else if (root.right!=null){
                    return findLevelAndSide(root.right,target,1,level+1);
                }
            }else {
                if (root.left!=null&&root.right!=null){
                    Map<String, Integer> leftLevelAndSide = findLevelAndSide(root.left, target, side, level + 1);
                    Map<String, Integer> rightLevelAndSide = findLevelAndSide(root.right, target, side, level + 1);
                    return leftLevelAndSide==null?rightLevelAndSide:leftLevelAndSide;
                }else if (root.left!=null){
                    return findLevelAndSide(root.left,target,side,level+1);
                }else if (root.right!=null){
                    return findLevelAndSide(root.right,target,side,level+1);
                }
            }
        }
        return null;
    }
    static public TreeNode findAncestor(TreeNode root,TreeNode sideNode){
        if ((root.left!=null&&root.left.val==sideNode.val)||(root.right!=null&&root.right.val==sideNode.val)){
            return root;
        }else {
            if (root.left!=null&&root.right!=null){
                TreeNode leftAncestor = findAncestor(root.left, sideNode);
                TreeNode rightAncestor = findAncestor(root.right, sideNode);
                return leftAncestor==null?rightAncestor:leftAncestor;
            }else if (root.left!=null){
                return findAncestor(root.left,sideNode);
            }else if (root.right!=null){
                return findAncestor(root.right,sideNode);
            }
        }
        return null;
    }

    //257. 二叉树的所有路径
    static public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        binaryTreePaths(root, paths, new StringBuilder());
        return paths;
    }
    static public void binaryTreePaths(TreeNode root, List<String> paths, StringBuilder path) {
        if (root == null) {
            if (path.length() != 0) {
                path.delete(path.lastIndexOf("->"), path.length());
                paths.add(path.toString());
            }
        } else if (root.left == null && root.right == null) {
            path.append(root.val);
            paths.add(path.toString());
            path.delete(path.lastIndexOf(root.val + ""), path.length());
        } else if (root.left == null) {
            path.append(root.val).append("->");
            binaryTreePaths(root.right, paths, path);
            path.delete(path.lastIndexOf(root.val + ""), path.length());
        } else if (root.right == null) {
            path.append(root.val).append("->");
            binaryTreePaths(root.left, paths, path);
            path.delete(path.lastIndexOf(root.val + ""), path.length());
        } else {
            path.append(root.val).append("->");
            binaryTreePaths(root.right, paths, path);
            binaryTreePaths(root.left, paths, path);
            path.delete(path.lastIndexOf(root.val + ""), path.length());
        }
    }

    //404. 左叶子之和
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
                } else {
                    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
                }
            } else {
                return sumOfLeftLeaves(root.right);
            }
        }
        return 0;
    }

    //501. 二叉搜索树中的众数
    //todo
    static public int[] findMode(TreeNode root) {
        return null;
    }

    //530. 二叉搜索树的最小绝对差
    static int minimum = -1;
    static public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root, -1);
            getMinimumDifference(root.left);
            getMinimumDifference(root.right);
        }
        return minimum;
    }
    static public void getMinimumDifference(TreeNode root, int val) {
        if (root != null) {
            if (val == -1) {
                if (root.left != null) {
                    getMinimumDifference(root.left, root.val);
                }
                if (root.right != null) {
                    getMinimumDifference(root.right, root.val);
                }
            } else {
                if (minimum == -1) {
                    minimum = Math.abs(val - root.val);
                } else if (Math.abs(val - root.val) < minimum) {
                    minimum = Math.abs(val - root.val);
                }
                if (root.left != null) {
                    getMinimumDifference(root.left, val);
                }
                if (root.right != null) {
                    getMinimumDifference(root.right, val);
                }
            }
        }
    }

    //543. 二叉树的直径
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return ans;
    }
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int L = diameter(root.left);
            int R = diameter(root.right);
            ans = Math.max(ans, L + R);
            return Math.max(L, R) + 1;
        }
    }

    //563. 二叉树的坡度
    public int findTilt(TreeNode root) {
        tilt(root);
        return ans;
    }
    public int tilt(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int L = tilt(root.left);
            int R = tilt(root.right);
            ans += Math.abs(L - R);
            return root.val + L + R;
        }
    }

    //572. 另一棵树的子树
    static TreeNode temp;
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subtree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
    public static boolean subtree(TreeNode root, TreeNode subRoot) {
        if (temp == null) {
            temp = subRoot;
        }
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else if (root.val == subRoot.val) {
            return subtree(root.left, subRoot.left) && subtree(root.right, subRoot.right);
        } else {
            if (subRoot == temp) {
                return subtree(root.left, temp) || subtree(root.right, temp);
            } else {
                return subtree(root, temp);
            }
        }
    }

    //606. 根据二叉树创建字符串
    public static String tree2str(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return root.val + "";
            } else if (root.left == null) {
                return root.val + "()" + "(" + tree2str(root.right) + ")";
            } else if (root.right == null) {
                return root.val + "(" + tree2str(root.left) + ")";
            } else {
                return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
            }
        } else {
            return "";
        }
    }

    //617. 合并二叉树
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            root1.val += root2.val;
            if (root1.left == null && root2.left != null) {
                root1.left = new TreeNode();
            }
            if (root1.right == null && root2.right != null) {
                root1.right = new TreeNode();
            }
            mergeTrees(root1.left, root2.left);
            mergeTrees(root1.right, root2.right);
            return root1;
        }
    }

    //637. 二叉树的层平均值
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> results = new ArrayList<>();
        queue.offer(root);
        for (; !queue.isEmpty(); ) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                sum += queue.poll().val;
            }
            results.add(sum / size);
        }
        return results;
    }

    //653. 两数之和 IV - 输入 BST
    static TreeNode node;
    static public boolean findTarget(TreeNode root, int k) {
        if (node == null) {
            node = root;
        }
        if (root != null) {
            int target = k - root.val;
            boolean b;
            if (target > root.val) {
                b = find(node, target);
            } else if (target < root.val) {
                b = find(node, target);
            } else {
                return findTarget(root.left, k) || findTarget(root.right, k);
            }
            if (b) {
                return true;
            } else {
                return findTarget(root.left, k) || findTarget(root.right, k);
            }
        } else {
            return false;
        }
    }
    static public boolean find(TreeNode root, int target) {
        if (root == null) {
            return false;
        } else {
            if (root.val > target) {
                return find(root.left, target);
            } else if (root.val < target) {
                return find(root.right, target);
            } else {
                return true;
            }
        }
    }

    //671. 二叉树中第二小的节点
    int result;
    public int findSecondMinimumValue(TreeNode root) {
        result = root.val;
        findSecondMinimumValue(root, root.val);
        if (result == root.val) {
            return -1;
        } else {
            return result;
        }
    }
    public void findSecondMinimumValue(TreeNode root, int val) {
        if (root.left != null) {
            findSecondMinimumValue(root.left, val);
            findSecondMinimumValue(root.right, val);
        } else {
            if (result == val) {
                if (root.val > val) {
                    result = root.val;
                }
            } else {
                if (root.val < result && root.val != val) {
                    result = root.val;
                }
            }
        }
    }

    //700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        } else {
            return null;
        }
    }

    //872. 叶子相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        leafSimilar(root1, result1);
        leafSimilar(root2, result2);
        if (result1.toString().equals(result2.toString())) {
            return true;
        } else {
            return false;
        }
    }
    public void leafSimilar(TreeNode root, StringBuilder stringBuilder) {
        if (root.left != null) {
            leafSimilar(root.left, stringBuilder);
        }
        if (root.right != null) {
            leafSimilar(root.right, stringBuilder);
        }
        if (root.left == null && root.right == null) {
            stringBuilder.append(root.val + " ");
        }
    }

    //897. 递增顺序搜索树
    TreeNode head;
    TreeNode tail;
    public TreeNode increasingBST(TreeNode root) {
        if (root != null) {
            increasingBST(root.left);
            if (head == null) {
                head = root;
                tail = head;
            } else {
                tail.right = root;
                root.left = null;
                tail = tail.right;
            }
            increasingBST(root.right);
        }
        return head;
    }

    //938. 二叉搜索树的范围和
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    //965. 单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            } else if (root.right != null && root.val != root.right.val) {
                return false;
            } else {
                return isUnivalTree(root.left) && isUnivalTree(root.right);
            }
        } else {
            return true;
        }
    }

    //993. 二叉树的堂兄弟节点
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        boolean left = false, right = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (; !queue.isEmpty(); ) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.poll();
                if (peek.left != null && peek.right != null && ((peek.left.val == x && peek.right.val == y) || (peek.left.val == y && peek.right.val == x))) {
                    return false;
                }
                if (peek.left != null) {
                    queue.offer(peek.left);
                    if (peek.left.val == x) {
                        left = true;
                    }
                    if (peek.left.val == y) {
                        right = true;
                    }
                }
                if (peek.right != null) {
                    queue.offer(peek.right);
                    if (peek.right.val == x) {
                        left = true;
                    }
                    if (peek.right.val == y) {
                        right = true;
                    }
                }
            }
            if (left != right) {
                return false;
            }
            if (left && right) {
                return true;
            }
        }
        return true;
    }

    //1022. 从根到叶的二进制数之和
    static int sum = 0;
    public static int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, new StringBuilder());
        return sum;
    }
    static void sumRootToLeaf(TreeNode root, StringBuilder result) {
        if (root.left == null && root.right == null) {
            result.append(root.val);
            sum += Integer.parseInt(result.toString(), 2);
            result.deleteCharAt(result.length() - 1);
        } else {
            result.append(root.val);
            if (root.left != null) {
                sumRootToLeaf(root.left, result);
            }
            if (root.right != null) {
                sumRootToLeaf(root.right, result);
            }
            result.deleteCharAt(result.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer>queue=new LinkedList<Integer>();
        Collections.addAll(queue,-1,0,3,-2,4,null,null,8);
        TreeNode root = TreeNode.levelOrderConstruct(queue);
        System.out.println(lowestCommonAncestor(root,new TreeNode(8),new TreeNode(4)));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //前序构造
    public static TreeNode preorderConstruct(Queue<Integer> queue) {
        if (queue.isEmpty() || queue.peek() == null) {
            queue.poll();
            return null;
        } else {
            TreeNode node = new TreeNode();
            node.val = queue.poll();
            node.left = preorderConstruct(queue);
            node.right = preorderConstruct(queue);
            return node;
        }
    }

    static public TreeNode levelOrderConstruct(Queue<Integer> queue) {
        Queue<TreeNode>nodes=new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(queue.poll());
        nodes.add(root);
        while (!queue.isEmpty()){
            TreeNode node = nodes.poll();
            if (node!=null){
                if (queue.peek()!=null){
                    node.left=new TreeNode(queue.poll());
                    nodes.add(node.left);
                }else {
                    queue.poll();
                    node.left=null;
                    nodes.add(null);
                }
                if (queue.peek()!=null){
                    node.right=new TreeNode(queue.poll());
                    nodes.add(node.right);
                }else {
                    queue.poll();
                    node.right=null;
                    nodes.add(null);
                }
            }
        }
        return root;
    }

    @Override
    public String toString() {
        List<List<Integer>> lists = BinaryTreeSolution.levelOrder(this);
        return lists.toString();
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
//173. 二叉搜索树迭代器
class BSTIterator {

    private Queue<Integer> inorderList=new LinkedList<>();

    public BSTIterator(TreeNode root) {
        inorderTraversal(root,inorderList);
    }

    public int next() {
        return inorderList.poll();
    }

    public boolean hasNext() {
        return !inorderList.isEmpty();
    }

    private void inorderTraversal(TreeNode root,Queue<Integer> inorderList){
        if (root!=null){
            inorderTraversal(root.left,inorderList);
            inorderList.offer(root.val);
            inorderTraversal(root.right,inorderList);
        }
    }
}
