package eremenko.diplodocus.contorller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("anime")
    @Operation(description = "Something get request")
    fun test(): String {
        return "anime"
    }
}