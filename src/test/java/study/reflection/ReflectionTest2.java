package study.reflection;

import com.diy.app.Lecture;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReflectionTest2 {

    @Test
    @DisplayName("요구사항1 -> Lecture 생성자 찾기")
    void TestGetConstructors() {
        Class<Lecture> lectureClass = Lecture.class;

        Constructor<?>[] declaredConstructors = lectureClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
    }

    @Test
    @DisplayName("요구사항2 -> Lecture 인스턴스 동적 생성")
    void TestInstance()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Lecture> lectureClass = Lecture.class;

        Lecture lecture = lectureClass.getDeclaredConstructor().newInstance();
        lecture.setId(100L);

        System.out.println(lecture.getId());
    }
}
