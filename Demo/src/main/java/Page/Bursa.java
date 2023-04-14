package Page;

import Core.BasePage;
import Model.StockModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bursa extends BasePage {
    // Page file and custom page method script
    public Bursa(WebDriver driver) {
        super(driver);
    }

    private List<StockModel> stockModelArrayList = new ArrayList<>();

    @FindBy(xpath = "//h2[contains(text(),'Market Overview')]")
    private WebElement marketOverviewTxt;

    @FindBy(xpath = "//h2[contains(text(),'Market Overview')]//following-sibling::div//div[contains(@class,'active')]/table/tbody/tr/*[contains(text(),\"\")]")
    private List<WebElement> dataTable;

    @FindBy(xpath = "//h2[contains(text(),\"Market Overview\")]//following-sibling::div//div[contains(@id,\"active\")]//tbody/tr")
    private List<WebElement> dataRow;

    public void goToTable() {
        scrollTo(marketOverviewTxt);
    }

    public void getData(){
        for (int i = 0; i < dataRow.size(); i++) {
            String changeTemp = "";
            float change = 0;
            int data = i * 5;
            String code = dataTable.get(data).getText().trim();
            String name = dataTable.get(data+1).getText().trim();
            float lastDone = Float.parseFloat(dataTable.get(data+2).getText().trim().replace(",","."));
            changeTemp = dataTable.get(data+3).getText().trim().replace(",",".");
            if (changeTemp.equalsIgnoreCase("-")){
            } else {
                change = Float.parseFloat(changeTemp);
            }
            float vol = Float.parseFloat(dataTable.get(data+4).getText().trim().replace(",","."));
            stockModelArrayList.add(new StockModel(code,name,lastDone,change,vol));

        }
    }

    public void sortTable(String typeToSort){
        System.out.println("Before Soft : \n");
        String file = "Code | Name | LastDone | Change | Volume\n";
        for (int i = 0; i < stockModelArrayList.size(); i++) {
            file = file + stockModelArrayList.get(i) + "\n";
        }
        System.out.print(file);

        switch (typeToSort.toLowerCase().trim()){
            case("code"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getCode).reversed());
                break;
            case("name"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getName).reversed());
                break;
            case("lastDone"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getLastDone).reversed());
                break;
            case("change"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getChange).reversed());
                break;
            case("vol"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getCode).reversed());
                break;
            case("volume"):
                stockModelArrayList.sort(Comparator.comparing(StockModel::getCode).reversed());
                break;
            default:
                System.out.println("Default case is : sort Change");
                stockModelArrayList.sort(Comparator.comparing(StockModel::getChange).reversed());
                break;
        }
        System.out.println("\nAfter Soft : \n");
    }
    public void printData(){
        String file = "Code | Name | LastDone | Change | Volume\n";
        for (int i = 0; i < stockModelArrayList.size(); i++) {
            file = file + stockModelArrayList.get(i) + "\n";
        }
        System.out.print(file);
        String fileOutput = file.replace(" | ",";");
        createFileandWrite(fileOutput);
        System.out.print("\n");
        checkFile();
    }

}
