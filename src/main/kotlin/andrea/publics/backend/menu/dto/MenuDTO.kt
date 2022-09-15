package andrea.publics.backend.menu.dto

data class MenuGroupDTO(
    val id: Int,
    val title: String,
    val items: List<MenuItemDTO> = emptyList()
) {
    companion object {
        val dummyMenu: List<MenuGroupDTO>
            get() = listOf(
                MenuGroupDTO(
                    id = 1,
                    title = "일번그룹",
                    items = listOf(
                        MenuItemDTO(
                            id = 2,
                            name = "일번메뉴",
                            path = "/first/one"
                        ),
                        MenuItemDTO(
                            id = 3,
                            name = "이번메뉴",
                            path = "/first/two"
                        )
                    )
                ),
                MenuGroupDTO(
                    id = 4,
                    title = "일번그룹",
                    items = listOf(
                        MenuItemDTO(
                            id = 5,
                            name = "일번메뉴",
                            path = "/second/first"
                        ),
                        MenuItemDTO(
                            id = 6,
                            name = "이번메뉴",
                            path = "/second/two",
                            children = listOf(
                                MenuItemDTO(
                                    id = 7,
                                    name = "일번메뉴",
                                    path = "/second/two/one"
                                ),
                                MenuItemDTO(
                                    id = 8,
                                    name = "일번메뉴",
                                    path = "/second/two/two"
                                ),
                            )
                        )
                    )
                ),
            )
    }
}

data class MenuItemDTO(
    val id: Long,
    val name: String,
    val path: String,
    val children: List<MenuItemDTO> = emptyList()
)
