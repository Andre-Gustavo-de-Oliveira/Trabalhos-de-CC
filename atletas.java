import java.util.Scanner;

public class Atletas {

    private String nome;
    private char sexo;
    private double altura;
    private double peso;

    public Atletas(String nome, char sexo, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de atletas (N > 0): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Atletas[] atletasArray = new Atletas[n];

        double pesoTotal = 0;
        double alturaTotalMulheres = 0;
        int contHomens = 0;
        int contMulheres = 0;
        double maiorAltura = 0;
        String nomeMaisAlto = "";

        for (int i = 0; i < n; i++) {
            System.out.println("\nInforme os dados do " + (i + 1) + "º atleta:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            char sexo;
            while (true) {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.nextLine().toUpperCase().charAt(0);
                if (sexo == 'M' || sexo == 'F') {
                    break;
                }
                System.out.println("Entrada inválida! Por favor, digite 'M' ou 'F'.");
            }

            double altura;
            while (true) {
                System.out.print("Altura (em metros): ");
                altura = scanner.nextDouble();
                if (altura > 0) {
                    break;
                }
                System.out.println("Entrada inválida! A altura deve ser um valor positivo.");
            }

            double peso;
            while (true) {
                System.out.print("Peso (em kg): ");
                peso = scanner.nextDouble();
                if (peso > 0) {
                    break;
                }
                System.out.println("Entrada inválida! O peso deve ser um valor positivo.");
            }
            scanner.nextLine();

            atletasArray[i] = new Atletas(nome, sexo, altura, peso);

            pesoTotal += peso;

            if (sexo == 'M') {
                contHomens++;
            } else {
                contMulheres++;
                alturaTotalMulheres += altura;
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaisAlto = nome;
            }
        }

        double pesoMedio = pesoTotal / n;
        double porcentagemHomens = (contHomens / (double) n) * 100;
        
        System.out.println("\n--- Relatório ---");
        System.out.printf("Peso médio dos atletas: %.2f kg%n", pesoMedio);
        System.out.println("Atleta mais alto: " + nomeMaisAlto);
        System.out.printf("Porcentagem de homens: %.2f%%%n", porcentagemHomens);

        if (contMulheres > 0) {
            double alturaMediaMulheres = alturaTotalMulheres / contMulheres;
            System.out.printf("Altura média das mulheres: %.2f m%n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }
        scanner.close();
    }
}
