package andrea.publics.backend.menu.dto

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
                    title = "Theme",
                    items = listOf(
                        MenuItemDTO(
                            id = "2",
                            name = "Colors",
                            path = "/template/theme/colors"
                        ),
                        MenuItemDTO(
                            id = "3",
                            name = "Typography",
                            path = "/template/theme/typography"
                        )
                    )
                ),
                MenuGroupDTO(
                    id = "4",
                    title = "COMPONENTS",
                    items = listOf(
                        MenuItemDTO(
                            id = "5",
                            name = "Base",
                            path = "/template/component/base"
                        ),
                        MenuItemDTO(
                            id = "6",
                            name = "Buttons",
                            path = "/template/component/buttons",
                            children = listOf(
                                MenuItemDTO(
                                    id = "7",
                                    name = "Accordion",
                                    path = "/template/component/buttons/accordion"
                                ),
                                MenuItemDTO(
                                    id = "8",
                                    name = "Breadcrumb",
                                    path = "/template/component/buttons/breadcrumb"
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

