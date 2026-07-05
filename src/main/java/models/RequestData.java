package models;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RequestData {

    private Map<String, String> headers = new HashMap<>();

    private Map<String, String> formParams = new HashMap<>();

    private Map<String, Object> queryParams = new HashMap<>();

    private Map<String, Object> pathParams = new HashMap<>();

    private Object body;

    private File multipartFile;

    private String multipartName;

    private String schemaPath;

}