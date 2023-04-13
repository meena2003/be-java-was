package controller;

import webserver.HttpRequest;
import webserver.HttpResponse;

import java.io.IOException;

public interface Handler {
    void handle(HttpRequest httpRequest, HttpResponse httpResponse) throws IOException;
}
