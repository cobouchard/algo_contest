package Exercices;


import FileWriting.InputCreator;
import FileWriting.ReadingCreator;
import fonctions.UsefulFunc;

import java.util.ArrayList;


public abstract class Exercice2 {

    private static final String name="exo2";
    private static final String populationFile="population.txt";

    private static ArrayList<String> names = new ArrayList<>();

    private static void populateNames()
    {
        ReadingCreator rc = new ReadingCreator(populationFile);

        String line;

        try
        {
            while ((line = rc.br.readLine()) != null)
            {
                names.add(line);
            }
            rc.br.close();

        }catch(Exception e){}

    }

    public static void main(String... args)
    {
        populateNames();

        InputCreator ic = new InputCreator(name);

        int size = names.size();

        for(int i=0; i!=size; i++)
        {
            ic.addString(names.get(i)+"\n");
            ic.addString(((Double)UsefulFunc.randomDouble(1,5)).toString()+"\n");
            ic.addString(((Double)UsefulFunc.randomDouble(1,10)).toString()+"\n");
            ic.addString(((Double)UsefulFunc.randomDouble(1,100)).toString()+"\n");
        }

        ic.close();
    }
}
