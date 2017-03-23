public class Reverse {
  public static void main(String... args){
    String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a function that can reverse a String, which is passed as the parameter
    // Use it on this reversed string to check it!
    // Try to solve this using charAt() first, and optionally anything else after.

    reversed = reverse(reversed).toString();
    System.out.println(reversed);
  }

  public static StringBuilder reverse(String inStr) {
    StringBuilder outStr = new StringBuilder(inStr);
    for (int i = 0; i < inStr.length() / 2; i++) {
      outStr.setCharAt(i, inStr.charAt(inStr.length() - 1 - i));
      outStr.setCharAt(inStr.length() - 1 - i, inStr.charAt(i));
    }

    return outStr;
  }
}