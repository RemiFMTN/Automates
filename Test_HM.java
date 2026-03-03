import java.util.*;

public class Test_HM {
    public static void main(String[] args) {
        // Création des états
        Etat q0 = new Etat("q0");
        Etat q1 = new Etat("q1");
        Etat q2 = new Etat("q2");
        Etat q3 = new Etat("q3");
        Etat q4 = new Etat("q4");
        Etat q5 = new Etat("q5");
        Etat q6 = new Etat("q6");
     

        // Création des transitions
        Transition t1 = new Transition(q0, q1, "0|1");
        Transition t2 = new Transition(q0, q2, "2");
        Transition t3 = new Transition(q1, q3, "0|1|2|3|4|5|6|7|8|9");
        Transition t4 = new Transition(q2, q3, "0|1|2|3");
        Transition t5 = new Transition(q3, q4, ":");
        Transition t6 = new Transition(q4, q5, "0|1|2|3|4|5");
        Transition t7 = new Transition(q5, q6, "0|1|2|3|4|5|6|7|8|90|1|2|3|4|5|6|7|8|9");

        // Création de l'automate
        ArrayList<Etat> etatsFinaux = new ArrayList<>();
        ArrayList<Transition> transitions = new ArrayList<>();
        transitions.add(t1);
        transitions.add(t2);
        transitions.add(t3);
        transitions.add(t4);
        transitions.add(t5);
        transitions.add(t6);
        transitions.add(t7);
        etatsFinaux.add(q6);
        Automate automate = new Automate(etatsFinaux, transitions, "Automate1", q0);

        // Test de l'appartenance d'un mot à l'automate
        System.out.println("Automate : " + automate.nom);

        String mot1 = "12:34";
        boolean appartient = automate.appartient(mot1);
        System.out.println("Le mot '" + mot1 + "' appartient a l'automate : " + appartient + '\n');

        String mot2 = "22:45";
        appartient = automate.appartient(mot2);
        System.out.println("Le mot '" + mot2 + "' appartient a l'automate : " + appartient + '\n');

        String mot3 = "99:25";
        appartient = automate.appartient(mot3);
        System.out.println("Le mot '" + mot3 + "' appartient a l'automate : " + appartient + '\n');

        String mot4 = "1k";
        appartient = automate.appartient(mot4);
        System.out.println("Le mot '" + mot4 + "' appartient a l'automate : " + appartient + '\n');
    }
}
