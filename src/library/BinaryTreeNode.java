package library;

public class BinaryTreeNode {
    private Nodal value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    private BinaryTreeNode parent;
    private boolean root = false;



    public BinaryTreeNode(Nodal value) {
        this.value = value;
    }

    public boolean isRoot() {
        return root;
    }

    public void setValue(Nodal value) {
        this.value = value;
    }

    public void root() {
        root = true;
    }

    public void noRoot() {
        root = false;
    }

    public Nodal getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void insertLeft(BinaryTreeNode node) {
        left = node;
        if (left != null) {
            left.parent = this;
        }

    }

    public void insertRight(BinaryTreeNode node) {
        right = node;
        if (right != null) {
            right.parent = this;
        }
    }

    public BinaryTreeNode getSibling() {
        if (this.getParent().getLeft() == this) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    public void replaceChild(BinaryTreeNode oldNode, BinaryTreeNode newNode) {
        if (this.getLeft() == oldNode) {
            insertLeft(newNode);
        } else {
            insertRight(newNode);
        }
    }

    public void disable() {
        parent.replaceChild(this,null);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public void smartDisable() {
        BinaryTreeNode parent = this.getParent();
        if (parent.hasParent()) {
            parent.getParent().replaceChild(parent,this.getSibling());
        } else {
            BinaryTreeNode sibling = this.getSibling();
            parent.setValue(sibling.getValue());
            parent.insertLeft(sibling.getLeft());
            parent.insertRight(sibling.getRight());
        }
    }

    public boolean hasLeft() {
        return getLeft() != null;
    }

    public boolean hasRight() {
        return getRight() != null;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
