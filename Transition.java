public class Transition {
    Etat e_init;
    Etat e_final;
    String symbole;

    public Transition(Etat e_init, Etat e_final, String symbole) {
        this.e_init = e_init;
        this.e_final = e_final;
        this.symbole = symbole;
    }

    //Setters
    public void set_e_init (Etat e_init){
        this.e_init = e_init;
    }
    public void set_e_final (Etat e_final){
        this.e_final = e_final;
    }
    public void set_symbole (String symbole){
        this.symbole = symbole;
    }

    //Getters
    Etat get_e_init (){
        return this.e_init;
    }
    Etat get_e_final (){
        return this.e_final;
    }
    String get_symbole (){
        return this.symbole;
    }
}
