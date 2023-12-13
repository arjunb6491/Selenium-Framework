package Practice;

public class MethodoveringProgram {
	class Animal {
	    void makeSound() {
	        System.out.println("The animal makes a sound");
	    }
	}

	class Dog extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("The dog barks");
	    }
	}

	class Cat extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("The cat meows");
	    }
	}

	public class Main {
	    public void main(String[] args) {
	        Animal animal1 = new Dog();
	        Animal animal2 = new Cat();

	        animal1.makeSound(); // Calls the makeSound method in Dog
	        animal2.makeSound(); // Calls the makeSound method in Cat
	    }
	}


}
