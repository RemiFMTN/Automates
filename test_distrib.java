import java.util.ArrayList;

public class test_distrib {
    public static void main(String[] args) {

        // États principaux
        Etat e0 = new Etat("e0");
        Etat e10 = new Etat("e10");
        Etat e20 = new Etat("e20");
        Etat e30 = new Etat("e30");
        Etat e40 = new Etat("e40");
        Etat e50 = new Etat("e50");

        // États de dépassement
        Etat e60 = new Etat("e60"); 
        Etat e70 = new Etat("e70"); 
        Etat e80 = new Etat("e80"); 
        Etat e90 = new Etat("e90"); 
        Etat e100 = new Etat("e100"); 

        // États de rendu intermédiaire
        Etat srendu10 = new Etat("srendu10");
        Etat srendu20 = new Etat("srendu20");

        // États de commande
        Etat s = new Etat("s");
        Etat l = new Etat("l");

        // État final
        Etat Final = new Etat("Final");

        // -----------------------------
        // Boucles S|L
        // -----------------------------
        Transition t1 = new Transition(e0, e0, "S|L");
        Transition t2 = new Transition(e10, e10, "S|L");
        Transition t3 = new Transition(e20, e20, "S|L");
        Transition t4 = new Transition(e30, e30, "L");
        Transition t5 = new Transition(e40, e40, "L");

        // -----------------------------
        // Transitions pièces
        // -----------------------------
        Transition t6 = new Transition(e0, e10, "1");
        Transition t7 = new Transition(e0, e20, "2");
        Transition t8 = new Transition(e0, e50, "5");

        Transition t9 = new Transition(e10, e20, "1");
        Transition t10 = new Transition(e10, e30, "2");
        Transition t11 = new Transition(e10, e60, "5");

        Transition t12 = new Transition(e20, e30, "1");
        Transition t13 = new Transition(e20, e40, "2");
        Transition t14 = new Transition(e20, e70, "5");

        Transition t15 = new Transition(e30, e40, "1");
        Transition t16 = new Transition(e30, e50, "2");
        Transition t17 = new Transition(e30, e80, "5");
        Transition t18 = new Transition(e30, s, "S");

        Transition t19 = new Transition(e40, e50, "1");
        Transition t20 = new Transition(e40, e60, "2");
        Transition t21 = new Transition(e40, e90, "5");
        Transition t22 = new Transition(e40, srendu10, "S");

        Transition t23 = new Transition(e50, e60, "1");
        Transition t24 = new Transition(e50, e70, "2");
        Transition t25 = new Transition(e50, e100, "5");
        Transition t26 = new Transition(e50, srendu20, "S");
        Transition t27 = new Transition(e50, l, "L");

        // -----------------------------
        // Rendu automatique
        // -----------------------------
        Transition t28 = new Transition(e60, e50, "d");
        Transition t29 = new Transition(e70, e50, "v");
        Transition t30 = new Transition(e80, e50, "d|v");
        Transition t31 = new Transition(e90, e50, "v,v");
        Transition t32 = new Transition(e100, e50, "c");

        // -----------------------------
        // Rendu intermédiaire → distribution
        // -----------------------------
        Transition t33 = new Transition(srendu20, s, "v");
        Transition t34 = new Transition(srendu10, Final, "s");

        // -----------------------------
        // Transitions finales
        // -----------------------------
        Transition t35 = new Transition(s, Final, "s");
        Transition t36 = new Transition(l, Final, "l");

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
        transitions.add(t8);
        transitions.add(t9);
        transitions.add(t10);
        transitions.add(t11);
        transitions.add(t12);
        transitions.add(t13);
        transitions.add(t14);
        transitions.add(t15);
        transitions.add(t16);
        transitions.add(t17);
        transitions.add(t18);
        transitions.add(t19);
        transitions.add(t20);
        transitions.add(t21);
        transitions.add(t22);
        transitions.add(t23);
        transitions.add(t24);
        transitions.add(t25);
        transitions.add(t26);
        transitions.add(t27);
        transitions.add(t28);
        transitions.add(t29);
        transitions.add(t30);
        transitions.add(t31);
        transitions.add(t32);
        transitions.add(t33);
        transitions.add(t34);
        transitions.add(t35);
        transitions.add(t36);
        etatsFinaux.add(Final);
        Automate automate = new Automate(etatsFinaux, transitions, "Automate1", e0);

        System.out.println("Automate : " + automate.nom);

        // Test du sujet de TP
        String mot1 = "12Ss";
        boolean appartient = automate.appartient(mot1);
        System.out.println("Le mot '" + mot1 + "' appartient a l'automate : " + appartient + '\n');

        String mot2 = "LSLS2SS1Ss";
        appartient = automate.appartient(mot2);
        System.out.println("Le mot '" + mot2 + "' appartient a l'automate : " + appartient + '\n');

        String mot3 = "1L5dSvs";
        appartient = automate.appartient(mot3);
        System.out.println("Le mot '" + mot3 + "' appartient a l'automate : " + appartient + '\n');

        String mot4 = "2Ss";
        appartient = automate.appartient(mot4);
        System.out.println("Le mot '" + mot4 + "' appartient a l'automate : " + appartient + '\n');

        String mot5 = "1S5s";
        appartient = automate.appartient(mot5);
        System.out.println("Le mot '" + mot5 + "' appartient a l'automate : " + appartient + '\n');

        String mot6 = "d11l";
        appartient = automate.appartient(mot6);
        System.out.println("Le mot '" + mot6 + "' appartient a l'automate : " + appartient + '\n');

        // Autres Tests

        // Mot accepté : 50c -> café long direct
        String mot7 = "5Ll";
        appartient = automate.appartient(mot7);
        System.out.println("Le mot '" + mot7 + "' appartient a l'automate : " + appartient + '\n');

        // Mot accepté : 20c + 20c + 10c -> café long
        String mot8 = "221Ll";
        appartient = automate.appartient(mot8);
        System.out.println("Le mot '" + mot8 + "' appartient a l'automate : " + appartient + '\n');

        // Mot refusé : bouton avant paiement suffisant
        String mot9 = "1Ss";
        appartient = automate.appartient(mot9);
        System.out.println("Le mot '" + mot9 + "' appartient a l'automate : " + appartient + '\n');

        // Mot refusé : rendu de monnaie sans raison
        String mot10 = "v2Ss";
        appartient = automate.appartient(mot10);
        System.out.println("Le mot '" + mot10 + "' appartient a l'automate : " + appartient + '\n');

        // Mot refusé : distribution sans commande
        String mot11 = "12s";
        appartient = automate.appartient(mot11);
        System.out.println("Le mot '" + mot11 + "' appartient a l'automate : " + appartient + '\n');

        // Mot refusé : rendu après distribution
        String mot12 = "12Ssd";
        appartient = automate.appartient(mot12);
        System.out.println("Le mot '" + mot12 + "' appartient a l'automate : " + appartient + '\n');
    }
}