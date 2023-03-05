package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Digite dados do trabalhador");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Nivel: ");
		String nivelTrabalhador = sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		sc.nextLine();
		Departamento departamento = new Departamento(nomeDepartamento);
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, departamento);
		
		System.out.print("Quantos contratos tem esse trabalhador? ");
		int quantidadeContratos = sc.nextInt();
		
		for (int i = 1; i <= quantidadeContratos; i++) {
			
			System.out.println("Digite os dados do contrato nº " + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			
			Contrato contrato = new Contrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
			
		}
		
		System.out.println();
		System.out.println("Entre com mês e ano para calcular os ganhos (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.printf("Ganhos em %s: R$%.2f", mesAno, trabalhador.ganhos(ano, mes));
		
		sc.close();
	}

}
