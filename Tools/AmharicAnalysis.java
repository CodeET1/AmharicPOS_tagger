import java.util.Properties;

import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class AmharicAnalysis {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("tokenize.model", "path/to/tokenize.model.gz");
        props.setProperty("segment.model", "path/to/segment.model.gz");
        props.setProperty("ner.model", "path/to/ner.model.gz"); // optional

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        String amharicText = "አማርኛ ጽሑፍ ለ POS መለያ";

        Annotation document = new Annotation(amharicText);
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            List<CoreMap> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            for (CoreMap token : tokens) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class); // optional

                System.out.println(word + " - POS: " + pos + " - NER: " + ner); // adjust output based on your needs
            }
        }
    }
}
