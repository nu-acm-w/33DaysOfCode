import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
//What if implement runnable?
//TODO: - check for structures and variables to control multithreading
//
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

