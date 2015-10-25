import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Rc4Test {

    private Rc4 rc4 = new Rc4();
    private CipherReader cipherReader = new CipherReader();
    private byte[] cipher;
//    private KeyGenerator keyGenerator;
//    private byte[] key;
//    private String maxKey;
//    private String maxString;
//
//    @Before
//    public void setUp() throws Exception {
//        key = cipherReader.readKey();
//        cipher = cipherReader.readCipher2();
//        keyGenerator = new KeyGenerator(key);
//    }
//
//    @Test
//    public void canDecrypt() throws Exception {
////        Cipher.getInstance("RC4");
////        byte[] bytes = rc4.decrypt(cipher, keyGenerator.generateKey());
////        System.out.println(Arrays.toString(bytes));
//        Cipher rc4Decrypt = Cipher.getInstance("RC4");
//        double max = 0;
//        while(true) {
//        for(long i = 0; i < Long.MAX_VALUE; i++) {
//
//            byte[] key = keyGenerator.generateKey();
//            SecretKeySpec rc4Key = new SecretKeySpec(key, "RC4");
//            rc4Decrypt.init(Cipher.DECRYPT_MODE, rc4Key);
//            byte[] clearText2 = rc4Decrypt.update(cipher);
//
//           //System.out.println(Arrays.toString(keyGenerator.generateKey()));
//
//            if(i % 50000000 == 0) {
//                System.out.println(i + ", maxVal: " + max + ", key: " + maxKey + ", string: " + maxString);
//            }
//            double number = number(clearText2);
//            if(number > max) {
//                maxKey = Arrays.toString(key);
//                maxString = new String(clearText2, "ASCII");
//                max = number;
//            }
//            if(number > 0.7) {
//                System.out.println(Arrays.toString(key));
//                System.out.println("[" + i + "]: " + number);
//                System.out.println("[" + i + "]: " + new String(clearText2, "ASCII"));
//            }
//           // System.out.println("[" + i + "]: " + new String(clearText2, "ASCII"));
//        }}
//    }
//


    @Test
    public void tesatName() throws Exception {
        System.out.println((byte) 'a');

    }

    @Test
    public void testName() throws Exception {
        byte [] key = "AAAAA".getBytes("ASCII");

        String clearText = "66";


        Cipher rc4 = Cipher.getInstance("RC4");
        SecretKeySpec rc4Key = new SecretKeySpec(key, "RC4");
        rc4.init(Cipher.ENCRYPT_MODE, rc4Key);

        byte [] cipherText = rc4.update(clearText.getBytes("ASCII"));

        System.out.println("clear (ascii)        " + clearText);
        System.out.println("clear (hex)          " + DatatypeConverter.printHexBinary(clearText.getBytes("ASCII")));
        System.out.println("cipher (hex) is      " + DatatypeConverter.printHexBinary(cipherText));


        Cipher rc4Decrypt = Cipher.getInstance("RC4");
        rc4Decrypt.init(Cipher.DECRYPT_MODE, rc4Key);
        byte [] clearText2 = rc4Decrypt.update(cipherText);

        System.out.println("decrypted (clear) is " + new String(clearText2, "ASCII"));

    }
}