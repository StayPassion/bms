package com.xzt.util;

import net.sourceforge.pinyin4j.PinyinHelper;

public class ChineseToPinyin {
    public static char getPinYinHeadChar(String str){
        char word = str.charAt(0);
        //判断是否是字母
        int asc = (int)word;
        if ((asc>=65 && asc<=90)||( asc>=97 && asc <= 122)){
            String convert = String.valueOf(word);
            return convert.toUpperCase().charAt(0);
        }else {
            //提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            String convert = String.valueOf(pinyinArray[0].charAt(0));
            return convert.toUpperCase().charAt(0);
        }
    }

}
