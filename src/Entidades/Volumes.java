package Entidades;

public class Volumes {
	
	String titulo, autor, descricao, ano, editora, tipo, paginas;
	
	public Volumes(){
		this.titulo="";
		this.autor="";
		this.descricao="";
		this.ano="";
		this.editora="";
		this.paginas="";
		this.tipo="";
	}
	
	public Volumes (String titulo, String autor, String descricao, String ano, 
			String editora, String paginas, String tipo){
		this.titulo=titulo;
		this.autor=autor;
		this.descricao=descricao;
		this.ano=ano;
		this.editora=editora;
		this.paginas=paginas;
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	

}
