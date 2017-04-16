package com.IoA;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Honsen on 2016/10/15.
 * @author Honsen
 */
public class IoA01 {

    private final static String FILEPATH = "D:\\whoami\\Junior\\IoA\\";//文件路径
    private static String INPUT    = "input.dat";//输入文件
    private static String OUTPUT   = "output.dat";//输出文件
    private static int count=0;
    public static void main(String[] args) throws IOException {
        //读取文件
//        INPUT = args[0];//参数1 输入文件
//        OUTPUT = args[1];//参数2 输出文件
        String input = read(FILEPATH+INPUT);
        String[] strArray = input.split(" ");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (String s:strArray){
            if(!s.equals("")&&!s.equals("-----------------------------------------")){
                if (!map.containsKey(s))
                    map.put(s,1);
                else
                    map.put(s,map.get(s)+1);
                count++;
            }
        }
        ArrayList<Map.Entry<String,Integer>> list =new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            //降序排序
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                //return o1.getValue().compareTo(o2.getValue());
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
        //归并排序
//        Sort.mergeSort(list,0,list.size()-1);
        //快速排序
//        Sort.quickSort(list,0,list.size()-1);
        //堆排序
        Sort.heapSort(list);
        //插入排序
//        Sort.insertSort(list);
        if (write(OUTPUT,strArray,list))
            System.out.println("成功");;
    }

    /**
     * 读取文件
     * @param filename 数据来源文件
     * @return 返回读取并过滤的数据 (String)
     * @throws IOException io异常
     *
     */
    private static String read(String filename) throws IOException {
        //设置按照 ISO8859-1编码格式进行读取
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"ISO8859-1"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s).append("\n");
        in.close();
        String result = sb.toString();
        //正则直接过滤掉非法字符
        Pattern pattern = Pattern.compile("[0-9]|[\n.%+,\\[\\])(/:;'\"]");
        Matcher matcher = pattern.matcher(result);
        result = matcher.replaceAll(" ");
//        count = result.length();
        return result;
    }

    /**
     * 写入文件
     * @param filename 数据输出文件
     * @param strArray 输入字符串的分词
     * @param list 分词之后的排序结果，一个键值对的 arrayList
     * @return true:写入成功 false: 写入失败
     * @throws IOException io异常
     *
     */
    private static boolean write(String filename,String[] strArray,ArrayList<Map.Entry<String,Integer>> list) throws IOException{
        File file = new File(FILEPATH+OUTPUT);
        FileWriter writer = new FileWriter(file);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"ISO8859-1"));
        System.out.println(count);
        out.write(count+"\r\n");
        for (Map.Entry<String, Integer> mapping : list) {
            //
            System.out.print(mapping.getKey() + ":" + mapping.getValue());
            out.write(mapping.getKey() + ":" + mapping.getValue());
            int j=0;
            for (String s : strArray) {
                if (s.equals(mapping.getKey())) {
                    //
                    System.out.print(" " + (j + 1));
                    out.write(" " + (j + 1));
                }
                //忽视特殊情况
                if (!s.equals("") && !s.equals("-----------------------------------------"))
                    j++;
            }
            System.out.println();
            out.write("\r\n");
        }
        out.flush();
        out.close();
        return true;
    }

}
