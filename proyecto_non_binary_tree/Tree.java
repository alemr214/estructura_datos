package proyecto_non_binary_tree;

import java.util.ArrayList;

public class Tree<T> {

    // Raiz del nodo
    private Node<T> root;

    // Metodo constructor
    public Tree(Node<T> root) {
        this.root = root;
    }

    // Verifica que no este vacia
    public boolean isEmpty() {
        return root == null;
    }

    // Metodo que regresa la raiz
    public Node<T> getRoot() {
        return root;
    }

    // Metodo que asigna la raiz
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    // Metodo que verfica que si el dato esta dentro del arbol
    public boolean exists(T key) {
        return find(root, key);
    }

    // Metodo que egresa el numero de nodos que hay en el arbol
    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    // Metodo que cuenta el numero de nodos
    public int getNumberOfDescendants(Node<T> node) {
        int n = node.getChildren().size();
        for (Node<T> child : node.getChildren())
            n += getNumberOfDescendants(child);

        return n;

    }

    // Metodo que busca un dato
    private boolean find(Node<T> node, T keyNode) {
        boolean res = false;
        if (node.getData().equals(keyNode))
            return true;

        else {
            for (Node<T> child : node.getChildren())
                if (find(child, keyNode))
                    res = true;
        }

        return res;
    }

    // Metoodo que obtiene el preorden
    public ArrayList<Node<T>> getPreOrderTraversal() {
        ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
        buildPreOrder(root, preOrder);
        return preOrder;
    }

    // Metodo que obtiene el postorden
    public ArrayList<Node<T>> getPostOrderTraversal() {
        ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
        buildPostOrder(root, postOrder);
        return postOrder;
    }

    // Metodo construye el preorden
    private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
        preOrder.add(node);
        for (Node<T> child : node.getChildren()) {
            buildPreOrder(child, preOrder);
        }
    }

    // Metodo que construye el postorden
    private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
        for (Node<T> child : node.getChildren()) {
            buildPostOrder(child, postOrder);
        }
        postOrder.add(node);
    }

    /**
     * <pre>
     *          A
     *         / \
     *        B   C
     *           / \
     *          D  E
     *              \
     *              F
     * </pre>
     * 
     * The result would be [A, C, E, F]
     */

    // Metodo que obtiene la ruta mas larga en el arbol
    public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
        ArrayList<Node<T>> longestPath = null;
        int max = 0;
        for (ArrayList<Node<T>> path : getPathsFromRootToAnyLeaf()) {
            if (path.size() > max) {
                max = path.size();
                longestPath = path;
            }
        }
        return longestPath;
    }

    // Metood para obtener la altura del arbol
    public int getHeight() {
        return getLongestPathFromRootToAnyLeaf().size();
    }

    // Metodo para obtener todos las rutas
    public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
        ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
        ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
        getPath(root, currentPath, paths);
        return paths;
    }

    // Metodo apra obtener la ruta
    private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
            ArrayList<ArrayList<Node<T>>> paths) {
        if (currentPath == null)
            return;

        currentPath.add(node);

        if (node.getChildren().size() == 0) {
            // This is a leaf
            paths.add(clone(currentPath));
        }
        for (Node<T> child : node.getChildren())
            getPath(child, currentPath, paths);

        int index = currentPath.indexOf(node);
        for (int i = index; i < currentPath.size(); i++)
            currentPath.remove(index);
    }

    // Metodo para clonar el arbol
    private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
        ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
        for (Node<T> node : list)
            newList.add(new Node<T>(node));

        return newList;
    }
}