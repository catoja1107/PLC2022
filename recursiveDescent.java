import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
GRAMMAR:

M ---> { S } ' # '
S ---> I | W | A | P | C | G
I ---> ' [ ' E ' ? ' { S } ' : ' { S } ' ] ' | ' [ ' E ' ? ' { S } ' ] '
W --- > ' { ' E ' ? ' { S } ' } '
A --- > lower-case ' - ' E ' ; '
P --- > ' < ' E ' ; '
G ---> ' ' . ' lower case ' ; '
C ---> ' < ' upper case ' ; '
E ---> T { ( ' + ' | ' - ' ) T }
T ---> U { ( ' * ' | ' / ' | ' % ' ) U }
U ---> F ' ^ ' U | F
F ---> ' ( ' E ' ) ' | lower case | digit
*/

public class recursiveDescent {
  private static class Parser {
    private StringBuilder buffer;
    public Parser(File file) {
      Scanner sc = null;
      try {
        sc = new Scanner(file);
        buffer = new StringBuilder((int) file.length());
        while (sc.hasNext()) {
          String token = sc.next();
          StringTokenizer tokens = new StringTokenizer(token, "()+-*/=;", true);

          while (tokens.hasMoreTokens())
            buffer.append(tokens.nextToken() + " ");
        }
      } catch (FileNotFoundException e) {
        System.out.print("File not found.");
        e.printStackTrace();
      } finally {
        sc.close();
      }
    }
    private String lexer() {
      int i = buffer.indexOf(" ");
      String lexeme = buffer.substring(0, i);
      buffer.delete(0, i + 1);
      System.out.println(lexeme); //debug
      return lexeme;
    }
    public boolean analyzeCode() {
      return program();
    }
    private boolean variable() {
      if (!lexer().matches("[a-zA-Z0-9]*")) return false;
      return true;
    }
    private boolean program() {
      if (!lexer().toLowerCase().equals("start")) return false;
      if (!lexer().toLowerCase().equals("end")) return false;
      if (!variable()) return false;
      return true;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("File name: ");
    String name = sc.next();
    File file = new File(name);
    Parser parser = new Parser(file);
    if (!parser.analyzeCode())
      System.out.print("There are no syntax errors in the program.");

    else
      System.out.print("The program contains syntax errors.");
  }
}
