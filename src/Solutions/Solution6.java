package Solutions;

import Exercices.Exercice6;
import FileWriting.InputCreator;
import FileWriting.ReadingCreator;
import fonctions.PuissanceTableau;

import java.io.IOException;

public abstract class Solution6
{
    private static final String inputFile="exo6";

    private static InputCreator ic;

    public static void main(String... args)
    {
        long startTime = System.currentTimeMillis();


        ReadingCreator rc = new ReadingCreator(inputFile);
        String line;

        PuissanceTableau tab = new PuissanceTableau(Exercice6.taille,Exercice6.taille);
        try {
            for(int ligne=0;ligne!=Exercice6.taille;ligne++)
            {
                String line_str =  rc.br.readLine();

                //on parcours la ligne et on prend tout les caractères pair, correspondants aux nombres du tableau
                for(int position=0;;position+=2)
                {
                    try
                    {
                        char c = line_str.charAt(position);
                        short num = (short)Character.getNumericValue(c);
                        tab.matrix[ligne][position/2]=num;
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        break;
                    }
                }
            }
            /*en réalité on récupère la transposée de la matrice originale
                mais cela n'a pas d'importance puisque le nombre de puissance 4 possibles restera identique
            */

            //maintenant que le tableau est rempli on peut compter le nombre de jetons à placer
            int result = 0;

            for(int ligne=0;ligne!=Exercice6.taille;ligne++)
                for(int colonne=0;colonne!=Exercice6.taille;colonne++)
                {
                    if(tab.matrix[ligne][colonne]==0)
                    {
                        tab.matrix[ligne][colonne]=1;
                        if(tab.pionPuissance4(ligne,colonne, (short) 1))
                        {
                            result++;
                            tab.matrix[ligne][colonne]=3;
                        }
                        else
                            tab.matrix[ligne][colonne]=2;
                    }
                }

            System.out.println(result);
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        System.out.println("Temps d'éxécution :");
        System.out.print(stopTime - startTime);
    }
}
