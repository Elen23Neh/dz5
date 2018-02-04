import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter extends Thread {
    @Override
    public void run() {
        try {
            execute();
        }
        catch (Exception ex){

        }
    }

    private void execute() throws InterruptedException, IOException {
        do {
            FileWriter fw = new FileWriter("output.txt");
            synchronized (ThreadDz.sync) {
                fw.write(ThreadDz.input);
            }
            fw.close();

            sleep(1000);
        }
        while (true);
    }
}
