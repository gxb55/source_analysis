package com.trip.springbootsource.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.trip.springbootsource.module.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static void writeCsv(List<Object> datasParam, String myPath) {
        if (CollectionUtils.isEmpty(datasParam)) {
            return;
        }
        Field[] declaredFields = datasParam.get(0).getClass().getDeclaredFields();
        CSVWriter writer = null;
        try {
            URL resource = CSVUtil.class.getResource(myPath);
            File file = new File(CSVUtil.class.getResource("").getPath() + "/" + myPath);
            if (resource == null) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            writer = new CSVWriter(new FileWriter(resource.getPath()));
            String[] header = new String[declaredFields.length];
            for (int i = 0; i < header.length; i++) {
                header[i] = declaredFields[i].getName();
            }
            writer.writeNext(header);
            for (Object remove : datasParam) {
                String[] data1 = new String[declaredFields.length];
                for (int i = 0; i < header.length; i++) {
                    Field declaredField = declaredFields[i];
                    declaredField.setAccessible(true);
                    data1[i] = String.valueOf(ReflectionUtils.getField(declaredField, remove));
                }
                writer.writeNext(data1);
            }
            System.out.println("CSV written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public static <T> List<T> readCsv(String myPath, Class<T> o) {
        List<T> list = new ArrayList<>();
        CSVReader reader = null;
        try {
            URL resource = CSVUtil.class.getResource(myPath);
            if (resource == null) {
                return null;
            }
            reader = new CSVReader(new FileReader(resource.getPath()));
            List<String[]> allRows = reader.readAll();
            String[] strings = allRows.get(0);
            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                T o1 = (T) o.getConstructors()[0].newInstance();
                for (int j = 0; j < row.length; j++) {
                    Field field = o1.getClass().getDeclaredField(strings[j]);
                    field.setAccessible(true);
                    field.set(o1, getValue(row[j], field.getType()));
                }
                list.add(o1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        /*writeCsv(Arrays.asList(new User(1l, "aa", 1),new User(1l, "aa", 1),new User(1l, "aa", 1)), "user.csv");
         */
        List<User> list = readCsv("user.csv", User.class);
        System.out.println(list);
    }


    private static Object getValue(Object value, Class type) {
        if (value != null) {
            if (type.isAssignableFrom(String[].class))
                return toStringArray(value);
            if (type.isAssignableFrom(Integer[].class))
                return toIntegerArray(value);
            else if (type.isAssignableFrom(Integer.class) || type.isAssignableFrom(int.class))
                return toInteger(value);
            if (type.isAssignableFrom(Double.class) || type.isAssignableFrom(double.class))
                return toDouble(value);
            else if (type.isAssignableFrom(Boolean.class) || type.isAssignableFrom(boolean.class))
                return toBoolean(value);
            else if (type.isAssignableFrom(String.class))
                return toString(value);
            else if (type.isAssignableFrom(Long.class))
                return Long.valueOf(value.toString());
        }
        return null;
    }

    private static String[] toStringArray(Object value) {
        return value.toString().split(",");
    }

    private static Integer[] toIntegerArray(Object value) {
        String[] stringArray = toStringArray(value);
        Integer[] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private static Integer toInteger(Object value) {
        return Integer.parseInt(value.toString());
    }

    private static Double toDouble(Object value) {
        return Double.parseDouble(value.toString());
    }

    private static String toString(Object value) {
        return value.toString();
    }

    private static Boolean toBoolean(Object value) {
        return Boolean.parseBoolean(value.toString());
    }

}