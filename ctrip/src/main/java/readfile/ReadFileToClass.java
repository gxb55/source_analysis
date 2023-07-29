package readfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author xbguo
 * @date 2023/6/30 16:13
 */
public class ReadFileToClass {
    public static void main(String[] args) throws Exception {
        //handler();
        handler2();
    }

    private static void handler2() throws Exception {
        String path1 = "D:\\WorkSpace\\vscode\\txt\\basicOrderDetail1.txt";
        String before = "D:\\WorkSpace\\vscode\\txt\\\\java\\";
        FileInputStream inputStream = new FileInputStream(path1);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        BufferedWriter bufferedWriter = null;
        List<String> list = new ArrayList<>();
        while ((str = bufferedReader.readLine()) != null) {
            str = str.trim();
            if (str.startsWith("class")) {
                if (bufferedWriter != null) {
                    writeGetAndSet(bufferedWriter,list);
                    bufferedWriter.flush();
                    list.clear();
                }
                String[] s = str.split(" ");
                String substring = s[1].substring(0, s[1].length() - 1);
                FileOutputStream outputStream = new FileOutputStream(before + substring + ".java");
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            }
            if (str.endsWith(";")) {
                String[] s1 = str.split(" ");
                if (s1.length == 2) {
                    String s2 = s1[0];
                    String substring = s1[1].substring(0, s1[1].length() - 1);
                    list.add(changeAttributes(s2)+"_"+changeName(substring));
                    //属性
                    String s = "private " + changeAttributes(s2) + " " + changeName(substring) + ";";
                    bufferedWriter.write(s);
                } else {
                    bufferedWriter.write("private " + str);
                }
            } else if (str.startsWith("class")) {
                String s = str.substring(0, str.length() - 1) + " implements  java.io.Serializable { ";
                bufferedWriter.write("public " + s);
                bufferedWriter.write(System.getProperty("line.separator"));
                bufferedWriter.write(" private static final long serialVersionUID = -1;");
            } else if(str.equals("}")){
                //bufferedWriter.write(str);
            }else{
                bufferedWriter.write(str);
            }
            bufferedWriter.write(System.getProperty("line.separator"));
        }
        //close
        inputStream.close();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void writeGetAndSet(BufferedWriter bufferedWriter, List<String> list) throws Exception {
        for (String s:list){
            String[] s1 = s.split("_");
            if(s1.length==2){
                String s2 = s1[0];
                String s3 = s1[1];
                //首字符大写
                String name = getName(s3);
                bufferedWriter.write("public "+s2+" get"+getName(s3)+"(){ return "+s3+";}");
                bufferedWriter.write(System.getProperty("line.separator"));
                bufferedWriter.write("public void  set"+name+"("+s2+" "+s3+") { this."+s3+"="+s3+"; };");
                bufferedWriter.write(System.getProperty("line.separator"));

            }
        }
        bufferedWriter.write("}");
        bufferedWriter.write(System.getProperty("line.separator"));
    }

    private static String getName(String substring) {
        String substring1 = substring.substring(0, 1);
        String substring2 = substring.substring(1);
        return substring1.toUpperCase(Locale.ROOT)+substring2;
    }

    private static String changeName(String substring) {
        String substring1 = substring.substring(0, 1);
        String substring2 = substring.substring(1);
        return substring1.toLowerCase(Locale.ROOT)+substring2;
    }

    private static String changeAttributes(String s2) {
        if (s2.equals("string")) {
            return "String";
        } else if (s2.equals("list")) {
            return "List";
        } else if (s2.equals("decimal")) {
            return "java.math.BigDecimal";
        } else if (s2.equals("datetime")) {
            return "java.util.Calendar";
        }else if(s2.equals("bool")){
            return "Boolean";
        }
        return s2;
    }

    private static void handler() throws IOException {
        String path = "D:\\WorkSpace\\vscode\\txt\\basicOrderDetail.txt";
        String path1 = "D:\\WorkSpace\\vscode\\txt\\basicOrderDetail1.txt";
        FileOutputStream outputStream = new FileOutputStream(path1);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        String last = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (!str.contains("@com.fasterxml.jackson.annotation.J")) {
                bufferedWriter.write(str);
            }
            if (last != null && last.contains("@com.fasterxml.jackson.annotation.J")) {
                bufferedWriter.write(";");
            }
            bufferedWriter.write(System.getProperty("line.separator"));
            last = str;
        }
        //close
        inputStream.close();
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
    }
}
