package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardYourCards {
    private SelenideElement replenishFirstCardButton = $("[class=button__content]");
    private SelenideElement replenishSecondCardButton = $$("[class=button__content]").get(1);
    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DashboardPage replenishFirst() {
        replenishFirstCardButton.click();
        return new DashboardPage();
    }

    public DashboardPage replenishSecond() {
        replenishSecondCardButton.click();
        return new DashboardPage();
    }

}
