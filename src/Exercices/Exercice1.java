package Exercices;


import FileWriting.InputCreator;
import fonctions.UsefulFunc;

public abstract class Exercice1
{
    private static final int taille = 1000;
    private static final int taille2 = 750;

    private static final String name="exo1";

    private static final int debut = 1;

    private static final int fin = 200;


    public static void main(String... args)
    {
        UsefulFunc.generatePrimes(10000);

        boolean avant = UsefulFunc.randomBool();

        InputCreator ic = new InputCreator(name);
        for(int i=0; i!= taille ; i++)
        {
            Integer temp = UsefulFunc.randomInt(debut,fin);
            ic.addString(temp.toString()+"\n");
            if(UsefulFunc.isPrime(temp))
            {
                for(int k=0;k!=4;k++)
                    ic.addString(((Integer)UsefulFunc.randomNonPrime(debut,fin)).toString()+"\n");
            }
        }


        //création de l'intrus

        if(avant)
        {
            //nombre premier 4 de distance avant l'intrus
            ic.addString(((Integer)UsefulFunc.randomPrime(debut,fin)).toString()+"\n");

            //nombre pair à droite du jumeau de l'intrus
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin,0)).toString()+"\n");

            //2 nombres quelquonques

            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin)).toString()+"\n");
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin)).toString()+"\n");

            //intrus
            Integer intrus = UsefulFunc.randomPrime(debut,fin);
            ic.addString(intrus.toString()+"\n");
            System.out.println(intrus);

            //nombre impair à droite de l'intrus
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin,1)).toString()+"\n");
        }
        else
        {
            //intrus
            Integer intrus = UsefulFunc.randomPrime(debut,fin);
            ic.addString(intrus.toString()+"\n");
            System.out.println(intrus);

            //nombre impair à droite de l'intrus
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin,1)).toString()+"\n");

            //2 nombres quelquonques
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin)).toString()+"\n");
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin)).toString()+"\n");

            //nombre premier 4 de distance avant l'intrus
            ic.addString(((Integer)UsefulFunc.randomPrime(debut,fin)).toString()+"\n");

            //nombre pair à droite du jumeau de l'intrus
            ic.addString(((Integer)UsefulFunc.randomInt(debut,fin,0)).toString()+"\n");
        }

        //création de l'intrus




        for(int i=0; i!= taille2 ; i++)
        {
            Integer temp = UsefulFunc.randomInt(debut,fin);
            ic.addString(temp.toString()+"\n");
            if(UsefulFunc.isPrime(temp))
            {
                for(int k=0;k!=4;k++)
                    ic.addString(((Integer)UsefulFunc.randomNonPrime(debut,fin)).toString()+"\n");
            }
        }
        ic.close();

    }
}
