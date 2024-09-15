package FileWriting;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class ReadingCreator
{
    public BufferedReader br;

    public ReadingCreator(String input)
    {
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(fstream));
    }
}
