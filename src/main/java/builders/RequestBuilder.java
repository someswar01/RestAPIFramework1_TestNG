package builders;

import models.RequestData;

import java.io.File;

public class RequestBuilder {

    private final RequestData requestData;

    private RequestBuilder() {
        requestData = new RequestData();
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public RequestBuilder header(String key, String value) {
        requestData.getHeaders().put(key, value);
        return this;
    }

    public RequestBuilder queryParam(String key, Object value) {
        requestData.getQueryParams().put(key, value);
        return this;
    }

    public RequestBuilder pathParam(String key, Object value) {
        requestData.getPathParams().put(key, value);
        return this;
    }

    public RequestBuilder formParam(String key, String value) {
        requestData.getFormParams().put(key, value);
        return this;
    }

    public RequestBuilder body(Object body) {
        requestData.setBody(body);
        return this;
    }

    public RequestBuilder multiPart(File file, String paramName) {

        requestData.setMultipartFile(file);
        requestData.setMultipartName(paramName);

        return this;
    }
    public RequestData build() {
        return requestData;
    }
}
