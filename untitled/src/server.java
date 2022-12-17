import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(8000)) {

        System.out.println("Server started!");

        while (true)
            try (Socket socket = server.accept();

                 BufferedWriter writer = new BufferedWriter(
                         new OutputStreamWriter(
                                 socket.getOutputStream()));
                 BufferedReader reader = new BufferedReader(
                         new InputStreamReader(
                                 socket.getInputStream()))) {

                String request = reader.readLine();
                writer.write("x^2-16=0");
                writer.newLine();
                writer.flush();

                System.out.println("Client");
                System.out.println(request);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
