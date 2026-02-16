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

    public static final Set<Character> ALPHABET = 
        new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ':', 'a', 'b', 'c')); // alphabet

    public boolean appartient(String mot) {

        // Cas du mot vide
        if (mot.length() == 0) {
            if (ensembleEtatsFinaux.contains(etatInitial)) {
                return true;
            } else {
                System.out.println("Echec : le mot est vide et l'etat initial n'est pas un etat final.");
                return false;
            }
        }

        Etat etatCourant = etatInitial;

        for (int i = 0; i < mot.length(); i++) {
            char symbole = mot.charAt(i);
            boolean transitionTrouvee = false;

            for (Transition transition : ensembleTransitions) {

                // Vérifie s'il existe une transition depuis l'état courant
                if (transition.get_e_init().equals(etatCourant)
                    && transition.accepte(symbole)) {

                    etatCourant = transition.get_e_final();
                    transitionTrouvee = true;
                    break;
                }
            }
            
            // Vérifie si le symbole appartient à l'alphabet
            if (!ALPHABET.contains(symbole)) {
                System.out.println(
                    "Echec : le symbole '" + symbole + "' n'appartient pas a l'alphabet."
                );
                return false;
            }

            // transition inexistante
            if (!transitionTrouvee) {
                System.out.println(
                    "Echec : aucune transition definie depuis l'etat "
                    + etatCourant.GetNomEtat()
                    + " avec le symbole '" + symbole + "'."
                );
                return false;
            }
        }

        // Fin du mot atteinte dans un état non final
        if (!ensembleEtatsFinaux.contains(etatCourant)) {
            System.out.println(
                "Echec : fin du mot atteinte dans l'etat "
                + etatCourant.GetNomEtat()
                + " qui n'est pas un etat final."
            );
            return false;
        }

        return true;
    }
}