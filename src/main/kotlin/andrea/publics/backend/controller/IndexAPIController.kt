package andrea.publics.backend.controller

import andrea.publics.backend.constants.API_PATH_PREFIX_V1
import andrea.publics.backend.menu.dto.MenuGroupDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(API_PATH_PREFIX_V1)
@RestController
class IndexAPIController {
    @GetMapping("/index")
    fun index(): Any {
        return "인덱스 데이터"
    }

    @GetMapping("/menus")
    fun menus(): Any {
        return MenuGroupDTO.dummyMenu
    }
}
