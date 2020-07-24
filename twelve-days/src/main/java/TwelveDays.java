class TwelveDays {
    static String list[]={".","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth"};
    static String list2[]={".","a Partridge in a Pear Tree.","two Turtle Doves","three French Hens","four Calling Birds","five Gold Rings",
                       "six Geese-a-Laying","seven Swans-a-Swimming","eight Maids-a-Milking","nine Ladies Dancing",
                       "ten Lords-a-Leaping","eleven Pipers Piping","twelve Drummers Drumming"};
    static boolean flag=false;
    static String [] dp=new String[13];
    
    public static void fill(){                   
    dp[1]=list2[1];
    dp[2]=list2[2]+", and "+dp[1];
    for(int i=3;i<=12;i++){
        dp[i]=list2[i]+", "+dp[i-1];
    }
    flag=true;
}

    public static String line(int day){
    String initial="On the "+ list[day]+ " day of Christmas my true love gave to me: ";
    return initial;
}
    String verse(int verseNumber) {
       if(flag==false){
           fill();
       }
       String result="";
       result=line(verseNumber)+dp[verseNumber]+"\n";
       return result;
    }

    String verses(int startVerse, int endVerse) {
    String result=verse(startVerse);
    for(int i=startVerse+1;i<=endVerse;i++){
        result+="\n"+verse(i);
    }
    return result;
    }
    
    String sing() {
    return verses(1, 12);
    }
}
