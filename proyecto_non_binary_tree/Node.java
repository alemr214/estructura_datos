package proyecto_non_binary_tree;

import java.util.ArrayList;
import java.util.List;

// <T> Tipo de dato generico
public class Node<T> {
    private T data;
    private List<Node<T>> children;
    private Node<T> parent;

    // Constructor
    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<Node<T>>();
    }

    // Sobre carga de constructor para inicializar con tipo de dato ya definido
    public Node(Node<T> node) {
        this.data = node.getData();
        children = new ArrayList<Node<T>>();
    }

    // Metodo para agregar un nodo hijo
    public void addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
    }

    // Metodo para agregar un nodo hijo a un hijo en cierto indice
    public void addChildAt(int index, Node<T> child) {
        child.setParent(this);
        this.children.add(index, child);
    }

    // Metodo par aasignar nodos hijos
    public void setChildren(List<Node<T>> children) {
        for (Node<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    // Metodo para remover todos los nodos hijos
    public void removeChildren() {
        this.children.clear();
    }

    // Metodo para remover un nodo hijo en especifico
    public Node<T> removeChildAt(int index) {
        return children.remove(index);
    }

    // Metodo para identificar el nodo a eliminar
    public boolean removeChild(Node<T> childToBeDeleted) {
        List<Node<T>> list = getChildren();
        return list.remove(childToBeDeleted);
    }

    // Metodos set y getter
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return this.children;
    }

    public Node<T> getChildAt(int index) {
        return children.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof Node) {
            if (((Node<?>) obj).getData().equals(this.data))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
