//@author Maximiliano De Santiago Galan

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;


public class ProductReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File desiredFile;
        String rec = "";
        ArrayList<String[]> storedData = new ArrayList<String[]>();
        ArrayList<Product> generatedProducts = new ArrayList<Product>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                desiredFile = chooser.getSelectedFile();
                Path file = desiredFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;

                    String[] temp = rec.split(","); //create temporary array storing divided data
                    String costString = temp[3];
                    costString = costString.replaceAll(" ",""); //remove spaces from String to allow conversion to Int
                    Product Temp = new Product(temp[0], temp[1], temp[2], Double.valueOf(temp[3])); //fill a Person object with the read data
                    generatedProducts.add(Temp); //add generated Person to an arrayList
                }
                reader.close();

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(("File not found"));
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println(("File not found"));
            e.printStackTrace();
        }
        int lineCount = 1;

        for(Product People : generatedProducts)
        {
            System.out.println("Line " + lineCount + " " + People.toCSVDataRecord()); //print out people in CSV form
            lineCount ++;
        }
        System.out.println("\n\nData file read!");
    }
}
