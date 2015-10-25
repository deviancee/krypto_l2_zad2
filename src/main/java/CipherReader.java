import com.google.common.base.Splitter;
import com.google.common.primitives.Bytes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Iterables.getOnlyElement;
import static org.apache.commons.io.FileUtils.readLines;

public class CipherReader {
    private static final String KEY_NAME = "key";
    private static final String CIPHER_NAME = "cipher";
    private static final String WHITESPACE = " ";


    public byte[] readKey() throws IOException {
        String keyFilePath = this.getClass().getResource(KEY_NAME).getPath();
        String key = getOnlyElement(readLines(new File(keyFilePath)));
        byte[] bytes = new byte[8];
        for(int i = 0; i < 8; i++) {
            bytes[i] = (byte) key.charAt(i);
        }

        return bytes;
    }

    public byte[] readCipher() throws IOException {
        String cipherFilePath = this.getClass().getResource(CIPHER_NAME).getPath();
        List<String> cipher = parseCipherToWords(getOnlyElement(readLines(new File(cipherFilePath))));
        return Bytes.toArray(cipher.stream().map(x -> (byte) Integer.parseInt(x, 2)).collect(Collectors.toList()));
    }

    private List<String> parseCipherToWords(String cipher) {
        return Splitter.on(WHITESPACE).omitEmptyStrings().splitToList(cipher);
    }
}