package com.softgraf.agenda.controller;

import java.io.IOException;

import com.softgraf.agenda.model.ArquivoBinario;
import com.softgraf.agenda.model.Contato;

public class TesteArquivo {

	public static void main(String[] args) {
		Contato c1 = new Contato(1, "João da Silva", "3224-0705");
		Contato c2 = new Contato(2, "Josiel Madureira", "3028-0449");
		Contato c3 = new Contato(3, "Maria Luiza", "3028-1234");
		Contato c4 = new Contato(4, "Rafael Moreira", "98401-0000");
		
		ArquivoBinario arq = new ArquivoBinario();
		
		try {
			System.out.println("Salvando registros...");
			arq.abrirArquivo("agenda.dat");
//			arq.gravarContato(c1);
//			arq.gravarContato(c2);
//			arq.gravarContato(c3);
//			arq.gravarContato(c4);
//			
			System.out.println("\nLendo registros em qualquer ordem!");
			System.out.println(arq.lerContato(4));
			System.out.println(arq.lerContato(3));
			System.out.println(arq.lerContato(2));
			System.out.println(arq.lerContato(1));
			
			
			arq.fecharArquivo();
			
		} catch (IOException e) {
			System.out.println("Erro ao abrir/gravar/ler arquivo agenda.dat");
			e.printStackTrace();
			System.exit(0);  //  status normal de saida
		}

	}

}
