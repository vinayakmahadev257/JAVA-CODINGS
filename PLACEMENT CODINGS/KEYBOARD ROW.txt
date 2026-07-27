import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        String regex = "(?i)([qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+)";
        
        for (String word : words) {
            if (word.matches(regex)) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}