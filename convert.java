import java.io.*;
import java.util.Scanner;

public class convert {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String fileIn = null;
			String fileOut = null;
			String sourceCoding = null;
			String targetCoding = null;
			String data = null;
			int tp = 1;
			FileInputStream fis = null;
			FileOutputStream fos;  
		    OutputStreamWriter osw ;  
		    BufferedWriter bw = null;
		    boolean t = true;
			
		    Scanner in = new Scanner(System.in);
		    while(t){
		    	try{
		    		System.out.println("The name of source file is:");
		    		fileIn = in.nextLine();
		    		fis = new FileInputStream("D:\\Program Files (x86)\\Eclipse\\CCLab1-convert\\src\\"+fileIn);	    
		    		t = false;
		    	}catch(FileNotFoundException e)
		    	{
		    		t = true;
		    		System.out.println("File not found\n");
		    	
		    	}
		    }
		    System.out.println("The name of target file is:");
		    fileOut = in.nextLine();
		    System.out.println("The source coding is:");
		    sourceCoding = in.nextLine();
		    System.out.println("The target coding is:");
		    targetCoding = in.nextLine();
		    
					    
		    //User need to change the path of input file
			InputStreamReader isr = new InputStreamReader(fis,sourceCoding);
			BufferedReader br = new BufferedReader(isr);
			
			fos = new FileOutputStream("D:\\Program Files (x86)\\Eclipse\\CCLab1-convert\\src\\"+fileOut);  
			//User need to change the path of output file
			osw = new OutputStreamWriter(fos, targetCoding);  
			bw = new BufferedWriter(osw); 
			while((data = br.readLine()) != null){				
					
				tp = data.indexOf(sourceCoding);
				if(tp >= 0) data = data.replaceAll(sourceCoding, targetCoding);
				bw.write(data); 
				bw.newLine();
				bw.flush(); 
				
			}
			bw.close();
			br.close();
			
			System.out.println("Finished!");
		}catch(Exception e) {e.printStackTrace();}
	}
}
