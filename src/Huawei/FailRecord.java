package Huawei;

import java.util.*;

public class FailRecord {

    static String[] paths = {"G:\\rp\\onajqj\\maahmq 631" ,
            "E:\\njfgjkcrh 641" ,
//            "F:\\vylww\\zhh\\cqekvaxypemktyurn 643" ,
//            "C:\\njfgjkcrh 637\n" ,
//            "F:\\bfn\\dxwjje\\jmfdahkeffyjjsf 632" ,
//            "E:\\bxgxjfgrwckfxekeqro 634" ,
            "G:\\gwuusj\\ized\\qq\\szxcdhlaytgj 646" ,
            "F:\\arefkiz 644" ,
            "G:\\zsw\\uewu\\arefkiz 634" ,
            "E:\\ja\\zg\\njfgjkcrh 644" ,
            "D:\\gfute\\ju\\wuy\\szxcdhlaytgj 636" ,
            "C:\\mpgcx\\kcgi\\arefkiz 645" ,
            "C:\\zayn\\jmfdahkeffyjjsf 648" ,
            "F:\\kkplu\\avvw\\hbzmwj\\jmfdahkeffyjjsf 648" ,
            "E:\\maahmq 631" ,
            "E:\\hs\\xnto\\jmfdahkeffyjjsf 645" ,
            "G:\\cqekvaxypemktyurn 633" ,
            "D:\\maahmq 646" ,
            "E:\\jmfdahkeffyjjsf 636" ,
            "G:\\hbvm\\szxcdhlaytgj 642"
    };

    public static void main(String[] args) {
        FIFOLinkedHashMap map = new FIFOLinkedHashMap(8);
        Set<String> uniqueKey = new HashSet<>();
        for(String line : paths) {
            Integer count;
            line = getLimitPath(line);
            if ((count = map.get(line)) != null) {
                map.put(line, count+1);
                uniqueKey.add(line);
            } else if (!uniqueKey.contains(line)){
                map.put(line, 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static String getLimitPath(String path) {
        String[] pathAndNum = path.split(" ");
        String[] split = pathAndNum[0].split("\\\\");
        String last = split[split.length - 1];
        if (last.length() > 16) {
            last = last.substring(last.length() - 16);
        }
        return last + " " + pathAndNum[1];
    }

    static class FIFOLinkedHashMap extends LinkedHashMap<String,Integer> {
        int maxSize;
        FIFOLinkedHashMap(int maxSize) {
            super(maxSize);
            this.maxSize = maxSize;
        }

        protected boolean removeEldestEntry(Map.Entry eldest)
        {
            return size() > maxSize;
        }
    }
}
