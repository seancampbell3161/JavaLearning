import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("MyText.txt");
        BufferedWriter bw = new BufferedWriter(fileWriter);

        String[] list = new String[] {"One", "Two", "Three", "Four"};

        String abc = "Hello this is a sentence that will hopefully be written into the text file.";

        for(String s : list) {
            bw.write(s + "\n");
        }
        bw.write(abc, 0, abc.length());
        bw.newLine();
        bw.write("Hello this is the second sentence that will hopefully be written into the text file", 0, 69);
        bw.close();

        File myFile = new File("MyText.txt");

        FileReader fileReader= new FileReader(myFile);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
