public class Etat {

    String nomEtat;
    TypeEtat typeEtat;
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

	public TypeEtat GetTypeEtat(){
		return typeEtat;
	}

	public void SetTypeEtat(TypeEtat TypeEtat){
		typeEtat = TypeEtat;
	}

	public Boolean getCo_Access() {
		return Co_Access;
	}

	public void setCo_Access(Boolean co_Access) {
		Co_Access = co_Access;
	}

	public Etat(String nomEtat, TypeEtat typeEtat) {
        this.nomEtat = nomEtat;
        this.typeEtat = typeEtat;
    }
	//khorsi : Empty Arguments Constructor
	public Etat() {

    }
	//Khorsi : Set Type Etat
	public void SetType(TypeEtat typeEtat) {
		this.typeEtat= typeEtat;
	}
}