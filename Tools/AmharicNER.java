import opennlp.tools.namefind.*;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import java.io.FileInputStream;
import java.io.InputStream;

public class AmharicNER {

    public static void main(String[] args) throws Exception {
        // Load tokenizer model
        InputStream tokenizerModelIn = new FileInputStream("path/to/tokenizer-model");
        TokenizerModel tokenizerModel = new TokenizerModel(tokenizerModelIn);

        // Load NER model
        InputStream nerModelIn = new FileInputStream("path/to/amharic-ner-model");
        TokenNameFinderModel nameFinderModel = new TokenNameFinderModel(nerModelIn);

        String amharicText = "አማርኛ ጽሑፍ ለ NER";

        // Tokenize text
        TokenizerME tokenizer = new TokenizerME(tokenizerModel);
        String[] tokens = tokenizer.tokenize(amharicText);

        // Find named entities
        NameFinderME nameFinder = new NameFinderME(nameFinderModel);
        Span[] nameSpans = nameFinder.find(tokens);

        // Print entities and their positions
        for (Span nameSpan : nameSpans) {
            String entity = "";
            for (int i = nameSpan.getStart(); i < nameSpan.getEnd(); i++) {
                entity += tokens[i] + " ";
            }
            System.out.println(entity + " : " + nameSpan);
        }
    }
}
