package com.xzt.util;

import net.sourceforge.pinyin4j.PinyinHelper;

public class ChineseToPinyin {
    public static int getPinYinHeadChar(String str, char letter) {
        char word = str.charAt(0);
        //判断是否是字母
        int asc = (int) word;
        if ((asc >= 65 && asc <= 90) || (asc >= 97 && asc <= 122)) {
            String convert = String.valueOf(word);
            if (convert.toUpperCase().charAt(0) == letter) {
                //匹配成功
                return 1;
            } else {
                //匹配失败
                return 2;
            }
        } else if (String.valueOf(word).matches("[\u4e00-\u9fa5]")) {
            //提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            String convert = String.valueOf(pinyinArray[0].charAt(0));
            if (convert.toUpperCase().charAt(0) == letter) {
                //匹配成功
                return 1;
            } else {
                //匹配失败
                return 2;
            }
        } else {
            //数字开头等
            if (letter == '0') {
                return 0;
            } else {
                return 2;
            }
        }
    }

}
