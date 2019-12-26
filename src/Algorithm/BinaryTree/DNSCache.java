package Algorithm.BinaryTree;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2019/12/26 17:07
 * @Description：反向DNS查找指的是使用Internet IP地址查找域名。
 * 例如，如果在浏览器中输入74.125.200.106，它会自动重定向到google.in。
 * 使用Trie树
 */
public class DNSCache {
    //IP字符数 0 1 2 3 4 5 6 7 8 9 . 共11个
    private final int CHAR_COUNT = 11;

    public class TrieNode {
        boolean isLeaf;
        String url;
        TrieNode[] child;

        public TrieNode(){
            this.isLeaf = false;
            this.url = null;
            this.child = new TrieNode[CHAR_COUNT];
            for (int i = 0; i < CHAR_COUNT; i++) {
                child[i] = null;
            }
        }
    }

    private TrieNode root = new TrieNode();

    public int getIndexFromChar(char c) {
        return (c == '.') ? 10 : (c - '0');
    }

    public char getCharFromIndex(int i) {
        return (i == 10) ? '.' : (char) ('0' + i);
    }

    /**
     * @Description: 将ip和相应的url添加到trie树中
     * @Param:  [id, url]
     * @Return: void
     * @Author: FANG MIAO
     * @Date: 2019/12/26 17:27
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public void insert(String ip, String url) {
        int len = ip.length();
        TrieNode p = root;

        int level;
        for (level = 0; level < len; level++) {
            int index = getIndexFromChar(ip.charAt(level));

            if (p.child[index] == null) {
                p.child[index] = new TrieNode();
            }

            p = p.child[index];
        }

        p.isLeaf = true;
        p.url = url;
    }

    public String searchDNS(String ip) {
        TrieNode p = root;
        int len = ip.length();
        int level;
        for (level = 0; level < len; level++) {
            int index = getIndexFromChar(ip.charAt(level));
            if (p.child[index] == null) {
                return null;//找不到
            }
            p = p.child[index];
        }

        if (p != null && p.isLeaf) {
            return p.url;
        }

        return null;
    }

    public static void main(String[] args) {
        String[] ips = {"1.2.3.4", "213.213.123.31", "21.342.213.255"};
        String[] urls = {"ddd", "sss", "aaa"};
        DNSCache dnsCache = new DNSCache();
        for (int i = 0; i < 3; i++) {
            dnsCache.insert(ips[i], urls[i]);
        }

        System.out.println(dnsCache.searchDNS("1.2.3.4"));
        System.out.println(dnsCache.searchDNS("213.213.123.31"));
        System.out.println(dnsCache.searchDNS("21.342.213.255"));
    }
}

