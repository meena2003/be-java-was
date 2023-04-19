package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ContentType;
import util.StatusCode;
import webserver.HttpResponse;

import java.io.IOException;

public class ViewResolver {
    private final static Logger log = LoggerFactory.getLogger("ViewResolver");
    public static void resolveView(String uri, ContentType contentType, StatusCode statusCode, HttpResponse httpResponse) throws IOException {

        // 200 이라면 200헤더 메소드 호출
        if (statusCode == StatusCode.OK) {
            byte[] body = httpResponse.readFile(contentType.getRootPath(), uri);
            httpResponse.response200Header(body.length, contentType);
            httpResponse.responseBody(body);
        }

        // 302 리다이렉트라면 302헤더 메소드 호출
        if (statusCode == StatusCode.FOUND) {
            httpResponse.response302Header(uri, contentType);
        }
    }
}
