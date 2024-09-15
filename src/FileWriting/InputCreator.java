package FileWriting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InputCreator
{
    private String fileName="";
    BufferedWriter writer;
    public void addString(String toAdd)
    {
        try
        {
            writer.write(toAdd);
        }
        catch(Exception e){}
    }

    public InputCreator(String file)
    {
        fileName=file;

        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
