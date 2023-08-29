import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        int opcao = -1; 
        while (opcao != 0) {
            System.out.println("\n Menu:");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Listar Veículos Cadastrados");
            System.out.println("3 - Remover Veículo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); 

            if (opcao == 1) {
                cadastrarVeiculo(veiculos, scanner);
            } else if (opcao == 2) {
                listarVeiculos(veiculos);
            } else if (opcao == 3) {
                removerVeiculo(veiculos, scanner);
            } else if (opcao == 0) {
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
    // Função para cadastrar um veículo
    public static void cadastrarVeiculo(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Informe a marca do veículo:");
        String marca = scanner.next();
        System.out.println("Informe o modelo do veículo:");
        String modelo = scanner.next();
        System.out.println("Informe o ano do veículo:");
        int ano = scanner.nextInt();
        
        // Cria um novo veículo com as informações fornecidas e o adiciona à lista
        veiculos.add(new Veiculo(marca, modelo, ano));
        System.out.println("Veículo cadastrado com sucesso!");
    }

    // Função para listar os veículos cadastrados
    public static void listarVeiculos(List<Veiculo> veiculos) {
        int anoAtual = 2023;
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            int idade = anoAtual - veiculo.getAno();
            String ipva = idade > 5 ? "Não paga" : "Paga";
            // Exibe as informações do veículo, incluindo índice, marca, modelo, idade e status do IPVA
            System.out.println("Índice: " + i + " | Marca: " + veiculo.getMarca() + " | Modelo: " + veiculo.getModelo() +
                               " | Idade: " + idade + " anos | IPVA: " + ipva);
        }
    }

    // Função para remover um veículo
    public static void removerVeiculo(List<Veiculo> veiculos, Scanner scanner) {
        System.out.println("Informe o índice do veículo que deseja remover:");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < veiculos.size()) {
            // Remove o veículo da lista com base no índice fornecido pelo usuário
            Veiculo removido = veiculos.remove(indice);
            System.out.println("Veículo removido: " + removido.getMarca() + " " + removido.getModelo());
        } else {
            // Mensagem para índice inválido
            System.out.println("Índice inválido.");
        }
    }
}

// Classe que define a estrutura de um veículo
class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    // Construtor da classe
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Métodos para acessar os atributos do veículo
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}
