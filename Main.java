import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecioneUmaOpcao:");
            System.out.println("1 - InserirElemento");
            System.out.println("2 - RemoverElemento");
            System.out.println("3 - ExibirLista");
            System.out.println("4 - OrdenarBubbleSort");
            System.out.println("5 - OrdenarSelectionSort");
            System.out.println("6 - BuscaBinaria");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite O Valor Para Inserir: ");
                    int valor = scanner.nextInt();
                    lista.inserir(valor);
                }
                case 2 -> {
                    System.out.print("Digite o valor para removar: ");
                    int valor = scanner.nextInt();
                    if (lista.remover(valor)) {
                        System.out.println("elemento removido.");
                    } else {
                        System.out.println("elemento nao encontrado.");
                    }
                }
                case 3 -> {
                    System.out.println("lista");
                    lista.exibir();
                }
                case 4 -> {
                    System.out.println("BubbleSort");
                    int[] array = lista.toArray();
                    bubbleSort(array);
                    lista.fromArray(array);
                    System.out.println("lista ordenada:");
                    lista.exibir();
                }
                case 5 -> {
                    System.out.println("selectionSort");
                    int[] array = lista.toArray();
                    selectionSort(array);
                    lista.fromArray(array);
                    System.out.println("lista ordenada");
                    lista.exibir();
                }
                case 6 -> {
                    System.out.print("Digite o valor: ");
                    int valor = scanner.nextInt();
                    int[] array = lista.toArray();
                    bubbleSort(array); // Ordenação antes da busca
                    int posicao = buscaBinaria(array, valor);
                    if (posicao != -1) {
                        System.out.println("eelemento na posicao " + posicao);
                    } else {
                        System.out.println("nao encontrado");
                    }
                }
                case 0 -> {
                    System.out.println("vlw flw.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("valor invalido");
            }
        }
    }

    // Metodo de ordenação Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Metodo de ordenação Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Metodo de busca binária
    public static int buscaBinaria(int[] array, int valor) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            if (array[meio] == valor) {
                return meio;
            } else if (array[meio] < valor) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}