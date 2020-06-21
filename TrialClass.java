package com.pharma.org;

import java.lang.Math;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TrialClass
{
    private String fileName;
    private int count = 0;
    private int sum = 0;
    private int sumOfSquares = 0;

    public TrialClass(String strToStart)
    {
        fileName = strToStart;
        Scanner input = null;
        try
        {
            input = new Scanner(new File(fileName));
        }
            catch (Exception ex)
            {
                System.out.println("Can not open file.");
                System.exit(0);
            }
        while(input.hasNextInt())
        {
            count++;
            int number = input.nextInt();
            sum += number;
            sumOfSquares += number * number;
        }
    }
    public double getAverage()
    {
        double average;
        average = sum / count;
        return average;
    }
    public double getStandardDeviation()
    {
        double squareOfAverage = getAverage() * getAverage();
        double averageOfSquares = sumOfSquares / count;
        double standardDeviation = Math.sqrt(averageOfSquares - squareOfAverage);
        return standardDeviation;
    }
    public String getFileName()
    {
        return fileName;
    }

    public String stats()
    {
        return getFileName() + ": average = " + getAverage() + ", standard deviation = " + getStandardDeviation();
    }
    public static boolean isStatSignicant(double avg1, double avg2, double deviation1, double deviation2)
    {
        double difference = Math.abs(avg1 - avg2);
        if (difference > deviation1 && difference > deviation2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
