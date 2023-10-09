package Exam_Advance_1.ra.business;

import Exam_Advance_1.ra.bussinessImp.Catalog;

import java.util.List;

public interface IShop {
    float RATE = 1.3F;
    void inputData();
    void inputData(List<Catalog> catalogList);
    void displayData();
}
