package pl.qubiak.quotes.Api;

import org.springframework.web.bind.annotation.*;
import pl.qubiak.quotes.Model.Quotes;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotesApi {

    private List<Quotes> quotesList;

    public QuotesApi() {
        this.quotesList = new ArrayList<>();
        quotesList.add(new Quotes("Cywilizacja to w końcu tylko maska ogłady.", "Kevin Mitnick"));
        quotesList.add(new Quotes("Wcinam puste kalorie i oglądam filmy dla dorosłych! Spróbujcie mi zabronić!", "Kevin McCallister"));
        quotesList.add(new Quotes("James Bond ma licencję na zabijanie, a my na kłamanie. Tylko dla niepoznaki nazywamy ją dyplomem ukończenia studiów prawniczych.", "Joanna Chyłka"));
    }

    //AllUser
    @GetMapping("/api")
    public List<Quotes> getQuotesList() {
        return quotesList;
    }

    //Moderator
    @PostMapping("/api")
    public boolean addQuites(@RequestBody Quotes quotes) {
        return quotesList.add(quotes);
    }

    //Admin
    @DeleteMapping("/api")
    public void deleteQuites(@RequestParam("id") int id) {
        quotesList.remove(id);
    }

}
