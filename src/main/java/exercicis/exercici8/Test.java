package exercicis.exercici8;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        // Instanciém la clase.
        Registre r1 = new Registre("USR23", "Marta", "Barcelona");
        Registre r2 = new Registre("USR24", "David", "Madrid");
        Registre r3 = new Registre("USR25", "Joan", "Mahón");

        // ArrayList per els registres.
        ArrayList<Registre> registres = new ArrayList<>();

        // Afegim els resgistres al ArrayList.
        registres.add(r1);
        registres.add(r2);
        registres.add(r3);

        Registre regist = new Registre(registres);

        // Cridem al mètode de la condició.
        regist.esDeBarcelona(); // Li pasem l'ArrayList.
        System.out.println(); // Salt de lìnea.
        System.out.println(regist);

    }
}