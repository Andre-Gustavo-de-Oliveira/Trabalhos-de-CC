import java.util.Scanner;

public class Imposto {
    
    private double salarioMensal;
    private double prestacaoServico;
    private double ganhoCapital;
    private double gastosMedicos;
    private double gastosEducacionais;


    public Imposto(double salarioMensal, double prestacaoServico, double ganhoCapital, double gastosMedicos, double gastosEducacionais) {
        this.salarioMensal = salarioMensal;
        this.prestacaoServico = prestacaoServico;
        this.ganhoCapital = ganhoCapital;
        this.gastosMedicos = gastosMedicos;
        this.gastosEducacionais = gastosEducacionais;
    }

    
    public double calcularImposto() {
        double salarioAnual = salarioMensal * 12;
        double impostoTotal = 0;

        
        if (salarioMensal < 3000) {
            
            impostoTotal += 0; 
        } else if (salarioMensal >= 3000 && salarioMensal <= 5000) {
            impostoTotal += salarioAnual * 0.10; 
        } else {
            impostoTotal += salarioAnual * 0.20; 
        }

        
        if (prestacaoServico > 0) {
            impostoTotal += prestacaoServico * 0.15; 
        }

        
        if (ganhoCapital > 0) {
            impostoTotal += ganhoCapital * 0.20; 
        }

        return impostoTotal;
    }

    
    public double calcularAbatimentos(double impostoTotal) {
        double maxAbatimento = impostoTotal * 0.30; 
        double totalGastos = gastosMedicos + gastosEducacionais;

        if (totalGastos > maxAbatimento) {
            return maxAbatimento; 
        } else {
            return totalGastos; 
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Informe o salário mensal: ");
        double salarioMensal = scanner.nextDouble();

        System.out.print("Informe a renda com prestação de serviços: ");
        double prestacaoServico = scanner.nextDouble();

        System.out.print("Informe o ganho de capital: ");
        double ganhoCapital = scanner.nextDouble();

        System.out.print("Informe os gastos médicos: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Informe os gastos educacionais: ");
        double gastosEducacionais = scanner.nextDouble();

        
        Imposto imposto = new Imposto(salarioMensal, prestacaoServico, ganhoCapital, gastosMedicos, gastosEducacionais);
        
        
        double impostoTotal = imposto.calcularImposto();
        
        double abatimentos = imposto.calcularAbatimentos(impostoTotal);
        
        double valorFinal = impostoTotal - abatimentos;

        
        System.out.println("Total bruto de imposto: R$ " + impostoTotal);
        System.out.println("Abatimentos: R$ " + abatimentos);
        System.out.println("Valor final do imposto devido: R$ " + valorFinal);

        
        scanner.close();
    }
}
