package Entidades;

public class Cliente {

	String login;
	String senha;
	String data;
	String sexo;
	String CPF;

	public Cliente(){
		this.login="";
		this.senha="";
		this.data="";
		this.sexo="";
		this.CPF="";
		}

	public Cliente(String login, String senha, String data, String sexo, String CPF) {
		this.login = login;
		this.senha = senha;
		this.data=data;
		this.sexo=sexo;
		this.CPF=CPF;
	}

	public String getLogin() {
		return login;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
