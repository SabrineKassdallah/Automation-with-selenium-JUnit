// cette page d'objet est dédiée pour l'interface qui contient des produits

package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ProductPage {
    // ces deux ligne pour identifier le boutton de filter
    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement buttonFilter ;

    // identifier l'option que je choisirai
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement filterLoHi;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> listePrice ;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement sauceBikeButton ;


    WebDriver driver ;

    public ProductPage(WebDriver driver) {

        this.driver = driver ;
        PageFactory.initElements(driver, this);
    }

    // cette méthode pour récupperer l'url de la page product

    public String getPageProductUrl() {
        return driver.getCurrentUrl(); // cette fonction créée depuis selenium pour récuperer l'url courant
    }

    public void setFilterLoHi() {
        buttonFilter.click();
        filterLoHi.click();
    }

    public Boolean isListInOrder() {
        // liste String vide ou on va récupérer tous les elements de notre list de Webelement
        List<String> list = new ArrayList<>();
        // Créer un boucle FOR , permet de lire chaque elements de listePrice pour les ajouter dans list
        for(WebElement orderListe : listePrice ) {
         // System.out.println(""+" " +orderListe.getText() );
            list.add(orderListe.getText().replaceAll("[^\\d]", ""));
        }
        // iterator = taille de notre liste
        Iterator<String> iterator = list.iterator();
        // convertir le premier element d'un iterator en un int
        int current, previous = Integer.parseInt(iterator.next());
        while (iterator.hasNext()){
            current = Integer.parseInt(iterator.next());
            if(previous > current) {
                return false;
            }
            previous =  current ;
        }
        return true;

    }


    public void clickAddToCartBikeLight() {

        sauceBikeButton.click();
    }
}
