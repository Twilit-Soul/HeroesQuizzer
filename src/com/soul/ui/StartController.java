package com.soul.ui;

import com.soul.Hero;
import com.soul.HeroMap;
import com.soul.HeroQuiz;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Optional;

/**
 * Controller for starting point of Quiz UI.
 * Created by Mitchell on 12/22/2015.
 */
public class StartController {
    public Label heroNameLabel;
    public TextField synergyField;
    public TextField counterField;
    public TextField strongMapField;
    public TextField weakMapField;
    public ListView<String> synergyAnswersListView;
    public ListView<String> counterAnswersListView;
    public ListView<String> strongMapsAnswersListView;
    public ListView<String> weakMapsAnswersListView;

    private HeroQuiz heroQuiz;

    @FXML
    protected void initialize() {
        heroQuiz = new HeroQuiz(); //init Hero Quiz
        heroNameLabel.setText(heroQuiz.getNewQuizHero().toString()); //init Hero Label
        synergyAnswersListView.getItems().clear(); //init ListViewCells
        synergyAnswersListView.setCellFactory(l -> new SynergyCell());
        counterAnswersListView.getItems().clear();
        counterAnswersListView.setCellFactory(l -> new CounterCell());
        strongMapsAnswersListView.getItems().clear();
        strongMapsAnswersListView.setCellFactory(l -> new StrongMapCell());
        weakMapsAnswersListView.getItems().clear();
        weakMapsAnswersListView.setCellFactory(l -> new WeakMapCell());
    }

    public void trySynergy() {
        tryAnswer(synergyField, synergyAnswersListView);
    }

    public void tryCounter() {
        tryAnswer(counterField, counterAnswersListView);
    }

    public void tryStrongMap() {
        tryAnswer(strongMapField, strongMapsAnswersListView);
    }

    public void tryWeakMap() {
        tryAnswer(weakMapField, weakMapsAnswersListView);
    }

    /**
     * Adds the answer currently in the text field to the list view, clears the text field.
     */
    private void tryAnswer(TextField textField, ListView<String> listView) {
        String synergy = textField.getText();
        textField.clear();
        ObservableList<String> items = listView.getItems();
        while (items.contains("")) items.remove("");
        items.add(0, synergy);
        while (items.size() < 6) items.add(0,""); //Filler to make items start at bottom
    }

    public class SynergyCell extends ListCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Optional<Hero> hero = Hero.getHeroByName(item);
                Text text = new Text(item);
                text.setFill((hero.isPresent() && heroQuiz.hasSynergy(hero.get())) ? Color.GREEN : Color.RED);
                setGraphic(text);
            }
        }
    }

    public class CounterCell extends ListCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Optional<Hero> hero = Hero.getHeroByName(item);
                Text text = new Text(item);
                text.setFill((hero.isPresent() && heroQuiz.hasCounter(hero.get())) ? Color.GREEN : Color.RED);
                setGraphic(text);
            }
        }
    }

    public class StrongMapCell extends ListCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Optional<HeroMap> heroMap = HeroMap.getHeroMapByName(item);
                Text text = new Text(item);
                text.setFill((heroMap.isPresent() && heroQuiz.hasStrongMap(heroMap.get())) ? Color.GREEN : Color.RED);
                setGraphic(text);
            }
        }
    }

    public class WeakMapCell extends ListCell<String> {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                Optional<HeroMap> heroMap = HeroMap.getHeroMapByName(item);
                Text text = new Text(item);
                text.setFill((heroMap.isPresent() && heroQuiz.hasWeakMap(heroMap.get())) ? Color.GREEN : Color.RED);
                setGraphic(text);
            }
        }
    }
}
