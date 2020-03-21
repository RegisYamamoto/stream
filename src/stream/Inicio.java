package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Inicio {

	public static void main(String[] args) throws IOException {
	
		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// forEach 1
		System.out.println("forEach 1");
		
		lista.stream()
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
	
		// -------------------------------------------------------------------------------------------------------------------------------------	
		
		
		// forEach 2
		System.out.println("forEach 2");
		
		lista.stream()
				.forEach(System.out::println);
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// skip
		System.out.println("skip");
		
		lista.stream()
				.skip(2)
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// limit
		System.out.println("limit");
		
		lista.stream()
				.limit(2)
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// distinct
		System.out.println("distinct");
		
		lista.stream()
				.distinct()
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// filter
		System.out.println("filter");
		
		lista.stream()
				.filter(e -> e % 2 == 0)
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// map 1
		System.out.println("map 1");
		
		lista.stream()
				.map(e -> e * 2) // A lista original não é modificada
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// map 2
		System.out.println("map 2");
				
		lista.stream()
				.map(e -> String.valueOf(e)) // A lista original não é modificada
				.forEach(e -> System.out.println(e));
				
		System.out.println("---");
				
				
		// -------------------------------------------------------------------------------------------------------------------------------------

				
		// range
		System.out.println("range");
		
		IntStream
				.range(1, 10)
				.forEach(e -> System.out.println(e));
		
		System.out.println("---");

		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// count
		System.out.println("count");
		
		long count = lista.stream()
						.count();
		System.out.println(count);
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// min
		System.out.println("min");
		
		Optional<Integer> min = lista.stream()
				.min(Comparator.naturalOrder());
		System.out.println(min.get());
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// max
		System.out.println("max");
		
		Optional<Integer> max = lista.stream()
				.max(Comparator.naturalOrder());
		System.out.println(max.get());
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// collect
		System.out.println("collect");
		
		List<Integer> novaLista = lista.stream()
				.filter(e -> e % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(novaLista);
		
		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// grounpingBy 1
		System.out.println("groupingBy 1");
		
		Map<Boolean, List<Integer>> mapa1 = lista.stream()
				.collect(Collectors.groupingBy(e -> e % 2 == 0));
		System.out.println(mapa1);

		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// grounpingBy 2
		System.out.println("groupingBy 2");
				
		Map<Integer, List<Integer>> mapa2 = lista.stream()
				.collect(Collectors.groupingBy(e -> e % 3));
		System.out.println(mapa2);

		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// grounpingBy 3
		System.out.println("groupingBy 3");
						
		String mapa3 = lista.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining());
		System.out.println(mapa3);

		System.out.println("---");
				
				
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// grounpingBy 4
		System.out.println("groupingBy 4");
								
		String mapa4 = lista.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(";"));
		System.out.println(mapa4);

		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// findFirst 1
		System.out.println("findFirst 1");
										
		Integer primeiroNumero1 = lista.stream()
				.findFirst().orElse(null);
		System.out.println(primeiroNumero1);

		System.out.println("---");
		
				
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		// findFirst 2
		System.out.println("findFirst 2");
										
		Integer primeiroNumero2 = lista.stream()
				.findFirst().orElse(10);
		System.out.println(primeiroNumero2);

		System.out.println("---");
		
		
		// -------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		
		
		
		

		// 3. Integer Stream com sum
		int numero = IntStream
						.range(1, 5)
						.sum();
		System.out.println(numero);
		System.out.println("---");

		// 4. Stream.of, sorted and findFirst
		Stream.of("Ana", "Aline", "Alberto")
				.sorted()
				.findFirst()
				.ifPresent(System.out::println);
		System.out.println("---");

		// 5. Stream from Array, sort, filter e print
		String[] nomes = { "Ana", "Aline", "Kelly", "Bianca", "Suzana", "amanda", "Hugo", "Silvia", "Santoro" };
		Arrays.stream(nomes) // o mesmo que Stream.of(nomes)
				.filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
		System.out.println("---");

		// 7. Stream de uma List, filter e print
		List<String> pessoas = Arrays.asList("Ana", "Aline", "Kelly", "Bianca", "Suzana", "amanda", "Hugo", "Silvia",
				"Santoro");
		pessoas.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
		System.out.println("---");

		// 8. Stream rows from text file, sort, filter, e print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
		bands.close();
		System.out.println("---");

		// 9. Stream rows de arquivo te texto e inserir para List
		List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("jit"))
				.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		System.out.println("---");

		// 10. Stream rows de arquivo CSV e count
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int) rows1.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(rowCount + " linhas.");
		rows1.close();
		System.out.println("---");

		// 11. Stream rows from CSV file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();
		System.out.println("---");

		// 12. Stream rows from CSV file, store fields in HashMap
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
		System.out.println("---");

		// 13. Reduction - sum
		double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> 1 + b);
		System.out.println("Total = " + total);

		// 14. Reduction - summary statistics
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
		System.out.println(summary);
		System.out.println("---");

	}

}