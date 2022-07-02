public class Maxiser {
    public static Dog max(Dog[] dogs) {
        int maxDex = 0;
        for (int i =0;i<dogs.length;i++){
            int cmp = dogs[i].compareTo(dogs[maxDex]);
            if (cmp < 0) {
                maxDex = i;
            }
        }
        return dogs[maxDex];
    }
    
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Elyse", 3), new Dog("Sture", 9), new Dog("Benjamin", 15)};
        Dog maxDog = (Dog) max(dogs);
        maxDog.bark();
    }
}
