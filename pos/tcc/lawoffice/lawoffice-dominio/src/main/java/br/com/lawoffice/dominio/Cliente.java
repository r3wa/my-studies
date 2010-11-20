/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Representa um cliente do escritório
 * 
 * @author robson
 *
 */
@Entity
@Table(name="CLIENTE")
public class Cliente{

	
	// TODO: long ou Long
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToMany(mappedBy="cliente")
	private List<Lancamento> lancamentos;
	
	// TODO: transient até fechar o serviço de caixa
	@Transient
	private Conta conta;

	
	public Cliente() {}
	
	
	// TODO: construtor temporario
	public Cliente(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
