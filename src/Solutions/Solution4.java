package Solutions;

import Exercices.Exercice4;
import FileWriting.ReadingCreator;

import java.io.IOException;
import java.util.ArrayList;

import static Exercices.Exercice4.taille_matrice;
import static Exercices.Exercice4.nb_matrice;
import static Exercices.Exercice4.Matrix;

public abstract class Solution4
{
    private static final String inputFile="exo4";

    public static void main(String... args)
    {
        ReadingCreator rc = new ReadingCreator(inputFile);
        String line;

        ArrayList<Matrix> lesMatrices = new ArrayList<>();

        try
        {
            for(int matri=0;matri!=nb_matrice+2;matri++)
            {
                //une matrice par itération
                Matrix temp_matrix = new Matrix();
                for(int ligne = 0; ligne!= taille_matrice; ligne++)
                {
                    //itération sur les lignes
                    String current = rc.br.readLine();
                    int position = 0;
                    for(int colonne = 0; colonne!= taille_matrice; colonne++)
                    {
                        //itération sur les nombres
                        String number="";
                        for(char c = current.charAt(position);c!=',';position++, c= current.charAt(position))
                        {
                            number = number + Character.toString(c);
                        }
                        position++;
                        Double num = Double.parseDouble(number);

                        temp_matrix.matrice[ligne][colonne]=num;
                        //System.out.println(ligne+","+colonne+" : "+num);
                    }
                }
                lesMatrices.add(temp_matrix);

                //System.out.println();

                //on enlève la ligne vide
                rc.br.readLine();
            }
            rc.br.close();

            ArrayList<Integer> list_of_sums = new ArrayList<>();

            //naturalisation des matrices
            for(Matrix m : lesMatrices)
            {
                while(!m.everyRound())
                {
                    m.multiplyBy(10);
                }

                while(m.divisableBy(2))
                    m.divideBy(2);

                while(m.divisableBy(5))
                    m.divideBy(5);

                m.calculateSum();
                m.affiche();
                list_of_sums.add(m.somme);
                System.out.println();
            }

            //trouver les deux matrices avec la même somme et ajouter faire la combinaison linéaire de leurs coefficients diagonaux
            int position1 = 0;
            int position2 = 0;
            for(int i =0; i!= list_of_sums.size(); i++)
            {
                for(int k =0; k!= list_of_sums.size(); k++)
                {
                    if(k!=i)
                    {
                        if(list_of_sums.get(i)==list_of_sums.get(k))
                        {
                            position1=i;
                            position2=k;
                        }
                    }
                }
            }

            System.out.println("Position 1 : " + position1);
            System.out.println("Position 1 : " + position2);

            Matrix m1 = lesMatrices.get(position1);
            Matrix m2 = lesMatrices.get(position2);

            int resultat = 0;

            for(int i=0; i!= taille_matrice; i++)
            {
                for(int j=0; j!= taille_matrice; j++)
                {
                    resultat += m1.matrice[i][j] * m2.matrice[i][j];
                }
            }

            System.out.println("Le résultat est : " + resultat);


        }catch(Exception e){}

        try {
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
