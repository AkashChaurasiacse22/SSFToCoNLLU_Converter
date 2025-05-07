import in.co.sanchay.GlobalProperties;
import in.co.sanchay.corpus.ssf.SSFProperties;
import in.co.sanchay.corpus.ssf.SSFStory;
import in.co.sanchay.corpus.ssf.features.impl.FSProperties;
import in.co.sanchay.corpus.ssf.features.impl.FeatureStructuresImpl;
import in.co.sanchay.corpus.ssf.impl.SSFStoryImpl;
import in.co.sanchay.corpus.ssf.tree.SSFNode;

import java.io.FileNotFoundException;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//    }
//Akash Chaurasiya:

    public static void main(String[] args)
    {
        FSProperties fsp = new FSProperties();
        SSFProperties ssfp = new SSFProperties();

        SSFStory story = new SSFStoryImpl();
//        SSFText text = null;

        try {
            fsp.read(GlobalProperties.resolveRelativePath("props/fs-mandatory-attribs.txt"),
                    GlobalProperties.resolveRelativePath("props/fs-other-attribs.txt"),
                    GlobalProperties.resolveRelativePath("props/fs-props.txt"),
                    GlobalProperties.resolveRelativePath("props/ps-attribs.txt"),
                    GlobalProperties.resolveRelativePath("props/dep-attribs.txt"),
                    GlobalProperties.resolveRelativePath("props/sem-attribs.txt"),
                    GlobalProperties.getIntlString("UTF-8")); //throws java.io.FileNotFoundException;
            ssfp.read(GlobalProperties.resolveRelativePath("props/ssf-props.txt"), GlobalProperties.getIntlString("UTF-8")); //throws java.io.FileNotFoundException;
            FeatureStructuresImpl.setFSProperties(fsp);
            SSFNode.setSSFProperties(ssfp);
//            story.readFile("/extra/wmt12/training_set/target_system.spa.postaggedUS", "UTF-8"); //throws java.io.FileNotFoundException;
//            story.readFile("/extra/work/questimate/tmp/source.eng", "UTF-8"); //throws java.io.FileNotFoundException;
            story.readFile("fullnews_id_2568799_date_3_7_2004.dat", "UTF-8"); //throws java.io.FileNotFoundException;

            System.out.println("Sentences read: " + story.countSentences());

//            story.convertToPOSNolex();

            System.out.println(story.convertToPOSTagged("/"));

//            story.print(System.out);
//            story.readFile("/home/anil/docs/resources/CIIL-FORMALISED/Hindi/tagged-ciil-ssf-nlpai6.utf8/story_52_1c.final.mod.utf8"); //throws java.io.FileNotFoundException;
//            story.readFile("/home/anil/bhaash-debug-data/poslcat-single-fs.txt"); //throws java.io.FileNotFoundException;
//            story.readFile("/home/anil/myproj/bhaash/eclipse/Bhaashik/workspace/syn-annotation/delhi-tasks/story_14_1a.final.mod"); //throws java.io.FileNotFoundException;
//            story.print(System.out);
//            ((SSFStoryImpl) story).readXML("tmp/ssf-xml-sample.xml.xml", "UTF-8");
//            ((SSFStoryImpl) story).printXML(System.out);
//            ((SSFStoryImpl) story).saveXML("tmp/ssf-xml-sample.xml", "UTF-8");
//            ((SSFStoryImpl) story).reallocateSentenceIDs();
//	    story.save("/home/anil/tmp/Corpus1/story_26_1.final.txt", "UTF-8");
//           SSFStory.getSSFText("ABC-5.txt", 3, 4).print(System.out);

//	    SSFStoryImpl.clearAnnotationRecursive(
//		    new File("/home/anil/myproj/bhaash/eclipse/Bhaashik/workspace/syn-annotation/preeti-tmp"),
//		    GlobalProperties.getIntlString("UTF-8"),
//		    SSFCorpus.LEX_MANDATORY_ATTRIBUTES | SSFCorpus.CHUNK_MANDATORY_ATTRIBUTES
//	    );

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}