package org.lscx.utils;



import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Tools{




    //从html中提取纯文本
    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {System.err.println("Html2Text: " + e.getMessage()); }
        //剔除空格行
        textStr=textStr.replaceAll("[ ]+", " ");
        textStr=textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
        return textStr;// 返回文本字符串
    }

    /**
     * 实现JavaBean绑定ResultSet
     * 此方法有点问题，目前废弃
     **/
    @SuppressWarnings("unchecked")
    public static List resultSetToList(ResultSet rs, Class cls)throws Exception {


        //取得Method
        Method[] methods = cls.getMethods();
        System.out.println(methods[0].getName());
        List lst = new ArrayList();
        // 用于获取列数、或者列类型
        ResultSetMetaData meta = rs.getMetaData();
        Object obj = null;
        while (rs.next()) {
            // 获取formbean实例对象
            obj = cls.newInstance(); // 用Class.forName方法实例化对象和new创建实例化对象是有很大区别的，它要求JVM首先从类加载器中查找类，然后再实例化，并且能执行类中的静态方法。而new仅仅是新建一个对象实例
            // 循环获取指定行的每一列的信息
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                // 当前列名
                String colName = meta.getColumnName(i);

                // 设置方法名
                String setMethodName = "set" + colName;


                //遍历Method
                for (int j = 0; j < methods.length; j++) {
                    if (methods[j].getName().equalsIgnoreCase(setMethodName)) {
                        setMethodName = methods[j].getName();

                        System.out.println(setMethodName);
                        // 获取当前位置的值，返回Object类型
                        Object value = rs.getObject(colName);
                        if(value == null){
                            continue;
                        }

                        //实行Set方法
                        try {
                            //// 利用反射获取对象
                            //JavaBean内部属性和ResultSet中一致时候
                            Method setMethod = obj.getClass().getMethod(
                                    setMethodName, value.getClass());
                            setMethod.invoke(obj, value);
                        } catch (Exception e) {
                            //JavaBean内部属性和ResultSet中不一致时候，使用String来输入值。
                            Method setMethod = obj.getClass().getDeclaredMethod(setMethodName, Object.class);
                            setMethod.invoke(obj, String.valueOf(value));
                            //e.printStackTrace();
                        }
                    }
                }
            }
            lst.add(obj);
        }

        return lst;

    }

}