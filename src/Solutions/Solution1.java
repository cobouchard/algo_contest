package Solutions;

import FileWriting.ReadingCreator;
import fonctions.UsefulFunc;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Solution1
{
    private static final String inputFile="exo1";

    public static void main(String... args)
    {
        ReadingCreator rc = new ReadingCreator(inputFile);

        UsefulFunc.generatePrimes(10000);

        ArrayList<Integer> nombres = new ArrayList<>();

        String line;

        try
        {
            while ((line = rc.br.readLine()) != null)
            {
                nombres.add(Integer.parseInt(line));
            }
            rc.br.close();

        }catch(Exception e){}


        for(int i=0;i!=nombres.size();i++)
        {
            try
            {
                if(UsefulFunc.isParity(nombres.get(i+1),1))
                {
                    //le nombre de droite est impair
                    int candidat = nombres.get(i);
                    if(UsefulFunc.isPrime(candidat))
                    {
                        //le nombre candidat est premier
                        if(UsefulFunc.isPrime(nombres.get(i-4)) || UsefulFunc.isPrime(nombres.get(i+4)))
                        {
                            System.out.println("L'intrus a été trouvé c'est : " + candidat + " il est en position : " + i+1 + ".");
                        }
                    }
                }
            }catch(IndexOutOfBoundsException e){}




        }

        try {
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
