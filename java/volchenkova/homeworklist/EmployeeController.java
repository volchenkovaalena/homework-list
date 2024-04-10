package volchenkova.homeworklist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController ( EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee ( @RequestParam ("name") String name, @RequestParam ("surname") String surname ) {
        return service.add ( name, surname );
    }

    @GetMapping("/remove")
    public Employee deleteEmployee ( @RequestParam String name, @RequestParam String surname ) {
        return service.remove ( name, surname );

    }

    @GetMapping("/find")
    public Employee findEmployee ( @RequestParam String name, @RequestParam String surname) {
        return service.find ( name,surname);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll ( );
    }
}
