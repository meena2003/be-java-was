package controller;

import webserver.HttpRequest;
import webserver.HttpResponse;

public interface Controller {
    void run(HttpRequest httpRequest);
}
