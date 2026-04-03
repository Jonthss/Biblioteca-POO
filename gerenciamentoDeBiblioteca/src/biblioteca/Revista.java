package biblioteca;

public class Revista extends Material {

	public int numero;

	public Revista(String titulo, String autor, int numeroDaRevistaAdd) {
		super(titulo, autor);
		this.numero = numeroDaRevistaAdd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
	    return "📰 REVISTA: " + titulo.toUpperCase() + "\n" +
	           "   ├─ Autor: " + autor + "\n" +
	           "   └─ Edição: Nº " + numero + "\n";
	}

	
	
	

	
}
