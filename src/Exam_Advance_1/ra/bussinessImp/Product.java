package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.business.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop, Comparable<Product> {

    private final float RATE = 1.3f;

    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = importPrice * RATE;
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
    }

    @Override
    public void inputData(List<Catalog> catalogList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mã sản phẩm: ");
        productId = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên sản phẩm: ");
        productName = scanner.nextLine();

        System.out.println("Nhập tiêu đề sản phẩm: ");
        title = scanner.nextLine();

        System.out.println("Nhập mô tả sản phẩm: ");
        descriptions = scanner.nextLine();

        System.out.println("Nhập giá nhập sản phẩm: ");
        importPrice = Float.parseFloat(scanner.nextLine());

        exportPrice = importPrice * RATE;


        System.out.println("Nhập danh mục sản phẩm theo các danh mục đã có:");
        for (Catalog catalog : catalogList) {
            System.out.println("Mã danh mục: " + catalog.getCatalogId() + ", Tên danh mục: " + catalog.getCatalogName());
        }
        int catalogId;
        boolean isExist = true;
        boolean check = false;
        while (isExist){
            catalogId = Integer.parseInt(scanner.nextLine());
            for (Catalog catalog : catalogList) {
                if (catalog.getCatalogId() == catalogId) {
                    this.catalog = catalog;
                    check = true;
                    break;
                }
            }
            if(check){
                isExist = false;
            }else {
                System.out.println("Nhập sai danh mục, mời nhập lại");
            }
        }


        System.out.println("Nhập trạng thái sản phẩm (true/false): ");
        productStatus = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + productId);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Tên danh mục sản phẩm: " + catalog.getCatalogName());
        System.out.println("Giá bán sản phẩm: " + exportPrice);
        System.out.println("Trạng thái: " + (productStatus ? "Hoạt động" : "Không hoạt động"));
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.exportPrice, o.exportPrice);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }


}
