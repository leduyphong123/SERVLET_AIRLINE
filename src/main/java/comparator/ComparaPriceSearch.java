package comparator;

import dto.SearchFlight;

import java.util.Comparator;

public class ComparaPriceSearch implements Comparator<SearchFlight> {
    @Override
    public int compare(SearchFlight o1, SearchFlight o2) {
        return (int) (o1.getAirplaneChairPrice() - o2.getAirplaneChairPrice());
    }
}
