public class Etat {

    String nomEtat;
    Boolean Access=false;
    Boolean Co_Access=false;

    public Boolean getAccess() {
		return Access;
	}

	public void setAccess(Boolean access) {
		Access = access;
	}

	public String GetNomEtat(){
		return nomEtat;
	}

	public void SetNomEtat(String NomEtat){
		nomEtat = NomEtat;
	}

	public Boolean getCo_Access() {
		return Co_Access;
	}

	public void setCo_Access(Boolean co_Access) {
		Co_Access = co_Access;
	}

	public Etat(String nomEtat) {
        this.nomEtat = nomEtat;
    }

	public Etat() {

    }
}