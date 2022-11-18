/*
package andrea.publics.backend.domain.survey.entity

import andrea.publics.backend.common.model.Period
import javax.persistence.*

@Entity
class Survey(
    @field:Id
    val id: Int,

    @field:Column(length = 100)
    var title: String,

    @field:Column(length = 300)
    var description: String?,

    @field:AttributeOverrides(
        AttributeOverride(name = "start", column = Column(name = "start_at")),
        AttributeOverride(name = "end", column = Column(name = "end_at"))
    )
    @field:Embedded
    var period: Period
) {


    companion object {
*/
/*        val dummy = Survey(
            title = "설문을 시작합니다.",
            description = "달라일러야 쩜메야",
            period = Period(LocalDateTime.now(), LocalDateTime.MAX),
            items = listOf(
                SurveyItem(
                    query = "단일선택요망",
                    type = SurveyItemType.Single,
                    options = listOf(

                    )
                ),
                SurveyItem(

                ),
                SurveyItem(

                )
            )
        )*//*

    }
}
*/
