package package1;

import java.io.*;

public class Account {
    
    ObjectOutputStream writer = null ;
    ObjectInputStream reader = null ;

    public boolean createAccount(String name,String accNumber ,String password )
    {
        File file = new File("src/resources/" + accNumber);
        User user = new User(name,accNumber,password);

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
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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

                    if(user.getBalance()>=ammount){
                        user.setBalance(user.getBalance()-ammount);
                    }

                   writer = new ObjectOutputStream(new FileOutputStream(f)) ;
                   writer.writeObject(user);

                    reader.close();
                    writer.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
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
