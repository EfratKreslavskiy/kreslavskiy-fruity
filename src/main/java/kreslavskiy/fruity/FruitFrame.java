package kreslavskiy.fruity;

import kreslavskiy.fruity.unsplash.UnsplashService;
import kreslavskiy.fruity.unsplash.UnsplashServiceFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FruitFrame extends JFrame
{
    private final JTextField searchbar;
    private final JLabel familyLabel;
    private final JLabel orderLabel;
    private final JLabel genusLabel;
    private final JLabel caloriesLabel;
    private final JLabel fatLabel;
    private final JLabel sugarLabel;
    private final JLabel carbsLabel;
    private final JLabel proteinLabel;


    public FruitFrame()
    {
        setSize(600, 800);
        setTitle("Fruity Vice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        searchbar = new JTextField("Strawberry");
        add(searchbar, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        JButton searchButton =  new JButton("Search");
        add(searchButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 9;
        constraints.gridwidth = 2;
        JLabel picture = new JLabel();
        add(picture, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        familyLabel = new JLabel("Family");
        add(familyLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        JLabel family = new JLabel();
        add(family, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        orderLabel = new JLabel("Order");
        add(orderLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 2;
        JLabel order = new JLabel();
        add(order, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        genusLabel = new JLabel("Genus");
        add(genusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 3;
        JLabel genus = new JLabel();
        add(genus, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        caloriesLabel = new JLabel("Calories");
        add(caloriesLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 4;
        JLabel calories = new JLabel();
        add(calories, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 5;
        fatLabel = new JLabel("Fat");
        add(fatLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 5;
        JLabel fat = new JLabel();
        add(fat, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        sugarLabel = new JLabel("Sugar");
        add(sugarLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 6;
        JLabel sugar = new JLabel();
        add(sugar, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        carbsLabel = new JLabel("Carbs");
        add(carbsLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 7;
        JLabel carbs = new JLabel();
        add(carbs, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        proteinLabel = new JLabel("Protein");
        add(proteinLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 8;
        JLabel protein = new JLabel();
        add(protein, constraints);

        UnsplashService service = new UnsplashServiceFactory().create();
        FruitController fruitController = new FruitController(service, picture, searchbar, family, order,
                                                                    genus, calories, fat, sugar, carbs, protein);

        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fruitController.doSearch();
            }
        });

    }

    static void main(String[] args)
    {
        FruitFrame frame = new FruitFrame();
        frame.setVisible(true);
    }
}
