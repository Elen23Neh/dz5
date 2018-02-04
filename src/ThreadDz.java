import java.util.Scanner;

public class ThreadDz {

    public static Object sync = new Object();
    public static String input = "";

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        MyFileWriter t = new MyFileWriter();
        //t.setDaemon(true);
        t.start();

        while (true){
            userInput = sc.nextLine();

            if(userInput.equals("quit")){
                break;
            }

            synchronized (sync) {
                input += userInput;
            }
        }

        t.join(1000);
        t.interrupt();
    }
}
