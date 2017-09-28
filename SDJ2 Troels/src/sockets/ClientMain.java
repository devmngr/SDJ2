package sockets;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMain
{
   public static void main(String args[]) throws IOException, 
                      UnknownHostException, ClassNotFoundException
   {
      
      ChatView view = new ChatView("Client");
      view.start();
   }
}
