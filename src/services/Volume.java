package services;

public class Volume {
	
	int paginas;
	String titulo, descricao, editora, autor, ano, tipo; 
	
	public Volume(){}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPag() {
		return paginas;
	}

	public void setPag(int paginas) {
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public void setVolume(String titulo, String tipo, String descricao, 
			String editora, String autor, String ano, int paginas){
		this.titulo = titulo;
		this.tipo = tipo;
		this.ano = ano;
		this.autor = autor;
		this.editora = editora;
		this.descricao = descricao;
		this.paginas = paginas;
	}

}
