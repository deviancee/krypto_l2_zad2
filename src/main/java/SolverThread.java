import static org.apache.commons.lang3.ArrayUtils.addAll;

public class SolverThread implements Runnable {
    private static final byte[] keyChars = new byte[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private byte[] knownPart;
    private final byte[] message;
    private final int min;
    private final int max;
    private final Result result;
    private final CharacterChecker characterChecker = new CharacterChecker();
    private final Rc4 rc4 = new Rc4();

    SolverThread(int min, int max, Result result, byte[] message, byte[] knownPart) {
        this.knownPart = knownPart;
        this.min = min;
        this.max = max;
        this.result = result;
        this.message = message;
    }

    public void run() {
        byte[] generatedKey = new byte[8];
        for (int i = min; !result.isDone() && i < max; i++) {
            generatedKey[0] = keyChars[i];
            for (int j = 0; shouldContinue(j); j++) {
                generatedKey[1] = keyChars[j];
                for (int k = 0; shouldContinue(k); k++) {
                    generatedKey[2] = keyChars[k];
                    for (int l = 0; shouldContinue(l); l++) {
                        generatedKey[3] = keyChars[l];
                        for (int m = 0; shouldContinue(m); m++) {
                            generatedKey[4] = keyChars[m];
                            for (int n = 0; shouldContinue(n); n++) {
                                generatedKey[5] = keyChars[n];
                                for (int o = 0; shouldContinue(o); o++) {
                                    generatedKey[6] = keyChars[o];
                                    for (int p = 0; shouldContinue(p); p++) {
                                        generatedKey[7] = keyChars[p];
                                        byte[] output = rc4.decode(message, addAll(generatedKey, knownPart));
                                        if (characterChecker.isAsciiCharsArray(output)) {
                                            result.markDone(addAll(generatedKey, knownPart), output);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean shouldContinue(int j) {
        return !result.isDone() && j < keyChars.length;
    }
}
