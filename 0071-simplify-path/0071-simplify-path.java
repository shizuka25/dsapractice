// class Solution {
//     public String simplifyPath(String path) {
//         String[] components = path.split("/");
//         Stack<String> st = new Stack<>();

//         for (String comp : components) {
//             if (comp.equals("") || comp.equals(".")) {
//                 continue;
//             }

//             if (comp.equals("..")) {
//                 if (!st.isEmpty()) {
//                     st.pop();
//                 }
//             } else {
//                 st.push(comp);
//             }
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!st.isEmpty()) {
//             sb.insert(0, "/" + st.pop());
//         }

//         return sb.length() == 0 ? "/" : sb.toString();        
//     }
// }


class Solution {
    public String simplifyPath(String path) {
        Stack<String> folders = new Stack<String>();

        int i = 0;
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') {
                i++;
            }

            if (i == path.length()) {
                continue;
            }

            if (i < (path.length() - 1) && path.charAt(i) == '.' && path.charAt(i+1) == '.') {
                if (i + 2 == path.length() || path.charAt(i + 2) == '/') {
                    if (folders.size() != 0) {
                        folders.pop();
                    }
                    i += 2;
                    continue;
                    
                }
            }

            if (path.charAt(i) == '.' && (i + 1 == path.length() || path.charAt(i + 1) == '/')) {
                i += 1;
                continue;
            }

            int j = i;
            while (j < path.length() && path.charAt(j) != '/') {
                j++;
            }
            String folder = path.substring(i, j);
            i = j;
            folders.push(folder);
        }

        if (folders.size() == 0) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String folder : folders) {
            sb.append("/");
            sb.append(folder);
        }

        return sb.toString();
    }
}