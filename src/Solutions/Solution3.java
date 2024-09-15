package Solutions;

import FileWriting.ReadingCreator;
import fonctions.UsefulFunc;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Solution3
{
    private static final String inputFile="exo3";

    public static void main(String... args)
    {

        UsefulFunc.generatePrimes(10000);

        ReadingCreator rc = new ReadingCreator(inputFile);

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

        int reponse=0;

        for(Integer i : nombres)
        {
            int def = UsefulFunc.getDeficiency(i);
            if(def>0)
            {
                reponse+=def;
            }
        }

        System.out.println(reponse);

        try {
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
