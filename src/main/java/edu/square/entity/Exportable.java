package edu.square.entity;

import java.lang.reflect.Field;

public interface Exportable {
    default Object getFieldValue(int index) throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        Field field = fields[index];
        /*
         * set accessible to true
         * so that we can get the value of private field
         * again, this is not a good practice
         * which is against the encapsulation
         */
        field.setAccessible(true);
        return field.get(this);
    }
}
