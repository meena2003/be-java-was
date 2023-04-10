package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ContentType;
import util.StatusCode;
import webserver.HttpRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class View {
    private static final Logger log = LoggerFactory.getLogger(View.class);
    private final ContentType contentType;
    private final HttpRequest httpRequest;
    private final StatusCode statusCode;

    public View(ContentType contentType, HttpRequest httpRequest, StatusCode statusCode) {
        this.contentType = contentType;
        this.httpRequest = httpRequest;
        this.statusCode = statusCode;
    }

    public byte[] makeResponseMessage() throws IOException {
        byte[] content = readFile(httpRequest.getHttpUriRootPath());
        byte[] header = setResponseHeader(content.length);
        byte[] responseMessage = new byte[content.length + header.length];

        System.arraycopy(header, 0, responseMessage, 0, header.length);
        System.arraycopy(content, 0, responseMessage, header.length, content.length);
        return responseMessage;
    }

    private byte[] setResponseHeader(int contentSize) {
        StringBuilder sb = new StringBuilder();
        sb.append(httpRequest.getHttpVersion() + " " + statusCode.getStatusCode() + " " + statusCode.getStatusMessage() + "\r\n");
        sb.append("Content-Type: text/html;charset=utf-8\r\n");
        sb.append("Content-Length: " + contentSize + "\r\n");
        sb.append("\r\n");
        log.debug("responseHeader : {}", sb.toString());
        return String.valueOf(sb).getBytes();
    }

    private byte[] readFile(String uri) throws IOException {
        return Files.readAllBytes(new File(contentType.getFILE_LOCATION() + uri).toPath());
    }
}
