package LeetCode;

public class StringMinus {
    public static void main(String[] args) {
        int res = Integer.parseInt("1000") - Integer.parseInt("800");
        int a = 'a' - 'a';
        System.out.println(a);
        int[] ans = numSmallerByFrequency(new String[]{"cbd","sdsggg"}, new String[]{"zaaaz","frfssss","ttttrrrrrrrr","qqwq"});
        for (int i: ans
             ) {
            System.out.println(i);
        }
    }
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wfnum = new int[11];
        for(int i = 0; i < words.length; i++) {
            int n = f(words[i]);
            wfnum[n]++;
        }

        for(int i = 1; i <= 10; i++) {
            int n = 0;
            for(int j = i + 1; j <= 10; j++) {
                n += wfnum[j];
            }
            wfnum[i] = n;
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = wfnum[f(queries[i])];
        }
        return res;

    }

    public static int f(String s) {
        int[] num = new int[26];
        for(char c: s.toCharArray()) {
            num[c - 'a']++;
        }
        int res = 0;
        for(int i = 0; i < num.length; i++) {
            if(num[i] != 0){
                res = num[i];
                break;
            }
        }
        return res;
    }
}
