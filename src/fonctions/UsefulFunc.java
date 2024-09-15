package fonctions;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class UsefulFunc
{

    public static int randomInt(int start, int end)
    {
        return ThreadLocalRandom.current().nextInt(start, end);
    }

    public static int randomInt(int start, int end, int parite)
    {
        int n;
        do {
            n=ThreadLocalRandom.current().nextInt(start, end);
        }while(n%2!=parite);
        return n;
    }

    public static double randomDouble(double start, double end)
    {
        return ThreadLocalRandom.current().nextDouble(start, end);
    }

    public static boolean randomBool()
    {
        return ThreadLocalRandom.current().nextInt()%2==0;
    }

    public static int randomPrime(int start, int end)
    {
        int n;
        do {
            n=ThreadLocalRandom.current().nextInt(start, end );
        }while(!isPrime(n));
        return n;
    }

    public static int randomNonPrime(int start, int end)
    {
        int n;
        do {
            n=ThreadLocalRandom.current().nextInt(start, end );
        }while(isPrime(n));
        return n;
    }


    public static ArrayList<Integer> primes = new ArrayList<>();

    public static void generatePrimes(int taille)
    {
        for(int nombre=2; nombre!=taille; nombre++)
        {
            if(isPrime(nombre))
                primes.add(nombre);
        }
    }

    public static int getDeficiency(int n)
    {
        int somme =0;


        for(int i=1; i!= n+1; i++)
        {
            if(n%i==0)
                somme+=i;
        }

        return 2*n-(somme);
    }


    public static boolean isPrime(int nombre)
    {
        for(Integer i : primes)
        {
            if(nombre%i==0 && nombre!=i)
                return false;
        }

        return true;
    }

    public static boolean isParity(int n, int parity)
    {
        return n%2==parity;
    }

    public static boolean isRound(double n)
    {
        return n==Math.round(n);
    }



}
