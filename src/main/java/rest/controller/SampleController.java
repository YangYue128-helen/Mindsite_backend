package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.IService;
import service.request.ServiceRequest;
import service.response.ServiceResponse;

@RestController
public class SampleController {

    private IService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> samplefunc(@RequestParam(name = "searchkey") String key) {

        //Construct service request
        ServiceRequest request = new ServiceRequest("Sample"); //operation name
        // Set up the request here

        ServiceResponse response = this.service.execute(request);

        if (!response.isError()) {
            return new ResponseEntity<Boolean>(HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
