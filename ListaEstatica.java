public class ListaEstatica {
    private int[] data;
    private int count = 0; // n elementos na lista

    public ListaEstatica(int size) {
        this.data = new int[size];
    }

    public void clear() {
        count = 0;
    }

    public void add(int element) {
        if (!isFull()) {
            data[count++] = element; // Add elemento no final da lista
        } else {
            System.out.println("Lista cheia!");
        }
    }

    public void add(int element, int pos) {
        if (!isFull() && pos >= 0 && pos <= count) {
            for (int i = count; i > pos; i--) {
                data[i] = data[i - 1]; // Desloca elementos para a direita
            }
            data[pos] = element;
            count++;
        } else {
            System.out.println("Posição inválida ou lista cheia!");
        }
    }

    public int remove(int pos) {
        if (!isEmpty() && pos >= 0 && pos < count) {
            int removedElement = data[pos];
            for (int i = pos; i < count - 1; i++) {
                data[i] = data[i + 1]; // Desloca elementos para a esquerda
            }
            count--;
            return removedElement;
        } else {
            System.out.println("Posição inválida ou lista vazia!");
            return -1;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == data.length;
    }

    public int getData(int pos) {
        if (pos >= 0 && pos < count) {
            return data[pos];
        } else {
            System.out.println("Posição inválida!");
            return -1;
        }
    }

    public int getSize() {
        return count;
    }

    public int find(int element) {
        for (int i = 0; i < count; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1; // Elemento não encontrado
    }

    public static void main(String[] args) {
        ListaEstatica list = new ListaEstatica(5);

        // Testando add de elementos
        list.add(10);
        list.add(20);
        list.add(30);

        // Testando add em uma posição específica
        list.add(15, 1);

        // Testando a remoção de elementos
        System.out.println("Removido: " + list.remove(2)); // Remove o elemento na posição 2

        // Testando os métodos
        System.out.println("Elemento na posição 1: " + list.getData(1));
        System.out.println("Tamanho atual da lista: " + list.getSize());
        System.out.println("Posição do elemento 20: " + list.find(20));

        // Limpando a lista
        list.clear();
        System.out.println("Lista limpa. Está vazia: " + list.isEmpty());
    }
}
