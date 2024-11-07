package br.fiap.modelo.bean;

public class Fornecedor {
	int id;
	String nome;
	double cnpj;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCnpj() {
		return cnpj;
	}
	public void setCnpj(double cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		return  nome;
	}
	
	
}
