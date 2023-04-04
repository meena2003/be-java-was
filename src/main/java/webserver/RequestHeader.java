package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RequestHeader {
    private final HashMap<String, String> requestHeader;

    public RequestHeader(BufferedReader requestHeaderInfo) throws IOException {
        requestHeader = new HashMap<>();
        convertRequestHeaderInfoToMap(requestHeaderInfo);
    }

    // requestHeader를 Header-Name과 Header-Value로 나누어 HashMap에 저장
    private void convertRequestHeaderInfoToMap(BufferedReader br) throws IOException {
        String headerLine;
        while (!(headerLine = br.readLine()).equals("")) {
            String[] tokens = headerLine.split(": ");
            requestHeader.put(tokens[0], tokens[1]);
        }
    }

    // requestHeader 전체를 출력
    public void printRequestHeaderLog() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entrySet : requestHeader.entrySet()) {
            sb.append(entrySet.getKey() + ": " + entrySet.getValue() + "\n");
        }
        System.out.println(sb);
    }

    // 해당하는 헤더 값을 반환
    public String getHeaderValue(String headerName) {
        return requestHeader.get(headerName);
    }
}
