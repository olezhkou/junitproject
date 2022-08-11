import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitStreamApi {

	private List<Fruit> fruits = new ArrayList<>();

	public FruitStreamApi() {
		fruits.add(new Fruit(FruitName.APPLE,Color.RED, 100));
		fruits.add(new Fruit(FruitName.APPLE, Color.GREEN, 200));
		fruits.add(new Fruit(FruitName.PEAR,Color.RED, 100));
		fruits.add(new Fruit(FruitName.PEAR, Color.YELLOW, 100));
		fruits.add(new Fruit(FruitName.TOMATO, Color.YELLOW, 100));
	}

	public List<Fruit> getAllFruits() {
		return fruits;
	}

	public List<Fruit> findAllApples() {
		Stream<Fruit> fruitStream = fruits.stream();

		return fruits.stream()
				.filter(fruit -> FruitName.APPLE.equals(fruit.getTitle()))
				.collect(Collectors.toList());
	}

	public List<Fruit> findRedApplesWithWeightBiggerThen100() {
		return fruits.stream()
				.filter(fruit -> FruitName.APPLE.equals(fruit.getTitle()))
				.filter(fruit -> Color.RED.equals(fruit.getColor()))
				.filter(fruit -> fruit.getWeight() > 100)
				.collect(Collectors.toList());
	}

	public Set<FruitName> findAllFruitUniqNames() {
		return fruits.stream()
					 .map(fruit -> fruit.getTitle())
					 .collect(Collectors.toSet());
	}

	public List<FruitName> findAllFruitUniqueNames() {
		return fruits.stream()
				.map(Fruit::getTitle)
				//.map(fruit -> fruit.getTitle())
				.distinct()
				.collect(Collectors.toList());
	}

	public Optional<Fruit> findAnyApple() {
		return fruits.stream()
					 .filter(fruit -> FruitName.APPLE.equals(fruit.getTitle()))
					 .findAny();
	}

	public Optional<Fruit> findFirstApple() {
		return fruits.stream()
				.filter(fruit -> FruitName.APPLE.equals(fruit.getTitle()))
				.findFirst();
	}
}
