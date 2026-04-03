package biblioteca;

public enum Genero {

	FICCAO("Ficção"), 
	FICCAO_CIENTIFICA("Ficção Científica"), 
	FANTASIA("Fantasia"), 
	HISTORIA("História"), 
	ROMANCE("Romance"), 
	TERROR("Terror"), 
	AVENTURA("Aventura"), 
	MISTERIO("Mistério"), 
	POLICIAL("Policial"), 
	BIOGRAFIA("Biografia"), 
	AUTOAJUDA("Autoajuda"), 
	POESIA("Poesia"), 
	FILOSOFIA("Filosofia"), 
	INFANTIL("Infantil"), 
	ACADEMICO("Acadêmico"),
	TECNOLOGIA("Tecnologia"), 
	VIAGENS("Viagens"), 
	MUSICA("Música"),
	OUTROS("Outros");


	private String descricao;

	Genero(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}