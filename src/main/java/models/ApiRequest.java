package models;

import java.util.Map;

public class ApiRequest {

    private Map<String, String> headers;

    private Map<String, Object> queryParams;

    private Map<String, Object> pathParams;

    private Object requestBody;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public Map<String, Object> getPathParams() {
        return pathParams;
    }

    public void setPathParams(Map<String, Object> pathParams) {
        this.pathParams = pathParams;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
    }
}