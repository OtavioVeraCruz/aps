package cadastros;

public class CadastroArtistas{

	private IRepositorioArtista repositorioArtista;

	public CadastroArtistas(){
		this.repositorioArtista = new RepositorioArtistaDB();
	}

	public Artista cadastrar(Artista artista){
		Artista aux=this.repositorioArtista.cadastrar(artista);
		return aux;
	}

	public boolean existeConta(String cpf){
		boolean aux = this.repositorioArtista.existeConta(cpf);	

	}

}