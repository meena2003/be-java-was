package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestHeader {
    private final LinkedHashMap<String, String> requestHeader;

    public RequestHeader(BufferedReader requestHeaderInfo) throws IOException {
        requestHeader = new LinkedHashMap<>();
        convertRequestHeaderInfoToMap(requestHeaderInfo);
    }

    // requestHeader를 HeaderName과 HeaderValue로 나누어 LinkedHashMap에 저장
    private void convertRequestHeaderInfoToMap(BufferedReader requestHeaderInfo) throws IOException {
        String headerLine;
        while (!(headerLine = requestHeaderInfo.readLine()).equals("")) {
            String[] tokens = headerLine.split(": ");
            requestHeader.put(tokens[0], tokens[1]);
        }
    }

    public StringBuilder getRequestHeaders() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entrySet : requestHeader.entrySet()) {
            sb.append("header : " + entrySet.getKey() + ": " + entrySet.getValue() + "\n");
        }
        return sb;
    }

    // 해당하는 헤더 값을 반환
    public String getHeaderValue(String headerName) {
        return requestHeader.get(headerName);
    }

    public int getHeaderSize() {
        return requestHeader.size();
    }
}
