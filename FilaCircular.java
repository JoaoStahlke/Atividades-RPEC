public class FilaCircular<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;
    private int size;
    private int count = 0; // controla o número de elementos na fila
    
    public FilaCircular(int size) {
        this.size = size;
        this.data = (T[]) new Object[size];
    }

    public void add(T element) {
        if (isFull()) {
            System.out.println("Fila cheia!");
            return;
        }
        top = move(top);
        data[top] = element;
        count++; // Incrementa o número de elementos
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return null;
        }
        T removedElement = data[base];
        data[base] = null;
        base = move(base);
        count--; // Decrementa o número de elementos
        return removedElement;
    }

    public void clear() {
        top = -1;
        base = 0;
        count = 0;
        data = (T[]) new Object[size];
    }

    public boolean isFull() {
        return count == size; // A fila está cheia quando o número de elementos atinge o tamanho máximo
    }

    public boolean isEmpty() {
        return count == 0; // A fila está vazia quando não há elementos
    }

    private int move(int position) {
        return (position + 1) % size;
    }

    public static void main(String[] args) {
        FilaCircular<Integer> queue = new FilaCircular<>(5);

        // Testando o add e remove
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Removido: " + queue.remove());
        System.out.println("Removido: " + queue.remove());

        // Adicionando mais elementos
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);

        // Verificando se está cheia
        System.out.println("Fila cheia: " + queue.isFull());

        // Limpeza da fila
        queue.clear();
        System.out.println("Agora a Fila foi limpa. --> Está vazia: " + queue.isEmpty());
    }
}
