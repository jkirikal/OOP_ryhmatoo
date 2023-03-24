import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Server server = new Server();
        User user = new User();
        System.out.print("[Pretend You are the User.] Try typing a message here: ");

        Thread thread1 = new Thread(() -> {

            try {
                server.serverProcesses();
                System.out.println("[Server's view]: " + server.getWhatServerSees());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {

            try {
                user.userProcesses();
                System.out.println("[User's view]: " + user.getWhatUserSees());

            } catch (IOException e) {
                throw new RuntimeException(e); }
        });

        thread1.start();
        thread2.start();
    }
}