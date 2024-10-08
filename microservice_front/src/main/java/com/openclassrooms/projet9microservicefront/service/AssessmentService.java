package com.openclassrooms.projet9microservicefront.service;

import com.openclassrooms.projet9microservicefront.model.Note;
import com.openclassrooms.projet9microservicefront.proxies.AssessmentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AssessmentService {


    @Value("${ASSESSMENT_URI}")
    String assessmentUri;

    @Autowired
    AssessmentProxy assessmentProxy;

    public String getAssessment(int id){
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject(assessmentUri+"/"+id, String.class);

        //return response;

        return assessmentProxy.getAssessment(id);
    }
}
