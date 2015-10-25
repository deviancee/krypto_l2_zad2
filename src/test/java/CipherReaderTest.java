import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CipherReaderTest {

    private CipherReader cut = new CipherReader();

    @Test
    public void testName() throws Exception {
        String result = "key: c766cb2b8f694e49\n" +
                " message: Most of us tend to see crying at work as embarrassing, awkward, and a sign of weakness.";
        String cipherFilePath = Resources.getResource("result").getPath();
        FileUtils.write(new File(cipherFilePath), result);
        FileUtils.writeStringToFile(new File(cipherFilePath), result);

    }

    @Test
    public void key() throws Exception {
        byte[] bytes = cut.readKey();
        byte[] key = new byte[]{'8', 'f', '6', '9', '4', 'e', '4', '9'};
        System.out.println("equal " + Arrays.equals(bytes, key));
        System.out.println(Arrays.toString(bytes));
        List<IntStream> intStreams = Lists.newArrayList();
        for(int i = 0; i < 6; i++) {
            intStreams.add(IntStream.range(0, 15));
        }

        IntStream mainStream = IntStream.range(0, 2);

    }
}