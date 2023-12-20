package utils;


import library.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class FileHandler {

    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    private String buildName(String fileName) {
        return path + "/" + fileName;
    }

    public void writeData(String data, String fileName) {
        try {
            FileWriter writer = new FileWriter(buildName(fileName), false);
            writer.write(data);
            writer.close();
        } catch (IOException ignored) {
        }
    }

    public void writeDataSerial(PostCodeDTO data, String fileName) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(buildName(fileName)))) {
            stream.writeObject(data);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public PostCodeDTO readDataSerial(String fileName) {
        PostCodeDTO data = null;
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(buildName(fileName)))) {
            data = (PostCodeDTO) stream.readObject();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void writeData(List<Token> dataMap, String fileName, List<Symbol>  dataList) {
        StringBuilder sb = new StringBuilder();
        dataMap.forEach(item -> {
            sb.append(item.out());
            if (item.getLexeme() == Lexeme.ID) {
                sb.append(" с именем ").append(dataList.get((Integer) item.getAttribute()));
            }
            sb.append("\n");
        });
        writeData(sb.toString(), fileName);
    }

    public void writeData(List<Symbol>  dataList, String fileName) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataList.size(); i++) {
            sb.append(i).append(" - ").append(dataList.get(i)).append("\n");
        }
        writeData(sb.toString(), fileName);
    }

    public void writeData(String fileName, List<CodeInstruction> instructionList) {
        StringJoiner sj = new StringJoiner("\n");
        instructionList.forEach(item -> sj.add(item.toString()));
        writeData(sj.toString(),fileName);
    }

    public void writeData(String fileName, ArrayList<BinaryTreeNode> instructionList) {
        StringBuilder sb = new StringBuilder();
        instructionList.forEach(sb::append);
        writeData(sb.toString(),fileName);
    }

    public String readData(String fileName) throws IOException {
        return Files.readString(Paths.get(buildName(fileName)));
    }
}
