import java.util.*;

public class Automate {
    
    ArrayList<Etat> ensembleEtatsFinaux;
    ArrayList<Transition> ensembleTransitions;
    String nom;
    Etat etatInitial;

    public Automate (ArrayList<Etat> ensembleEtatsFinaux, ArrayList<Transition> ensembleTransitions, String nom, Etat etatInitial){
        this.ensembleEtatsFinaux = ensembleEtatsFinaux;
        this.ensembleTransitions = ensembleTransitions;
        this.nom = nom;
        this.etatInitial = etatInitial;
    }

    public boolean appartient(String mot){
        Etat etatCourant = etatInitial;
        for (int i = 0; i < mot.length(); i++) {
            char symbole = mot.charAt(i);
            boolean transitionTrouvee = false;
            for (Transition transition : ensembleTransitions) {
                if (transition.get_e_init().equals(etatCourant) && transition.get_symbole().equals(String.valueOf(symbole))) {
                    etatCourant = transition.get_e_final();
                    transitionTrouvee = true;
                    break;
                }
            }
            if (!transitionTrouvee) {
                // 1. Symbole non reconnu (hors alphabet)
                
                return false; // Aucune transition trouvée pour ce symbole
                
                // 2. transition inexistante depuis l'état courant
                // 3. Mot vide impossible
                // 4. fin du mot dans un état non final
            }
        }
        return ensembleEtatsFinaux.contains(etatCourant); // Vérifie si l'état final est atteint
    }
}
