public class Decrypter {
    private String origMessage;

    public String decrypt(String secretMessage) {
        int[] numValOfsecretMsg = new int[secretMessage.length()];
        char[] charValOfsecretMsg = new char[secretMessage.length()];

        for (int i = 0; i < secretMessage.length(); i++) {
            numValOfsecretMsg[i] = secretMessage.charAt(i) - '0';

            if (numValOfsecretMsg[i] >= 7) {
                numValOfsecretMsg[i] = (numValOfsecretMsg[i] - 7) % 10;
            } else {
                numValOfsecretMsg[i] = (numValOfsecretMsg[i] + 10) - 7;
            }
        }

        doIndexSwap(numValOfsecretMsg);

        for (int j = 0; j < secretMessage.length(); j++) {
            charValOfsecretMsg[j] = (char) (numValOfsecretMsg[j] + '0');
        }

        origMessage = new String(charValOfsecretMsg);
        return origMessage;
    }

    public void doIndexSwap(int[] array) {
        int temp;

        // Note: swap values inside index 0 and index 2
        temp = array[0];
        array[0] = array[2];
        array[2] = temp;

        // Note: swap values inside index 1 and index 3
        temp = array[1];
        array[1] = array[3];
        array[3] = temp;
    }
}
