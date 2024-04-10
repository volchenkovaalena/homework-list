package volchenkova.homeworklist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private int maxEmloyees = 265;
    private final List<Employee> employeeList = new ArrayList<> ( );

    public int getMaxEmloyees () {
        return maxEmloyees;
    }
@Override
    public Employee add ( String name, String surname ) {
        Employee employee = new Employee ( name,surname );
        if (employeeList.contains ( employee )){
            throw new EmployeeAlreadyAddedException ("такой сотрудник уже есть" );
        }
        employeeList.add(employee);
        return employee;
    }
@Override
    public Employee remove ( String name, String surname ) {
    Employee employee = new Employee ( name, surname );
    if ( employeeList.contains ( employee ) ) {
        employeeList.remove ( employee );
        System.out.println ( "Сотрудник удален" + name + surname );
    }
    throw new EmployeeNotFoundException ("такой сотрудник не найден"  );
}

    public Employee find ( String name, String surname ) {
        Employee employee = new Employee ( name,surname );
        if ( employeeList.contains ( employee) ) {
            return employee;
        }
        throw new EmployeeNotFoundException ( "такой сотрудник не найден" );
    }

    @Override
    public Collection<Employee> findAll () {
        return new ArrayList<> (employeeList);
    }
}


