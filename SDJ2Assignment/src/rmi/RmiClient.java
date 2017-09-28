package rmi;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class RmiClient implements Serializable
{
   private ServerInterface server;

   public RmiClient() throws RemoteException
   {
      super();
      try
      {
         server = (ServerInterface) Naming
               .lookup("rmi://localhost:1099/toUpperCase");   
         System.out.println("server connected");
         Scanner input= new Scanner(System.in);
         boolean check=false;
         while (!check){
         System.out.println("Choose: \n1.Add string\n2.Remove string\n3.Get all Strings\n4.Terminate");
         String string="";
         int choice= input.nextInt();
         input.nextLine();
         switch (choice){
         case 1: System.out.println("Write the string: ");
         			string= input.nextLine();
         			server.add(string,this);
         			break;
         case 2: System.out.println("Write the string: ");
			string= input.nextLine();
			System.out.println("The string " + server.remove(string,this)+" was removed.");
			break;	
         case 3: System.out.println("The strings are: ");
			ArrayList<String> strings= server.getAllStrings(); 
			System.out.println("nr of strings "+strings.size());
			for(String el: strings)
				System.out.print(" "+el);
			System.out.println();
			break;	
         
         case 4: System.out.println("Program terminated");
         		check=true;
         		break;
         }
         }
         
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
   }

   public static void main(String[] args) 
                                       throws RemoteException
   {
      RmiClient client = new RmiClient();
   }
}

