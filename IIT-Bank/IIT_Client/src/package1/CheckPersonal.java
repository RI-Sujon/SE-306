package package1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CheckPersonal {
	
    File file1 = new File("personal.txt") ;
    BufferedReader reader = null ;
    BufferedWriter writer = null ;
    ObjectOutputStream writerObj = null ;
    ObjectInputStream readerObj = null ;

    public CheckPersonal() {

    }

    public boolean createCertificate(String name, String roll, String registration, String nameOfFather, String nameOfMother, String dateOfBirth, String result){
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(roll))
            {
                return false ;
            }
        }

        File file = new File("src/resources/" + roll);
        PersonalInfo personal = new PersonalInfo(name,roll,registration,nameOfFather,nameOfMother,dateOfBirth,result);

        try{
            writerObj = new ObjectOutputStream(new FileOutputStream(file)) ;
            writerObj.writeObject(personal);
            writerObj.close();
        }catch(IOException e){
            System.out.println("Exception1 : " + e);
        }

        return true ;
    }
        
    public boolean loginForUpdate(String roll){
            File folder = new File("src/resources/");
            File[] files = folder.listFiles();
            for(File f: files){
                if(f.getName().equals(roll))
                {
                    return true ;
                }
            }
            
            return false ;
        }
        
    public void updateInfo(String roll,String data,int n){
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(roll))
            {
                try {
                    readerObj = new ObjectInputStream(new FileInputStream(f));

                    PersonalInfo personal = (PersonalInfo)readerObj.readObject();
                    
                    readerObj.close();
                    if(n==0){
                        personal.setName(data);
                    }
                    
                    else if(n==1){
                        personal.setNameOfFather(data);
                    }
                    
                    else if(n==2){
                        personal.setNameOfMother(data);
                    }
                    
                    else if(n==3){
                        personal.setDateOfBirth(data);
                    }
                    
                    else if(n==4){
                        personal.setResult(data);
                    }
                    
                    writerObj = new ObjectOutputStream(new FileOutputStream(f)) ;
                    writerObj.writeObject(personal);
                    writerObj.close();
                        
                } catch (FileNotFoundException e) {
                    System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }
            }
        }
    }

    public String printAllInfo(String roll){
        File folder = new File("src/resources/");
        String str = "" ;
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(roll))
            {
                try {
                    readerObj = new ObjectInputStream(new FileInputStream(f));
                    PersonalInfo personal = (PersonalInfo)readerObj.readObject();
                    readerObj.close();
                    str = personal.getName() + "&" + personal.getRoll() + "&" + personal.getRegistration() + "&"+ personal.getNameOfFather()+ "&" + personal.getNameOfMother()
                           + "&" + personal.getDateOfBirth()+ "&" + personal.getResult() ;
                    
                    return str ;
                
                } catch (FileNotFoundException e) {
                System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }
                }
            }
            
            return str;
    }
    
    public int checking(String Name,String Registration,String fName,String mName,String dOb) {
            try {
                    //writer = new BufferedWriter(new FileWriter(file1)) ;
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
