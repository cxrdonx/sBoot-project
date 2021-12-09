package com.springBoot.example.spring.boot.bean;

import com.springBoot.example.spring.boot.bean.PalindromWord;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PalindromWordImplementation implements PalindromWord {
    @Override
    public String str(String letter) {
          String newLetter  = letter.toLowerCase();
          StringBuilder str = new StringBuilder(newLetter);
          String wordReversed = str.reverse().toString();
        System.out.println(wordReversed);
            if(newLetter.equals(wordReversed)){
                return "palindrome";
            }else{
                return "not Palindrome";
            }
    }
}
