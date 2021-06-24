import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat",
        "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut."};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while(true) {
                Socket socket = serverSocket.accept(); // just sits there til a request comes in,
                // then method returns a socket on anonymous port for communicating with the client

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.go();
    }

}
