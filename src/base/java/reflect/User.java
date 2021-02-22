package base.java.reflect;

import java.lang.reflect.ParameterizedType;

abstract class Base<T> {
    public Base() {
        Class clazz = this.getClass();
        ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();
        clazz = (Class) pt.getActualTypeArguments()[0];
        System.out.println(clazz);
    }
}

public class User extends Base<Integer> {
    public static void main(String[] args) {
        Base<Integer> user = new User();
    }
}
