//@author Maximiliano De Santiago Galan

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class ProductGenerator
{
    public static void main(String[] args) {
        String ID;
        String name;
        String description;
        Double cost;

        String fileName;
        Scanner fileNameInput = new Scanner(System.in);
        fileName = SafeInput.getNonZeroLenString(fileNameInput, "Input Desired File Name (Don't include .txt)");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\" + fileName + ".txt");

        boolean adding;

        ArrayList<Product> products = new ArrayList<Product>();
        adding = true;

        //Get input from user
        while(adding)
        {
            //get Safeinput from user for each field in Product
            Scanner IDNumInput = new Scanner(System.in);
            ID = SafeInput.getNonZeroLenString(IDNumInput, "ID");
            Scanner nameInput = new Scanner(System.in);
            name = SafeInput.getNonZeroLenString(nameInput, "Product Name");
            Scanner descriptionInput = new Scanner(System.in);
            description = SafeInput.getNonZeroLenString(descriptionInput, "Product Description");
            Scanner costInput = new Scanner(System.in);
            cost = SafeInput.getDouble(costInput, "Cost");
            //creates a temporary Product with input data
            Product holder = new Product(ID, name, description, cost);
            //add temp product to arraylist
            products.add(holder);
            //Ask user if they wish to enter another Product
            Scanner continueInput = new Scanner(System.in);
            adding = SafeInput.getYNConfirm(continueInput, "Add Another Product? (Y or N)");
        }
        int counter = 0;
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Product product : products)
            {
                writer.write(product.toCSVDataRecord(), 0, product.toCSVDataRecord().length());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
