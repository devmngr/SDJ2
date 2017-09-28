package sockets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
   public static void main(String args[]) throws IOException,
         ClassNotFoundException
   {
      boolean isConnected = true;
      final int PORT = 6789;
      System.out.println("Starting Server...");

      // create welcoming socket at port 6789
      ServerSocket welcomeSocket = new ServerSocket(PORT);
      MessageBroadcast mb = new MessageBroadcast();
      
         while (isConnected)
      {
         Socket connectionSocket = welcomeSocket.accept();
         ServerConnection c = new ServerConnection(connectionSocket, mb);
         mb.addConnection(c);
         new Thread(c, "Comunication ").start();
      }
      welcomeSocket.close();
   }
}

