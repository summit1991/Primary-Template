package andrea.publics.backend.domain.survey.service

import andrea.publics.backend.domain.survey.repo.SurveyRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Service
class SurveyService @Autowired constructor(
    private val surveyRepo: SurveyRepo
) {
    fun getPage(pageable: Pageable): Any {
        return ""
    }

    fun getSurvey(@PathVariable surveyId: Long): Any {
        return ""
    }
}
