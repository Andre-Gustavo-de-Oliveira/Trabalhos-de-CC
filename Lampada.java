import java.util.Scanner;

public class Lampada {

    private String marca;
    private String modelo;
    private String cor;
    private int watts;
    private String tipo;
    private double preco;
    private int garantia;
    private boolean ligada;

    public Lampada(String marca, String modelo, String cor, int watts, String tipo, double preco, int garantia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.watts = watts;
        this.tipo = tipo;
        this.preco = preco;
        this.garantia = garantia;
        this.ligada = false;
    }

    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println("# Lâmpada Ligada #");
        } else {
            System.out.println("A lâmpada já está ligada.");
        }
    }

    public void desligar() {
        if (ligada) {
            ligada = false;
            System.out.println("# Lâmpada Desligada #");
        } else {
            System.out.println("A lâmpada já está desligada.");
        }
    }

    public void mostrarStatus() {
        System.out.println("STATUS: " + (ligada ? "Ligada" : "Desligada"));
    }

    public void mostrarPropriedades() {
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<");
        System.out.println("COR: " + cor);
        System.out.println("MARCA: " + marca);
        System.out.println("MODELO: " + modelo);
        System.out.println("WATTS: " + watts);
        System.out.println("TIPO: " + tipo);
        System.out.println("GARANTIA: " + garantia + " meses");
        System.out.println("PREÇO – R$: " + preco);
        mostrarStatus();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe os dados da lâmpada:");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        System.out.print("Watts: ");
        int watts = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Tipo (LED, Incandescente, etc.): ");
        String tipo = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Garantia (em meses): ");
        int garantia = scanner.nextInt();

        Lampada lampada = new Lampada(marca, modelo, cor, watts, tipo, preco, garantia);

        lampada.mostrarPropriedades();

        int escolha;
        do {
            System.out.println("Ligar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não");
            escolha = scanner.nextInt();

            if (escolha == 1) {
                lampada.ligar();
            } else if (escolha == 2) {
                lampada.desligar();
            } else if (escolha == 0) {
                System.out.println("*** Você encerrou o software. ***");
            } else {
                System.out.println("Opção inválida! Por favor, digite 0, 1 ou 2.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}
