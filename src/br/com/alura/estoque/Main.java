package br.com.alura.estoque;
import br.com.alura.estoque.modelo.Alurator;

import java.util.Scanner;

public class Main {

	/**
	 * Simula o navegador.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Casos possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 */
		
		try (Scanner s = new Scanner(System.in)) {
			String url = s.nextLine();
			
			Alurator alurator = new Alurator("br.com.alura.estoque.controle.");
			while (!url.equals("exit")) {
				Object response = alurator.executa(url);
				
				System.out.println("Response: " + response);
				
				url = s.nextLine();
			}
		}
	}

}
