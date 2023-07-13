package Seminar05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneDirectory {

    private HashMap<String, List<String>> list;

    public TelephoneDirectory() {
        list = new HashMap<>();
    }

    public TelephoneDirectory(HashMap<String, List<String>> record) {
        list = new HashMap<>();
        list.putAll(record);
    }

    public HashMap<String, List<String>> getListAll() {
        return list;
    }

    public HashMap<String, List<String>> getRecord(String family) {
        HashMap<String, List<String>> record = new HashMap<>();
        record.put(family, list.get(family));
        return record;
    }

    public void add(String family, String phoneNumber) {
        if (list.containsKey(family)) {
            list.get(family).add(phoneNumber);
        } else {
            ArrayList<String> subList = new ArrayList<>();
            subList.add(phoneNumber);
            list.put(family, subList);
        }
    }

    public void print(String family) {
        StringBuilder stringBuilder = new StringBuilder(">> " + family + " : ");
        if (list.containsKey(family)) {
            ArrayList<String> phones = (ArrayList<String>) list.get(family);
            for (String item: phones) {
                stringBuilder
                        .append("\n\t\t")
                        .append(item);
            }
            stringBuilder.append("\n");
            System.out.println(stringBuilder);
        } else {
            System.out.printf("Запись с именем %s, не найдена", family);
        }
    }

    public void printAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String entry: list.keySet()) {

            stringBuilder.append(String.format(">> %s : ", entry));
            ArrayList<String> values = (ArrayList<String>) list.get(entry);
            for (String phoneNumber: values) {
                stringBuilder
                        .append("\n\t\t")
                        .append(phoneNumber);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
