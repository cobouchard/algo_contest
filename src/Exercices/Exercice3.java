package Exercices;

import FileWriting.InputCreator;
import fonctions.UsefulFunc;

public abstract class Exercice3
{
    private static final String name="exo3";
    private static final int taille = 10000;

    private static final int debut = 1;
    private static final int fin = 1000;


    public static void main(String... args)
    {;

        InputCreator ic = new InputCreator(name);

        for(int i=0; i!= taille; i++)
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin)).toString()+"\n");


        ic.close();
    }
}
