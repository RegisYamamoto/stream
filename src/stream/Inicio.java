package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Inicio {

	public static void main(String[] args) throws IOException {
	
		// 1. Integer Stream
		IntStream
				.range(1, 10)
				.forEach(System.out::println);
		System.out.println("---");

		
		// 2. Integer Stream com skip
		IntStream
				.range(1,  10)
				.skip(5)
				.forEach(x -> System.out.println(x));
		System.out.println("---");
		
		
		// 3. Integer Stream com sum
		System.out.println(
				IntStream
				.range(1,  5)
				.sum());
		System.out.println("---");
		
		
		// 4. Stream.of, sorted and findFirst
		Stream.of("Ana", "Aline", "Alberto")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println("---");
		
		
		// 5. Stream from Array, sort, filter e print
		String[] nomes = {"Ana", "Aline", "Kelly", "Bianca", "Suzana", "amanda", "Hugo", "Silvia", "Santoro"};
		Arrays.stream(nomes) // o mesmo que Stream.of(nomes)
				.filter(x -> x.startsWith("S"))
				.sorted()
				.forEach(System.out::println);
		System.out.println("---");
		
		
		// 7. Stream de uma List, filter e print
		List<String> pessoas = Arrays.asList("Ana", "Aline", "Kelly", "Bianca", "Suzana", "amanda", "Hugo", "Silvia", "Santoro");
		pessoas
				.stream()
				.map(String::toLowerCase)
				.filter(x -> x.startsWith("a"))
				.forEach(System.out::println);
		System.out.println("---");
		
		
		// 8. Stream rows from text file, sort, filter, e print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands
				.sorted()
				.filter(x -> x.length() > 13)
				.forEach(System.out::println);
		bands.close();
		System.out.println("---");
		
		
		// 9. Stream rows de arquivo te texto e inserir para List
		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
				.filter(x -> x.contains("jit"))
				.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		System.out.println("---");
		
		
		// 10. Stream rows de arquivo CSV e count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int)rows1
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.count();
		System.out.println(rowCount + " linhas.");
		rows1.close();
		System.out.println("---");
		
		
		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();
		System.out.println("---");
		
		
		
		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3
				.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
					x -> x[0],
					x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
		System.out.println("---");
		
		
		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8)
				.reduce(0.0, (Double a, Double b) -> 1 +b);
		System.out.println("Total = " + total);
		
		
		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
				.summaryStatistics();
		System.out.println(summary);
		System.out.println("---");
		
	}

}