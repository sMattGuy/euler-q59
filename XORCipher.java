import java.io.*;
import java.util.Scanner;

public class XORCipher{
	public static void main(String args[])throws IOException{
		File input = new File(args[0]);
		PrintStream output = new PrintStream(new FileOutputStream("output.txt",true));
		System.setOut(output);
		int[] currentKey = {97,97,97};
		int index = 0;
		quickSolve(input);
		//brute force finder tries all combinations of key
		//uncomment to use
		/*
		while(currentKey[0]!=123){
			System.out.println("Current Key:"+currentKey[0]+""+currentKey[1]+""+currentKey[2]);
			Scanner scan = new Scanner(input).useDelimiter(",");
			while(scan.hasNextInt()){
				int encryptedNum = scan.nextInt();
				int xorNumber = encryptedNum ^ currentKey[index];
				System.out.print(Character.toString((char)xorNumber));
				index++;
				index = index % 3;
			}
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			scan.close();
			currentKey[2]++;
			if(currentKey[2] == 123){
				currentKey[2] = 97;
				currentKey[1]++;
				if(currentKey[1] == 123){
					currentKey[1] = 97;
					currentKey[0]++;
				}
			}
		}
		*/
	}
	static void quickSolve(File input)throws IOException{
		Scanner scan = new Scanner(input).useDelimiter(",");
		int index = 0;
		int[] currentKey = {101,120,112};
		int total = 0;
		while(scan.hasNextInt()){
			int encryptedNum = scan.nextInt();
			int xorNumber = encryptedNum ^ currentKey[index];
			total = total + xorNumber;
			index++;
			index = index % 3;
		}
		System.out.println(total);
		scan.close();
	}
}