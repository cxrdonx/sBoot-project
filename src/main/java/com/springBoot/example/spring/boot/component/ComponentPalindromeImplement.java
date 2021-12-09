package com.springBoot.example.spring.boot.component;

import com.springBoot.example.spring.boot.bean.PalindromWord;
import com.springBoot.example.spring.boot.bean.ShowPalindromeLetter;
import org.springframework.stereotype.Component;

@Component
public class ComponentPalindromeImplement implements ShowPalindromeLetter {
    PalindromWord palindromWord;

    public ComponentPalindromeImplement(PalindromWord palindromWord){
        this.palindromWord = palindromWord;
    }
    @Override
    public void ShowPalindromeLetter() {
         String word = "arenera";
        System.out.println("palabra palindroma o no:");
        System.out.println(palindromWord.str(word));
    }
}
