package StrAlgo;

import static java.lang.System.out;

public class TestStrAlgo {

    public static void main(String[] args) {
        testTrie();
        out.println("===== ===== ===== =====\n");

        testNaiveAlgo();
        out.println("===== ===== ===== =====\n");

        testRKAlgo();
        out.println("===== ===== ===== =====\n");

        testKMPAlgo();
        out.println("===== ===== ===== =====\n");

        testBMAlgo();
        out.println("===== ===== ===== =====\n");
    }

    private static void testTrie() {
        Trie trie = new Trie();
        out.println(trie.getClass().getName());

        trie.insert("ann");
        trie.insert("bob");
        trie.insert("cindy");
        trie.insert("dan");
        out.println(String.valueOf(trie.find("bob")));
        out.println(String.valueOf(trie.find("diane")));
        out.println(String.valueOf(trie.find("ann")));
        out.println(String.valueOf(trie.find("john")));
    }

    private static void testNaiveAlgo() {
        MatchString ms = new NaiveAlgo();
        out.println(ms.getClass().getName());

        out.println(String.valueOf(ms.matchString("abcdefgh", "def")));
        out.println(String.valueOf(ms.matchString("abcdefgh", "zsw")));
        out.println(String.valueOf(ms.matchString("asdxcvzvaasd", "vzvaa")));
    }

    private static void testRKAlgo() {
        MatchString ms = new RKAlgo();
        out.println(ms.getClass().getName());

        out.println(String.valueOf(ms.matchString("abcdefgh", "def")));
        out.println(String.valueOf(ms.matchString("abcdefgh", "zsw")));
        out.println(String.valueOf(ms.matchString("asdxcvzvaasd", "vzvaa")));
    }

    private static void testKMPAlgo() {
        MatchString ms = new KMPAlgo();
        out.println(ms.getClass().getName());

        out.println(String.valueOf(ms.matchString("abcdefgh", "def")));
        out.println(String.valueOf(ms.matchString("abcdefgh", "zsw")));
        out.println(String.valueOf(ms.matchString("asdxcvzvaasd", "vzvaa")));
    }

    private static void testBMAlgo() {
        MatchString ms = new BMAlgo();
        out.println(ms.getClass().getName());

        out.println(String.valueOf(ms.matchString("abcdefgh", "def")));
        out.println(String.valueOf(ms.matchString("abcdefgh", "zsw")));
        out.println(String.valueOf(ms.matchString("asdxcvzvaasd", "vzvaa")));
    }

}
