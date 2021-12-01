public class Pet {
    String name;
    String furColour;

    public Pet(String name, String furColour) {
        this.name = name;
        this.furColour = furColour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFurColour() {
        return furColour;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", furColour='" + furColour + '\'' +
                '}';
    }
}
