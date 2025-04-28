package ok.utils;

import java.util.stream.Stream;

public class TestDataProvider {
    public static Stream<SearchQuery> provideSearchQueries() {
        return Stream.of(
                new SearchQuery("Иван Иванов", 10),
                new SearchQuery("Петр Петров", 5),
                new SearchQuery("Сергей Сергеев", 3));
    }

    public static Stream<String> provideMessages() {
        return Stream.of(
                "Hello, world!", "Тестовое сообщение", "Привет, как дела?");
    }
}

class SearchQuery {
    private final String query;
    private final int minResults;

    public SearchQuery(String query, int minResults) {
        this.query = query;
        this.minResults = minResults;
    }

    public String getQuery() {
        return query;
    }

    public int getMinResults() {
        return minResults;
    }
}