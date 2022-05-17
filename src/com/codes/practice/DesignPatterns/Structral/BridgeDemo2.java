package com.codes.practice.DesignPatterns.Structral;

import java.util.ArrayList;
import java.util.List;

// decouple the functional abstraction from the implementation
// so that the two can vary independently
public class BridgeDemo2 {
        public static void main(String[] args) {
            // Bridget between JavaQuestions (implementing question interface) and
            //                 QuestionManager (coupled through question interface)
            // 1. create JavaQuestions object
            // 2. create QuestionManager object or QuestionFormat object
            // 3. Inject JavaQuestions object into QuestionManager object or QuestionFormat object
            // 4. manipulate JavaQuestions object through QuestionManager object
            //
            // 1.
            JavaQuestions iq = new JavaQuestions();
            // 2.
            QuestionFormat questions = new QuestionFormat("Java Programming Language");
            // 3.
            questions.setQuestion(iq);
            // 4.
            questions.displayAll();
            questions.delete("What is class? ");
            System.out.println("Item is deleted: What is class?\nCurrent item:");
            questions.display();

            questions.newOne("What is inheritance? ");
            System.out.println("item is added: What is inheritance? ");

            questions.newOne("How many types of inheritance are there in java?");
            System.out.println("item is added: How many types of inheritance are there in java? ");
            questions.displayAll();
        }
    }// End of the BridgePatternDemo class.

// this is the Question interface.
interface Question {
    public void nextQuestion();
    public void previousQuestion();
    public void newQuestion(String q);
    public void deleteQuestion(String q);
    public void displayQuestion();
    public void displayAllQuestions();
}
// End of the Question interface.

// Question interface Implementation
class JavaQuestions implements Question {
    private List<String> questions = new ArrayList<String>();
    private int current = 0;
    public JavaQuestions(){
        questions.add("What is class? ");
        questions.add("What is interface? ");
        questions.add("What is abstraction? ");
        questions.add("How multiple polymorphism is achieved in java? ");
        questions.add("How many types of exception  handling are there in java? ");
        questions.add("Define the keyword final for  variable, method, and class in java? ");
        questions.add("What is abstract class? ");
        questions.add("What is multi-threading? ");
    }
    public void nextQuestion() {
        if( current <= questions.size()-1 )
            current++;
        System.out.print(current);
    }

    public void previousQuestion() {
        if( current > 0 )
            current--;
    }

    public void newQuestion(String quest) {
        questions.add(quest);
    }

    public void deleteQuestion(String quest) {
        questions.remove(quest);
    }

    public void displayQuestion() {
        System.out.println( questions.get(current) );
    }
    public void displayAllQuestions() {
        for (String quest : questions) {
            System.out.println(quest);
        }
    }
}

// Following parts are separated from above question implementation
// and bridged through interface
class QuestionManager  {
    private Question q; //bridged through interface
    private String catalog;

    public QuestionManager(String catalog) {
        this.catalog=catalog;
    }

    public Question getQuestion() {
        return q;
    }

    public void setQuestion(Question q) {
        this.q = q;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void next() {
        q.nextQuestion();
    }
    public void previous() {
        q.previousQuestion();
    }
    public void newOne(String quest) {
        q.newQuestion(quest);
    }
    public void delete(String quest) {
        q.deleteQuestion(quest);
    }
    public void display() {
        q.displayQuestion();
    }
    public void displayAll() {
        System.out.println("Question Paper: " + catalog);
        q.displayAllQuestions();
    }
}

// this is the QuestionFormat class.
class QuestionFormat extends QuestionManager {
    public QuestionFormat(String catalog){
        super(catalog);
    }
    public void displayAll() {
        System.out.println("\n---------------------------------------------------------");
        super.displayAll();
        System.out.println("-----------------------------------------------------------");
    }
}