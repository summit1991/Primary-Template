package andrea.publics.backend.domain.survey.controller

import andrea.publics.backend.constants.API_PATH_PREFIX_V1
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("$API_PATH_PREFIX_V1/surveys")
@RestController
class SurveyAPIController {
    @GetMapping
    fun getPage(pageable: Pageable): Any {
        return ""
    }

    @GetMapping("/{surveyId}")
    fun getSurvey(@PathVariable surveyId: Long): Any {
        return ""
    }
}
