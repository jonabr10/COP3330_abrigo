public class Encrypter {
    private String secretMessage;

    public String encrypt(String newMessage) {

        int[] numValOfnewMsg = new int[newMessage.length()];
        char[] charValOfnewMsg = new char[newMessage.length()];

        for (int i = 0; i < newMessage.length(); i++) {
            numValOfnewMsg[i] = newMessage.charAt(i) - '0';
            numValOfnewMsg[i] = (numValOfnewMsg[i] + 7) % 10;
        }

        doIndexSwap(numValOfnewMsg);

        for (int j = 0; j < newMessage.length(); j++) {
            charValOfnewMsg[j] = (char) (numValOfnewMsg[j] + '0');
        }

        secretMessage = new String(charValOfnewMsg);
        return secretMessage;
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

