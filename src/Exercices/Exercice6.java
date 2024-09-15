package Exercices;

import FileWriting.InputCreator;
import fonctions.PuissanceTableau;
import fonctions.UsefulFunc;

public abstract class Exercice6
{
    public static final int taille = 500;

    private static final int nbRouge = 75000;

    private static final String name = "exo6";

    private static InputCreator ic;

    public static void writeMatrix(PuissanceTableau tab, InputCreator writer)
    {
        for(int i=0; i!=tab.tailleY;i++)
        {
            for(int k=0; k!=tab.tailleX;k++)
            {
                Short temp = tab.matrix[k][tab.tailleY-i-1];
                writer.addString(temp.toString()+",");
            }
            writer.addString("\n");
        }
    }

    public static void main(String... args) {
        ic = new InputCreator(name);

        PuissanceTableau tab = new PuissanceTableau(taille,taille);

        for(int i=0; i!=nbRouge; i++)
        {
            int posX = UsefulFunc.randomInt(0,taille-1);
            int posY = UsefulFunc.randomInt(0,taille-1);

            if(tab.matrix[posX][posY]==0)
            {
                tab.matrix[posX][posY]=1;
                if(tab.pionPuissance4(posX,posY,(short)1))
                {
                    tab.matrix[posX][posY]=0;
                    i--;
                }
            }
            else
            {
                i--;
            }
        }

        writeMatrix(tab,ic);
        ic.close();

    }

}