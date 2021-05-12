package service.request;

/**
 * A class that construct http request to service request
 */
public class ServiceRequest {
    private final String operation;

    public ServiceRequest(String operationName) {
        operation = operationName;
    }
}
