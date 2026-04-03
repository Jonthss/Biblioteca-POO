package biblioteca;

public class Livro extends Material {

	public Genero genero;

	public Livro(String titulo, String autor, Genero genero) {
		super(titulo, autor);
		this.genero = genero;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
	    return "📖 LIVRO: " + getTitulo().toUpperCase() + "\n" +
	           "   ├─ Autor: " + getAutor() + "\n" +
	           "   └─ Gênero: " + genero + "\n";
	}

	
}
