package com.softgraf.agenda.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
 * Registro Contato:
 * - cada registro de contato possui 64 bytes
 * - int id + String nome + String fone
 * - tamanho total: 4 + 40 + 20 = 64 bytes
 * - int: 4 bytes
 * - String: cada char = 2 bytes
 * - posição do ponteiro no arquivo: 0..63  
 */

public class ArquivoBinario {
	
	
	// arquivo binário de acesso aleatório
	private RandomAccessFile arquivo;
	
	// abre ou cria um arquivo de dados. Ex: agenda.dat
	public void abrirArquivo(String nome) throws IOException {
		arquivo = new RandomAccessFile(nome, "rw"); // read write
		// posiciona o ponteiro no final do arquivo
		arquivo.seek(arquivo.length());
	}
	
	// fechar o arquivo de dados
	public void fecharArquivo() throws IOException {
		if (arquivo != null) {
			arquivo.close();
			arquivo = null;
		}
	}

	// adiciona registro no final do arquivo
	public void gravarContato(Contato contato) throws IOException {
		// posiciona ponteiro no final do arquivo
		arquivo.seek(arquivo.length());
		arquivo.writeInt(contato.getId());
		// precisamos limitar o tamanho das strings
		arquivo.writeChars(limitarStrings(contato.getNome(), 20));
		arquivo.writeChars(limitarStrings(contato.getFone(), 10));
		
	}

	private String limitarStrings(String campo, int tamanhoMaximo) {
		int diferenca = tamanhoMaximo - campo.length();
		StringBuilder sb = new StringBuilder(tamanhoMaximo);
		
		// faltam caracteres no tamanho do campo, então
		// precisamos adicionar espaços
		if (diferenca > 0) {
			  char[] arrChar = new char[diferenca];
			  // preenche o array com espaços
			  Arrays.fill(arrChar, ' ');
			  sb.append(campo);   // "João"
			  sb.append(arrChar); // "João               "
		// sobram caracteres no tamanho do campo: então corta excedentes
		} else {
			sb.append(campo.substring(0, tamanhoMaximo));
		}
		
		return sb.toString();
	}
	
	
	// le um contato dado o número do registro
	// número = 1..n
	public Contato lerContato(int numero) throws IOException {
		Contato contato = null;
		
		if (arquivo != null) {
			contato = new Contato();
			
			// posiciona o ponteiro: 0, 64, 128, 192, 256
			arquivo.seek((numero - 1) * 64);
			
			// le id
			int id = arquivo.readInt();
			contato.setId(id);
			
			// le cada caractere do nome (20 vezes)
			StringBuilder nome = new StringBuilder(20);
			for (int i=0; i<20; i++) {
				nome.append(arquivo.readChar());
			}
			contato.setNome(nome.toString().trim());
			
			// le cada caractere do fone (10 vezes)
			StringBuilder fone = new StringBuilder(10);
			for (int i=0; i<10; i++) {
				fone.append(arquivo.readChar());
			}
			contato.setFone(fone.toString().trim());
			
		} else {
			throw new IOException("Nenhum arquivo aberto para leitura");
		}
		
		return contato;
	}
	
	
	
	

}
