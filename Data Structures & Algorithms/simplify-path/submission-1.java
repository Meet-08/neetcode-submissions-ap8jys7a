class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");

        Stack<String> s = new Stack<>();

        for (String dir : dirs) {
            switch (dir) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!s.isEmpty())
                        s.pop();
                    break;
                default:
                    s.push(dir);
            }
        }

        return "/" + String.join("/", s);
    }
}