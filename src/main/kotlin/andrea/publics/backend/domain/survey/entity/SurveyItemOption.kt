package andrea.publics.backend.domain.survey.entity

import javax.persistence.*

@Entity
class SurveyItemOption(
    @field:Id
    val id: Int,

    @field:Column(name="`order`")
    var order: Int,

    @field:Column(length = 300)
    var contents: String,

    @field:JoinColumn(name = "survey_id")
    @field:ManyToOne(fetch = FetchType.LAZY)
    val survey: Survey,

    @field:JoinColumn(name = "survey_item_id")
    @field:ManyToOne(fetch = FetchType.LAZY)
    val item: SurveyItem
)
