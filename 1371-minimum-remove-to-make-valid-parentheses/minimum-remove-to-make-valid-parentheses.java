class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int extraOpen = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                sb.append(ch);
                extraOpen++;
            }else if(ch == ')'){
                if(extraOpen > 0){
                    sb.append(ch);
                    extraOpen--;
                }else if(extraOpen == 0){
                    continue;
                }
            }else{
                sb.append(ch);
            }
        }
        n = sb.length();
        for(int i = n - 1; i >= 0; i--){
            if(extraOpen == 0){
                break;
            }
            char ch = sb.charAt(i);
            if(ch == '('){
                sb.deleteCharAt(i);
                extraOpen--;
            }
        }
        return sb.toString();
    }
}