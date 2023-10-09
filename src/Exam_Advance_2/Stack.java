package Exam_Advance_2;

import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        int choice;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Nhập một câu: ");
                    inputStr = scanner.nextLine().trim();
                    break;
                case 2:
                    String result = reverseStr(inputStr);
                    System.out.println("Câu đảo ngược: " + result);
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }while (choice!=3);
    }


    public static String reverseStr(String inputStr) {
        String[] words = inputStr.split(" ");
        java.util.Stack<String> stk= new java.util.Stack<>();

        for (String word : words) {
            stk.push(word);
        }

        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
            if (!stk.isEmpty()) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
