import java.util.*;

public class Test_TD {
    public static void main(String[] args) {
        // Création des états
        Etat q0 = new Etat("q0");
        Etat q1 = new Etat("q1");
        Etat q2 = new Etat("q2");

        // Création des transitions
        Transition t1 = new Transition(q0, q1, "a");
        Transition t2 = new Transition(q1, q2, "b");
        Transition t3 = new Transition(q2, q0, "c");

        // Création de l'automate
        ArrayList<Etat> etatsFinaux = new ArrayList<>();
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(t1);
        transitions.add(t2);
        transitions.add(t3);
        etatsFinaux.add(q0);
        Automate automate = new Automate(etatsFinaux, transitions, "Automate1", q0);

        // Test de l'appartenance d'un mot à l'automate
        System.out.println("Automate : " + automate.nom);

        String mot1 = "abc";
        boolean appartient = automate.appartient(mot1);
        System.out.println("Le mot '" + mot1 + "' appartient a l'automate : " + appartient + '\n');

        String mot2 = "ab";
        appartient = automate.appartient(mot2);
        System.out.println("Le mot '" + mot2 + "' appartient a l'automate : " + appartient + '\n');

        String mot3 = "abca";
        appartient = automate.appartient(mot3);
        System.out.println("Le mot '" + mot3 + "' appartient a l'automate : " + appartient + '\n');

        String mot4 = "abc abc";
        appartient = automate.appartient(mot4);
        System.out.println("Le mot '" + mot4 + "' appartient a l'automate : " + appartient + '\n');
    }
}
