package Java8Feature;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] arg) {
          Supplier dateSupplier = () -> new Date();

        System.out.println(dateSupplier.get());
        System.out.println(dateSupplier.get());
        System.out.println(dateSupplier.get());

        Supplier nameSupplier = () -> {

            List<String> name = Arrays.asList("Aarav", "Ambar", "Ruchi", "Shivangi");
            return name.get((int) (Math.random() * 4));
        };

        System.out.println(nameSupplier.get());
        System.out.println(nameSupplier.get());
        System.out.println(nameSupplier.get());
        System.out.println(nameSupplier.get());


        Supplier otpSupplier = () ->
        {
            String otp = "";
             for(int i =0;i<=6 ; i++){
                  otp = otp+ (int)(Math.random()*10);
          }

            return otp;
        };

        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());

        Supplier<String> passwordSupplier = () -> {
            String password = "";
            Supplier<Character> c1 = () -> {
                Character[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '@', '#', '$', '^', '&', '*', '!'};
                return cArr[(int) (Math.random() * 33)];
            };
            Supplier<Integer> i1 = () -> {
                return (int) (Math.random() * 10);
            };
            for (int i = 0; i <= 6; i++) {
                if (i % 2 == 0) {
                    password = password + c1.get();
                } else {
                    password = password + i1.get();
                }
            }
            return password;
        };

        System.out.println(passwordSupplier.get());
        System.out.println(passwordSupplier.get());
        System.out.println(passwordSupplier.get());
        System.out.println(passwordSupplier.get());
        System.out.println(passwordSupplier.get());
        System.out.println(passwordSupplier.get());
    }
}
