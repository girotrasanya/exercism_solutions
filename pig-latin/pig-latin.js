//
// This is only a SKELETON file for the 'Pig Latin' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

import { workerData } from "worker_threads"

export class translator {
  static startsWithVowel(word){
    let pat=/^[aeiou]|^xr|^yt/;
    let result=pat.test(word);
    return result;
  }
  static startsWithConsonant(word){
    let pat=/[^aeiou]/;
    let result=pat.test(word);
    return result;
  }
  static translateWord(word){
      if(this.startsWithVowel(word))
        word=word+"ay";
      
      else if(word.startsWith("qu"))
        word=word.substr(2)+"qu"+"ay";
      
      else if(this.startsWithConsonant(word) && word.substr(1,2)=="qu")
        word=word.substr(3)+word.substr(0,3)+"ay";
      
      else if(this.startsWithConsonant(word)){
        let pat;
        if(!word.startsWith("y"))
        pat=/[aeiouy]/;
        else
        pat=/[aeiou]/
        let idx=word.match(pat).index;
        word=word.substr(idx)+word.substr(0,idx)+"ay";
      }

       return word;
   }
  static translate(str) {
    var result="";
    var arr=str.split(" ");
    let word=this.translateWord(arr[0]);
    result+=word;
    
    for(let i=1;i<arr.length;i++){
        let word=this.translateWord(arr[i]);
        result+=" "+word;
    }
    return result;    
  }
}
