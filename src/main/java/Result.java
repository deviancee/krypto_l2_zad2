import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Result {
    private static final String RESULT_FILE = "result";
    private boolean isDone = false;

    public void markDone(byte[] key, byte[] message){
        String cipherFilePath = this.getClass().getResource(RESULT_FILE).getPath();

        String result = createResultString(key, message);
        writeToFile(cipherFilePath, result);
        isDone = true;
    }

    private void writeToFile(String resultFilePath, String result) {
        try {
            FileUtils.write(new File(resultFilePath), result);
        } catch (IOException e) {
            System.out.println("Unable to write " + result + " to file");
        }
    }

    private String createResultString(byte[] key, byte[] message) {
        try {
            return "key: " + new String(key, "ASCII") + "\n message: " + new String(message, "ASCII");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unable to create message from key: " + Arrays.toString(key) + "and message: " + Arrays.toString(message));
            return "";
        }
    }

    public boolean isDone(){
        return isDone;
    }
}
