package Old;

import Exercices.Exercice6;
import FileWriting.InputCreator;
import fonctions.PuissanceTableau;
import fonctions.UsefulFunc;

public abstract class Exercice5
{
    private static final int tailleX = 7;
    private static final int tailleY = 6;
    private static final String name = "exo5";
    private static final int nbCoup = 30;

    private static InputCreator ic;
    public static void main(String... args)
    {
        ic = new InputCreator(name);

        PuissanceTableau tab = new PuissanceTableau(tailleX,tailleY);

        short couleur = 1;

        for(int i=0; i!=nbCoup; i++)
        {
            int posX = UsefulFunc.randomInt(0,tab.tailleX-1);

            int posY = tab.gravite(posX,(short)(couleur+1));

            if(posY!=-1 && tab.pionPuissance4(posX,posY,(short)(couleur+1)))
            {
                tab.matrix[posX][posY]=0;
                i--;
            }


            couleur = (short)((couleur+1)%2);
        }


        Exercice6.writeMatrix(tab,ic);
        ic.close();
    }
}
