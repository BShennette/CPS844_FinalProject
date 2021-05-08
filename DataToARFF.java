import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Arrays;

public class DataToARFF
{
    public String[] attributes;
    public String[][] data;

    public static void main (String[] args)
    {

    }

    private void readData(String filename)
    {
        ArrayList<String[]> list = new ArrayList<String[]>();	// list to store the incoming data
		try{
			//Read the input file and convert to 2d array
			File inFile = new File(filename);

			if (inFile.isFile()) {
				// create BufferedReader and read data from csv
				BufferedReader csvReader = new BufferedReader(new FileReader(filename));
				String row;
				while ((row = csvReader.readLine()) != null) {
					String[] data = row.split(",");
					int[] tmp = new int[3];

					//convert String[] to int[]
					for(int i=0; i<3; i++)
					{
						tmp[i] = Integer.parseInt(data[i]);
					}
					
					//add the int[] to the ArrayList
					list.add(tmp);
				}

				//finally, close the reader
				csvReader.close();
			}
		}
		catch(Exception e)
		{
			System.out.println("Failed to parse file. Please check file format.");
			System.exit(1);
		}
    }

    private void writeARFF()
    {

    }
}