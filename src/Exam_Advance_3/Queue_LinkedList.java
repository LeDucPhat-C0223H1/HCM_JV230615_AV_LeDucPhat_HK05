package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_LinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> parentQueue = new LinkedList<>();
        String inputStr = "";
        int choice;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-3-MENU***************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phụ huynh: ");
                    String parentName = scanner.nextLine();
                    parentQueue.add(parentName);
                    System.out.println("Đã thêm tên phụ huynh vào danh sách.");
                    System.out.println();
                    break;
                case 2:
                    if (!parentQueue.isEmpty()) {
                        String nextParent = parentQueue.poll();
                        System.out.println("Phụ huynh tiếp theo: " + nextParent);
                    } else {
                        System.out.println("Danh sách phụ huynh rỗng.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    System.out.println();
            }
        }while (choice!=3);
    }
}
