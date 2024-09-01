public class ListaDuplamenteEncadeada<T> {
    private Node<T> base;
    private Node<T> top;
    private int size;

    // Classe Node --> representa um NÓ na lista
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // Add elemento no final da lista
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            base = top = newNode;
        } else {
            top.next = newNode;
            newNode.prev = top;
            top = newNode;
        }
        size++;
    }

    // Add elemento em posição específica
    public void add(int pos, T value) {
        if (pos < 0 || pos > size) {
            System.out.println("Posição inválida!");
            return;
        }
        Node<T> newNode = new Node<>(value);
        if (pos == 0) { // Add no início
            if (isEmpty()) {
                base = top = newNode;
            } else {
                newNode.next = base;
                base.prev = newNode;
                base = newNode;
            }
        } else if (pos == size) { // Add no final
            add(value);
        } else { // Add no meio
            Node<T> current = getNode(pos);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    // Remove elemento em posição específica
    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posição inválida!");
            return null;
        }
        Node<T> toRemove = getNode(pos);
        return remove(toRemove);
    }

    // Remove nó específico
    public T remove(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node == base) {
            base = node.next;
            if (base != null) {
                base.prev = null;
            }
        } else if (node == top) {
            top = node.prev;
            if (top != null) {
                top.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.data;
    }

    // Obtém nó em posição específica
    public Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Posição inválida!");
            return null;
        }
        Node<T> current = base;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    // Obtém valor em posição específica
    public T get(int pos) {
        Node<T> node = getNode(pos);
        return node != null ? node.data : null;
    }

    // Define valor de elemento em posição específica
    public void set(int pos, T value) {
        Node<T> node = getNode(pos);
        if (node != null) {
            node.data = value;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // Encontra posição de valor específico
    public int find(T value) {
        Node<T> current = base;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(value)) {
                return i;
            }
            current = current.next;
        }
        return -1; // Valor não encontrado
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Integer> list = new ListaDuplamenteEncadeada<>();

        // Add elementos
        list.add(10);
        list.add(20);
        list.add(30);

        // Add elemento em posição específica
        list.add(1, 15);

        // Removendo elementos
        System.out.println("Removido: " + list.remove(2)); // Remove elemento na posição 2

        // Testando métodos
        System.out.println("Elemento na posição 1: " + list.get(1));
        System.out.println("Tamanho atual da lista: " + list.getSize());
        System.out.println("Posição do elemento 20: " + list.find(20));

        // Removendo pelo nó
        Node<Integer> node = list.getNode(0);
        System.out.println("Removido pelo nó: " + list.remove(node));
    }
}
