package fonctions;

public class PuissanceTableau
{
    public int tailleX;
    public int tailleY;
    public short[][] matrix;

    public PuissanceTableau(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        matrix = new short[this.tailleX][this.tailleY];
    }

    public boolean posePion(int x, int y, short couleur)
    {
        boolean test=false;
        int realY = tailleY-y-1;
        if(matrix[x][y]==0)
        {
            test=true;
            matrix[x][y]=couleur;
        }

        return test;

    }

    public boolean pionPuissance4(int x, int y, short couleur)
    {
        boolean test = false;

        //vérification horizontale

        {

            int compteur = 0;
            int temp_x_start=x-4;
            int temp_x_end=x+4;

            for (int i = temp_x_start; i != temp_x_end; i++) {
                try
                {
                    if (matrix[i][y] == couleur) {
                        compteur++;
                        if (compteur == 4)
                        {
                            //System.out.println("horizontal");
                            return true;
                        }

                    } else {
                        compteur = 0;
                    }
                }catch(ArrayIndexOutOfBoundsException e)
                {

                }

            }
        }
        //vérification verticale
        {

            int compteur = 0;
            int temp_y_start=y-4;
            int temp_y_end=y+4;

            for (int i = temp_y_start; i < temp_y_end; i++) {
                try
                {

                    if (matrix[x][i] == couleur) {
                        compteur++;
                        if (compteur == 4)
                        {
                            //System.out.println("verticale");
                            return true;
                        }

                    } else {
                        compteur = 0;
                    }
                }catch(ArrayIndexOutOfBoundsException e)
                {

                }

            }
        }

        //vérification diagonale (haut gauche vers bas droit)
        {
            int temp_x_start=x-4;
            int temp_x_end=x+4;

            int temp_y_start=y+4;
            int temp_y_end=y-4;

            int compteur=0;



            for (int x_ = temp_x_start, y_ = temp_y_start; x_ != temp_x_end; x_++, y_--)
            {
                try
                {
                    if (matrix[x_][y_] == couleur) {
                        compteur++;
                        if (compteur == 4)
                        {
                            //System.out.println("diagonale HG -> BD ");
                            return true;
                        }

                    } else {
                        compteur = 0;
                    }
                }catch(ArrayIndexOutOfBoundsException e)
                {

                }
            }
        }

        //vérification diagonale (bas gauche vers haut droit)
        {
            int temp_x_start=x-4;
            int temp_x_end=x+4;

            int temp_y_start=y-4;
            int temp_y_end=y+4;

            int compteur=0;

            for (int x_ = temp_x_start, y_ = temp_y_start; x_ != temp_x_end ; x_++, y_++)
            {
                try
                {
                    if (matrix[x_][y_] == couleur) {
                        compteur++;
                        if (compteur == 4)
                        {
                            //System.out.println("diagonale BG -> HD");
                            return true;

                        }

                    } else {
                        compteur = 0;
                    }
                }catch(ArrayIndexOutOfBoundsException e)
                {

                }
            }
        }
        return test;
    }

    public int gravite(int x, short couleur)
    {
        for(int y=0; y!=tailleY; y++)
        {
            if(posePion(x,y,couleur))
            {
                return y;
            }
        }

        return -1;
    }

    public void afficheMatrix()
    {
        for(int i=0; i!=tailleY;i++)
        {
            for(int k=0; k!=tailleX;k++)
                System.out.print(matrix[k][tailleY-i-1]);
            System.out.println();
        }

    }

    public static void main(String... args)
    {
        PuissanceTableau t = new PuissanceTableau(5,7);

        //BG -> HD
        /*
        t.posePion(0,0, (short) 1);
        t.posePion(1,1, (short) 1);
        t.posePion(2,2, (short) 1);
        t.posePion(3,3, (short) 1);

        t.pionPuissance4(1,1,(short)1);
        */

        //HG -> BD

        t.posePion(4,0, (short) 1);
        t.posePion(3,1, (short) 1);
        t.posePion(2,2, (short) 1);
        t.posePion(1,3, (short) 1);

        t.pionPuissance4(4,0,(short)1);


        /*

        t.posePion(1,0, (short) 1);
        t.posePion(1,1, (short) 1);
        t.posePion(1,2, (short) 1);
        t.posePion(1,3, (short) 1);


        t.posePion(1,0, (short) 1);
        t.posePion(2,0, (short) 1);
        t.posePion(3,0, (short) 1);
        t.posePion(4,0, (short) 1);

        System.out.println(t.pionPuissance4(1,0,(short)1));
        System.out.println(t.pionPuissance4(1,1,(short)1));
        System.out.println(t.pionPuissance4(1,2,(short)1));
        System.out.println(t.pionPuissance4(1,3,(short)1));
        */

        t.afficheMatrix();
    }
}
