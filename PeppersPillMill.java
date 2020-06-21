package com.pharma.org;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PeppersPillMill
{
    public static void main(String[] args)
    {
        TrialClass[] dataFile = new TrialClass[3];
        for(int i = 0; i <= 2; i++)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("What is the name of the file?");
            String stringToStart = input.nextLine();
            System.out.println("You entered " + stringToStart + ".");
            dataFile[i] = new TrialClass(stringToStart);
        }
        
        boolean result1 = TrialClass.isStatSignicant(dataFile[0].getAverage(), dataFile[1].getAverage(), dataFile[0].getStandardDeviation(), dataFile[1].getStandardDeviation());
        boolean result2 = TrialClass.isStatSignicant(dataFile[0].getAverage(), dataFile[2].getAverage(), dataFile[0].getStandardDeviation(), dataFile[2].getStandardDeviation());
        boolean result3 = TrialClass.isStatSignicant(dataFile[1].getAverage(), dataFile[2].getAverage(), dataFile[1].getStandardDeviation(), dataFile[2].getStandardDeviation());
        
        System.out.println("Name for the outpile file: ");
        Scanner output = new Scanner(System.in);
        String stringToEnd = output.nextLine();
        System.out.println("You entered " + stringToEnd + ".");

        File file = new File(stringToEnd);
        boolean result;
        try
        {
            result = file.createNewFile();
            if (result)
            {
                System.out.println("File created." + file.getCanonicalPath());
            }
            else
            {
                System.out.println("It may not have worked.");
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Statistics: \n" + dataFile[0].stats() + "\n" + dataFile[1].stats() + "\n" + dataFile[2].stats() + "\n");
            bw.write("Results: \n" + dataFile[0].getFileName() + " vs. " + dataFile[1].getFileName() + " : " + result1 + "\n");
            bw.write(dataFile[0].getFileName() + " vs. " + dataFile[2].getFileName() + " : " + result2 + "\n");
            bw.write(dataFile[1].getFileName() + " vs. " + dataFile[2].getFileName() + " : " + result3 + "\n");
            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }
}
