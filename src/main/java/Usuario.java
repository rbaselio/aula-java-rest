
public class Usuario {

	private String nome;
	private String pass;
	
	public Usuario() {
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if(obj.getClass() == getClass()) {
				Usuario other = (Usuario) obj;
				if(other.nome.equals(nome)
						&& other.pass.equals(pass)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
