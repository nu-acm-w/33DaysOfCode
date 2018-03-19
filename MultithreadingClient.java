import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
//What if implement runnable?
//TODO: - check for structures and variables to control multithreading
//
class TCP_Server_mult {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String lengthSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Socket connectionSocket = welcomeSocket.accept();
        int length = 0;
        
        
        public TCP_Server_mult(int port){
            this.serverPortVal = port;
        }
        
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        
        while (true) {
            clientSentence = inFromClient.readLine();
            length = clientSentence.length();
            if (length==0){
                outToClient.writeBytes("END" + "\n");
                break;
            }
            
            System.out.println("Received: " + clientSentence);
            lengthSentence = String.valueOf(length);
            outToClient.writeBytes(lengthSentence + "\n");
        }
        connectionSocket.close();
        welcomeSocket.close();
        
    }
}

class TCP_Client_mult {
    
    public static void main(String argv[]) throws Exception {
        String send;
        String rec;
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while(true){
            send = inFromUser.readLine();
            outToServer.writeBytes(send + '\n');
            rec= inFromServer.readLine();
            System.out.println("FROM SERVER: " + rec);
            if(rec.equals("END")){
                clientSocket.close();
                break;
            }
        }
        
        
    }
}

