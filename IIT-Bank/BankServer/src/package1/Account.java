package package1;

import java.io.*;

public class Account {
    
    ObjectOutputStream writer = null ;
    ObjectInputStream reader = null ;

    public boolean passwordChecking(String password){
        
        if(password.length()>=8&&password.length()<=15){
            int n=-1 ,flag1=-1 ,flag2=-1,flag3=-1 ;
            for(int i=0 ; i<password.length() ; i++){
                n = password.charAt(i) ;
                if(n>=65&&n<=90 || n>=97&&n<=122){
                    flag1 = 1 ;
                }
                
                else if(n>=48&&n<=57){
                    flag2 = 1 ;
                }
                
                else flag3 = 1 ;
            }
            
            if(flag1==1&&flag2==1&&flag3==1){
                return true ;
            }
        }
        
        return false ;
    }
    
    public boolean createAccount(String name,String accNumber ,String password )
    {
        File file = new File("src/resources/" + accNumber);
        User user = new User(name,accNumber,password);
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accNumber))
            {
                return false ;
            }
        
        }
        try{
            writer = new ObjectOutputStream(new FileOutputStream(file)) ;
            writer.writeObject(user);
            writer.close();
        }catch(IOException e){
            System.out.println("Exception1 : " + e);
        }

        return true;
    }

    public boolean login(String accountNumber, String password)
    {
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountNumber))
            {
                try {
                    reader = new ObjectInputStream(new FileInputStream(f));

                    User user = (User)reader.readObject();
                    
                    reader.close();
                    if(user.getPassword().equals(password)){
                        System.out.println(user.getName());
                        return true;
                    }
                        
                    else
                        return false;


                } catch (FileNotFoundException e) {
                    System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }
            }
        }

        return false;
    }
    
    public boolean deposit(String tmpAmmount, String accountNumber)
    {
        double ammount = Double.parseDouble(tmpAmmount);

        if(ammount<0)
            return false;


        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountNumber))
            {
                try {
                    reader = new ObjectInputStream(new FileInputStream(f));

                    User user = (User)reader.readObject();

                    user.setBalance(user.getBalance()+ammount);
                    System.out.println("balance:" + user.getBalance());

                   writer = new ObjectOutputStream(new FileOutputStream(f)) ;
                   writer.writeObject(user);

                    reader.close();
                    writer.close();


                } catch (FileNotFoundException e) {
                    System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }

                return true;
            }
        }

        return false;

    }
    

    public boolean withdraw(String tmpAmmount, String accountNumber)
    {
        double ammount = Double.parseDouble(tmpAmmount);

        if(ammount<0)
            return false;


        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountNumber))
            {
                try {
                    reader = new ObjectInputStream(new FileInputStream(f));

                    User user = (User)reader.readObject();
                    
                    reader.close();
                    

                    if(user.getBalance()>=ammount){
                        user.setBalance(user.getBalance()-ammount);
                    }
                    
                    else{
                        return false ;
                    }

                    writer = new ObjectOutputStream(new FileOutputStream(f)) ;
                    writer.writeObject(user);

                    
                    writer.close();


                } catch (FileNotFoundException e) {
                    System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }

                return true;
            }
        }

        return false;

    }
    
    public String allInfo(String accountNumber){
        
        File folder = new File("src/resources/");
        File[] files = folder.listFiles();
        for(File f: files){
            if(f.getName().equals(accountNumber))
            {
                try {
                    reader = new ObjectInputStream(new FileInputStream(f));

                    User user = (User)reader.readObject();
                    reader.close();
                    return user.getName() + "&" + user.getAccountNumber() + "&" + user.getBalance() ;
        
                } catch (FileNotFoundException e) {
                    System.out.println("Ex1:" + e);
                } catch (IOException e) {
                    System.out.println("Ex2:" + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Ex3:" + e);
                }
            }
        }
        return "";
    }

    /*public boolean transferBalance(String from, String to, String tmpAmmount) throws IOException, ClassNotFoundException {
        File fromFile = null, toFile = null;
        double ammount = Double.parseDouble(tmpAmmount);

        if(ammount<=0)
            return false;

        File folder = new File("src/resources/");
        File[] files = folder.listFiles();

        for(File f: files)
        {
            if(f.getName().equals(from))
                fromFile = f;
            else if(f.getName().equals(to))
                toFile = f;
        }

        if(fromFile == null || toFile == null)
            return false;

        FileInputStream finFromFile = new FileInputStream(fromFile);
        ObjectInputStream objectInputStreamFromFile = new ObjectInputStream(finFromFile);

        User fromUser = (User) objectInputStreamFromFile.readObject();

        if(ammount >= fromUser.getBalance())
            return false;

        finFromFile.close();
        objectInputStreamFromFile.close();

        withdraw(tmpAmmount, from);
        deposit(tmpAmmount, to);

        return true;
    }*/

}
