package util;

public class HttpRequestUtils {
    public static String getUrl(String requestLine) {
        String[] tokens = requestLine.split(" ");
        return tokens[1];
    }
}
