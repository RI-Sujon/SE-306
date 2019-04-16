package Package1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CheckPersonal {
	
	File file1 = new File("personal.txt") ;
	BufferedReader reader = null ;
	
	public CheckPersonal() {
		
	}
	
	public int checking(String Name,String Registration,String fName,String mName,String dOb) {
		try {
			reader = new BufferedReader(new FileReader(file1)) ;
			String str;
			int check = 0 ;
			while((str=reader.readLine())!=null ){
				String s = ""  ;
                for(int i=0 ; i<str.length() ;i++) {
                	if(str.charAt(i)!=' ') {
                		s = s + str.charAt(i) ;
                	}
                	//System.out.println("Name Ok: " + s);
                	if(str.charAt(i)==' ' || i==str.length()-1 ) {
                		System.out.println("Name: " + s);
                		if(Registration.equals(s) && check==0) {
                			//System.out.println("Name Okkkkkk: " + s);
                	
                			check++ ;
                		}
                		
                		else if(Name.equals(s) && check == 1) {
                			//System.out.println("Name Ok: " + s);
                		
                			check++ ;
                		
                		}
                		
                		else if(fName.equals(s) && check == 2) {
                			//System.out.println("Name Ok: " + s);
                			
                			check++ ;
                		
                		}
                		
                		else if(mName.equals(s) && check == 3 ) {
                			//System.out.println("Name Ok: "+ s);
                			
                			check++ ;
                		}
                		
                		else if(dOb.equals(s)&& check == 4) {
                			System.out.println("Name Okffff: " + s);
                		
                			check++ ;
                			reader.close();
                			return 1 ;
                		}
                		
                		else if(check==0){
                			break ;
                		}
                		
                		else {
                			reader.close();
                			return -1 ;
                		}
                		
                		s = "" ;
                	}
                	
                }
            }
            reader.close();
		}catch(IOException e){
			System.out.println("Ex:" + e);
		}
		
		return -1 ;
	}
	
}
