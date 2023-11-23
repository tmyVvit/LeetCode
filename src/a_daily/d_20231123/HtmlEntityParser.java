package a_daily.d_20231123;

import java.util.HashMap;
import java.util.Map;

public class HtmlEntityParser {

    public static void main(String[] args) {
        HtmlEntityParser htmlEntityParser = new HtmlEntityParser();
        System.out.println(htmlEntityParser.entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(htmlEntityParser.entityParser("&&amp;"));
    }

    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        while (idx < text.length()) {
            while (idx < text.length() && text.charAt(idx) != '&') {
                sb.append(text.charAt(idx));
                idx++;
            }
            if (idx >= text.length()) {
                break;
            }
            int s = idx++;
            while (idx < text.length() && text.charAt(idx) != ';' && text.charAt(idx) != '&') {
                idx++;
            }
            if (idx < text.length() && text.charAt(idx) != '&') {
                idx++;
            }
            String str = text.substring(s, idx);
            sb.append(map.getOrDefault(str, str));
        }
        return sb.toString();
    }
}
