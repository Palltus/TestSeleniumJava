import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args){

        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\ChromeWebDr\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://examples.sencha.com/extjs/6.5.3/examples/calendar/");

            Thread.sleep(5000);

            //переход во фрейм

            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"examples-iframe\"]")));

            // 1-ое событие, создание

            // Открытие окна Create

            WebElement buttonCreate = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                            elementToBeClickable(By.xpath("//*[@id=\"button-1019\"]")));
            buttonCreate.click();

            // Title

            WebElement titleText1 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"textfield-1039-inputEl\"]")));

            titleText1.sendKeys("Some Title");

            // Checkbox Allday

            driver.findElement(By.id("checkbox-1046-inputEl")).click();

            // Заполнение date FROM

            WebElement dateFrom = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"datefield-1041-trigger-picker\"]")));
            dateFrom.click();

            driver.findElement(By.xpath("/html/body/div[8]/div/table/tbody/tr[5]/td[2]/div")).click();

            // Заполнение date TO

            WebElement dateTo = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"datefield-1044-trigger-picker\"]")));
            dateTo.click();

            driver.findElement(By.cssSelector("#datefield-1044-picker-cell-29 > div")).click();

            // Time FROM
            WebElement timeFromList = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"timefield-1042-trigger-picker\"]")));
            timeFromList.click();


            WebElement timeFrom1 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By.xpath("//li[@class = 'x-boundlist-item' and contains(., '10:00 AM')]")));
            timeFrom1.click();

            // Time TO
            WebElement timeTo = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"timefield-1045-trigger-picker\"]")));
            timeTo.click();


            WebElement timeTo1 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By
                            .xpath("//*[@id=\"timefield-1045-picker-listWrap\"]//li[@class = 'x-boundlist-item' and contains(., '11:00 AM')]")));
            timeTo1.click();

            // Save event
            WebElement SaveEv = driver.findElement(By.xpath("//*[@id=\"button-1050-btnInnerEl\"]"));
            SaveEv.click();


            // 2-ое событие, создание
            // Открытие окна Create
            buttonCreate.click();

            //Title для 2 события
            WebElement titleText2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"textfield-1059-inputEl\"]")));
            titleText2.sendKeys("Some Title 2");

            // Checkbox Allday
            driver.findElement(By.id("checkbox-1066-inputEl")).click();

            // Заполнение date FROM
            WebElement dateFrom2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                elementToBeClickable(By.xpath("//*[@id=\"datefield-1061-trigger-picker\"]")));
            dateFrom2.click();

            driver.findElement(By.xpath("//*[@id=\"datefield-1061-picker-cell-29\"]/div")).click();

            //Time From
            WebElement timeFromList2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By.xpath("//*[@id=\"timefield-1062-trigger-picker\"]")));
            timeFromList2.click();

            WebElement timeFrom2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By
                            .xpath("//*[@id=\"timefield-1062-picker-listWrap\"]//li[@class = 'x-boundlist-item' and contains(., '12:00 PM')]")));
            timeFrom2.click();

            // Заполнение date TO
            WebElement dateTo2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By.xpath("//*[@id=\"datefield-1064-trigger-picker\"]")));
            dateTo2.click();

            driver.findElement(By.cssSelector("#datefield-1064-picker-cell-29 > div")).click();

            //Time To
            WebElement timeToClick = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By.xpath("//*[@id=\"timefield-1065-trigger-picker\"]")));
            timeToClick.click();


            WebElement timeTo2 = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.
                    elementToBeClickable(By
                            .xpath("//*[@id=\"timefield-1065-picker-listWrap\"]//li[@class = 'x-boundlist-item' and contains(., '1:00 PM')]")));
            timeTo2.click();

            // Save event
            WebElement SaveEv2 = driver.findElement(By.xpath("//*[@id=\"button-1070-btnInnerEl\"]"));
            SaveEv2.click();

            //Переход в сортировку по дням
            WebElement SortByDay = driver.findElement(By.xpath("//*[@id=\"button-1029\"]"));
            SortByDay.click();


            //Пролистываем до конца сентября
            WebElement Scroll = driver.findElement(By.xpath("//*[@id=\"button-1025\"]"));
            while (!driver.findElement(By.xpath("//*[@id=\"box-1026\"]"))
                        .getText().contains("Monday September 30, 2024")) {
                    Scroll.click();
                }
            //Чтение events в log

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ожидание основного блока
            WebElement mainBlock = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[2]/div[1]")));

            // ожидание событий
            List<WebElement> eventBlocks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".x-calendar-event")));

            // Вывод каждого события в лог
            for (WebElement eventBlock : eventBlocks) {
                // заголовок
                WebElement titleElement = eventBlock.findElement(By.cssSelector(".x-calendar-event-title"));
                String title = titleElement.getText();

                System.out.println("Title: " + title);

                // время начала и конца
                WebElement startTimeElement = eventBlock.findElement(By.cssSelector(".x-calendar-event-time-start"));
                WebElement endTimeElement = eventBlock.findElement(By.cssSelector(".x-calendar-event-time-end"));
                String startTime = startTimeElement.getText();
                String endTime = endTimeElement.getText();

                System.out.println("Start Time: " + startTime);
                System.out.println("End Time: " + endTime);

                // Разделитель
                System.out.println("-----------------");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
