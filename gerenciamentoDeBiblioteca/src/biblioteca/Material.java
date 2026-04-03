package biblioteca;

public class Material {
	
	public String titulo;
	public String autor;
	
	
	public Material(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
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

}
