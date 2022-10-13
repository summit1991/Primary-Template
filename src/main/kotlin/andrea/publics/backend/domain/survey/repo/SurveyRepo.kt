package andrea.publics.backend.domain.survey.repo

import andrea.publics.backend.domain.survey.entity.Survey
import org.springframework.data.jpa.repository.JpaRepository

interface SurveyRepo : JpaRepository<Survey, Int> {

}
