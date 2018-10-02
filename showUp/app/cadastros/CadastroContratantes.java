package cadastros;

public class CadastroContratantes{

	private IReposirioContratante repositorioContrante;

	public CadastroContratantes(){
		this.repositorioContrante = new RepositorioContratanteDB();
	}

	public Contratante cadastrar(Contratante contratante){
		Contratante aux=this.repositorioContrante.cadastrar(contratante);
	}

	public boolean existeConta(String cpf){
		boolean aux = this.repositorioContrante.existeConta(cpf);
		return aux;
	}
}