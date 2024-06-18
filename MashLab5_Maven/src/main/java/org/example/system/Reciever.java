package org.example.system;

import org.example.exceeption.NoElementException;
import org.example.exceeption.RootException;
import org.example.exceeption.WrongArgumentException;
import org.example.managers.*;
import org.example.recources.*;
import org.example.recources.comporators.PersonComporator;
import org.example.recources.generator.WorkerGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
/**
 * @author Mariia
 */

public class Reciever {
    private static Stack<File> st = new Stack<>();


    public static void addNewWorker() {
        Worker worker = WorkerGenerator.createWorker();
        CollectionManager.add(worker);
        System.out.println("Элемент добавлен в коллекцию");
    }

    public static void showWorkers() {
        ArrayList<Worker> workers = CollectionManager.getWorkers();
        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }

    public static void clearCollection() {
        CollectionManager.setWorkers(new ArrayList<Worker>());
        System.out.println("Коллекция очищена");
    }

    public static void updateById(String line) throws WrongArgumentException, NoElementException {
        Validator.checkId(line);
        Integer id = Integer.parseInt(line);
        Worker newWorker = WorkerGenerator.createWorker();
        for (Worker worker : CollectionManager.getWorkers()) {
            if (Objects.equals(worker.getId(), id)) {
                CollectionManager.remove(worker);
                newWorker.setId(id);
                CollectionManager.add(newWorker);
                System.out.println("Данные о работнике обновлены");
                return;
            }
        }
    }

    public static void showHelp() {
        for (String key : CommandManager.getCommandList().keySet()) {
            System.out.println(CommandManager.getCommandList().get(key).getName() + " - " + CommandManager.getCommandList().get(key).getDescription());
        }
    }

    public static void showInfo() {
        System.out.println("Data type - " + CollectionManager.getWorkers().getClass().getName());
        System.out.println("Count of person - " + CollectionManager.getWorkers().size());
    }

    public static void removeById(String line) throws WrongArgumentException, NoElementException {
        Validator.checkId(line);
        Integer id = Integer.parseInt(line);
        for (Worker worker : CollectionManager.getWorkers()) {
            if (Objects.equals(worker.getId(), id)) {
                CollectionManager.remove(worker);
                System.out.println("Данные о работнике удалены");
                return;
            }
        }
    }
    public static void maxByPerson(){
        PersonComporator comporator = new PersonComporator();
        ArrayList<Worker> list = CollectionManager.getWorkers();
        Collections.sort(list, (w1, w2) -> comporator.compare(w1.getPerson(), w2.getPerson()));
        System.out.println(list.get(list.size() - 1));
    }

    public static void filterContainsName(String line){

        for (Worker worker:CollectionManager.getWorkers()){
           if  (worker.getName().contains(line)){
               System.out.println(worker);
           }
        }
    }
    public static void insertWorker(String position,Worker worker) {
        try {
            int index = Integer.parseInt(position);
            ArrayList<Worker> list = CollectionManager.getWorkers();


            if (index > 0 && index < CollectionManager.getWorkers().size()) {
                ArrayList<Worker> newList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    if (i == index) {
                       if(worker == null) {
                           newList.add(WorkerGenerator.createWorker());
                       }else newList.add(worker);
                    }
                    newList.add(list.get(i));
                }
                CollectionManager.setWorkers(newList);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeAtIndex(String position) {
        try {
            int index = Integer.parseInt(position);
            ArrayList<Worker> list = CollectionManager.getWorkers();
            list.remove(index);
            CollectionManager.setWorkers(list);
            System.out.println("Объект удален");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void groupCountingByCoordinates() {
        HashMap<Double, ArrayList<Worker>> groupsByCoordinates = new HashMap();
        for (Worker worker : CollectionManager.getWorkers()) {
            double key = worker.getCoordinates().getX() + worker.getCoordinates().getY();
            if (groupsByCoordinates.containsKey(key)) {
                groupsByCoordinates.get(key).add(worker);
            } else {
                groupsByCoordinates.put(key, new ArrayList<Worker>());
                groupsByCoordinates.get(key).add(worker);
            }
        }
        int k = 0;
        for (Double key : groupsByCoordinates.keySet()) {
            k++;
            System.out.println("Группа №" + k);
            for (Worker worker : groupsByCoordinates.get(key)) {
                System.out.println(worker);
            }
        }

    }

    public static void executeScript(String path) throws Exception {
        File file = new File(path);
        if (!file.canRead()) {
            throw new RootException("You do not have enough rights to read the file");
        }
        /*if (st.isEmpty()) {
            st.add(file);
        }*/
        st.add(file);
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        String[] sp = new String[10];
        while ((line = br.readLine()) != null) {
            String id = null;
            String command = line.split(" ")[0];
            if (command.equals("add") || command.equals("update") || command.equals("insert_at")) {
                if (command.equals("update") || command.equals("insert_at")) id = line.split(" ")[1];
                for (int n = 0; n < 10; n++) {
                    if ((line = br.readLine()) != null) {
                        sp[n] = line;
                    }
                }
                Worker worker = new Worker();

                Validator.checkName(sp[0]);
                worker.setName(sp[0]);

                Coordinates coordinates = new Coordinates();
                Validator.checkXCoordinates(sp[1]);
                Validator.checkYCoordinates(sp[2]);
                if (sp[1].isEmpty()) {
                    coordinates.setY(Double.parseDouble(sp[1]));
                } else {
                    coordinates.setX(Float.parseFloat(sp[1]));
                    coordinates.setY(Double.parseDouble(sp[2]));
                }
                worker.setCoordinates(coordinates);

                Validator.checkSalary(sp[3]);
                worker.setSalary(Integer.parseInt(sp[3]));
                worker.setPosition(Position.valueOf(sp[4]));

                if (!sp[5].isEmpty()) {
                    worker.setStatus(Status.valueOf(sp[5]));
                }

                Person person = new Person();
                if (!sp[6].isEmpty()) {
                    Validator.checkPassportId(sp[6]);
                    person.setPassportID(sp[6]);
                }

                if (sp[7].isEmpty()) {
                    break;
                }
                person.setEyeColor(Color.valueOf(sp[7]));

                person.setHairColor(Color.valueOf(sp[8]));

                if (sp[9].isEmpty()) {
                    break;
                }
                person.setNationality(Country.valueOf(sp[9]));
                worker.setPerson(person);
                if (command.equals("update")) {
                    int count = CollectionManager.getWorkers().size();
                    Reciever.removeById(id);
                    if (count == CollectionManager.getWorkers().size()) {
                        System.out.println("Элемента с таким id не сущестует " + id);
                    } else {
                        CollectionManager.add(worker);
                        System.out.println("Элемент с id " + id + " был обновлен");
                    }
                } else if (command.equals("insert_at")){
                    Reciever.insertWorker(id, worker);
                }else
                    CollectionManager.add(worker);
            } else {
                if (line.contains("execute_script")) {
                    File file_new = new File(line.split(" ")[1]);
                    if (!file_new.canRead()) {
                        throw new RootException("You do not have enough rights to read the file");
                    }
                    if (st.contains(file_new)) {
                        System.out.println("Recursion to file " + file.getName() + " was skipped");
                    } else {
                        CommandManager.executeCommand(line);
                    }
                } else {
                    CommandManager.executeCommand(line);
                }
            }
        }
        st.pop();
    }

}
