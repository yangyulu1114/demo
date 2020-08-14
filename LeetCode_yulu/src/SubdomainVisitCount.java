import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    //这题要注意用split函数时可能会发生转义，比如这里的.就发生了转义
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String string : cpdomains) {
            String[] domains = string.split(" ");
            String[] subdomain = domains[1].split("\\.");
            for (int i = subdomain.length - 1; i >= 0; i--) {
                if (sb.length() != 0) {
                    sb.insert(0, ".");
                }
                sb.insert(0, subdomain[i]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + Integer.valueOf(domains[0]));
            }
            sb.setLength(0);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(' ').append(entry.getKey());
            ans.add(sb.toString());
            sb.setLength(0);
        }
        return ans;
    }

    public void test() {
        String[] input = new String[] {"9001 discuss.leetcode.com"};
        List<String> list = subdomainVisits(input);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
