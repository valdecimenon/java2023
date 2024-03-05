package com.softgraf.primavera.data.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softgraf.primavera.data.ClienteProjection;
import com.softgraf.primavera.data.entity.Cliente;

@Repository										// <NomeEntidade, TipoDoId>
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// == Usando os Métodos existentes ===
	// findBy + nome_do_atributo_na_entidade
	// Exemplos:
	// List<Cliente> findByNome(String nome)
	// List<Cliente> findByEmail(String email)
	
	
	// == Criando Métodos personalizados ===
	// Like
	// Ex.: String nome = "%maria%"
	List<Cliente> findByNomeLike(String nome);
	
	// Containing
	// Ex.: String nome = "maria"
	List<Cliente> findByNomeContaining(String nome);
	List<Cliente> findByEmailContaining(String email);
	
	// Starting e Ending
//	List<Cliente> findByNomeStartingWith(String nome);
//	List<Cliente> findByNomeEndingWidth(String nome);
	
	// Null e Not Null
	List<Cliente> findByNomeIsNull();
	List<Cliente> findByNomeIsNotNull();
	
	// Busca com ordenação
	List<Cliente> findByNomeOrderByNomeAsc(String nome);
	List<Cliente> findByNomeOrderByNomeDesc(String nome);
	
	// Busca com ordenação usando Sort
	// Ex.: Sort sort = Sort.by(Sort.Direction.ASC, "nome");
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	// Busca com classe aninhada
	// cliente.endereco.cidade
	List<Cliente> findByEndereco_CidadeContaining(String cidade);
	List<Cliente> findByEndereco_BairroContaining(String bairro);
	List<Cliente> findByEndereco_EstadoContaining(String estado);
	List<Cliente> findByEndereco_CepContaining(String cep);
	
	// Busca com paginação e ordenação: interface PagingAndSortingRepository
	//                                  page, size, sort
	// Pageable pageable = PageRequest.of(1, 5, Sort.by(Sort.Direction.ASC, "email");
	Page<Cliente> findAll(Pageable pageable);
	
	// Página atual: clientes.getNumber()
	// Total de itens da consulta: clientes.getTotalElements()
	
	// === JPQL Queries ===
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Pageable pageable);
	
	@Query("SELECT c FROM Cliente c WHERE c.email = :emailParam")
	List<Cliente> findAllByEmailDoCliente(@Param("emailParam") String email, Pageable pageable);
	
	// query usando nome e data (apenas exemplo)
	/*
	 * DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 * LocalDate data = LocalDate.parse("17/02/2024", formatador)
	 */
//	@Query("SELECT c FROM Cliente c WHERE c.nome = :nome AND c.dataCadastro = :data")
//	List<Cliente> findNomeDataCadastro(@Param("nome") String nome, @Param("data") LocalDate data);
	
	// === Native Query (sql nativo com o Spring Data)
	@Query(value = "SELECT * FROM Cliente WHERE nome = ?1", nativeQuery = true)
	List<Cliente> findByNome(String nome);
	
	// query usando Interface-Based Projection
	// equivale ao operador "Select New" do JPA
	// Ex.: Select New pacote.ClienteDados(c.id, c.nome, c.email) FROM Cliente c"
	// porém no Spring Data, não precisamos criar a classe, criamos apenas a interface
	@Query("SELECT c.id, c.nome, c.email FROM Cliente c")
	List<ClienteProjection> findClienteProjecao(); 
	
	
	// === JPQL Named Queries (uma named query é escrita na entidade e não no repositório)
	/*
	 * @NamedQuery(name = "Cliente.buscarPF", 
	 *      query="SELECT c FROM Cliente c WHERE c.tipoPessoa='Física' AND c.cpfOuCnpj = :cpf)
	 *    
	 * @Entity
	 * public class Cliente {
	 * ....
	 */
	// o nome do método deve ser o nome da named query!!
	// List<Cliente> buscarPF(@Param("cpf") String cpf);
	
	// Documentação completa
	// https://docs.spring.io/spring-data/jpa/reference/
}
