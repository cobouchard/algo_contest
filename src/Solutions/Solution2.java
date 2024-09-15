package Solutions;

import FileWriting.ReadingCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Solution2
{
    private static final String inputFile="exo2";

    private static class Meuble implements java.lang.Comparable<Meuble>
    {
        String nom;
        double note;
        double duree;
        double prix;
        Double moyenne;

        public Meuble(String nom, double note, double duree, double prix) {
            this.nom = nom;
            this.note = note;
            this.duree = duree;
            this.prix = prix;
            this.moyenne = 0.;
        }

        @Override
        public int compareTo(Meuble o) {
            return moyenne.compareTo(o.moyenne);
        }
    }

    public static void main(String... args)
    {
        ReadingCreator rc = new ReadingCreator(inputFile);
        String line;

        ArrayList<Meuble> meubles = new ArrayList<>();

        String nom;
        double note;
        double duree;
        double prix;

        try
        {
            while ((line = rc.br.readLine()) != null)
            {
                nom = line;
                note = Double.parseDouble(rc.br.readLine());
                duree = Double.parseDouble(rc.br.readLine());
                prix =Double.parseDouble(rc.br.readLine());

                meubles.add(new Meuble(nom,note,duree,prix));

            }
            rc.br.close();

        }catch(Exception e){}

        //calcul de la moyenne

        for(Meuble m : meubles)
        {
            m.moyenne = (m.note*20+m.duree*10+(101-m.prix))/3;
        }
        //Collections.sort(meubles);

        Meuble max = Collections.max(meubles);

        System.out.println(max.nom);

        try {
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
