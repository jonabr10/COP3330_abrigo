public class Main {
    public static void main(String[] args) {
        Encrypter e = new Encrypter();
        System.out.println(e.encrypt("0123"));

        Encrypter e1 = new Encrypter();
        System.out.println(e1.encrypt("0199"));

        Encrypter e2 = new Encrypter();
        System.out.println(e2.encrypt("0099"));

        Decrypter f = new Decrypter();
        System.out.println(f.decrypt("9078"));

        Decrypter f1 = new Decrypter();
        System.out.println(f1.decrypt("6678"));

        Decrypter f2 = new Decrypter();
        System.out.println(f2.decrypt("6677"));


    }
}
