package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    private static List<Catalog> catalogList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    inputCatalogs(scanner);
                    System.out.println();
                    break;
                case 2:
                    inputProducts(scanner);
                    System.out.println();
                    break;
                case 3:
                    sortProductsByPrice();
                    System.out.println();
                    break;
                case 4:
                    searchProductByCatalog(scanner);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    System.out.println();
                    break;
            }
        } while (choice != 5);
    }

    private static void inputCatalogs(Scanner scanner) {
        System.out.print("Nhập số danh mục sản phẩm cần thêm: ");
        int numCatalogs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCatalogs; i++) {
            Catalog catalog = new Catalog();
            System.out.println("* Nhập thông tin danh mục thứ " + (i + 1)+"*");
            catalog.inputData();
            catalogList.add(catalog);
            System.out.println();
        }

        System.out.printf("Đã thêm %d danh mục mới thành công\n", numCatalogs);
    }

    private static void inputProducts(Scanner scanner) {
       if(catalogList.size()==0) {
           System.out.println("Chưa nhập danh mục sản phẩm. Hãy nhập danh mục sản phẩm trước!");
       }else {
           System.out.print("Nhập số sản phẩm cần thêm: ");
           int numProducts = Integer.parseInt(scanner.nextLine());

           for (int i = 0; i < numProducts; i++) {
               Product product = new Product();
               System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
               product.inputData(catalogList);
               productList.add(product);
           }
       }
    }

    private static void sortProductsByPrice() {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm trong kho");
            return;
        }
        Collections.sort(productList);
        System.out.println("Đã sắp sắp xếp sản phẩm theo lợi nhuận tăng dần");
        for (Product product : productList) {
            product.displayData();
            System.out.println();
        }
    }

    private static void searchProductByCatalog(Scanner scanner) {
        if (productList.isEmpty()) {
            System.out.println("Không có sản phẩm trong kho");
        } else {
            System.out.println("Nhập tên danh mục: ");
            String inputtName = scanner.nextLine();
            boolean found = false;
            System.out.println("\n Kết quả tìm kiếm");
            for (Product p :
                    productList) {
                if (p.getCatalog().getCatalogName().contains(inputtName)) {
                    p.displayData();
                    System.out.println("-------------------------------------");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sản phẩm");
            }
        }

    }
}
