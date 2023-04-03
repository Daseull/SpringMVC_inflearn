package hello.springmvc.basic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users") // 중복 uri 제거
public class MethodMappingController {

    //    @GetMapping("/mapping/users")
    @GetMapping
    public String getUser() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{id}")
    public String findUser(@PathVariable Long id) {
        return "get userId = " + id;
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable Long id) {
        return "patch userId = " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "delete userId = " + id;
    }


}
