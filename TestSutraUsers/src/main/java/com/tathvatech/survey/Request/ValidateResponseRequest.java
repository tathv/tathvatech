package com.tathvatech.survey.Request;

import com.tathvatech.survey.response.SurveyResponse;
import lombok.Data;

import java.util.List;

@Data
public class ValidateResponseRequest {
    private SurveyResponse surveyResponse;
    private List surveyQuestions;
}
