package Exercices;

import FileWriting.InputCreator;
import fonctions.UsefulFunc;

import java.util.ArrayList;

public abstract class Exercice4 {

    public static final int taille_matrice = 3;
    public static final int nb_matrice = 40;

    private static final String name="exo4";

    private static final int debut = 0;

    private static final int fin = 20;

    private static ArrayList<Integer> liste_sommes = new ArrayList<>();

    static InputCreator ic;

    private static int getFactor()
    {
        int factor=1;

        int two  = UsefulFunc.randomInt(1,5);
        int five = UsefulFunc.randomInt(0,2);

        for(int i=0; i!= two; i++)
            factor*=2;

        for(int i=0; i!= five; i++)
            factor*=5;

        return factor;
    }

    public static class Matrix
    {
        public double[][] matrice;
        public int somme=0;
        public Matrix()
        {
            matrice = new double[taille_matrice][taille_matrice];
            somme =0;
        }

        public boolean everyRound()
        {
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    if(!UsefulFunc.isRound(matrice[i][j]))
                        return false;
                }
            }

            return true;
        }

        public boolean divisableBy(int div)
        {
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    if(matrice[i][j]%div!=0)
                        return false; //should not divide by div
                }
            }

            return true; //should divide by div
        }

        public void multiplyBy(double mult)
        {
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    matrice[i][j]=(double)mult*(double)matrice[i][j];
                }
            }
        }

        public void divideBy(double div)
        {
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    matrice[i][j]=(double)matrice[i][j]/div;
                }
            }
        }

        public void calculateSum()
        {
            int somme = 0;
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    somme+=matrice[i][j];
                }
            }
            this.somme = somme;
        }

        public void affiche()
        {
            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    System.out.print(matrice[i][j]+",");
                }
                System.out.println();
            }
            System.out.println("La somme est : " + this.somme);
        }
    }

    private static Matrix createMatrixEquals(int somme)
    {
        Matrix m = new Matrix();

        int initial_sum = somme;

        for(int i=0; i!= taille_matrice; i++)
        {
            for(int j=0; j!= taille_matrice; j++)
            {
                int nombre = UsefulFunc.randomInt(debut,fin);

                if(nombre>somme)
                {
                    nombre = nombre - (nombre-somme);
                }

                somme-=nombre;

                m.somme+=nombre;
                m.matrice[i][j]=nombre;
            }
        }

        if(m.somme!=initial_sum)
        {
            return createMatrixEquals(initial_sum);
        }
        else
        {
            return m;
        }

    }

    private static Matrix createMatrixNotEquals(int somme)
    {
        Matrix m = new Matrix();

        for(int i=0; i!= taille_matrice; i++)
        {
            for(int j=0; j!= taille_matrice; j++)
            {
                int nombre = UsefulFunc.randomInt(debut,fin);

                m.somme+=nombre;
                m.matrice[i][j]=nombre;
            }
        }

        if(liste_sommes.contains(m.somme) || m.somme==somme)
        {
            return createMatrixNotEquals(somme);
        }
        else
        {
            liste_sommes.add(m.somme);
            return m;
        }

    }



    private static void writeMatrix(Matrix m)
    {
        double factor = getFactor();
        for(int i=0; i!= taille_matrice; i++)
        {
            for(int j=0; j!= taille_matrice; j++)
            {
                Double nombre = (double)m.matrice[i][j]/factor;
                //Double nombre = (double)m.matrice[i][j];
                ic.addString(nombre.toString()+",");
            }
            ic.addString("\n");
        }
        ic.addString("\n");
        System.out.println("Factor : " + factor);
    }

    public static void main(String... args)
    {
        ic = new InputCreator(name);

        int compteur=0;
        int somme = taille_matrice*taille_matrice*fin/2;
        System.out.println("Somme : "+somme);


        int remaining_matrices = nb_matrice;



        //first generation

        //int number_matrix_first_gen = remaining_matrices/3+UsefulFunc.randomInt(-5,5);
        int number_matrix_first_gen = 10;
        remaining_matrices -= number_matrix_first_gen;

        System.out.println("Nombre de matrices first gen : "+number_matrix_first_gen);

        for(int i =0; i!=number_matrix_first_gen; i++)
        {
            Matrix m = createMatrixNotEquals(somme);
            writeMatrix(m);
        }
        Matrix real = createMatrixEquals(somme);
        writeMatrix(real);

        //second generation

        //int number_matrix_second_gen = remaining_matrices/3+UsefulFunc.randomInt(-5,5);
        int number_matrix_second_gen = 10;
        remaining_matrices -= number_matrix_second_gen;

        System.out.println("Nombre de matrices second gen : "+number_matrix_second_gen);

        for(int i =0; i!=number_matrix_second_gen; i++)
        {
            Matrix m = createMatrixNotEquals(somme);
            writeMatrix(m);
        }
        real = createMatrixEquals(somme);
        writeMatrix(real);


        //third generation
        for(int i =0; i!=remaining_matrices; i++)
        {
            Matrix m = createMatrixNotEquals(somme);
            writeMatrix(m);
        }


        ic.close();
    }
}
