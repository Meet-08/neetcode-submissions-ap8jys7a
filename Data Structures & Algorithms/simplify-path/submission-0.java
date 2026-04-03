class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String s : paths){
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(!s.equals("") && !s.equals(".")){
                stack.push(s);
            }
        }
        

        return "/" + String.join("/", stack);
    }
}