package main;

import tree.Tree;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        Tree<Integer> tree = new Tree<>();
        tree.add(5);
        tree.add(8);
        tree.add(2);
        tree.add(3);
        tree.add(9);
        tree.add(6);
        tree.add(11);
        tree.add(1);

        tree.traverse();
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(4));
    }
}
