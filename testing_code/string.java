import java.util.*;

public class string {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    static class Match {
        int endIdx;
        boolean reversed;

        Match(int endIdx, boolean reversed) {
            this.endIdx = endIdx;
            this.reversed = reversed;
        }
    }

    static TrieNode buildTrie(String s) {
        TrieNode root = new TrieNode();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                curr = curr.children.computeIfAbsent(s.charAt(j), k -> new TrieNode());
                curr.isEnd = true;
            }
        }
        return root;
    }

    static List<Match> findMatches(String X, int start, TrieNode trie, boolean reversed) {
        List<Match> res = new ArrayList<>();
        TrieNode curr = trie;
        for (int j = start; j < X.length(); j++) {
            if (!curr.children.containsKey(X.charAt(j)))
                break;
            curr = curr.children.get(X.charAt(j));
            if (curr.isEnd)
                res.add(new Match(j + 1, reversed));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.nextLine();
        String Y = sc.nextLine();
        int S = sc.nextInt(), R = sc.nextInt();

        TrieNode normalTrie = buildTrie(Y);
        TrieNode reversedTrie = buildTrie(new StringBuilder(Y).reverse().toString());

        int n = X.length();
        int[] dp = new int[n + 1];
        int[] cost = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(cost, Integer.MAX_VALUE);
        dp[n] = 0;
        cost[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            List<Match> matches = new ArrayList<>();
            matches.addAll(findMatches(X, i, normalTrie, false));
            matches.addAll(findMatches(X, i, reversedTrie, true));  // fixed: should be true

            for (Match m : matches) {
                int substrCount = dp[m.endIdx] + 1;
                int factor = cost[m.endIdx] + (m.reversed ? R : S);
                if (substrCount < dp[i] || (substrCount == dp[i] && factor < cost[i])) {
                    dp[i] = substrCount;
                    cost[i] = factor;
                }
            }
        }

        if (dp[0] == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(cost[0]);
        }
    }
}
