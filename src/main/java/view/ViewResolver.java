package view;


import util.ContentType;
import util.StatusCode;
import webserver.HttpRequest;

import java.io.IOException;

public class ViewResolver {

    public static byte[] handleView(String viewName, HttpRequest httpRequest) throws IOException {
        ContentType contentType = choiceContentType(viewName);
        StatusCode statusCode = null;
        String protocolVersion = httpRequest.getHttpVersion();
        String statusMessage = null;

        if (viewName.equals("redirect:/")) {
            statusCode = StatusCode.FOUND;
            viewName = "";
            return new View(contentType, httpRequest, statusCode).makeResponseMessage();
        }
        if (viewName.equals("/index.html")) {
            statusCode = StatusCode.OK;
            return new View(contentType, httpRequest, statusCode).makeResponseMessage();
        }
        return null;
    }

    private static ContentType choiceContentType(String viewName) {
        for (ContentType contentType : ContentType.values()) {
            if (viewName.matches(contentType.getFILE_EXTENSION())) {
                return contentType;
            }
        }
        throw new IllegalArgumentException("해당하는 Contents-type이 없습니다.");
    }
}
