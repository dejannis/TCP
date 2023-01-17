import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        System.out.println("Enter number 1: ");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        System.out.println("Enter number 2: ");
        int number2 = scanner.nextInt();

        try (Socket socket = new Socket("localhost", 1080);
             BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

            int numbers = number1 + number2;
            bos.write(String.valueOf(numbers).getBytes());
            bos.flush();

            String s = bis.readLine();
            System.out.println("Sum is: " + Integer.parseInt(s));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
