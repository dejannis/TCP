import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        System.out.println("Listening...");
         try (ServerSocket serverSocket = new ServerSocket(1080);
              Socket socket = serverSocket.accept();
              BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

             String s = bis.readLine();
             String[] numbers = s.split(",");
             int number1 = Integer.parseInt(numbers[0]);
             int number2 = Integer.parseInt(numbers[1]);
             int sum = number1 + number2;

             bos.write(String.valueOf(sum).getBytes());

         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
