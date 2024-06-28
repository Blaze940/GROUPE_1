package fr.esgi.groupe1;

public class FakeFoods implements Foods {

    @Override
    public Food find() {
        return new Food(false, "Bissap");
    }
}
