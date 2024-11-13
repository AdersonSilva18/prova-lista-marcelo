class ListaLigada {
    private Node node;

    // Método para inserir elemento na lista
    public void inserir(int valor) {
        Node novoNode = new Node(valor);
        if (node == null) {
            node = novoNode;
        } else {
            Node atual = node;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNode;
        }
    }

    // Método para remover elemento da lista
    public boolean remover(Integer valor) {
        if (node == null){
            return false;
        } 

        if (node.valor == valor) {
            node = node.proximo;
            return true;
        }

        Node atual = node;
        while (atual.proximo != null && atual.proximo.valor != valor) {
            atual = atual.proximo;
        }

        if (atual.proximo == null) return false;

        atual.proximo = atual.proximo.proximo;
        return true;
    }

    // Método para exibir a lista
    public void exibir() {
        Node atual = node;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    // Método para converter lista ligada em array (necessário para busca e ordenação)
    public int[] toArray() {
        int tamanho = tamanho();
        int[] array = new int[tamanho];
        Node atual = node;
        for (int i = 0; i < tamanho; i++) {
            array[i] = atual.valor;
            atual = atual.proximo;
        }
        return array;
    }

    // Método para atualizar lista a partir de um array ordenado
    public void fromArray(int[] array) {
        node = null;
        for (int valor : array) {
            inserir(valor);
        }
    }

    // Método para obter o tamanho da lista
    public int tamanho() {
        int contador = 0;
        Node atual = node;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }
}