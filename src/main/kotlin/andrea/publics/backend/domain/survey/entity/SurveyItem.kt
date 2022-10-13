package andrea.publics.backend.domain.survey.entity

import javax.persistence.*

@Entity
class SurveyItem(
    @field:Id
    val id: Int,

    @field:Column(name="`order`")
    var order: Int,

    @field:Column(length = 300)
    var query: String,

    @field:Enumerated(EnumType.STRING) // TODO 축약 컨버터 넣자
    var type: SurveyItemType,

    @field:JoinColumn(name = "survey_id")
    @field:ManyToOne(fetch = FetchType.LAZY)
    val survey: Survey
)

enum class SurveyItemType {
    Single,
    Multiple,
    Description
}
