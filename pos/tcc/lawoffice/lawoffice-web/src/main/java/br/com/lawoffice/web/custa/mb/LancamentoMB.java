package br.com.lawoffice.web.custa.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.BaseMB;
import br.com.lowoffice.custas.exception.LancamentoDeCustaException;
import br.com.lowoffice.custas.lancamento.LancamentoDeCustaLocal;

/**
 * @author robson
 *
 * Manager Bean para página de /custas/novo-lacamento.xhtml
 *
 */
@ManagedBean()
@ViewScoped // TODO: @ViewScoped ? débito técnico 
public class LancamentoMB extends BaseMB{
	
	
	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
		
	// TODO: cdi ?
	/**
	 * Custa para adição/edicão/remoção da lista de custas 
	 */
	private Custa custa;
	
	/**
	 * ID do Colaborador selecionada na view para para adcionar nova custa 
	 */
	private Long colaboradorID;
	
	
	/**
	 * ID do Cliente selecionada na view para para adcionar nova custa 
	 */	
	private Long clienteID;
	
	

	/**
	 * Serviço de lançamentos de custas 
	 */
	@EJB
	private LancamentoDeCustaLocal lancamentoDeCusta;
	
	
	/**
	 * Serviço de dados ( CRUD ) 
	 */
	@EJB
	private DadosLocal dados;
	
	
	
	// >>>>>>>>>>>  ATRIBUTOS PARA MONTAGEM DA VIEW <<<<<<<<<<<<<<<
	
	/**
	 * 
	 * Colaboradores cadastrados no  sistema
	 * 
	 */
	private List<Colaborador> colaboradores;
	

	/**
	 * 
	 * Clientes cadastrados no sistema
	 * 
	 */
	private List<Cliente> clientes;
	
	// TODO: cdi ?
	/**
	 * Custas adicionadas para efetuar o lançamento ( montagem da tabela )
	 */
	private List<Custa> custas;
	
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		custa = new Custa();
		custas = new ArrayList<Custa>();
		clientes = dados.listar(Cliente.class);
		colaboradores = dados.listar(Colaborador.class);
	}
	
	
	public void adicionarCusta(){		
		custas.add(
			lancamentoDeCusta.adicionarCusta(
				custa, 
				getClienteSelecionado(), 
				getColaboradorSelecionado()
			)
		);
		custa = new Custa();	
	}
	

	public void removerCusta(){
		try {
			if(custa != null){
				lancamentoDeCusta.removerCusta(custa);
				custas.remove(custa);
			}else{
				custa = new Custa();
			}
				
		} catch (LancamentoDeCustaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void editarCusta(){
		if(custa == null)
			custa = new Custa();
	}
	
	
	
	public void atualizarCusta(){
		/*try {*/
			
/*			Custa c = custas.get(custas.indexOf(custa));
			
			c = lancamentoDeCusta.atualizarCusta(custa);*/
			
			custa = new Custa();
			
/*		} catch (LancamentoDeCustaException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}*/
	}


	
	public void fecharLancamento(){
		try {
			lancamentoDeCusta.fecharLacamento();
			custas.clear();
		} catch (LancamentoDeCustaException e){
			// TODO: 
			e.printStackTrace();
		}
	}
	
	

	private Colaborador getColaboradorSelecionado() {
		for (Colaborador colaborador: colaboradores)
			if( colaborador.getId().equals(colaboradorID))
				return colaborador;		
		return null;
	}


	private Cliente getClienteSelecionado() {
		for (Cliente cliente : clientes)
			if( cliente.getId().equals(clienteID))
				return cliente;
		return null;
	}	
	
		
	
	// gets e sets ...
	public Custa getCusta() {
		return custa;
	}


	public void setCusta(Custa custa) {
		this.custa = custa;
	}


	public List<Custa> getCustas() {
		return custas;
	}

	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}

	
	// 
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public List<Cliente> getClientes(){		
		return clientes;
	}

	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Long getColaboradorID() {
		return colaboradorID;
	}

	public void setColaboradorID(Long colaboradorID) {
		this.colaboradorID = colaboradorID;
	}


	public Long getClienteID() {
		return clienteID;
	}

	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}

}
