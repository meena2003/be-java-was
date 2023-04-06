package webserver;

import config.AppConfig;
import controller.Controller;
import controller.HttpRequestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HttpRequestUtils;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());
        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            HttpRequest httpRequest = new HttpRequest(br);

            DataOutputStream dos = new DataOutputStream(out);
            HttpResponse httpResponse = new HttpResponse(dos);

            String uri = httpRequest.getHttpUri();

            byte[] body = Files.readAllBytes(new File("src/main/resources/templates" + uri).toPath());
            httpResponse.response200Header(dos, body.length);
            httpResponse.responseBody(dos, body);
            connection.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }


}
