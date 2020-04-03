package com.example.client.controller;
import com.example.client.service.SoapConnector;
import com.example.generated.StudentDetailsRequest;
import com.example.generated.StudentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.client.util.Constants.SERVICE_URL;

@RestController
public class SendController {

    private final SoapConnector soapConnector;

    @Autowired
    public SendController(SoapConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

    @PostMapping("/")
    public String exampleCallWebService() {
        StudentDetailsRequest request = generateRequest();
        StudentDetailsResponse response = (StudentDetailsResponse) soapConnector.callWebService(SERVICE_URL, request);
        printResponse(response);
        return "ok";
    }

    private void printResponse(StudentDetailsResponse response) {
        System.out.println("========= Got Response =========");
        System.out.println("Name : " + response.getStudent().getName());
        System.out.println("Standard : " + response.getStudent().getStandard());
        System.out.println("Address : " + response.getStudent().getAddress());
        System.out.println("========= End Response =========");
    }

    private StudentDetailsRequest generateRequest() {
        StudentDetailsRequest request = new StudentDetailsRequest();
        request.setName("Вася");
        return request;
    }

}
