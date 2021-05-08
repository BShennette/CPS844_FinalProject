import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class GradeToNominal
{
	private static ArrayList<String[]> data;
	
	public static void main (String[] args)
    {
		if(args.length != 1)
		{
			System.out.println("Invalid arguments. Expected 1 argument: filename (no extension) of .csv file");
			System.exit(1);
		}
		data = new ArrayList<String[]>();
		
		//get the filename from teh commandline
		String filename = args[0];
		
		//read the file, store data in ArrayList<String[]>
		readData(filename+".arff");
		
		//write two files, with different discretizations
		writeData_2(filename, data);
		writeData_5(filename, data);
    }
	
	private static void readData(String filename)
    {		
		try{
			//Read the input file and convert to 2d array
			File inFile = new File(filename);
			
			
			if (inFile.isFile()) {
				boolean isData = false;
				
				// create BufferedReader and read data from csv
				BufferedReader csvReader = new BufferedReader(new FileReader(filename));
				String row;
				while ((row = csvReader.readLine()) != null) {
					
					String[] tmp = row.split(",");
					
					if(isData)
					{
						data.add(tmp);
					}
					else
					{
						if (row.toLowerCase().equals("@data"))
						{
							isData = true;
						}
					}
				}

				//finally, close the reader
				csvReader.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.exit(1);
		}
    }
	
	private static void writeData_2(String filename, ArrayList<String[]> data)
	{
		String head = "@relation " + filename + "_2\n\n"
				+ "@attribute school {GP,MS}\n"
				+ "@attribute sex {M,F}\n"
				+ "@attribute age INTEGER\n"
				+ "@attribute address {U,R}\n"
				+ "@attribute famsize {LE3,GT3}\n"
				+ "@attribute Pstatus {T,A}\n"
				+ "@attribute Medu INTEGER\n"
				+ "@attribute Fedu INTEGER\n"
				+ "@attribute Mjob {teacher,health,services,at_home,other}\n"
				+ "@attribute Fjob {teacher,health,services,at_home,other}\n"
				+ "@attribute reason {home,reputation,course,other}\n"
				+ "@attribute guardian {mother,father,other}\n"
				+ "@attribute traveltime INTEGER\n"
				+ "@attribute studytime INTEGER\n"
				+ "@attribute failures INTEGER\n"
				+ "@attribute schoolsup {yes,no}\n"
				+ "@attribute famsup {yes,no}\n"
				+ "@attribute paid {yes, no}\n"
				+ "@attribute activities {yes, no}\n"
				+ "@attribute nursery {yes, no}\n"
				+ "@attribute higher {yes, no}\n"
				+ "@attribute internet {yes, no}\n"
				+ "@attribute romantic {yes, no}\n"
				+ "@attribute famrel INTEGER\n"
				+ "@attribute freetime INTEGER\n"
				+ "@attribute goout INTEGER\n"
				+ "@attribute Dalc INTEGER\n"
				+ "@attribute Walc INTEGER\n"
				+ "@attribute health INTEGER\n"
				+ "@attribute absences INTEGER\n"
				+ "@attribute G3 {fail,pass}\n\n"
				+ "@data\n";
		
		BufferedWriter bw = null;
		try {
			 //Specify the file name and path here
			File file = new File(filename+"_2.arff");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			//put the .arff head data into the file
			bw.write(head);
			
			//write the data
			for (String[] row : data)
			{
				//so we don't overwrite the original
				String[] tmp = Arrays.copyOf(row,row.length);
				
				//convert last index (i.e. G3, the final student grade) from number to nominal
				//x<=10 = fail ; 10<x = pass
				int val = Integer.parseInt(tmp[tmp.length-1]);
				if(val<=10)
					tmp[tmp.length-1] = "fail";
				else
					tmp[tmp.length-1] = "pass";
				
				//write into the file
				bw.write(Arrays.toString(tmp).replace(" ", "").replace("[", "").replace("]", "\n"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		finally
		{
			//cleanup
			try {
				if(bw!=null)
					bw.close();
			} catch(Exception e) {
				System.out.println("Error closing writer.");
			}
		}
		

	}
	
	private static void writeData_5(String filename, ArrayList<String[]> data)
	{
		String head = "@relation " + filename + "_5\n\n"
				+ "@attribute school {GP,MS}\n"
				+ "@attribute sex {M,F}\n"
				+ "@attribute age INTEGER\n"
				+ "@attribute address {U,R}\n"
				+ "@attribute famsize {LE3,GT3}\n"
				+ "@attribute Pstatus {T,A}\n"
				+ "@attribute Medu INTEGER\n"
				+ "@attribute Fedu INTEGER\n"
				+ "@attribute Mjob {teacher,health,services,at_home,other}\n"
				+ "@attribute Fjob {teacher,health,services,at_home,other}\n"
				+ "@attribute reason {home,reputation,course,other}\n"
				+ "@attribute guardian {mother,father,other}\n"
				+ "@attribute traveltime INTEGER\n"
				+ "@attribute studytime INTEGER\n"
				+ "@attribute failures INTEGER\n"
				+ "@attribute schoolsup {yes,no}\n"
				+ "@attribute famsup {yes,no}\n"
				+ "@attribute paid {yes, no}\n"
				+ "@attribute activities {yes, no}\n"
				+ "@attribute nursery {yes, no}\n"
				+ "@attribute higher {yes, no}\n"
				+ "@attribute internet {yes, no}\n"
				+ "@attribute romantic {yes, no}\n"
				+ "@attribute famrel INTEGER\n"
				+ "@attribute freetime INTEGER\n"
				+ "@attribute goout INTEGER\n"
				+ "@attribute Dalc INTEGER\n"
				+ "@attribute Walc INTEGER\n"
				+ "@attribute health INTEGER\n"
				+ "@attribute absences INTEGER\n"
				+ "@attribute G3 {F,D,C,B,A}\n\n"
				+ "@data\n";
		
		BufferedWriter bw = null;
		try {
			 //Specify the file name and path here
			File file = new File(filename+"_5.arff");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			//put the .arff head data into the file
			bw.write(head);
			
			//write the data
			for (String[] row : data)
			{
				//so we don't overwrite the original
				String[] tmp = Arrays.copyOf(row,row.length);
				
				//convert last index (i.e. G3, the final student grade) from number to nominal
				//Grades consistent with Ryerson grading range
				int val = Integer.parseInt(tmp[tmp.length-1]);
				if(val<10)
					tmp[tmp.length-1] = "F";
				else if(val<12)
					tmp[tmp.length-1] = "D";
				else if(val<14)
					tmp[tmp.length-1] = "C";
				else if(val<16)
					tmp[tmp.length-1] = "B";
				else if(val<=20)
					tmp[tmp.length-1] = "A";
				//write into the file
				bw.write(Arrays.toString(tmp).replace(" ", "").replace("[", "").replace("]", "\n"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		finally
		{
			//cleanup
			try {
				if(bw!=null)
					bw.close();
			} catch(Exception e) {
				System.out.println("Error closing writer.");
			}
		}
	}
}