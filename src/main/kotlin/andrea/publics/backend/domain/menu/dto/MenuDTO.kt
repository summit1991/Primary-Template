package andrea.publics.backend.domain.menu.dto

data class MenuGroupDTO(
    val id: String,
    val title: String,
    val items: List<MenuItemDTO> = emptyList()
) {
    companion object {
        val dummyMenu: List<MenuGroupDTO>
            get() = listOf(
                MenuGroupDTO(
                    id = "1",
                    title = "모듈",
                    items = listOf(
                        MenuItemDTO(
                            id = "2",
                            name = "WON => 한글",
                            path = "/template/module/won-to-hangle"
                        ),
                        MenuItemDTO(
                            id = "3",
                            name = "Typography",
                            path = "/template/module/typography"
                        )
                    )
                ),
                MenuGroupDTO(
                    id = "4",
                    title = "연습장",
                    items = listOf(
                        MenuItemDTO(
                            id = "5",
                            name = "Base",
                            path = "/template/exercise-book/base"
                        ),
                        MenuItemDTO(
                            id = "6",
                            name = "Survey",
                            path = "/template/exercise-book/survey",
                            children = listOf(
                                MenuItemDTO(
                                    id = "7",
                                    name = "등록",
                                    path = "/template/exercise-book/survey/create"
                                ),
                                MenuItemDTO(
                                    id = "8",
                                    name = "Breadcrumb",
                                    path = "/template/exercise-book/buttons/breadcrumb"
                                ),
                            )
                        ),
                        MenuItemDTO(
                            id = "9",
                            name = "Forms",
                            path = "/template/exercise-book/forms",
                            children = listOf(
                                MenuItemDTO(
                                    id = "10",
                                    name = "Form Control",
                                    path = "/template/exercise-book/forms/form-control"
                                ),
                                MenuItemDTO(
                                    id = "11",
                                    name = "Select",
                                    path = "/template/exercise-book/forms/select"
                                ),
                            )
                        )
                    )
                ),
            )
    }
}

data class MenuItemDTO(
    val id: String,
    val name: String,
    val path: String,
    val children: List<MenuItemDTO> = emptyList()
)

