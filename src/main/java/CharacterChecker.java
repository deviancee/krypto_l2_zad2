import static com.google.common.primitives.Bytes.asList;

public class CharacterChecker {
    public boolean isAsciiCharsArray(byte[] bytes) {
        return asList(bytes).stream().allMatch(this::isWantedChar);
    }

    private boolean isWantedChar(byte b) {
        return (b >= 44 && b <= 93) || (b >= 96 && b <= 122) || (b >= 32 && b <= 41);
    }
}
