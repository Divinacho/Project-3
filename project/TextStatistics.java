/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
/**
 *
 * @author Divyanshu Tripathy
 */
public class TextStatistics implements TextStatisticsInterface
{
    private File textFile;
    private Scanner fileScan;
    private int lineCount, wordCount;
    private final String DELIMETERS = ",.;:'\\\"&!?-_\\n\\t12345678910[]{}()@#$\n%^*/+-";
    private StringTokenizer tokenizer;
    public int getLineCount()
    {
        return lineCount;
    }
    public TextStatistics(File file)
    {
        textFile = file;
        try
        {
            fileScan = new Scanner(textFile);
            while(fileScan.hasNextLine())
            {
                //fileScan.nextLine();
                String str = fileScan.nextLine();
                int charCount =+ str.length(); 
                lineCount++;
                tokenizer = new StringTokenizer(fileScan.nextLine(), DELIMETERS);
                while(tokenizer.hasMoreTokens())
                {
                    tokenizer.nextToken();
                    wordCount++;
                }
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File cannot be located");
        }
    }
    @Override
    public int getWordCount()
    {
        return wordCount;
    }
    
    
}
