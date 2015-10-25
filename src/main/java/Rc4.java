import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;

public class Rc4 {

    public byte[] decode(byte[] message, byte[] key) {
        byte[] output = new byte[message.length];

        decode(message, key, output);
        return output;
    }

    private void decode(byte[] message, byte[] key, byte[] output) {
        RC4Engine rc4Engine = new RC4Engine();
        CipherParameters params = new KeyParameter(new SecretKeySpec(key, "RC4").getEncoded());
        rc4Engine.init(false, params);
        rc4Engine.processBytes(message, 0, message.length, output, 0);
    }

    public static void main(String[] args) throws IOException {
        CipherReader cipherReader = new CipherReader();
        byte[] message = cipherReader.readCipher();
        byte[] key = cipherReader.readKey();
        Result result = new Result();


        int indexesPerThread = 2;
        for (int i = 0; i < 16; i += indexesPerThread) {
            new Thread(new SolverThread(i, i + indexesPerThread, result, message, key)).start();
        }
    }
}
