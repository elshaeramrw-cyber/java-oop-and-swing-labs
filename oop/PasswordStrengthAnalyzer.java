void main(){
    Scanner pass = new Scanner(System.in);
    System.out.println("enter your password : ");
    String pword= pass.nextLine();
    System.out.println("password length is: "+ pword.length());
    if (pword.length()<8){
        if (pword.isEmpty()){
          System.out.println("no password");  
        }else{
           System.out.println("less than 8 charactrs"); 
        }
    }
    int upper=0;
    int lower=0;
    int digits=0;
    int spchar=0;
    for (int i=0; i<pword.length();i++){
        char a=pword.charAt(i);
        if (Character.isUpperCase(a)){
            upper++;
        }else if (Character.isLowerCase(a)){
            lower++;
        }else if (Character.isDigit(a)){
            digits++;
        }else {
            spchar++;
        }
    }
    System.out.println("Uppercase letters count: "+ upper);
    System.out.println("Lowercase letters count: "+ lower);
    System.out.println("digits count: "+ digits);
    System.out.println("Special characters count: "+ spchar);
    System.out.println("first character "+ pword.charAt(0));
    System.out.println("last character "+ pword.charAt(pword.length()-1));
    System.out.println("does it  contain @ :"+ (pword.indexOf('@') >= 0 ? "yes" : "no"));  
    System.out.println("password in Uppercase : "+ pword.toUpperCase());
    boolean isupper=false;
    boolean islower=false;
    boolean isdigits=false;
    if (upper > 0){
        isupper=true;
        }
    if (lower > 0){
        islower=true;
        
    }
    if (digits > 0){
        isdigits=true;
        
    }
    System.out.println("Contains Uppercase letters " + isupper);
    System.out.println("Contains Lowercase letters " + islower);
    System.out.println("Contains digits " + isdigits);
}