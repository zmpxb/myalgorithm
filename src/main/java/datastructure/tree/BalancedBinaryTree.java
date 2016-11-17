package datastructure.tree;

/**
 * Created by xiaozl on 2016/9/26.
 */
public class BalancedBinaryTree {

    /**
     * 右旋
     * 向右旋转之后，p移到p的右子节点处，p的左子树B变为最小旋转子树的根节点
     * B的右子节点变为p的左节点、
     * 例如:       A(2)                     B(-1)
     *            /         右旋转          /    \
     *          B(0)       ------>         /     A(0)
     *         /   \                      /      /
     *       BL(0) BR(0)                BL(0)  BR(0)
     * @param root
     * @param p
     * @return
     */
    public static TreeNode rotateRight(TreeNode root,TreeNode p){
        System.out.println("绕 " + p.getValue() + " 右旋转");
        if (p!=null){
            TreeNode l = p.getLeft();
            p.setLeft(l.getRight());
            if (l.getRight() != null){
                l.getRight().setParent(p);
            }
            l.setParent(p.getParent());
            if (p.getParent() == null){
                root = l;
            } else if (p.getParent().getRight() == p){
                p.getParent().setRight(l);
            } else {
                p.getParent().setLeft(l);
            }
            l.setRight(p);
            p.setParent(l);
        }
        return root;
    }

    /**
     * 向左旋转之后p移到p的左子树处，p的右子树B变为此最小子树根节点，
     * B的左子树变为p的右子树
     * 比如：     A(-2)                   B(1)
     *              \        左旋转       /   \
     *             B(0)     ---->       A(0)   \
     *             /   \                   \    \
     *           BL(0)  BR(0)              BL(0) BR(0)
     *  旋转之后树的深度之差不超过1
     * @param root
     * @param p
     * @return
     */
    public static TreeNode rotateLeft(TreeNode root,TreeNode p){
        if (root != null){
            TreeNode r = p.getRight();
            p.setRight(r.getLeft());
            r.setParent(p.getParent());
            if (r.getLeft() != null){
                r.getLeft().setParent(p);
            }
            if (p.getParent() == null){
                root = r;
            } else if (p.getParent().getRight() == p){
                p.getParent().setRight(r);
            } else {
                p.getParent().setLeft(r);
            }
            r.setLeft(p);
            p.setParent(r);
        }
        return root;
    }

    /**
     * 平衡二叉树插入一个节点，返回根
     * @param root
     * @param key
     * @return
     */
    public static TreeNode add(TreeNode root,Integer key){
        if (root == null){
            TreeNode insertNode = new TreeNode();
            insertNode.setValue(key);
            insertNode.setParent(null);
            return insertNode;
        }
        TreeNode parent = null;
        TreeNode now = root;
        // 找到插入位置,和其父节点
        do {
            parent = now;
            if (now.getValue() == key){
                return root;
            } else if (key < now.getValue()){
                now = now.getLeft();
            } else {
                now = now.getRight();
            }
        } while (now != null);
        TreeNode insertNode = new TreeNode();
        insertNode.setValue(key);
        insertNode.setParent(parent);
        if (key < parent.getValue()){
            parent.setLeft(insertNode);
        } else {
            parent.setRight(insertNode);
        }
        // 调整节点的平衡因子和树的结构,下面的循环结构是为了找到最小失衡点
        while(parent != null){
            if (key < parent.getValue()){
                parent.setBalance(parent.getBalance()+1);
            } else {
                parent.setBalance(parent.getBalance()-1);
            }
            if (parent.getBalance() == 0){
                break;
                //return root;
            }
            if (Math.abs(parent.getBalance()) == 2){
                 // fixAfterInsertion(parent);
                break;
            }
            parent = parent.getParent();
        }
return  null;
    }

    private void fixAfterInsertion(TreeNode p){
        if(p.getBalance() == 2){
            leftBalance(p);
        }
        if(p.getBalance() == -2){
            //rightBalance(p);
        }
    }

    /**
     * 做左平衡处理
     * 平衡因子的调整如图：
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /  \    /  \
     *  ll    rd                ll   rdl rdr  tr
     *       /   \
     *     rdl  rdr
     *
     *   情况2(rd的BF为0)
     *
     *
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /  \       \
     *  ll    rd                ll   rdl     tr
     *       /
     *     rdl
     *
     *   情况1(rd的BF为1)
     *
     *
     *         t                       rd
     *       /   \                   /    \
     *      l    tr   左旋后右旋    l       t
     *    /   \       ------->    /       /  \
     *  ll    rd                ll       rdr  tr
     *           \
     *          rdr
     *
     *   情况3(rd的BF为-1)
     *
     *
     *         t                         l
     *       /       右旋处理          /    \
     *      l        ------>          ll     t
     *    /   \                             /
     *   ll   rd                           rd
     *   情况4(L等高)
     */
    private boolean leftBalance(TreeNode t){
        boolean heightLower = true;
        TreeNode l = t.getLeft();
        switch (l.getBalance()) {
            case 1:			//左高，右旋调整,旋转后树的高度减小，这种情况是LL型
                t.setBalance(0);
                l.setBalance(0);
              //  rotateRight(root,t);
                break;
            case -1:	        //右高，分情况调整LR型
                TreeNode rd = l.getRight();
                switch (rd.getBalance()) {	//调整各个节点的BF
                    case 1:	//情况1
                        t.setBalance(-1);
                        l.setBalance(0);
                        break;
                    case 0:	//情况2 应该删除的时候出现
                        t.setBalance(0);
                        l.setBalance(0);
                        break;
                    case -1:	//情况3
                        t.setBalance(0);
                        l.setBalance(1);
                        break;
                }
                rd.setBalance(0);
             //   rotateLeft(root,t.getLeft());
              //  rotateRight(root,t);
                break;
            case 0:	  //特殊情况4,这种情况在添加时不可能出现，只在移除时可能出现，旋转之后整体树高不变
                l.setBalance(-1);
                t.setBalance(1);

              //  rotateRight(t);
                heightLower = false;
                break;
        }
        return heightLower;
    }
}
