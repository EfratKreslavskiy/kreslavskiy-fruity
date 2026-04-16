package kreslavskiy.fruity;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;


public class FruitController
{
    private final FruityService service;
    private final JLabel picture;
    private final JTextField name;
    private final JLabel family;
    private final JLabel order;
    private final JLabel genus;
    private final JLabel calories;
    private final JLabel fats;
    private final JLabel sugars;
    private final JLabel carbs;
    private final JLabel proteins;

    public FruitController(FruityService service, JLabel picture, JTextField name, JLabel family, JLabel order,
                           JLabel genus, JLabel calories, JLabel fats, JLabel sugars, JLabel carbs, JLabel proteins)
    {
        this.service = service;
        this.picture = picture;
        this.name = name;
        this.family = family;
        this.order = order;
        this.genus = genus;
        this.calories = calories;
        this.fats = fats;
        this.sugars = sugars;
        this.carbs = carbs;
        this.proteins = proteins;
    }

    public void doSearch()
    {
        String fruitName = name.getText();
        Disposable disposable = service.getFruit(fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())
                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities:: invokeLater))
                .subscribe(
                        this:: handleResponse,
                        Throwable:: printStackTrace);
    }

    private void handleResponse(Fruit fruit)
    {
        family.setText(fruit.family());
        order.setText(fruit.order());
        genus.setText(fruit.genus());
        Nutritions nutritions = fruit.nutritions();
        calories.setText(String.valueOf(nutritions.calories()));
        fats.setText(String.valueOf(nutritions.fat()));
        sugars.setText(String.valueOf(nutritions.sugar()));
        carbs.setText(String.valueOf(nutritions.carbohydrates()));
        proteins.setText(String.valueOf(nutritions.protein()));

        try {
            ImageIcon imageIcon = new ImageIcon(new URL("https://picsum.photos/800/600"));
            picture.setIcon(imageIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
