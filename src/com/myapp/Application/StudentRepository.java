import java.util.List;
import java.util.Optional;

import com.myapp.Models.Entities.SchoolObjects.Student;

public interface StudentRepository {
    void add(Student student); // throw Duplicate nếu trùng tên
    Optional < Student > findByName(String name);
    List < Student > findAll();
    void remove(String name); // throw NotFound nếu không có
}