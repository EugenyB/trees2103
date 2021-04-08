package tree;

/**
 * Created by eugen on 21.03.2017.
 */
public class Tree<T extends Comparable<T>> {
    Node<T> root;

    public boolean add(T value) {
        if(root == null) {
            root = new Node<T>(value);
            return true;
        }
        return addInSubTree(value, root);
    }

    private boolean addInSubTree(T value, Node<T> root) {
        if (value.equals(root.getKey())) {
            return false;
        }
        if (value.compareTo(root.getKey()) < 0) {
            if (root.getLeft()==null) {
                root.setLeft(new Node<T>(value));
                return true;
            } else {
                return addInSubTree(value, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(new Node<T>(value));
                return true;
            } else {
                return addInSubTree(value, root.getRight());
            }
        }
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node<T> root) {
        if (root != null) {
            traverse(root.getLeft());
            visit(root);
            traverse(root.getRight());
        }
    }

    private void visit(Node<T> node) {
        System.out.println(node.getKey());
    }

    private Node<T> find(T key) {
        if (root == null) {
            return null;
        }
        return findInSubTree(key, root);
    }

    private Node<T> findInSubTree(T key, Node<T> root) {
        if (root==null || key.equals(root.getKey())) {
            return root;
        }
        if (key.compareTo(root.getKey())<0) {
            return findInSubTree(key, root.getLeft());
        } else {
            return findInSubTree(key, root.getRight());
        }
    }

    public boolean contains(T key) {
        return find(key)!=null;
    }
}
