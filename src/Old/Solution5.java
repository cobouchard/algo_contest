package Old;

import FileWriting.ReadingCreator;

import java.io.IOException;

public abstract class Solution5
{
    private static final String inputFile="exo5";

    public static void main(String... args)
    {
        ReadingCreator rc = new ReadingCreator(inputFile);
        String line;


        try {
            rc.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
