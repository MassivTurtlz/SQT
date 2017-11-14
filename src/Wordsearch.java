
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Wordsearch
{ public static void main (String[] args)
{
    char[][] g1 = new char[20][20]; String[] g2 = new String[20];
    ArrayList<String> u1 = new ArrayList<String>(); ArrayList<Boolean>
        z1 = new ArrayList<Boolean>(); ArrayList<Integer> r1 = new ArrayList<Integer>();
    ArrayList<String> s1 = new ArrayList<String>();
    ArrayList<Boolean> z2 = new ArrayList<Boolean>();
    ArrayList<Boolean> z3 = new ArrayList<Boolean>();
    ArrayList<Boolean> z4 = new ArrayList<Boolean>(); final int K1 = 1;
    final int K2 = 2;final int K3 = 3;final int K4 = 0;int g5 = 0;
    try{FileReader reader = new FileReader ("grid.txt");
        BufferedReader gridFile
                = new BufferedReader(reader);
        String t6; int n2 = 0; boolean e1 = false;
        t6 = gridFile.readLine(); g5 = t6.length();
        if (g5 <= 4 || g5 >= 22 )
        {System.out.println("Grid size out of range");
            e1 = true;}else{g2[0] = t6;
            n2 = 1;for (int i=0;
                        e1 == false && i < t6.length(); i++){
                if (!Character.isUpperCase(t6.charAt(i)))
                {e1 = true;System.out.println("Non-uppercase character in grid");
                }}}while (e1 == false
                && (t6 = gridFile.readLine())
                != null){if (t6.length() != g5){
            System.out.println("Grid not square");e1 = true;}else
        {g2[n2] = t6;n2++;

            {
                for (int i=0;  e1 == false
                        && i < t6.length(); i++){
                    if (!Character.isUpperCase(t6.charAt(i)))
                    {e1 = true;System.out.println("Non-uppercase character in grid");
                    }
                }}
        }
        }if (e1 == false && n2 < g5)
        {System.out.println("Grid not square");
            e1 = true;
        }else{if (e1 == false){for (int i=0; i < g5; i++)
        {for (int j=0; j < g5; j++)
        {g1[i][j] = g2[i].charAt(j);}}}}reader.close();
    }catch (FileNotFoundException e)
    { System.out.println("Cannot open file");
        System.exit(1);}catch (IOException e)
    { System.out.println("Cannot open file");System.exit(1);}
    try {FileReader reader
            = new FileReader ("words.txt");
        BufferedReader wordsFile
                = new BufferedReader(reader); String t6;
        boolean w1 = false;  while ((t6 = wordsFile.readLine())
                != null){
            String temp = ""; for (int i=0; i<t6.length(); i++)
            {   if (Character.isLetter(t6.charAt(i)))
            {  String temp2 = t6.substring(i,i+1);
                temp = temp + temp2.toUpperCase();  }
            }if (temp.length()>0){int p6 = u1.size();
                for (int j=0; j<u1.size(); j++)
                {if (temp.compareTo(u1.get(j))<0){p6 = j;}}u1.add(p6, temp);
                z2.add(p6, false);z3.add(p6, false);z4.add(p6, false);
                if (u1.get(p6).length() < 3)
                {
                    z1.add(p6, true); r1.add(p6, K1);}else{z1.add(p6, false);
                    r1.add(p6, K4);
                    w1 = true;
                }s1.add(p6, "");}}reader.close();if (w1 == false){
            System.out.println("No valid words in words.txt");
            System.exit(1);}else{int
                n4 = u1.size(); for (int i=0; i<n4-1; i++){if (!z1.get(i))
        {String thisWord
                = new String (u1.get(i)); for (int j=i+1; j<n4-1; j++){if (!z1.get(j)){
            String thatWord = new String (u1.get(j)); if (thisWord.equals(thatWord))
            {z1.set(j, true);r1.set(j, K2);}}}}}for (int i=0; i<n4; i++)
        {if (!z1.get(i)){String t8 = new String (u1.get(i));
            int l3
                    = t8.length(); char[] thing = new char[l3];
            for (int j=0; j<l3; j++){thing[j] =
                    t8.charAt(j);}boolean whatever
                    = true;for (int j=0; j<l3 && whatever; j++)
            {if (thing[j] != thing[l3-j-1]){whatever = false;}}
            z2.set(i, whatever);}{String
                t8 = new String (u1.get(i));int t7 = t8.length();
            for (int j=0; j<n4; j++){if (i!=j && !z1.get(j)){
                String x0 = new String (u1.get(j));int q8 = x0.length();
                if (q8 > t7){for (int k=0; k<=q8-t7; k++){if
                        ((t8.charAt(0) == x0.charAt(k))
                                && t8.equals(x0.substring(k, k+t7))){z1.set(i, true);
                    r1.set(i, K3);s1.set(i, x0);}} }}}String b6 = "";for
                    (int j=t7-1; j>=0; j--){b6 = b6 + t8.substring(j, j+1);}
            for (int j=i+1; j<n4; j++){if (!z1.get(j)){String
                    x0 = new String (u1.get(j));if (b6.equals(x0)){
                z3.set(i, true);z3.set(j, true);} }}}}}}
    catch (FileNotFoundException e)
    { System.out.println("Cannot open file");
        System.exit(1);
    }catch (IOException e){ System.out.println("Cannot open file");
        System.exit(1);
    }try{FileWriter writer = new FileWriter ("results.txt");
    PrintWriter resultsFile =
            new PrintWriter(writer);for (int i=0; i<u1.size(); i++)
    {resultsFile.print(u1.get(i) + " ");if(z1.get(i)){
        resultsFile.print("- removed from list - ");
        String s3[] = {"less than 3 letters", "duplicate", "subset of "};
        resultsFile.print(s3[r1.get(i)-1]);if (r1.get(i) == K3)
        {resultsFile.print(s1.get(i));}}else {if
            (z2.get(i)){resultsFile.print("- is palindroom - ");}
    else if (z3.get(i)){
        resultsFile.print("- is reversal - ");}String
            s5 = new String(u1.get(i));int v7 = s5.length();char[]v3 =
            new char [v7];for (int j=0; j<v7; j++){v3[j] = s5.charAt(j);
    }for (int r=0; r<g5; r++){for (int s=0; s<g5; s++){
        if (v3[0] == g1[r][s]){int r0=r+1;int s0=s+1;
            int t=0;for (t=1; t<v7 && (s+t)<g5 && (!z4.get(i))
                    && v3[t] == g1[r][s+t]; t++); if (t == v7) {
                if (z4.get(i) == true) { resultsFile.println();
                    resultsFile.print("and "); }
                resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 +
                        " horizontal forward");
                z4.set(i, true); }  t=0; for (t=1; t<v7  && (s-t)>=0
                    && v3[t] == g1[r][s-t]; t++)
                ; if (t == v7) { if (z4.get(i) == true) {
                resultsFile.println();
                resultsFile.print("and "); }
                resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 +
                        " horizontal backward");
                z4.set(i, true); } t=0;
            for (t=1; t<v7
                    && (r-t)>=0
                    && v3[t] == g1[r-t][s];
                 t++);
            if (t == v7) { if (z4.get(i) ==
                    true) { resultsFile.println(); resultsFile.print("and ");
            } resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 + " vertical up");
                z4.set(i, true);
            }t=0;for (t=1; t<v7
                    && (r+t)<g5
                    && v3[t] == g1[r+t][s];t++);if (t == v7){
                if (z4.get(i) == true){resultsFile.println();
                    resultsFile.print("and ");
                }resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 +
                        " vertical down");
                z4.set(i, true);
            }t=0;for (t=1; t<v7 && (r-t)>0 && (s+t)<g5
                    && v3[t] == g1[r-t][s+t]; t++);  if (t == v7) {
                if (z4.get(i) == true) { resultsFile.println();
                    resultsFile.print("and "); }
                resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 + " diagonal down");
                z4.set(i, true); }
            t=0; for (t=1; t<v7
                    && (r+t)<g5 && (s+t)<g5 && v3[t] == g1[r+t][s+t];
                      t++); if (t == v7) { if (z4.get(i) == true) {
                resultsFile.println();resultsFile.print("and ");}
                resultsFile.print("starts at row " + r0);
                resultsFile.print(" column " + s0 +
                        " diagonal down");
                z4.set(i, true);} }}} if (z4.get(i)==false){
        resultsFile.print("- not found");}}resultsFile.println();
    }resultsFile.close();} catch
        (FileNotFoundException e)
{ System.out.println("Cannot open results.txt");
}catch (IOException e)
{ System.out.println("Cannot write to results.txt");}}}
