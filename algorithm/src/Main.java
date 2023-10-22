import com.sun.source.tree.MethodInvocationTree;

import javax.naming.directory.DirContext;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.ResolutionException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.zip.CheckedInputStream;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("배열의 크기를 입력하세요 : ");

        int n=0;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("에외 발생 : " + e);
        }

        System.out.println("배열 요소를 입력해주세요. ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            int value = map.get(key);
            if(value >= 2) {
                int[] arr = new int[value];
                Arrays.fill(arr, key);
                System.out.print(Arrays.toString(arr) + " ");
            }
        }


    }
}



