package com.ex200810;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @author An Qi
 * @date 2020/8/10
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}
        };

        String word = "abcced";
        System.out.println(exist(board, word));
    }


    public static boolean exist(char[][] board, String word) {
        // 行数
        int m = board.length;
        // 列数
        int n = board[0].length;
        // 遍历每行每列元素，从第一个字符搜索
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从第一个字符开始搜索，命中整个字符串则返回true
                if (dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int m, int n, int index) {
        // 搜索失败条件：1.搜索方向超出边界 2.搜索长度大于目标字符串长度 3.与目标字符不匹配
        if (m < 0 || m > board.length - 1 || n < 0 || n > board[0].length - 1 || index >= word.length() || board[m][n] != word.charAt(index)) {
            return false;
        }

        // 如果命中目标字符后，且长度等于目标字符串长度，则搜索完成
        if (index == word.length() - 1) {
            return true;
        }

        // 将搜索过的元素置为*，防止重复搜索
        char temp = board[m][n];
        board[m][n] = '*';

        boolean result =
                // 向左搜索
                dfs(board, word, m, n - 1, index + 1)
                // 向下搜索
                || dfs(board, word, m + 1, n, index + 1)
                // 向右搜索
                || dfs(board, word, m, n + 1, index + 1)
                // 向上搜索
                || dfs(board, word, m - 1, n, index + 1);

        // 复原置为*的元素
        board[m][n] = temp;
        return result;
    }

}
