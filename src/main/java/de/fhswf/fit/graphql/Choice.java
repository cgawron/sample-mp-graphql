package de.fhswf.fit.graphql;

import java.util.List;

import org.eclipse.microprofile.graphql.Enum;
import org.eclipse.microprofile.graphql.Description;

@Description("The choice of pizza of an order")
public class Choice {

    @Enum("Size")
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private Size size = Size.MEDIUM;
    private String choice;
    private List<String> extras;

    public Choice() {
        this.choice = "Margherita";
        this.extras = new java.util.ArrayList<>();
    }

    public String getChoice() {
        return this.choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<String> getExtras() {
        return this.extras;
    }

    public void setExtras(List<String> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "{" + " size='" + getSize() + "'" + ", choice='" + getChoice() + "'" + "}";
    }

}