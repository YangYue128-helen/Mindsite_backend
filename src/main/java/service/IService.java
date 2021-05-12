package service;

import service.request.ServiceRequest;
import service.response.ServiceResponse;

public interface IService {

    ServiceResponse execute(ServiceRequest request);
}
